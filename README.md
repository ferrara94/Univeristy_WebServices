# 🎓 University WebServices - RESTful APIs for Academic Systems
## Overview

**University WebServices** is a RESTful backend application built with Java and Spring Boot, designed to simulate key services within a university ecosystem. 
It provides an API layer that models core university entities and exposes endpoints for basic operations. As distinct from a Microservice Architecture, we followed a "Monolithic-based" approach.

**Need to simulate university services?** 🎓 Test them instantly with University_WebServices!

---

## ▶️ Run the Application
💡 Tip: There are two simple ways to run the application — via IDE or command line.

### Using Spring Tool Suite (STS)
- Open the project in Spring Tool Suite
- Right-click on the project folder
- Select:

```
  right click on project + run as Spring Boot App
```

### Using Command Line
- Open a terminal and navigate to the root project directory
- Run the following command:

```
  mvn spring-boot:run
```

---

## Technologies Used

- [ ] Java 11
- [ ] JPA
- [ ] json format
- [ ] Slf4j
- [ ] JUnit 4/5
- [ ] H2 database
- [ ] Spring Web Modules
- [ ] Spring Actuator
- [ ] Tomcat (provided by SpringBoot)

---

## Entities
The application models key components of a university environment through the following entities:

- [ ] 📚 Course
- [ ] 👩‍💼 Employee
- [ ] 🏛️ Faculty
- [ ] 🎓 Professor
- [ ] 👨‍🎓 Student
- [ ] 📝 Student_Enrolled
- [ ] 🏫 University

Each entity represents a part of the university domain and participates in relevant relationships.

![Schermata del 2021-08-05 17-21-08](https://user-images.githubusercontent.com/45211249/128376030-3bfba1ae-3a32-458d-9317-3f7dacfe79da.png)


---

## 🗄️ Persistence & Repository

- The project uses an H2 in-memory database to manage data during runtime — ideal for testing and development.
- Data access is handled through Spring Data JPA, with repository classes named following the pattern EntityNameRepository. These repositories simplify database operations and provide built-in CRUD support.


Additionally, the application supports key JPA relationships, such as:
- @OneToOne
- @OneToMany
- @ManyToOne

--- 

#### > FILE uploading & generation

I implemented services which allow us to upload (insert into DB) and download students information in **FILE.txt** format. 

Files are read and written, in the format **name;surname;date;xxx**, invoking related end-points.

![Schermata del 2021-08-05 17-29-20](https://user-images.githubusercontent.com/45211249/128377448-4ff7c4ac-b4a7-42ec-a2f1-d4eb2bacce04.png)


--- 

#### > execution RestServices 

To view the results of web services, I used Postman. 
**RequestsMappingUniversity.postman_collection** is a collection of RequestMapping in postman which you can use direclty to test the services.

- [ ] **Add the Student by calling the Rest Service through Postman**

![Schermata del 2021-08-05 17-26-22](https://user-images.githubusercontent.com/45211249/128376943-02e4bf71-01e1-4c06-8ead-cf53ad1845de.png)

- [ ] **Check all Students on Database**

![image](https://user-images.githubusercontent.com/45211249/123134899-8ee8e800-d451-11eb-828f-4ce07321387a.png)

- [ ] **Retrieve all Students by calling the Rest Service through Postman**

![Schermata del 2021-08-05 17-25-26](https://user-images.githubusercontent.com/45211249/128376716-250e0733-6f27-4ce2-bdcf-575253248a01.png)

- [ ] **Delete the Student by calling the Rest Service through Postman**

![Schermata del 2021-08-05 17-27-37](https://user-images.githubusercontent.com/45211249/128377148-0af9b1c7-4c7c-4643-89af-28e7b579c5ad.png)
