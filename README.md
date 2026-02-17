# About the Project

This application recreates the classic 9x9 Sudoku puzzle experience. Unlike simple console applications, this project features a responsive graphical user interface that handles user input validation, game state management, and real-time visual feedback.

The main goal was to decouple the game logic from the user interface, ensuring a clean and maintainable codebase.

# Technical Highlights

* Java Fundamentals: Strong use of core Java syntax, data structures (2D Arrays), and control flow.
* Object-Oriented Design:
    * Encapsulation: Logic is separated into distinct classes.
    * Modularity: Interfata.java handles UI rendering, while Constructie.java manages the underlying data model.
* GUI Development (Swing/AWT):
    * Custom layout management using panels and grids.
    * Implementation of ActionListeners to handle user clicks and input.
* Algorithmic Logic:
    * Validation algorithms to check rows, columns, and 3x3 grids.
    * Matrix manipulation for board generation.

# Project Structure

The source code is organized to promote readability and separation of concerns:

* Main.java - Entry Point: Initializes the application and launches the main window.
* Interfata.java - View Layer: Manages the GUI components (buttons, text fields, layout) and user interaction events.
* Constructie.java - Model/Logic Layer: Contains the core logic for the Sudoku grid, including cell generation and validity checks.
