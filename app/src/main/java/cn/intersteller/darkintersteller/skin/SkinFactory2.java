package cn.intersteller.darkintersteller.skin;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.intersteller.darkintersteller.R;

public class SkinFactory2 implements android.view.LayoutInflater.Factory2 {
    //    到 AppCompatViewInflater类源码里面去搜索：view = createViewFromTag(context, name, attrs);
    private static final String[] sClassPrefixList = {
            "android.widget.",
            "android.view.",
            "android.webkit."
    };
    private static final Map<String, Constructor<? extends View>> sConstructorMap
            = new ArrayMap<>();
    private static final String TAG = SkinFactory2.class.getSimpleName();

    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = new Class<?>[]{
            Context.class, AttributeSet.class};

    private List<ViewWrapper> mCache_Can_Change_Views = new ArrayList<>();

    private class ViewWrapper {
        /*
        *    <ImageView
        android:id="@+id/test_imgeview_dwadwadwa"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_gravity="center"
        android:background="@color/clor_dwadwadawdaw"
        app:isSupport="true" />
        *
        *
        *
        * 对于xml中定义的单个view,
        * 每一行属性都封装成一个SkinItem,每个SkinItem存放属性值
        * 有多少需要换肤的属性就存在list<SkinItem>中
         */
        View view;

        List<SkinItem> skinItems = new ArrayList<>();

        public ViewWrapper(View view, List<SkinItem> skinItems) {
            /*
             *通过这个封装,就形成了每个view在xml中的对象
             */
            this.view = view;
            this.skinItems = skinItems;
        }

        /**
         * 真正的换肤操作
         */
        public void changeSkin() {
            for (SkinItem skinItem : skinItems) {
                if (skinItem.name.equals("background")) {
                    //background可以设置color和drawable或者mipmap
                    if (skinItem.type.equals("color")) {
                        view.setBackgroundColor(SkinManager.getInstance().getColor(skinItem.resId));
                    } else if (skinItem.type.equals("drawable") || skinItem.type.equals("mipmap")) {
                        view.setBackground(SkinManager.getInstance().getDrawable(skinItem.resId));
//                        view.setBackground(SkinManager.getInstance().getDrawable(skinItem.value));
                    }
                }
                if (skinItem.name.equals("textColor")) {
                    if (skinItem.type.equals("color")) {
                        ((TextView) view).setTextColor(SkinManager.getInstance().getColor(skinItem.resId));
                    }
                }

                if (skinItem.name.equals("src")) {
                    //后续再增加

                }
            }
        }
    }


    public void changeSkin() {
        for (ViewWrapper viewWrapper : mCache_Can_Change_Views) {
            viewWrapper.changeSkin();
        }
    }


    private class SkinItem {
        /*
         *android:background="@color/clor_dwadwadawdaw"的background
         */
        private String name;


        /*
         *android:background="@color/clor_dwadwadawdaw"中的color
         */
        private String type;


        /*
         *android:background="@color/clor_dwadwadawdaw"中的@color/clor_dwadwadawdaw
         */
        private String value;


        /*
         *android:background="@color/clor_dwadwadawdaw"中的@color/clor_dwadwadawdaw在R文件中的值
         比如:int color clor_dwadwadawdaw 0x7f06002f
         */
        private int resId;

        public SkinItem(String name, String type, String value, int resId) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.resId = resId;
        }


        public SkinItem(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }


    void collectViewNeedsChange(Context context, AttributeSet attrs, View view) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Skinable);
        boolean issupport = typedArray.getBoolean(R.styleable.Skinable_isSupport, false);
        if (issupport) {
            /*判断每个传进来的view是否有app:isSupport="true"
                    <ImageView
                        android:id="@+id/test_imgeview_dwadwadwa"
                        android:layout_width="100dp"
                        android:layout_height="100dp"
                        android:layout_gravity="center"
                        android:background="@color/clor_dwadwadawdaw"
                    />
             */
            int attributeCount = attrs.getAttributeCount();
            //遍历每个传进来的单个view的所有属性
            List<SkinItem> skinItems = new ArrayList<>();
            for (int i = 0; i < attributeCount; i++) {
                    /*
                     *    <TextView
                            android:textColor="@color/red"
                            android:id="@+id/textview1"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:background="@color/blue"
                            android:text="textview1"
                            android:textSize="30sp"
                            app:isSupport="true" />
                     *
                     *
                     *
                     * 对于这个TextView, 遍历的得到
                     * textColor, 2131623940
                     * background, 2131099680
                     */
                String attributeName = attrs.getAttributeName(i);
                //换肤的话,我们暂时只换textColor/background,所以只取textColor/background

                if (attributeName.contains("textColor") || attributeName.contains("background")) {
                    String attributeValue = attrs.getAttributeValue(i);
                    Log.i(TAG, "foriput: " +attributeValue);
                    int resId = Integer.parseInt(attributeValue.substring(1));//去掉@
                    String resourceTypeName = view.getResources().getResourceTypeName(resId);
                    String resourceEntryName = view.getResources().getResourceEntryName(resId);
                    Log.i(TAG, "foriput: " + attributeName + ", " + resourceTypeName + ", " + resourceEntryName + ", " + resId);
                    SkinItem skinItem = new SkinItem(attributeName, resourceTypeName, resourceEntryName, resId);
                    skinItems.add(skinItem);
                }
            }
            int size = skinItems.size();
            Log.e(TAG, "view中可以有可以换肤的属性有 " + size + "个");
            if (size > 0) {
                //每来一个view,就把这个view封装为一个view绑定要换的属性
                ViewWrapper viewWrapper = new ViewWrapper(view, skinItems);
                //把每个来的view都保存,他们都需要换肤
                mCache_Can_Change_Views.add(viewWrapper);
            }

        }
        typedArray.recycle();

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View view;
        Log.i("SkinFactory2.onCreateView()","name  =" +name);
        view = createViewFromTag(context, name, attrs);
        collectViewNeedsChange(context, attrs, view);
        return view;

//        View view = null;
//        if (name.contains(".")) {
//            //带包名的控件
//            view = onCreateView(name, context, attrs);
//        } else {
//            for (String s : sClassPrefixList) {
//                String viewname = name + s;
//                view = onCreateView(viewname, context, attrs);
//                if (view != null) {
//                    break;
//                }
//            }
//        }
//
//        //收集需要换肤的,并且把需要换肤的控件实例化并且返回出去
//        if (view != null) {
//            collectViewNeedsChange(context, attrs, view);
//        }
//        return view;
    }

    /**
     * 这个方法其实就是给我们来反射构造的,可以把反射的放在这里,换成调用这个onCreateView方法
     * @param name
     * @param context
     * @param attrs
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return null;
//        View view = null;
//        try {
//            Class<?> aClass = context.getClassLoader().loadClass(name);
//            Constructor<? extends View> constructor =
//                    (Constructor<? extends View>) aClass.getConstructor(Context.class, AttributeSet.class);
//            view = constructor.newInstance(context, attrs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return view;
    }


    /**
     * @param context 上下文
     * @param name view的名字(自定义view是全限定类名, 系统view只是类名比如TextView)
     * @param prefix 用来给系统view添加前缀,自定义view时,prefix为null
     *               系统view时, 要从sClassPrefixList里面取
     * @return
     * @throws InflateException
     */
    private View createViewByPrefix(Context context, String name, String prefix)
            throws InflateException {
        Constructor<? extends View> constructor = sConstructorMap.get(name);

        try {
            if (constructor == null) {
                // Class not found in the cache, see if it's real, and try to add it
                Class<? extends View> clazz = Class.forName(
                        prefix != null ? (prefix + name) : name,
                        false,
                        context.getClassLoader()).asSubclass(View.class);

                constructor = clazz.getConstructor(sConstructorSignature);
                sConstructorMap.put(name, constructor);
            }
            constructor.setAccessible(true);
            return constructor.newInstance(mConstructorArgs);
        } catch (Exception e) {
            // We do not want to catch these, lets return null and let the actual LayoutInflater
            // try
            return null;
        }
    }

    private View createViewFromTag(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }

        try {
            mConstructorArgs[0] = context;
            mConstructorArgs[1] = attrs;
            Log.i("dengview", "name1 = "+name);

            if (-1 == name.indexOf('.')) {
                //比如传进来的是LinearLayout/ViewStub/FrameLayout等等
                for (int i = 0; i < sClassPrefixList.length; i++) {
                    final View view = createViewByPrefix(context, name, sClassPrefixList[i]);
                    if (name.equals("ImageView")){
                        Log.i("dengview", "name2 = "+name);
                        Log.i("dengview", "view = "+view.toString());
                    }
                    if (view != null) {
                        return view;
                    }
                }
                return null;
            } else {
                //自定义view或者系统有些特殊的控件
                // 比如androidx.appcompat.widget.FitWindowsLinearLayout
                //这种view都是存在全限定类名的,可以直接用反射
                //不过这时候是反射的两个参数的构造
                return createViewByPrefix(context, name, null);
            }
        } catch (Exception e) {
            // We do not want to catch these, lets return null and let the actual LayoutInflater
            // try
            return null;
        } finally {
            // Don't retain references on context.
            mConstructorArgs[0] = null;
            mConstructorArgs[1] = null;
        }
    }

//    /**
//     * 给外部提供一个set方法
//     *
//     * @param mDelegate
//     */
//    public void setDelegate(AppCompatDelegate mDelegate) {
//        this.mDelegate = mDelegate;
//    }
//
//    private AppCompatDelegate mDelegate;//预定义一个委托类，它负责按照系统的原有逻辑来创建view

}
