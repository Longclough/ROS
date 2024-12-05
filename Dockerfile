FROM ubuntu:22.04

WORKDIR /hmi-app

COPY ./hmi /hmi-app

RUN apt-get update && apt-get install -y \ 
    libgl1-mesa-glx \ 
    libxext6 \
    libxrender1 \
    openjdk-17-jdk \
    maven \
    && rm -rf /var/lib/apt/lists/*

#RUN mvn compile


#CMD ["mvn", "exec:java", "-Dexec.mainClass=com.hmi.router.Application"]








