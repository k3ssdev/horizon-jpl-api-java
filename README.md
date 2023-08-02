# Getting Started with the Horizons API using Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## About the Horizons API

The JPL Horizons on-line solar system data and ephemeris computation service provides access to key solar system data and flexible production of highly accurate ephemerides for solar system objects (1,299,227 asteroids, 3,881 comets, 290 planetary satellites {includes satellites of Earth and dwarf planet Pluto}, 8 planets, the Sun, L1, L2, select spacecraft, and system barycenters).

To make use of the API, an input file must be created containing settings appropriate for the desired ephemeris results. Please refer to the Horizons batch example/instructions for detailed information on the possible settings. Note that an alternate Horizons API is also available, which uses the HTTP GET method to send Horizons parameters as query parameters via the URL.

## Java Horizons API Query

To query the Horizons API with Java, follow these steps:

1. Make sure you have Java Development Kit (JDK) 8 or above installed.
2. Clone this repository to your local machine.
3. Open the project in your preferred Java development environment.
4. Edit the `query_parameters.txt` file and customize the parameters based on your desired query.
5. Run the `HorizonsQuery.java` class to send the Horizons API query and retrieve the data.
6. The results will be saved in the `results.txt` file.

## Python Example Program

An example program in Python is also provided for querying the Horizons API. Follow these steps to run the program:

1. Make sure you have Python installed on your machine.
2. Open the `horizons.py` file.
3. Customize the parameters in the file based on your desired query.
4. Open a terminal or command prompt and navigate to the project directory.
5. Run the program using the command `python horizons.py`.
6. The results will be displayed in the console.

## Horizons API Documentation

For more information on the Horizons API and available parameters, refer to the following documentation:

- [Horizons API Web Interface](https://ssd-api.jpl.nasa.gov/doc/horizons.html): This web interface provides an overview of the Horizons API, including available queries and parameters.

- [Horizons API Batch Interface](https://ssd-api.jpl.nasa.gov/doc/horizons_file.html): This batch interface documentation explains how to create an input file and customize the parameters for desired ephemeris results.

## Contributing

Contributions to this project are welcome! If you have any suggestions or improvements, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
