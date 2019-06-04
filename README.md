# SpringBootProject-4A

API'S IN SPRING BOOT 2.1.5 (VIDEO STORE)

Specification
1st Requirement
Client Registration
URL: http: // localhost: 8080 / signup
PAYLOAD: {"email": "marcos9@gmail.com", "name": "marcos9", "encryptedPassword": "marcos54321"}
Returns the created client.


2nd Requirement
Login
URL: http: // localhost: 8080 / login
PAYLOAD: {"email": "marcos9@gmail.com", "password": "marcos54321"}
Returns the logged in user.


3rd Requirement
Logout
URL: http: // localhost: 8080 / logout


4th Requirement
List of films available
URL: http: // localhost: 8080 / film / filmByStatus / {status} (available -> true / not available-> false)
Entry is true or false (Variable Path)
Returns a list of films.



5th Requirement
Location of a film
URL: http: // localhost: 8080 / film / {id}
Input is the id of the film (Variable Path)
  Return the film.



6th Requirement
Search for Filme by title
URL: http: // localhost: 8080 / film / title / {title}
Entry is the title (exact, case sensitive) of the film (Path Variable)
Returns a list of films.



7th Requirement
Return of a film
Input is the id of the film (Variable Path)
Input is the id of the film (Variable Path)
URL: http: // localhost: 8080 / film / updFilm / {idFilm} (return -> true / delivery-> false)
Returns the updated film.



ASPECTS
1) Concurrency is handled by @beans since these are by default singletons and are not used as data holders, therefore the operations they perform will handle the concurrency of data (searched, updated movies, etc.) without worrying about it .
2) The scripts are executed in a ComandLineRunner (com.mex.SpringBootProject.initializer), which contains the context of the services for including and saving the encrypted data (password).

TECHNOLOGIES
i hav used Spring Boot 2.1.5 mostly java-config, and for the security part spring-boot-starter-security with JWT for authentication.
For what is the data structure i used MySql (configured in application.xml, you can also modify it there) the options of handling tables by JPA (CREATE (current), UPDATE, CREATE-DROP, etc ..)
