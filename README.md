# Manasbi Chautaari API

Manasbi Chautaari is a podcast that I founded and host on Anchor platform. Although the podcast is already available on
different popular platforms such as Spotify, Apple Podcasts and Google Podcasts, as a Software Developer, I
wanted to experiment with my podcast RSS feed and tailor to my needs either via a web application, mobile app or even
streamable under Manasbi Chautaari name.

Manasbi Chautaari API serves the endpoints to getting the metadata for the podcast. The application is written in Java
using Spring Boot framework. It consumes public RSS feed for the podcast and uses JAXB to unmarshall the XML content to
Java POJOs.

The application exposes two endpoints defined in
[PodcastContentController](src/main/java/com/manasbi/controller/PodcastContentController.java)

## Environment Variables

To run this project, pass the following environment variables

- `spring.config.activate.on-profile` : valid values are dev, local, prod

## Run Locally

Clone the project

```bash
  git clone https://github.com/manasbiparajuli/manasbi-chautaari-api
```

Go to the project directory

```bash
  cd manasbi-chautaari-api
```

## Installation

Open the project on IntelliJ as a maven project. As the project uses JDK19, ensure that IntelliJ is configured to run
the project using SDK of Java 19. For example, if you have Amazon Corretto 19 installed on your machine, you can
configure as below:

```File -> Project Structure -> SDK -> corretto-19```

To comply with coding standards, install the following plugins:

- google-java-format
- SonarLint
- Pom Format
- QAPlug
- QAPlug - Checkstyle
- QAPlug - FindBugs
- QAPlug - PMD
- CheckStyle-IDEA

The default entry for the application is under ```ManasbiChautaariApiApplicationClass.java``` The default spring profile
is set to local and can be overwritten by setting spring profile in environment variable.

To run the application from command line:

```bash
  mvn spring-boot:run
```

## Swagger Documentation

The default root directory for the project redirects to Swagger UI home page and can be accessed
at ```{domain}/api/v1/swagger-ui/index.html```

## API Reference

#### Get metadata about the podcast channel

```http
  GET /api/v1/channel
```

#### Get details about the podcast episodes

```http
  GET /api/v1/episodes
```

## Actuators

The project has configured actuators using Spring Actuator and only exposes the following endpoints: health, info. The
endpoints can be accessed at ```{domain}/actuator/{endpoint}```

## Authors

- [@manasbiparajuli](https://www.github.com/manasbiparajuli)

## Contributing

Contributions are always welcome!

See [CONTRIBUTING.md](CONTRIBUTING.md) for ways to get started.

Please adhere to this project's [code of conduct](CODE_OF_CONDUCT.md).

## Feedback

If you have any feedback, please open a GitHub issue and I will respond to it.

![Manasbi Chautaari Logo](src/main/resources/manasbi-chautaari-logo.jpeg)
