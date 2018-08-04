package swallow.com.model_base.IMVP;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

/**
 * 类描述：顶级view接口
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IView extends LifecycleOwner {

    Context getContext();

    /**
     * 网络请求错误,弹框提示
     *
     * @param msg
     * @param code
     */
    void showError(String msg, String code);

    /**
     * 显示Dialog
     */
    void showHUD(String msg);

    /**
     * 关闭Dialog
     */
    void dismissHUD();

    //----------------------------下面用来显示空界面---------------------------//

    /**
     * showNormal 页面
     */
    void showNormal();

    /**
     * Show loading 页面
     */
    void showLoading();

    /**
     * Show EmptyView 页面
     */
    void showEmptyView();

    /**
     * Show error 页面
     */
    void showError();
}
