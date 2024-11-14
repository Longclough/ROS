apt update && apt install -y libjsoncpp-dev && rm -rf /var/lib/apt/lists/*
apt update && apt install -y libgeos-dev && rm -rf /var/lib/apt/lists/*
apt update && apt install -y g++ && rm -rf /var/lib/apt/lists/*
apt update && apt install -y cmake && rm -rf /var/lib/apt/lists/*
apt update && apt install -y git && rm -rf /var/lib/apt/lists/*
apt update && apt install -y python3-pip && rm -rf /var/lib/apt/lists/*
cd ../bindings
./clone_pybind11.sh
cd ..