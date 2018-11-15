# Java EE 8 + Self-Contained Gradle Build + CI Pipeline 

This application demonstrates the following technologies put together

* JEE 8 
  - CDI
  - JSF
  - TODO: add more JEE features
* Self-contained build/test Gradle script. Running this application does't require any JEE 8 Server 
pre-installed on your local dev computer. 
* TODO: dockerization of the application
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
[https://github.com/nnworkspace/crossword-gen-api/blob/master/src/main/api/crossword-gen-api.yaml](Crossword Generator OpenAPI spec)

More about the generator:
[https://github.com/nnworkspace/crossword-gen-java](https://github.com/nnworkspace/crossword-gen-java)