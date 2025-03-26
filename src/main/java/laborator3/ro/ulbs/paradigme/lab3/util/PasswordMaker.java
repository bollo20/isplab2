package laborator3.ro.ulbs.paradigme.lab3.util;

import laborator3.ro.ulbs.paradigme.lab3.util.StringRandomizer;

public class PasswordMaker {
    private static final StringRandomizer stringRandomizer = new StringRandomizer();
    private double MAGIC_NUMBER;
    private String magicString;
    private String name;

    private static int accessCount = 0;


    private static PasswordMaker instance;

    static {
        instance = null;
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance(String name) {
        accessCount++;

        if (instance == null) {
            instance = new PasswordMaker(name);  // Crează instanța doar dacă nu există deja
        }
        return instance;
    }

    public static int getAccessCount() {
        return accessCount;
    }

   public void setName(String name) {
        this.name = name;
    }


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
