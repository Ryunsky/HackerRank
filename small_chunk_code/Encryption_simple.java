/*

An English text needs to be encrypted using the following encryption scheme. 
First, the spaces are removed from the text. Let L be the length of this text. 
Then, characters are written into a grid, whose rows and columns have the following constraints:

Math.floor(L) <= rows <= columns <= Math.ceil(l)
For example, the sentence if man was meant to stay on the ground god would have given us roots after removing spaces is  characters long, so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots
Ensure that rows * columns >= L
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rows * columns.
The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:

imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

You will be given a message in English with no spaces between the words. The maximum message length can be characters. Print the encoded message.


*/


import java.io.*;
import java.util.*;

public class Encryption_simple {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String message = scan.next();
        int length = message.length();
        int floor = (int)Math.floor(Math.sqrt((double)length));
        int ceil = (int)Math.ceil(Math.sqrt(length));
        int row = floor;
        int col =  ceil;
        String out ="";
        for (int i =1;i<=col;i++){
            for(int j=1;j<=length;j++){
                if(j%col==i){
                    out += message.charAt(j-1);
                }
                if(i==col && j%col ==0){
                    out += message.charAt(j-1);
                }
            }
            out+= " ";
        }
        System.out.println(out);

    }
}
