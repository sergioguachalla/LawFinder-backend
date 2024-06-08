#!/bin/bash

# package the app
./mvnw clean package -DskipTests
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#build docker image
echo "####################"
echo "Building docker image"
echo "####################"

echo -n "Docker container name (lawfinder-backend): "
read container_name

if [ -z "$container_name" ]; then
    container_name="lawfinder-backend"
fi

while [[ -z "$version_tag" ]]; do
  echo -n "$container_name version tag: "
  read version_tag

  if [[ -z "$version_tag" ]]; then
    echo "Version tag cannot be empty!"
  fi
done

docker build -t $container_name:$version_tag .

echo "####################"
echo "Docker image built"
echo "####################"

