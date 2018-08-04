package swallow.com.model_base;

import android.content.Context;
import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IView;

/**
 * 类描述：Presenter基类
 * v泛型p,实现v,就是v,构造p调用p层方法;p泛型v,v调用v的方法,
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BasePresenter<V extends IView, M extends IModel> {

    protected V mView;
    protected M mModel;

    //管理事件流订阅的生命周期CompositeDisposable
    private CompositeDisposable compositeDisposable;

    @CallSuper
    public void attachView(V view) {
        this.mView = view;
        if (mModel == null) {
            mModel = createModel();
        }
    }

    @CallSuper
    public void detachView() {
        if (mModel != null) {
            clearPool();
        }
        mModel = null;
        mView = null;
    }


    public Context getContext() {
        return mView.getContext();
    }

    /**
     * rxjava管理订阅者
     */
    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 取消订阅关系
     *
     * @return
     */
    public void clearPool() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

    public M getModel() {
        return mModel;
    }

    protected abstract M createModel();

}
