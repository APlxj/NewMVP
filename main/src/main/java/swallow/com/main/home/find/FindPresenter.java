package swallow.com.main.home.find;

import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class FindPresenter
        extends BasePresenter<FindContract.View, FindContract.Model>
        implements FindContract.Presenter {

    @Override
    public void attachView(FindContract.View view) {
        super.attachView(view);
    }

    @Override
    protected FindContract.Model createModel() {
        return new FindModel();
    }
}
