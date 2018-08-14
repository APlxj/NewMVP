package swallow.com.model_base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;

import swallow.com.model_base.arouter.RouterConfig;
import swallow.com.model_utils.JRTTDensityUtils;
import swallow.com.model_utils.L;
import swallow.com.model_utils.Utils;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class BaseApplication extends Application {

    private static BaseApplication mBaseApplication;
    //Activity管理
    private ActivityControl mActivityControl;
    public static boolean IS_DEBUG = BuildConfig.DEBUG;

    //SmartRefreshLayout 有三种方式,请参考:https://github.com/scwang90/SmartRefreshLayout
    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            //全局设置主题颜色
            layout.setPrimaryColorsId(android.R.color.darker_gray, android.R.color.white);
            //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));
            //指定为经典Header，默认是 贝塞尔雷达Header
            return new BezierRadarHeader(context);
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            return new ClassicsFooter(context).setDrawableSize(20);
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mActivityControl = new ActivityControl();
        //arouter路由初始化
        RouterConfig.init(this, IS_DEBUG);
        //热修复初始化
        //initBugly();
        //适配初始化
        JRTTDensityUtils.setDensity(this, 375);
        //Stetho调试工具初始化
        Stetho.initializeWithDefaults(this);
        // 初始化Logger工具
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return IS_DEBUG;
            }
        });
        //初始化Log
        L.init(IS_DEBUG);
        L.i("当前是否为debug模式：" + IS_DEBUG);
        Utils.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mBaseApplication = this;
        //MultiDex分包方法 必须最先初始化
        MultiDex.install(this);
    }

    public static BaseApplication getAppContext() {
        return mBaseApplication;
    }

    public ActivityControl getActivityControl() {
        return mActivityControl;
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        exitApp();
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        mActivityControl.finishiAll();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * 程序在内存清理的时候执行
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
