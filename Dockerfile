FROM openjdk:jre-alpine
MAINTAINER Anthony Cramp <anthony.cramp@gmail.com>

WORKDIR /root/app

COPY ./out/production/sheepywolfy/*.class /root/app/
COPY ./lib/*.jar /root/app/
COPY ["Wolf Sheep Predation.nlogo", "/root/app/"]

ENTRYPOINT ["java", "-cp", \
            "asm-all-3.3.1.jar:gson-2.7.jar:NetLogo.jar:picocontainer-2.13.6.jar:scala-library-2.9.2.jar:.", \
            "Main"]
