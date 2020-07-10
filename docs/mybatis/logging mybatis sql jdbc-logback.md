# logging mybatis sql jdbc-logback

Dependency

```xml
<!-- log jdbc spy-sql -->
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1 -->
<dependency>
  <groupId>org.bgee.log4jdbc-log4j2</groupId>
  <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
  <version>1.16</version>
</dependency>
```

Datasource properties

```ini
jdbc.driverClassName=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
jdbc.url=jdbc:log4jdbc:mariadb://10.1.10.47:3306/DB_NAME
```

`log4jdbc.log4j2.properties`

```ini
log4jdbc.drivers=org.mariadb.jdbc.Driver
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
log4jdbc.dump.sql.maxlinelength=0
```

`logback.xml`

```xml
<logger level="info" name="org.mybatis.spring" additivity="false">
  <appender-ref ref="console" />
</logger>
<logger level="warn" name="jdbc.audit" additivity="false">
  <appender-ref ref="console" />
</logger>
<logger level="warn" name="jdbc.resultset" additivity="false">
  <appender-ref ref="console" />
</logger>
<logger level="warn" name="jdbc.resultsettable" additivity="false">
  <appender-ref ref="console" />
</logger>
<logger level="warn" name="jdbc.sqlonly" additivity="false">
  <appender-ref ref="console" />
</logger>
<logger level="info" name="jdbc.sqltiming" additivity="false">
  <appender-ref ref="console" />
</logger>
<logger level="info" name="jdbc.connection" additivity="false">
  <appender-ref ref="console" />
</logger>
```
