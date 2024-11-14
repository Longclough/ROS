# For more information, please refer to https://aka.ms/vscode-docker-python
FROM python:3.10-slim

# Keeps Python from generating .pyc files in the container
ENV PYTHONDONTWRITEBYTECODE=1

# Turns off buffering for easier container logging
ENV PYTHONUNBUFFERED=1

# copy requirements into working directory 
COPY ./requirements.txt /requirements.txt

# install requirements
RUN pip install --no-cache-dir --upgrade -r /requirements.txt

# copy app and data into working directory
COPY ./app /app
COPY ./data /data

CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8080"]

# link to connect to API http://localhost/docs for API definitions
# link to connect to API http://localhost/vehicle_performance/   for v1 API access
# link to connect to API http://localhost/vehicle_performance/v2 for v2 API access