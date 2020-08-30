# spring-boot-mongodb  HATEOAS (Hypermedia As The Engine Of Application State)
demo project for HATEOAS with mongo database  with spring boot
HATEOAS is an extra level upon REST and is used to present information about a REST API to a client

#Mongo database setup steps :
1. download community server and install it
https://www.mongodb.com/download-center/community

2. create direcoty structure "C:\data\db", if already there then can ignore this.

3. now set environment variable mongodb.
For me i have added variable name:MongoDB, variable value: C:\Program Files\MongoDB\Server\4.2\bin and added the same at path variable like this %MongoDB%.

4. now open command promt  and type command mongod
C:\Users\**>mongod

5. now open one more command promt  and type command mongo
C:\Users\ishu1010>mongo
do not close both CMD windows.
Now mongo database is ready to hanle all the request.

try checkout this application on you laptop/desktop and run and share feedback.


# Jacoco code coverage 
Pom has configuration for code coverage plugin Jacoco.

#junit test case
Demo controller class test cases using Mockmvc.


