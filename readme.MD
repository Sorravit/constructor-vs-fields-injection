# SpringBoot Constructor vs fields injection

### This project serves as an illustrative example in the Spring Boot framework, demonstrating the distinctions between constructor injection and field injection.

Now include AssertJ, Mapper, API Versioning, Logging via Slf4j and Model documentation and validation as well

1. IOC
    1. In traditional programming, objects are responsible for creating and managing their dependencies.
       This can lead to tightly coupled code and make it challenging to change or replace dependencies.
       Inversion of Control addresses this by inverting the control of creating and managing dependencies to an external
       container or framework.
       (Create the @component and @Autowired it when we use it instead of using new SomeGoodNamingObject())
    2. How IOC works in Spring
        1. Configuration Metadata: In Spring Boot, the configuration metadata is typically provided using annotations
           such as @Component, @Service, @Repository, and @Controller. These annotations mark the classes as
           Spring-managed components and indicate their role and purpose within the application.
        2. Spring will do component scan in all the same package or sub-package as the @SpringBootApplication
        3. Bean Creation: The container scans the application's classpath and identifies the classes annotated with the
           appropriate annotations. It then creates instances of these classes, known as beans, and registers them
           within the container. (Which will scan all class in the package and sub-package)
        4. Dependency Resolution: When creating beans, the container analyzes the dependencies declared by each bean
           and resolves them by looking for other beans in the container that can satisfy those dependencies.
           This process is known as autowiring.
           Note: In some cases that you did not specify the bean spring will do AutoConfiguration such as ObjectMapper
        5. Scope? probably will not include it in this example
    3. Benefit of IOC
        1. Loose Coupling: IOC promotes loose coupling between components by allowing dependencies to be resolved
           dynamically. This makes it easier to replace or modify dependencies without affecting other parts of the
           application.
        2. Testability: By delegating the responsibility of object creation to the container, it becomes easier to write
           unit tests for individual components. Dependencies can be mocked or stubbed during testing, enabling isolated
           testing of specific components.
        3. Modular and Maintainable Code: IOC encourages the development of modular and maintainable code by separating
           the construction and configuration of objects from their usage. This leads to code that is more focused on
           business logic and easier to understand and maintain.
2. Constructor vs field injection (See the code)
    1. Benefit of using Constructor injection
        1. Testability
            1. Faster Because we don't need to create Spring context at all
        2. Cyclic Dependency detection
            1. Spring does not support cyclic dependencies with constructor injection.
        3. Cleaner Code
            1. Seriously, If you have more than 3,4 parameters in your constructor, your class probably doesn't follow
               a "Single responsibility" principal
3. AssertJ
    1. It provides a more expressive and fluent API for writing assertions compared to the more traditional assertion
       methods provided by JUnit. AssertJ's fluent syntax allows you to write assertions in a more readable and natural
       language style, making your tests easier to understand and maintain.
    2. It provides a wider range of assertion features beyond basic assertion
    3. It can do chain assertion in case you need to do "assertThat(42).isEven().isGreaterThan(20).isLessThan(55);" for
       some reason
    4. Custom assertion: For example, you want to check that user have full name you expect you can do assertThat(user)
       .haveFullName("Big Bigger");
4. Mapper
    1. show example
    2. talk about ofNullable
5. Api Versioning
    1. Make sure to have the API version in front of your API in case we need to update the version ( Breaking change,
       remove some field ),
       we can just create new endpoint with a new version
6. Logging using @Slf4j rather than create your own logger or System.out.println()
    1. Standard Logging such as logging context information, stack traces, and exception handling. This can be
       invaluable for troubleshooting and debugging purposes, allowing you to capture relevant information when an issue
       occurs.
    2. Easy to config log level
    3. The logging levels used are ERROR, WARN, INFO, DEBUG and TRACE.
    4. SLF4J provides a very useful interface for working with parameters: logger.debug("Very important message: {}",
       message);
    5. Never use "System.out.println()" because it is blocking (not async)
7. Data Model documentation
    1. It will tell the user what that field is
    2. The example will be used as an example in swagger
8. Data Model Validation
    1. This is really clear!
   