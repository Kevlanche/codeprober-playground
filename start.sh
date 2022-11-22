#!/bin/bash

if [ ! -f "/start-codeprober.sh" ]; then
    echo "ERROR: /start-codeprober.sh does not exist."
    echo "'start.sh' can only be run inside a Dev Container (or Github Codespaces)."
    exit 1
fi

/start-codeprober.sh
