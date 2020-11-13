# Docker build

```
cd frontend/
docker build -t cars-api .
```

# Docker run

```sh
docker run --rm -it -p 8085:8085 -v $PWD:/usr/src/app cars-api sh

# install
./mvnw install

# run test
./mvnw test

# run dev
./mvnw  spring-boot:run

# run app
java -jar /usr/src/app/target/car_dealership-0.0.1-SNAPSHOT.jar
```
