# Docker build

```
cd frontend/
docker build -t cars_frontend .
```

# Docker run

```
docker run --rm -p 8080:8080 -v $PWD:/usr/src/app cars_frontend
```

# Docker debug

```
docker run --rm -it -p 8080:8080 -v $PWD:/usr/src/app cars_frontend sh

# inside container

# run dev
npm dev

# build
npm build


```
