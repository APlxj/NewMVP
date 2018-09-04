package swallow.com.main.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.app.RouterURL;
import swallow.com.main.contract.IWebContract;
import swallow.com.main.presenter.WebPresenter;
import swallow.com.model_base.BaseActivity;
import swallow.com.model_utils.NetworkUtils;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/31  17:17
 * - generate by MvpAutoCodePlus plugin.
 */

@Route(path = RouterURL.Web)
public class WebActivity
        extends BaseActivity<IWebContract.View, IWebContract.Presenter>
        implements IWebContract.View{

    @BindView(R2.id.web_view)
    WebView mWebView;
    @BindView(R2.id.root_view)
    LinearLayout mRootView;
    @BindView(R2.id.iv_refresh)
    ImageView iv_refresh;
    @Autowired
    public String uri;

    Animation animation;

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void initTitle() {

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initView() {
        //清除网页访问留下的缓存
        // 由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
        //mWebView.clearCache(true);
        //清除当前webview访问的历史记录
        // 只会webview访问历史记录里的所有记录除了当前访问记录
        //mWebView.clearHistory();
        //这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
        //mWebView.clearFormData();
        WebSettings settings = mWebView.getSettings();
        //默认是false 设置true允许和js交互
        settings.setJavaScriptEnabled(true);
        //支持通过JS打开新窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //支持插件
        //settings.setPluginsEnabled(true);
        //设置自适应屏幕，两者合用
        //将图片调整到适合webview的大小
        settings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        settings.setLoadWithOverviewMode(true);
        //缩放操作
        //支持缩放，默认为true。是下面那个的前提。
        settings.setSupportZoom(true);
        //设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setBuiltInZoomControls(true);
        //隐藏原生的缩放控件
        settings.setDisplayZoomControls(false);
        //设置可以访问文件
        settings.setAllowFileAccess(true);
        //支持自动加载图片
        settings.setLoadsImagesAutomatically(true);
        //设置编码格式
        settings.setDefaultTextEncodingName("utf-8");
        //  WebSettings.LOAD_DEFAULT 如果本地缓存可用且没有过期则使用本地缓存，否加载网络数据 默认值
        //  WebSettings.LOAD_CACHE_ELSE_NETWORK 优先加载本地缓存数据，无论缓存是否过期
        //  WebSettings.LOAD_NO_CACHE  只加载网络数据，不加载本地缓存
        //  WebSettings.LOAD_CACHE_ONLY 只加载缓存数据，不加载网络数据
        //Tips:有网络可以使用LOAD_DEFAULT 没有网时用LOAD_CACHE_ELSE_NETWORK
        if (NetworkUtils.isConnected()) {
            //根据cache-control决定是否从网络上取数据。
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
            //开启 DOM storage API 功能 较大存储空间，使用简单
            settings.setDomStorageEnabled(true);
            //设置数据库缓存路径 存储管理复杂数据 方便对数据进行增加、删除、修改、查询 不推荐使用
            settings.setDatabaseEnabled(true);
            final String dbPath = getApplicationContext().getDir("db", Context.MODE_PRIVATE).getPath();
            settings.setDatabasePath(dbPath);
            //开启 Application Caches 功能 方便构建离线APP 不推荐使用
            settings.setAppCacheEnabled(true);
        } else {
            //没网，则从本地获取，即离线加载
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            //开启 DOM storage API 功能 较大存储空间，使用简单
            settings.setDomStorageEnabled(false);
            //设置数据库缓存路径 存储管理复杂数据 方便对数据进行增加、删除、修改、查询 不推荐使用
            settings.setDatabaseEnabled(false);
            //开启 Application Caches 功能 方便构建离线APP 不推荐使用
            settings.setAppCacheEnabled(false);
        }
        //缓存路径
        final String cachePath = getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        settings.setAppCachePath(cachePath);
        settings.setAppCacheMaxSize(5 * 1024 * 1024);
    }

    @Override
    public void init() {
        mWebView.loadUrl("http://image.baidu.com/");
        //加载 HTML 页面的一小段内容
        //WebView.loadData(String data, String mimeType, String encoding)
        mWebView.setWebViewClient(webViewClient);
    }

    WebViewClient webViewClient = new WebViewClient() {

        @Override
        //作用：打开网页时不调用系统浏览器， 而是在本WebView中显示；
        //     在网页上的所有加载都经过这个方法,这个函数我们可以做很多操作。
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.loadUrl(request.getUrl().toString());
            } else {
                view.loadUrl(request.toString());
            }
            return true;
        }

        @Override
        //作用：开始载入页面调用的，我们可以设定一个loading的页面，告诉用户程序在等待网络响应。
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        //作用：在页面加载结束时调用。我们可以关闭loading 条，切换程序动作。
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        //作用：在加载页面资源时会调用，每一个资源（比如图片）的加载都会调用一次。
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        @Override
        //作用：加载页面的服务器出现错误时（如404）调用。
        //App里面使用webview控件的时候遇到了诸如404这类的错误的时候，
        // 若也显示浏览器里面的那种错误提示页面就显得很丑陋了，
        // 那么这个时候我们的app就需要加载一个本地的错误提示页面，即webview如何加载一个本地的页面
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            switch (errorCode) {
                case 404:
                    //加载一个本地的页面
                    view.loadUrl("file:///android_assets/error_handle.html");
                    break;
            }
        }
    };

    @Override
    public IWebContract.Presenter createPresenter() {
        return new WebPresenter();
    }

    @Override
    public IWebContract.View createView() {
        return this;
    }

    @Override
    protected void onResume() {
        mWebView.onResume();
        mWebView.resumeTimers();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mWebView.onPause();
        mWebView.pauseTimers();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();

            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void goback(View view) {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        }
    }

    @Override
    public void goforward(View view) {
        if (mWebView.canGoForward()) {
            mWebView.goForward();
        }
    }

    @Override
    public void refresh(View view) {
        mWebView.reload(); //刷新
        if (null == animation) {
            animation = AnimationUtils.loadAnimation(this, R.anim.main_refresh);
        }
        iv_refresh.startAnimation(animation);
    }

    @Override
    public void finish(View view) {
        finish();
    }
}

