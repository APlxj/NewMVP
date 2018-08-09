package swallow.com.main.home;

import java.util.ArrayList;
import java.util.List;

import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomePresenter
        extends BasePresenter<HomeContract.View, HomeContract.Model>
        implements HomeContract.Presenter {

    @Override
    protected HomeContract.Model createModel() {
        return new HomeModel();
    }

    @Override
    public void initListData() {
        List<String> strings = new ArrayList<>();
        strings.add("主页");
        strings.add("订单");
        strings.add("知识");
        strings.add("我的");
        mView.showData(strings);
    }
}
