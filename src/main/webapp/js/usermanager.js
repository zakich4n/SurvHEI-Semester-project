
function deleteUser(pseudo) {
    let deleteUserRequest=new XMLHttpRequest();
    deleteUserRequest.open("DELETE","/usermanagement?pseudo="+pseudo,true);
    deleteUserRequest.onload = function () {
        location.reload();
    }
    deleteUserRequest.send();
}



