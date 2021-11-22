Coverage: 81%

# HWA- Practical Project

This is the README file of my HWA practical project which is a Hobby Web Application that provides an application which allows the user to Create, Read, Update and Delete a Football Club and Football Player. The relationship between the two entitiies consisted of many clubs having players while the players would be added to one club. As a result this meant a many to one relationship. To complete this application MySQL was used as the database management system to store the database and tables, then Java was used as the back-end programming language in Eclipse to write the codebase. HTML, CSS and JavaScript was web technologies used for the front-end.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Git, MySQL Server 5.7 (local or GCP instance), Eclipse IDE, Maven, JUnit, Mockito, Selenium and Visual Code Studio.

### Installing

A step by step series of examples that tell you how to get a development env running

1. Firstly you would use Git to clone down the repository before creating your own development branch to work on.
2. By running the fat jar file in GitBash you would be able to run the spring boot application and use the CRUD Functionality to create, read, update and delete clubs or players.
3. Open the folder of the project in your Eclipse IDE.
4. Once the project has loaded you can then navigate through the multiple files in the project where you will find the methods and testing files, documentation also.

### Unit Tests 

These tests will test if the CRUD method function correctly and to run them you would use JUnit.

	@Test
	public void addPlayerTest() {
		Mockito.when(this.repo.saveAndFlush(testPlayer)).thenReturn(testPlayer);
		
		assertEquals(testPlayer, this.service.addPlayer(testPlayer));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(testPlayer);
	}
	
	@Test
	public void getAllTest() {
		List<Player> testPlayer = new ArrayList<>();
		testPlayer.add(new Player("jadon sancho", 21, "england", "winger", 87, testClub));
	
		Mockito.when(this.repo.findAll()).thenReturn(testPlayer);
		
		assertEquals(testPlayer, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		Player testPlayer = new Player(2L, "marcus rashford", 23, "england", "striker", 85, testClub);
		
		Mockito.when(this.repo.findById(2L)).thenReturn(Optional.of(testPlayer));
		
		assertEquals(testPlayer, this.service.getById(2L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(2L);
	}
	
	@Test
	public void updatePlayerTest() {
		Optional<Player>existing = Optional.of(new Player(2, "marcus rashford", 23, "england", "winger", 85, testClub));
		Player testPlayer =  new Player("marcus rashford", 23, "england", "striker", 85, testClub);
		Player testPlayer2 = new Player(2L, "marcus rashford", 23, "england", "striker", 85, testClub);
	
		Mockito.when(this.repo.findById(2L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(testPlayer2)).thenReturn(testPlayer2);
		
		assertEquals(testPlayer2, this.service.updatePlayer(2L, testPlayer));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(testPlayer2);
	}
	
	@Test
	public void removePlayerTest() {
		this.service.addPlayer(testPlayer);
		boolean exists = true;
		
		Mockito.when(this.repo.existsById(2L)).thenReturn(false);
		assertTrue(this.service.removePlayer(2L));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(2L);
	}

### Integration Tests

These tests will test if the CRUD method function correctly and to run them you would use JUnit.

	@Test
	void testAddClub() throws Exception {
		Club club = new Club("manchester united", "premier league", "england", "old trafford");
		String clubAsJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = post("/club/create").contentType(MediaType.APPLICATION_JSON).content(clubAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Club clubSaved = new Club(2, "manchester united", "premier league", "england", "old trafford");
		String clubSavedAsJSON = this.mapper.writeValueAsString(clubSaved);
		
		ResultMatcher checkBody = content().json(clubSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Club club = new Club(1, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		String clubJSON = this.mapper.writeValueAsString(List.of(club));
		RequestBuilder request = get("/club/getAll");
		
		ResultMatcher checkStatus =  status().isOk();
		
		ResultMatcher checkBody = content().json(clubJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetById() throws Exception {
		Club club = new Club(1, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		String clubJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = get("/club/getById/1");
		
		ResultMatcher checkStatus =  status().isOk();
		
		ResultMatcher checkBody = content().json(clubJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);	
	}
	
	@Test
	void testUpdateClub() throws Exception {
		Club club = new Club("atletico madrid", "la liga", "spain", "wanda metropolitano");
		String clubJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = put("/club/update/1").contentType(MediaType.APPLICATION_JSON).content(clubJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		Club clubSaved = new Club(1, "atletico madrid", "la liga", "spain", "wanda metropolitano");
		String clubSavedAsJSON = this.mapper.writeValueAsString(clubSaved);
		
		ResultMatcher checkBody = content().json(clubSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRemoveClub() throws Exception {
		this.mvc.perform(delete("/club/delete/1")).andExpect(status().isNoContent());
	}

## Deployment

To deploy on the a live system the fatjar file will be required.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Hamid Mohammed** - *Initial work* - [HMohammed96](https://github.com/HMohammed96)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*
