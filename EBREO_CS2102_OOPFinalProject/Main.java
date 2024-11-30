import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userIndex = 0;
    private static BookCategory[] physicalBookCategories;
    private static BookCategory[] ebookCategories;

    public static void main(String[] args) {
        initializePhysicalBooks();
        initializeEbooks();
        Display display = new Display();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                display.displayMainMenu();
                int answer = getValidIntInput(scanner);
                switch (answer) {
                    case 1:
                        signUp(scanner, display);
                        System.out.println("");
                        break;
                    case 2:
                        logIn(scanner, display);
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid input. Try again.");
                }
            } catch (Exception e) {
                // Catch any unexpected exceptions
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }
    }

    private static int getValidIntInput(Scanner scanner) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter your choice: ");
                input = scanner.nextInt();
                scanner.nextLine(); // Clear newline

                // If input is valid, break the loop
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                // Handle invalid input (e.g., when the user enters a string instead of an integer)
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input from the scanner buffer
            }
        }
        return input;
    }

    private static void initializePhysicalBooks() {
        physicalBookCategories  = new BookCategory[] {
            new BookCategory("Programming", new Book[] {
                new Book.PhysicalBook("Java Programming 101", 250.00, 10),
                new Book.PhysicalBook("Python made easy",300.00,20),
                new Book.PhysicalBook("Learning to be a programmer!", 300.00,24),
                new Book.PhysicalBook("How to code:Guide to programming",400.00,20)
            }),
            new BookCategory("Hobbies", new Book[] {
                new Book.PhysicalBook("Art Crazed",200.00,19),
                new Book.PhysicalBook("Handwork guide", 178.00,15),
                new Book.PhysicalBook("Homemade meals' love", 109.00,21),
                new Book.PhysicalBook("Painter's Guide",399.00,20)
            }),
            new BookCategory("Comics/Manga", new Book[] {
                new Book.PhysicalBook("One Punch Man",439.00,34),
                new Book.PhysicalBook("Demon Slayer",499.00,25),
                new Book.PhysicalBook("Tokyo Ghoul",489.00,28),
                new Book.PhysicalBook("Death Note",469.00,16),
                new Book.PhysicalBook("Attack on Titan",487.00,33)
            }),
            new BookCategory("English Lit", new Book[] {
                new Book.PhysicalBook("Lord of the Flies",499.00,28),
                new Book.PhysicalBook("Pride and Prejudice",359.00,12),
                new Book.PhysicalBook("Emma",238.00,10),
                new Book.PhysicalBook("To kill a Mockingbird",389.00,27),
                new Book.PhysicalBook("The woman in white",369.00,25)
            }),
            new BookCategory("Science", new Book[] {
                new Book.PhysicalBook("On the Origin of Species",479.00,30),
                new Book.PhysicalBook("Breathless: The Scientific Race to Defeat a Deadly Virus",365.00,12),
                new Book.PhysicalBook("Astrophysics for People in a Hurry",400.00,18),
                new Book.PhysicalBook("Bad Science",125.00,22)
            }),
            new BookCategory("Kids' Books", new Book[] {
                new Book.PhysicalBook("Matilda",280.00,30),
                new Book.PhysicalBook("Diary of a Wimpy Kid", 498.00, 50),
                new Book.PhysicalBook("The Giving Tree",289.00,34),
                new Book.PhysicalBook("Madeline",230.05,30),

            })
        };
    }

    private static void initializeEbooks() {
        ebookCategories  = new BookCategory[] {
            new BookCategory("Programming", new Book[] {
                new Book.eBook("The Pragmatic Programmer", 480.00),
                new Book.eBook("Code: The Hidden Language of Computer Hardware and Software",234.00),
                new Book.eBook("The Art of Game Design: A Book of Lenses, Third Edition",333.00),
                new Book.eBook("Hacker's Delight",199.00)
            }),
            new BookCategory("Hobbies", new Book[] {
                new Book.eBook("Stitch 'N Bitch Crochet: The Happy Hooker",212.00),
                new Book.eBook("The Sewing Book",320.00),
                new Book.eBook("Lego Gear Bots",146.00),
                new Book.eBook("Four Season Harvest",330.00),
                new Book.eBook("Drawing on the Right Side of the Brain",376.00)
            }),
            new BookCategory("Comics/Manga", new Book[] {
                new Book.eBook("The Villainess turns the hourglass",176.00),
                new Book.eBook("Wind breaker",234.00),
                new Book.eBook("The Lady Knight",188.00),
                new Book.eBook("Study group",269.00),
                new Book.eBook( "Villain's Crush",299.00)
            }),
            new BookCategory("English Lit", new Book[] {
                new Book.eBook("Harry Potter and the Chamber of Secrets",599.00),
                new Book.eBook("Fantastic beasts",389.00),
                new Book.eBook("The Great Gatsby",237.00),
                new Book.eBook("Miss Peregrine's House for Peculiars",345.00)
            }),
            new BookCategory("Kids' Books", new Book[] {
                new Book.eBook("Cinderella", 125.00),
                new Book.eBook("Pinnochio", 125.00),
                new Book.eBook("Princess and the frog", 125.00),
                new Book.eBook("The Giving Tree", 150.00)
            }),
            new BookCategory("Science", new Book[] {
                new Book.eBook("Science Encyclopedia vol.1",200.00),
                new Book.eBook("Cosmos",255.00),
                new Book.eBook("The Elegant Universe",210.00),
                new Book.eBook("Six Easy Pieces",199.00)
            })
        };
    }

    private static void signUp(Scanner scanner, Display display) {
        System.out.println();
        System.out.println(" || Sign up ||");
        System.out.println();
        System.out.println("Type 'C' to cancel at any time.");

        String username;
        while (true) {
            System.out.print("Enter a username: ");
            username = scanner.nextLine().trim();
            if (username.length() == 1 && (username.charAt(0) == 'C' || username.charAt(0) == 'c')) {
                System.out.println("Registration canceled.");
                return;
            }
            if (username != null && username.length() > 0) {
                break;
            }
            System.out.println("Username cannot be empty. Please try again.");
        }

        String password;
        while (true) {
            System.out.print("Enter a password (minimum 8 characters): ");
            password = scanner.nextLine().trim();
            if (password.length() == 1 && (password.charAt(0) == 'C' || password.charAt(0) == 'c')) {
                System.out.println("Registration canceled.");
                return;
            }
            if (password.length() >= 8) {
                break;
            }
            System.out.println("Password must have at least 8 characters. Please try again.");
        }

        String address;
        while (true) {
            System.out.print("Enter your address: ");
            address = scanner.nextLine().trim();
            if (address.length() == 1 && (address.charAt(0) == 'C' || address.charAt(0) == 'c')) {
                System.out.println("Registration canceled.");
                return;
            }
            if (address != null && address.length() > 0) {
                break;
            }
            System.out.println("Address cannot be empty. Please try again.");
        }

        addUser(username, password, address);
        display.displayRegisterSuccess();
    }
    private static void logIn(Scanner scanner, Display display) {
        System.out.println();
        System.out.println("|| Log in ||");
        System.out.println();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        //if user passes validation
        if (validateUser(username, password)) {
            System.out.println("");
            System.out.println("=-=-=| Log in successful. Welcome " + username + "! :> |=-=-=");
            System.out.println("");
            loggedInMenu(scanner, username, password, display);
        } else {
            System.out.println("Account credential mismatch. Try again.");
        }
    }

    private static void addUser(String username, String password, String address) {
        if (userIndex >= users.length) {
            //Create a new array that doubles size
            User[] newUsers = new User[users.length *2];

            //Copy elements from the old array to the new one manually
            for (int i = 0; i < users.length; i++) {
                newUsers[i] =users[i];
            }
            //Assign the new array to users
            users = newUsers;
        }
        //Add new user to the array
        users[userIndex] = new User(username, password, address);
        userIndex++;
    }

    private static boolean validateUser(String username, String password) {
        for (int i = 0; i < userIndex; i++) {
            if (users[i].getUsername().length() == username.length()) {
                boolean isUsernameMatch = true;
                for (int j = 0; j < username.length(); j++) {
                    if (users[i].getUsername().charAt(j) != username.charAt(j)) {
                        isUsernameMatch = false;
                        break;
                    }
                }
                if (isUsernameMatch) {
                    // If username matches, compare passwords
                    if (users[i].getPassword().length() == password.length()) {
                        boolean isPasswordMatch = true;
                        for (int k = 0; k < password.length(); k++) {
                            if (users[i].getPassword().charAt(k) != password.charAt(k)) {
                                isPasswordMatch = false;
                                break;
                            }
                        }
                        if (isPasswordMatch) {
                            return true; // Username and password both match
                        }
                    }
                }
            }
        }
        return false; // Username or password doesn't match
    }
    

    private static void loggedInMenu(Scanner scanner, String username, String password, Display display) {
        User loggedInUser = null;
        for (int i = 0; i < userIndex; i++) {
            if (users[i].getUsername().length() == username.length()) {
                boolean isMatch = true;
                for (int j = 0; j < username.length(); j++) {
                    if (users[i].getUsername().charAt(j) != username.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    loggedInUser = users[i];
                    break;
                }
            }
        }

        if (loggedInUser != null) {
            while (true) {
                display.displayLoggedInMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                case 1:
                    seeCategory(scanner, loggedInUser, display);
                    break;
                case 2:
                    display.displayCart1();
                    loggedInUser.displayCart(scanner);
                    break;
                case 3:
                    while (true) { // Loop until valid input or cancellation
                        System.out.print("Enter the amount to add to your wallet (type 'C' to cancel): Php ");
                        String input = scanner.nextLine().trim(); // Read the input as a string
                
                        if (input.isEmpty()) {
                            System.out.println("Amount cannot be empty. Please enter a valid number or type 'C' to cancel.");
                            System.out.println("");
                            continue; // Go back to the beginning of the loop
                        }
                
                        // Check if the input is a single character and matches 'C' or 'c'
                        if (input.length() == 1 && (input.charAt(0) == 'C' || input.charAt(0) == 'c')) {
                            System.out.println("Operation canceled.");
                            break; // Exit the loop and the case
                        }
                
                        try {
                            double amountToAdd = Double.parseDouble(input);
                            loggedInUser.getWallet().addBalance(amountToAdd); // Call addBalance with the validated input
                            break; // Exit the loop if the input is valid
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid numeric value or type 'C' to cancel.");
                        }
                    }
                    break;
                case 4:
                    // Display wallet and allow user to stay or return to menu
                    while (true) {
                        display.displayWallet();
                        System.out.println("Wallet Balance: Php " + loggedInUser.getWallet().getBalance());
                        System.out.println("\nPress 'r' to return to the main menu.");

                        String walletChoice = scanner.nextLine().trim();

                        // Use .length() and .charAt() for checking the input
                        if (walletChoice.length() == 1 && walletChoice.charAt(0) == 'r') {
                            System.out.println("Returning to the main menu...");
                            break; // Exit the loop to go back to the main menu
                        } else {
                            System.out.println("Invalid option. Please press 'r' to return.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Goodbye, " + username + ". Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("User not found");
        }

    }

    private static void seeCategory(Scanner scanner, User loggedInUser, Display display) {
        display.displayCategoryMenu();
        String input = scanner.nextLine().trim(); // Read entire input and trim whitespace
    
        if (input == null) { // Check for blank input
            System.out.println("No input provided. Returning to menu.");
            return;
        }
    
        char answer = input.charAt(0); // Get the first character of the input
    
        if (answer == 'P' || answer == 'p') {

            listPhysicalBooksCategory(scanner, loggedInUser, display); // Call function that lists physical books

        } else if (answer == 'E' || answer == 'e') {

            listEbooksCategory(scanner, loggedInUser, display); // Call function that lists eBooks

        } else {
            
            System.out.println("Invalid choice. Returning to menu.");

        }
    }
    

    private static void listPhysicalBooksCategory(Scanner scanner, User loggedInUser, Display display) {
        display.displayPhysicalBookCategory();
        for (int i = 0; i < physicalBookCategories.length; i++) {
            if (physicalBookCategories[i].hasPhysicalBooks()) {
                System.out.println((i + 1) + ". " + physicalBookCategories[i].getCategoryName());
                System.out.println("--------------------------");
            }
        }
        System.out.println((physicalBookCategories.length + 1) + ". Back to Main Menu");
    
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();  // Clear newline
    
        if (categoryChoice > 0 && categoryChoice <= physicalBookCategories.length) {
            if (physicalBookCategories[categoryChoice - 1].hasPhysicalBooks()) {
                listBooksInCategory(scanner, loggedInUser, physicalBookCategories[categoryChoice - 1]);
            } else {
                System.out.println("No physical books available in this category.");
            }
        } else if (categoryChoice == physicalBookCategories.length + 1) {
            return;
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
    
    private static void listEbooksCategory(Scanner scanner, User loggedInUser, Display display) {
        display.displayEbookCategory();
        for (int i = 0; i < ebookCategories.length; i++) {
            if (ebookCategories[i].hasEBooks()) {
                System.out.println((i + 1) + ". " + ebookCategories[i].getCategoryName());
                System.out.println("--------------------------");
            }
        }
        System.out.println((ebookCategories.length + 1) + ". Back to Main Menu");
    
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();  // Clear newline
    
        if (categoryChoice > 0 && categoryChoice <= ebookCategories.length) {
            if (ebookCategories[categoryChoice - 1].hasEBooks()) {
                listBooksInCategory(scanner, loggedInUser, ebookCategories[categoryChoice - 1]);
            } else {
                System.out.println("No eBooks available in this category.");
            }
        } else if (categoryChoice == ebookCategories.length + 1) {
            return;
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
    
    private static void listBooksInCategory(Scanner scanner, User loggedInUser, BookCategory category) {
        category.listBooks();
        System.out.println((category.getBooks().length + 1) + ". Back to Menu");

        int bookChoice = scanner.nextInt();
        scanner.nextLine();  // Clear newline

        if (bookChoice > 0 && bookChoice <= category.getBooks().length) {
            Book selectedBook = category.getBooks()[bookChoice - 1];

            System.out.println("\n=-=-=-=-=-=-=-=-=-=");
            System.out.println("Do you want to: ");
            System.out.println("1. Add to cart");
            System.out.println("2. Buy directly");
            System.out.println("=-=-=-=-=-=-=-=-=-=");

            int actionChoice = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            switch (actionChoice) {
                case 1:
                    loggedInUser.addToCart(selectedBook);
                    break;
                case 2:
                    loggedInUser.buyBookDirectly(selectedBook);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } else if (bookChoice == category.getBooks().length + 1) {
            return;
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
}