`use strict`;

let id = document.querySelector("#playerIdField");
let deletePlayerBtn = document.querySelector("#deletePlayerBtn");

let deleteData = () => {
    let inputValue = id.value;

    let newType
};

let deleteRequest = (id) => {

    fetch(`http://localhost:8080/player/delete/${id}`, {
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

deletePlayerBtn.addEventListener('Click', deleteRequest);
    console.log("Delete button has been clicked!");