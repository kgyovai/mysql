# MySQL Spring Data Instant Test

The purpose of this repository is to provide a simple way of testing the precision of timestamps persisted
by MySQL using Spring Data (JPA).

## To test a specific version of MySQL
```
docker pull mysql:<version>

docker run -e MYSQL_DATABASE=test -e MYSQL_USER=test -e MYSQL_PASSWORD=test -e MYSQL_ROOT_PASSWORD=root -p 33060:33060 -p 3306:3306 -d mysql:<version>
```

## Then execute the test
`./gradlew test`

If the test passes, then the database should provide nanosecond level precision as shown below.

![image](https://user-images.githubusercontent.com/10728023/58874326-840a6180-8696-11e9-98ae-a234e26e914c.png)

If the test fails, then the database likely truncated the precision at seconds.
