public class Main {
    public static void main(String[] args) {
        Book book = new Book("Война и мир", "Толстой", 1869);
        System.out.println(book.getInfo());
        System.out.println("Выдана: " + book.takeBook());
        System.out.println("Выдана повторно: " + book.takeBook());
        System.out.println(book.getInfo());
        System.out.println("Возвращена: " + book.returnBook());
        try {
            Book emptyTitle = new Book("", "Оруэлл", 1984);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Book yearExceeded = new Book("Книга", "Автор", 3000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
