FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD ./target/test-order-1.0.jar test-order.jar
ENTRYPOINT ["java","-jar","test-order.jar"]