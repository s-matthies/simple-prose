# simple-prose - Weather Text Generator

A Java application that converts weather data into natural language text, combining a simple prose processing library with OpenWeather API integration.
Available via GitHub Packages, it provides formatted weather information for different cities in a readable, prose format.

## Features

- Fetch real-time weather data for any city worldwide
- Convert weather data into natural language sentences
- Support for multiple cities simultaneously
- Flexible output formatting using SimpleProse or ProseBuilder

## Prerequisites

- Java 21+
- Maven
- OpenWeather API Key

## API Key Configuration

### Getting an API Key
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

Alternative: You can directly enter the variable in the Environment variables field:

