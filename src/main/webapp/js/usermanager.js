
function deleteUser(pseudo) {
    let deleteUserRequest=new XMLHttpRequest();
    deleteUserRequest.open("DELETE","/usermanagement?pseudo="+pseudo,true);
    deleteUserRequest.onload = function () {
        location.reload();
    }
    deleteUserRequest.send();
}

function sendPUTForm() {
    var id, nameform, anonyme, timeform;
    id= document.getElementById("prodId").value;
    nameform=document.getElementById("nameform").value;
    anonyme=document.getElementById("cnameform").value;
    timeform=document.getElementById("timeform").value;
    console.log("nameform='"+nameform+"'&cnameform='"+anonyme+"'&timeform="+timeform);
    let putFormRequest=new XMLHttpRequest();
    putFormRequest.open("PUT","/FormulaireEdit?id="+id,true);


    putFormRequest.onload = function () {
        location.reload();
    }
    putFormRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    putFormRequest.send("nameform="+nameform+"&cnameform="+anonyme+"&timeform="+timeform);
}

