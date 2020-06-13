package Day3_0418;

public class Custom_method {


    // purpose of these user defined custom method so that i can reuse it again and again
    //and call it on my main method when i need to use them
    // user defined custom methods will be created here
    // lets create one for void first

    public static void voidADD (int a, int b){
        int result = a+b;
        System.out.println(" My addition results is " + result);
    }// end of void method
    //create same method as return method
    public static int returnAdd (int a , int b){
        int result = a+b;
        System.out.println("my addition result is" + result);
        return result;// will return the result c
    }// end of void method


}//end of java class
