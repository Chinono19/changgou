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