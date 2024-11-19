########################################################################################################################
# build stage
########################################################################################################################

#FROM pulsardevcr.azurecr.io/pybind AS build
FROM base_container AS build

RUN apt update && apt install -y libjsoncpp-dev && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y libgeos-dev && rm -rf /var/lib/apt/lists/*

COPY bindings/ /bindings
COPY cpp/ /cpp
COPY CMakeLists.txt .

WORKDIR /bindings

RUN ./clone_pybind11.sh

WORKDIR /build

RUN cmake -DCMAKE_BUILD_TYPE=Release .. && \
    cmake --build . --parallel 8

########################################################################################################################
# image
########################################################################################################################

FROM ubuntu:22.04
# Set build environment arguments
ARG PIP_INSTALL="python3 -m pip install --no-cache-dir"

ARG PYPI_REPO_HOST
ARG PYPI_REPO 

# Set env variables
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1
ENV LD_LIBRARY_PATH="${LD_LIBRARY_PATH}:/lib"
ENV PYTHONPATH="${PYTHONPATH}:/lib"

# Install dependencies
RUN apt update && apt install -y python3 && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y python3-pip && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y libjsoncpp25 && rm -rf /var/lib/apt/lists/*
RUN apt update && apt install -y libgeos-c1v5 && rm -rf /var/lib/apt/lists/*

# Copy requirements.txt to container
COPY ./requirements.txt /requirements.txt

# Install all python dependencies
RUN $PIP_INSTALL --trusted-host $PYPI_REPO_HOST -i $PYPI_REPO --force-reinstall -r requirements.txt 

# Setup user
RUN adduser appuser
USER appuser

# Copy application files into container
COPY --chown=appuser:appuser ./app /app
COPY --chown=appuser:appuser --from=build ./lib /lib 

# Run server
CMD ["uvicorn", "app.main:app", "--reload", "--port", "8080", "--host", "0.0.0.0"]
