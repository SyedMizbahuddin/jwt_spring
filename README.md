
# JWT Authentication & Authorisation With Spring boot


JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object ([read more](https://jwt.io/introduction))


When the User logs in a jwt token is generated which is used to authenticate the subsequent request made.
## Environment Variables

To run this project, you will need to add the following environment variables to your application.properties file


```bash
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=user_name
spring.datasource.password=user_password

jwt.token.secret.key=256-bit key 
#5 minutes
jwt.token.secret.validity=300
```


## API Reference

#### Signup

```http
  POST /api/v1/auth/signup
```

Request Body
```body
{
    "email" : "syed@gmail.com",
    "password": "test@123",
    "role": "ADMIN",
    "name": "Syed"
}
```
Response
```body
{
    "token" : "jwt token"
}
```

#### Login

```http
  POST /api/v1/auth/login
```

Request Body
```body
{
    "email" : "syed@gmail.com",
    "password": "test@123",
}
```
Response
```body
{
    "token" : "jwt token"
}
```



#### users

```http
  GET /home/users
```
Request header
`Authorization: "Bearer bffghkjggr8759238rgbfcdhgkfyr9v26223978x362b8927r6-token"`


## Run Locally

Clone the project

```bash
  https://github.com/SyedMizbahuddin/jwt_spring
```

Go to the project directory

```bash
  cd jwt_spring
```

Requirements
```bash
  Java 17 required by Spring Boot 3.x 
```


Build the application

```bash
  ./mvn clean install
```

Run the application

```bash
  java -jar target/jwt-security-0.0.1-SNAPSHOT.jar
```

Application will start running at port `8085`
