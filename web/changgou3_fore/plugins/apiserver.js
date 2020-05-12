const request = {
     //以前的
     checkUsername:(user)=>{
        return axios.post('/cgwebservice/user/checkusername',user)
    },
    checkPhone:(phone)=>{
        return axios.post('/cgwebservice/user/checkPhone?phone='+phone)
    },
    sendSms:(user)=>{
        return axios.post('/cgwebservice/sms/sendSms',user);
    },
    register : ( user ) => {
        return axios.post('/cgwebservice/user/register' , user )
    },
    userLogin:(user)=>{
        return axios.post('/cgwebservice/user/userLogin' , user )
    }
     //--end
     ,
    findAllNews:()=>{
        return axios.get('/cgwebservice/news/findAllNews',{
            params:{
                pageNum:1,
                pageSize:5,
                sortWay:'desc'
            }
        })
    },
    findAllCategory:()=>{
        return axios.get('/cgwebservice/categorys/findAll')
    },
    findBrandByCid:(cid)=>{
        return axios.get('/cgwebservice/brands/category/'+ cid)
    },
    findSpec: (categoryId) =>{
        return axios.get("/cgwebservice/specifications/category/"+categoryId);
    },
    search: ( params ) => {
        return axios.post('/cgsearchservice/sku/search', params)
    },
    //查询详情
    getGoodsInfo:(skuId)=>{
        return axios.get('cgwebservice/sku/goods/'+skuId);
    },
    //查询所有的评论
    findComments : (spuId , pageNum , pageSize) => {
     return axios.get(`/cgwebservice/comments/spu/${spuId}?pageNum=${pageNum}&pageSize=${pageSize}`)
     },
    //添加到购物车
    addToCart:(params)=>{
        return axios.post('/gccartservice/carts/addOrder', params );
    },
    //查询当前用户的购物车
    getCart : () => {
      return axios.get('/gccartservice/carts/queryCartList')
    },
    //更新购物车
    updateCart:(cart)=>{
     return axios.put('/gccartservice/carts/updateCart',cart);
    },
    //收货人地址
    getAddress: () => {
         return axios.get('cgorderservice/address/findAll')
    },
    //添加收货人地址  
    addAddress: ( address ) => {
        return axios.post('/cgorderservice/address/addAddress', address )
    },
    //下订单
    addOrder: ( params ) => {
     return axios.post('/cgorderservice/orders/addOrder', params )
    },
     // 获得微信支付路径
     payUrl: ( sn ) => {
        return axios.post('/cgpayservice/pay/payUrl', { sn })
     }
}

var axios = null

export default ({$axios,redirect},inject) =>{
    //sessionStorage获得token
    // let token = localStorage.getItem('token');
    // if(token){
    //     $axios.setToken(token);
    // }

    // $axios.onError(error=>{
    //     if(error.response.status === 403){
    //         redirect('/Login');
    //     }
    // })
    //赋值
    axios = $axios;

    inject('request',request)
}