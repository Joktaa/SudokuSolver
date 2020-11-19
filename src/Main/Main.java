package Main;

public class Main {

	static int[][] grille = {
			{0,8,4,3,6,0,2,0,0},
			{7,0,3,0,0,0,6,0,0},
			{0,2,0,9,4,0,0,1,3},
			{0,0,6,0,3,0,0,4,0},
			{0,1,0,0,8,0,0,3,0},
			{0,5,0,0,9,0,1,0,0},
			{5,4,0,0,1,6,0,8,0},
			{0,0,2,0,0,0,5,0,1},
			{0,0,1,0,5,3,4,7,0}
		};
	
	
	public static void main(String[] args) {
		while(checkNotFinish(grille)) {
			grille = parcourirGrille(grille);
			
		}
	}
	
	
	
	
	
	static int[][] parcourirGrille(int[][] grille) {
		int[] lsOk = {};
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(grille[i][j] == 0) {
					lsOk = clearArr(lsOk);
					for(int k=1; k<10; k++) {
						if(checkVertical(grille,i,j,k) && checkHorizontal(grille,i,j,k) && checkCarre(grille,i,j,k)) {
							lsOk = addToArr(lsOk, k);
						}
					}
					debugPossibilites(grille, i, j, lsOk);
					if(lsOk.length == 1) {
						grille = replaceGrille(grille, i, j, lsOk[0]);
						afficherGrille(grille);
					}
				}
			}
		}
		return grille;
	}
	
	
	static void debugPossibilites(int[][] grille, int x, int y, int[] liste) {
		System.out.print("La case " + x + ";" + y + " a " + liste.length + " possibilités :");
		for(int a : liste) {
			System.out.print(" " + a);
		}
		System.out.print("\n");
	}
	
	
	
	
	static boolean checkVertical(int[][] grille, int x, int y, int z) {
		for(int i=0; i<9; i++) {
			if(i != x) {
				if(grille[i][y] == z) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	static boolean checkHorizontal(int[][] grille, int x, int y, int z) {
		for(int i=0; i<9; i++) {
			if(i != y) {
				if(grille[x][i] == z) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	static boolean checkCarre(int[][] grille, int x, int y, int z) {
		int init_i = 0;
		int init_j = 0;
		
		if(x == 0 || x == 1 || x == 2) {
			init_i = 0;
		}
		else if(x == 3 || x == 4 || x == 5) {
			init_i = 3;
		}
		else if(x == 6 || x == 7 || x == 8) {
			init_i = 6;
		}
		
		if(y == 0 || y == 1 || y == 2) {
			init_j = 0;
		}
		else if(y == 3 || y == 4 || y == 5) {
			init_j = 3;
		}
		else if(y == 6 || y == 7 || y == 8) {
			init_j = 6;
		}
		
		
		for(int i=init_i; i<init_i+3; i++) {
			for(int j=init_j; j<init_j+3; j++) {
				if(i != x || j != y) {
					if(grille[i][j] == z) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	
	
	static boolean checkNotFinish(int[][] grille) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(grille[i][j] == 0) {
					return true;
			}
		}
	}
		
		return false;
	}
	
	
	static int[][] replaceGrille(int[][] grille, int x, int y, int z){
		int[][] newGrille = new int[9][9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i == x && j == y) {
					newGrille[i][j] = z;
				} else {
					newGrille[i][j] = grille[i][j];
				}
			}
		}
		
		return newGrille;
	}
	
	
	
	
	static void afficherGrille(int[][] grille) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(grille[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}
	
	static int[] addToArr(int[] arr, int x) 
    {
		int n = arr.length;
		int[] newarr = new int[n + 1];

		for (int i = 0; i < n; i++) 
			newarr[i] = arr[i]; 

		newarr[n] = x; 

		return newarr;
    }
	
	static int[] clearArr(int arr[]) {
		int[] newArr = {};
		return newArr;
	}
}
