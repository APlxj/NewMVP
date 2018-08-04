package swallow.com.model_base.IMVP;

import io.reactivex.disposables.Disposable;

/**
 * 类描述：连接池
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IDisposablePool {
    /**
     * rxjava管理订阅者
     * @param disposable
     */
    void addDisposable(Disposable disposable);

    /**
     * 丢弃连接 在view销毁时调用,取消订阅关系
     */
    void clearPool();

}
