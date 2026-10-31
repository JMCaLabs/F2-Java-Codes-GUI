public class PizzaSize {

    public double getPrice(String size){
        switch (size) {
            case "Small":
                return 10.00;
            case "Medium":
                return 15.00;
            case "Large":
                return 20.00;
            default:
                return 0.00;
        }
    }
}
