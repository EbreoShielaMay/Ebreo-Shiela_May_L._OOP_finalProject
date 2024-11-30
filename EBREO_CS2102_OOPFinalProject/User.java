import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;
    private Wallet wallet = new Wallet();
    private Book[] cart = new Book[10];
    private int cartIndex = 0;
    private String address;

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

    public void addToCart(Book book) {
        if (book == null) {
            System.out.println("Error: Cannot add a null book to the cart.");
            return;
        }

        if (cartIndex >= cart.length) {
            Book[] newCart = new Book[cart.length * 2];
            System.arraycopy(cart, 0, newCart, 0, cart.length);
            cart = newCart;
        }

        cart[cartIndex++] = book;
        System.out.println(book.getTitle() + " has been added to your cart.");
    }

    public void displayCart(Scanner scanner) {
        if (cartIndex == 0) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("( " + cartIndex + " ) items");
        System.out.println("---------------------------------");
        for (int i = 0; i < cartIndex; i++) {
            System.out.println((i + 1) + ". Title: " + cart[i].getTitle() + " | Price: Php" + cart[i].getPrice());
        }
        System.out.println("---------------------------------");

        System.out.println("---------------------------");
        System.out.println("\nCart Menu:");
        System.out.println("1. Proceed to Purchase");
        System.out.println("2. Remove an Item");
        System.out.println("3. Back to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                purchaseFromCart(scanner);
                break;
            case 2:
                removeItemFromCart(scanner);
                break;
            case 3:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option. Returning to main menu...");
        }
    }

    private void removeItemFromCart(Scanner scanner) {
        if (cartIndex == 0) {
            System.out.println("Your cart is empty. Nothing to remove.");
            return;
        }
    
        System.out.println("Enter the number of the item to remove (1-" + cartIndex + "), or press 'r' to return to the cart:");
        String input = scanner.nextLine().trim();
    
        // Check if the input is 'r' using charAt()
        if (input.length() == 1 && input.charAt(0) == 'r') {
            System.out.println("Returning to the cart...");
            return; // Exit the method to return to the cart
        }
    
        // Check if the input is a valid number
        if (input.length() > 0) {
            try {
                int itemIndex = Integer.parseInt(input) - 1; // Convert input to index
                if (itemIndex >= 0 && itemIndex < cartIndex) {
                    Book removedBook = cart[itemIndex];
    
                    // Shift the remaining items in the cart to the left
                    for (int i = itemIndex; i < cartIndex - 1; i++) {
                        cart[i] = cart[i + 1];
                    }
                    cart[--cartIndex] = null; // Clear the last item and update cartIndex
                    System.out.println(removedBook.getTitle() + " has been removed from your cart.");
                } else {
                    System.out.println("Invalid item number. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number or 'r' to return.");
            }
        } else {
            System.out.println("Invalid input! Please enter a valid number or 'r' to return.");
        }
    }

    public void purchaseFromCart(Scanner scanner) { // Reuse the Scanner passed as a parameter
        if (cartIndex == 0) {
            System.out.println("Your cart is empty. Cannot proceed with purchase.");
            return;
        }
    
        System.out.println("Your cart contains the following items:");
    
        // Display cart items
        for (int i = 0; i < cartIndex; i++) {
            System.out.println((i + 1) + ". " + cart[i].getTitle() + " | Price: Php " + cart[i].getPrice());
        }
    
        // Ask the user to choose an item or proceed with all items
        System.out.println("Select an item number to purchase or enter '0' to purchase all items.");
        String input = scanner.nextLine().trim(); // Reuse the existing scanner
    
        try {
            int itemIndex = Integer.parseInt(input);
    
            if (itemIndex == 0) {
                // Purchase all items in the cart
                double totalCost = 0;
                for (int i = 0; i < cartIndex; i++) {
                    totalCost += cart[i].getPrice();
                }
    
                if (wallet.getBalance() >= totalCost) {
                    wallet.deductBalance(totalCost);
                    System.out.println("Successfully purchased all items in the cart!");
                    
                    // Generate receipt after purchase
                    generateCartReceipt();
    
                    // Deduct stock for physical books after successful purchase
                    for (int i = 0; i < cartIndex; i++) {
                        if (cart[i] instanceof Book.PhysicalBook) {
                            ((Book.PhysicalBook) cart[i]).decreaseStock();
                        }
                    }
                    cartIndex = 0; // Clear the cart after purchase
                } else {
                    System.out.println("Insufficient balance to purchase all items in the cart.");
                }
            } else if (itemIndex > 0 && itemIndex <= cartIndex) {
                // Purchase selected item
                Book selectedBook = cart[itemIndex - 1];
                if (wallet.getBalance() >= selectedBook.getPrice()) {
                    wallet.deductBalance(selectedBook.getPrice());
                    System.out.println("Successfully purchased " + selectedBook.getTitle());
    
                    // Generate receipt for the single item
                    generateReceipt(selectedBook);
    
                    // Deduct stock for physical books
                    if (selectedBook instanceof Book.PhysicalBook) {
                        ((Book.PhysicalBook) selectedBook).decreaseStock();
                    }
    
                    // Remove the item from the cart
                    for (int i = itemIndex - 1; i < cartIndex - 1; i++) {
                        cart[i] = cart[i + 1];
                    }
                    cart[--cartIndex] = null; // Clear last item and update cartIndex
                } else {
                    System.out.println("Insufficient balance for " + selectedBook.getTitle());
                }
            } else {
                System.out.println("Invalid item number. Returning to the menu.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid item number.");
        }
    }

    private void generateCartReceipt() {
        System.out.println("\n=-=-=| Cart Purchase Receipt |=-=-=");
        System.out.println("Name: " + username);
        System.out.println("Address: " + address);
        System.out.println("Items Purchased:");

        double totalCost = 0;
        for (int i = 0; i < cartIndex; i++) {
            System.out.println("- " + cart[i].getTitle() + " (Php " + cart[i].getPrice() + ")");
            totalCost += cart[i].getPrice();
        }

        System.out.println("Total Cost: Php " + totalCost);
        System.out.println("--------------------------------------\n");
    }

    public void buyBookDirectly(Book book) {
        if (book == null) {
            System.out.println("Error: Book not found or unavailable.");
            return;
        }

        if (wallet.getBalance() >= book.getPrice()) {
            book.purchase(this); // Deducts stock for physical books
        } else {
            System.out.println("Insufficient balance to purchase " + book.getTitle() + ".");
        }
    }

    public void generateReceipt(Book book) {
        System.out.println("\n\t=-=-=| Purchase Receipt |=-=-=");
        System.out.println("Name: " + getUsername());
        System.out.println("Address: " + getAddress());
        System.out.println("Purchased: " + book.getTitle());
        System.out.println("Price: Php" + book.getPrice());
        System.out.println("-----------------------------------\n");
    }

    public class Wallet {
        private double balance;

        public double getBalance() {
            return balance;
        }

        public void addBalance(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully added Php " + amount + " to your wallet. 'v'");
            } else {
                System.out.println("Invalid amount. Please enter a value greater than 0.");
            }
        }

        public void deductBalance(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Deducted Php " + amount + " from your wallet.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }
    }
}
