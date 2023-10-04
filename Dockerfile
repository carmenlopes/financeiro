FROM ubuntu:latest
LABEL authors="carme"

ENTRYPOINT ["top", "-b"]