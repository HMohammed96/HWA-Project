`use strict`;

let clubIdField = document.querySelector("#clubIdField");
let deleteClubBtn = document.querySelector("#deleteClubBtn");

let deleteData = () => {
    let clubIdValue = clubIdField.value;

    let newType
};

let deleteRequest = (clubIdField) => {

    fetch(`http://localhost:8080/club/delete/${clubIdField}`, {
        method : `DELETE` 
    }).then((response) => {
        if(response.status !== 204){
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