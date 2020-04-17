const request = {
    test:()=>{
        return axios.get('/test')
    },
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
}

var axios = null

export default ({$axios,redirect},inject) =>{
    //sessionStorage获得token
    let token = localStorage.getItem('token');
    if(token){
        $axios.setToken(token);
    }

    $axios.onError(error=>{
        if(error.response.status === 403){
            redirect('/Login');
        }
    })
    //赋值
    axios = $axios;

    inject('request',request)
}