// Group Members: Dustin M., Riley S., Khu Y.

import java.util.*;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Chord {
    //the full and abbreviated chord names
    private String chordName;
    private String chordDisplayName;

    //list of all notes in the chord
    private ArrayList <String> notes;

    //this list is the name of all intervals in the chord
    //**e.g. the first string is the interval between the first note and the second note
    private ArrayList <String> nameOfIntervals;

    //a list of all potential chords names
    private static Set<Chord> potentialChords;

    //constructor -- fills the notes list, names of intervals list, gives the chord its chordName and chordDisplayName
    //THE getAllPotentialChord() MUST BE RUN BEFORE YOU CALL THIS CONSTRUCTOR!!!
    public Chord(String ... notes){

        this.notes = new ArrayList<String>(Arrays.asList(notes));
        this.nameOfIntervals = new ArrayList<String>();
        //gets the interval from note to note
        for (int i=0; i<this.notes.size() - 1; i++){
            int distance = (ChordMaps.getTone(this.notes.get(i + 1)) - ChordMaps.getTone(this.notes.get(i)) + 12) % 12;
            this.nameOfIntervals.add(ChordMaps.getIntervalName(distance));
        }
        //looks through all potential chords and if there is a match it sets the name felids otherwise they stay NULL
        this.chordDisplayName = null;
        this.chordName = null;
        for(Chord c : potentialChords){
            if(c.nameOfIntervals.equals(this.nameOfIntervals)){
                this.chordDisplayName = c.chordDisplayName;
                this.chordName = c.chordName;
            }
        }
    }

    //this constructor is just used for the potentialChords list
    private Chord(String chordName, String chordDisplayName, ArrayList<String> listOfIntervals){
        this.chordName = chordName;
        this.chordDisplayName = chordDisplayName;
        this.nameOfIntervals = listOfIntervals;
    }

    @Override
    public String toString(){
        if (this.chordName == null) return null;
        return this.notes.get(0) + " " + this.chordDisplayName;
    }

    //gets all potential chords 
    public static boolean getAllPotentialChord(String fileName){
        potentialChords = new HashSet<Chord>();
        String jsonString = "";

        //grabs JSON file
        try{
            jsonString = new String (Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.err.println("Problem reading file: " + e.getMessage());
            return false;
        }
        JSONObject root = new JSONObject(jsonString);
        JSONArray chords = root.getJSONArray("chords");

        //Gets all possible chord names and their intervals from JSON
        for(int i = 0 ; i < chords.length(); i++){
            JSONObject chord = chords.getJSONObject(i);
            String name = chord.getString("name");
            String displayName = chord.getString("display_name");
            JSONArray intervals = chord.getJSONArray("intervals");
            List<String> intervalsList = new ArrayList<String>();
            for (int j = 0; j < intervals.length(); j++) {
                intervalsList.add(intervals.getString(j));
            }
            potentialChords.add(new Chord(name, displayName, new ArrayList<>(intervalsList)));
        }
        return true;
    }
}
