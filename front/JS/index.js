const logReg = document.getElementById("login")
const carouselMapPic = document.getElementsByClassName("carouselMapPic")[0]
const lisLi = document.querySelectorAll(".lis li")
const btnFootText = document.querySelector(".footText")
const btnRev = document.getElementById("learnMoreRev")
//检查登录状态
function checkState() {
    const tokenStr = localStorage.getItem("token");
    const token = JSON.parse(tokenStr)
    const now = new Date().getTime()
    if (token == null) {
        return
    }else if (now - token.startTime > 1000*60*60) {
        localStorage.removeItem("token")
    } else {
        logReg.classList.replace("logReg","hiddenLog")
    }
}
checkState()
//改变轮播图小圆圈颜色
function addRem(num) {
    for (i = 0; i < 3; i++) {
        if (num == i) {
            lisLi[i].classList.add("lisSelect")
        } else {
            lisLi[i].classList.remove("lisSelect")
        }
    }
}
//轮播图小圆圈颜色跟随轮播图变化
function circleSel(){
        switch (carouselMapPic.offsetLeft) {
            case 0:
                addRem(1)
                break;
            case -1920:
                addRem(2)
                break;
            case -3840:
                addRem(0)
                break;
        }
}
// 图片位移
function animate() {
    let step = 1920
    if (carouselMapPic.offsetLeft == -3840) {
        carouselMapPic.style.left = 0 + "px"
    } else {
        carouselMapPic.style.left = carouselMapPic.offsetLeft - step + "px"
    }
}
// 轮播图效果
 setInterval(() => {
    animate()
     circleSel()
 }, 3000)
 // 推荐阅读跳转书库
btnFootText.addEventListener("click", () => document.location.replace("../front/stackRoom.html"))
// 热点书评跳转书友圈
btnRev.addEventListener("click",()=>{})