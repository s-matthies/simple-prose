# Simple Prose

A simple prose builder for constructing text content from individual sentences, enhanced with weather data integration.

## Overview

**Simple Prose** provides a flexible way to construct text content by registering and combining sentences. It serves two main purposes:

1. **Basic Text Construction**: A simple system for building text content from individual sentences
2. **Weather Integration**: Enhanced functionality to incorporate real-time weather data into your text content

### Key Concepts
- Simple sentence composition
- Flexible text construction
- Weather data integration

## Weather Integration

Converts weather data into natural language text, combining a simple prose processing library with OpenWeather API integration.
It provides formatted weather information for different cities in a readable, prose format.

### Features

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

**Another option: Direct Input**
You can also enter the variable directly in the Environment variables field using format: `OPENWEATHER_API_KEY=your-api-key`
Note: Run configurations containing sensitive data should not be shared or committed to version control.


