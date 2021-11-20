`use strict`;

let clubNameField = document.querySelector("#clubNameField");
let clubLeagueField = document.querySelector("#clubLeagueField");
let clubLocationField = document.querySelector("#clubLocationField");
let clubStadiumField = document.querySelector("#clubStadiumField");
let addClubBtn = document.querySelector("#addClubBtn");

let postData = () => {
    let clubNameValue = clubNameField.value;
    let clubLeagueValue = clubLeagueField.value;
    let clubLocationValue = clubLocationField.value;
    let clubStadiumValue = clubStadiumField.value;

    let newClub = {
        title: (clubNameValue, clubLeagueValue, clubLocationValue, clubStadiumValue),
        body: ("manchester united", "premier league", "england", "old trafford"),
        clubId: 1,
    }

    postFetch(newClub);

    return newClub
  };

// POST request - Creating data and pushing it into a database
// POST request we also need to pass in a BODY of data
// Data we get back will likely be using the data we sent

// This is the object we are creating to post to the backend

let postFetch = (object) => {
    fetch("http://localhost:8080/club/create", {
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
  
  // Event Listener ALWAYS GO AT BOTTOM
  
  addClubBtn.addEventListener('Click', postData);
    console.log("Add button has been clicked!");
