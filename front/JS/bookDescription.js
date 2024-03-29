const description = document.getElementById('description')
const picture = document.getElementById('picture')
const str = document.getElementById('str')
const author = document.getElementById('author')
const publishTime = document.getElementById('publishTime')
const evaluate = document.getElementById('evaluate')
const logReg = document.getElementById("login");

let bookname = decodeURIComponent(location.search).split("=")[1];

function checkState() {
    const tokenStr = localStorage.getItem("token");
    if (tokenStr == null) {
        return
    } else {
        logReg.classList.replace("logReg", "hiddenLog")
    }
}
checkState()

axios.defaults.baseURL = 'http://nqcv7igb.shenzhuo.vip:50375/Library_management_system_war_exploded/'

axios({
    method: 'GET',
    url: '/showBookInfoController',
    params: {
        str:bookname
    }
}).then((res) => {
    // console.log(res.data);
    str.innerHTML = res.data.books[0].name
    description.innerHTML = res.data.books[0].introduce
    picture.src = res.data.books[0].image 
    author.innerHTML = res.data.books[0].author
    publishTime.innerHTML = res.data.books[0].publishTime
    evaluate.innerHTML = res.data.books[0].evaluate
})
