# Project Selection

Car Dealership.

## Domain

Car Dealership applicaiton which provides a simple RESTful API to retrieve cars from an inventory list. With optional query params user can retrieve specific cars.

## Interface

Car Dealership is powered by a Vue application which has multi selector for the filter options.

# Docker

Easiest way to get started is to build and run with Docker and DockerCompose.

```sh
# Will build and run the stack
docker-compose up --build
```

# Run Application

Then go to http://127.0.0.1:8080 for web UI.

For Further details about the Domain please look at the following.

## Build image(backend Java)

```
cd backend/
docker build -t car_dealership .
```

## Run Container

```
docker run --rm -p 8085:8085 car_dealership
```

PS. by default server runs on port 8085.

## Run Test

```
 docker run --rm car_dealership sh ./mvnw test
```

# Cars API

This service is written in Java with SpringBoot. It provides simple API to retrieve cars.
Optional: Pass query params to retrieve specific cars

- `GET /cars` - list all cars
- `GET /cars?color=Red&sun_roof=false` - get a car by color and sun rood option

## Possible filter options

| name             | possible values | type    |
| ---------------- | --------------- | ------- |
| color            | "Red", "White"  | String  |
| sun_roof         | true, false     | boolean |
| four_wheel_drive | true, false     | boolean |
| low_miles        | true, false     | boolean |
| power_windows    | true, false     | boolean |
| navigation       | true, false     | boolean |
| heated_seats     | true, false     | boolean |

Note: When trying to query by multiple options service will `AND` all filter options.

## Usage

```
curl --request GET --url 'http://localhost:8085/cars?color=Red'
```

## Response

The JSON object structure is as follows:

```json
[
  {
    "make": "Toyota",
    "year": 2014,
    "color": "Red",
    "price": 19248.0,
    "hasSunroof": true,
    "hasLowMiles": true,
    "hasPowerWindows": true,
    "hasNavigation": true,
    "hasHeatedSeats": true,
    "_id": "59d2698ce2e7eeeb4f109001",
    "isFourWheelDrive": false
  }
]
```

Server status code:

| code | definition              |
| ---- | ----------------------- |
| 200  | Valid response          |
| 204  | No Content (Empty List) |
| 500  | Server error            |
