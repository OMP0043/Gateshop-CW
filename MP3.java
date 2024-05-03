public class MP3 extends Gadget {
    // Attribute
    private int availableMemory;

    // Constructor
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    // Accessor method
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Method to download music
    public void downloadMusic(int downloadSize) {
        if (downloadSize <= availableMemory) {
            availableMemory -= downloadSize;
            System.out.println("Music downloaded. Available memory: " + availableMemory + " MB");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    // Method to delete music
    public void deleteMusic(int deletedSize) {
        availableMemory += deletedSize;
        System.out.println("Music deleted. Available memory: " + availableMemory + " MB");
    }

    // Display method override
    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.display()); // Call the superclass display method
        sb.append("Available Memory: ").append(availableMemory).append(" MB").append("\n");
        return sb.toString();
    }
}
