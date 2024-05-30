/**
 * Represents an item on the restaurant menu.
 */
public class MenuItem {
    private String name;
    private double price;

    /**
     * Constructor to create a new menu item.
     * @param name The name of the menu item.
     * @param price The price of the menu item.
     */
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the menu item.
     * @return The name of the menu item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the menu item.
     * @return The price of the menu item.
     */
    public double getPrice() {
        return price;
    }
}
