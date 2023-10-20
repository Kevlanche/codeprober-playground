
wget https://raw.githubusercontent.com/lu-cs-sde/codeprober/master/code-prober.jar -O data/code-prober.jar
VERSION=$(wget https://raw.githubusercontent.com/lu-cs-sde/codeprober/master/VERSION -q -O - | tail -n 1)

echo "Suggested commit:"
echo "  git commit -am \"Update to CodeProber version $VERSION\""