# BookKeeper

BookKeeper is a Java-based desktop application for managing personal book collections. It allows users to add, edit, and delete books, track reading progress, and manage lending. The application integrates with a MySQL database to store book data and uses JSON for data interchange.

## Technologies Used
- Java
- JDBC
- MySQL
- JSON
- Swing
- Git

## Features
- Add, edit, and delete books
- Categorize books by genre and add personal notes
- View and search book collection
- Manage book lending
- Import and export data using JSON

## Setup Instructions
1. Set up a MySQL database and create a database named `bookkeeper`.
2. Run the SQL script in `resources/database.sql` to create the required table.
3. Update the database connection details in `Database.java`.
4. Compile and run the `Main.java` file to start the application.
