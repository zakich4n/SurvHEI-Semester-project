function deleteUser(pseudo) {
    let deleteUserRequest=new XMLHttpRequest();
    deleteUserRequest.open("DELETE","/SupprimerUser?pseudo="+pseudo,true);
    deleteUserRequest.onload = function () {
        location.reload();
    }
    deleteUserRequest.send();
}