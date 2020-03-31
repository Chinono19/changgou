<template>
  <div>
      	<!-- 顶部导航 start -->
	<div class="topnav">
		<div class="topnav_bd w990 bc">
			<div class="topnav_left">

			</div>
			<div class="topnav_right fr">
				<ul>
					<li>您好，{{username}}欢迎来到畅购！[<a href="login.html">登录</a>] [<a href="register.html">免费注册</a>] </li>
					<li class="line">|</li>
					<li>我的订单</li>
					<li class="line">|</li>
					<li>客户服务</li>

				</ul>
			</div>
		</div>
	</div>

  </div>
</template>

<script>
import { mapMutations } from 'vuex'
export default {
	data() {
		return {
			username:""
		}
	},

	methods: {
		...mapMutations(['setData'])
	},
	mounted()  {
		let loginName = localStorage.getItem('loginName');
		this.setData({'key':"user",'value':loginName});
		console.warn(this.$store.state.user);
		this.username = this.$store.state.user;
		
	},

}
</script>

<style>

</style>