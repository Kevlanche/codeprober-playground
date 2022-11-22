FROM alpine:3.17

RUN apk update
RUN apk add openjdk8 bash curl git zip

ADD data/* /
RUN chmod +x /setup.sh /*-codeprober.sh
RUN /setup.sh
RUN rm /setup.sh

ENTRYPOINT ["/bin/bash"]
