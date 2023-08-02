import java.util.*;
 
public class Game {
 
    private GameMap map;
    private Location startloc;
    private Location current;
    private String visited;
    private Scanner sc;
    private boolean available;
 
    public Game(GameMap g){
       this.map = g;
       this.sc = new Scanner(System.in);
    }
 
    public void playGame(){
        // Intialisation stuff
        //ArrayList<String> visited = new ArrayList<String>(); dont need this
        int x = 0;
        int y = 0;
        //boolean here[][] = new boolean[2][2]; //dont need this?


        int height = map.getHeight();
        int width = map.getWidth();
        GameMap m = new GameMap(height, width); //creating a new map of same size as map that is being passed in from runner class

        
        m.setLocation(x,y, map.getLocation(x,y)); // gets the symbol of x=0, y=0 as they havent changed yet
        current = m.getLocation(x,y); // Get current location
        // Maze Start
        current.togglePlayerHere(); // Toggle player here on
        System.out.println("Welcome to the maze!");
        System.out.println(m); //printing the first symbol


        // dont need startloc = map.getLocation(x,y);  // Get starting location *always 0,0
        // dont need this 2nd one startloc.togglePlayerHere(); // Toggle player here off
        //visited.add(startloc.mapRepresentation()); // Add location to visited
       // dont need this System.out.println(current.toString()); // Print starting available direction


        
 
       while(!current.isExit()){
            current.togglePlayerHere();
            System.out.print(current); //invokes the toString method for Location class, printing available directions of current locaion object
            System.out.print("Which way would you like to go? ");
            
            
            String input = sc.nextLine();
           
            while(!current.hasDirection(input)){
                System.out.print("You can't go that way! Try again. ");
                System.out.print("Which way would you like to go?");
                input = sc.nextLine();
            }
           
 
            if(input.equals("north")){
                x--;
                
            }
            else if(input.equals("south")){
                x++;
                
            }
            else if(input.equals("east")){
                y++;
                
            }
            else if(input.equals("west")){
                y--;
                
            }
            current = map.getLocation(x,y);
            m.setLocation(x,y,current);
            current.togglePlayerHere();
            System.out.print(m);
        }
        
        System.out.print("You made it to an exit. You have escaped!");
        
 
 
 
 
        
    }
}
