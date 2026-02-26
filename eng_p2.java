import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class eng_p2 {
    public static void main(String[] args){

        //exception handling for invalid num of gate directions
        if(((args[0].length())< 6)){
            throw new ArithmeticException("Invalid Number of Gate Directions - too short");
        }

        if(((args[0].length())> 6)){
            throw new ArithmeticException("Invalid Number of Gate Directions - too long");
        }
    

        String directions = "";
        String direct = "";
        int numGates = 1;
        String input = "";
        String marbleStart = "";
        int numMarbles = 0;

        //to make more intuitive, we will start at index 1 for gate 1
        String[] gate = new String[7];
        ArrayList<String> config = new ArrayList<>();
        //if we use a gate, we will append to arraylist
        //at the end of each final stage, we iterate through arraylist to determine whose configs need to be updated
        ArrayList<Integer> usedGates = new ArrayList<>();
        String gatedirect = "";
        String currconfig = "";
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
        //reset curr path string, usedGates arra
        usedGates.clear();
        currconfig = "";

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

        //System.out.print("Marble " + marbleStart);

        if(marbleStart.equals("0")){
            stage = "A";
        }
        else{
            stage = "B";
        }
        //input of 0 goes down A
        if (stage.equals("A")){
            //System.out.println("Gate 1 Taken");
            usedGates.add(1);

            if(gate[1].equals("L")){
                stage = "C";
            }
            else if(gate[1].equals("C")){
                stage = "D";
            }
            else{
                stage = "E";
            }

        }else{
            usedGates.add(2);
            // System.out.println("Gate 2 Taken");


            if(gate[2].equals("L")){
                stage = "D";
            }
            else if(gate[2].equals("C")){
                stage = "E";
            }
            else{
                stage = "F";
            }

        }



        if(stage.equals("C")){
            usedGates.add(3);
            // System.out.println("Gate 3 Taken");

            if(gate[3].equals("L")){
                stage = "G";
            }
            else{
                stage = "H";
            }
        }
        else if(stage.equals("D")){
            usedGates.add(4);
            // System.out.println("Gate 4 Taken");

            if(gate[4].equals("L")){
                stage = "H";
            }
            else{
                stage = "I";
            }
        }
        else if(stage.equals("E")){
    //       System.out.println("Gate 5 Taken");

            usedGates.add(5);
            if(gate[5].equals("L")){
                stage = "I";
            }
            else{
                stage = "J";
            }
        }
        else if (stage.equals("F")){
            usedGates.add(6);
            //  System.out.println("Gate 6 Taken");

            if(gate[6].equals("L")){
                stage = "J";
            }
            else{
                stage = "K";
            }
        }

        //you've reached the bottom accept/reject stages
        if(stage.equals("G") | stage.equals("H") | stage.equals("I") | stage.equals("J") | stage.equals("K")   ){
            
            //System.out.println("Done with Marble" + numMarbles + "\n");
            //create current configs
            for (int i = 1; i < 7; i++){
                currconfig += gate[i];
            }

            config.add(currconfig); 
            
            //update gate configs that were taken
            for (Integer i: usedGates){
               if(i.equals(1)){
                    if(gate[i].equals("L")){
                        gate[i] = "R";
                    }
                    else if(gate[i].equals("R")){
                        gate[i] = "C";
                    }
                    else{
                        gate[i] = "L";
                    }

               }
               else if(i.equals(2)){
                    if(gate[i].equals("L")){
                        gate[i] = "C";
                    }
                    else if(gate[i].equals("C")){
                        gate[i] = "R";
                    }
                    else{
                        gate[i] = "L";
                    }

               }
               //gates 3-6 follow same patterns
               else{
                    if(gate[i].equals("L")){
                        gate[i] = "R";
                    }
                    else if(gate[i].equals("R")){
                        gate[i] = "L";
                    }
               }

            }

            if(lastMarble){
                finalstage = stage;
            }

        }

        //make sure string is split properly
        //System.out.println("marble starts at: " + marbleStart );

        
        
       }
       //to test that rounds = input.length
       //System.out.println("Total Marbles: " + numMarbles);

       //printing out paths for each marble + final stage marble ends up in
       for (String c: config){
        System.out.print(c + "->");
       }
       input = args[0];
       System.out.print(input + " ");
       System.out.print(finalstage);

       


    }

}