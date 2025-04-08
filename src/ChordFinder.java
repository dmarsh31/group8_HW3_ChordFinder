// Group Members: Dustin M., Riley S., Khu Y.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChordFinder{

    //TODO --- final method
    public Set<String> getChordName(String ... notes){
        Set<String> returnSet = new HashSet<>();
        validateInput(notes); //validates inputted notes

        List<Chord> allChords = getAllPermutations(notes);
        

        

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


    //returns all possible chord permutations with given notes
    public List<Chord> getAllPermutations(String... notes){
        List<List<String>> result = new ArrayList<>();
        permute(Arrays.asList(notes), 0, result);

        List<Chord> returnList = new ArrayList<Chord>();
        for (List<String> list : result) {
            returnList.add(new Chord(list.toArray(new String[0])));
        }
        return returnList;
    }
    //recursive method to get all permutations
    private static void permute(List<String> arr, int index, List<List<String>> result) {
        if (index == arr.size() - 1) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, index, i);
            permute(arr, index + 1, result);
            Collections.swap(arr, index, i); // backtrack
        }
    }
}
