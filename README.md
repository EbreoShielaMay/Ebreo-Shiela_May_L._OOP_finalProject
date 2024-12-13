<div align="center">
<img src="https://github.com/EbreoShielaMay/my/blob/main/image.png" alt="Logo" width="400"/>
</div>

---
# D'Bookstore :cherry_blossom: :book: :sparkles:

D'Bookstore is a digital bookstore management system designed to streamline book purchases and enhance the shopping experience. The system allows users to:

* :bookmark_tabs: Browse book categories, including physical books and eBooks.

* :shopping_cart: Add books to a cart or purchase directly.

* :moneybag: Manage their wallet balance for seamless transactions.

* :receipt: View detailed purchase receipts for clarity and record-keeping.

This project aims to provide a user-friendly interface for book enthusiasts while integrating sustainable practices aligned with the Sustainable Development Goals (SDGs).

---

## OOP Principles application :computer:
This project employs Object-Oriented Programming (OOP) principles to ensure modularity, scalability, and maintainability:

### Encapsulation :pill: 
* Each class (Book, BookCategory, User) encapsulates its data and methods, ensuring that related functionalities are grouped logically.
* Access to class attributes is restricted via private modifiers, with getters and constructors providing controlled access.
* Encapsulation of logic within methods:
Methods like addToCart(), purchaseFromCart(), buyBookDirectly() in User encapsulate complex operations on user data.
BookCategory methods (hasPhysicalBooks(), listBooks()) encapsulate checks and operations on books.

* Book.java 
  ```java
  private String title;
  private double price;
  ```
  ```java
   public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
  ```
* BookCategory.java
 ```java
private String categoryName;
private Book[] books;
```
```java
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
```
* User.java
```java
private String username;
private String password;
private Wallet wallet = new Wallet();
private Book[] cart = new Book[10];
private int cartIndex = 0;
private String address;
```
```java
 public User(String username, String password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public Wallet getWallet() {
        return wallet;
    }
```
### Inheritance :family:  
* The Book class is extended into two specialized classes: PhysicalBook and eBook, enabling reuse of common attributes while adding specific features.

* At the Book.java
```java
public static class PhysicalBook extends Book {}
```
```java
public static class eBook extends Book {}
  ```
### Abstraction :atm: 
* The Display class abstracts the user interface, keeping UI-related logic separate from the core business logic.
* The BookCategory class abstracts the management of books, hiding the complexity of book organization.
```java
public interface Purchasable {
    void purchase(User user);
}
```
### Polymorphism :butterfly: 
* The Purchasable interface defines a purchase method implemented differently by various classes, allowing a unified handling of purchasable items.

---

## Chosen SDG and its Integration :ballot_box_with_check:

### SDG 4: Quality Education :pencil:
:white_check_mark: Books are sources of knowledge so an accessible digital bookstore facilitates easy access to educational resources and books, encouraging informed and sustainable consumption habits.

### SDG 9:  Industry innovation and infrastracture :building_construction:
:white_check_mark: This digital bookstore is also a form of an industrial innovation that brings libraries to a notch!

---

## Executing program
### Prerequisites

1. Ensure you have Java Development Kit (JDK) installed on your system.

2. A terminal or IDE (e.g., IntelliJ IDEA, Eclipse) to run the Java program.

### Steps to Run

1. Compile the Program:

* Navigate to the project directory in your terminal.

* Compile the program using the command:

javac Main.java

2. Run the Program:

* Execute the compiled program:

java Main

3. Explore Features: :

* Sign up or log in.

* Browse book categories and add books to your cart or purchase directly.

* View your wallet balance and manage transactions.

### Notes :spiral_notepad: :white_check_mark:
:paperclip: Follow on-screen instructions to navigate menus.

:paperclip: Input validation ensures user-friendly interactions; errors or invalid entries prompt retries.

