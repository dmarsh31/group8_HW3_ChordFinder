// Group Members: Dustin M., Riley S., Khu Y.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChordFinder{

    public Set<String> getChordName(String ... notes){
        Set<String> returnSet = new HashSet<>();
        validateInput(notes); //validates inputted notes
        Chord.getAllPotentialChord("chord_rules_method1 (1).json"); // this is the file that is read for all chord names
        List<Chord> allChords = PermuteChord.getAllPermutations(notes); //gets all chord permutations
        for (Chord chord : allChords) {
            if(chord.toString() != null) returnSet.add(chord.toString());//if a chord in not in the JSON file it is not added to the return list
        }
        return returnSet;
    }


    //checks input for number is 3-7 and checks for duplicate notes and that all notes are valid
    private void validateInput(String ... notes){
        //cases where there are too few or many arguments
        if (notes.length > 7 || notes.length < 3) {
            throw new IllegalArgumentException("This chord contains to many or few notes");
        }
        //case for invalid notes
        for(int i = 0; i < notes.length; i++){
            if(ChordMaps.getTone(notes[i]) == -1) throw new IllegalArgumentException("This chord contains an invalid note");
        }
        //case for duplicate notes
        Set<String> tempSet = new HashSet<>();
        for (String note : notes) {
            tempSet.add(note);
        }
    }

}
