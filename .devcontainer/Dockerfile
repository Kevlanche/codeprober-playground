FROM alpine:3.17

RUN apk update
RUN apk add openjdk8-jre bash git

ADD data/* /

ENTRYPOINT ["/bin/bash"]
