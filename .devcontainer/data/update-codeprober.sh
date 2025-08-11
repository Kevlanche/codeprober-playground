#!/usr/bin/env bash

echo "Fetching latest CodeProber release..."

# Get the latest release info from GitHub API
LATEST_JAR_URL=$(curl -s https://api.github.com/repos/lu-cs-sde/codeprober/releases/latest | grep "browser_download_url.*codeprober.jar" | cut -d '"' -f 4)

if [ -z "$LATEST_JAR_URL" ]; then
    echo "Error: Could not find latest release JAR URL"
    exit 1
fi

# Download the jar file
echo "Downloading from $LATEST_JAR_URL..."
curl -L -o /codeprober.jar "$LATEST_JAR_URL"

if [ $? -eq 0 ]; then
    echo "Successfully downloaded latest CodeProber to /codeprober.jar"
else
    echo "Error: Failed to download CodeProber"
    exit 1
file