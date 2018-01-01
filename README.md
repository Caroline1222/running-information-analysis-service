# running-information-analysis-service

## Introduction
**running-information-analysis-service** is a RESTful service application built with *[Spring Boot](https://projects.spring.io/spring-boot/)* and *[Maven](https://maven.apache.org/)*.

**Running Information** contains:
- runningId
- latitude
- longitude
- runningDistance,
- totalRunningTime,
- heartRate,
- Timestamp,
- userInfo (username, address)
- HealthWarningLevel (based on heartRate)

The following functions can be achieved through corresponding **REST APIs**. More query functions can be easily added based on users' needs.
- Upload runningInfos
- Delete all runningInfo
- Find runningInfo by runningId
- Get all runningInfo by username and sorted by HealthWarningLevel

## Requirements
* Java Platform (JDK) 8
* [Apache Maven](https://maven.apache.org/)
* [Docker](https://www.docker.com/)

## Installation and Quick Start
#### 1. Download project file
```
git clone https://github.com/Caroline1222/running-information-analysis-service.git 
cd running-information-analysis-service
```
#### 2. Run MySQL with docker
```
docker-compose up
```
#### 3. Build and run application
```
mvn clean install
java -jar target/running-information-analysis-service-1.0.0.BUILD-SNAPSHOT.jar
```
#### 4. Post, Get, and Delete data using Postman and running_information.json


## API Reference


