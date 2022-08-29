From openjdk
EXPOSE 8092
Add target/SportyShoes-0.0.1-SNAPSHOT.war app1.war
ENTRYPOINT ["java","-jar","app1.war"]