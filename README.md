# Spark Strava

Processing my personal cycling data from the [Strava iOS App](http://strava.com/) using Apache Spark. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Docker
- 
```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Structure
There are 2 implementations of each package, a Scala and a Kotlin one. 
    
####Modules
* `general`: basic analytics on a csv file with ~500 rides worth of data.
* `suspension`: comparisons of bike ride data using an air shock and a coil shock. Unfortunately, raw data is in HTML as Strava does not allow you to download segment data directly, so logic for extracting data from the HTML lives here.

## Built With
* [Kotlin](https://kotlinlang.org/) - 1.3.21
* [Scala](https://www.scala-lang.org/) - 2.13.1
* [Apache Spark](https://spark.apache.org/) - 2.4.3
* [ElasticSearch](https://www.elastic.co/) - 7.5.1
    * [ElasticSearch High Level REST Client](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-getting-started-maven.html)
* [Gradle](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## License

This project is licensed under the MIT License.

