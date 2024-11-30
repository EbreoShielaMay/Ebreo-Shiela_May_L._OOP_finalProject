public abstract class Book implements Purchasable {
    private String title;
    private double price;

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

    @Override
    public String toString() {
        return title + " - Php " + price;
    }

    public static class PhysicalBook extends Book {
        private int stock;

        public PhysicalBook(String title, double price, int stock) {
            super(title, price);
            this.stock = stock;
        }

        public int getStock() {
            return stock;
        }

        public void decreaseStock() {
            if (stock > 0) stock--;
        }

        @Override
        public void purchase(User user) {
            if (stock > 0) {
                if (user.getWallet().getBalance() >= getPrice()) {
                    user.getWallet().deductBalance(getPrice());
                    decreaseStock();
                    System.out.println("Purchased physical book: " + getTitle());
                    user.generateReceipt(this);
                } else {
                    System.out.println("Insufficient balance for " + getTitle());
                }
            } else {
                System.out.println(getTitle() + " is out of stock.");
            }
        }

        @Override
        public String toString() {
            return super.toString() + " (Stock: " + stock + ")";
        }
    }

    public static class eBook extends Book {
        public eBook(String title, double price) {
            super(title, price);
        }

        @Override
        public void purchase(User user) {
            if (user.getWallet().getBalance() >= getPrice()) {
                user.getWallet().deductBalance(getPrice());
                System.out.println("Purchased ebook: " + getTitle());
                user.generateReceipt(this);
            } else {
                System.out.println("Insufficient balance for " + getTitle());
            }
        }
    }
}
