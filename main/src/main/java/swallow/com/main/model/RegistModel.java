package swallow.com.main.model;

import java.util.List;

import swallow.com.main.app.MyApp;
import swallow.com.main.contract.IRegistContract;
import swallow.com.model_base.BaseModel;
import swallow.com.model_data.model.User;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:25
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegistModel
        extends BaseModel
        implements IRegistContract.Model {

    @Override
    public boolean saveMsg(User user) {
        return MyApp
                .getAppContext()
                .getDaoSession()
                .getUserDao()
                .insertOrReplace(user) > 0;
    }

    @Override
    public List<User> queryByIDCardNO(String idCardNO) {
        return MyApp
                .getAppContext()
                .getDaoSession()
                .getUserDao()
                .queryRaw("where iDCardNO = ? ", idCardNO);
    }
}

