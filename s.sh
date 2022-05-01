#!/bin/bash

for tsk in 1 2 3 4
do
    cp ../moedit/results/user-study/old-task-7-${tsk}.java ./comment-update/task-7-${tsk}.java
    git add .
    git commit -m "Add ${tsk} java file."
    cp ../moedit/results/user-study/new-task-7-${tsk}.java ./comment-update/task-7-${tsk}.java
    git add .
    git commit -m "Update ${tsk} java file."
    git push
done

