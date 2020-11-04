
# API Exemplo Quarkus

Este código tem como por objetivo apresentar as funcionalidades básicas do quarkus referente a implementação do 
Microprofile e aderência a cloud native applications.

### Ferramentas Utilizadas

- Java SE Development Kit (Versão 11)
- Eclipse IDE
- Maven
- Docker
- Docker Compose

## Construído Com:

- [Quarkus](https://quarkus.io/)
- [Maven](https://maven.apache.org/)



### Referência

- Este projeto segue as recomendações [**CloudNative**](https://www.cncf.io/) e [**twelve-factor app**](https://12factor.net/) . 


### Desafios na arquitetura de microserviços

- Gerência de configuração
- Dinamismo e escalabilidade
- Aplicação distribuída
- Tracing e monitoramento
- Fault Tolerance (relisiência)

### Tecnologias utilizadas

| Artefato                        |Porta  | Descrição  |
|---------------------------------|------ |-----|
| ms_transacao                    | 8080  | Microserviço responsável por receber uma transação e realizar sua persistência |
| postgres-database               | 5432  | Banco de dados postgres responsável pelo armazenamento dos dados  |
| jaeger_service                  | 14268 | Serviço responsável por monitorar e rastrear o trace de chamada dos microserviços  |
| grafana-service                 | 3000  | Instância do Prometheus, responsável por obter as métricas dos microserviços e apresentar o monitoramento |
| prometheus-service              | 9090  | Responsável por obter as métricas de monitoramento dos microserviçoes e enviar para o Grafana  |


### Executando a aplicação em container

```sh
docker-compose up
```

