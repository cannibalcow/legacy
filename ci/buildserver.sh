#!/usr/bin/env bash

echo "STAGE1: TEST"
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true -Dsonar.jacoco.reportMissing.force.zero=true

echo "STAGE2: SONARQUBE"
mvn sonar:sonar -Psonarqube
