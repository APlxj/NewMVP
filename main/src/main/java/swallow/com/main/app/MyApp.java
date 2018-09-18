package swallow.com.main.app;

import com.mob.MobSDK;

import swallow.com.main.crash.RecoveryUtils;
import swallow.com.model_base.BaseApplication;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MyApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //recovery配置
        RecoveryUtils.init(this);
        //mob
        MobSDK.init(this, "27dcdad452385", "5d1ca47c252a59a3475d13c04a163016");
    }
}
