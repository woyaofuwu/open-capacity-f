#!/bin/sh

echo "Starting api-gateway app..."
echo "JVM options => $JAVA_OPTIONS"
echo

java $JAVA_OPTIONS -jar /opt/app-root/bin/api-gateway.jar
