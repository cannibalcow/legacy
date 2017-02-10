#!/usr/bin/env bash

echo "TEST"
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true -Dsonar.jacoco.reportMissing.force.zero=true

echo "SONARQUBE"
mvn sonar:sonar -Psonarqube
