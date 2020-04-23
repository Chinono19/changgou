const request = {
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