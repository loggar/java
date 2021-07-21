```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <executions>
        <execution>
            <id>copy-dependencies</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>copy-dependencies</goal>
            </goals>
            <configuration>
                <outputDirectory>${project.build.directory}/classes/lib</outputDirectory>
                <overWriteReleases>false</overWriteReleases>
                <overWriteSnapshots>false</overWriteSnapshots>
                <overWriteIfNewer>true</overWriteIfNewer>
            </configuration>
        </execution>
    </executions>
</plugin>

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <!-- <classpathPrefix>lib</classpathPrefix> -->
                <!-- <mainClass>test.org.Cliente</mainClass> -->
            </manifest>
            <manifestEntries>
                <Class-Path>lib/</Class-Path>
            </manifestEntries>
        </archive>
    </configuration>
</plugin>
```

The first plugin puts all dependencies in the target/classes/lib folder, and the second one includes the library folder in the final JAR file, and configures the Manifest.mf file.

But then you will need to add custom classloading code to load the JAR files.
