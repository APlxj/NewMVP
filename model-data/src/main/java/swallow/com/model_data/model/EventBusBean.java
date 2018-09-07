package swallow.com.model_data.model;

/**
 * @Created by TOME .
 * @时间 2018/5/17 16:47
 * @描述 ${EventBus 事件类型}
 */

public class EventBusBean extends BaseEventbusBean<Object> {

    public EventBusBean(int type, Object obj) {
        super(type, obj);
    }

    //侧滑菜单
    public static final int SHOP_MALL_HOME = 10001;

    //登录
    public static final int TOLOGIN = 10002;

    //登录账号
    public static final int LOGINNUM = 10003;

}
