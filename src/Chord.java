// Group Members: Dustin M., Riley S., Khu Y.

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Chord {

    //list of all notes in the chord
    private ArrayList <String> notes;

    //this list is the name of all intervals in the chord
    //**e.g. the first string is the interval between the first note and the second note
    public ArrayList <String> nameOfIntervals;

    //constructor -- ensures all notes are real notes and fills both the notes list, and distanceFromEachNote list
    public Chord(String ... notes){
        this.notes = new ArrayList<String>();
        this.nameOfIntervals = new ArrayList<String>();

        //constructs this.notes list and ensures there is no duplicate notes
        for (String note : notes) {
            this.notes.add(note);
        } 

        //gets the interval from note to note
        for (int i=0; i<this.notes.size() - 1; i++){
            //case if an invalid note is given 
            if (getTone(this.notes.get(i + 1)) == -1 || getTone(this.notes.get(i)) == -1) {
                throw new IllegalArgumentException("This chord contains an invalid note");
            }
            int distance = (getTone(this.notes.get(i + 1)) - getTone(this.notes.get(i)) + 12) % 12;
            this.nameOfIntervals.add(getIntervalName(distance));
        }
    }

    //TODO gets chord name based of a json file
    @Override
    public String toString(){   
        return "";
    }



    //the following should be moved to a new class but honestly doesn't matter

    //the following is a method and a map to get the tone of each note
    private static int getTone(String note) {
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
    private static String getIntervalName(int i) {
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
