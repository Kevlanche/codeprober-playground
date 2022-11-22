#!/bin/bash

mkdir codeprober
cd codeprober
git init
git remote add origin https://github.com/lu-cs-sde/codeprober.git
git fetch --depth 1 origin master
git checkout FETCH_HEAD
