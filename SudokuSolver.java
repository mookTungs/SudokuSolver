import java.util.Scanner;
import java.io.File;

public class SudokuSolver{
	static int size = 3;
	static int boxSize = 9;
	static int totalSize = 81;
	static int row = 0;
	static int column = 0;
	static int[][] sudoku = new int[boxSize][boxSize];
	
	public SudokuSolver(int[][] grid){
		sudoku = grid;
	}
	
	public boolean isNumberValid(int[][] grid){
		for(int i = 0; i < boxSize; i++){
			for(int j = 0; j < boxSize; j++){
				if(grid[i][j] < 0 || grid[i][j] > 9){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isSudokuValid(int[][] grid){
		for(int i = 0; i < boxSize; i++){
			for(int j = 0; j < boxSize; j++){
				if(grid[i][j] != 0){
					if(checkHor(grid,i,j,grid[i][j]) > 1 || checkVer(grid,i,j,grid[i][j]) > 1
						|| checkSquare(grid,i,j,grid[i][j]) > 1){
							return false;
					}
					
				}
			}
		}
		return true;
	}
	
	public int checkHor(int[][] result,int hor, int ver, int num){
		int count = 0;
		for(int j = 0; j < boxSize; j++){
			if(result[hor][j] == num){
				count++;
			}	
		}
		return count;
	}
	
	public int checkVer(int[][] result,int hor, int ver, int num){
		int count = 0;
		for(int i = 0; i < boxSize; i++){
			if(result[i][ver] == num){
				count++;
			}	
		}
		return count;
	}
	
	public int checkSquare(int[][] result,int hor, int ver, int num){
		/*'''''''''''
			1|2|3
			4|5|6
			7|8|9
		'''''''''''''*/
		int count = 0;
		//square 1 (0,0)
		int x = 0;
		int y = 0;
		if(hor < 3){
			if(ver > 2 && ver < 6){
				//square 2 (0,3)
				y = 3;
			}
			if(ver > 5){
				//square 3 (0,6)
				y = 6;
			}
		}
	
		if(hor > 2 && hor < 6){
			//square 4 (3,0)
			x = 3;
			if(ver > 2 && ver < 6){
				//square 5 (3,3)
				y = 3;
			}
			if(ver > 5){
				//square 6 (3,6)
				y = 6;
			}
		}
		
		if(hor > 5){
			//square 7 (6,0)
			x = 6;
			if(ver > 2 && ver < 6){
				//square 8 (6,3){
				y = 3;
			}
			if(ver > 5){
				//square 9 (6,6)
				y = 6;
			}
		}
		
		for(int i = x; i <= (x+2); i++){
			for(int j = y; j <= (y+2); j++){
				if(result[i][j] == num){
					count++;
				}
			}
		}
		
		return count;
	}
	
	public boolean unassigned(int[][] s){
		int count = 0;
		for(int i = 0; i < boxSize; i++){
			for(int j = 0; j < boxSize; j++){
				if(s[i][j] == 0){
					row = i;
					column = j;
					return true;
				}
			}
		}
		return false;
	}
	

	public boolean solveSudoku(int[][] result){
		if(!unassigned(result)){
			return true;
		}
		int oldRow = row;
		int oldColumn = column;
		for(int num = 1; num <=boxSize; num++){
			if(checkHor(result,oldRow,oldColumn,num) == 0 && checkVer(result,oldRow,oldColumn,num) == 0 
					&& checkSquare(result,oldRow,oldColumn,num) == 0){
				result[oldRow][oldColumn] = num;
				if(solveSudoku(result)){
					return true;
				}
				result[oldRow][oldColumn] = 0;
			}
		}
		return false;
	}
}