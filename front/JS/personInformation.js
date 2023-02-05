//selectBox点击时对应的装饰出现，其余消失
        let selectedSign = document.querySelectorAll(".selectedSign") //获取分类导航栏里的标志
        let selectBox = document.querySelectorAll(".selectBox") //获取分类导航栏里的功能
        for (let i = 0; i < selectBox.length; i++) {
            selectBox[i].onclick = function () {
                for (let j = 0; j < selectedSign.length; j++) {
                    selectedSign[j].style.display = "none";
                }
                selectedSign[i].style.display = "block";
            }
        }
        
//点击修改功能
        let changes = document.querySelectorAll(".changes");//获取修改按钮
        let preserves = document.querySelectorAll(".preserve");//获取保存按钮

        let personInformationInputs = document.querySelectorAll(".personInformation input, button")//获取个人信息页面的输入框
        let contactWayInputs = document.querySelectorAll(".contactWay input")//获取联系方式页面的输入框
        let bindInputs = document.querySelectorAll(".bind input")//获取账号绑定页面的输入框
        let changePasswordInputs = document.querySelectorAll(".changePassword input")//获取修改登录密码页面的输入框
        let allInformationInputs = [personInformationInputs, contactWayInputs, bindInputs, changePasswordInputs];//将所有获取的输入框整理成数组

        for (let i = 0; i < changes.length; i++) {
            changes[i].addEventListener("click", () => {
                preserves[i].style.display = "block";
                changes[i].style.display = "none";
                const element = allInformationInputs[i];
                for (let j = 0; j < element.length; j++) {
                    element[j].disabled = false;
                }
            })
            preserves[i].addEventListener("click", () => {
                preserves[i].style.display = "none";
                changes[i].style.display = "block";
                const element = allInformationInputs[i];
                for (let j = 0; j < element.length; j++) {
                    element[j].disabled = true;
                }
            })
        }

//修改密码的眼睛在点击时发生变化
        let eye = document.querySelectorAll(".eye>div");//获取眼睛按钮
        let password = document.querySelectorAll(".password>input");//获取密码输入框
        for (let i = 0; i < eye.length; i++) {
            eye[i].addEventListener("click", () => {
                if (i == 1) {
                    eye[1].style.display = "none";
                    eye[0].style.display = "block";
                    password.type = text;
                } else {
                    eye[0].style.display = "none";
                    eye[1].style.display = "block";
                    password.type = password;
                }
            })
        }