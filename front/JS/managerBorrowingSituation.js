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