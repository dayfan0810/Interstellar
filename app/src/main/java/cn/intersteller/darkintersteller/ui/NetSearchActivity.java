package cn.intersteller.darkintersteller.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.bean.SearchSuggestBean;
import cn.intersteller.darkintersteller.innerfragment.search.SearchHotWordFragment;
import cn.intersteller.darkintersteller.innerfragment.search.SearchTabPagerFragment;
import cn.intersteller.darkintersteller.innerfragment.search.SearchWords;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import cn.intersteller.darkintersteller.utils.ScreenUtils;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NetSearchActivity extends AppCompatActivity implements View.OnTouchListener, View.OnFocusChangeListener, SearchWords {

    private ArrayList<SearchSuggestBean.ResultBean.AllMatchBean> mAllMatchBeans = new ArrayList<>();
    private SearchView mSearchView;
    private ArrayList<String> list_string;
    private AutoCompleteTextView mAutoCompleteTextView;
    private SearchTabPagerFragment searchTabPagerFragment;
    private Button mFloatingButton;
    private WindowManager mWindowManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_search_111111111);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SearchHotWordFragment f = new SearchHotWordFragment();
        f.searchWords(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.search_frame, f);
        ft.commit();

        if (ScreenUtils.commonROMPermissionCheck(NetSearchActivity.this)) {
            showFloat();
        } else {
            requestAlertWindowPermission();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        Resources resources = getResources();
        final MenuItem item = menu.findItem(R.id.menu_main_search_view);
        mSearchView = (SearchView) item.getActionView();
        mSearchView.onActionViewExpanded();
        mSearchView.setQueryHint(getString(R.string.search_tips));
        mSearchView.setIconifiedByDefault(false);

//        mSearchView.setSubmitButtonEnabled(true);
        try {
            Field field = mSearchView.getClass().getDeclaredField("mGoButton");
            field.setAccessible(true);
            ImageView mGoButton = (ImageView) field.get(mSearchView);
            assert mGoButton != null;
            mGoButton.setImageResource(R.drawable.actionbar_search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String searchWord_hot = SharedPreferenceUtils.getPrefString("searchWord_hot", "");
        Log.i("dengsearchWord_hot", searchWord_hot);
        final String[] resultArray = searchWord_hot.substring(1, searchWord_hot.length() - 1).split(", ");

        int completeTextId = mSearchView.getResources().getIdentifier("android:id/search_src_text", null, null);
        mAutoCompleteTextView = (AutoCompleteTextView) mSearchView
                .findViewById(completeTextId);
        mAutoCompleteTextView.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, R.id.text, resultArray));
        mAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSearchView.setQuery(resultArray[position], true);
            }
        });

        mAutoCompleteTextView.setThreshold(0);


        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchTabPagerFragment = new SearchTabPagerFragment(query);
                Log.i("searchsearch----NetSearchActivity", query);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.search_frame, searchTabPagerFragment);
                fragmentTransaction.commitAllowingStateLoss();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    Toast.makeText(getApplicationContext(), "无关键字", Toast.LENGTH_SHORT).show();
                    return false;
                }
                searchAll(newText);

                return false;
            }
        });


        return true;
    }


    private void requestAlertWindowPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 42);
    }


    @Override
    //处理回调
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 42) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    showFloat();
                } else {
                    Toast.makeText(NetSearchActivity.this, "没有悬浮窗权限", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mWindowManager == null){
            return;
        }
        mWindowManager.removeView(mFloatingButton);
    }

    private void showFloat() {
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mFloatingButton = new Button(this);
        mFloatingButton.setText("悬浮窗//TODO");

        WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0,
                PixelFormat.TRANSPARENT);
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.x = 400;
        mLayoutParams.y = 800;
//        mFloatingButton.setOnTouchListener(this);
        mWindowManager.addView(mFloatingButton, mLayoutParams);

        mFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + getPackageName()));
                intent.putExtra("cmp", "com.android.settings/.applications.InstalledAppDetails");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


    private void searchAll(String keyword) {
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_SEARCH_SUGGEST + keyword + "&type=mobile", new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i("dengsearc3", Constant.NETEASE_SEARCH_SUGGEST + keyword + "&type=mobile");
                mAllMatchBeans.clear();
                final String responseText = response.body().string();
                try {
                    JSONObject jsonObject = null;
                    jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (!resultCode.equals("200")) {
                        Looper.prepare();
                        Toast.makeText(getApplicationContext(), "code:200", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                        return;
                    }

                    JSONObject result = jsonObject.getJSONObject("result");
                    JSONArray allMatch = result.optJSONArray("allMatch");
                    if (allMatch == null) {
                        runOnUiThread(() -> {
//                            LinearLayoutManager manager = new LinearLayoutManager(mContext);
//                            mReclclerView.setLayoutManager(manager);
//                            searchSuggestRecyclerViewAdapter = new SearchSuggestRecyclerViewAdapter(mContext, mAllMatchBeans, mReclclerView, manager);
//                            mReclclerView.setAdapter(searchSuggestRecyclerViewAdapter);
//                            Looper.prepare();
//                            Toast.makeText(getApplicationContext(), "没有搜到", Toast.LENGTH_SHORT).show();
//                            Looper.loop();
                        });

                        return;
                    }
                    list_string = new ArrayList<String>();
                    for (int i = 0; i < allMatch.length(); i++) {
                        JSONObject allMatchItem = (JSONObject) allMatch.get(i);
                        String keyword_suggest = allMatchItem.optString("keyword");
                        SearchSuggestBean.ResultBean.AllMatchBean allMatchBean = new SearchSuggestBean.ResultBean.AllMatchBean();
                        allMatchBean.setKeyword(keyword_suggest);
                        mAllMatchBeans.add(allMatchBean);
                        list_string.add(keyword_suggest);
                    }
                    runOnUiThread(() -> {
                        String[] array = list_string.toArray(new String[0]);
                        mAutoCompleteTextView.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.list_item, R.id.text, array));
                        mAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                mSearchView.setQuery(array[position], true);
                                searchTabPagerFragment = new SearchTabPagerFragment(array[position]);
                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.add(R.id.search_frame, searchTabPagerFragment);
                                fragmentTransaction.commit();
                            }
                        });
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            mAutoCompleteTextView.showDropDown();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }


    public interface NetSearchCallBack {
        void onActivityQuery(String searchAll);
    }

    NetSearchCallBack mNetSearchCallBack;

    public void setmNetSearchCallBack(NetSearchCallBack mNetSearchCallBack) {
        this.mNetSearchCallBack = mNetSearchCallBack;
    }

    @Override
    public void onSearch(String t) {
        mSearchView.setQuery(t, true);
    }
}
