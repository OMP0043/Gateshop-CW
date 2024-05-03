public class Gadget {
    // Attributes
    private String model;
    private double price;
    private int weight;
    private String size;

    // Constructor
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Accessor methods
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    // Display method
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("Model: ").append(model).append("\n");
        sb.append("Price: £").append(price).append("\n");
        sb.append("Weight: ").append(weight).append(" grams").append("\n");
        sb.append("Size: ").append(size).append("\n");
        return sb.toString();
    }
}
