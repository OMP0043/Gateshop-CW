import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets;

    public GadgetShop() {
        gadgets = new ArrayList<>();
    }

    public ArrayList<Gadget> getGadgets() {
        return gadgets;
    }

    public void addGadget(Gadget gadget) {
        gadgets.add(gadget);
    }
    public void displayAllGadgets() {
        for (Gadget gadget : gadgets) {
            gadget.display();
        }
    }
}