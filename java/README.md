# Justification for This Project

I created this playground project to learn and experiment with Kafka.  More information about this project
can be found at <https://developer.confluent.io/get-started/java/>.  I took the sample code found on Confluent Developer Java portal, and made some customizations (e.g., add SLF4J logging, used a matrix data structure for the event key/value pairs, and other minor changes.)

## Prerequisites

This project has the following pre-requisites:

- Java 11
- Gradle
- Kafka Cluster has been set up in Confluent Cloud

## Kafka Cluster Set Up

1. I have signed up for a Confluent Account, and then I created a Basic Kafka Cluster
   following instructions from <https://www.confluent.io/confluent-cloud/tryfree/>.
2. While creating a Kafka Cluster on Confluent Cloud I chose to use the "Azure" Cloud
3. To facilitate easy identification of my cluster I named it "rubens_cluster"
4. After the cluster was created and named, I create a topic named "rubens_topic"
   within my Kafka cluster.

### Confluent Cloud Kafka Cluster Key Settings

Notice that the Kafka Cluster is made available over the public Internet

- cluster name       : "rubens_cluster"
- topic name         : "rubens_topic" with 1 partitions
- bootstrap server   : "pkc-57jzz.southcentralus.azure.confluent.cloud:9092"
- cluster API key    : "HV2ZKRSLDTK6YDCK"
- cluster API secret : "pirfdTaGaAGmKIlMzbiPx4Y9R8czku7hqAaL3j9Jb5jn7h/ShxMeUnS47oDg9KXT"

---
[Rubens Gomes](https://rubensgomes.com/)
