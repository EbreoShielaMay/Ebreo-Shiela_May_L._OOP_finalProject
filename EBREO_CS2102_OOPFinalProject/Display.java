public class Display {
    public void displayMainMenu() {
        System.out.println("");
            System.out.println("\t\t\t        (=^-ω-^=)");
            System.out.println("\t\t\t=-=-=-=-===***===-=-=-=-=");
            System.out.println("\t\t\t WELCOME TO D'Bookstore! ");
            System.out.println("\t\t\t=-=-=-=-=-=-=-=-=-=-=-=-=");

            System.out.println(" -=-=-=-=-=");
            System.out.println(" || MENU ||");
            System.out.println(" -=-=-=-=-=");
            System.out.println();
            System.out.println("-------------");
            System.out.println("1. Sign up");
            System.out.println("-------------");
            System.out.println("2. Log in");
            System.out.println("-------------");
            System.out.println("3. Exit");
            System.out.println("-------------");
    }

    public void displayRegisterSuccess() {
        System.out.println("\n\nx-------------------------------x");
        System.out.println("|  Registration successful. :>  |");
        System.out.println("x-------------------------------x\n\n");
    }

    public void displayLoggedInMenu() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-");
        System.out.println("|| Logged in Menu ||");
        System.out.println("=-=-=-=-=-=-=-=-=-=-");
        System.out.println();
        System.out.println("------------------------");
        System.out.println("1. See Book Categories");
        System.out.println("------------------------");
        System.out.println("2. View Cart");
        System.out.println("------------------------");
        System.out.println("3. Add Balance");
        System.out.println("------------------------");
        System.out.println("4. View Wallet");
        System.out.println("------------------------");
        System.out.println("5. Exit");
        System.out.println("------------------------");
        System.out.print("Please choose an option: ");
    }

    public void displayCategoryMenu() {
        System.out.println();
        System.out.println("=-=-=-=--=-=-=-=-=-=-");
        System.out.println("|| Book Categories ||");
        System.out.println("=-=-=-=--=-=-=-=-=-=-");
    
        System.out.println("(P) Physical Book ");
        System.out.println("(E) eBook");
        System.out.print("What type of book do you want? Choose the corresponding letter or press Enter to return: ");
    }

    public void displayWallet() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=");
        System.out.println("|   Wallet  |");
        System.out.println("=-=-=-=-=-=-=");
    }

    public void displayCart1() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=");
        System.out.println("|    Cart     |");
        System.out.println("=-=-=-=-=-=-=-=");
    }

    public void displayPhysicalBookCategory() {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("| Available Physical Book Categories: |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
    }

    public void displayEbookCategory() {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("| Available eBook Categories: |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
    }

}
