const midNav01 = document.getElementById("midNav01");
const midNav02 = document.getElementById("midNav02");
const midNav03 = document.getElementById("midNav03");
const midNav04 = document.getElementById("midNav04");
const midNav05 = document.getElementById("midNav05");

const chatList = document.getElementById("chatList");
const recLikes = document.getElementById("recLikes");
const replyMe  = document.getElementById("replyMe");
const myComment = document.getElementById("myComment");
const myLike  = document.getElementById("myLike");

const midMsgAll = [chatList,recLikes,replyMe,myComment,myLike]

function showMsg(target) {
    target.classList.remove("hidden")
    for (let val of midMsgAll) {
        if (val == target) {
            continue
        }
        if (val.classList.value === '') {
            val.classList.add("hidden")
        }
    }
}

midNav01.addEventListener("click", () => showMsg(chatList));
midNav02.addEventListener("click", () => showMsg(recLikes));
midNav03.addEventListener("click", () => showMsg(replyMe));
midNav04.addEventListener("click", () => showMsg(myComment));
midNav05.addEventListener("click", () => showMsg(myLike));
