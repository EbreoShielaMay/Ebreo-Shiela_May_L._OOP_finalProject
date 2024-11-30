public class BookCategory {
    private String categoryName;
    private Book[] books;

    public BookCategory(String categoryName, Book[] books) {
        this.categoryName = categoryName;
        this.books = books;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Book[] getBooks() {
        return books;
    }

    public boolean hasPhysicalBooks() {
        for (Book book : books) {
            if (book instanceof Book.PhysicalBook) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasEBooks() {
        for (Book book : books) {
            if (book instanceof Book.eBook) {
                return true;
            }
        }
        return false;
    }

    public void listBooks() {
        System.out.println("x---" + categoryName + "---x");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
}