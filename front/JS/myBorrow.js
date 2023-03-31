const midNavBor = document.getElementById("midNavBor");
const midNavRet = document.getElementById("midNavRet");
const midNavRes = document.getElementById("midNavRes");
const borBookAtl = document.getElementById("borBookAtl");
const retBookAtl = document.getElementById("returnBookAtl");
const resBookAtl = document.getElementById("resBookAtl");
const allBookAtl = [borBookAtl, returnBookAtl, resBookAtl]
const logReg = document.getElementById("login");

function showBook(target){
    target.classList.remove("hidden")
    for (let val of allBookAtl) {
        if (val == target) {
            continue
        }
        if (val.classList.value === '') {
            val.classList.add("hidden")
        }
    }
}
midNavRet.addEventListener("click", () => showBook(retBookAtl))
midNavBor.addEventListener("click", () => showBook(borBookAtl))
midNavRes.addEventListener("click", () => showBook(resBookAtl))

function checkState() {
    const tokenStr = localStorage.getItem("token");
    if (tokenStr == null) {
        return
    } else {
        logReg.classList.replace("logReg", "hiddenLog")
    }
}
checkState()