const account = document.getElementById("account");
const pwd = document.getElementById("pwd");
const btn = document.getElementById("btn");

btn.addEventListener("click", () => {
    axios({
        method: "POST",
        url: "http://127.0.0.1:8888/login",
        data: {
            password: `${pwd.value}`,
            account: `${account.value}`
        }
    }).then(res => {
        if (res.data.code == 200) {
            const token = res.data.token
            const startTime = new Date().getTime()
            const tokenInfo = {
                startTime,
                token
            }
            localStorage.setItem("token", JSON.stringify(tokenInfo))
            document.location.replace("../front/index.html")
        } else {
            alert(res.data.message)
            pwd.value = ''
            account.value = ''
        }
        
    })
})

