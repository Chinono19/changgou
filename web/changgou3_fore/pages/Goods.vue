<template>
  <div>
    <!-- 顶部导航 start -->
    <IndexHeader :isFirst="false" :list="categoryList"></IndexHeader>

    <!-- end -->

    <!-- 商品页面主体 start -->
    <div class="main w1210 mt10 bc">
      <!-- 面包屑导航 start -->
      <div class="breadcrumb">
        <h2>
          当前位置：
          <a href>{{goodsInfo.cat1_info.catName}}</a> >
          <a href>{{goodsInfo.cat2_info.catName}}</a> >
          <a href>{{goodsInfo.cat3_info.catName}}</a>
          >
          {{goodsInfo.goods_name}}
        </h2>
      </div>
      <!-- 面包屑导航 end -->

      <!-- 主体页面左侧内容 start -->
      <div class="goods_left fl">
        <!-- 相关分类 start -->
        <div class="related_cat leftbar mt10">
          <h2>
            <strong>相关分类</strong>
          </h2>
          <div class="leftbar_wrap">
            <ul>
              <li>
                <a href>笔记本</a>
              </li>
              <li>
                <a href>超极本</a>
              </li>
              <li>
                <a href>平板电脑</a>
              </li>
            </ul>
          </div>
        </div>
        <!-- 相关分类 end -->

        <!-- 相关品牌 start -->
        <div class="related_cat leftbar mt10">
          <h2>
            <strong>同类品牌</strong>
          </h2>
          <div class="leftbar_wrap">
            <ul>
              <li>
                <a href>D-Link</a>
              </li>
              <li>
                <a href>戴尔</a>
              </li>
              <li>
                <a href>惠普</a>
              </li>
              <li>
                <a href>苹果</a>
              </li>
              <li>
                <a href>华硕</a>
              </li>
              <li>
                <a href>宏基</a>
              </li>
              <li>
                <a href>神舟</a>
              </li>
            </ul>
          </div>
        </div>
        <!-- 相关品牌 end -->

        <!-- 热销排行 start -->
        <div class="hotgoods leftbar mt10">
          <h2>
            <strong>热销排行榜</strong>
          </h2>
          <div class="leftbar_wrap">
            <ul>
              <li></li>
            </ul>
          </div>
        </div>
        <!-- 热销排行 end -->

        <!-- 浏览过该商品的人还浏览了  start 注：因为和list页面newgoods样式相同，故加入了该class -->
        <div class="related_view newgoods leftbar mt10">
          <h2>
            <strong>浏览了该商品的用户还浏览了</strong>
          </h2>
          <div class="leftbar_wrap">
            <ul>
              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="images/relate_view1.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a href>ThinkPad E431(62771A7) 14英寸笔记本电脑 (i5-3230 4G 1TB 2G独显 蓝牙 win8)</a>
                  </dd>
                  <dd>
                    <strong>￥5199.00</strong>
                  </dd>
                </dl>
              </li>

              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="images/relate_view2.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a
                      href
                    >ThinkPad X230i(2306-3V9） 12.5英寸笔记本电脑 （i3-3120M 4GB 500GB 7200转 蓝牙 摄像头 Win8）</a>
                  </dd>
                  <dd>
                    <strong>￥5199.00</strong>
                  </dd>
                </dl>
              </li>

              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="images/relate_view3.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a
                      href
                    >T联想（Lenovo） Yoga13 II-Pro 13.3英寸超极本 （i5-4200U 4G 128G固态硬盘 摄像头 蓝牙 Win8）晧月银</a>
                  </dd>
                  <dd>
                    <strong>￥7999.00</strong>
                  </dd>
                </dl>
              </li>

              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="images/relate_view4.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a href>联想（Lenovo） Y510p 15.6英寸笔记本电脑（i5-4200M 4G 1T 2G独显 摄像头 DVD刻录 Win8）黑色</a>
                  </dd>
                  <dd>
                    <strong>￥6199.00</strong>
                  </dd>
                </dl>
              </li>

              <li class="last">
                <dl>
                  <dt>
                    <a href>
                      <img src="images/relate_view5.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a
                      href
                    >ThinkPad E530c(33662D0) 15.6英寸笔记本电脑 （i5-3210M 4G 500G NV610M 1G独显 摄像头 Win8）</a>
                  </dd>
                  <dd>
                    <strong>￥4399.00</strong>
                  </dd>
                </dl>
              </li>
            </ul>
          </div>
        </div>
        <!-- 浏览过该商品的人还浏览了  end -->

        <!-- 最近浏览 start -->
        <div class="viewd leftbar mt10">
          <h2>
            <a href>清空</a>
            <strong>最近浏览过的商品</strong>
          </h2>
          <div class="leftbar_wrap">
            <dl>
              <dt>
                <a href>
                  <img src="images/hpG4.jpg" alt />
                </a>
              </dt>
              <dd>
                <a href>惠普G4-1332TX 14英寸笔记...</a>
              </dd>
            </dl>

            <dl class="last">
              <dt>
                <a href>
                  <img src="images/crazy4.jpg" alt />
                </a>
              </dt>
              <dd>
                <a href>直降200元！TCL正1.5匹空调</a>
              </dd>
            </dl>
          </div>
        </div>
        <!-- 最近浏览 end -->
      </div>
      <!-- 主体页面左侧内容 end -->

      <!-- 商品信息内容 start -->
      <div class="goods_content fl mt10 ml10">
        <!-- 商品概要信息 start -->
        <div class="summary">
          <h3>
            <strong>ThinkPad X230(23063T4）12.5英寸笔记本（i5-3230M 8GB 500G HD4000 指纹蓝牙 WIN8PRC 一年质保）</strong>
          </h3>

          <!-- 图片预览区域 start -->
          <div class="preview fl">
            <div class="midpic">
              <a :href="goodsInfo.logo.xbiglogo" class="jqzoom" rel="gal1">
                <!-- 第一幅图片的大图 class 和 rel属性不能更改 -->
                <img :src="goodsInfo.logo.biglogo" alt />
                <!-- 第一幅图片的中图 -->
              </a>
            </div>

            <!--使用说明：此处的预览图效果有三种类型的图片，大图，中图，和小图，取得图片之后，分配到模板的时候，把第一幅图片分配到 上面的midpic 中，其中大图分配到 a 标签的href属性，中图分配到 img 的src上。 下面的smallpic 则表示小图区域，格式固定，在 a 标签的 rel属性中，分别指定了中图（smallimage）和大图（largeimage），img标签则显示小图，按此格式循环生成即可，但在第一个li上，要加上cur类，同时在第一个li 的a标签中，添加类 zoomThumbActive  -->

            <div class="smallpic">
              <a href="javascript:;" id="backward" class="off"></a>
              <a href="javascript:;" id="forward" class="on"></a>
              <div class="smallpic_wrap">
                <ul>
                  <li class="cur">
                    <a
                      class="zoomThumbActive"
                      href="javascript:void(0);"
                      :rel="{gallery: 'gal1', smallimage: '${goodsInfo.logo.smlogo}',largeimage: '${goodsInfo.logo.xbiglogo}'}"
                    >
                      <img :src="goodsInfo.logo.biglogo" />
                    </a>
                  </li>
                  <li v-for="(p,index) in goodsInfo.photos" :key="index">
                    <a
                      href="javascript:void(0);"
                      :rel="{gallery: 'gal1', smallimage: '${p.sming}',largeimage: '${p.xbigimg}'}"
                    >
                      <img :src="p.bigimg" />
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <!-- 图片预览区域 end -->

          <!-- 商品基本信息区域 start -->
          <div class="goodsinfo fl ml10">
            <ul>
              <li>
                <span>商品编号：</span>
                {{goodsInfo.skuid}}
              </li>
              <li class="market_price">
                <span>定价：</span>
                <em>￥{{goodsInfo.price * 1.2}}</em>
              </li>
              <li class="shop_price">
                <span>本店价：</span>
                <strong>￥{{goodsInfo.price}}</strong>
                <a href>(降价通知)</a>
              </li>
              <li>
                <span>上架时间：</span>
                {{goodsInfo.on_sale_date}}
              </li>
              <li :class="['star', 'star' + parseInt(goodsInfo.comment_level)]">
                <span>商品评分：</span>
                <strong></strong>
                <a href>(已有{{goodsInfo.comment_count}}人评价)</a>
              </li>
              
              <!-- 此处的星级切换css即可 默认为5星 star4 表示4星 star3 表示3星 star2表示2星 star1表示1星 -->
            </ul>
            <form action="flow1.html" method="post" class="choose">
              <ul>
                <li class="product" v-for="(spec,index) in goodsInfo.spec_list" :key="index">
                  <dl>
                    <dt>{{spec.specName}}:</dt>
                    <dd>
                      <a
                        v-for="(opt,optIndex) in spec.options"
                        :key="optIndex"
                        href="javascript:;"
                        :class="{'selected':goodsInfo.spec_info.id_list.indexOf(spec.id + ':' + opt.id) != -1}"
                        @click="selectSpec(spec.id, opt.id)"
                      >
                        {{opt.optionName}}
                        <input
                          type="radio"
                          name="color"
                          :value="opt.optionName"
                          checked="checked"
                        />
                      </a>

                      <input type="hidden" name value />
                    </dd>
                  </dl>
                </li>

                <li>
								<dl>
									<dt>购买数量：</dt>
									<dd>
										<a href="javascript:;" id="reduce_num"></a>
										<input type="text" name="amount" v-model="count" class="amount"/>
										<a href="javascript:;" id="add_num"></a>
									</dd>
								</dl>
							</li>

							<li>
								<dl>
									<dt>&nbsp;</dt>
									<dd>
										<input type="submit" value="" class="add_btn" @click.prevent="addToCartFn" />
									</dd>
								</dl>
							</li>
              </ul>
            </form>
          </div>
          <!-- 商品基本信息区域 end -->
        </div>
        <!-- 商品概要信息 end -->

        <div style="clear:both;"></div>

        <!-- 商品详情 start -->
        <div class="detail">
          <div class="detail_hd">
            <ul>
              <li class="first">
                <span>商品介绍</span>
              </li>
              <li class="on">
                <span>商品评价</span>
              </li>
              <li>
                <span>售后保障</span>
              </li>
            </ul>
          </div>
          <div class="detail_bd">
            <!-- 商品介绍 start -->
            <div class="introduce detail_div none">
              <div class="attr mt15">
                <ul>
                  <li>
                    <span>商品名称：</span>ThinkPadX230(2306 3T4）
                  </li>
                  <li>
                    <span>商品编号：</span>979631
                  </li>
                  <li>
                    <span>品牌：</span>联想（Thinkpad）
                  </li>
                  <li>
                    <span>上架时间：</span>2013-09-18 17:58:12
                  </li>
                  <li>
                    <span>商品毛重：</span>2.47kg
                  </li>
                  <li>
                    <span>商品产地：</span>中国大陆
                  </li>
                  <li>
                    <span>显卡：</span>集成显卡
                  </li>
                  <li>
                    <span>触控：</span>非触控
                  </li>
                  <li>
                    <span>厚度：</span>正常厚度（>25mm）
                  </li>
                  <li>
                    <span>处理器：</span>Intel i5
                  </li>
                  <li>
                    <span>尺寸：</span>12英寸
                  </li>
                </ul>
              </div>

              <div class="desc mt10">
                <!-- 此处的内容 一般是通过在线编辑器添加保存到数据库，然后直接从数据库中读出 -->
                <img src="images/desc1.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc2.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc3.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc4.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc5.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc6.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc7.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc8.jpg" alt />
                <p style="height:10px;"></p>
                <img src="images/desc9.jpg" alt />
              </div>
            </div>
            <!-- 商品介绍 end -->

            <!-- 商品评论 start -->
            <div class="comment detail_div mt10">
              <div class="comment_summary">
                <div class="rate fl">
                  <strong>
                    <em>{{commentResult.ratio.goods}}</em>%
                  </strong>
                  <br />
                  <span>好评度</span>
                </div>
                <div class="percent fl">
                  <dl>
                    <dt>好评（{{commentResult.ratio.goods}}%）</dt>
                    <dd>
                      <div style="width:90px;"></div>
                    </dd>
                  </dl>
                  <dl>
                    <dt>中评（{{commentResult.ratio.common}}%）</dt>
                    <dd>
                      <div style="width:5px;"></div>
                    </dd>
                  </dl>
                  <dl>
                    <dt>差评（{{commentResult.ratio.bad}}%）</dt>
                    <dd>
                      <div style="width:5px;"></div>
                    </dd>
                  </dl>
                </div>
                <div class="buyer fl">
                  <dl>
                    <dt>买家印象：</dt>
                    <dd v-for="(imp,index) in commentResult.impressions" :key="index">
                      <span>{{imp.title}}</span>
                      <em>({{imp.count}})</em>
                    </dd>
                  </dl>
                </div>
              </div>
  			<!-- 评论列表 -->
              <div class="comment_items mt10"  v-for="(comment,index) in commentResult.comments" :key="index">
                <div class="user_pic">
                  <dl>
                    <dt>
                      <a href>
                        <img :src="comment.user.face" alt />
                      </a>
                    </dt>
                    <dd>
                      <a href>{{comment.user.username}}</a>
                    </dd>
                  </dl>
                </div>
                <div class="item">
                  <div class="title">
                    <span>{{comment.createdAt}}</span>
                    <strong :class="['star', 'star' + comment.star]"></strong>
                    <!-- star5表示5星级 start4表示4星级，以此类推 -->
                  </div>
                  <div class="comment_content">
                   {{comment.content}}
                  </div>
                  <div class="btns">
                    <a href class="reply">回复(0)</a>
                    <a href class="useful">有用(0)</a>
                  </div>
                </div>
                <div class="cornor"></div>
              </div>
			  <!-- 评论列表 -->


             <!-- 分页信息 start -->
  <Pagination :total="commentResult.comment_count"
	:page_size="2"
	@page_changed="findCommentsFn">
  </Pagination>
  <!-- 分页信息 end -->

              <!--  评论表单 start-->
              <div class="comment_form mt20">
                <form action>
                  <ul>
                    <li>
                      <label for>评分：</label>
                      <input type="radio" name="grade" />
                      <strong class="star star5"></strong>
                      <input type="radio" name="grade" />
                      <strong class="star star4"></strong>
                      <input type="radio" name="grade" />
                      <strong class="star star3"></strong>
                      <input type="radio" name="grade" />
                      <strong class="star star2"></strong>
                      <input type="radio" name="grade" />
                      <strong class="star star1"></strong>
                    </li>

                    <li>
                      <label for>评价内容：</label>
                      <textarea name id cols rows></textarea>
                    </li>
                    <li>
                      <label for>&nbsp;</label>
                      <input type="submit" value="提交评论" class="comment_btn" />
                    </li>
                  </ul>
                </form>
              </div>
              <!--  评论表单 end-->
            </div>
            <!-- 商品评论 end -->

            <!-- 售后保障 start -->
            <div class="after_sale mt15 none detail_div">
              <div>
                <p>
                  本产品全国联保，享受三包服务，质保期为：一年质保
                  <br />如因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！
                </p>
                <p>
                  售后服务电话：800-898-9006
                  <br />品牌官方网站：http://www.lenovo.com.cn/
                </p>
              </div>

              <div>
                <h3>服务承诺：</h3>
                <p>本商城向您保证所售商品均为正品行货，京东自营商品自带机打发票，与商品一起寄送。凭质保证书及京东商城发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由本商城联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。本商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

                <p>注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！</p>
              </div>

              <div>
                <h3>权利声明：</h3>
                <p>本商城上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是京东商城重要的经营资源，未经许可，禁止非法转载使用。</p>
                <p>注：本站商品信息均来自于厂商，其真实性、准确性和合法性由信息拥有者（厂商）负责。本站不提供任何保证，并不承担任何法律责任。</p>
              </div>
            </div>
            <!-- 售后保障 end -->
          </div>
        </div>
        <!-- 商品详情 end -->
      </div>
      <!-- 商品信息内容 end -->
    </div>
    <!-- 商品页面主体 end -->

    <div style="clear:both;"></div>

    <!-- 底部导航 start -->

    <Bottomnav></Bottomnav>
    <!-- 底部导航 end -->

    <div style="clear:both;"></div>
    <!-- 底部版权 start -->
    <Foot></Foot>
    <!-- 底部版权 end -->

    <script type="text/javascript">
  document.execCommand("BackgroundImageCache", false, true);
    </script>
  </div>
</template>

<script>
import IndexHeader from "~/components/IndexHeader";
import Foot from "~/components/Foot.vue";
import Bottomnav from "~/components/Bottomnav";
import Pagination from '~/components/Pagination';
export default {
  head: {
    title: "详情页",
    link: [
      { rel: "stylesheet", href: "/style/goods.css" },
      { rel: "stylesheet", href: "/style/common.css" },
      { rel: "stylesheet", href: "/style/bottomnav.css" },
      { rel: "stylesheet", href: "/style/jqzoom.css" }
    ],
    script: [
      { type: "text/javascript", src: "/js/header.js" },
      { type: "text/javascript", src: "/js/goods.js" },
      { type: "text/javascript", src: "/js/jqzoom-core.js" }
    ]
  },
  data() {
    return {
      categoryList: [],
      commentResult: {
        ratio: {}
      }, //评论查询结果
      count:1,
    };
  },
  components: {
    IndexHeader,
    Foot,
	Bottomnav,
	Pagination
  },
  methods: {
    //切换规格
    selectSpec(specId, optId) {
      //重新组合
      let id_list_arr = this.goodsInfo.spec_info.id_list.split("|");
      let newArr = [];
      for (let i = 0; i < id_list_arr.length; i++) {
        let ids = id_list_arr[i];
        let ids_arr = ids.split(":");
        if (specId == ids_arr[0]) {
          newArr.push(specId + ":" + optId);
        } else {
          newArr.push(ids);
        }
      }
      let new_id_list = newArr.join("|");
      console.warn(new_id_list);

      //获得skuid
      let skuid = "";
      for (let i = 0; i < this.goodsInfo.sku_list.length; i++) {
        let obj = this.goodsInfo.sku_list[i];
        if (new_id_list == obj.id_list) {
          skuid = obj.skuid;
          break;
        }
      }

      //如果skuid不存在,表示数据有问题,不跳转
      if (!skuid) {
        skuid = this.goodsInfo.skuid;
      }

      //重新加载,跳转当前页面
      location.href = "/goods?id=" + skuid;
    },
    //查询所有的评论
    async findCommentsFn(pageNum) {
      let spuId = this.goodsInfo.spuid;
      let pageSize = 2;
      let { data } = await this.$request.findComments(spuId, pageNum, pageSize);
      this.commentResult = data.data;
      console.warn(this.commentResult);
    },
    //添加到购物车
    async addToCartFn(){
      console.warn("add");
      //准备数据
      let params = {
        skuid:this.goodsInfo.skuid,
        count:this.count,
        checked:true
      }
      //发送ajax
      let {data} = await this.$request.addToCart(params);
      console.warn(data);
      
      //处理结果
      if(data.code == 1){
        console.warn("添加成功");
        location.href="/flow1"
      }else{
        alert("添加失败")
        //这就是用户没有登录
        let cartItem = {
          skuid:this.goodsInfo.skuid,
          spuid:this.goodsInfo.spuid,
          goods_name:this.goodsInfo.goods_name,
          price:this.goodsInfo.price,
          count:this.count,
          checked:true,
          midlogo: this.goodsInfo.logo.biglogo,
          spec_info_id_txt: JSON.parse(this.goodsInfo.spec_info_id_txt),
        }
        let cartStr = localStorage.getItem("cart");
        let cart = JSON.parse(cartStr);
        if(!cart){
          cart = []
        }
        //把准备的数据添加到购物车中
         let tempArr = cart.filter( item => item.skuid == cartItem.skuid)
         if(tempArr.length == 0){
           cart.push(cartItem)
         }else{
             //  如果商品购物车已有，数量累加
            cart.forEach( item => {
            if(item.skuid == cartItem.skuid){
              item.count += parseInt(cartItem.count)
            }
          })
         }
         //把购物车保存到localStorage中去
         localStorage.setItem("cart",JSON.stringify(cart));
         //跳转到购物车列表页面
         location.href = '/flow1'
      }
      
    }
  },
  mounted() {
    // 页面加载成功 图片放大效果
    $(function() {
      $(".jqzoom").jqzoom({
        zoomType: "standard",
        lens: true,
        preloadImages: false,
        alwaysOn: false,
        title: false,
        zoomWidth: 400,
        zoomHeight: 400
      });
    });

    //查询评论
    this.findCommentsFn(1);
  },
  async asyncData({ app, query }) {
    //获取请求的参数
    let skuId = query.id;
    let [{ data: categoryData }, { data: goodsData }] = await Promise.all([
      app.$request.findAllCategory(),
      app.$request.getGoodsInfo(skuId)
    ]);
    return {
      categoryList: categoryData.data,
      goodsInfo: goodsData.data
    };
  }
};
</script>

<style>
.midpic img {
  width: 100%;
}
</style>