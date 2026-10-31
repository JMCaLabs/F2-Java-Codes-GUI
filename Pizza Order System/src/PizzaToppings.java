public class PizzaToppings {
    public double getPrice(String toppings) {
        switch (toppings){
            case "Mushroom", "Onions", "Pepperoni":
                return 2.00;
            default:
                return 0.00;
        }
    }
}
