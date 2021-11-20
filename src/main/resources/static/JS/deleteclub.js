`use strict`;

let id = document.querySelector("#clubIdField");
let deleteClubBtn = document.querySelector("#deleteClubBtn");

let deleteData = () => {
    let inputValue = id.value;

    let newType
};

let deleteRequest = (id) => {

    fetch(`http://localhost:8080/club/delete/${id}`, {
        method : `DELETE` 
    }).then((response) => {
        if(response.status !== 200){
            console.error(`Status: ${response.statusText}`);
            return;
        }
        response.json().then((data) =>{
            console.log(data);
        });
    });
};

deleteClubBtn.addEventListener('Click', deleteRequest);
    console.log("Delete button has been clicked!");