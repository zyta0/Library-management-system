const description = document.getElementById('description')
const picture = document.getElementById('picture')
const str = document.getElementById('str')
const author = document.getElementById('author')
const publishTime = document.getElementById('publishTime')
const evaluate = document.getElementById('evaluate')

let bookname = decodeURIComponent(location.search).split("=")[1];
// console.log(bookname);

axios.defaults.baseURL = 'http://frp-fly.top:18252/Library_management_system_war_exploded/'

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

// let id33 = {
//     id: 3,
//         author: '罗贯中',
//         isbn: 'SGYY20200728',
//         name: '三国演义',
//         pages:'445'
// }
// axios({
//     method: 'post',
//     url: '/safe/borrowBookController',
//     data: {
//         id33
//     }
// })