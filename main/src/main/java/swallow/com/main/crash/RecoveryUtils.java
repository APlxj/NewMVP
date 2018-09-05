package swallow.com.main.crash;

import android.content.Context;

import com.zxy.recovery.core.Recovery;

import swallow.com.main.view.MainActivity;
import swallow.com.main.view.WebActivity;
import swallow.com.model_base.crash.MyCrashCallback;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class RecoveryUtils {

    //recovery配置
    public static void init(Context context) {
        //Crash File Path: {SDCard Dir}/Android/data/{packageName}/files/recovery_crash/
        Recovery.getInstance()
                .debug(true)//是否开启debug模式
                .recoverInBackground(false)//当应用在后台时发生Crash，是否需要进行恢复
                .recoverStack(true)//是否恢复整个Activity Stack，否则将恢复栈顶Activity
                .mainPage(MainActivity.class)//回退的界面
                .recoverEnabled(true)
                .callback(new MyCrashCallback())//发生Crash时的回调
                //是否使用静默恢复，
                //如果设置为true的情况下，那么在发生Crash时将不显示RecoveryActivity界面来进行恢复，
                //而是自动的恢复Activity的堆栈和数据，也就是无界面恢复
                //SilentMode
                //RESTART - 重启应用
                //RECOVER_ACTIVITY_STACK - 恢复Activity堆栈
                //RECOVER_TOP_ACTIVITY - 恢复栈顶Activity
                //RESTART_AND_CLEAR - 重启应用并清空缓存数据
                .silent(false, Recovery.SilentMode.RECOVER_ACTIVITY_STACK)
                //.skip(WebActivity.class)
                .init(context);
    }
}
