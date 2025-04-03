package laborator3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int p = 4;

        // Crearea listelor x si y
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        // Popularea listelor x si y cu 5, respectiv 7 elemente aleatorii
        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11)); // Adaugă numere între 0 și 10
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11)); // Adaugă numere între 0 și 10
        }

        // Ordonarea crescătoare a listelor x și y
        Collections.sort(x);
        Collections.sort(y);

        // a) xPlusY conține toate elementele din x și y
        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        System.out.println("xPlusY: " + xPlusY);

        // b) zSet conține numai valorile comune din x și y, luate o singură dată
        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y); // Lasă doar elementele comune
        System.out.println("zSet (comune): " + zSet);

        // c) xMinusY conține valorile din x care nu se află în y
        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y); // Elimina elementele care se află în y
        System.out.println("xMinusY: " + xMinusY);

        // d) xPlusYLimitedByP conține valorile din x și y care nu depășesc valoarea p
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        for (Integer num : xPlusY) {
            if (num <= p) {
                xPlusYLimitedByP.add(num);
            }
        }
        System.out.println("xPlusYLimitedByP (<= " + p + "): " + xPlusYLimitedByP);
    }
}
