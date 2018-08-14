package swallow.com.main.presenter;

import java.util.ArrayList;
import java.util.List;

import swallow.com.main.contract.IMainContract;
import swallow.com.main.model.HomeModel;
import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomePresenter
        extends BasePresenter<IMainContract.View, IMainContract.Model>
        implements IMainContract.Presenter {

    @Override
    protected IMainContract.Model createModel() {
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
