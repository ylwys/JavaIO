#!/bin/bash

# 世界服务器0

# 设置启动参数
RUN_PARAM="0"

# 设置加载类的环境变量 运行主类名
CPATH="."
MAIN="com.test.AppMain"

#路径
gcFolder="/export/gc/"${PWD##*/}"/"
errorFolder="/export/error/"${PWD##*/}"/"
#如果不存在则创建
if [ ! -d "$gcFolder" ]; then
  mkdir "$gcFolder"
fi
if [ ! -d "$errorFolder" ]; then
  mkdir "$errorFolder"
fi

# 设置运行参数
JAVA_PARAMS="-server -Xms15g -Xmx15g -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m -XX:MaxDirectMemorySize=5g"
JAVA_PARAMS="$JAVA_PARAMS -XX:+UseG1GC -XX:MaxGCPauseMillis=150 -XX:+UseStringDeduplication"
JAVA_PARAMS="$JAVA_PARAMS -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -verbose:gc -Xloggc:"$gcFolder"gc.word0.log"
JAVA_PARAMS="$JAVA_PARAMS -XX:ErrorFile="$errorFolder"hs_err_%p.log -XX:HeapDumpPath="$errorFolder"heap_dump_err_%p.hprof"
JAVA_PARAMS="$JAVA_PARAMS -javaagent:./libs/classreload-agent.jar"

serverid=`grep game.server.id= ./config/template.properties`
JAVA_PARAMS="-D$serverid $JAVA_PARAMS"

echo "========================================================================="
echo ""
echo "  ZS World0 Server Environment"
echo ""
echo "  JAVA_PARAMS: $RUN_PARAM $MAIN $CPATH $JAVA_PARAMS"
echo ""
echo "========================================================================="
echo ""

eval \"java\" $JAVA_PARAMS \
		-cp \"$CPATH\" \"$MAIN\" \"$RUN_PARAM\"
