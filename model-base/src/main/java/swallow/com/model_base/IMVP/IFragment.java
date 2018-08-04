package swallow.com.model_base.IMVP;

import android.os.Bundle;
import android.view.View;

/**
 * 类描述：activity规则接口
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public interface IFragment {

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
    void initView(View view);

    /**
     * 初始化数据
     */
    void init();

    /**
     * view填充之前 过去Intent数据  绑定Presenter等
     * 注意:获取intent的数据需要在super之前,否则如果创建Presenter使用到这些数据的话,这些数据在使用时还未被赋值
     *
     * @param savedInstanceState
     */
    void init(Bundle savedInstanceState);

}
