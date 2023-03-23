//点击借阅书籍和预约请求进行页面跳转
        let loanRequest = document.querySelector(".loanRequest");//获取借阅书籍按钮
        let reservationRequest = document.querySelector(".reservationRequest");//获取预约请求按钮
        let timeLimit = document.querySelectorAll(".timeLimit");//获取借阅时间显示区域
        let person = document.querySelectorAll(".person");//获取借阅人显示区域
        let button = document.querySelectorAll(".button");//获取按钮

        loanRequest.addEventListener("click", () => {
            reservationRequest.classList.remove("signed");
            loanRequest.classList.add("signed");
            for (let i = 0; i < timeLimit.length; i++) {
                timeLimit[i].style.display = "block";
                person[i].className ="person";

            }
            for (let i = 0; i < button.length; i++) {
                button[i].style.display = "block";
            }
        })
        reservationRequest.addEventListener("click", () => {
            loanRequest.classList.remove("signed");
            reservationRequest.classList.add("signed");
            for (let i = 0; i < timeLimit.length; i++) {
                timeLimit[i].style.display = "none";
                person[i].className ="person2";
            }
            for (let i = 0; i < button.length; i++) {
                button[i].style.display = "none";
            }
        })

//管理员信息页面的请求与点击是的页面切换
        let bookPic = document.querySelectorAll(".book>img");
        let bookName = document.querySelectorAll(".bookName");
        let author = document.querySelectorAll(".author");
        let personName = document.querySelectorAll(".person>span");
        axios({
            method: "post",
            url: "http://frp-fly.top:57378/BookBorrowRequestServlet"
        })
            .then((result) => {
                console.log(result.data);
                for (let i = 0; i < result.data.length; i++) {
                    bookName[i].innerText = result.data[i].name;
                    author[i].innerText = result.data[i].author;
                    personName[i].innerText = result.data[i].appointee;
                    bookName[i].previousElementSibling.src = `${result.data[i].url}`;
                    if (result.data[i].url.includes(".png")) {
                        bookName[i].previousElementSibling.src = `${result.data[i].url}`;
                    }
                }
            })
            .catch((err) => {
                alert("出错了！", err)
            })
        loanRequest.addEventListener("click", () => {
            axios({
                method: "post",
                url: "http://frp-fly.top:57378/BookBorrowRequestServlet"
            })
                .then((result) => {
                    console.log(result.data);
                    for (let i = 0; i < result.data.length; i++) {
                        bookName[i].innerText = result.data[i].name;
                        author[i].innerText = result.data[i].author;
                        personName[i].innerText = result.data[i].appointee;
                        bookName[i].previousElementSibling.src = `${result.data[i].url}`;
                    }
                })
                .catch((err) => {
                    alert("出错了！", err)
                })
        })
        reservationRequest.addEventListener("click", () => {
            axios({
                method: "post",
                url: "http://frp-fly.top:57378/BookAppointmentRequestServlet"
            })
                .then((result) => {
                    console.log(result.data);
                    for (let i = 0; i < result.data.length; i++) {
                        bookName[i].innerText = result.data[i].name;
                        author[i].innerText = result.data[i].author;
                        personName[i].innerText = result.data[i].appointee;
                        bookName[i].previousElementSibling.src = `${result.data[i].url}`;
                    }
                })
                .catch((err) => {
                    alert("出错了！", err)
                })
        })