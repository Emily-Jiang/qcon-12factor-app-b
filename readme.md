# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you containing some endpoints which are called from the main application (see the `service-a` directory)

The generation of the executable jar file can be performed by issuing the following command

    mvn clean compile quarkus:build

This will create a jar file **quarkus-runner.jar** within the _target_ maven folder. This can be started by executing the following command

    java  -jar target/quarkus-runner.jar

You can also start the project in development mode where it automatically updates code on the fly as you save your files:

    mvn  clean compile quarkus:dev

Last but not least, you can build the whole application into a one statically linked executable that does not require JVM:

    mvn clean compile quarkus:native-image -Pnative

Native executable build might take a minute. Then you can execute it on a compatible architecture without JVM:

    ./target/quarkus-runner 

## Note on Native image

 * You need GraalVM installed from the GraalVM web site. Using the community edition is enough. Version 19.1.1+ is required.
 * The GRAALVM_HOME environment variable configured appropriately
 * The native-image tool must be installed; this can be done by running ```gu install native-image``` from your GraalVM directory

## Prepare for cloud deployment
### Build the docker image

    mvn clean compile quarkus:build
    docker build -t quarkus-service-b:1.0 .

### Test the docker image

    docker run -i --rm -p 8080:8080 quarkus-service-b:1.0 
    
   Test the image by hitting this url
   
    http://localhost:8080/data/client/service/host

## Specification examples


### JWT Auth

Have a look at the **TestSecureController** class (main application) which calls the protected endpoint on the secondary application.
The **ProtectedController** contains the protected endpoint since it contains the _@RolesAllowed_ annotation on the JAX-RS endpoint method.

The _TestSecureController_ code creates a JWT based on the private key found within the resource directory.
However, any method to send a REST request with an appropriate header will work of course. Please feel free to change this code to your needs.




### Rest Client

A type safe invocation of HTTP rest endpoints. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

The example calls one endpoint from another JAX-RS resource where generated Rest Client is injected as CDI bean.

