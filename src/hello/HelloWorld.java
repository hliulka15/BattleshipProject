package hello;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        int sum=0;

        // int i=1;

        //while used when we're not sure when the condition will end
        // while (i <=100) {
        //     sum = sum + i;
        //     i++;
        // }

        // for loop for when we have a predetermined range
        for (int i = 0; i <= 100; i++) {
            sum = i + sum;
        }

        System.out.println(sum);
    }
}
