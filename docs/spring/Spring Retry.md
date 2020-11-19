# Spring Retry

## dependendy

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.retry/spring-retry -->
<dependency>
  <groupId>org.springframework.retry</groupId>
  <artifactId>spring-retry</artifactId>
  <version>1.2.5.RELEASE</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aspects</artifactId>
  <version>${spring-framework.version}</version>
</dependency>
```

## config

application context xml configuration

```xml
<!-- annotations config -->
<context:annotation-config />
<aop:aspectj-autoproxy />
<bean class="org.springframework.retry.annotation.RetryConfiguration" />
```

springboot app config

```java
@Configuration
@EnableRetry
public class AppConfig { ... }
```

## apply to methods

```java
@Service
public interface MyService {

    @Retryable(value = SQLTransactionRollbackException.class, maxAttempts = 3, backoff = @Backoff(delay = 200))
    void retryService(String sql);

    @Recover
    void recover(SQLException e, String sql);

}
```

## RetryTemplate

### RetryTemplate Configuration

```java
@Configuration
public class AppConfig {
    //...
    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(2000l);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(2);
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }
}
```

### Using the RetryTemplate

```java
retryTemplate.execute(new RetryCallback<Void, RuntimeException>() {
    @Override
    public Void doWithRetry(RetryContext arg0) {
        myService.templateRetryService();
        ...
    }
});
```

Instead of an anonymous class, we can use a lambda expression as follows:

```java
retryTemplate.execute(arg0 -> {
    myService.templateRetryService();
    return null;
});
```

### Adding Callbacks

```java
public class DefaultListenerSupport extends RetryListenerSupport {
    @Override
    public <T, E extends Throwable> void close(RetryContext context,
      RetryCallback<T, E> callback, Throwable throwable) {
        logger.info("onClose);
        ...
        super.close(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context,
      RetryCallback<T, E> callback, Throwable throwable) {
        logger.info("onError");
        ...
        super.onError(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context,
      RetryCallback<T, E> callback) {
        logger.info("onOpen);
        ...
        return super.open(context, callback);
    }
}
```

### Registering the Listener

```java
@Configuration
public class AppConfig {
    ...

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        ...
        retryTemplate.registerListener(new DefaultListenerSupport());
        return retryTemplate;
    }
}
```

### Testing

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  classes = AppConfig.class,
  loader = AnnotationConfigContextLoader.class)
public class SpringRetryIntegrationTest {

    @Autowired
    private MyService myService;

    @Autowired
    private RetryTemplate retryTemplate;

    @Test(expected = RuntimeException.class)
    public void givenTemplateRetryService_whenCallWithException_thenRetry() {
        retryTemplate.execute(arg0 -> {
            myService.templateRetryService();
            return null;
        });
    }
}
```
