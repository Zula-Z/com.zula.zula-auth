# Local monitoring and infra stack for zula-auth

This single Docker Compose file stands up the service dependencies you need while running `zula-auth` in the `dev` profile: Postgres, RabbitMQ, Grafana, Prometheus, and a lightweight HTTP echo service that accepts the `/api/services/register` webhook the monitoring library calls.

## Bring it up

```bash
cd zula-auth-app/monitoring-infra
docker compose up -d
```

Postgres listens on `localhost:5432`, RabbitMQ on `localhost:5672`, Prometheus on `localhost:9090`, Grafana on `localhost:3000`, and the fake Datahog endpoint is available on `localhost:8080`. Prometheus is already configured (see `prometheus.yml`) to scrape `http://host.docker.internal:8081/actuator/prometheus`, so make sure the application is running on port `8081` while the stack is up.

When you stop work:

```bash
docker compose down
```
