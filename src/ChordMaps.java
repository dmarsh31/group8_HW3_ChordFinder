import java.util.HashMap;
import java.util.Map;

public class ChordMaps {

    //the following is a method and a map to get the tone of each note
    public static int getTone(String note) {
        return noteToToneMap.getOrDefault(note, -1);
    }
    private static final Map<String, Integer> noteToToneMap = new HashMap<>();
    static {
        noteToToneMap.put("A", 0);
        noteToToneMap.put("A#", 1);
        noteToToneMap.put("Bb", 1);
        noteToToneMap.put("B", 2);
        noteToToneMap.put("Cb", 2);
        noteToToneMap.put("B#", 3);
        noteToToneMap.put("C", 3);
        noteToToneMap.put("C#", 4);
        noteToToneMap.put("Db", 4);
        noteToToneMap.put("D", 5);
        noteToToneMap.put("D#", 6);
        noteToToneMap.put("Eb", 6);
        noteToToneMap.put("E", 7);
        noteToToneMap.put("Fb", 7);
        noteToToneMap.put("E#", 8);
        noteToToneMap.put("F", 8);
        noteToToneMap.put("F#", 9);
        noteToToneMap.put("Gb", 9);
        noteToToneMap.put("G", 10);
        noteToToneMap.put("G#", 11);
        noteToToneMap.put("Ab", 11);
    }

    //the following is a method and a map to get the interval name for semitone distance
    public static String getIntervalName(int i) {
        return semitonesToIntervalName.get(i);
    }
    private static final Map<Integer, String> semitonesToIntervalName = new HashMap<>();
    static {
        semitonesToIntervalName.put(0, "PERFECT_UNISON");
        semitonesToIntervalName.put(1, "MINOR_SECOND");
        semitonesToIntervalName.put(2, "MAJOR_SECOND");
        semitonesToIntervalName.put(3, "MINOR_THIRD");
        semitonesToIntervalName.put(4, "MAJOR_THIRD");
        semitonesToIntervalName.put(5, "PERFECT_FOURTH");
        semitonesToIntervalName.put(6, "DIMINISHED_FIFTH");
        semitonesToIntervalName.put(7, "PERFECT_FIFTH");
        semitonesToIntervalName.put(8, "AUGMENTED_FIFTH");
        semitonesToIntervalName.put(9, "MAJOR_SIXTH");
        semitonesToIntervalName.put(10, "MINOR_SEVENTH");
        semitonesToIntervalName.put(11, "MAJOR_SEVENTH");
    }

}
