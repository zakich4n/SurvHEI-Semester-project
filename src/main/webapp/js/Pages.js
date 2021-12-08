let sessionValue = '<%=Session["typeuser"]%>'

function addFields(){
    var number = document.getElementById("member").value;
    var container = document.getElementById("GenerateQuestions");
    while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }
    for (i=0;i<number;i++){
        var userbox=document.createElement("div");
        userbox.setAttribute("class","user-box");

        var Question = document.createElement("input");
        Question.setAttribute('type', 'text');
        Question.setAttribute('name', 'Q'+(i+1));
        Question.setAttribute('id', 'Q'+(i+1));
        Question.setAttribute('style', "width: 100%;" +
            "    padding: 10px 0;" +
            "    font-size: 16px;" +
            "    color: #fff;" +
            "    margin-bottom: 20px;" +
            "    border: none;" +
            "    border-bottom: 1px solid #fff;" +
            "    outline: none;" +
            "    background: transparent;");

        var Hidden=document.createElement("input");
        Hidden.setAttribute("type","hidden");
        Hidden.setAttribute("name","NBQuestions");
        Hidden.setAttribute("id","NBQuestions");
        Hidden.setAttribute("value",number);
        container.appendChild(Hidden);


        var labelQ=document.createElement("label");
        container.appendChild(document.createTextNode("Question " + (i+1)));
        labelQ.setAttribute("style","top: -20px;" +
            "    left: 0;" +
            "    color: #03e9f4;" +
            "    font-size: 16px; position: absolute;" +
            "top: 0;" +
            "left: 0;" +
            "padding: 10px 0;");
        container.appendChild(labelQ);
        container.appendChild(Question);
        var userbox2=document.createElement("div");
        userbox2.setAttribute("class","obligatoire");
        userbox2.setAttribute("style","position: relative; ");

        var pObl=document.createElement("p");
        pObl.setAttribute("class","lobligatoire");
        pObl.setAttribute("style","position: absolute;" +
            "top: 0;" +
            "left: 0;" +
            "padding: 10px 0;" +
            "font-size: 16px;" +
            "color: #fff;" +
            "pointer-events: none;" +
            "transition: .5s;" +
            "color: #03e9f4;");
        container.appendChild(document.createTextNode("Obligatoire : "));
        container.appendChild(pObl);

        var checkbox = document.createElement("input");
        checkbox.setAttribute("type","checkbox");
        checkbox.setAttribute("class","box");
        checkbox.setAttribute("name","cQ"+(i+1));
        checkbox.setAttribute("id","cQ"+(i+1));
        checkbox.setAttribute("style","width: 100%;" +
            "padding: 10px 0;" +
            "font-size: 16px;" +
            "color: #fff;" +
            "margin-bottom: 20px;" +
            "border: none;" +
            "border-bottom: 1px solid #fff;" +
            "outline: none;" +
            "background: transparent;position: relative;" +
            "width: 10%;" +
            "left: 30%;" +
            "margin-top: 9%;");
        container.appendChild(checkbox);
        container.appendChild(userbox2);
        container.appendChild(userbox);

    }

}

function deleteForm(IDForm) {
    let deleteFormRequest=new XMLHttpRequest();
    deleteFormRequest.open("DELETE","/Formulaire?id="+IDForm,true);
    deleteFormRequest.onload = function () {
        location.reload();
    }
    deleteFormRequest.send();
}

function searchAndHide() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("FormSearchBar");
    filter = input.value.toUpperCase();
    //ul = document.getElementById("individualForm");
    li = document.getElementsByClassName("removable");
    console.log(input+" : "+filter);
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("figcaption")[0];
        txtValue =a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}