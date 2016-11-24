import java.io.*;
import java.util.*;

public class BotCleanPartially {
	
	static BufferedReader reader;
	static BufferedWriter writer;
	static int maxDist = 25;
	static ArrayList<LOC> path;
	static HashSet<LOC> done;
	
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scan = new Scanner(System.in);
    	int botX = scan.nextInt();
    	int botY = scan.nextInt();
    	String[] grid = new String[5];
    	String[] state = new String[5];
    	for(int i = 0; i<5; i++){
    		grid[i] = scan.next();
    	}
    	scan.close();
    	File f = new File("state.txt");
    	if(f.exists() && !f.isDirectory()){
    		reader = new BufferedReader(new FileReader("state.txt"));
    		String line;
    		int index =0;
		    while((line = reader.readLine()) != null) {
		    	state[index] = line;
		    	index++;
		    }
			reader.close();
			for(int i=0; i<5;i++){
				char[] gridC = grid[i].toCharArray().clone();
				char[] stateC = state[i].toCharArray().clone();
				for(int j =0;j<5;j++){
					if(gridC[j] != stateC[j] && gridC[j] == 'o'){
						gridC[j] = stateC[j];
					}
				}
				grid[i] = String.valueOf(gridC);
			}
		writer = new BufferedWriter(new FileWriter("state.txt",false));
    	} else {
    		writer = new BufferedWriter(new FileWriter("state.txt",false));
    	}
		for(int i=0; i<5;i++){
				writer.write(grid[i]);
			writer.newLine();
		}
		writer.close();
		next_move(botX,botY,5,5,grid);
    }
    
	public enum Move {
		CLEAN, LEFT, RIGHT, UP, DOWN
	}
	
	public static class LOC {
		
		public int x;
		public int y;
		public LOC(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int distance(LOC next){
			return Math.abs(this.x-next.x) + Math.abs(this.y-next.y);
		}
		
		public boolean equals(LOC next){
			return this.x == next.x && this.y == next.y;
		}
	}
	
	
static void next_move(int botX, int botY, int height, int width, String[] grid){
		
		if(grid[botX].charAt(botY) == 'd'){
			System.out.println(Move.CLEAN);
			return;
		}
		final LOC current = new LOC(botX,botY);
		ArrayList<LOC> list = new ArrayList<LOC>();
		for (int i = 0;i<height; i++){
			for(int j=0; j<width;j++){
				if(grid[i].charAt(j) == 'd'||grid[i].charAt(j) == 'o') {
					list.add(new LOC(i,j));
				}
			}
		}
		
		Collections.sort(list, new Comparator<LOC>(){
			@Override
			public int compare(LOC a, LOC b){
			return current.distance(a) - current.distance(b);
			}
		});
		
		int size = list.size();

		//limit the number of dirty cell in the list
		while (size > 30) {
			list.remove(size-1);
			size--;
		}
		
		HashSet<LOC> set = new HashSet<LOC>();
		Stack<LOC> stack = new Stack<LOC>();
		set.addAll(list);
		stack.push(current); 
		

		
		calculateShortestPath(list, 0, 0, set, new HashSet<LOC>(), stack);
		
		LOC next = path.get(1);
		
		if(current.x - next.x < 0){
			System.out.println(Move.DOWN);
			current.x++;
		} else if (current.x - next.x > 0){
			System.out.println(Move.UP);
			current.x--;
		} else if (current.y - next.y < 0){
			System.out.println(Move.RIGHT);
			current.y++;
		} else if (current.y - next.y > 0){
			System.out.println(Move.LEFT);
		}
		
	}
	
	
	//recursively find the shortest path
	static void calculateShortestPath(ArrayList<LOC> list, int totalDist, int index, HashSet<LOC> set, HashSet<LOC> done, Stack<LOC> stack){
		if(totalDist > maxDist) {
			return;
		}
		if (index == list.size()){
			if(totalDist < maxDist) {
				maxDist = totalDist;
				path = new ArrayList<LOC>(stack);
			}
			return;
		}
		LOC current = stack.peek();
		HashSet<LOC> copy = new HashSet<LOC>(set);
		//to avoid concurrent modification in the same set
		for (LOC next : copy){
			
			if(!done.contains(next)){
				int dist_next = current.distance(next);
				set.remove(next);
				boolean pass = false;
				for(LOC other : set){
					int dist_other = current.distance(other);
					if(dist_next>dist_other){
						set.add(next);
						pass = true;
						break;
					}
				}
                if(pass){
                    continue;
                }
				stack.push(next);
				done.add(next);
				calculateShortestPath(list,totalDist + dist_next, index+1, set, done, stack);
				set.add(next);
				done.remove(next);
				stack.pop();
			}
		}
	}
}
