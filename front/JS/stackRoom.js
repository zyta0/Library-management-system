
function checkState() {
    const tokenStr = localStorage.getItem("token");
    if (tokenStr == null) {
        return
    } else {
        logReg.classList.replace("logReg", "hiddenLog")
    }
}
checkState()

//classificationDetails点击时对应的装饰出现，其余消失
        let classificationDetails = document.querySelectorAll(".classificationDetails>div") //获取分类导航栏里的功能
        for (let i = 0; i < classificationDetails.length; i++) {
            classificationDetails[i].addEventListener('click',function () {
                for (let j = 0; j < classificationDetails.length; j++) {
                    classificationDetails[j].className = "unSign";
                }
                classificationDetails[i].className = "signed";
            })
        }
        
//书库页面的请求
        let bookPic = document.querySelectorAll(".bookPic>img");
        let bookName = document.querySelectorAll(".bookName");
        axios({
                method: "post",
                url: "http://frp-fly.top:57378/bookServlet"
            })
                .then((result) => {
                    for (let i = 13; i < result.data.length; i++) {
                        bookName[i].innerText = result.data[i].name;
                        bookPic[i].src = `${result.data[i].url}`;
                    }
                })
                .catch((err) => {
                    alert("出错了！", err)
                })

        
const bookDet = document.querySelectorAll(".book .bookPic")  
console.log(bookDet);      
let htmlUrl = "./bookDescription.html?name=";
bookDet.forEach((ele) => {
    ele.addEventListener("click", () => {
        htmlUrl += `${ele.nextElementSibling.textContent}`
        location.assign(htmlUrl);
        htmlUrl = htmlUrl.split("=")[0] + "=";
        console.log(htmlUrl);
    })
})
        
