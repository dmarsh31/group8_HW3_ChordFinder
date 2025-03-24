package group8.hw3.chordfinder;

// Group Members: Dustin M., Riley S., Khu Y.

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        ChordFinder cf = new ChordFinder();
        Set<String> mySet;
        
        //Test-1 
        // notes : ["D”, “G”, “ B"]
        //expected output : [“G maj”]
        mySet = cf.getChordName("D", "G", "B");
        System.out.println(mySet);

        //Test-2 
        // notes : [“C”. “Eb”, “G”] 
        //expected output : [“C min”] 
        mySet = cf.getChordName("C", "Eb", "G");
        System.out.println(mySet);

        //Test-3 
        // notes : [“B”. “E#”, “G”] 
        //expected output : [“B aug”, “D# aug”, “G aug”]
        mySet = cf.getChordName("B", "D#", "G");
        System.out.println(mySet);
    }
}
