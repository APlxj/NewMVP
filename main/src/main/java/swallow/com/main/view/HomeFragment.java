package swallow.com.main.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.app.RouterURL;
import swallow.com.main.contant.SettingConfig;
import swallow.com.main.contract.IHomeContract;
import swallow.com.main.presenter.MainPresenter;
import swallow.com.model_base.BaseListFragment;
import swallow.com.model_data.model.EventBusBean;
import swallow.com.model_ocr.camera.CameraActivity;
import swallow.com.model_ocr.model.ResultModel;
import swallow.com.model_ocr.util.RecognizeService;
import swallow.com.model_ui.keyboard.KeyboardType;
import swallow.com.model_ui.keyboard.SecurityConfigure;
import swallow.com.model_ui.keyboard.SecurityEditText;
import swallow.com.model_ui.keyboard.SecurityKeyboard;
import swallow.com.model_utils.FileUtils;
import swallow.com.model_utils.SPUtils;
import swallow.com.model_utils.ToastUtils;
import swallow.com.model_zxing.android.CaptureActivity;
import swallow.com.model_zxing.bean.ZxingConfig;
import swallow.com.model_zxing.common.Constant;

import static com.mob.tools.utils.DeviceHelper.getApplication;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomeFragment
        extends BaseListFragment<IHomeContract.View, IHomeContract.Presenter>
        implements IHomeContract.View, View.OnClickListener {

    //更多
    @BindView(R2.id.iv_left)
    ImageView mIvLeft;
    //搜索框
    @BindView(R2.id.et_comment_search)
    SecurityEditText mEtCommentSearch;
    //搜索布局
    @BindView(R2.id.lin_title_search)
    LinearLayout mLinTitleSearch;
    //头像
    @BindView(R2.id.iv_right)
    ImageView mIvRight;
    //title总布局
    @BindView(R2.id.v_title_container)
    LinearLayout mVTitleContainer;
    //列表
    @BindView(R2.id.recyclerView)
    RecyclerView mRecyclerView;
    //刷新
    @BindView(R2.id.srl_layout)
    SmartRefreshLayout mSrlLayout;
    //总View
    @BindView(R2.id.layout_home)
    LinearLayout mLayoutHome;
    //扫描
    @BindView(R2.id.ib_scan)
    ImageButton mScan;

    //安全键盘
    SecurityKeyboard securityKeyboard;

    private int REQUEST_CODE_SCAN = 101;
    private int REQUEST_CODE_SCAN_FRONT = 102;
    private int REQUEST_CODE_SCAN_BACK = 103;
    private int REQUEST_CODE_SCAN_GENERAL = 104;

    private Intent intent;

    @Override
    public IHomeContract.Presenter createPresenter() {
        return new MainPresenter(getActivity(), mRecyclerView);
    }

    @Override
    public IHomeContract.View createView() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initTitle() {
        mIvLeft.setVisibility(View.VISIBLE);
        mEtCommentSearch.setHint("请输入搜索内容");
        mEtCommentSearch.setEnabled(true);
        mEtCommentSearch.setFocusable(false);
        mEtCommentSearch.setOnClickListener(this);
        //侧滑
        mIvLeft.setOnClickListener(v ->
                EventBus.getDefault().post(new EventBusBean(EventBusBean.SHOP_MALL_HOME, 1))
        );
    }

    @Override
    public void initView(View view) {
        super.rlRefreshLayout = mSrlLayout;
        super.initView(view);
        mPresenter.BannerData();
        //键盘
        SecurityConfigure configure = new SecurityConfigure()
                .setDefaultKeyboardType(KeyboardType.NUMBER);
        securityKeyboard = new SecurityKeyboard(mLinTitleSearch, configure);
        mScan.setOnClickListener(v -> scan());
        mIvRight.setOnClickListener(v -> {
            boolean isLogin = SPUtils.getInstance(SPUtils.USER).getBoolean(SettingConfig.isLogin);
            if (isLogin) {
            } else {
                //跳转到登录界面
                ARouter.getInstance()
                        .build(RouterURL.LANDR)
                        .navigation();
            }
        });
    }

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        mPresenter.FeedArticleList(false, mSrlLayout, page);
    }

    @Override
    public void init() {
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.startBannerPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.stopBannerPlay();
    }

    @Override
    public void scan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        CharSequence[] sequences = {"二维码/条形码", "身份证（正）", "身份证（反）", "图片"};
        builder.setTitle(getResources().getString(R.string.main_scan))
                .setItems(sequences, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            /*ZxingConfig是配置类
                             *可以设置是否显示底部布局，闪光灯，相册，
                             * 是否播放提示音  震动
                             * 设置扫描框颜色等
                             * 也可以不传这个参数
                             * */
                            intent = new Intent(getActivity(), CaptureActivity.class);
                            ZxingConfig config = new ZxingConfig();
                            config.setPlayBeep(true);//是否播放扫描声音 默认为true
                            config.setShake(true);//是否震动  默认为true
                            config.setDecodeBarCode(false);//是否扫描条形码 默认为true
                            config.setReactColor(R.color.darkturquoise);//设置扫描框四个角的颜色 默认为淡蓝色
                            config.setFrameLineColor(R.color.darkturquoise);//设置扫描框边框颜色 默认无色
                            config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                            //config.setMaskViewColor(R.color.tra);//外框颜色
                            config.setScanLineColor(R.color.cyan);
                            intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                            startActivityForResult(intent, REQUEST_CODE_SCAN);
                            break;
                        case 1:
                            intent = new Intent(getApplication(), CameraActivity.class);
                            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                                    FileUtils.getSaveFile("pic").getAbsolutePath());
                            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                                    CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                            startActivityForResult(intent, REQUEST_CODE_SCAN_FRONT);
                            break;
                        case 2:
                            intent = new Intent(getApplication(), CameraActivity.class);
                            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                                    FileUtils.getSaveFile("pic").getAbsolutePath());
                            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                                    CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
                            startActivityForResult(intent, REQUEST_CODE_SCAN_BACK);
                            break;
                        case 3:
                            intent = new Intent(getApplication(), CameraActivity.class);
                            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                                    FileUtils.getSaveFile("pic").getAbsolutePath());
                            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                                    CameraActivity.CONTENT_TYPE_GENERAL);
                            startActivityForResult(intent, REQUEST_CODE_SCAN_GENERAL);
                            break;
                    }
                });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) return;
        String content;
        if (requestCode == REQUEST_CODE_SCAN) {
            // 扫描二维码/条码回传
            content = data.getStringExtra(Constant.CODED_CONTENT);
            ToastUtils.showShort(content);
        } else {
            RecognizeService.recAccurateBasic(FileUtils.getSaveFile("pic").getAbsolutePath(),
                    new RecognizeService.ServiceListener<ResultModel>() {
                        @Override
                        public void onResult(ResultModel result) {
                            ToastUtils.showShort(result.toString());
                        }

                        @Override
                        public void onError(String result) {

                        }
                    });
        }
    }
}
