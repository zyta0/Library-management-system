const logReg = document.getElementById("login")

function checkToken() {
    const tokenStr = localStorage.getItem("token");
    const token = JSON.parse(tokenStr)
    const now = new Date().getTime()
    if (token == null) {
        return
    }else if (now - token.startTime > 1000*60*60) {
        localStorage.removeItem("tokenStr")
    } else {
        logReg.classList.replace("logReg","hiddenLog")
    }
    
    
}
checkToken()