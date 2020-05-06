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
        <div class="flow fr flow2">
          <ul>
            <li>1.我的购物车</li>
            <li class="cur">2.填写核对订单信息</li>
            <li>3.成功提交订单</li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 页面头部 end -->

    <div style="clear:both;"></div>

    <!-- 主体部分 start -->
    <div class="fillin w990 bc mt15">
      <div class="fillin_hd">
        <h2>填写并核对订单信息</h2>
      </div>

      <div class="fillin_bd">
        <!-- 收货人信息  start-->
        <div class="address">
          <h3>
            收货人信息
            <a href="javascript:;" id="address_modify">[修改]</a>
          </h3>
          <div class="address_info">
            <p>{{defaultAddress.shr_name}} {{defaultAddress.shr_mobile}}</p>
            <p>{{defaultAddress.shr_province}} {{defaultAddress.shr_city}} {{defaultAddress.shr_area}} {{defaultAddress.shr_address}}</p>
            ---
          </div>

          <div class="address_select none">
          
            <ul>
              <li :class="{'cur': address.isdefault == 1}"
               v-for="(address,index) in addressList" :key="index"
              >
                <input type="radio" name="address" checked="checked" />aaa
                {{address.shr_name}}  {{address.shr_province}} {{address.shr_city}} {{address.shr_area}} {{address.shr_address}} {{address.shr_mobile}}
                <a href>设为默认地址</a>
                <a href>编辑</a>
                <a href>删除</a>
              </li>
            </ul>
          <!-- 添加收货人表单 start -->
            <form action class="" name="address_form">
              <ul>
                <li>
                  <label for>
                    <span>*</span>收 货 人：
                  </label>
                  <input type="text" name class="txt" v-model="newAddress.shr_name" />
                </li>
                <li>
                  <label for>
                    <span>*</span>所在地区：
                  </label>
                  <select v-model="newAddress.shr_province" >
                    <option value="">请选择</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="天津">天津</option>
                    <option value="重庆">重庆</option>
                    <option value="武汉">武汉</option>
                  </select>

                  <select name id v-model="newAddress.shr_city">
                    <option >请选择</option>
                    <option value="朝阳区">朝阳区</option>
                    <option value="东城区">东城区</option>
                    <option value="西城区">西城区</option>
                    <option value="海淀区">海淀区</option>
                    <option value="昌平区">昌平区</option>
                  </select>

                  <select name id v-model="newAddress.shr_area">
                    <option value="">请选择</option>
                    <option value="西二旗">西二旗</option>
                    <option value="西三旗">西三旗</option>
                    <option value="三环以内">三环以内</option>
                  </select>
                </li>
                <li>
                  <label for>
                    <span>*</span>详细地址：
                  </label>
                  <input type="text" name class="txt address" v-model="newAddress.shr_address" />
                </li>
                <li>
                  <label for>
                    <span>*</span>手机号码：
                  </label>
                  <input type="text"  v-model="newAddress.shr_mobile" name class="txt" />
                </li>
              </ul>
            </form>
                  <!-- 添加收货人表单 end -->
            <a href class="confirm_btn" @click.prevent="addAddressFn">
              <span>保存收货人信息</span>
            </a>
          </div>
        </div>
        <!-- 收货人信息  end-->

        <!-- 配送方式 start -->
        <div class="delivery">
          <h3>
            送货方式
            <a href="javascript:;" id="delivery_modify">[修改]</a>
          </h3>
          <div class="delivery_info">
            <p>普通快递送货上门</p>
            <p>送货时间不限</p>
          </div>

          <div class="delivery_select none">
            <table>
              <thead>
                <tr>
                  <th class="col1">送货方式</th>
                  <th class="col2">运费</th>
                  <th class="col3">运费标准</th>
                </tr>
              </thead>
              <tbody>
                <tr class="cur">
                  <td>
                    <input type="radio" name="delivery" checked="checked" />普通快递送货上门
                    <select name id>
                      <option value>时间不限</option>
                      <option value>工作日，周一到周五</option>
                      <option value>周六日及公众假期</option>
                    </select>
                  </td>
                  <td>￥10.00</td>
                  <td>每张订单不满499.00元,运费15.00元, 订单4...</td>
                </tr>
                <tr>
                  <td>
                    <input type="radio" name="delivery" />特快专递
                  </td>
                  <td>￥40.00</td>
                  <td>每张订单不满499.00元,运费40.00元, 订单4...</td>
                </tr>
                <tr>
                  <td>
                    <input type="radio" name="delivery" />加急快递送货上门
                  </td>
                  <td>￥40.00</td>
                  <td>每张订单不满499.00元,运费40.00元, 订单4...</td>
                </tr>
                <tr>
                  <td>
                    <input type="radio" name="delivery" />平邮
                  </td>
                  <td>￥10.00</td>
                  <td>每张订单不满499.00元,运费15.00元, 订单4...</td>
                </tr>
              </tbody>
            </table>
            <a href class="confirm_btn">
              <span>确认送货方式</span>
            </a>
          </div>
        </div>
        <!-- 配送方式 end -->

        <!-- 支付方式  start-->
        <div class="pay">
          <h3>
            支付方式
            <a href="javascript:;" id="pay_modify">[修改]</a>
          </h3>
          <div class="pay_info">
            <p>货到付款</p>
          </div>

          <div class="pay_select none">
            <table>
              <tr class="cur">
                <td class="col1">
                  <input type="radio" name="pay" />货到付款
                </td>
                <td class="col2">送货上门后再收款，支持现金、POS机刷卡、支票支付</td>
              </tr>
              <tr>
                <td class="col1">
                  <input type="radio" name="pay" />在线支付
                </td>
                <td class="col2">即时到帐，支持绝大数银行借记卡及部分银行信用卡</td>
              </tr>
              <tr>
                <td class="col1">
                  <input type="radio" name="pay" />上门自提
                </td>
                <td class="col2">自提时付款，支持现金、POS刷卡、支票支付</td>
              </tr>
              <tr>
                <td class="col1">
                  <input type="radio" name="pay" />邮局汇款
                </td>
                <td class="col2">通过快钱平台收款 汇款后1-3个工作日到账</td>
              </tr>
            </table>
            <a href class="confirm_btn">
              <span>确认支付方式</span>
            </a>
          </div>
        </div>
        <!-- 支付方式  end-->

        <!-- 发票信息 start-->
        <div class="receipt">
          <h3>
            发票信息
            <a href="javascript:;" id="receipt_modify">[修改]</a>
          </h3>
          <div class="receipt_info">
            <p>个人发票</p>
            <p>内容：明细</p>
          </div>

          <div class="receipt_select none">
            <form action>
              <ul>
                <li>
                  <label for>发票抬头：</label>
                  <input type="radio" name="type" checked="checked" class="personal" />个人
                  <input type="radio" name="type" class="company" />单位
                  <input type="text" class="txt company_input" disabled="disabled" />
                </li>
                <li>
                  <label for>发票内容：</label>
                  <input type="radio" name="content" checked="checked" />明细
                  <input type="radio" name="content" />办公用品
                  <input type="radio" name="content" />体育休闲
                  <input type="radio" name="content" />耗材
                </li>
              </ul>
            </form>
            <a href class="confirm_btn">
              <span>确认发票信息</span>
            </a>
          </div>
        </div>
        <!-- 发票信息 end-->

        <!-- 商品清单 start -->
        <div class="goods">
          <h3>商品清单</h3>
          <table>
            <thead>
              <tr>
                <th class="col1">商品</th>
                <th class="col2">规格</th>
                <th class="col3">价格</th>
                <th class="col4">数量</th>
                <th class="col5">小计</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(item,index) in cart" :key="index">
                <td class="col1">
                  <a href>
                    <img :src="item.midlogo" alt />
                  </a>
                  <strong>
                    <a href>{{item.goods_name}}</a>
                  </strong>
                </td>
                <td class="col2">
                  <p v-for="(value,key,index) in item.spec_info_id_txt" :key="index">{{key}}:{{value}}</p>
                  <p>尺码：170/92A/S</p>
                </td>
                <td class="col3">￥{{item.price}}</td>
                <td class="col4">{{item.count}}</td>
                <td class="col5">
                  <span>￥{{item.price*item.count}}</span>
                </td>
              </tr>

            </tbody>
            <tfoot>
              <tr>
                <td colspan="5">
                  <ul>
                    <li>
                      <span>4 件商品，总商品金额：</span>
                      <em>￥{{totalPrice}}</em>
                    </li>
                    <li>
                      <span>返现：</span>
                      <em>-￥240.00</em>
                    </li>
                    <li>
                      <span>运费：</span>
                      <em>￥10.00</em>
                    </li>
                    <li>
                      <span>应付总额：</span>
                      <em>￥5076.00</em>
                    </li>
                  </ul>
                </td>
              </tr>
            </tfoot>
          </table>
        </div>
        <!-- 商品清单 end -->
      </div>

      <div class="fillin_ft">
        <a href>
          <span>提交订单</span>
        </a>
        <p>
          应付总额：
          <strong>￥5076.00元</strong>
        </p>
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
import TopNav from "~/components/TopNav.vue";
import Foot from "~/components/Foot.vue";
export default {
  head: {
    title: "订单核对页面",
    link: [
        { rel: "stylesheet", href: "/style/fillin.css"},
        ],
    script: [{ type: "text/javascript", src: "/js/cart2.js" }]
  },
  components: {
    TopNav,
    Foot
  },
  data() {
    return {
      addressList: [], //所有收货人
      defaultAddress: {}, //默认收获人
      newAddress: {         //新地址
      'shr_name': '',
      'shr_mobile': '',
      'shr_province': '',
      'shr_city': '',
      'shr_area': '',
      'shr_address': ''
      },
      cart:[],//勾选的购物车中的数据
    };
  },
  methods: {
    //查询所有的地址
    async findAllAddress(){
          //查询收获人
        let { data } =await this.$request.getAddress();
        this.addressList = data.data;

        let defArr = this.addressList.filter(item => {
          if(item.isdefault == 1){
              return item
          }
        });
        console.warn(defArr);
      this.defaultAddress = defArr[0];
        console.warn(this.addressList);
    },
    //添加地址
    async addAddressFn(){
      let {data} = await this.$request.addAddress(this.newAddress);
      //如果成功显示 更新数据
      if(data.code == 1){
        this.findAllAddress();
        //清空表单
        this.newAddress = {};
      }

    }
  },
  async  mounted() {
     this.findAllAddress();
     //查询购物车 , 并且过滤选中的信息
     let {data} = await this.$request.getCart();
     this.cart = data.data.filter(item=>item.checked);
     console.warn(this.cart );

     
  },
  computed: {
    totalPrice(){
      let sum = 0;
       //遍历，求所有小计的和
      this.cart.forEach(item=>{
        sum += (item.price * item.count)
      })

      return sum
    }
  },
}
</script>

<style>
</style>