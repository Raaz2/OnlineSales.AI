# Math Expression Evaluator

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Endpoint](#api-endpoint)
- [Swagger Documentation](#swagger-documentation)
- [Configuration](#configuration)
- [Testing](#testing)
- [Improvements](#improvements)
- [Contributing](#contributing)

## Prerequisites

Before running the application, make sure you have the following prerequisites installed:

- Java 8 or higher
- Apache Maven
- Wolfram Alpha API Key (You can get it from [Wolfram Alpha Developer Portal](https://products.wolframalpha.com/api/))

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/math-expression-evaluator.git
   ```

2. Navigate to the project directory:

   ```bash
   cd math-expression-evaluator
   ```

3. Open the `application.properties` file and replace `YOUR_WOLFRAM_ALPHA_API_KEY` with your actual Wolfram Alpha API key.

4. Build the application using Maven:

   ```bash
   mvn clean install
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

The application will start, and you can access it at `http://localhost:8080`.

## Usage

To evaluate mathematical expressions, send a POST request to the `/evaluate` endpoint with the expressions as the request body in text format(raw). Each expression should be on a new line, and use "end" to signal the end of expressions. The application will return the results.

## API Endpoint

- **POST /evaluate**: Evaluate mathematical expressions in bulk. Send expressions in the request body, one per line. Use "end" to signal the end of expressions. Returns the results.

### Sample Input
```
2 * 4 * 4
5 / (7 - 5)
sqrt(5^2 - 4^2)
sqrt(-3^2 - 4^2)
add(10, 199)
subtract(999, 25)
end
```

### Sample Output

```
2 * 4 * 4 => 32
5 / (7 - 5) => 2.5
sqrt(5^2 - 4^2) => 3
sqrt(-3^2 - 4^2) => 5i
add(10, 199) => 209
subtract(999, 25) => 974
```

## Swagger Documentation
You can access the Swagger documentation to understand the API and test it using Swagger UI. Here's how:

Start the application as mentioned in the "Getting Started" section.

Open your web browser and go to the Swagger UI page:

```
http://localhost:8080/swagger-ui.html
```
This page provides an interactive interface to explore and test the API endpoints.

## Configuration

You can configure the Wolfram Alpha API key and base URL in the `application.properties` file. Here are the configuration properties:

- `wolframalpha.api.appid`: User can acquire their own Wolfram Alpha API key.
- `wolframalpha.api.baseUrl`: http://api.wolframalpha.com/v1/result

## Testing

The application includes unit tests for the controller and service classes. You can run the tests using Maven.

## Improvements

- Implement error handling for API responses and user input validation.
- Add logging for better debugging and monitoring.
- To handle API rate limits (50 req/s) while processing 500+ expressions/s, implement a request queue with rate limiting and concurrency control mechanisms to ensure smooth and controlled API interactions, avoiding overloading.

- Dockerize the application for easy deployment.
- Implement global exception handling for consistent error responses.
- Expand test coverage to include edge cases.

## Contributing

Contributions are welcome! If you have suggestions, bug reports, or feature requests, please open an issue or create a pull request.