import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grocery extends JFrame {

    static ArrayList<Item> inventory = new ArrayList<>();

    public Grocery() {
        super("Grocery Management System");
        setLayout(new FlowLayout());

        JButton addButton = new JButton("Add item to inventory");
        JButton removeButton = new JButton("Remove item from inventory");
        JButton viewButton = new JButton("View inventory");
        JButton exitButton = new JButton("Exit");

        add(addButton);
        add(removeButton);
        add(viewButton);
        add(exitButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewInventory();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    static void addItem() {
        String name = JOptionPane.showInputDialog("Enter item name:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter item quantity:"));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter item price:"));

        Item newItem = new Item(name, quantity, price);
        inventory.add(newItem);

        JOptionPane.showMessageDialog(null, "Item added to inventory.");
    }

    static void removeItem() {
        String name = JOptionPane.showInputDialog("Enter item name:");

        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                inventory.remove(item);
                JOptionPane.showMessageDialog(null, "Item removed from inventory.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Item not found in inventory.");
    }

    static void viewInventory() {
        String message = "Inventory:\n";
        for (Item item : inventory) {
            message += item.getName() + " (" + item.getQuantity() + ") - $" + item.getPrice() + "\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        Grocery grocery = new Grocery();
    }

}

