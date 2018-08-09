package swallow.com.main.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.app.RouterURL;
import swallow.com.main.home.find.FindFragment;
import swallow.com.main.home.home.HomeFragment;
import swallow.com.main.home.mine.MineFragment;
import swallow.com.main.home.order.OrderFragment;
import swallow.com.model_base.BaseActivity;
import swallow.com.model_data.BaseEventbusBean;
import swallow.com.model_data.EventBusBean;
import swallow.com.model_ui.BottomNavigationViewHelper;
import swallow.com.model_utils.ToastUtils;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
@Route(path = RouterURL.Home)
public class HomeActivity
        extends BaseActivity<HomeContract.View, HomeContract.Presenter>
        implements HomeContract.View, NavigationView.OnNavigationItemSelectedListener {

    //view
    @BindView(R2.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    //主布局
    @BindView(R2.id.layout_pager)
    FrameLayout mFrameLayout;
    //侧滑菜单
    @BindView(R2.id.nav_view)
    NavigationView mNavigationView;
    //底部按钮
    @BindView(R2.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    //fragment容器
    private List<Fragment> mFragmentList;
    //选中fragment
    private Fragment mCurrentFragment;

    @Override
    public int getLayoutId() {
        return R.layout.mall_activity_home;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {
        initNavigationView();
        initFragment();
        initBottomNavigationView();
    }

    private void initNavigationView() {
        //头部布局  登录
        mNavigationView.getHeaderView(0)
                .findViewById(R.id.nav_header_login_tv)
                .setOnClickListener(v -> {
                    ToastUtils.showShort("请登录");
                });

        //通过actionbardrawertoggle将toolbar与drawablelayout关联起来
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.mall_drawer_open, R.string.mall_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //可以重新侧滑方法,该方法实现侧滑动画,整个布局移动效果
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = mDrawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };

        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);

        //设置图片为本身的颜色
        mNavigationView.setItemIconTintList(null);
        //设置item的点击事件
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new FindFragment());
        mFragmentList.add(new OrderFragment());
        mFragmentList.add(new MineFragment());
    }

    private void initBottomNavigationView() {
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        // 预设定进来后,默认显示fragment
        addFragment(R.id.layout_pager, mFragmentList.get(0));
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.tab_home) {
                addFragment(R.id.layout_pager, mFragmentList.get(0));
            } else if (item.getItemId() == R.id.tab_goods) {
                addFragment(R.id.layout_pager, mFragmentList.get(1));
            } else if (item.getItemId() == R.id.tab_cart) {
                addFragment(R.id.layout_pager, mFragmentList.get(2));
            } else if (item.getItemId() == R.id.tab_self) {
                addFragment(R.id.layout_pager, mFragmentList.get(3));
            }
            return true;
        });

    }

    /**
     * 显示fragment
     *
     * @param frameLayoutId
     * @param fragment
     */
    private void addFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).show(fragment);
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);
                }
            }
            mCurrentFragment = fragment;
            transaction.commit();
        }
    }

    @Override
    public void init() {
        showWelCome();
        mPresenter.initListData();
    }

    @Override
    public HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public HomeContract.View createView() {
        return this;
    }

    @Override
    public void showWelCome() {
        ToastUtils.showShort("欢迎光临");
    }

    @Override
    public void showData(List<String> data) {
        ToastUtils.showShort(data.toString());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {//福利
            ToastUtils.showShort("福利");

        } else if (id == R.id.item2) {//视频
            ToastUtils.showShort("视频");

        } else if (id == R.id.item3) {//关于我们
            ToastUtils.showShort("关于我们");

        } else if (id == R.id.item4) {//退出登录
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        return false;
    }

    @Override
    protected void onEvent(BaseEventbusBean event) {
        super.onEvent(event);
        int type = event.getType();

        if (EventBusBean.SHOP_MALL_HOME == type) {
            //检查侧滑菜单的状态
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        }
    }
}
