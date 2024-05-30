import java.util.ArrayList;

/**
 * Handles the logic for splitting the restaurant bill.
 */
public class BillSplitter {
    private ArrayList<Person> people;
    private ArrayList<MenuItem> menu;
    private double taxRate;
    private double gratuityPercentage;
    private double tip;
    private boolean[][] itemAssignments; // 2D array to keep track of item assignments

    /**
     * Constructor to initialize the bill splitter.
     */
    public BillSplitter() {
        this.people = new ArrayList<>();
        this.menu = new ArrayList<>();
        this.taxRate = 0.0;
        this.gratuityPercentage = 0.0;
        this.tip = 0.0;
    }

    /**
     * Adds a person to the list of people sharing the bill.
     * @param person The person to add.
     */
    public void addPerson(Person person) {
        this.people.add(person);
    }

    /**
     * Adds a menu item to the list of menu items.
     * @param menuItem The menu item to add.
     */
    public void addMenuItem(MenuItem menuItem) {
        this.menu.add(menuItem);
        initializeItemAssignments(); // Reinitialize item assignments to accommodate new items
    }

    /**
     * Assigns a menu item to a person.
     * @param personIndex The index of the person who consumed the item.
     * @param itemIndex The index of the item consumed by the person.
     */
    public void assignItemToPerson(int personIndex, int itemIndex) {
        if (personIndex < people.size() && itemIndex < menu.size()) {
            itemAssignments[personIndex][itemIndex] = true;
            Person person = people.get(personIndex);
            MenuItem menuItem = menu.get(itemIndex);
            person.addItem(menuItem);
        }
    }

    /**
     * Sets the tax rate.
     * @param taxRate The tax rate to set.
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Sets the gratuity percentage.
     * @param gratuityPercentage The gratuity percentage to set.
     */
    public void setGratuityPercentage(double gratuityPercentage) {
        this.gratuityPercentage = gratuityPercentage;
    }

    /**
     * Sets the tip amount.
     * @param tip The tip amount to set.
     */
    public void setTip(double tip) {
        this.tip = tip;
    }

    /**
     * Distributes the tax, gratuity, and tip among the people based on their total bill.
     */
    public void distributeAdditionalCharges() {
        double totalBill = 0;
        for (Person person : people) {
            totalBill += person.getAmountToPay();
        }

        double totalTax = totalBill * taxRate / 100;
        double totalGratuity = totalBill * gratuityPercentage / 100;
        double totalAdditionalCharges = totalTax + totalGratuity + tip;

        for (Person person : people) {
            double personShare = person.getAmountToPay() / totalBill;
            double personTax = totalTax * personShare;
            double personGratuity = totalGratuity * personShare;
            double personTip = tip * personShare;

            person.addTax(personTax);
            person.addGratuity(personGratuity);
            person.addTip(personTip);
        }
    }

    /**
     * Displays the final amounts each person has to pay.
     */
    public void displayBill() {
        System.out.println("\n_______________________");
        System.out.println("| Jin's Bill Splitter!");
        System.out.print("| Bill for ");
        for (int i = 0; i < people.size(); i++) {
            if (i == people.size()-1) {
                if (i == 0) {
                    System.out.print(people.get(i).getName());
                }
                else {
                    System.out.print("& " + people.get(i).getName());
                }
            }
            else {
                System.out.print(people.get(i).getName() + ", ");
            }
        }
        System.out.println("\n|______________________");
        for (Person person : people) {
            System.out.printf("| %s has to pay: $%.2f\n", person.getName(), person.getAmountToPay());
            if (person.getItemsConsumed() != null) {
                for (MenuItem item : person.getItemsConsumed()) {
                    System.out.printf("| - %s: $%.2f\n", item.getName(), item.getPrice());
                }
                System.out.println("|");
            }
        }
        System.out.println("_______________________");
    }

    /**
     * Initializes the item assignments 2D array.
     */
    private void initializeItemAssignments() {
        int numPeople = people.size();
        int numItems = menu.size();
        itemAssignments = new boolean[numPeople][numItems];
    }

    /**
     * Gets the list of people.
     * @return The list of people.
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Gets the list of menu items.
     * @return The list of menu items.
     */
    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public String getName(int i) {
        return people.get(i).getName();
    }
}
