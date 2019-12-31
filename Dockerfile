FROM openjdk:11
COPY . /usr/src/myshop
WORKDIR /usr/src/myshop
RUN javac -cp src src/Main.java
CMD ["java", "-cp", "src", "Main"]