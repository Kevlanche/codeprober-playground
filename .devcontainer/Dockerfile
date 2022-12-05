FROM alpine:3.17

RUN apk update
RUN apk add openjdk8-jre bash git

ADD data/* /
RUN chmod +x /start-codeprober.sh /workspaces/codeprober-playground/start.sh

ENTRYPOINT ["/bin/bash"]
