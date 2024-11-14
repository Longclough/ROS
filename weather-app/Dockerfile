
# Use python base image
FROM python:3.10.6-slim

EXPOSE 8080

# Set build environment arguments
ARG PIP_INSTALL="python3 -m pip install --no-cache-dir"

ARG PYPI_REPO_HOST
ARG PYPI_REPO 

# set env variables
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

# set working directory
WORKDIR /code

#Install Pip first - though not supported by Ubuntu 23.01>
RUN apt-get update -y && apt-get install python3-pip -y

#Copy requirements.txt to local container
COPY ./requirements.txt /code/requirements.txt

#Install all python dependencies
RUN $PIP_INSTALL --trusted-host $PYPI_REPO_HOST -i $PYPI_REPO --force-reinstall -r /code/requirements.txt 

# Copy application files into container
COPY ./app /code/app

# Creates a non-root user with an explicit UID and adds permission to access the /app folder
# For more info, please refer to https://aka.ms/vscode-docker-python-configure-containers
RUN adduser -u 5678 --disabled-password --gecos "" appuser && chown -R appuser /code/app
USER appuser

ENV PATH /home/appuser/.local/bin:${PATH},

# run server
CMD ["uvicorn", "app.main:app", "--reload", "--port", "8080", "--host", "0.0.0.0"]
