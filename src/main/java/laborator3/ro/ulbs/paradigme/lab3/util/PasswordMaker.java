package laborator3.ro.ulbs.paradigme.lab3.util;

// Importă clasa Random din pachetul java.util
import java.util.Random;

public class PasswordMaker {
    // Definirea unei constante pentru numărul magic
    private static final int MAGIC_NUMBER = 7; // Valoare între 5 și 10
    // Definirea unui câmp final pentru șirul magic
    private final String magicString;
    // Definirea unui câmp final pentru nume
    private final String name;
    // Definirea unei instanțe statice a clasei PasswordMaker
    private static PasswordMaker instance;
    // Definirea unui contor static pentru a număra de câte ori a fost accesată metoda getInstance()
    private static int accessCounter = 0;

    // Bloc static pentru inițializarea instanței
    static {
        try {
            // Inițializarea instanței cu un nume implicit
            instance = new PasswordMaker("defaultName");
        } catch (Exception e) {
            // Aruncarea unei excepții în cazul în care apare o eroare la crearea instanței
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    // Constructor privat pentru a preveni instanțierea directă
    private PasswordMaker(String name) {
        // Inițializarea câmpului name
        this.name = name;
        // Inițializarea câmpului magicString cu un șir aleatoriu de 20 de caractere
        magicString = getString();
    }

    private String getString() {
        final String magicString;
        //this.magicString = StringRandomizer.getRandomString(20); // Lungime minimă de 20 de caractere
        return this.magicString;
    }

    // Metodă statică pentru a obține instanța unică a clasei
    public static PasswordMaker getInstance() {
        // Incrementarea contorului de acces
        accessCounter++;
        // Returnarea instanței unice
        return instance;
    }

    // Metodă pentru a genera o parolă
    public String getPassword() {
        // Crearea unui obiect Random
        Random random = new Random();
        // Generarea unui șir aleatoriu de lungime MAGIC_NUMBER
        String randomString = "";//StringRandomizer.getRandomString(MAGIC_NUMBER);
        // Obținerea unei părți din șirul magic
        String randomMagicStringPart = magicString.substring(0, 10);
        // Obținerea lungimii numelui ca șir de caractere
        String nameLengthString = String.valueOf(name.length());
        // Generarea unui număr aleatoriu între 0 și 50
        int randomInt = random.nextInt(0, 50); // Interval [0, 50]

        // Returnarea parolei generate prin concatenarea șirurilor
        return randomString + randomMagicStringPart + nameLengthString + randomInt;
    }

    // Metodă statică pentru a obține valoarea contorului de acces
    public static int getAccessCounter() {
        return accessCounter;
    }
}