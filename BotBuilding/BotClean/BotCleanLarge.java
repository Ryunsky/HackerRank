import java.io.*;
import java.util.*;

public class BotCleanLarge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int botX=scan.nextInt();
        int botY=scan.nextInt();
        int height = scan.nextInt();
        int width = scan.nextInt();
        String grid[] = new String[height];
        for (int i=0; i<height;i++){
            grid[i] = scan.next();
        }
        int princeX=0;
        int princeY=0;
        double minDist=height+width+1;
        for(int i = 0;i<height;i++){
            for(int j =0; j<width;j++){
                if(grid[i].charAt(j) == 'd'){
                    double dist = Math.pow((botX-i),2) + Math.pow((botY-j),2); 
                    if(dist < minDist){
                    princeX=i;
                    princeY=j;
                    minDist = dist;
                    }  
                    }
                }
            }
            if(botX-princeX < 0 ){
                System.out.println("DOWN");
                botX++;
            } else if(botX-princeX > 0){
                System.out.println("UP");
                botX--;
            } else if(botY-princeY < 0) {
                System.out.println("RIGHT");
                botY++;
            } else if (botY-princeY > 0){
                System.out.println("LEFT");
                botY--;
            } else {
                System.out.println("CLEAN");
            }
    }
}
