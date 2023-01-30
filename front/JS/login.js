const account = document.getElementById("account");
const pwd = document.getElementById("pwd");
const btn = document.getElementById("btn");
btn.addEventListener("click", () => {
    axios({
        method: "POST",
        url: "http://api.reginvolver.cn/user/login",
        data: {
            password: `${pwd.value}`,
            name: `${account.value}`
        }
    }).then(res => console.log(res))
})