package swallow.com.main.model;

import java.util.List;

import swallow.com.main.app.MyApp;
import swallow.com.main.contract.ILoginContract;
import swallow.com.model_base.BaseModel;
import swallow.com.model_data.model.User;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:32
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginModel
        extends BaseModel
        implements ILoginContract.Model {

    @Override
    public User queryLoginMsg(String phone, String psw) {
        List<User> users = MyApp
                .getAppContext()
                .getDaoSession()
                .getUserDao()
                .queryRaw("Where Mobile = ? AND Password = ? ", phone, psw);
        if (null != users && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}

