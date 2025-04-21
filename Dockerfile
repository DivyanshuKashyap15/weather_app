# Use an official OpenJDK image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy source code and weather data file into the container
COPY WeatherApp.java .
COPY weatherdata.txt .

# Compile the Java code
RUN javac WeatherApp.java

# Command to run the app
CMD ["java", "WeatherApp"]
