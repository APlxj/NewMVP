package swallow.com.model_net.constant;

/**
 * @Created by TOME .
 * @时间 2018/5/15 17:35
 * @描述 ${TODO}
 */

public class BaseHost {

    public static final String NETEAST_HOST = "http://c.m.163.com/";

    //干货集中营 API
    public static final String SINA_PHOTO_HOST = "http://gank.io/api/";

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.NETEASE_NEWS_VIDEO:
                host = "http://www.wanandroid.com/";
                break;
            case HostType.GANK_GIRL_PHOTO:
                host = SINA_PHOTO_HOST;
                break;
            case HostType.NEWS_DETAIL_HTML_PHOTO:
                host = "http://kaku.com/";
                break;
            case HostType.JS_NEWS:
                host = "http://open.iciba.com/dsapi/";
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
