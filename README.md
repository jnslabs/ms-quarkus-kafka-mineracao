# ms-quarkus-kafka-mineracao
Projeto desenvolvera sistema para mineradora para contação de contratos

## Inicializar projeto

### Start container Kafka
`workspace docker`

### Start Container Postgres
`workspace docker`

* Criar Banco proposaldb

* Criar Banco reportdb

### Keycloak

* Docker

```
docker run -p 8180:8080 --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin  quay.io/keycloak/keycloak:21.1.1 start-dev
```

### Jaeger

* Docker

```
docker run -p 5575:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 jaegertracing/all-in-one:latest
```
