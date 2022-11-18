#!/bin/sh
export javapath=openjdk-17.0.2_windows-x64_bin/jdk-17.0.2/bin
$javapath/javac runner/Runner.java && $javapath/java runner.Runner