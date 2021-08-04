# Programming Problems

**TnC**
- Overview
- Project Setup
  - Logging Setup
  - Unit Test Support
- References

## Overview
Programming Problems on data structures & algorithms. 
 
## Project Setup

### Logging Setup 
Project relies on logback logging framework. 
The [Logback Dependency] to logback-classic pulls logback-core.jar and slf4j-api.jar as well.

[Logback Configuration] is provided by logback.xml under the main resources.
By default, project uses 'debug' level logging which can be changed to other levels either in the file or by using a command live override.
 
### Unit Test Support

**JUnit 5 Integration**\
build.gradle is updated based on sample project at https://github.com/junit-team/junit5-samples/tree/r5.7.0/junit5-jupiter-starter-gradle

**Matcher**
    ```testImplementation 'org.hamcrest:hamcrest:2.2'```

[Hamcrest Dependency] is managed by gradle.
[AssertJ] is included to provide fluent assertion apis.
 
 
## References
- [Logback Configuration]
- [Logback Dependency]

---
[Logback Configuration]: http://logback.qos.ch/manual/configuration.html 
[Logback Dependency]: http://logback.qos.ch/setup.html#ide
[Hamcrest Dependency]: http://hamcrest.org/JavaHamcrest/distributables#using-hamcrest-in-a-gradle-project
[AssertJ]: https://assertj.github.io/doc/#assertj-core-quick-start
