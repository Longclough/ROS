FROM ubuntu:latest

ARG PIP_INSTALL="python3 -m pip install --no-cache-dir"
ARG PYPI_REPO_HOST
ARG PYPI_REPO 

# Install package dependencies

RUN apt update && apt install -y python3 && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y python3-pip && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y g++ && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y cmake && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y git && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y python3-pip && rm -rf /var/lib/apt/lists/*

# Install python dependencies
COPY ./requirements.txt /requirements.txt

RUN $PIP_INSTALL --trusted-host $PYPI_REPO_HOST -i $PYPI_REPO --force-reinstall -r requirements.txt