import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI {
    private JFrame frame;
    private JTextField titleField, authorField, genreField, notesField;
    private JTextArea displayArea;
    private BookManager bookManager;

    public GUI() {
        bookManager = new BookManager();
        frame = new JFrame("BookKeeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        inputPanel.add(genreField);
        inputPanel.add(new JLabel("Notes:"));
        notesField = new JTextField();
        inputPanel.add(notesField);
        JButton addButton = new JButton("Add Book");
        inputPanel.add(addButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        frame.setVisible(true);
        displayBooks();
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String notes = notesField.getText();
        Book book = new Book(0, title, author, genre, notes);
        bookManager.addBook(book);
        displayBooks();
    }

    private void displayBooks() {
        List<Book> books = bookManager.getAllBooks();
        displayArea.setText("");
        for (Book book : books) {
            displayArea.append(book.getTitle() + " by " + book.getAuthor() + " (" + book.getGenre() + ")\n");
            displayArea.append("Notes: " + book.getNotes() + "\n\n");
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
