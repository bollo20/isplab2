package laborator3.ro.ulbs.paradigme.lab3.util;

import laborator3.ro.ulbs.paradigme.lab3.util.StringRandomizer;

public class PasswordMaker {
    private static final StringRandomizer stringRandomizer = new StringRandomizer();
    private double MAGIC_NUMBER;
    private String magicString;
    private String name;

    // Contor static pentru a număra de câte ori a fost apelată metoda getInstance()
    private static int accessCount = 0;

    // Instanța statică a clasei PasswordMaker (Singleton) inițializată într-un bloc static
    private static PasswordMaker instance;

    // Bloc static pentru inițializarea instanței
    static {
        instance = null;  // Instanța este null la început
    }

    // Constructor privat pentru a preveni instanțierea directă
    private PasswordMaker(String name) {
        this.name = name;
    }

    // Metodă publică pentru a obține instanța unică a clasei PasswordMaker
    public static PasswordMaker getInstance(String name) {
        // Incrementăm contorul de acces
        accessCount++;

        if (instance == null) {
            instance = new PasswordMaker(name);  // Crează instanța doar dacă nu există deja
        }
        return instance;
    }

    // Metodă pentru a obține numărul de accesări la getInstance()
    public static int getAccessCount() {
        return accessCount;
    }

    // Metodă pentru a seta numele (în cazul în care dorim să schimbăm numele pentru instanța existentă)
    public void setName(String name) {
        this.name = name;
    }

    // Metodă pentru generarea parolei
    public String getPassword() {
        MAGIC_NUMBER = Math.random() * 5 + 5;
        magicString = stringRandomizer.getRandomString((int) MAGIC_NUMBER);
        StringBuilder random10Chars = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            int index = (int) (Math.random() * magicString.length());
            random10Chars.append(magicString.charAt(index));
        }
        String nameLengthString = String.valueOf(name.length());
        int randomInt = (int) (Math.random() * 51);
        return magicString + random10Chars.toString() + nameLengthString + randomInt;
    }
}
