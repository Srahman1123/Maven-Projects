package Action_items;

public class  AC_1 {
    public static void main(String[] args) {

        int[] streetNumber = new int[4];

        streetNumber[0] = 2347;
        streetNumber[1] = 321;
        streetNumber[2] = 319;
        streetNumber[3] = 323;

        String[] zipCode = new String[4];
        zipCode[0] = "11210";
        zipCode[1] = "11218";
        zipCode[2] = "11223";
        zipCode[3] = "11224";

        for (int i = 0; i < streetNumber.length; i++) {
            System.out.println("My street number is " + streetNumber[i] + " and my zipcode is " + zipCode[i]);
        }// end of for loop

        int i = 0;

        while(i < zipCode.length){
            System.out.println("my zipcode is " + zipCode[i] + " and My street number is " + streetNumber[i]);
            i = i + 1;
        }// end of while loop

    }//end of main method
}//end of java class





