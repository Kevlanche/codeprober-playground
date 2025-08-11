#!/usr/bin/env bash

echo "Starting CodeProber with IntraJ.."
java -jar -Dcpr.workspace=example_exercises /codeprober.jar /intraj.jar -WDAA -WNPA -XparseOnly
