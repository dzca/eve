#!/bin/bash

APP_NAME=eve

pid=`ps -ef | grep  $APP_NAME  | grep -v grep |awk '{print $2}'`
echo $pid
if [ -z "$pid" ]
then
	echo "Service $APP_NAME is down, exit..."
#	exit 0
else
	echo "Killing $APP_NAME service"
	kill -9 $pid
fi

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

# if [ -n "$pid" ]
# 	echo "Service $APP_NAME is running..."
# then
#
# else
# 	echo "Service $APP_NAME is down"
# fi
