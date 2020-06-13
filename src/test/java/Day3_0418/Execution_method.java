package Day3_0418;

public class Execution_method {

    public static void main(String[] args) {
        Custom_method.voidADD(100,200);
        // call the return add method
        int c= Custom_method.returnAdd(200,300);
        System.out.println("new result is " +( c-25));

        Custom_method.voidADD(200,400);
        Custom_method.voidADD(60,50);
        int d= Custom_method.returnAdd(200,600);
        System.out.println("my new result is " + (d/100));

        Custom_method.voidADD(40,60);
        int e = Custom_method.returnAdd(200,800);
        System.out.println("my new result is " + (e+200));


    } // end of main method

}//end of java class
