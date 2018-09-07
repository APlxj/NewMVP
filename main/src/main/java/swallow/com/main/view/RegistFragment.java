package swallow.com.main.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.contract.IRegistContract;
import swallow.com.main.presenter.RegistPresenter;
import swallow.com.model_base.BaseFragment;
import swallow.com.model_data.model.EventBusBean;
import swallow.com.model_data.model.User;
import swallow.com.model_utils.EditUtils;
import swallow.com.model_utils.PhoneUtils;
import swallow.com.model_utils.ToastUtils;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:25
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegistFragment
        extends BaseFragment<IRegistContract.View, IRegistContract.Presenter>
        implements IRegistContract.View {

    @BindView(R2.id.mobile)
    EditText mobile;
    @BindView(R2.id.password)
    EditText password;
    @BindView(R2.id.name)
    EditText name;
    @BindView(R2.id.iDCardNO)
    EditText iDCardNO;
    @BindView(R2.id.gender)
    EditText gender;
    @BindView(R2.id.age)
    EditText age;
    @BindView(R2.id.nation)
    EditText nation;
    @BindView(R2.id.politicsstatus)
    EditText politicsstatus;
    @BindView(R2.id.education)
    EditText education;
    @BindView(R2.id.address)
    EditText address;
    @BindView(R2.id.register)
    Button register;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void init() {
        register.setOnClickListener(v -> register());
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public IRegistContract.Presenter createPresenter() {
        return new RegistPresenter();
    }

    @Override
    public IRegistContract.View createView() {
        return this;
    }

    @Override
    public void register() {
        if (!verifyMsg()) return;
        if (saveMsg()) {
            ToastUtils.showShort("注册成功");
            EventBus.getDefault().post(new EventBusBean(EventBusBean.TOLOGIN, 1));
        }
    }

    @Override
    public boolean verifyMsg() {
        if (!PhoneUtils.judgePhoneNums(mobile.getText().toString())) {
            ToastUtils.showShort("请输入正确电话号码");
            EditUtils.requestFocus(mobile);
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            ToastUtils.showShort("请输入密码");
            EditUtils.requestFocus(password);
            return false;
        }
        if (TextUtils.isEmpty(name.getText().toString())) {
            ToastUtils.showShort("请输入姓名");
            EditUtils.requestFocus(name);
            return false;
        }
        if (TextUtils.isEmpty(iDCardNO.getText().toString())) {
            ToastUtils.showShort("请输入身份证号码");
            EditUtils.requestFocus(iDCardNO);
            return false;
        }
        if (TextUtils.isEmpty(gender.getText().toString())) {
            ToastUtils.showShort("请输入性别");
            EditUtils.requestFocus(gender);
            return false;
        }
        if (TextUtils.isEmpty(age.getText().toString())) {
            ToastUtils.showShort("请输入年龄");
            EditUtils.requestFocus(age);
            return false;
        }
        if (TextUtils.isEmpty(nation.getText().toString())) {
            ToastUtils.showShort("请输入民族");
            EditUtils.requestFocus(nation);
            return false;
        }
        if (TextUtils.isEmpty(politicsstatus.getText().toString())) {
            ToastUtils.showShort("请输入政治面貌");
            EditUtils.requestFocus(politicsstatus);
            return false;
        }
        if (TextUtils.isEmpty(education.getText().toString())) {
            ToastUtils.showShort("请输入学历");
            EditUtils.requestFocus(education);
            return false;
        }
        if (TextUtils.isEmpty(address.getText().toString())) {
            ToastUtils.showShort("请输入地址");
            EditUtils.requestFocus(address);
            return false;
        }
        List<User> users = mPresenter.queryByIDCardNO(iDCardNO.getText().toString());
        if (null != users && users.size() > 0) {
            ToastUtils.showShort("用户已注册");
            return false;
        }
        return true;
    }

    @Override
    public boolean saveMsg() {
        User new_user = new User(
                iDCardNO.getText().toString()
                , name.getText().toString()
                , gender.getText().toString()
                , Integer.parseInt(age.getText().toString())
                , nation.getText().toString()
                , politicsstatus.getText().toString()
                , education.getText().toString()
                , mobile.getText().toString()
                , address.getText().toString()
                , password.getText().toString()
        );
        return mPresenter.saveMsg(new_user);
    }
}

