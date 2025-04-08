import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuteChord {
    
    //returns all possible chord permutations with given notes
    public static List<Chord> getAllPermutations(String... notes){
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
