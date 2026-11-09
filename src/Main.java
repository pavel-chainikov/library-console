import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Library library = new Library();
        library.addBook(new Book("Война и мир", "Толстой", 1869));
        library.addBook(new Book("Анна Каренина", "Толстой", 1878));
        library.addBook(new Book("Мастер и Маргарита", "Булгаков", 1967));
        boolean running = true;
        while (running) {
            System.out.println("1 — Показать все книги");
            System.out.println("2 — Добавить книгу");
            System.out.println("3 — Найти по автору");
            System.out.println("4 — Выдать книгу");
            System.out.println("5 — Вернуть книгу");
            System.out.println("6 — Удалить книгу");
            System.out.println("0 — Выход");
            System.out.print("Команда: ");
            String command = console.nextLine();
            switch (command) {
                case "1" -> library.printAll();
                case "2" -> {
                    try {
                        System.out.print("Название: ");
                        String title = console.nextLine();
                        System.out.print("Автор: ");
                        String author = console.nextLine();
                        System.out.print("Год: ");
                        int year = Integer.parseInt(console.nextLine());
                        library.addBook(new Book(title, author, year));
                        System.out.println("Книга добавлена");
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: год должен быть числом");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }
                case "3" -> {
                    System.out.print("Автор: ");
                    String author = console.nextLine();
                    ArrayList<Book> found = library.findByAuthor(author);
                    if (found.isEmpty()) {
                        System.out.println("Ничего не найдено");
                    } else {
                        for (Book book : found) {
                            System.out.println(book.getInfo());
                        }
                    }
                }
                case "4" -> {
                    System.out.print("Название: ");
                    String title = console.nextLine();
                    if (library.takeBook(title)) {
                        System.out.println("Книга выдана");
                    } else {
                        System.out.println("Книга не найдена или уже выдана");
                    }
                }
                case "5" -> {
                    System.out.print("Название: ");
                    String title = console.nextLine();
                    if (library.returnBook(title)) {
                        System.out.println("Книга возвращена");
                    } else {
                        System.out.println("Книга не найдена или не была выдана");
                    }
                }
                case "6" -> {
                    System.out.print("Название: ");
                    String title = console.nextLine();
                    if (library.removeBook(title)) {
                        System.out.println("Книга удалена");
                    } else {
                        System.out.println("Книга не найдена");
                    }
                }
                case "0" -> {
                    System.out.println("До свидания");
                    running = false;
                }
                default -> System.out.println("Нет такой команды");
            }
        }
    }
}
