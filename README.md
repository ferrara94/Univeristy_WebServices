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
- [ ] H2 database
- [ ] Spring Web Modules
- [ ] Tomcat (provided by SpringBoot)

---
#### > entities 

- [ ] Student
- [ ] Professor
- [ ] Employee
- [ ] Faculty

#### > persistence & repository 

Persistence is represented by the in-memory database called H2 Database.

Classes which implements JPA interfaces have the **Repository** at the end of the name and they allow access to data.

In addition, there are also functionalities related to **Foreign Key** and **external relations** (e.g. **OneToOne|OneToMany|ManyToOne**).

![image](https://user-images.githubusercontent.com/45211249/124036097-c4677580-d9fd-11eb-9eba-11f1dc784bbd.png)


--- 

#### > FILE uploading & generation

I implemented services which allow us to upload (insert into DB) and download students information in **FILE.txt** format. 

Files are read and written, in the format **name;surname;date;xxx**, invoking related end-points.

![image](https://user-images.githubusercontent.com/45211249/125109357-89430180-e0e3-11eb-90a8-7bbd225467b7.png)


--- 

#### > execution RestServices 

To view the results of web services, I used Postman.

- [ ] **Add the Student by calling the Rest Service through Postman**

![image](https://user-images.githubusercontent.com/45211249/123134992-a0ca8b00-d451-11eb-9764-9554a6e40c01.png)

- [ ] **Check all Students on Database**

![image](https://user-images.githubusercontent.com/45211249/123134899-8ee8e800-d451-11eb-828f-4ce07321387a.png)

- [ ] **Retrieve all Students by calling the Rest Service through Postman**

![image](https://user-images.githubusercontent.com/45211249/123135042-ab852000-d451-11eb-8ed6-b46f94e2cba6.png)

- [ ] **Delete the Student by calling the Rest Service through Postman**

![image](https://user-images.githubusercontent.com/45211249/123135063-af18a700-d451-11eb-907a-fef54b80e97f.png)
