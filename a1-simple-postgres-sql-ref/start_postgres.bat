mkdir -p %userprofile%\.local\docker\postgresql

docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=local -d -p 5432:5432 -e PGDATA=\var\lib\postgresql\data\pgdata -v %userprofile%\.local\docker\postgresql\data:\var\lib\postgresql\data postgres
