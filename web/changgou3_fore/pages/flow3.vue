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
			<div class="flow fr flow3">
				<ul>
					<li>1.我的购物车</li>
					<li>2.填写核对订单信息</li>
					<li class="cur">3.成功提交订单</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 页面头部 end -->
	
	<div style="clear:both;"></div>

	<!-- 主体部分 start -->
	<div class="success w990 bc mt15">
		<div class="success_hd">
			<h2>订单提交成功</h2>
		</div>
		<div class="success_bd">
			<p><span></span>订单提交成功，我们将及时为您处理</p>
			<div id="qrcode"></div>
			<p class="message">完成支付后，你可以 <a href="" @click.prevent="payQueryFn">查看订单状态</a>  <a href="">继续购物</a> <a href="">问题反馈</a></p>
		</div>
	</div>
	<!-- 主体部分 end -->

	<div style="clear:both;"></div>
	<!-- 底部版权 start -->
    <Foot></Foot>
	<!-- 底部版权 end -->
  </div>
</template>

<script>
import TopNav from '~/components/TopNav'
import Foot from '~/components/Foot'
export default {
    head:{
        title:"支付页面",
        link:[
            {rel:'stylesheet',href:"/style/success.css"}
        ],
        script:[
            {type:'text/javascript',src:'/js/qrcode.min.js'}
        ]
    },
    data() {
        return {
              sn : this.$route.query.sn
        }
    },
    components:{
        TopNav,
        Foot
    },
    methods:{
        //查询订单的URl地址
        async getWxUrl(sn){
            let {data} = await this.$request.payUrl(this.sn);
            console.warn(data);
            
            if(data.other.wxurl){
                let qrcode = new QRCode(document.getElementById('qrcode'),
                {width:200,height:200});
                //设置数据
                qrcode.makeCode(data.other.wxurl);
            }else{
                alert("重新获取");
            }
        },
        //查询订单状态
        async payQueryFn(){
            let {data} = await this.$request.payQuery(this.sn);
            if(data.code == 1){
                location.href = 'flow4'
            }else{
                alert(data.message);
            }
        }
    },
    mounted() {
        this.getWxUrl(this.sn);
    },

}
</script>

<style>
 #qrcode img {
    margin: 0 auto;			/*居中*/
    padding: 5px;			/*内边距*/
  }
</style>