cd ../

python -m pytest test/unit
python -m pytest test/api
python -m pytest test/integration

cd developer-scripts
