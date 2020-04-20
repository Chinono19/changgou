<template>
  <div>
    <IndexHeader :isFirst="false" :list="categoryList"></IndexHeader>
    <!-- 列表主体 start -->
    <div class="list w1210 bc mt10">
      <!-- 面包屑导航 start -->
      <div class="breadcrumb">
        <h2>
          当前位置：
          <a href>首页</a> >
          <a href>电脑、办公</a>
        </h2>
      </div>
      <!-- 面包屑导航 end -->

      <!-- 左侧内容 start -->
      <div class="list_left fl mt10">
        <!-- 分类列表 start -->
        <div class="catlist">
          <h2>电脑、办公</h2>
          <div class="catlist_wrap">
            <div class="child">
              <h3 class="on">
                <b></b>电脑整机
              </h3>
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

          <div style="clear:both; height:1px;"></div>
        </div>
        <!-- 分类列表 end -->

        <div style="clear:both;"></div>

        <!-- 新品推荐 start -->
        <div class="newgoods leftbar mt10">
          <h2>
            <strong>新品推荐</strong>
          </h2>
          <div class="leftbar_wrap">
            <ul>
              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="/images/list_hot1.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a href>美即流金丝语悦白美颜新年装4送3</a>
                  </dd>
                  <dd>
                    <strong>￥777.50</strong>
                  </dd>
                </dl>
              </li>

              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="/images/list_hot2.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a href>领券满399减50 金斯利安多维片</a>
                  </dd>
                  <dd>
                    <strong>￥239.00</strong>
                  </dd>
                </dl>
              </li>

              <li class="last">
                <dl>
                  <dt>
                    <a href>
                      <img src="/images/list_hot3.jpg" alt />
                    </a>
                  </dt>
                  <dd>
                    <a href>皮尔卡丹pierrecardin 男士长...</a>
                  </dd>
                  <dd>
                    <strong>￥1240.50</strong>
                  </dd>
                </dl>
              </li>
            </ul>
          </div>
        </div>
        <!-- 新品推荐 end -->

        <!--热销排行 start -->
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
        <!--热销排行 end -->

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
                  <img src="/images/hpG4.jpg" alt />
                </a>
              </dt>
              <dd>
                <a href>惠普G4-1332TX 14英寸笔记...</a>
              </dd>
            </dl>

            <dl class="last">
              <dt>
                <a href>
                  <img src="/images/crazy4.jpg" alt />
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
      <!-- 左侧内容 end -->

      <!-- 列表内容 start -->
      <div class="list_bd fl ml10 mt10">
        <!-- 热卖、促销 start -->
        <div class="list_top">
          <!-- 热卖推荐 start -->
          <div class="hotsale fl">
            <h2>
              <strong>
                <span class="none">热卖推荐</span>
              </strong>
            </h2>
            <ul>
              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="/images/hpG4.jpg" alt />
                    </a>
                  </dt>
                  <dd class="name">
                    <a href>惠普G4-1332TX 14英寸笔记本电脑 （i5-2450M 2G 5</a>
                  </dd>
                  <dd class="price">
                    特价：
                    <strong>￥2999.00</strong>
                  </dd>
                  <dd class="buy">
                    <span>立即抢购</span>
                  </dd>
                </dl>
              </li>

              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="/images/list_hot3.jpg" alt />
                    </a>
                  </dt>
                  <dd class="name">
                    <a href>ThinkPad E42014英寸笔记本电脑</a>
                  </dd>
                  <dd class="price">
                    特价：
                    <strong>￥4199.00</strong>
                  </dd>
                  <dd class="buy">
                    <span>立即抢购</span>
                  </dd>
                </dl>
              </li>

              <li>
                <dl>
                  <dt>
                    <a href>
                      <img src="/images/acer4739.jpg" alt />
                    </a>
                  </dt>
                  <dd class="name">
                    <a href>宏碁AS4739-382G32Mnkk 14英寸笔记本电脑</a>
                  </dd>
                  <dd class="price">
                    特价：
                    <strong>￥2799.00</strong>
                  </dd>
                  <dd class="buy">
                    <span>立即抢购</span>
                  </dd>
                </dl>
              </li>
            </ul>
          </div>
          <!-- 热卖推荐 end -->

          <!-- 促销活动 start -->
          <div class="promote fl">
            <h2>
              <strong>
                <span class="none">促销活动</span>
              </strong>
            </h2>
            <ul>
              <li>
                <b>.</b>
                <a href>DIY装机之向雷锋同志学习！</a>
              </li>
              <li>
                <b>.</b>
                <a href>京东宏碁联合促销送好礼！</a>
              </li>
              <li>
                <b>.</b>
                <a href>台式机笔记本三月巨惠！</a>
              </li>
              <li>
                <b>.</b>
                <a href>富勒A53g智能人手识别鼠标</a>
              </li>
              <li>
                <b>.</b>
                <a href>希捷硬盘白色情人节专场</a>
              </li>
            </ul>
          </div>
          <!-- 促销活动 end -->
        </div>
        <!-- 热卖、促销 end -->

        <div style="clear:both;"></div>

        <!-- 商品筛选 start -->
        <div class="filter mt10">
          <h2>
            <a href>重置筛选条件</a>
            <strong>商品筛选</strong>
          </h2>
          <div class="filter_wrap">
            <dl>
              <dt>品牌：</dt>
              <dd :class="{'cur':searchMap.brandId == ''}">
                <a href>不限</a>
              </dd>
              <dd
                :class="{'cur':searchMap.brandId == brand.id}"
                v-for="(brand,index) in brandList"
                :key="index"
              >
                <a href @click.prevent="brandSearch(brand.id)">{{brand.brandName}}</a>
              </dd>
            </dl>
            <!-- 规格 start  -->
            <dl v-for="(spec,index) in specList" :key="index">
              <dt>{{spec.specName}}</dt>
              <dd class="cur">
                <a href @click.prevent="specSearch(spec.specName,null,$event)">不限</a>
              </dd>
              <dd v-for="(opt,indexOpt) in spec.options" :key="indexOpt">
                <a
                  href
                  @click.prevent="specSearch(spec.specName,opt.optionName,$event)"
                >{{opt.optionName}}</a>
              </dd>
            </dl>
            <!-- 规格end  -->
          </div>
        </div>
        <!-- 商品筛选 end -->

        <div style="clear:both;"></div>

        <!-- 排序 start -->
        <div class="sort mt10">
          <dl>
            <dt>排序：</dt>
            <dd :class="{'cur':this.searchMap.sortBy == 'xl'}">
              <a href @click.prevent="sortSearch('xl')">销量</a>
            </dd>
            <dd :class="{'cur':this.searchMap.sortBy == 'jg'}">
              <a href @click.prevent="sortSearch('jg')">
                价格
                <span
                  v-if="this.searchMap.sortBy=='jg' 
                && this.searchMap.sortWay=='asc'"
                >↑</span>
                <span
                  v-if="this.searchMap.sortBy=='jg' 
                && this.searchMap.sortWay=='desc'"
                >↓</span>
              </a>
            </dd>
            <dd :class="{'cur':this.searchMap.sortBy == 'pl'}">
              <a href @click.prevent="sortSearch('pl')">评论数</a>
            </dd>
            <dd :class="{'cur':this.searchMap.sortBy == 'sj'}">
              <a href @click.prevent="sortSearch('sj')">上架时间</a>
            </dd>
          </dl>
          <input type="text" style="width:80px" v-model="searchMap.minPrice" /> -
          <input type="text" style="width:80px" v-model="searchMap.maxPrice" />
          <input type="button" value="查询" @click="searchList" />
        </div>
        <!-- 排序 end -->

        <div style="clear:both;"></div>

        <!-- 商品列表 start-->
        <div class="goodslist mt10">
          <ul>
            <li v-for="(sku,index) in searchResult.list" :key="index">
              <dl>
                <dt>
                  <a href>
                    <img :src="sku.midlogo" alt />
                  </a>
                </dt>
                <dd>
                  <a href class="goodsname">{{sku.goodsName}}</a>
                </dd>
                <dd>
                  <strong>￥{{sku.price}}</strong>
                </dd>
                <dd>
                  <a href>
                    <em>已有{{sku.commentCount}}人评价</em>
                  </a>
                </dd>
              </dl>
            </li>
          </ul>
        </div>
        <!-- 商品列表 end-->

        <!-- 分页信息 start -->
        <div class="page mt20">
          <!-- <a href>首页</a>
          <a href>上一页</a>
          <a href>1</a>
          <a href>2</a>
          <a href class="cur">3</a>
          <a href>4</a>
          <a href>5</a>
          <a href>下一页</a>
          <a href>尾页</a>&nbsp;&nbsp;
          <span>
            <em>
              共8页&nbsp;&nbsp;到第
              <input type="text" class="page_num" value="3" /> 页
            </em>
            <a href="#" class="skipsearch">确定</a>
          </span> -->
        <Pagination :total="searchResult.count"
  :page_size="searchMap.pageSize"
  @page_changed="pageChanged">
</Pagination>
        </div>
        <!-- 分页信息 end -->
      </div>
      <!-- 列表内容 end -->
    </div>
    <!-- 列表主体 end-->

    <Bottomnav></Bottomnav>
    <Foot></Foot>
  </div>
</template>

<script>
import IndexHeader from "~/components/IndexHeader";
import Foot from "~/components/Foot.vue";
import Bottomnav from "~/components/Bottomnav";
import Pagination from '~/components/Pagination'

export default {
  head: {
    title: "搜索页面",
    link: [
      { rel: "stylesheet", href: "/style/list.css" },
      { rel: "stylesheet", href: "/style/common.css" },
      { rel: "stylesheet", href: "/style/bottomnav.css" }
    ],
    script: [
      { type: "text/javascript", src: "/js/header.js" },
      { type: "text/javascript", src: "/js/list.js" }
    ]
  },
  components: {
    IndexHeader,
    Foot,
    Bottomnav,
    Pagination
  },

  //---
  async asyncData({ app }) {
    let { data } = await app.$request.findAllCategory();
    return {
      categoryList: data.data
    };
  },
  created() {
    this.searchMap.catId = this.$route.params.cid;
    this.findBrandByCidFN();
    this.findSpecFN();
    //查询搜索数据
    this.searchList();
  },
  data() {
    return {
      searchMap: {
        catId: "",
        brandId: "", //品牌id
        pageNum: 1, //第几页
        pageSize: 2, //每页个数
        specList: {
          机身颜色: "",
          内存: ""
        }
      },
      brandList: [],
      specList: [], //规格列表
      searchResult: {} //查询结果
    };
  },
  methods: {
    async findBrandByCidFN() {
      let { data } = await this.$request.findBrandByCid(this.searchMap.catId);
      this.brandList = data.data;
      console.warn(data);
    },
    brandSearch(brandId) {
      this.searchMap.brandId = brandId;
    },
    async findSpecFN() {
      let { data: specData } = await this.$request.findSpec(
        this.searchMap.catId
      );
      this.specList = specData.data;
    },
    // 规格的切换
    specSearch(specName, optionName, e) {
      //通过“规格项名称”来判断是否为“不限”
      if (optionName) {
        //规格项
        this.searchMap.specList[specName] = optionName;
      } else {
        //不限--删
        delete this.searchMap.specList[specName];
      }

      //查询所有
      this.searchList();
      $(e.target)
        .parent()
        .addClass("cur");
      $(e.target)
        .parent()
        .siblings()
        .removeClass("cur");
    },
    //搜索商品
    async searchList() {
      //查询
      let { data } = await this.$request.search(this.searchMap);
      //保存查询的结果
      this.searchResult = data.data;
      console.warn(this.searchResult);
    },
    //根据品牌查询
    brandSearch(brandId) {
      this.searchMap.brandId = brandId;
      this.searchList();
    },
    //根据评论排序
    sortSearch(sortBy) {
      //判断是否连续点击
      if (this.searchMap.sortBy == sortBy) {
        //如果是练习点击 切换排序方式
        this.searchMap.sortWay =
          this.searchMap.sortWay == "asc" ? "desc" : "asc";
      } else {
        //如果不是切换排序字段
        this.searchMap.sortBy = sortBy;
        this.searchMap.sortWay = "asc";
      }
      this.searchList();
    },
    //分页的回调函数
      pageChanged( pageNum ) {
      //查询第几页数据
      //1) 设置当前页
      this.searchMap.pageNum = pageNum
      //2) 查询
      this.searchList()
    }
  },
  watch: {
    "$store.state.keyword": function(newValue, oldValue) {
      this.searchMap.keyword = newValue;
      this.searchList();
    }
  }
};
</script>

<style>
.goodslist .goodsname {
  display: block; /* 当前元素本身是inline的，因此需要设置成block模式 */
  white-space: nowrap; /* 因为设置了block，所以需要设置nowrap来确保不换行 */
  overflow: hidden; /* 超出隐藏结合width使用截取采用效果*/
  text-overflow: ellipsis; /* 本功能的主要功臣，超出部分的剪裁方式 */
  -o-text-overflow: ellipsis; /* 特定浏览器前缀 */
  text-decoration: none; /* 无用 */
}
</style>