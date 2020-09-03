# Currency Converter
![](https://img.shields.io/github/languages/count/angelobms/currency-converter-api) ![](https://img.shields.io/github/repo-size/angelobms/currency-converter-api) ![](https://img.shields.io/github/last-commit/angelobms/currency-converter-api) ![](https://travis-ci.org/angelobms/currency-converter-api.svg?branch=master) 

Currency conversion system API. [CurrencyConverterAPI]:<https://mighty-beyond-43289.herokuapp.com>

The conversion application was implemented as a challenge for the company Jaya.Tech [jaya.tech]. It is possible from the application to obtain the currency conversion using conversion rates obtained obtained from https://api.exchangeratesapi.io.

## Features

  -  RESTful APIs

## Tech

Math Expression API was developed using the technologies bellow:

* [Java] - Java 11
* [Spring Boot] - Spring Boot 2
* [Spring Data] - Spring Data
* [Lombok] - Lombok
* [Maven] - Maven
* [JUnit5] - JUnit 5
* [Mockito] - Mockito
* [Insomnia] - Insomnia
* [Swagger] - Swagger
* [TravisCI] - TravisCI

## Endpoins

- \api\transactions - Endpoint to convert a source currency to a target currency.
- \api\transactions\1 - Endpoint to see the conversions used by a user.

The documentation of the endpoints can be consulted after running the application at http://localhost:8080/swagger-ui.html

## Installation

Math Expression API need to be cloned on GitHub.

```sh
$ git clone https://github.com/angelobms/currency-converter-api.git
$ cd currency-converter-api
```

### Running the application

* Via Eclipse or IntelliJ - Run the "Main" ProductApplication.java class as a java application (normal or debug).

* Via Maven - Run the command

```sh
$ mvn spring-boot: run
```

###  License
----

MIT


**Free Software, Hell Yeah!** 

[Java]: <https://docs.oracle.com/en/java/javase/11/?xd_co_f=4f813848-9bb3-47f8-9094-f46bcca78914>
[Spring Boot]: <https://spring.io>
[Spring Data]: <https://spring.io/projects/spring-data>
[Lombok]: <https://projectlombok.org/>
[insomnia]: <https://www.getpostman.com>
[Maven]: <https://maven.apache.org/>
[JUnit5]: <https://junit.org/junit5/>
[Mockito]: <https://site.mockito.org/>
[Insomnia]: <https://insomnia.rest/>
[Swagger]: <https://swagger.io/>
[TravisCI]: <https://travis-ci.org/>
