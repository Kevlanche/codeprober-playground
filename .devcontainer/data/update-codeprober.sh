#!/bin/bash

echo "Pulling latest CodeProber version.."
cd /codeprober
git fetch --depth 1 origin master
git checkout FETCH_HEAD
echo "Done"
