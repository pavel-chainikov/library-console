public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;
    public static final int MAX_YEAR = 2026;

    public Book(String title, String author, int year) {
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        if (year < 1 || year > MAX_YEAR) {
            throw new IllegalArgumentException("Год должен быть от 1 до " + MAX_YEAR);
        }
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean takeBook() {
        if (!this.available) {
            return false;
        }
        this.available = false;
        return true;
    }

    public boolean returnBook() {
        if (!this.available) {
            this.available = true;
            return true;
        }

        return false;
    }

    public String getInfo() {
        String status = this.available ? "в наличии" : "выдана";
        return String.format("«%s» — %s, %d [%s]", this.getTitle(), this.getAuthor(), this.getYear(), status);
    }
}
