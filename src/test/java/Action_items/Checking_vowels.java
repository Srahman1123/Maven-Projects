package Action_items;

public class Checking_vowels {
    public static void main(String[] args) {


        String[] letterList = new String[5];
        letterList[0] = "a";
        letterList[1] = "b";
        letterList[2] = "c";
        letterList[3] = "d";
        letterList[4] = "e";

        int i;
        for (i = 0; i<letterList.length; i++){

       if (letterList[i]=="a"|| letterList[i]=="e"){
        System.out.println("vowel matches");
       }else{
           System.out.println("vowel does not match");
       }


        }//loop










    }//end of method
}//end of java
