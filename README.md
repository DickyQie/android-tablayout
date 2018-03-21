# Android之新闻客服端顶部导航栏Tab点击和左右滑动实现切换界面
 <p>APP市场中大多数新闻App都有导航菜单，导航菜单是一组标签的集合，在新闻客户端中，每个标签标示一个新闻类别，对应下面ViewPager控件的一个分页面，今日头条， <span style="background-color:rgb(255, 255, 255); color:rgb(51, 51, 51)">网易新闻</span>等。</p> 
<p>随着版本迭代的更新，带来了许多控件，案例主要用到了TabLayout，ViewPage，RecyclerView，CardView等新控件。 效果如图：</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" src="https://static.oschina.net/uploads/space/2017/0216/101319_Sa3J_2945455.gif"></p> 
<p>&nbsp;</p> 
<p>以前的实现方法是 ：ViewPagerIndicator + Fragment + ViewPager 相结合来实现</p> 
<p>请看博客： <a href="https://my.oschina.net/zhangqie/blog/801646" rel="nofollow">ViewPagerIndicator实现新闻App导航栏</a>。</p> 
<p>今天主要讲的是另一种实现方式：TabLayout+ Fragment + ViewPager</p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(51, 51, 51)">添加程序所需要的依赖：</span></p> 
<pre><code class="language-java"> compile 'com.android.support:design:23.2.1'
 compile 'com.android.support:recyclerview-v7:23.1.1'
 compile 'com.android.support:cardview-v7:23.2.1'</code></pre> 
<p>主布局</p> 
<pre><code class="language-html">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"&gt;

    &lt;android.support.design.widget.TabLayout
        android:id="@+id/tablayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#E0E0E0"
        app:tabIndicatorColor="@color/ind_red"
        app:tabMode="fixed"
        app:tabSelectedTextColor="@color/material_orange"
        app:tabTextColor="@android:color/black"
        app:tabIndicatorHeight="5dp"
        app:tabTextAppearance="@style/TabStyle"
        /&gt;
    &lt;android.support.v4.view.ViewPager
        android:id="@+id/tab_viewpager"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="@android:color/white" /&gt;

&lt;/LinearLayout&gt;</code></pre> 
<p>Tablayout控件包含很多属性 例如 tabIndicatorColor：菜单下方移动的横线的颜色&nbsp; 属性很多就不一 一介绍了，代码中有注释。</p> 
<p>Activity.Java</p> 
<pre><code class="language-java">public class TabLessActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;

    private ViewPager viewPager;

    private Fragment[] mFragmentArrays = new Fragment[5];

    private String[] mTabTitles = new String[5];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab_layout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
        initView();
    }

    private void initView() {
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
        mTabTitles[2] = "科技";
        mTabTitles[3] = "体育";
        mTabTitles[4] = "健康";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = TabFragment.newInstance();
        mFragmentArrays[1] = TabFragment.newInstance();
        mFragmentArrays[2] = TabFragment.newInstance();
        mFragmentArrays[3] = TabFragment.newInstance();
        mFragmentArrays[4] = TabFragment.newInstance();
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }
}</code></pre> 
<p>Fragment.java</p> 
<pre><code class="language-java">public class TabFragment extends Fragment {

    public static Fragment newInstance() {
        TabFragment fragment = new TabFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter());
        return rootView;
    }
}</code></pre> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(51, 51, 51)">技术在更新，我们在进步,TabLayout实现tab导航效果比以前那些方法来的更加简单方便。</span></p> 
<p>&nbsp;</p> 
