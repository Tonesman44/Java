package song;

public class song {
    public static void main(String[] args) {
        verse1("cat", "fiddle-i-fee");
        verse2("hen", "chimmy-chuck, chimmy-chuck");
        verse3("duck", "quack, quack");
        verse4("goose", "hissy, hissy");
        verse5("sheep", "baa, baa");
        verse6("pig", "oink, oink");
    }

    public static void verse1(String animal, String sound) {
        sing(animal, sound);
    }

    public static void verse2(String animal, String sound) {
        verse1(animal, sound);
        sing("hen", "chimmy-chuck, chimmy-chuck");
    }

    public static void verse3(String animal, String sound) {
        verse2(animal, sound);
        sing("duck", "quack, quack");
    }

    public static void verse4(String animal, String sound) {
        verse3(animal, sound);
        sing("goose", "hissy, hissy");
    }

    public static void verse5(String animal, String sound) {
        verse4(animal, sound);
        sing("sheep", "baa, baa");
    }

    public static void verse6(String animal, String sound) {
        verse5(animal, sound);
        sing("pig", "oink, oink");
        customVerse("horse", "neigh, neigh");
    }

    public static void customVerse(String animal, String sound) {
        sing("Bought me a " + animal + " and the " + animal + " pleased me,");
        sing("I fed my " + animal + " under yonder tree.");
        sing(animal.substring(0, 1).toUpperCase() + animal.substring(1) + " goes " + sound + ".");
        emptyLine();
    }

    public static void sing(String animal, String sound) {
        sing("Bought me a " + animal + " and the " + animal + " pleased me,");
        sing("I fed my " + animal + " under yonder tree.");
        sing(animal.substring(0, 1).toUpperCase() + animal.substring(1) + " goes " + sound + ".");
        emptyLine();
    }

    public static void sing(String line) {
        System.out.println(line);
    }

    public static void emptyLine() {
        System.out.println();
    }
}

