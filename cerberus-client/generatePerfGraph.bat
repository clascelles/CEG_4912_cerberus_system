@echo off
FOR /F "usebackq tokens=1,2,3,4 delims=/ " %%i IN (`date /t`) DO (set yyyymmdd=%%l%%k%%j)
set jar_version=0.9.16
set jar_path=%USERPROFILE%\.m2\repository\org\perf4j\perf4j\%jar_version%\perf4j-%jar_version%.jar
set project_path=%USERPROFILE%\workspace\git\CEG_4912_cerberus_system\cerberus-client
echo Generating performance statistic graphs from the performance logs...
java -jar %jar_path% --graph %project_path%\perfGraphResult.html %project_path%\logs\perflog_%yyyymmdd%.txt
echo Done! Look in the perfGraphResult.html file!
pause