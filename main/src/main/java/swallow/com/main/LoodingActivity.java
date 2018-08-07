package swallow.com.main;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import swallow.com.main.app.RouterURL;
import swallow.com.model_base.BaseActivity;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;

@Route(path = RouterURL.Lood)
public class LoodingActivity extends BaseActivity {

    @BindView(R2.id.jup)
    TextView jup;
    private int time = 10;
    private Timer timer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_looding;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void init() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                time--;
                runOnUiThread(() -> {
                    if (time == 0) {
                        timer.cancel();
                        ARouter.getInstance().build(RouterURL.Home).navigation();
                    } else {
                        jup.setText(getResources().getString(R.string.jup) + time);
                    }
                });

            }
        }, 0, 1000);
    }

    @OnClick({R2.id.jup})
    public void onClick(View view) {
        ARouter.getInstance().build(RouterURL.Home).navigation();
        timer.cancel();
    }

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public IView createView() {
        return null;
    }
}
