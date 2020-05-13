<template>
  <div>
    <!-- 顶部导航 start -->
    <TopNav></TopNav>
    <!-- 顶部导航 end -->

    <div style="clear:both;"></div>

    <!-- 页面头部 start -->
    <div class="header w990 bc mt15">
      <div class="logo w990">
        <h2 class="fl"><a href="index.html"><img src="images/logo.png" alt="畅购商城"></a></h2>
      </div>
    </div>
    <!-- 页面头部 end -->

    <div style="clear:both;"></div>

    <!-- 主体部分 start -->
    <div class="success w990 bc mt15">
      <div class="success_hd">
        <h2>订单支付成功</h2>
      </div>
      <div class="success_bd">
        <p><span></span>支付成功，货物即将送出！</p>
      </div>
    </div>
    <!-- 主体部分 end -->

    <div style="clear:both;"></div>
    <!-- 底部版权 start -->
    <Footer></Footer>
    <!-- 底部版权 end -->
  </div>
</template>

<script>
import TopNav from '~/components/TopNav'
import Footer from '~/components/Foot'

export default {
  head: {
    title: '支付成功页面',
    link: [
      {rel:'stylesheet',href:'/style/success.css'}
    ],
    script: [

    ]
  },
  components: {
    TopNav,
    Footer
  },

}
</script>

<style>

</style>