## Student protected url with spring security

### build application

    mvn clean install

### Run Application
    mvn spring-boot:run

### Create docker image

    mvn install dockerfile:build

## Run docker image

    docker run -p 8080:8080 daya2023/docker-spring-app:1.0.0

## send request

    user username and password(user123,password)
    ADMIN username and password(admin123,password)

## Send request

    curl --location 'http://localhost:8081/getstudent' --header 'Authorization: Basic dXNlcjEyMzpwYXNzd29yZA==' --header 'Cookie: JSESSIONID=226299E51D1B87F1A84BAAB22093E7AE; JSESSIONID=96B25C1269E4C0A033A607C171546B09'

    curl --location --request PUT 'http://localhost:8081/updatestudent' --header 'Authorization: Basic YWRtaW4xMjM6cGFzc3dvcmQ=' --header 'Cookie: JSESSIONID=226299E51D1B87F1A84BAAB22093E7AE; JSESSIONID=96B25C1269E4C0A033A607C171546B09'

    curl --location --request DELETE 'http://localhost:8081/deletestudent' --header 'Authorization: Basic YWRtaW4xMjM6cGFzc3dvcmQ=' --header 'Cookie: JSESSIONID=226299E51D1B87F1A84BAAB22093E7AE; JSESSIONID=96B25C1269E4C0A033A607C171546B09'
 
