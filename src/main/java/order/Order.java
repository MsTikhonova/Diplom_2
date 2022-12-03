package order;

public class Order {
    static String[] ingredients;

    public Order(){
        this.ingredients = ingredients;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public static Order getTrueOrder() {
        ingredients = new String[2];
        ingredients[0] = "61c0c5a71d1f82001bdaaa6d";
        ingredients[1]= "61c0c5a71d1f82001bdaaa6f";
        return new Order();
    }

    public static Order getWrongIngredientsInOrder() {
        ingredients = new String[2];
        ingredients[0] = "86453";
        ingredients[1]= "65asdoi";
        return new Order();
    }

    public static Order getOrderWithoutIngredients() {
        return new Order();
    }
}
