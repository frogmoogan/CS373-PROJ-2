import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class eng_p2 {
    public static void main(String[] args){

        String directions = "";
        String direct = "";
        int numGates = 1;
        String input = "";
        String marbleStart = "";
        int numMarbles = 0;

        //to make more intuitive, we will start at index 1 for gate 1
        String[] gate = new String[7];
        ArrayList<String> path = new ArrayList<>();
        //if we use a gate, we will append to arraylist
        //at the end of each final stage, we iterate through arraylist to determine whose configs need to be updated
        ArrayList<Integer> usedGates = new ArrayList<>();
        String gatedirect = "";
        String currpath = "";
        String stage = "";
        String finalstage = "";

        boolean lastMarble = false;

        //storing user input in string vars
       directions = args[0];
       input = args[1];

       //testing input working properly
       //System.out.println("directions " + directions + " input " + input );
        
       //initialize direction of all gates based on user input
       while(!directions.isEmpty()){
            direct = directions.substring(0,1);
            directions = directions.substring(1);

            gate[numGates] = direct;
            numGates++;
       }
       
       //testing gatedirection configs
       /* 
       System.out.print("gateconfig: ");
       for (String g: gate){
        System.out.print(g);
       }
       */
        

       while (!input.isEmpty()){
        //reset curr path;
        currpath = "";

        //iterate numMarbles
        numMarbles++;
        if(input.length() > 1){
            marbleStart = input.substring(0,1);
            input = input.substring(1);
        }
        else{
            marbleStart = input;
            input = "";
            lastMarble = true;

        }
        //all if, else if, and else conditions to swap 

        //input of 0 goes down A
        if (marbleStart.equals(0)){
            stage = "A";

        }
        //input of 1 goes down B
        else{
            stage = "B";
        }


        if(stage.equals("C")){

        }
        else if(stage.equals("D")){

        }
        else if(stage.equals("E")){

        }
        else if (stage.equals("F")){

        }

        //you've reached the bottom accept/reject stages
        if(stage.equals("G") | stage.equals("H") | stage.equals("I") | stage.equals("J") | stage.equals("K")   ){
            if(lastMarble){
                finalstage = stage;
            }
            
            //store path taken
            path.add(currpath); 

            //update gate configs that were taken

        }

        //make sure string is split properly
        //System.out.println("marble starts at: " + marbleStart );

        
        
       }
       //to test that rounds = input.length
       //System.out.println("Total Marbles: " + numMarbles);

       //printing out paths for each marble + final stage marble ends up in
       for (String p: path){
        System.out.println(path + "->");
       }
       System.out.print(finalstage);

       


    }

}