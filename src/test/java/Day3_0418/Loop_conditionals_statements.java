package Day3_0418;

public class Loop_conditionals_statements {

    public static void main(String[] args) {
// only print out city when it is Brooklyn or Queens

        String[] city = new String[4];
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "Manhattan";
        city[3] = "Bronx";

        for(int i = 0; i < city.length; i++) {
            // using if else if condition
            // Different operators ==,&&,||,<,>,<=,=>
            //string can have equal() command or == but integer must have==
            // equal command when the expected value is matching the array value
            //equalIgnoreCase command will ignore case sensitivity as long as the array value
            //spelling is correct

            if (city[i].equals("Brooklyn")) {
                System.out.println("My city is " + city[i]);}


            else if (city[i] == "Queens"); System.out.println("My city is " + city[i]);

            //using or|| operators to meet the same conditions as above
            if (city[i].equals("Brooklyn") || city[1] == "Queens") {
                System.out.println("My city is " + city[1]);
            }// end of operation condition
        }//end of for loop

    }//end of main method


}//end of java class
