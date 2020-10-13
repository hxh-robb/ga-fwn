#!/usr/bin/env bash

CMD=$(readlink -f "$0")
CWD=$(dirname "${CMD}")
cd "${CWD}"

docker build -t robbtsang/ga-fwn-share:latest .
docker push robbtsang/ga-fwn-share:latest
