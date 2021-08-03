package cn.intersteller.darkintersteller.utils;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.intersteller.darkintersteller.MyApplication;
import cn.intersteller.darkintersteller.bean.SongPlayUrlBean;
import cn.intersteller.darkintersteller.net.PersistentCookieStore;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    private static final String TAG = "HttpUtil";
    static volatile HttpUtil defaultInstance;
    private static OkHttpClient mOkHttpClient;


    private HttpUtil() {

        final PersistentCookieStore cookieStore = new PersistentCookieStore();

        //创建cookieJar 用来保存登录的状态
        CookieJar cookieJar = new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                if (cookies != null && cookies.size() > 0) {
                    for (Cookie item : cookies) {
                        cookieStore.add(url, item);
                    }
                }
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                Log.i("deng2", "hahahahaah222222 url.host() " + url.host());
                List<Cookie> cookies = cookieStore.get(url);
                return cookies;
            }
        };
        //通过newBuilder设置cookjar并构建OkHttpClient对象
        mOkHttpClient = new OkHttpClient()
                .newBuilder()
                .cookieJar(cookieJar)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static HttpUtil getHttpUtilInstance() {
        if (defaultInstance == null) {
            synchronized (HttpUtil.class) {
                if (defaultInstance == null) {
                    defaultInstance = new HttpUtil();
                }
            }
        }
        return defaultInstance;
    }

    public void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        Log.i("dengall-address", "address = " + address);
        Request request = new Request.Builder().url(address).build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }


    /**
     * 后面考虑使用这个,而不是上面那个,因为这个可以直接把东西传出去
     *
     * @param action1
     * @return
     */
    public static JsonObject getResposeJsonObject(String action1) {
        Log.i("dengall-address", "address = " + action1);
        try {
            Request request = new Request.Builder()
                    .url(action1)
//                    .addHeader("Referer","http://music.163.com/")
//                    .addHeader("Cookie", "appver=1.5.0.75771")
                    .build();
            Response response = mOkHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                //response.body（）只调用一次。第二次就关闭了
                String c = response.body().string();
                JsonElement jsonElement = JsonParser.parseString(c);
                return jsonElement.getAsJsonObject();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    此方法是传入歌曲的ID,然后利用GSON解析
     */
    public static String getPlayUrl(String song_id) {
        JsonObject song_play_url_by_id_obj = HttpUtil.getResposeJsonObject(Constant.NETEASE_SONG_PLAY_URL_BY_ID + song_id);
        JsonArray data = song_play_url_by_id_obj.get("data").getAsJsonArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (JsonElement song : data) {
            //这里写循环来获取url的原因是:
            //JSON数据中的array只有一项,这个API应该不会更改
            SongPlayUrlBean.DataBean dataBean = MyApplication.gsonInstance().fromJson(song, SongPlayUrlBean.DataBean.class);
            stringBuilder.append(dataBean.getUrl());
        }
        return stringBuilder.toString();
    }


    public static Request makeCnbetaRequest(int page) {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("type", "all");
        params.put("page", page + "");
        params.put("_", System.currentTimeMillis() + "");
        headers.put("Referer", "http://www.cnbeta.com/");
        headers.put("Origin", "http://www.cnbeta.com");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.10 Safari/537.36");
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constant.CNBETA_NEWS_LIST_URL).newBuilder();

        for (String key : params.keySet()) {
            urlBuilder.setQueryParameter(key, params.get(key));
        }
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .headers(headers == null ? new Headers.Builder().build() : Headers.of(headers))
                .get()
                .build();
        return request;
    }


    public static Request makeJin10Request() {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
//        params.put("type", "all");
//        params.put("_", System.currentTimeMillis() + "");
        headers.put("Referer", Constant.JIN10_BASE_URL);
        headers.put("Origin", Constant.JIN10_BASE_URL);
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.10 Safari/537.36");
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constant.JIN10_BASE_URL).newBuilder();

        for (String key : params.keySet()) {
            urlBuilder.setQueryParameter(key, params.get(key));
        }
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .headers(headers == null ? new Headers.Builder().build() : Headers.of(headers))
                .get()
                .build();
        return request;
    }

}
