const logReg = document.getElementById("login")
const carouselMapPic = document.getElementsByClassName("carouselMapPic")[0]
const lisLi = document.querySelectorAll(".lis li")
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

function addRem(num) {
    for (i = 0; i < 3; i++) {
        if (num == i) {
            lisLi[i].classList.add("lisSelect")
        } else {
            lisLi[i].classList.remove("lisSelect")
        }
    }
}

function circleSel(){
    
        switch (carouselMapPic.offsetLeft) {
            case 0:
                addRem(1)
                break;
            case -850:
                addRem(2)
                break;
            case -1700:
                addRem(0)
                break;
        }
    
}

function animate() {
    let step = 850
    if (carouselMapPic.offsetLeft == -1700) {
        carouselMapPic.style.left = 0 + "px"
    } else {
        carouselMapPic.style.left = carouselMapPic.offsetLeft - step + "px"
    }
}


 setInterval(() => {
    animate()
     circleSel()
 },3000)