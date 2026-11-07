import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    private int findIndexByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (title.equalsIgnoreCase(books.get(i).getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public boolean takeBook(String title) {
        int index = findIndexByTitle(title);
        if (index == -1) {
            return false;
        }
        Book book = books.get(index);
        return book.takeBook();
    }

    public boolean returnBook(String title) {
        int index = findIndexByTitle(title);
        if (index == -1) {
            return false;
        }
        Book book = books.get(index);
        return book.returnBook();
    }

    public boolean removeBook(String title) {
        int index = findIndexByTitle(title);
        if (index == -1) {
            return false;
        }
        books.remove(index);
        return true;
    }

    public ArrayList<Book> findByAuthor(String part) {
        String lowerPart = part.toLowerCase();
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(lowerPart)) {
                result.add(book);
            }
        }
        return result;
    }

    public int countAvailable() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public void printAll() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println(String.format("%d. %s", i + 1, books.get(i).getInfo()));
            }
        }
    }
}
