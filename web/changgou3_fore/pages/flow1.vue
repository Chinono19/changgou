<template>
  <div>
    <!-- 顶部导航 start -->
   <TopNav></TopNav>
    <!-- 顶部导航 end -->

    <div style="clear:both;"></div>

    <!-- 页面头部 start -->
    <div class="header w990 bc mt15">
      <div class="logo w990">
        <h2 class="fl">
          <a href="index.html">
            <img src="images/logo.png" alt="畅购商城" />
          </a>
        </h2>
        <div class="flow fr">
          <ul>
            <li class="cur">1.我的购物车</li>
            <li>2.填写核对订单信息</li>
            <li>3.成功提交订单</li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 页面头部 end -->

    <div style="clear:both;"></div>

    <!-- 主体部分 start -->
    <div class="mycart w990 mt10 bc">
      <h2>
        <span>我的购物车</span>
      </h2>
      <table>
        <thead>
          <tr>
            <th class="col0">
              <input type="checkbox" :checked="selectAllChecked" name="" id="" @click="selectAll($event)">
            </th>
            <th class="col1">商品名称</th>
            <th class="col2">商品信息</th>
            <th class="col3">单价</th>
            <th class="col4">数量</th>
            <th class="col5">小计</th>
            <th class="col6">操作</th>
          </tr>
        </thead>
        <tbody>
            <!-- 购物车列表 -->
          <tr v-for="(item,index) in cart " :key="index">
            <th class="col0">
                <input type="checkbox" v-model="item.checked" name="" id="">
            </th>
            <td class="col1">
              <a href>
                <img :src="item.midlogo" alt />
              </a>
              <strong>
                <a href>{{item.goods_name}}</a>
              </strong>
            </td>
            <td class="col2">
               <p v-for="(value,key,index) in item.spec_info_id_txt" :key="index">{{key}}:{{value}} </p>
            </td>
            <td class="col3">
              ￥
              <span>{{item.price}}</span>
            </td>
            <td class="col4">
              <a href="javascript:;" class="reduce_num" @click.prevent="minus(item)"></a>
              <input type="text" name="amount" v-model="item.count" class="amount" />
              <a href="javascript:;" class="add_num" @click.prevent="plus(item)"></a>
            </td>
            <td class="col5">
              ￥
              <span>{{item.price*item.count}}</span>
            </td>
            <td class="col6">
              <a href @click.prevent="del(index)">删除</a>
            </td>
          </tr>
    
        </tbody>
        <tfoot>
          <tr>
            <td colspan="7">
              购物金额总计：
              <strong>
                ￥
                <span id="total">{{totalPrice}}</span>
              </strong>
            </td>
          </tr>
        </tfoot>
      </table>
      <div class="cart_btn w990 bc mt10">
        <a href class="continue">继续购物</a>
        <a href="flow2.html" class="checkout" @click.prevent="submitFN">结 算</a>
      </div>
    </div>
    <!-- 主体部分 end -->

    <div style="clear:both;"></div>
    <!-- 底部版权 start -->
    <Foot> </Foot>
    <!-- 底部版权 end -->
  </div>
</template>


<script>
import TopNav from "~/components/TopNav.vue";
import Foot from "~/components/Foot.vue";
export default {
  head: {
    title: "详情页",
    link: [{ rel: "stylesheet", href: "/style/cart.css" }],
    script: [
      // { type: "text/javascript", src: "/js/cart1.js" }
      ]
  },
  components:{
      TopNav,
      Foot
  },
  computed: {
    totalPrice(){
      //求和
      let sum = 0;
      this.cart.forEach(item=>{
        sum += (item.price * item.count)
      })
    return sum
    }
  },
  data() {
      return {
          cart:[],
          selectAllChecked:false
      }
  },
  methods: {
    minus(item){
      //减操作
      if(item.count > 1){
        item.count --;
      }
    },
    plus(item){
      item.count ++;
    },
    del(index){
      if(confirm('您确认要删除吗？')){
        this.cart.splice(index,1);
      }
    },
    selectAll(e){
      this.cart.forEach(item=>{
        item.checked = e.target.checked;
      })
    },
    //结算跳转
    submitFN(){
      //如果登录跳转到flow2,否则跳转到登录页面,同事记录需要跳转的页面路径
      let token = localStorage.getItem('token');
      if(token) {
        this.$router.push('/flow2');
      }else{
        sessionStorage.setItem('returnURL','/flow2');
        this.$router.push('/login');
      }
    }
  },
  //监听器
  watch: {
    cart:{
      async handler(newCart,oldCart){
        let {data} = await this.$request.updateCart(newCart);
        if(data.code == 0){
          alert(data.message);
        }

        //购物项 选中的个数，购物车个数相同，全选需要选中
        let cartSize = this.cart.length;
        let checkSize = this.cart.filter(item=>item.checked).length;
        this.selectAllChecked = (cartSize == checkSize);
      },

      immediate:false, //true就是会直接执行
      deep:true  //深度监听,就是对象的下面的属性改变之后也会执行
    }
  },
  async mounted(){
      //获取token
      let token = localStorage.getItem('token');
      if(token){
          console.warn("token有效");
          let {data} = await this.$request.getCart();
          console.warn(data);
          
          this.cart = data.data;
      }else{
          //未登录
          let cartStr = localStorage.getItem('cart');
          this.cart = JSON.parse(cartStr);
      }
      console.warn(this.cart);
      
  }
};
</script>

<style>
</style>