# Use python base image
FROM python:3.11-slim

# Set build environment arguments
ARG PIP_INSTALL="python3 -m pip install --no-cache-dir"

ARG PYPI_REPO_HOST
ARG PYPI_REPO 

# set env variables
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

# Make all commands now run from within /usr/src/app
WORKDIR /code

#Copy requirements.txt to local container
COPY ./requirements.txt /code/requirements.txt

# Copy application files into container
COPY ./app /code/app

#Install all python dependencies
RUN $PIP_INSTALL --trusted-host $PYPI_REPO_HOST -i $PYPI_REPO --force-reinstall -r requirements.txt 

# run server
CMD ["uvicorn", "app.main:app", "--reload", "--port", "8080", "--host", "0.0.0.0"]
