//classificationDetails点击时对应的装饰出现，其余消失
        let classificationDetails = document.querySelectorAll(".classificationDetails>div") //获取分类导航栏里的功能
        for (let i = 0; i < classificationDetails.length; i++) {
            classificationDetails[i].onclick = function () {
                for (let j = 0; j < classificationDetails.length; j++) {
                    classificationDetails[j].className = "unSign";
                }
                classificationDetails[i].className = "signed";
            }
        }