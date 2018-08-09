package swallow.com.main.home.mine;

import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MinePresenter
        extends BasePresenter<MineContract.View, MineContract.Model>
        implements MineContract.Presenter {

    @Override
    public void attachView(MineContract.View view) {
        super.attachView(view);
    }

    @Override
    protected MineContract.Model createModel() {
        return new MineModel();
    }
}
