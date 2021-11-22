`use strict`;

let clubNameField = document.querySelector("#clubNameField");
let clubLeagueField = document.querySelector("#clubLeagueField");
let clubLocationField = document.querySelector("#clubLocationField");
let clubStadiumField = document.querySelector("#clubStadiumField");
let updateClubBtn = document.querySelector("#updateClubBtn");

let putData = () => {
    let clubNameValue = clubNameField.value;
    let clubLeagueValue = clubLeagueField.value;
    let clubLocationValue = clubLocationField.value;
    let clubStadiumValue = clubStadiumField.value;

    inputClubNameField.value = "";
    inputClubLeagueField.value = "";
    inputClubLocationField.value = "";
    inputClubStadiumField.value = "";

    let newClub = {

      clubName : `${clubNameValue}`,
      clubLeague : `${clubLeagueValue}`,
      clubLocation : `${clubLocationValue}`,
      clubStadium : `${clubStadiumValue}`
      
    }

    putFetch(newClub);

    return newClub
  };


let putFetch = (newClub) => {
    fetch("http://localhost:8080/club/update", {
      method: "PUT", // We are specifying we are PUTTing data
      headers: {
        "Content-type": "application/JSON", // Telling the server we are sending JSON
      },
      body: JSON.stringify(newClub), 
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
  
  updateClubBtn.addEventListener('Click', putData);
    console.log("Update button has been clicked!");