#!/usr/bin/env bash

################################################
# Packaging the application
################################################
APP_NAME=eve
PKG_ROOT=../$APP_NAME

if [ -d $PKG_ROOT ]
then
    echo "delete $PKG_ROOT"
    rm -r $PKG_ROOT
fi

mkdir -v $PKG_ROOT
pushd ..
cp ./target/eve-0.0.1-SNAPSHOT.jar $APP_NAME/
cp ./run.sh $APP_NAME/
tar -czf $APP_NAME.tar.gz $APP_NAME/
chmod 755 $APP_NAME.tar.gz
popd
