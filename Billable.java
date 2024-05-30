/**
 * Interface for objects that can be billed.
 */
public interface Billable {
    /**
     * Gets the total amount to pay.
     * @return The total amount to pay.
     */
    double getAmountToPay();
}
