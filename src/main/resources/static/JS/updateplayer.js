`use strict`;

let clubIdField = document.querySelector("#clubIdField");
let playerNameField = document.querySelector("#playerNameField");
let playerAgeField = document.querySelector("#playerAgeField");
let playerNationalityField = document.querySelector("#playerNationalityField");
let playerPositionField = document.querySelector("#playerPositionField");
let playerOverallRatingField = document.querySelector("#playerOverallRatingField");
let updatePlayerBtn = document.querySelector("#updatePlayerBtn");

let putData = () => {
    let clubIdValue = clubIdField.value;
    let playerNameValue = playerNameField.value;
    let playerAgeValue = playerAgeField.value;
    let playerNationalityValue = playerNationalityField.value;
    let playerPositionValue = playerPositionField.value;
    let playerOverallRatingValue = playerOverallRatingField.value;

    let newPlayer = {
        title: (clubIdValue, playerNameValue, playerAgeValue, playerNationalityValue, playerPositionValue, playerOverallRatingValue),
        body: (1, "marcus rashford", "23", "england", "striker", 85),
        playerId: 1
    }

    putFetch(newPlayer);

    return newPlayer
  };


let putFetch = (object) => {
    fetch("http://localhost:8080/player/update", {
      method: "PUT", // We are specifying we are PUTTing data
      headers: {
        "Content-type": "application/JSON", // Telling the server we are sending JSON
      },
      body: JSON.stringify(object), 
    }).then((response) => {
      if (response.status !== 202) {
        console.error(`Status: ${response.status}`);
        return;
      }
      response.json().then((data) => {
        console.log(data);
      });
    });
  };
  
  // Event Listener ALWAYS GO AT BOTTOM
  
  updatePlayerBtn.addEventListener('Click', putData);
    console.log("Update button has been clicked!");