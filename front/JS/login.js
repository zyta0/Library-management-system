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
        url: "http://7l4ghd8r.shenzhuo.vip:50365/login",
        data: {
            account: `${account.value}`,
            password: `${pwd.value}`
        }
    }).then(res => {
        let code = res.data.code;
        if (code != 200) {
            alert("用户名或密码错误");
            account.value = '';
            pwd.value = '';
        } else {
            localStorage.setItem("token", res.data.token);
            alert("登录成功");
            document.location.replace("./index.html")
        }
    }).catch(err => { });
})

