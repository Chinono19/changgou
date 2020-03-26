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
    }
}

var axios = null

export default ({$axios,redirect},inject) =>{

    //赋值
    axios = $axios;

    inject('request',request)
}