RGA Customer Module
===================

##Scenario
An insurance company needs a system to manage their customer data.  A software engineering team is working on the story below.

*As a system user, I want to add new customer data into the system. After added, I can view a certain customer, and a customer list. Of course, I am also able to modify the data as well as remove it from the system.* 


##Instructions
You are required to provide the functions of:

1. Creating a single customer
2. Updating a single customer
3. Deleting a single customer
4. Reading a single customer
5. Listing all customers
6. Authentication (assume that the system user is existing)
7. Login - getting a login token. 
8. Logout - destroying a login token.

##Envirement
Java 1.7 or newer
Maven 3.1 or newer
Tomcat 6 or newer

##RESTful API List
###POST http://{your localhost}:{your post}/customer/session/login
**Parameters:**
* username {String} - username for the customr. Used to login.
* password {String} - password for the customer. Used to login.

***Sample Request Body***
```javascript
{
"customerName":"kerrigan",
"password":"12345"
}
```
***Sample Response Body***

```javascript
{"token":"eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE0NTEzMTIxNDksImV4cCI6MTQ1MTM5ODU0OSwic3ViIjoia2VycmlnYW4ifQ.y_ZzgEIxT1m49ZRoYLegPgVjKypAreUSdeDmDVKsidLtAMclw1bVkvIag9TrxEtpevJqYxKFXEEvBnpUw7lAdw","message":"Login Success!","userName":"kerrigan"}
```

###POST http://{your localhost}:{your post}/customer/session/logout
**Parameters:**
* username {String} - username for the customr. Used to login.

***Sample Request Body***
```javascript
{
"customerName":"kerrigan",
"password":"12345"
}
```

###GET http://{your localhost}:{your post}/customer/resources/get/{id}
**Parameters:**
* username {String} - username for the customr. Used to login.

***Sample Response Body***

```javascript
{
"id":2,
"username":"john",
"password":"12345",
"email":"john@gmail.com"
}
```

###GET http://{your localhost}:{your post}/customer/resources/list

***Sample Response Body***

```javascript
[{"id":1,"username":"kerrigan","password":"12345","email":"kerrigan@gmail.com"},
{"id":2,"username":"john","password":"12345","email":"john@gmail.com"},
{"id":3,"username":"tom","password":"12345","email":"tom@gmail.com"}]
```

###PUT http://{your localhost}:{your post}/customer/resources/create

***Sample Request Body***
```javascript
{
"username":"kerrigan22",
"password":"12345",
"email":"kerrigan22@gmail.com"
}
```

***Sample Response Body***

```javascript
{
"id":4,
"username":"kerrigan22",
"password":"12345",
"email":"kerrigan22@gmail.com"
}
```

###POST http://{your localhost}:{your post}/customer/resources/update

***Sample Request Body***
```javascript
{
"username":"kerrigan",
"password":"12345xx",
"email":"kerrigantest@gmail.com"
}
```

***Sample Response Body***

```javascript
{
"id":1,"username":"kerrigan",
"password":"12345xx",
"email":"kerrigantest@gmail.com"
}
```

###DELETE http://{your localhost}:{your post}/customer/resources/delete/{id}

