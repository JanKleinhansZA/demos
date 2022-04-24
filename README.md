# conversion-calculator
Spring Boot REST project for converting Metric to Imperial unit and vice-versa

## Java Technical Test Instructions
1. Create a Spring Boot application using rest API’s to do a conversions.
2. Convert Metric to imperial and vice versa. The API must cater for at least 5 conversions (include temperature conversion please).
3. Ensure that you have proper Unit and Integration testing that accompany the project.
4. Postman/Jmeter project with your RestAPI's.
5. Use the latest Angular to create a front end for your project. (Only if you have time)
6. Upload your project into your own GIT repository and share the project with us.
7. The project must be able to run in its own Docker environment
8. Build system must use Maven.

## Executing the Application (Locally)

```cmd
mvn clean install
```

```cmd
java -jar target/conversion-calculator-0.0.1-SNAPSHOT.jar
```

## Executing the Application (Docker)

```cmd
docker pull bhuwansethi/conversion-calculator:latest
```

```cmd
docker run -p 8080:8080 bhuwansethi/conversion-calculator
```

## API Documentation

After running the application successfully, use the below link to access the [API Documentation](http://localhost:8080/swagger-ui.html).

```
http://localhost:8080/swagger-ui.html
```
## Testing

API takes 3 inputs as Path Parameters.
1. Conversion Type (length, weight, area, volume, temperature)
2. To Conversion System (metric or imperial)
3. Value

Endpoint
```
/api/convert/{type}/{toSystem}/{value}
```

Example:
Convert 10 Mile to KMs
```
curl localhost:8080/api/convert/length/metric/10
```

Click on the button below to get the Postman Collection for Conversion Calculator.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/c162bdb0accbdddbf8d0)

##
GET http://localhost:8080/api/convert/length/metric/10