// Group Members: Dustin M., Riley S., Khu Y.

public class Test {
    public static void main(String[] args) {
        ChordFinder cf = new ChordFinder();
        // Major
        System.out.println(cf.getChordName("C", "E", "G"));

        // Minor
        System.out.println(cf.getChordName("C", "Eb", "G"));

        // Diminished
        System.out.println(cf.getChordName("C", "Eb", "Gb"));

        // Augmented
        System.out.println(cf.getChordName("C", "E", "G#"));

        // Suspended 4 -- ****
        System.out.println(cf.getChordName("C", "F", "G"));

        // Dominant 7 -- ****
        System.out.println(cf.getChordName("C", "E", "G", "Bb"));

        // Major 7  -- ****
        System.out.println(cf.getChordName("C", "E", "G", "B"));

        // **** -- for these 3 chord structures I asked AI and I believe the professor gave us the wrong intervals in the JSON
    }
}
