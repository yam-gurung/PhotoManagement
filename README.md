# PhotoManagement
Photo Management

o commit code to GitHub using the command line, follow these steps:
Navigate to your project directory: Open your terminal or command prompt and use the cd command to navigate to the root directory of your local Git repository.
Code

    cd path/to/your/project
Stage your changes: Use git add to stage the files you want to include in your commit. You can stage specific files or all changes.
Code

    git add . # To stage all changes
    # or
    git add <filename> # To stage a specific file
Commit your changes: Use git commit with the -m flag to add a descriptive commit message. This message should explain the changes you've made.
Code

    git commit -m "Your descriptive commit message here"
Push your changes to GitHub: Use git push to upload your local commits to the remote repository on GitHub. Replace origin with the name of your remote and main with the name of your branch (it might be master in older repositories). 
Code

    git push origin main
If you are pushing for the first time or setting up a new branch, you might need to use the -u flag to set the upstream branch:
Code

    git push -u origin main
