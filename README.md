# Java EE 8 + Self-Contained Gradle Build + CI Pipeline

This application demonstrates the following technologies put together

* JEE 8
  - CDI
  - JSF
  - TODO: add more JEE features ( Security, Jax-RS, JPA, Messaging, RxJava?? ....)
* Self-contained build/test Gradle script. Running this application does't require any JEE 8 Server
pre-installed on your local dev computer.
* TODO: Helm chart for deployment on a Kubernetes cluster
* TODO: CI/CD Pipeline (Jenkins file or similar setup)


## Prerequisite

* Git clone this repository
* cd into the directory where you cloned this repo to

## Build and Run

#### Start the application:

```

gradlew libertyRun

```

Then go to: `http://localhost:9080/cwgenJsf/`


#### Stop the server:
```

gradlew libertyStop

```

TODO: add docker, helm, etc...

## About the Application Itself

It is an application which generates a word search puzzle, can also be used to generate crossword
puzzle. User should specify the following parameters:

* rows of the board
* columns of the board
* density of the board to be filled (should be a value between 0.1 to 1.0)
* shortest length of words allowed in the board

You can find the API specification here:
[Crossword Generator OpenAPI spec](https://github.com/nnworkspace/crossword-gen-api/blob/master/src/main/api/crossword-gen-api.yaml)
More about the generator:
[https://github.com/nnworkspace/crossword-gen-java](https://github.com/nnworkspace/crossword-gen-java)


## Docker Commands

Build: `docker build -t nnworkspace/crossword-jsf:latest -t nnworkspace/crossword-jsf:v0.2 .`

Check images: `docker image ls`

Run the application from docker: `docker run -it -p 80:9080 -p 443:9443 nnworkspace/crossword-jsf:latest`

Stop a running container: `docker stop <container id/name>`

Start a stopped container: `docker start <container id/name>`

Access the application: [http://localhost:80/cwgenJsf](http://localhost:80/cwgenJsf)

> **_NOTE:_**  The context root string `cwgenJsf` is in the file `build.gradle` specified. By every build, the Gradle plugin _liberty-gradle-plugin_ will generate a `bootstrap.properties` file, which has a property `app.context.root=cwgenJsf`. The generated `bootstrap.properties` can be found in the path `./build/wlp/usr/servers/defaultServer/bootstrap.properties`.


## Special Thanks and Further Reading

* [Hansty Bai's JEE 8 By Examples](https://hantsy.gitbooks.io/java-ee-8-by-example/content/overview.html)
* [jakarta.io: Future of the JEE world](https://jakarta.ee/)
* The very responsive OpenLiberty support team on GitHub
* ....
