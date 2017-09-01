set -e

cd ..

mvn package -Dmaven.test.skip=true


cd superman-web
mvn docker:build -DpushImage
