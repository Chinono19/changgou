<template>
  	<div class="header w1210 bc mt15">

		  <TopNav> </TopNav>
		<!-- 头部上半部分 start 包括 logo、搜索、用户中心和购物车结算 -->
		<div class="logo w1210">
			<h1 class="fl"><a href="/Index"><img src="/images/logo.png" alt="畅购商城"></a></h1>
			<!-- 头部搜索 start -->
			<div class="search fl">
				<div class="search_form">
					<div class="form_left fl"></div>
					<form action="" name="serarch" method="get" class="fl">
						<input type="text" class="txt" v-model="keyword" placeholder="请输入商品关键字" />
						<input type="submit" class="btn" value="搜索" @click.prevent="search" />
					</form>
					<div class="form_right fl"></div>
				</div>

				<div style="clear:both;"></div>

				<div class="hot_search">
					<strong>热门搜索:</strong>
					<a href="">D-Link无线路由</a>
					<a href="">休闲男鞋</a>
					<a href="">TCL空调</a>
					<a href="">耐克篮球鞋</a>
				</div>
			</div>
			<!-- 头部搜索 end -->

			<!-- 用户中心 start-->
			<div class="user fl">
				<dl>
					<dt>
						<em></em>
						<a href="">用户中心</a>
						<b></b>
					</dt>
					<dd>
						<div class="prompt">
							您好，请<a href="">登录</a>
						</div>
						<div class="uclist mt10">
							<ul class="list1 fl">
								<li><a href="user.html">用户信息></a></li>
								<li><a href="">我的订单></a></li>
								<li><a href="">收货地址></a></li>
								<li><a href="">我的收藏></a></li>
							</ul>

							<ul class="fl">
								<li><a href="">我的留言></a></li>
								<li><a href="">我的红包></a></li>
								<li><a href="">我的评论></a></li>
								<li><a href="">资金管理></a></li>
							</ul>

						</div>
						<div style="clear:both;"></div>
						<div class="viewlist mt10">
							<h3>最近浏览的商品：</h3>
							<ul>
								<li><a href=""><img src="images/view_list1.jpg" alt="" /></a></li>
								<li><a href=""><img src="images/view_list2.jpg" alt="" /></a></li>
								<li><a href=""><img src="images/view_list3.jpg" alt="" /></a></li>
							</ul>
						</div>
					</dd>
				</dl>
			</div>
			<!-- 用户中心 end-->

			<!-- 购物车 start -->
			<div class="cart fl">
				<dl>
					<dt>
						<a href="">去购物车结算</a>
						<b></b>
					</dt>
					<dd>
						<div class="prompt">
							购物车中还没有商品，赶紧选购吧！
						</div>
					</dd>
				</dl>
			</div>
			<!-- 购物车 end -->
		</div>
		<!-- 头部上半部分 end -->

		<div style="clear:both;"></div>
		<!-- 导航条部分 start -->
		<div class="nav w1210 bc mt10">
			<!--  商品分类部分 start-->
			<div :class="{'category':true ,'fl':true,'cat1':!isFirst}"> <!-- 非首页，需要添加cat1类 -->
				<div :class="{'cat_hd':true,'off':!isFirst}">  <!-- 注意，首页在此div上只需要添加cat_hd类，非首页，默认收缩分类时添加上off类，鼠标滑过时展开菜单则将off类换成on类 -->
					<h2>全部商品分类</h2>
					<em></em>
				</div>

				<div  :class="{'cat_bd':true,'none':!isFirst}" >

					<div class="cat item1" v-for="(c1,i1) in list" :key="i1" >
						<h3><a href="">{{c1.catName}}</a> <b></b></h3>
						<div class="cat_detail">
							<dl class="dl_1st" v-for="(c2,i2) in c1.children" :key="i2">
								<dt><a href="">{{c2.catName}}</a></dt>
								<dd>
									<a :href="'/list/'+c3.id" v-for="(c3,i3) in c2.children" :key="i3">{{c3.catName}}</a>
								
								</dd>
							</dl>
						</div>
					</div>

					

				</div>

			</div>
			<!--  商品分类部分 end-->
			<div class="navitems fl">
				<ul class="fl">
					<li class="current"><a href="">首页</a></li>
					<li><a href="">电脑频道</a></li>
					<li><a href="">家用电器</a></li>
					<li><a href="">品牌大全</a></li>
					<li><a href="">团购</a></li>
					<li><a href="">积分商城</a></li>
					<li><a href="">夺宝奇兵</a></li>
				</ul>
				<div class="right_corner fl"></div>
			</div>
		</div>
		<!-- 导航条部分 end -->


	</div>
</template>

<script>
import TopNav from '~/components/TopNav'

import {mapMutations} from 'vuex' 
export default {
	props:{
		list:{
			type:Array
		},
		//是否是首页
		isFirst:{ 
			type:Boolean,
			default:true
		},
		keyword:"",//关键字
	},
	components:{
		TopNav,
	},
	methods: {
		...mapMutations(['setData']),
		search(){
			this.setData({'key':'keyword','value':this.keyword})
		}
	},
}
</script>

<style   scoped >
</style>