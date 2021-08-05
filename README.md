# Univeristy_WebServices

---

#### > about

Web Services Rest designed and developed using Java/Spring technologies.

The Services are related to University World, but they are based on a limited number of entities. 

The project is a **SpringBoot** project, so most of the Configurations are provided by default.

**RequestsMappingUniversity.postman_collection** is a collection of RequestMapping in postman which you can use direclty to test the services.



---

#### > run app

In my case, using Spring Tool Suit, to run my app I open it and
```
  right click on project + run as Spring Boot App
```
Another way is to launch from command line
```
  mvn spring-boot:run
```
where the *project* is located (into the project folder)

---

#### > technologies, libraries & representations

- [ ] Java 11
- [ ] JPA
- [ ] json format
- [ ] Slf4j
- [ ] JUnit 4/5
- [ ] H2 database
- [ ] Spring Web Modules
- [ ] Tomcat (provided by SpringBoot)

---
#### > entities 

- [ ] Course
- [ ] Employee
- [ ] Faculty
- [ ] Professor
- [ ] Student
- [ ] Student_enrolled
- [ ] University 

#### > persistence & repository 

Persistence is represented by the in-memory database called H2 Database.

Classes which implements JPA interfaces have the **Repository** at the end of the name and they allow access to data.

In addition, there are also functionalities related to **Foreign Key** and **external relations** (e.g. **OneToOne|OneToMany|ManyToOne**).

![Schermata del 2021-08-05 17-21-08](https://user-images.githubusercontent.com/45211249/128376030-3bfba1ae-3a32-458d-9317-3f7dacfe79da.png)


--- 

#### > FILE uploading & generation

I implemented services which allow us to upload (insert into DB) and download students information in **FILE.txt** format. 

Files are read and written, in the format **name;surname;date;xxx**, invoking related end-points.

![Schermata del 2021-08-05 17-29-20](https://user-images.githubusercontent.com/45211249/128377448-4ff7c4ac-b4a7-42ec-a2f1-d4eb2bacce04.png)


--- 

#### > execution RestServices 

To view the results of web services, I used Postman.

- [ ] **Add the Student by calling the Rest Service through Postman**

![Schermata del 2021-08-05 17-26-22](https://user-images.githubusercontent.com/45211249/128376943-02e4bf71-01e1-4c06-8ead-cf53ad1845de.png)

- [ ] **Check all Students on Database**

![image](https://user-images.githubusercontent.com/45211249/123134899-8ee8e800-d451-11eb-828f-4ce07321387a.png)

- [ ] **Retrieve all Students by calling the Rest Service through Postman**

![Schermata del 2021-08-05 17-25-26](https://user-images.githubusercontent.com/45211249/128376716-250e0733-6f27-4ce2-bdcf-575253248a01.png)

- [ ] **Delete the Student by calling the Rest Service through Postman**

![Schermata del 2021-08-05 17-27-37](https://user-images.githubusercontent.com/45211249/128377148-0af9b1c7-4c7c-4643-89af-28e7b579c5ad.png)
