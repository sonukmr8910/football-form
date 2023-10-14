<div id="top"></div>

# Football Registration Form
### To register for a football game

<details>
<summary>Table of Contents</summary>
<ol>
    <li><a href="#about-the-project" >About The Proect</a></li>
    <ul>
        <li><a href="#technology-stack">Technology Stack</a></li>
    </ul>
    <li><a href="#getting-started">Getting Started</a></li>
    <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#Installation">Installation</a></li>
    </ul>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
</ol>
</details>

## About the Project
A form that can be used to register users for participating in a Football game.

This form has many fields that are to be filled by the user.
Some of them are optional and other fields are mandatory to be filled.

The * symbol denotes that the field is mandatory to be filled in order to successfully submit the form.

A user can also update his form data by entering his "Username" and fetching his details using the GET button.

### Technology Stack

This project is build using the following technology stack:

#### Frontend
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=yellow)
![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)

#### Backend
![SpringBoot](https://img.shields.io/badge/Spring_Boot-329932?style=for-the-badge&logo=spring-boot)

#### Database
![MicrosoftSQLServer](https://img.shields.io/badge/Microsoft%20SQL%20Sever-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white)

## Getting Started
The following are the steps for you to get started.

### Prerequisites
These are the requirements that needs to be fulfilled beforehand in order to run the project successfully.

<ol>
    <li><b>Java Development Kit 11</b></li>
    This project needs you to have JDK 11 or above.
    <li><b>Microsoft SQL Server</b></li>
    Any recent version of SQL Server is required to be installed.
    An empty database needs to be created within SQL Server and the same needs to be updated in the ```application.properties``` file.
    <li><b>IntelliJ Idea IDE (For Development)</b></li>
    IntelliJ IDEA can be used as an IDE for development and testing.
</ol>

### Installation
The following steps guide you to running up the server.
1.  Get the project files
```
https://github.com/sonukmr8910/football-form
```
2. Get in to the project directory called `football-form`.
3. Run the project either using the IDE or using the command-line
```shell
gradlew bootRun
```
4. In the web browser, visit
```
http://localhost:8080
```
## Roadmap
- [ ] Frontend
    - [x] Basic Structure
    - [x] Applied CSS Design
    - [x] Connect to Server
    - [ ] Client-side validations
    - [ ] Optimizations
- [x] Backend
    - [x] Setting REST endpoints
    - [x] Creating Basic Entities and DAO 
    - [x] Server side validations

## Contributing
Contributions are always appreciated. If you have suggestions to make this better, then please create a pull request. Thank You!

## License
Distributed under GPL v3.0.

For more information see `LICENSE` file.

## Contact
[LinkedIn](https://linkedin.com/in/sonukmr8910)

## Acknowledgements
Resources that helped in the journey.

- [Shields](https://shields.io)
- [Bootstrap](https://getbootstrap.com)
- [Postman](https://www.postman.com)
