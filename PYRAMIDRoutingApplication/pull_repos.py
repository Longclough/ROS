## This script pulls all of the repositories defined in contributing_components.txt
## The credentials should be stored in a .env file which is held locally only, this version holds the access key in the script

## This script requires pandas and gitPython to be installed in order to run.

from dotenv import load_dotenv
import os
import shutil
import pandas as pd
from git import Repo

# Define local repo storage area
# local_repo_path = "/home/nigel.given@airlabs.net/Documents/"
local_repo_path = '../'

# Load list of contributing components
contri_comps = pd.read_csv("contributing_components.txt", header=None, names = ['Component'], index_col=None)

# Code for acquiring access key from local .env file
load_dotenv(dotenv_path=".env")
accesskey = os.getenv("ACCESSKEY")

# ACCESSKEY = open(local_repo_path + 'ACCESSKEY.txt', 'r').read()

## Loop thru contributing_components.txt performing the following
## Create a string defining the repository to pull from including the access key and the address
## Delete the existing local folder
## Execute the git clone operation to pull down the latest version of the repo

print("WARNING: This script will erase your existing local repos and replace them with the ADO masters")
answer = input("Are you sure you wish to continue Y/N?")
if answer.lower() in ["y","yes"]:
    c_count = 0
    for x in contri_comps.iterrows():
        # Construct source path
        repo = contri_comps.at[c_count, 'Component']
        source = ("https://%s@dev.azure.com/airlabs-poe/Dionysus/_git/%s" % (accesskey, repo))
        
        # Define local dir for repo
        local_repo_dir = (local_repo_path + repo)

        # Delete existing local repo, if there is no existing local copy the script just continues
        shutil.rmtree(local_repo_dir, ignore_errors=True)
        print(repo, " deleted")

        # Pull repository
        Repo.clone_from(source, local_repo_dir)
        print(source, " cloned")
        c_count = c_count + 1
    print("Done")
else:
     print("Script ended, no repos have been cloned")






