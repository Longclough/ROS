# Use GDAL base image see https://github.com/OSGeo/gdal/tree/master/docker
FROM ghcr.io/osgeo/gdal:ubuntu-small-3.5.0-amd64

EXPOSE 8080

# Set build environment arguments
ARG PIP_INSTALL="python3 -m pip install --no-cache-dir"

ARG PYPI_REPO_HOST
ARG PYPI_REPO 

# set env variables
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

#Install Pip first - though not supported by Ubuntu 23.01>
RUN apt-get update -y && apt-get install python3-pip -y

#Copy requirements.txt to local container
COPY ./requirements.txt /requirements.txt

#Install all python dependencies
RUN $PIP_INSTALL --trusted-host $PYPI_REPO_HOST -i $PYPI_REPO --force-reinstall --ignore-installed -r requirements.txt 

# Copy application files into container
COPY ./app /app
COPY ./data /data

# Creates a non-root user with an explicit UID and adds permission to access the /app and /data folders
# For more info, please refer to https://aka.ms/vscode-docker-python-configure-containers
RUN adduser -u 5678 --disabled-password --gecos "" appuser && chown -R appuser /app && chown -R appuser /data
USER appuser

ENV PATH /home/appuser/.local/bin:${PATH},

# run server
CMD ["uvicorn", "app.main:app", "--reload", "--port", "8080", "--host", "0.0.0.0"]
