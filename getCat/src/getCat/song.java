// Antonio Fabrizio
// September 18th 2023
// Assignment 02. get you a cat
// This program calls each verse which links together an animal and their noise. 
// After each verse, that animal and their noise are added to the next verse.

package getCat;

public class song {
    public static void main(String[] args) {
    	verseOne();
    	verseTwo();
    	verseThree();
    	verseFour();
    	verseFive();  
    	customVerse();
    }
    
    public static void verseOne() {
    	bought_fed("cat");
    	sound("cat", "fiddle-i-fee" + "\n");
    }
    
    public static void verseTwo() {
    	bought_fed("hen");
    	sound("hen", "chimmy-chuck, chimmy-chuck");
    	sound("cat", "fiddle-i-fee" + "\n");
    }
    
    public static void verseThree() {
    	bought_fed("duck");
    	sound("duck", "quack, quack");
    	sound("hen", "chimmy-chuck, chimmy-chuck");
    	sound("cat", "fiddle-i-fee" + "\n");
    }
    
    public static void verseFour() {
    	bought_fed("hissy, hissy");
    	sound("goose", "hissy, hissy");
    	sound("duck", "quack, quack");
    	sound("hen", "chimmy-chuck, chimmy-chuck");
    	sound("cat", "fiddle-i-fee" + "\n");
    }
    
    public static void verseFive() {
    	bought_fed("sheep");
    	sound("sheep", "baa, baa");
    	sound("goose", "hissy, hissy");
    	sound("duck", "quack, quack");
    	sound("hen", "chimmy-chuck, chimmy-chuck");
    	sound("cat", "fiddle-i-fee" + "\n");
    }
    
    public static void customVerse() {
    	bought_fed("pig");
    	sound("pig", "oink, oink");
    	sound("sheep", "baa, baa");
    	sound("goose", "hissy, hissy");
    	sound("duck", "quack, quack");
    	sound("hen", "chimmy-chuck, chimmy-chuck");
    	sound("cat", "fiddle-i-fee" + "\n");
    }

    public static void bought_fed(String animal) {
        System.out.println("Bought me a " + animal + " and the " + animal + " pleased me,");
        System.out.println("I fed my " + animal + " under yonder tree.");
    }
    
    public static void sound(String animal, String sound) {
        System.out.println(animal.substring(0, 1).toUpperCase() + animal.substring(1) + " goes " + sound);

    }
}