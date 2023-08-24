package InterfaceExample;

public class Item implements Comparable {
    private int value;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int weight;

    public Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Item otherItem = (Item) o;
        //return a negative int if this object is less than passed in object
        //return zero if they are equal
        //return a positive int if this object is greater than the passed in object

        //sort on value (suppose)
        // return this.value - otherItem.value;

        //sort on value per unit weight
        double difference = this.value / (1.0 * this.weight) - otherItem.value / (1.0 * otherItem.weight);
        if (difference < 0) return -1;
        if (difference == 0) return 0;
        return 1;
    }

    
}
