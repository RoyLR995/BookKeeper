import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private Database database;

    public BookManager() {
        database = new Database();
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, author, genre, notes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = database.getConnection().prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getNotes());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Statement statement = database.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                String notes = resultSet.getString("notes");
                books.add(new Book(id, title, author, genre, notes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void close() {
        database.close();
    }
}
