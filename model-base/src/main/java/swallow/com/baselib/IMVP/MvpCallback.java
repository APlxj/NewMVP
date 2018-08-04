package swallow.com.baselib.IMVP;

/**
 * 类描述：v-p的解绑和绑定过程
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface MvpCallback<V extends IView, P extends IPresenter<V>> {

    //创建Presenter  调用在init中
    P createPresenter();

    //创建View
    V createView();

    void setPresenter(P presenter);

    P getPresenter();

    void setMvpView(V view);

    V getMvpView();
}
