@echo off
setlocal
set "APP_HOME=%~dp0"
set "WRAPPER_JAR=%APP_HOME%gradle\wrapper\gradle-wrapper.jar"
if not exist "%WRAPPER_JAR%" (
    echo Pierwsze uruchomienie: pobieranie Gradle Wrapper 9.6.1...
    powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; $jar='%WRAPPER_JAR%'; $url='https://services.gradle.org/distributions/gradle-9.6.1-wrapper.jar'; $shaUrl=$url+'.sha256'; $tmp=$jar+'.download'; try { Invoke-WebRequest -Uri $url -OutFile $tmp; $expected=(Invoke-WebRequest -Uri $shaUrl).Content.Trim(); $actual=(Get-FileHash -Algorithm SHA256 $tmp).Hash.ToLower(); if ($actual -ne $expected.ToLower()) { throw 'Niezgodny SHA256 Gradle Wrapper' }; Move-Item -Force $tmp $jar } finally { Remove-Item -ErrorAction SilentlyContinue $tmp }"
    if errorlevel 1 exit /b 1
)
if not "%JAVA_HOME%"=="" (
    "%JAVA_HOME%\bin\java.exe" -cp "%WRAPPER_JAR%" org.gradle.wrapper.GradleWrapperMain %*
) else (
    java -cp "%WRAPPER_JAR%" org.gradle.wrapper.GradleWrapperMain %*
)
exit /b %ERRORLEVEL%
