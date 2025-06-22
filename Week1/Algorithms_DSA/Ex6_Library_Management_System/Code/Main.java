package lms;
public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The White Tiger", "Aravind Adiga"),
            new Book("B002", "Train to Pakistan", "Khushwant Singh"),
            new Book("B003", "God of Small Things", "Arundhati Roy"),
            new Book("B004", "Wings of Fire", "A.P.J. Abdul Kalam"),
            new Book("B005", "The Guide", "R. K. Narayan")
        };

        // Linear Search
        System.out.println(" Linear Search:");
        Book found1 = LibrarySearch.linearSearch(books, "Wings of Fire");
        System.out.println(found1 != null ? found1 : "Book not found");

        // Sort for Binary Search
        LibrarySearch.sortBooksByTitle(books);

        // Binary Search
        System.out.println("\n Binary Search:");
        Book found2 = LibrarySearch.binarySearch(books, "Wings of Fire");
        System.out.println(found2 != null ? found2 : "Book not found");
    }
}

