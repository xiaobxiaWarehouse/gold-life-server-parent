#!/bin/bash

PID=$(ps -ef | grep mc-sender-web.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo "MC-Sender-web has stopped!"
else
    echo "shutdown MC-Sender-web $PID"
    kill $PID
fi
