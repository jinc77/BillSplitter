import java.util.ArrayList;

/**
 * Represents a person who shares the bill.
 */
public class Person implements Billable {
    private String name;
    private double amountToPay;
    private ArrayList<MenuItem> itemsConsumed;

    /**
     * Constructor to create a new person with a name.
     * @param name The name of the person.
     */
    public Person(String name) {
        this.name = name;
        this.amountToPay = 0.0;
        this.itemsConsumed = new ArrayList<>();
    }

    /**
     * Gets the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the amount the person has to pay.
     * @return The amount to pay.
     */
    @Override
    public double getAmountToPay() {
        return amountToPay;
    }

    /**
     * Adds a specified amount to the person's total amount to pay.
     * @param amount The amount to add.
     */
    public void addToPay(double amount) {
        this.amountToPay += amount;
    }

    /**
     * Adds a menu item to the person's list of consumed items and updates the amount to pay.
     * @param item The menu item to add.
     */
    public void addItem(MenuItem item) {
        this.itemsConsumed.add(item);
        this.addToPay(item.getPrice());
    }

    /**
     * Gets the list of items consumed by the person.
     * @return The list of items consumed.
     */
    public ArrayList<MenuItem> getItemsConsumed() {
        return itemsConsumed;
    }

    /**
     * Adds tax to the person's amount to pay.
     * @param tax The tax amount.
     */
    public void addTax(double tax) {
        this.amountToPay += tax;
    }

    /**
     * Adds gratuity to the person's amount to pay.
     * @param gratuity The gratuity amount.
     */
    public void addGratuity(double gratuity) {
        this.amountToPay += gratuity;
    }

    /**
     * Adds a tip to the person's amount to pay.
     * @param tip The tip amount.
     */
    public void addTip(double tip) {
        this.amountToPay += tip;
    }
}
