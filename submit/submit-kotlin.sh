#!/bin/bash

cp ./build/libs/spark-=strava-1.0.0-all.jar ${SPARK_APPLICATION_JAR_LOCATION} &&

sh ./submit/submit.sh