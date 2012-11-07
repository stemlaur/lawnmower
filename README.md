# Lawnmower project

Here I describe important things about way I developed this project. If you're interested in my development and design skills, you might be interested in reading this. 

**And if you disagree with what you read, please share your opinion with me :)**

## Technical information

### Java project

The project has been developped on a Windows 8, with Java version 1.6.0_33, using Apache Maven 3.0.3, and Eclipse Indigo.
I used two helpful librairies :
* Google guava
* Commons lang
* Log4J (+ SLF4J)

Because my test should run on any platform, I unit test that my project works for windows or unix CR.

### Versioning

I created a tag with the final version of the project. Version 1.0.0 accessible here [].

### How to compile or launch the unit tests

I used Maven to build this project, so it makes compilation and test run very easy :

`mvn clean compile`

`mvn clean test`

### How to run the project

I created a main class `com.mowitnow.lawnmower.Main.java`, you can execute it by passing in parameter the path of the file with commands.

**We assume that the file is given in ASCII**

## Classes definition

### Actors and responsabilities

To define the model definition, I needed to stick to the requirements, but to determine as well the actors and responsabilities.

#### Actors

* The vehicle, that has a cardinal direction and a position in the playground
* The cardinal directions, because these are constants, I chosed it to be an `Enum`
* The position, and I considered that a position is immutable
* The dimension, immutable as well

#### Responsabilities

Who should change the position and the direction of the Vehicle ? Who should ensure that the Vehicle does not leave the playground ?

* The `Vehicle` is **NOT IMMUTABLE** because it's direction and position can be changed, but I decided instead of using basic setters for direction, to limit the operation to `turnRight` and `turnLeft`
* The `Playground` ensure that the Vehicle does not leave the playground, because it knows what is its dimension. So the `Playground` is not a POJO, it is the core of the project, responsible of moving the Vehicle properly.
* A `CommandExecutor` is used to parse a `java.io.Reader` containing the commands and returns the Vehicle with the last positions. I chosed to work with `java.io.Reader` because it is easily mockable with a `java.io.StringReader` in the UnitTest. Plus, we can separately test the command parser and the file reader.
* The `ImportFileCommandService` class is a service that can be used to pass a file path and retrieve the list of vehicles. It's the one used in the Main class to import the commands of a file.

## Go further (Philosophical questions)

There are few questions about the code that are interesting to talk about, because it has been a big debate between developers in previous projects.

### Why you don't have a Command object ? ###

We can ALWAYS do better, and I decided to stop there to **KISS**. But I could have thought of a Command object that represents command found in the `java.io.Reader`. 

### Should object responsible of testing it's values ? ###

I decided that the object can test it's values, if they are instantiated with `null` objects for example. I throws RuntimeExceptions but I precise in the JavaDoc when the input should not be `null`, and I Unit Test it.

### How to handle exceptions ? ###

Instead of creating on exception class per type of exception (occuring in the parsing of the `java.io.Reader`), I created only one with different messages. It makes the client of the class ambiguous of why he got an exception (only the message can help), but it was faster to write this way, and for a small project, once again, I prefer to **KISS**.