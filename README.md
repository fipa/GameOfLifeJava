# Personal version of Game of Life
Just for fun and practice, always a work in progress.

For more details on Game of Life, visit <a href="https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life">Wikipedia</a>

## Packaging
mvn package -DskipTests

## Running
java -jar target/GameOfLife.jar

## Run mutation tests
mvn org.pitest:pitest-maven:mutationCoverage

