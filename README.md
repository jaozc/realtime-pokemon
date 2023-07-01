# realtime-pokemon
 A real time random pokemon selector made with Spring, JS and Kafka

# Tecnologia utilizadas

Apache Kafka, Spring, Spring Boot, Apache Maven, Java 17, HTML, JavaScript, WebSockets e Docker.

# Como executar

3 aplicações precisam ser inicializadas para o funcionamento adequado da aplicação.

## Executando o Apache Kafka

Abra o diretório **/realtime-pokemon/kafka** em seu terminal e execute o seguinte comando:

> docker-compose up -d

O comando acima irá executar a nossa imagem docker em segundo plano, essa imagem é responsável por instanciar o Zookeeper e o Kafka da nossa aplicação. Caso mais a frente seja necessário, tente criar o tópico "random-pokemon" no Kafka para que as próximas aplicações sejam capazes de utilizar o tópico descrito.

## Executando o Produtor da aplicação

Abra o diretório **/realtime-pokemon/backend/realtime-producer** em seu terminaç e execute o seguinte comando:

> mvn spring-boot:run

O comando acima pedirá que o Apache Maven compile e execute o produtor da nossa aplicação.

## Executando o Consumidor da aplicação

Abra o diretório **/realtime-pokemon/backend/realtime-consumer** em seu terminal e execute o seguinte comando:

> mvn spring-boot:run

O comando acima pedirá que o Apache Maven compile e execute o consumidor da nossa aplicação.

# Visualizando os dados

Tanto a aplicação Produtora e Consumidora exibem no terminal os pokémons produzidos e consumidos, mas essa visualização é sem graça e nada visual. Por isso, acessando o diretório **/realtime-pokemon/frontend** e abrindo o arquivo **index.html** em seu browser de preferência, será possível encontrar um arquivo HTML que se conecta com o WebSocket da aplicação consumidora e exibe os pokémons consumidos em tempo real.


> have fun 😀

## Considerações

O arquivo docker-compose na raiz do projeto não apresenta o funcionamento adequeado, por favor não executar!