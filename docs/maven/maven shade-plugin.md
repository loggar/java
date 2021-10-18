# maven-shade-plugin

Create a single jar in its isolated dependencies

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <finalName>uber-${project.artifactId}-${project.version}</finalName>
    </configuration>
</plugin>
```

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.0.0</version>
            <executions>
                <execution>
                    <id>app-jar</id>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                    <configuration>
                        <finalName>studentApp</finalName>
                        <filters>
                            <artifact>*:*</artifact>
                            <excludes>
                                <exclude>META-INFO/﻿＊.SF</exclude>
                                <exclude>META-INFO/﻿＊.DSA</exclude>
                                <exclude>META-INFO/﻿＊.RSA</exclude>
                            </excludes>
                        </filters>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
