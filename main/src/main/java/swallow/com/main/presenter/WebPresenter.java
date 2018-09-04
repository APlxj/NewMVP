package swallow.com.main.presenter;

import swallow.com.main.contract.IWebContract;
import swallow.com.main.model.WebModel;
import swallow.com.model_base.BasePresenter;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/31  17:17
 * - generate by MvpAutoCodePlus plugin.
 */

public class WebPresenter
        extends BasePresenter<IWebContract.View, IWebContract.Model>
        implements IWebContract.Presenter {

    @Override
    protected IWebContract.Model createModel() {
        return new WebModel();
    }
}

