import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GadgetShopGUI extends JFrame implements ActionListener {
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField,
            phoneNumberField, durationField, downloadSizeField, displayNumberField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton;
    private GadgetShop gadgetShop;

    public GadgetShopGUI() {
        gadgetShop = new GadgetShop();

        setTitle("Gadget Shop");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 2, 10, 5));

        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField();
        memoryField = new JTextField();
        phoneNumberField = new JTextField();
        durationField = new JTextField();
        downloadSizeField = new JTextField();
        displayNumberField = new JTextField();

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make A Call");
        downloadMusicButton = new JButton("Download Music");

        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);

        mainPanel.add(new JLabel("Model:"));
        mainPanel.add(modelField);
        mainPanel.add(new JLabel("Price:"));
        mainPanel.add(priceField);
        mainPanel.add(new JLabel("Weight:"));
        mainPanel.add(weightField);
        mainPanel.add(new JLabel("Size:"));
        mainPanel.add(sizeField);
        mainPanel.add(new JLabel("Initial Credit:"));
        mainPanel.add(creditField);
        mainPanel.add(new JLabel("Initial Memory:"));
        mainPanel.add(memoryField);
        mainPanel.add(new JLabel("Phone Number:"));
        mainPanel.add(phoneNumberField);
        mainPanel.add(new JLabel("Duration:"));
        mainPanel.add(durationField);
        mainPanel.add(new JLabel("Download Size:"));
        mainPanel.add(downloadSizeField);
        mainPanel.add(new JLabel("Display Number:"));
        mainPanel.add(displayNumberField);
        mainPanel.add(addMobileButton);
        mainPanel.add(addMP3Button);
        mainPanel.add(clearButton);
        mainPanel.add(displayAllButton);
        mainPanel.add(makeCallButton);
        mainPanel.add(downloadMusicButton);

        add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addMobileButton) {
        // Get input values from text fields
        String model = modelField.getText();
        double price = Double.parseDouble(priceField.getText());
        int weight = Integer.parseInt(weightField.getText());
        String size = sizeField.getText();
        int credit = Integer.parseInt(creditField.getText());
        // Create a new Mobile gadget and add it to the GadgetShop
        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgetShop.addGadget(mobile);
        JOptionPane.showMessageDialog(this, "Mobile added successfully.");
    } else if (e.getSource() == addMP3Button) {
        // Get input values from text fields
        String model = modelField.getText();
        double price = Double.parseDouble(priceField.getText());
        int weight = Integer.parseInt(weightField.getText());
        String size = sizeField.getText();
        int memory = Integer.parseInt(memoryField.getText());
        // Create a new MP3 gadget and add it to the GadgetShop
        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgetShop.addGadget(mp3);
        JOptionPane.showMessageDialog(this, "MP3 player added successfully.");
    } else if (e.getSource() == clearButton) {
        // Clear all text fields
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    } else if (e.getSource() == displayAllButton) {
        // Display details of all gadgets
        StringBuilder details = new StringBuilder();
        for (Gadget gadget : gadgetShop.getGadgets()) {
            details.append(gadget.display()).append("\n");
        }
        JOptionPane.showMessageDialog(this, details.toString());
    } else if (e.getSource() == makeCallButton) {
    // Get input values from text fields
    int displayNumber = Integer.parseInt(displayNumberField.getText());
    String phoneNumber = phoneNumberField.getText();
    int duration = Integer.parseInt(durationField.getText());
    // Check if the display number is valid
    if (displayNumber < 0 || displayNumber >= gadgetShop.getGadgets().size()) {
        JOptionPane.showMessageDialog(this, "Invalid display number.");
        return; // Exit the method if the display number is invalid
    }

    // Get the Mobile gadget corresponding to the display number
    Mobile mobile = (Mobile) gadgetShop.getGadgets().get(displayNumber);

    // Check if mobile is not null (valid display number)
    if (mobile != null) {
        // Attempt to make the call
        mobile.makeCall(phoneNumber, duration);
        // Show appropriate message based on the outcome
        JOptionPane.showMessageDialog(this, "Call made successfully.");
    } else {
        JOptionPane.showMessageDialog(this, "Invalid display number.");
    }


    } else if (e.getSource() == downloadMusicButton) {
        // Get input values from text fields
        int displayNumber = Integer.parseInt(displayNumberField.getText());
        int downloadSize = Integer.parseInt(downloadSizeField.getText());

        // Download music using the selected MP3 gadget
        MP3 mp3 = (MP3) gadgetShop.getGadgets().get(displayNumber);
        if (mp3 == null) {
            JOptionPane.showMessageDialog(this, "Invalid display number.");
        } else if (downloadSize > mp3.getAvailableMemory()) {
            JOptionPane.showMessageDialog(this, "Insufficient memory to download music.");
        } else {
            // Download music using the MP3 gadget
            mp3.downloadMusic(downloadSize);
            JOptionPane.showMessageDialog(this, "Music downloaded successfully.");
        }
    }
}


    public static void main(String[] args) {
        new GadgetShopGUI();
    }
}
