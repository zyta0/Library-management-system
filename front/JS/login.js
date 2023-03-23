const account = document.getElementById("account");
const pwd = document.getElementById("pwd");
const btn = document.getElementById("btn");

const cancelToken = axios.CancelToken;
const source = cancelToken.source();

//拦截器函数，在发送请求前检查是否输入了账号密码
function checkUser(config) {
    if (account.value == '') {
        alert('您还没有输入账号');
        config.cancelToken = source.token;
        source.cancel();
        return config;
    }
    if (pwd.value == '') {
        alert('您还没有输入密码');
        config.cancelToken = source.token;
        source.cancel();
        return config;
    }
    return config;
}

axios.interceptors.request.use(checkUser);


//登录请求
btn.addEventListener("click", () => {
    axios({
        cancelToken: source.token,
        method: "POST",
        url: "http://frp-fly.top:15946/Library_management_system_war_exploded/loginController",
        data: {
            name: `${account.value}`,
            password: `${pwd.value}`
        }
    }).then(res => {
        console.log(res);
        let code = res.data.code;
        if (code != 200) {
            alert(res.data.message);
            account.value = '';
            pwd.value = '';
        } else {
            alert("登录成功");
            // document.location.replace("../front/index.html")
        }
    }).catch(err => { });
})

