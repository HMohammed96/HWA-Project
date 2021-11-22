`use strict`;

let listGroup = document.querySelector("#listGroup");

fetch('http://localhost:8080/club/getAll')
    .then((response) => {
        if (response.status !== 200) {
            console.error(`status: ${response.status} `);
            return;
        }
        response.json()                                     
        .then((data) => {
            console.log(data[25]);

            for(let obj of data){
                console.log(obj);
                createListItem(obj);
            }
        }).catch((error) => {
            console.error(`${error}`);
        });
    });

    let parentDiv = document.querySelector('#parentDiv');

    let createListItem = (data) => {
        
        let newListItem = document.createElement('li');
        let newListName = document.createElement('li');
        let newListBody = document.createElement('li');

        // Modifying class lists
        newListItem.classList = "list-group-item";

        // Setting the element text content
        newListItem.textContent = data.name;
        newListName.textContent = data.body;
        newListBody.textContent = data.email;
        
        // Append everything..
        listGroup.appendChild(newListItem);
        listGroup.appendChild(newListName);
        listGroup.appendChild(newListBody);

        newListItem.appendChild(newListBody);

        parentDiv.appendChild(newListItem);

    }