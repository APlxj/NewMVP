package swallow.com.main.home;

import com.alibaba.android.arouter.facade.annotation.Route;

import swallow.com.main.R;
import swallow.com.main.app.RouterURL;
import swallow.com.model_base.BaseActivity;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
@Route(path = RouterURL.Home)
public class HomeActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.mall_activity_home;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void init() {

    }

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public IView createView() {
        return null;
    }
}
