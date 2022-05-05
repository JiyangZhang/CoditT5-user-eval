#!/bin/bash

for tsk in 1 2 3 4 5 6
do
    cp ../moedit/results/user-study/tasks/code-review/old-task-7-${tsk}.java ./code-review/task-7-${tsk}.java
    git add .
    git commit -m "Add ${tsk} java file."
    cp ../moedit/results/user-study/tasks/code-review/new-task-7-${tsk}.java ./code-review/task-7-${tsk}.java
    git add .
    git commit -m "Update ${tsk} java file."
    git push
done

