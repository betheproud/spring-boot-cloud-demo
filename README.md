# 계속적으로 서비스들이 추가 되면서 오작동 되는 부분들이 있습니다.
다시 정리하고 테스트 후 다시 공지하겠습니다.


## How to run

1. Run discovery-service
2. Run spring-boot-admin-service
3. Run config-service
4. Run trace-service
5. Run edge-service
6. Run api-user-service and api-pay-service


## spring-boot-cloud sample

see also: https://blog.asarkar.org/technical/netflix-eureka/


### spring-boot-admin

see also: https://github.com/codecentric/spring-boot-admin


### spring-boot zuul router and filter

see also: https://bushkarl.gitbooks.io/spring-cloud/content/spring_cloud_netflix/router_and_filter_zuul.html


### zipkin 

If trace IDs in the log files are not enough, you can perform a more sophisticated trace analysis by using Zipkin. Zipkin is an application that collects tracing data and displays detailed data about it in a web UI. This data contains the duration of the single steps between services among a lot of other things.

see also: 

http://www.baeldung.com/tracing-services-with-zipkin

https://cloud.spring.io/spring-cloud-sleuth/single/spring-cloud-sleuth.html

### sleuth

Spring Cloud Sleuth is a library that supports implementing such a trace ID.

https://reflectoring.io/tracing-with-spring-cloud-sleuth/

 
