package swallow.com.baselib;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import swallow.com.baselib.IMVP.IDisposablePool;

/**
 * 类描述：
 * 管理rxjava订阅关系,实现了连接丢弃  不继承这个类的model 要手动实现 添加和清空
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class DisposablePool implements IDisposablePool {

    /**
     * 管理rxjava订阅关系
     * 暂时没用
     */
    private CompositeDisposable mDisposable;

    @Override
    public void addDisposable(Disposable disposable) {
        if (mDisposable == null) {
            mDisposable = new CompositeDisposable(disposable);
        } else {
            mDisposable.add(disposable);
        }
    }

    @Override
    public void clearPool() {
        if (mDisposable != null) {
            mDisposable.clear();
            mDisposable = null;
        }
    }
}
