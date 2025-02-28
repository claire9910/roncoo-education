#!/bin/bash
# Copyright 2019-现在 LingKe, Co., Ltd.
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=$HOME/jdk/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/usr/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/opt/java
[ ! -e "$JAVA_HOME/bin/java" ] && unset JAVA_HOME
if [ -z "$JAVA_HOME" ]; then
  echo "Please set the JAVA_HOME variable in your environment, We need java(x64)! jdk8 or later is better!"
  echo
fi
export JAVA_HOME
export JAVA="$JAVA_HOME/bin/java"
export BASE_DIR=`cd $(dirname $0)/..; pwd`
export SERVER="system"
export CONFIG_LOCATION=file:${BASE_DIR}/conf/

# JVM Configuration
JAVA_OPT="${JAVA_OPT} -Xms512m -Xmx512m"
JAVA_OPT="${JAVA_OPT} -jar ${BASE_DIR}/target/${SERVER}.jar"
JAVA_OPT="${JAVA_OPT} --spring.config.additional-location=${CONFIG_LOCATION}"

function start()
{
  pid=`ps ax | grep -i roncoo.${SERVER} | grep java | grep -v grep | awk '{print $1}'`
  if [ x"$pid" != x"" ] ; then
    echo "${SERVER} is running..."
  else
    nohup "$JAVA" ${JAVA_OPT} roncoo.${SERVER} >/dev/null 2>&1 &
    echo "${SERVER} start success"
  fi
}

function stop()
{
  pid=""
  query(){
    pid=`ps ax | grep -i roncoo.${SERVER} | grep java | grep -v grep | awk '{print $1}'`
  }
  query
  if [ x"$pid" != x"" ] ; then
    kill ${pid}
    echo "${SERVER} stopping···"
    while [ x"$pid" != x"" ]
    do
      sleep 1
      query
    done
    echo "${SERVER} stop success"
  else
    echo "${SERVER} is stop"
  fi
}

case "$1" in
  start)
    start;;
  stop)
    stop;;
  *)
    $0 stop
    sleep 1
    $0 start
    ;;
esac