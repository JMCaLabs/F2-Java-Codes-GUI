import javax.swing.*;
import java.awt.*;


public class PizzaOrderSystem {
    private JComboBox pizzaSizeChoice;
    private JComboBox pizzaToppingsChoice;
    private JComboBox extraCheeseChoice;
    private JButton calculateButton;
    private JLabel pSize;
    private JLabel pTops;
    private JLabel pCheeze;
    private JLabel totalLabel;
    private JPanel OrderSystem;

    double total = 0.00;

    PizzaOrderSystem(){

        OrderSystem.setPreferredSize(new Dimension(300, 400));
        calculateButton.setPreferredSize(new Dimension(100, 20));
        //pizzaSizeChoice.setPreferredSize(new Dimension(100, 20));
        //pizzaToppingsChoice.setPreferredSize(new Dimension(100, 20));
        //extraCheeseChoice.setPreferredSize(new Dimension(100, 20));

        pizzaSizeChoice.addItem("Small");
        pizzaSizeChoice.addItem("Medium");
        pizzaSizeChoice.addItem("Large");

        pizzaToppingsChoice.addItem("Mushroom");
        pizzaToppingsChoice.addItem("Pepperoni");
        pizzaToppingsChoice.addItem("Onions");

        extraCheeseChoice.addItem("Yes");
        extraCheeseChoice.addItem("No");

        pSize.setText("Size");
        pTops.setText("Toppings");
        pCheeze.setText("Extra Cheese");
        calculateButton.setText("Calculate Total");
        totalLabel.setText("Total: 0");

        calculateButton.addActionListener(e -> {
            String size = pizzaSizeChoice.getSelectedItem().toString();
            String toppings = pizzaToppingsChoice.getSelectedItem().toString();
            String cheese = extraCheeseChoice.getSelectedItem().toString();

            PizzaSize pizzaSize = new PizzaSize();
            PizzaToppings pizzaTops = new PizzaToppings();
            PizzaCheese choice = new PizzaCheese();

            double sizeP = pizzaSize.getPrice(size);
            double toppingsP = pizzaTops.getPrice(toppings);
            double yORn = choice.getPrice(cheese);

            total = sizeP + toppingsP + yORn;

            totalLabel.setText(String.format("Total: $%.2f", total));
        });
    }

    static void main(String[] args) {
        JFrame frame = new JFrame("Pizza Order System");

        PizzaOrderSystem order = new PizzaOrderSystem();

        frame.setContentPane(order.OrderSystem);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
