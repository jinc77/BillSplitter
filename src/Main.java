import java.util.Scanner;

/**
 * Main class to run the bill splitter program.
 */
public class Main {
    public static void main(String[] args) {
        boolean tipBool = true;
        boolean gratuityBool = true;

        Scanner scanner = new Scanner(System.in);
        BillSplitter billSplitter = new BillSplitter();

        // Add people
        System.out.print("Enter number of people: ");

        int numPeople = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter name of person " + (i + 1) + ": ");

            String name = scanner.nextLine();
            billSplitter.addPerson(new Person(name));
        }

        // Add menu items
        System.out.print("Enter number of menu items: ");

        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numItems; i++) {
            System.out.print("Enter name of menu item " + (i + 1) + ": ");

            String itemName = scanner.nextLine();
            System.out.print("Enter price of " + itemName + ": $");

            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            billSplitter.addMenuItem(new MenuItem(itemName, price));
        }

        // Display person number and name
        for (int i = 0; i < numPeople; i++) {
            System.out.println("Person " + (i+1) + ": " + billSplitter.getName(i));
        }

        // Assign items to people
        for (int i = 0; i < numItems; i++) {
            MenuItem item = billSplitter.getMenu().get(i);
            System.out.print("Who consumed " + item.getName() + " ($" + item.getPrice() + ")? Enter the person's number (1 to " + numPeople + "): ");
            int personIndex = scanner.nextInt() - 1;
            billSplitter.assignItemToPerson(personIndex, i);
        }

        // Get tax rate
        System.out.print("Enter tax rate percentage: ");

        double taxRate = scanner.nextDouble();
        billSplitter.setTaxRate(taxRate);

        // Get gratuity percentage
        System.out.print("Enter gratuity percentage (-1 if none): ");

        double gratuityPercentage = scanner.nextDouble();
        if (gratuityPercentage == -1) {
            gratuityBool = false;
        }
        if (gratuityBool) {
            billSplitter.setGratuityPercentage(gratuityPercentage);
        }

        // Get tip amount
        System.out.print("Enter tip amount (-1 if none): ");

        double tip = scanner.nextDouble();
        if (tip == -1) {
            tipBool = false;
        }
        if (tipBool) {
            billSplitter.setTip(tip);
        }

        // Distribute tax gratuity and tip
        if (tipBool || gratuityBool) {
            billSplitter.distributeAdditionalCharges();
        }

        // Display the final bill
        billSplitter.displayBill();

        scanner.close();
    }
}
