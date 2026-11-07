public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Война и мир", "Толстой", 1869));
        library.addBook(new Book("Анна Каренина", "Толстой", 1878));
        library.addBook(new Book("Мастер и Маргарита", "Булгаков", 1967));
        library.printAll();
        System.out.println("Выдать «мастер и маргарита»: " + library.takeBook("мастер и маргарита"));
        System.out.println("Выдать «Идиот»: " + library.takeBook("Идиот"));
        System.out.println("В наличии: " + library.countAvailable());
        System.out.println("Книги автора «толст»:");
        for (Book book : library.findByAuthor("толст")) {
            System.out.println(book.getInfo());
        }
        System.out.println("Удалить «Анна Каренина»: " + library.removeBook("Анна Каренина"));
        library.printAll();
    }
}
