public class Mobile extends Gadget {
    // Attribute
    private int callingCredit;

    // Constructor
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    // Accessor method
    public int getCallingCredit() {
        return callingCredit;
    }

    // Method to add calling credit
    public void addCallingCredit(int creditToAdd) {
        if (creditToAdd > 0) {
            callingCredit += creditToAdd;
        } else {
            System.out.println("Please enter a positive amount for calling credit.");
        }
    }

    // Method to make a call
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            callingCredit -= duration;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    // Display method override
    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.display()); // Call the superclass display method
        sb.append("Calling Credit Remaining: ").append(callingCredit).append(" minutes").append("\n");
        return sb.toString();
    }
}
