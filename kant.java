public class kant{
	public static void main(String [] args){
		String letters[] = {"A", "B", "C", "D", "E", "F", "G"};
		int Kant[][] = new int [7][7];
		for(int i = 0; i < Kant.length; i++){
			for(int j = 0; j < Kant.length; j++){
				Kant[i][j] = 0;
			}
		}
		//A-B
		Kant[0][1] = 5;
		//B-A
		Kant[1][0] = 5;
		//B-C
		Kant[1][2] = 9;
		//C-B
		Kant[2][1] = 9;
		//C-D
		Kant[2][3] = 1;
		//D-C
		Kant[3][2] = 1;
		//D-A
		Kant[3][0] = 3;
		//A-D
		Kant[0][3] = 3;
		//D-E
		Kant[3][4] = 6;
		//E-D
		Kant[4][3] = 6;
		//E-F
		Kant[4][5] = 2;
		//F-E
		Kant[5][4] = 2;
		//F-G
		Kant[5][6] = 7;
		//G-F
		Kant[6][5] = 7;
		//G-C
		Kant[6][2] = 8;
		//C-G
		Kant[2][6] = 8;
		printArray(Kant, letters);
		boolean running = true;
		int value = 0;
		int counter = 0;
		int pointTouched = 0;
		int x = 2; // Valg av bokstav å starte på (Current C)
		while(running){
			int temp = Integer.MAX_VALUE;
			for(int i = 0; i < Kant.length; i++){
				if(Kant[x][i] > 0){
					if(Kant[x][i] < temp){
						temp = Kant[x][i];
						counter += i;
					}
				}
			}
			for(int k = 0; k < Kant.length; k++){
				if(Kant[x][k] == temp){
					if(counter%(k+1) == 0){
						value += Kant[x][k];
						System.out.println(letters[x] + " -> " + letters[k] + "(" + value + ")");
						Kant[x][k] = 0;
						Kant[k][x] = 0;
						x = k;
						pointTouched++;
						break;
					}
				}
			}
			if(pointTouched == Kant.length){
				running = false;
			}
		}
		printArray(Kant, letters);
	}//Main end
	public static void printArray(int[][]edge, String[]l){
		System.out.print(" ");
		for(int k = 0; k < l.length; k++){
			System.out.print("|" + l[k] + "|");
		}
		System.out.println("");
		for(int i = 0; i < edge.length; i++){
			System.out.print("" + l[i]);
			for(int j = 0; j < edge.length; j++){
				System.out.print("|" + edge[i][j] + "|");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}//Class end
/*
  |A|B|C|D|E|F|G|
|A|0|0|0|0|0|0|0|
|B|0|0|0|0|0|0|0|
|C|0|0|0|0|0|0|0|
|D|0|0|0|0|0|0|0|
|E|0|0|0|0|0|0|0|
|F|0|0|0|0|0|0|0|
|G|0|0|0|0|0|0|0|
*/