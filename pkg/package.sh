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

mkdir $PKG_ROOT

cp target/eve-0.0.1-SNAPSHOT.jar $PKG_ROOT/
cp start.sh $PKG_ROOT/
cp stop.sh $PKG_ROOT/

tar -czf ../$APP_NAME.tar.gz $PKG_ROOT/
chmod 755 ../$APP_NAME.tar.gz
