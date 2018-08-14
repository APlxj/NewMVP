package swallow.com.model_base.IMVP;

import android.support.v4.app.Fragment;

/**
 * 类描述：activity规则接口
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IActivity {

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    int getLayoutId();

    /**
     * 初始化标题
     */
    void initTitle();

    /**
     * 初始化view
     */
    void initView();

    /**
     * 初始化数据
     */
    void init();

    /**
     * 显示Fragment
     */
    void showFragment(int frameLayoutId, Fragment fragment);
}
