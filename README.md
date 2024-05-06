# Maze Solver README

## Project Information
- **Course**: COMP2112 Data Structures and Algorithms
- **Semester**: Fall 2023
- **Project**: Project 1

## Project Objective
The objective of this project is to design and implement a maze solver using stacks and explore the maze until the robot reaches the southeast corner. The provided classes include MazeSolverProject.java, MazeUtility.java, and Stack.java. The maze is represented as a two-dimensional integer array where 0 represents an empty space, 1 represents a wall, and 2 represents the current path of the robot. The robot starts at coordinates [1,1] facing east and must navigate to the southeast corner, which is at coordinates [2*n-1, 2*n-1] for an nxn grid.

## Project Setup
1. Create a new project.
2. Import the provided files: MazeSolverProject.java, MazeUtility.java, and Stack.java.
3. Run the MazeSolverProject.java file to visualize the 10x10 maze on the console.

## Maze Exploration
- The robot starts at coordinates [1,1] facing east.
- Your task is to implement a solution using stacks to explore the maze and navigate the robot to the southeast corner.
- You may add new classes if necessary to implement your solution.

## Maze Representation
- A maze is represented as a two-dimensional integer array.
- Each entry in the array:
  - 0: Empty space
  - 1: Wall
  - 2: Current path of the robot

## Plotting the Maze
- Use the plotMaze(int[][]) static method of the MazeUtility class to plot the maze after each action (step forward or revert last action).
- This allows you and the grader to visualize how the robot proceeds in the maze.

## Example Maze Representation:
- X represents a wall.
- O represents the current path of the robot.

