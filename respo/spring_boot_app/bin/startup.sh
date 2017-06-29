#!/usr/bin/env bash



dir=${BASH_SOURCE-$0} # 脚本名称，绝对路径
dirname="$(dirname $dir)";
parent="$( cd $dirname/..; pwd; )";
echo $parent;


java="$(which java)"
echo $java;


pidFile="$dirname/main.pid";
if [[ -s $pidFile ]]; then
	#statements
	echo "exist pid file please stop $pidFile";
	exit;
fi

jarFile="$parent/target/spring_boot_app-1.0-SNAPSHOT.jar";

opt=" -jar ${jarFile}";
echo "$opt";
if [[ -f $jarFile ]]; then
	#statements
	echo "exist file  ${opt} ";
	cd $parent; $java  ${opt} &
	echo $! >> $pidFile;
else
   echo "jav file not exist ";
   cont="$( mvn package )";
   exitCode="$?"; ##前一个命令的退出码；
   if [[ $exitCode > 0 ]] ; then
       echo "failed $exitCode";
       rm $jarFile;
     else
     	cd $parent; $java  ${opt} $@ &
       echo $! >> $pidFile;
   fi
fi











