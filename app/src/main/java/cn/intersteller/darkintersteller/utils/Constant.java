package cn.intersteller.darkintersteller.utils;

import cn.intersteller.darkintersteller.MyApplication;

public class Constant {
    //sharedPreference
    public static final String LOGIN_USER_ID = "login_user_id";
    //新闻头条
    //http://v.juhe.cn/toutiao/index?type=top&key=APPKEY
    public static final String URL_TOPNEWS = "http://v.juhe.cn/toutiao/index?type=top&key=9c98897f8c0ef2f97ce13ef48f0c6cc1";
    public static final String CLOUDPAN_DATABASE_NAME = "interstellar.db";
    public static final String CLOUDPAN_DATABASE_TABLE_NAME = "cloudpan";
    public static final int CLOUDPAN_DATABASE_VERSION = 1;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static boolean isWifi = NetworkUtils.isConnectWifi(MyApplication.getInstance());
    //网易云音乐接口
//    public static final String NETEASEBASE = "http://musicapi.leanapp.cn/";
//    public static final String NETEASEBASE = isWifi ? "http://42.192.43.247:3000/" : "http://39.108.131.225:3000/";
    public static final String NETEASEBASE = "http://1.15.151.241:3000/";


    //mv 排行
    public static final String NETEASE_TOP_MV = NETEASEBASE + "top/mv?limit=99";
    //MV详情,根据Item的Id
    public static final String NETEASE_MV_ID = "mv?mvid=";
    //比上个要精简,就是MV的视频信息
    public static final String NETEASE_MV_VIDEO = NETEASEBASE + "mv/url?id=";

    //banner
    public static final String NETEASE_BANNER = NETEASEBASE + "banner";
    //推荐 mv
    public static final String NETEASE_PERSONALIZED = NETEASEBASE + "/personalized/mv";
    //邮箱登录:/login?email=xxx@163.com&password=yyy
    public static final String NETEASE_LOGIN = NETEASEBASE + "login?email=xxx@163.com&password=yyy";
    //云盘
    public static final String NETEASE_CLOUD_PAN = NETEASEBASE + "user/cloud?limit=500";
    //1我的歌单
    public static final String NETEASE_MYPLAYLIST = NETEASEBASE + "user/playlist?uid=";
    //2通过NETEASE_MYPLAYLIST拿到每个歌单的id
    public static final String NETEASE_MYPLAYLIST_DETAIL = NETEASEBASE + "playlist/detail?id=";
    //3.通过上面的NETEASE_MYPLAYLIST_DETAIL拿到每个歌单里面的song的trackid,
    // 然后再调用NETEASE_MYPLAYLIST_DETAIL_SONG_DETAIL
    //获取
    public static final String NETEASE_MYPLAYLIST_DETAIL_SONG_DETAIL = NETEASEBASE + "song/detail?ids=";

    //搜索建议http://1.15.151.241:3000/search/suggest?keywords=林俊杰
    public static final String NETEASE_SEARCH_SUGGEST = NETEASEBASE + "search/suggest?keywords=";
    //搜索视频  http://1.15.151.241:3000/search?keywords=林俊杰&type=1014
    public static final String NETEASE_SEARCH = NETEASEBASE + "search?keywords=";
    public static final String NETEASE_HOT_SEARCH_DETAIL = NETEASEBASE + "search/hot/detail";
    public static final String NETEASE_SONG_PLAY_URL_BY_ID = NETEASEBASE + "song/url?id=";


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //哔哩哔哩
    public static final String BILIBILI_BASE_URL = "http://app.bilibili.com/";

    /**
     * 首页推荐数据
     */
    public static final String BILIBILI_RECOMMEND = BILIBILI_BASE_URL + "x/show/old?platform=android&device=&build=412001";

    /**
     * 首页推荐banner
     */
    public static final String BILIBILI_BANNER = BILIBILI_BASE_URL + "x/banner?plat=4&build=411007&channel=bilih5";


    /*
     * Cnbeta
     */
    public static final String CNBEA_BASE_URL = "https://www.cnbeta.com";
    public static final String CNBETA_NEWS_LIST_URL = CNBEA_BASE_URL + "/home/more";

    /*
    jin10
     */
    public static final String JIN10_BASE_URL = "https://www.jin10.com/";

    /*
    美港电讯
     */
    public static final String USHKNEWS_BASE_URL = "http://www.ushknews.com/";



    /**
     * Music Player Action Command
     */
    public static final String ACTION_PLAY = "cn.interstellar.ACTION_PLAY";
    public static final String ACTION_PAUSE = "cn.interstellar.ACTION_PAUSE";
    public static final String ACTION_STATUS = "cn.interstellar.ACTION_STATUS"; //is playing or not
    public static final String ACTION_PREVIOUS = "cn.interstellar.ACTION_PREVIOUS";
    public static final String ACTION_NEXT = "cn.interstellar.ACTION_NEXT";
    public static final String ACTION_STOP = "cn.interstellar.ACTION_STOP";
    public static final String ACTION_DOWNLOAD = "cn.interstellar.ACTION_DOWNLOAD";
    public static final String ACTION_UPDATE_NOTIFICATION = "cn.interstellar.ACTION_UPDATE_NOTIFICATION";

}
