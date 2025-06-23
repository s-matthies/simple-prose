# Simple Prose

![Java](https://img.shields.io/badge/Java-21%2B-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.9.9-brightgreen.svg)
![Version](https://img.shields.io/badge/version-1.0.0-orange.svg)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

A flexible system for constructing text content by combining weather data and sentences from multiple contributors.

### Features

- Simple sentence composition and flexible text construction
- Fetch real-time weather data for any city worldwide
- Convert weather data into natural language sentences
- Support for multiple cities simultaneously
- Flexible output formatting using SimpleProse or ProseBuilder

## Prerequisites

- Java 21+
- Maven
- OpenWeather API Key

## Components Used

1. **Core Component**

   `Simple Prose` uses the Prose Builder as its foundation for text construction:

   - [Repository](https://github.com/bs-jokri/prose-builder)
   - Maven Artifact: `de.htw_berlin.fb4.ossd:prose_builder:1.0-SNAPSHOT`
   

2. **Peer Components**

   `Simple Prose` combines the following components to generate diverse sentence combinations:

   - [`joha1na/my-prose-app`](https://github.com/joha1na/my-prose-app)
   - [`eliseHtw/my-prose-app`](https://github.com/eliseHtw/my-prose-app)


### Example Output

> When running the application, you'll get a combined output from all components, for example:
> ```
> In Berlin sind es aktuell 25,7 °C.
> Hallo, das ist ein einfacher Satz.
> Ich esse heute Abend Salat
> ```

## Getting Started

### Using as a Maven Dependency
1. Add the GitHub Package Registry to your Maven settings (`~/.m2/settings.xml`):
   ```xml
   <settings>
     <servers>
       <server>
         <id>simple-prose-github</id>
         <username>YOUR_GITHUB_USERNAME</username>
         <password>YOUR_GITHUB_TOKEN</password>
       </server>
     </servers>
   </settings>
   ```
   > **Note:** Replace `YOUR_GITHUB_USERNAME` and `YOUR_GITHUB_TOKEN` with your credentials. The token needs `read:packages` scope.

2. Add the repository configuration to your project's `pom.xml`:
   ```xml
   <repositories>
     <repository>
       <id>simple-prose-github</id>
       <url>https://maven.pkg.github.com/s-matthies/simple-prose</url>
     </repository>
   </repositories>
   ```

3. Add the dependency to your `pom.xml`:
   ```xml
   <dependency>
     <groupId>com.github.s-matthies</groupId>
     <artifactId>prose-sample</artifactId>
     <version>VERSION</version>
   </dependency>
   ```
   > Replace `VERSION` with the current version from the [Package Registry](https://github.com/s-matthies/simple-prose/packages/2519474)

> **Important**: To use the weather integration features, you'll need a free API key from OpenWeather. Follow the steps below to set it up.

## Open Weather API Key Configuration

#### Getting an API Key
1. Visit [OpenWeather](https://openweathermap.org/api)
2. Create a free account
3. Navigate to "My API Keys"
4. Copy your API key

#### Setting up in IntelliJ IDEA
1. Click on the Run Configuration dropdown in the toolbar
2. Select "Edit Configurations..."
3. Select your Run Configuration or create a new one
4. Find the "Environment variables" section
5. Click the folder icon next to the field
6. In the "Environment Variables" dialog:
   - Click the Plus icon (+)
   - Name: `OPENWEATHER_API_KEY`
   - Value: Paste your API key here
7. Confirm with "OK" and then "Apply"

**Another option: Direct Input**
You can also enter the variable directly in the Environment variables field using format: `OPENWEATHER_API_KEY=your-api-key`
Note: Run configurations containing sensitive data should not be shared or committed to version control.


## Building from Source

1. Clone the repository:
   ```bash
   git clone https://github.com/s-matthies/simple-prose.git
   cd my-prose-app
   ```

2. Build the project with Maven:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   java -jar target/prose-sample-1.0-SNAPSHOT.jar
   ```

   > Make sure you have configured the OpenWeather API Key environment variable as described in the Configuration section before running the application.
   
## Contributing
For contribution guidelines, please see [CONTRIBUTE.md](CONTRIBUTE.md).

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.
