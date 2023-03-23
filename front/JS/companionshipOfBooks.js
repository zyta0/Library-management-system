const evaluateOne = document.getElementById('evaluateOne')
const evaluateTwo = document.getElementById('evaluateTwo')
const evaluateThree = document.getElementById('evaluateThree')
const evaluateFour = document.getElementById('evaluateFour')
const evaluateFive = document.getElementById('evaluateFive')
const newMan = document.getElementById('newMan')
const logReg = document.getElementById("login");

function checkState() {
    const tokenStr = localStorage.getItem("token");
    if (tokenStr == null) {
        return
    } else {
        logReg.classList.replace("logReg", "hiddenLog")
    }
}
checkState()

axios.defaults.baseURL = 'http://frp-fly.top:18252/Library_management_system_war_exploded/'

// axios({
//     method: 'GET',
//     url: '/showBySearchController',
//     params: {
//         str:'红楼梦'
//     }
// }).then((res) => {
//     console.log(res.data);
// })

axios({
    method: 'GET',
    url: '/showNewEvaluateController',
}).then((res) => {
    console.log(res.data);
    evaluateOne.innerHTML = res.data.label_evaluate[0].evaluate.evaluate
})

axios({
    method: 'GET',
    url: '/showNewEvaluateController',
}).then((res) => {
    console.log(res.data);
    evaluateTwo.innerHTML = res.data.label_evaluate[1].evaluate.evaluate
})

axios({
    method: 'GET',
    url: '/showNewEvaluateController',
}).then((res) => {
    console.log(res.data);
    evaluateThree.innerHTML = res.data.label_evaluate[2].evaluate.evaluate
})

axios({
    method: 'GET',
    url: '/showNewEvaluateController',
}).then((res) => {
    console.log(res.data);
    evaluateFour.innerHTML = res.data.label_evaluate[3].evaluate.evaluate
})

axios({
    method: 'GET',
    url: '/showNewEvaluateController',
}).then((res) => {
    console.log(res.data);
    evaluateFive.innerHTML = res.data.label_evaluate[4].evaluate.evaluate
})

// axios({
//     method: 'GET',
//     url: '/showAllLabelController',
// }).then((res) => {
//     console.log(res.data);
// })

// axios({
//     method: 'POST',
//     url: '/showEvaluateByLabel',
//     params: {
//         label_name:''
//     }
// }).then((res) => {
//     console.log(res.data);
// })


axios({
    method: 'GET',
    url: '/showHotReaderController',
}).then((res) => {
    console.log(res.data);
})
