docker image build -t mdsdb:1.0 ./db/.
docker rm -f mdsdb
docker-compose -f ./db/docker-compose.yml up -d --force-recreate