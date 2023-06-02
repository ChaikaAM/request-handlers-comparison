# Performance Comparison - Thread Pool vs Virtual Threads (Project Loom) in Spring Boot Applications
This is a project for measuting performance results of different request handling approaches:
* Thread Pool
* WebFlux
* Coroutines
* Virtual Threads (Project Loom)

Performance measurements are done using JMeter - see [jmeter-file](jmeter/LoadTest.jmx)  
Detailed results and conclusion could be found in [Article on DZone - Performance Comparison - Thread Pool vs Virtual Threads (Project Loom) in Spring Boot Applications](https://dzone.com/articles/request-handling-approaches-threadpool-webflux-cor)