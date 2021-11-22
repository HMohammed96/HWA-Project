`use strict`;

let playerIdField = document.querySelector("#playerIdField");
let deletePlayerBtn = document.querySelector("#deletePlayerBtn");

let deleteData = () => {
    let playerIdValue = playerIdField.value;

    let newType
};

let deleteRequest = (playerIdField) => {

    fetch(`http://localhost:8080/player/delete/${playerIdField}`, {
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

deletePlayerBtn.addEventListener('Click', deleteRequest);
    console.log("Delete button has been clicked!");