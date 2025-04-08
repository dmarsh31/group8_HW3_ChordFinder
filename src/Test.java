// Group Members: Dustin M., Riley S., Khu Y.

import java.util.List;

public class Test {
    public static void main(String[] args) {

        Chord c = new Chord("C", "E", "G", "B");
        System.out.println(c.nameOfIntervals);

        ChordFinder cf = new ChordFinder();

        List<Chord> allChords = cf.getAllPermutations("A", "B", "C", "D");
        for (Chord chord : allChords) {
            System.out.println(chord.nameOfIntervals);
        }
    }
}
