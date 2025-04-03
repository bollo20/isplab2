package laborator5;

import java.util.*;

public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa, List<Integer> note) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = note;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }

    public double calculateAverage() {
        return note.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public int getNumarRestante() {
        return (int) note.stream().filter(n -> n < 5).count();
    }

    @Override
    public String toString() {
        return nume + " " + prenume + " - Grupa: " + grupa + " - Note: " + note;
    }

    // Implementarea metodelor equals() și hashCode() pentru Map
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return nume.equals(student.nume) && prenume.equals(student.prenume) && grupa.equals(student.grupa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, grupa);
    }
}

