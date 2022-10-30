# Justification for This Project

This folder contains Confluent CLI information.

## Install Confluent Cloud and Confluent Platform CLI

- prerequisites: Confluent CLI v2.31.0 or above

1. Download and install platform CLI binary from [Confluent CLI Tarballs](https://docs.confluent.io/confluent-cli/current/install.html#tarball-or-zip-installation).
2. Refer to [.bash_profile](.bash_profile) for environment settings.

## Commands

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
