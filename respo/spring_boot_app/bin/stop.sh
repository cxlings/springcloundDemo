#!/usr/bin/env bash


dir=${BASH_SOURCE-$0} # 脚本名称，绝对路径
dirname="$(dirname $dir)";
parent="$( cd $dirname/..; pwd; )";
echo $parent;


java="$(which java)"
echo $java;


pidFile="$dirname/main.pid";

if [[ -f $pidFile ]]; then
    pid="$( cat $pidFile )"
    content="$(ps -ef | grep $pid )  ";
    echo "$content ";
    echo "try to stop";
    kill ${pid}; rm $pidFile;
else
    echo "start up ";
fi