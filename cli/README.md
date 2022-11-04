# Justification for This Project

This folder contains "Apache Kafka CLI" and "Confluent CLI" installation information.

## Pre-Requisite: Linux VM Environment

It is best to run the CLI on a Linux VM.  I tried to run some of the exercises on Windows
10 Cygwin and ended up struggling with missing Linux commands and other environmental issues.

### Linux Additional Set Up

I am running the Confluent Basic "Confluent Fundamentals of Apache Kafka" Self-Paced Training
on my own Linux VM server:

- AlmaLinux release 8.6 (Sky Tiger)


## Install Apache Kafka CLI

1. Download and install Apache Kafka binary from [Apache Kafka CLI Downloads](https://kafka.apache.org/downloads).

### Apache Kafka CLI Commands

```bash

```

## Install Confluent Cloud and Confluent Platform CLI

- prerequisites: Confluent CLI v2.31.0 or above

1. Download and install platform CLI binary from [Confluent CLI Tarballs](https://docs.confluent.io/confluent-cli/current/install.html#tarball-or-zip-installation).
2. Refer to [.bash_profile](.bash_profile) for environment settings.

### Confluent CLI Commands

```bash
confluent login --save
confluent environment list
confluent environment use <environment Id>
confluent kafka cluster list
confluent kafka cluster use <cluster Id>
confluent logout
```

---
[Rubens Gomes](https://rubensgomes.com/)
