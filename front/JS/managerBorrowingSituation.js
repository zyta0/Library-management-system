//点击待归还和预约中进行页面跳转
        let toBeReturned = document.querySelector(".toBeReturned");//获取待归还按钮
        let inAdvance = document.querySelector(".inAdvance");//获取预约中按钮
        let timeLimit = document.querySelectorAll(".timeLimit");//获取是否到期显示区域
        let person = document.querySelectorAll(".person");//获取借阅人显示区域

        toBeReturned.addEventListener("click", () => {
            inAdvance.classList.remove("signed");
            toBeReturned.classList.add("signed");
            for (let i = 0; i < timeLimit.length; i++) {
                timeLimit[i].style.display = "block";
                person[i].style.marginTop = "0";
            }
        })
        inAdvance.addEventListener("click", () => {
            toBeReturned.classList.remove("signed");
            inAdvance.classList.add("signed");
            for (let i = 0; i < timeLimit.length; i++) {
                timeLimit[i].style.display = "none";
                person[i].style.marginTop ="26px";
            }
        })

//待归还页面的请求
        let bookName = document.querySelectorAll(".bookName");
        let author = document.querySelectorAll(".author");
        let personName = document.querySelectorAll(".person>span");
        axios({
            method: "post",
            url: "http://frp-fly.top:57378/WaitingReturnServlet"
        })
            .then((result) => {
                console.log(result.data);
                console.log(result.data[0].url);
                console.log(result.data[1].url);
                console.log(result.data[2].url);
                for (let i = 0; i < result.data.length; i++) {
                    bookName[i].innerText = result.data[i].name;
                    author[i].innerText = result.data[i].author;
                    personName[i].innerText = result.data[i].borrower;
                    bookName[i].previousElementSibling.src=`${result.data[i].url}`;
                    if(result.data[i].url.includes(".png")){
                        bookName[i].previousElementSibling.src = `${result.data[i].url}`;
                        console.log(bookName[i].previousElementSibling.src);
                    }
                }
            })
            .catch((err) => {
                console.log("出错了！", err)
            })