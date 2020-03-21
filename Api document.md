#Catalog

##[1\. Account services](#1)
#####[1.1\. User login](#1.1)
#####[1.2\. User logout](#1.2)
#####[1.3\. User login status test](#1.3)
#####[1.4\. User register](#1.4)
##[2\. SQL executor](#2)
##[3\. Category services](#4)
#####[3.1\. Get all categories](#3.1)
#####[3.2\. Add category](#3.2)
#####[3.3\. Update category](#3.3)
#####[3.4\. Delete category](#3.4)
##[4\. Exercise services](#4)
#####[4.1\. Exercise request](#4.1)
#####[4.2\. Get all exercises](#4.2)
#####[4.3\. Get all exercises by category](#4.3)
#####[4.4\. Add exercise](#4.4)
#####[4.5\. Update exercise ](#4.5)
#####[4.6\. Delete exercise](#4.6)
##[5\. Correction services](#5)
#####[5.1\. Get all corrections by exercise](#5.1)
#####[5.2\. Add correction](#5.2)
#####[5.3\. Update correction](#5.3)
#####[5.4\. Delete correction](#5.4)

---
<h2 id="1">1. Account services</h2>
<h4 id="1.1">1.1 User login</h4>

###### Api function
> Allow normal user and administrator to login and create session

###### URL
> ../user/getLogInfo

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|username    |yes(or no if use email)    |string|Username for login                          |
|password    |yes    |string   |Password|
|email    |yes(or no if use username)    |string   |email address|
|groupid    |yes    |int   |1.Administrator 2.Normal user(defaut)|

###### Example request

``` javascript
{ 
    "userName":"titi.toto",
    "userPassword":"123456", 
    "userEmail":"titi.toto@gmail.com",
    "userClass":2
}
```

###### Example response of succesful request

``` javascript
{
    "Data":{
        "email":"titi.toto@gmail.com",
        "groupid":1,
        "password":"123456",
        "uid":1,
        "username":"titi.toto"},
    "StatusCode":200
}
```

###### Example response of failing request
``` javascript
{
    "StatusCode":401,
    "StatusMessage":"Wrong user name or password!"
}
```
---
<h4 id="1.2">1.2. User logout</h4>

###### Api function
> Allow user to log out

###### URL
> ../user/logOut

###### HTTP request methode
> GET

###### Example response of succesful request

>this response will redirect user to the homepage or login page

---
<h4 id="1.3">1.3. User login status test</h4>
###### Api function
> Allow developper to test the status of login

###### URL
> ../user/testLogin

###### HTTP request methode
> GET

###### Example response of succesful request

``` javascript
{
    "success"
}
```

###### Example response of failing request
``` javascript
{
    "StatusCode":400,
    "StatusMessage":"You have not logged in yet!"
}
```
---
<h4 id="1.4">1.4. User register</h4>

###### Api function
> Allow normal users to create their accounts

###### URL
> ../user/registerInfo

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|username    |yes    |string|Username for login                          |
|password    |yes    |string   |Password|
|email    |yes    |string   |email address|
|groupid    |yes    |int   |1.Administrator 2.Normal user(defaut)|

###### Example request

``` javascript
{
    "uid":1,
    "username":"titi.toto"
    "password":"123456", 
    "email":"123456@gmail.com",
    "groupid":2,
}
```

###### Example response of succesful request

``` javascript
{
    "Data":{
        "email":"123456@gmail.com",
        "groupid":1,
        "password":"123456",
        "uid":1,
        "username":"titi.toto"},
    "StatusCode":200
}
```

###### Example response of failing request
``` javascript
{
    "StatusCode":402,
    "StatusMessage":"Username or email have already been used!"
}
```
---

<h2 id="2">2. SQL executor</h2>

###### Api function
> Allow normal user to execute their SQL query

###### URL
> ../sqlExecutor/testSql

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|sqlQuery   |yes   |string|SQL query                       |

###### Example request

``` javascript
{
    sqlQuery:"select * from emp"
}
```

###### Example response of succesful request

``` javascript
[
    {"id_emp":1,"nom_emp":"coucou"},
    {"id_emp":2,"nom_emp":"chouchou"}
]
```

###### Example response of failing request
``` javascript
{
    "RootCause":"You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'Enter your sql query' at line 1",
    "ErrorCode":1064
}
```
---
<h2 id="4">4. Exercise services</h2>
<h4 id="4.1">4.1. Exercise request</h4>

###### Api function
> Request for exercises

###### URL
> ../exercise/getExoById

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|idExercise   |yes   |string|id of exercise                       |

###### Example request

``` javascript
{
    "idExercise":"1"
}
```

###### Example response of succesful request

``` javascript
{
    {"Data":{
        "exerciseText":"Veuillez afficher toutes les information dans la table emp","idExercise":1,"idCategory":1},
    "StatusCode":200}
}
```

###### Example response of failing request
``` javascript
{
    "StatusCode":403,
    "StatusMessage":"Wrong parameter! "
}
```
---

<h4 id="4.4">4.4. Add Exercise</h4>

###### Api function
> Allow to add new exercise to de database

###### URL
> ../exercise/addExercise

###### Support format
> JSON

###### HTTP request methode
> POST

###### Request parameter
|Parameter|Required|Type|Explain|
|:-----  |:-------|:-----|-----                               |
|exerciseText   |yes   |string|the text of the exercise                    |
|exerciseCorrection   |yes   |string|the correction of the exercise                      |
|groupId   |yes   |int|group id                     |

###### Example request

``` javascript
{
    "textExercise":"Veuillez afficher toutes les information dans la table emp",
    "idCategory":"1"
}
```

###### Example response of succesful request

``` javascript
{
    "StatusCode":200,
    "StatusMessage":"Require successfully"
}
```

###### Example response of failing request
``` javascript
{
    "StatusCode":410,
    "StatusMessage":"Error occured! Require unsuccessfully!"
}
```
---
