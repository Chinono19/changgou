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