
public class EnhancedForLoop {

    public static void main(String[] args) {

        int[] scores = {1,2,3};
        double total = 0;

        for (double element : scores) {
            total += element;
        };

        System.out.println(total);
    };

    // static = everyone has access, belongs to the class
    // final = nobody can modify it
    public static final int MAXSCORE = 100;
    

};



