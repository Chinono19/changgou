<template>
  <div>
    <!-- 顶部导航 start -->
    <TopNav></TopNav>
    <!-- 顶部导航 end -->
    <div style="clear:both;"></div>

    <!-- 页面头部 start -->
    <Header></Header>
    <!-- 页面头部 end -->

    <!-- 登录主体部分start -->
    <div class="login w990 bc mt10 regist">
      <div class="login_hd">
        <h2>用户注册</h2>
        <b></b>
      </div>
      <div class="login_bd">
        <div class="login_form fl">
          <form action method="post">
            <ul>
              <li>
                <label for>用户名：</label>
                <input
                  type="text"
                  class="txt"
                  @blur="checkUsernameFn"
                  name="username"
                  v-model="user.username"
                />
                <p>3-20位字符，可由中文、字母、数字和下划线组成</p>

                <p class="success" v-if="user.userObj.code == 1">{{user.userObj.message}}</p>
                <p class="error" v-else>{{user.userObj.message}}</p>
              </li>
              <li>
                <label for>密码：</label>
                <input type="password" v-model="user.password" class="txt" name="password" />
                <p>6-20位字符，可使用字母、数字和符号的组合，不建议使用纯数字、纯字母、纯符号</p>
              </li>
              <li>
                <label for>确认密码：</label>
                <input type="password"  v-model="user.repassword"  class="txt" name="password" />
                <p>请再次输入密码</p>
              </li>
              <li>
                <label for>手机号码：</label>
                <input
                  type="text"
                  class="txt"
                  name="mobile"
                  v-model="user.mobile"
                  @blur="checkPhone"
                />

                <p class="success" v-if="user.phoneObj.code == 1">{{user.phoneObj.message}}</p>
                <p class="error" v-else>{{user.phoneObj.message}}</p>
              </li>
              <li class="checkcode">
                <label for>验证码：</label>
                <input type="text" v-model="user.code" name="checkcode" />
                <button :disabled="btnDisabled" @click="sendSms">
                  发送验证码
                  <span v-if="btnDisabled">{{seconds}}秒</span>
                </button>
                <p class="error">{{userMsg.code.message}}</p>
              </li>
              <li>
                <label for>&nbsp;</label>
                <input type="checkbox" class="chb" checked="checked" /> 我已阅读并同意《用户注册协议》
              </li>
              <li>
                <label for>&nbsp;</label>
                <input type="submit" value @click.prevent="registerFn" class="login_btn" />
              </li>
            </ul>
          </form>
        </div>

        <div class="mobile fl">
          <h3>手机快速注册</h3>
          <p>
            中国大陆手机用户，编辑短信 “
            <strong>XX</strong>”发送到：
          </p>
          <p>
            <strong>1069099988</strong>
          </p>
        </div>
      </div>
    </div>
    <!-- 登录主体部分end -->

    <div style="clear:both;"></div>
    <!-- 底部版权 start -->
    <Foot></Foot>
    <!-- 底部版权 end -->
  </div>
</template>

<script>
import TopNav from "~/components/TopNav";
import Header from "~/components/Header";
import Foot from "~/components/Foot";
export default {
  head: {
    title: "用户注册",
    link: [{ rel: "stylesheet", href: "style/login.css" }]
  },
  components: {
    TopNav,
    Header,
    Foot
  },
  data() {
    return {
      user: {
        userObj: {},
        phoneObj: {},
        username: "",
        mobile: ""
      },
      userMsg:{code:''},
      btnDisabled:false,
      seconds:5,
      timer:null,
    };
  },
  methods: {
    async checkUsernameFn() {
      let { data } = await this.$request.checkUsername(this.user);
      console.warn(data);
      this.user.userObj = data;
    },
    async checkPhone() {
      let { data } = await this.$request.checkPhone(this.user.phone);
      console.warn(data);
      this.user.phoneObj = data;
    },
    //发送验证码 
    async sendSms() {
      if (!this.user.username){
        this.user.userObj.code = 0;
        this.user.userObj.message = "用户名不能为空";
      }
       if (!this.user.mobile){
        this.user.userObj.code = 0;
        this.user.phoneObj.message = "手机号不能为空!";
      }
      // 倒计时 start ---
      this.btnDisabled = true; //设置按钮不可用
      this.timer = setInterval(()=>{
        if(this.seconds <= 1){
          this.seconds =5;
          this.btnDisabled = false;
          //清除定时器
          clearInterval(this.timer);
        }else{
          this.seconds --;
        }
      },1000)
      //倒计时 end --


      let {data}  = await this.$request.sendSms(this.user);
      console.warn(data);
    },
    //注册
    async registerFn(){
       let {data} = await this.$request.register(this.user);
       if(data.code ==1){
         this.$router.push('/Login');
       }else{
         this.userMsg.code = data;
       }
    }
  }
};
</script>

<style>
</style>