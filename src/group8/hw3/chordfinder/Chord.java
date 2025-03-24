package group8.hw3.chordfinder;

// Group Members: Dustin M., Riley S., Khu Y.

import java.util.HashMap;
import java.util.Map;

public class Chord {

    String rootNote;
    String thirdNote;
    String fifthNote;
    String chordQuality;
    
    //constructor
    public Chord(String rootNote, String thirdNote, String fifthNote){
        this.rootNote = rootNote;
        this.thirdNote = thirdNote;
        this.fifthNote = fifthNote;
    }

    //returns the name of chord e.g. E maj
    @Override
    public String toString(){   
        return this.rootNote + " " + this.chordQuality;
    }

    //checks if the chord is a real chord
    //if the chord is valid it sets the chordQuality feild
    public boolean isValidChord(){
        if (getTone(this.rootNote) == -1 || getTone(this.thirdNote) == -1 || getTone(this.fifthNote) == -1 ){
            throw new IllegalArgumentException("Invalid Input"); 
        }
        //gets distance in semi-tones for the 3 notes
        int distanceFromRootToThird = (getTone(this.thirdNote) - getTone(this.rootNote) + 12) % 12;
        int distanceFromThirdToFifth = (getTone(this.fifthNote) - getTone(this.thirdNote) + 12) % 12;
        
        //all cases where a real chord exists
        //sets the chordQuality feild
    if (distanceFromRootToThird == 4 && distanceFromThirdToFifth == 3) {
        this.chordQuality = "maj";
        return true;
    } else if (distanceFromRootToThird == 3 && distanceFromThirdToFifth == 4) {
        this.chordQuality = "min";
        return true;
    } else if (distanceFromRootToThird == 3 && distanceFromThirdToFifth == 3) {
        this.chordQuality = "dim";
        return true;
    } else if (distanceFromRootToThird == 4 && distanceFromThirdToFifth == 4) {
        this.chordQuality = "aug";
        return true;
    }
    return false;
    }



    
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


}
