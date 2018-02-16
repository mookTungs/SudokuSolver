import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class SudokuSolver{
	static int size = 3;
	static int boxSize = 9;
	static int totalSize = 81;
	static int row = 0;
	static int column = 0;
	static int[][] sudoku = new int[boxSize][boxSize];
	
	public void printSudoku(int[][] result){
		for(int i=0;i<boxSize;i++){
			for(int j=0;j<boxSize;j++){
				System.out.print(" "+result[i][j]);
				if((j+1)%size == 0 && (j+1) != boxSize){
					System.out.print(" ");
				}
			}
			System.out.println("");
			if((i+1)%size == 0 && (i+1) != boxSize){
				System.out.println("");
			}
		}
		System.out.println("");
	}
	
	public void getSudoku(String fileName){
		File file = new File(fileName);
		if(!file.isFile()){
			System.out.println("Invalid file");
			System.exit(0);
		}
		try{
			Scanner scanner = new Scanner(file);
			int count = 0;
			for(int i=0;i<boxSize;i++){
				for(int j=0;j<boxSize;j++){
					if(scanner.hasNextInt()){
						sudoku[i][j] = scanner.nextInt();
						count++;
					}
				}
			}
			if(count < totalSize){
				System.out.println("Invalid sudoku");
				System.exit(0);
			}
		}catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
	}
	
	public boolean checkHor(int[][] result,int hor, int ver, int num){
		for(int j = 0; j < boxSize; j++){
			if(result[hor][j] == num){
				return false;
			}	
		}
		return true;
	}
	
	public boolean checkVer(int[][] result,int hor, int ver, int num){
		for(int i = 0; i < boxSize; i++){
			if(result[i][ver] == num){
				return false;
			}	
		}
		return true;
	}
	
	public boolean checkSquare(int[][] result,int hor, int ver, int num){
		/*'''''''''''
			1|2|3
			4|5|6
			7|8|9
		'''''''''''''*/
		
		//square 1 (0,0)
		int x = 0;
		int y = 0;
		//System.out.println("\nsquare 1\n");
		if(hor < 3){
			if(ver > 2 && ver < 6){
				//square 2 (0,3)
				//System.out.println("\nsquare 2\n");
				y = 3;
			}
			if(ver > 5){
				//square 3 (0,6)
				//System.out.println("\nsquare 3\n");
				y = 6;
			}
		}
	
		if(hor > 2 && hor < 6){
			//square 4 (3,0)
			//System.out.println("\nsquare 4\n");
			x = 3;
			if(ver > 2 && ver < 6){
				//square 5 (3,3)
				//System.out.println("\nsquare 5\n");
				y = 3;
			}
			if(ver > 5){
				//square 6 (3,6)
				//System.out.println("\nsquare 6\n");
				y = 6;
			}
		}
		
		if(hor > 5){
			//square 7 (6,0)
			//System.out.println("\nsquare 7\n");
			x = 6;
			if(ver > 2 && ver < 6){
				//square 8 (6,3){
				//System.out.println("\nsquare 1\n");
				y = 3;
			}
			if(ver > 5){
				//System.out.println("\nsquare 1\n");
				//square 9 (6,6)
				y = 6;
			}
		}
		
		for(int i = x; i <= (x+2); i++){
			for(int j = y; j <= (y+2); j++){
				if(result[i][j] == num){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean unassigned(){
		int count = 0;
		for(int i = 0; i < boxSize; i++){
			for(int j = 0; j < boxSize; j++){
				if(sudoku[i][j] == 0){
					row = i;
					column = j;
					return true;
				}
			}
		}
		return false;
	}
	

	public boolean solveSudoku(int[][]result){
		if(!unassigned()){
			printSudoku(result);
			return true;
		}
		int oldRow = row;
		int oldColumn = column;
		for(int num = 1; num <=9; num++){
			//System.out.println("row: " + oldRow + " column: " + oldColumn + " num: " + num);
			if(checkHor(result,oldRow,oldColumn,num) && checkVer(result,oldRow,oldColumn,num) && checkSquare(result,oldRow,oldColumn,num)){
				result[oldRow][oldColumn] = num;
				//printSudoku(result);
				if(solveSudoku(result)){
					return true;
				}
				result[oldRow][oldColumn] = 0;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("usage: \"java SudokuSolver filename.txt\"");
			return;
		}
		SudokuSolver solver = new SudokuSolver();
		solver.getSudoku(args[0]);
		solver.unassigned();
		if(!solver.solveSudoku(sudoku)){
			System.out.println("fail");			
		}
		
	}
	
}