# paytm weather
### Paytm Software challenges

#### Overview 

Show current weather info and brief 6-days forecast 

Collect weather data from https://openweathermap.org/api

#### Project structure 

- SoftwareChallenge: Spring based Rest service


- WeatherStation: Web Front-end with jquery + bootstrap

#### Project outline 

##### SoftwareChallenge

- Spring boot based application Developed in Windows 10 / Java 8 with IntelliJ 2017.2 and gradle 4.0.2

- user credential in H2 database - http://http://localhost:8080/h2console

  - Driver Class: org.h2.Driver
  - JDBC URL: jdbc:h2:file:./data/paytm_softwarechallenges
  - User Name: sa
  - Password: 12345
  - H2 db engine file can be found from <SoftwareChallenge>/data/paytm_softwarechallenges.mv.db

- user activity logging into ElasticSearch

  - cluster: paytm-cluster
  - index: paytm_weather

- API

  - Hello World

    - GET http://localhost:8080/greeting/helloworld/v1
    - Return
      - Hello World !!

  - Sign up

    - PUT http://localhost:8080/service/v1/user

    - Request: application/json

      - {

        	"username":"Sangchual Cha",
        	"email":"sangchual.cha@gmail.com",
        	"password":"12345"
        }

    - Response

      - {

            "code": 0,
            "message": "sign up success",
            "authToken": null
        }

  - Sign in

    - POST http://localhost:8080/service/v1/user

    - Request

      - {

        	"email":"sangchual.cha@gmail.com",
        	"password":"12345"
        }

    - Response

      - {

            "code": 0,
            "message": "signin success",
            "authToken": "QLm9+w2INk5AhCZZX7PRyxfAhBEheox0FTx5CtrG7EU2o7h+ceK68FXYWgsUnjQ1"
        }

  - Get Weather Info

    - localhost:8080/service/v1/weather?city=toronto&email=sangchual.cha@gmail.com&authtoken=QLm9%2Bw2INk5AhCZZX7PRyxfAhBEheox0FTx5CtrG7EXG7hN34JQGPGyEGs4Dj5MD

      - PLEASE do urlencode the auth token
      - <u>it should be changed to put the auth token in the http header and verify it from the servlet filter</u>

    - Response

      - {

            "currentWeather": {
                "coord": {
                    "lon": -79.42,
                    "lat": 43.7
                },
                "weather": [
                    {
                        "id": 800,
                        "main": "Clear",
                        "description": "clear sky",
                        "icon": "01n"
                    }
                ],
                "base": "stations",
                "main": {
                ...
                ...

##### WeatherStation

- SPA application based on JQuery + JQuery UI + Bootstrap 3



#### Execute

##### Code check out

Github https://github.com/chasangchual/paytm

##### Prerequisite

- install elasticseardch 2.4 
  - Download https://www.elastic.co/downloads/past-releases/elasticsearch-2-4-0

  - Set ${ELASTICSEARCH_HOME} with installed (extracted) folder

  - Change config, ${ELASTICSEARCH_HOME}\config\elasticsearch.yml

    cluster.name: paytm-cluster

    ​

##### Steps

1. Run elasticsearch

2. Run paytm weather service 

   1. gradle build
   2. gradle bootRun

3. Open the web page (in Firefox or Chrome)

   1. Sign up
   2. Sign in

4. Search Weather Info with a city name in Canada

   ​

#### Speak out

- ##### Token based user authentication

- ##### Rest API based Spring 5

- ##### Web front end - SPA with JQuery + Bootstrap

- ##### Persist User activities into ElasticSearch

- ##### Orchestrate oepn weather map API with Restrifit2



