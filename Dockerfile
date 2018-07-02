FROM openjdk:8-jdk-alpine
	VOLUME /tmp
	COPY target/claudsan-1.0.0.jar claudsan-app.jar  
	COPY /init.json init.json
	CMD mongoimport --host mongodb --db flart --collection clients --type json --file /init.json --jsonArray
	ENTRYPOINT ["java", "-jar", "/claudsan-app.jar"]
