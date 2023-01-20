<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring" />
  </a>
</p>
<h1 align="center">
  Simple Report Generator Jasper + Spring Boot
</h1>

<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/joaovictormacedo/simple-report-jasper-springboot">
</p>

### 💡 Description

This application generates a simple report of states in Brazil from the IBGE API (https://servicodados.ibge.gov.br/api/v1/localidades/estados)


### 🎲 Pre-requisites

Java 17.x.x <br>
Maven 3.x.x

### ▶️ Run Project

```bash
# Clone repository
$ https://github.com/joaovictormacedo/simple-report-jasper-springboot.git

# Go to project path and execute:
$ mvn spring-boot:run

# The project start on localhost:8090 
```
Or run in your favorite IDE

### 🤗 Test

```bash
# Open Postman and import CURL
  curl --location --request GET 'http://localhost:8090/api/reports/brazilian-states'

# Or run on browser
 - http://localhost:8090/api/reports/brazilian-states
```
