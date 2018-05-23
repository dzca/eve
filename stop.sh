#!/bin/bash

APP_NAME=eve

pid=`ps -ef | grep  $APP_NAME  | grep -v grep |awk '{print $2}'`
echo $pid
if [ -n "$pid" ]
	echo "Service $APP_NAME is running..."
then
	echo "Killing $APP_NAME service"
	kill -9 $pid
else
	echo "Service $APP_NAME is done"
fi

