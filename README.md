# spring-dot-enviroments
Provides a library for setting environment variables in the Spring Boot framework

## Installation

In your pom.xml add the following dependency:

```bash
<dependency>
    <groupId>com.dotenv</groupId>
    <artifactId>spring-dot-enviroments</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage
1 . Put the `.env` file in your .gitignore

2 . In your Spring Boot project, add a `.env` file in the resources path. 
E.g: 
```bash
SOME_ENV=Basic 123
```
3 . Apply the annotation `@DotEnv` in your SpringBoot application file. E.g:
```java
@SpringBootApplication
@DotEnv
public class MyApplication {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
[GPL-3.0](https://choosealicense.com/licenses/mit/)