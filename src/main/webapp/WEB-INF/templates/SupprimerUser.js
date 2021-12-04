window.onload = function () {
    listUser();
};


var listUser = function () {

    let listUserRequest = new XMLHttpRequest();
    listUserRequest.open("GET", "api/Users", true);
    listUserRequest.responseType = "json";
    listUserRequest.onload = function () {
        let Users = this.response;
               document.getElementById("liste-user").innerText = Users[0].nom;
    }
    listUserRequest.send();
};


/*
let deleteUser = function (user) {
    if (confirm("Are you sure you want to delete " + user.nom + " (" + city.cityCode + ") ?")) {
        let deleteRequest = new XMLHttpRequest();
        deleteRequest.open("DELETE", "ws/cities/" + city.cityCode, true);

        deleteRequest.onload = function () {
            countCities();
            listCities();
        };

        deleteRequest.send();
    }
};

 */
