### Android TabLayout实现新闻客服端顶部导航栏
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



