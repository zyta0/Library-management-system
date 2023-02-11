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
                person[i].style.marginTop = "0";
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
                person[i].style.marginTop ="46px";
            }
            for (let i = 0; i < button.length; i++) {
                button[i].style.display = "none";
            }
        })