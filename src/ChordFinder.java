// Group Members: Dustin M., Riley S., Khu Y.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChordFinder{

    //TODO --- final method
    public Set<String> getChordName(String ... notes){
        Set<String> returnSet = new HashSet<>();
        validateInput(notes); //validates inputted notes

        List<Chord> allChords = PermuteChord.getAllPermutations(notes);
        

        return returnSet;
    }


    //checks input for number is 3-7 and checks for duplicate notes
    private void validateInput(String ... notes){
        //cases where there are too few or many arguments
        if (notes.length > 7 || notes.length < 3) {
            throw new IllegalArgumentException("This chord contains to many or few notes");
        }
        //case for duplicate notes
        Set<String> tempSet = new HashSet<>();
        for (String note : notes) {
            tempSet.add(note);
        }
        if (tempSet.size() != notes.length) throw new IllegalArgumentException("This chord contains duplicate notes");
    }

}
