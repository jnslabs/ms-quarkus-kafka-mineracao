# ms-quarkus-kafka-mineracao
Projeto desenvolvera sistema para mineradora para contação de contratos

## Keycloak

* Docker

```
docker run -p 8180:8080 --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin  quay.io/keycloak/keycloak:21.1.1 start-dev
```

