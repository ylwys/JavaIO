@echo off
title 世界服务器

rem # 设置启动参数
set RUN_PARAM=0

rem # 设置加载类的环境变量 运行主类名
set CPATH=./target/classes/;
set MAIN=com.test.AppMain

rem # 设置运行参数
set JAVA_PARAMS=-server -Xms256m -Xmx256m -Xmn128m -XX:MetaspaceSize=50m -XX:MaxMetaspaceSize=128m -XX:MaxDirectMemorySize=512m -Dio.netty.leakDetectionLevel=advanced
set JAVA_PARAMS=%JAVA_PARAMS% -XX:+UseParallelGC -XX:+UseParallelOldGC
set JAVA_PARAMS=%JAVA_PARAMS% -XX:+DisableExplicitGC
set JAVA_PARAMS=%JAVA_PARAMS% -XX:+PrintGCDateStamps -XX:+PrintGCDetails -verbose:gc -Xloggc:/export/gc/gc.world0.log
set JAVA_PARAMS=%JAVA_PARAMS% -XX:ErrorFile=/export/error/hs_err_%p.log -XX:HeapDumpPath=/export/error/heap_dump_err_%p.hprof

echo ===============================================================================
echo.
echo   ZS World0 Server Environment
echo.
echo   JAVA_PARAMS: %RUN_PARAM% %MAIN% %CPATH% %JAVA_PARAMS%
echo.
echo ===============================================================================
echo.

java %JAVA_PARAMS% ^
	-cp %CPATH% %MAIN% %RUN_PARAM%
pause