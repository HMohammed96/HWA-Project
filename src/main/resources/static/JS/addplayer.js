`use strict`;

let playerNameField = document.querySelector("#playerNameField");
let playerAgeField = document.querySelector("#playerAgeField");
let playerNationalityField = document.querySelector("#playerNationalityField");
let playerPositionField = document.querySelector("#playerPositionField");
let playerOverallRatingField = document.querySelector("#playerOverallRatingField");
let addPlayerBtn = document.querySelector("#addPlayerBtn");

let postData = () => {
    let playerNameValue = playerNameField.value;
    let playerAgeValue = playerAgeField.value;
    let playerNationalityValue = playerNationalityField.value;
    let playerPositionValue = playerPositionField.value;
    let playerOverallRatingValue = playerOverallRatingField.value;

    let newPlayer = {
        title: (playerNameValue, playerAgeValue, playerNationalityValue, playerPositionValue, playerOverallRatingValue),
        body: ("marcus rashford", "23", "england", "striker", 85),
        playerId: 1,
    }

    postFetch(newPlayer);

    return newPlayer
};

let postFetch = (object) => {
    fetch("http://localhost:8080/player/create", {
      method: "POST", // We are specifying we are POSTing data
      headers: {
        "Content-type": "application/JSON", // Telling the server we are sending JSON
      },
      body: JSON.stringify(object), // We will be creating an object and passing it in here
    }).then((response) => {
      if (response.status !== 201) {
        console.error(`Status: ${response.status}`);
        return;
      }
      response.json().then((data) => {
        console.log(data);
      });
    });
  };

  addPlayerBtn.addEventListener('Click', postData);
    console.log("Add button has been clicked!");