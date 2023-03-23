const info = document.getElementById("info")
const btn = document.getElementById("btn");
const userName = document.getElementById('realName');
const department = document.getElementById('department');
const issNum = document.getElementById('issNum');
const inviCode = document.getElementById('inviCode');
const email = document.getElementById("account");
const password = document.getElementById("pwd");

const checkName = document.getElementById("checkName");
const checkCode = document.getElementById("checkCode");
const checkEmail = document.getElementById("checkEmail");
const checkPwd = document.getElementById("checkPwd");

const cancelToken = axios.CancelToken;
const source = cancelToken.source();

const infoArr = [
    userName.value,
    email.value,
    password.value,
    department.firstElementChild.textContent,
    issNum.firstElementChild.textContent,
    inviCode.value
];

const checkInfo = [
    checkName,
    checkCode, 
    checkEmail,
    checkPwd 
]

const testName = /^[\u4E00-\u9FA5]{2,4}$/;
const testCode = /.{1,}/;
const testEmail = /^([a-zA-Z\d][\w-]{2,})@(\w{2,})\.([a-z]{2,})(\.[a-z]{2,})?$/;
const testPwd = /^[0-9a-zA-Z]{8,16}$/;    

//选择信息
function selInfo(event,lim,aimObj) {
    if (event.target.textContent.length < lim) {
        aimObj.firstElementChild.textContent = event.target.textContent;
    }
}

//检查用户信息是否填完整
function checkCom(config) {
    let flag = 0;
    infoArr.forEach((ele) => {
        if (ele == '') {
            flag = 1
            source.cancel();
        }
    })
    if (flag == 1) {
        // source.cancel();
        alert("您的信息还未完善哦");
        return config;
    }
    checkInfo.forEach((ele) => {
        if (ele.textContent != '') {
            flag = 2;
        }
    })
    if (flag == 2) {
        source.cancel();
        alert("您的信息有误");
        return config;
    }
    return config;
}

//检查是否输入姓名
function checkNameInfo() {
    if (!testName.test(userName.value)) {
        checkName.textContent = "请输入正确的姓名!";
    } else {
        checkName.textContent = ""
    }
}

//检查是否输入邀请码
function checkCodeInfo() {
    if (!testCode.test(inviCode.value)) {
        checkCode.textContent = "请输入邀请码!"
    } else {
        checkCode.textContent = "";
    }
}

//检查邮箱是否符合规则
function checkEmailInfo() {
    if (!testEmail.test(email.value)) {
        checkEmail.textContent = "邮箱不符合规则!";
    } else {
        checkEmail.textContent = '';
    }
}

//检查密码是否符合规则
function checkPwdInfo() {
    if (!testPwd.test(password.value)) {
        checkPwd.textContent = "密码不符合规则!";
    } else {
        checkPwd.textContent = "";
    }
}

//为需要验证输入的对象绑定验证函数
userName.addEventListener("blur", () => checkNameInfo());
inviCode.addEventListener("blur", () => checkCodeInfo());
email.addEventListener("blur", () => checkEmailInfo());
password.addEventListener("blur", () => checkPwdInfo());

//信息选择功能
department.addEventListener("click", (event) => {
    selInfo(event, 10, department);
})
issNum.addEventListener("click", (event) => {
    selInfo(event, 3, issNum);
})

//当信息没有输入完成时拦截请求
axios.interceptors.request.use(checkCom);

//请求
btn.addEventListener("click", () => {
    axios({
        cancelToken: source.token,
        method: "POST",
        url: "http://127.0.0.1:8888/register",
        headers: { "Content-Type": "application/json;charset=UTF-8" },
        data: {
            username: `${userName.value}`,
            email: `${email.value}`,
            password: `${password.value}`,
            direction: `${department.firstElementChild.textContent}`,
            generation: `${issNum.firstElementChild.textContent}`,
            InviCode: `${inviCode.value}`
        }
    }).then((res) => {
        if (res.data.code == 200) {
            alert("注册成功,赶快去登录吧！");
            location.assign("../front/login.html");
        } else {
            if (res.data.message == "validating: expr_path=InviCode, cause=Invalid code") {
                alert("您的邀请码不对哦");
            }
            if (res.data.message == "member does not exist") {
                alert("没有查找到您的信息");
            }
            if (res.data.message == "user already exists") {
                alert("您已经注册过了哦");
            }
            if (res.data.message == "validating: expr_path=Email, cause=Illegal format") {
                alert("您的邮箱格式有误");
            }
        }
    }).catch(err =>{});
})