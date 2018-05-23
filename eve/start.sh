#!/bin/bash

APP_NAME=eve

echo "Starting Service $APP_NAME ..."

java -jar $APP_NAME-0.0.1-SNAPSHOT.jar \
-Xms16m \
-Xmx64m \
-XX:MaxMetaspaceSize=64m \
-XX:CompressedClassSpaceSize=8m \
-Xss256k \
-Xmn8m \
-XX:InitialCodeCacheSize=4m \
-XX:ReservedCodeCacheSize=8m \
-XX:MaxDirectMemorySize=16m &
