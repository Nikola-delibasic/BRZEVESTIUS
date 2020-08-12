
package framework;

public class Helper{

    public static String getRandomText(){
        return "Nikola" + getRandomInteger();


        }


    private static int getRandomInteger(){
        return (int) (Math.random() * 1000);
}
    public static String getRandomEmail(){
        return "nikola" + getRandomInteger() + "@gmail.com";
    }
}
