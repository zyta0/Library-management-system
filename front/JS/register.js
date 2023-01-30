const dep = document.querySelector(".department span");
const depCont = document.querySelectorAll(".depContent p");
const issueNum = document.querySelector(".issueNum span");
const issueNumCont = document.querySelectorAll(".issueNumCont p");
function uploadInfo(ele, tar) {
    ele.addEventListener("click", () => {
        tar.textContent = ele.textContent
    })
}
depCont.forEach(ele => uploadInfo(ele, dep));
issueNumCont.forEach(ele => uploadInfo(ele, issueNum));