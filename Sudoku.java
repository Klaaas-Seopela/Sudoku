import java.util.*;

public class Sudoku {
	int[][] board = new int [9][9];
	ArrayList[][] workBoard = new ArrayList[9][9];
	
	public void initializeBoard(){
		int index = 0;
		int[] values = {0,0,0,2,6,0,7,0,1,
						6,8,0,0,7,0,0,9,0,
						1,9,0,0,0,4,5,0,0,
						8,2,0,1,0,0,0,4,0,
						0,0,4,6,0,2,9,0,0,
						0,5,0,0,0,3,0,2,8,
						0,0,9,3,0,0,0,7,4,
						0,4,0,0,5,0,0,3,6,
						7,0,3,0,1,8,0,0,0};
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = values[index];
				index++;
			}
		}		
	}
	
	public void printBoard(){
		System.out.println("Board:");
		for (int i=0;i<9;i++){
			for (int j=0; j<9; j++){
				System.out.print("["+board[i][j]+"]");
			}
			System.out.println("");
		}
	}
	
	public void initializeWorkBoard(){
		for (int i=0;i<9;i++){
			for (int j=0; j<9; j++){
				ArrayList cell = new ArrayList();
				for (int k=1; k<=9; k++){
					cell.add(k);
				}
				workBoard[i][j] = cell;
			}
		}
	}

	public void printWorkBoard(){
		System.out.println("Current Work Board:");
		for (int i=0;i<9;i++){
			for (int j=0; j<9; j++){
				System.out.print(""+workBoard[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public void removeByColumn(){
		for (int i=0;i<9;i++){ //row
			for (int j=0; j<9; j++){ //column
				ArrayList currCell = workBoard[i][j];
				for (int k=0; k<9; k++){ //go down column
					if (currCell.contains(board[k][j]) && i!=k){
						currCell.remove(new Integer(board[k][j]));
					}
					if (workBoard[k][j].size() == 1 && currCell.contains(workBoard[k][j].get(0))&& i!=k){
						currCell.remove(workBoard[k][j].get(0));
					}
				}
			}
		}
	}

	public void removeByRow(){
		for (int i=0;i<9;i++){ //row
			for (int j=0; j<9; j++){ //column
				ArrayList currCell = workBoard[i][j];
				for (int k=0; k<9; k++){ //go down row
					if (currCell.contains(board[i][k]) && j!=k){
						currCell.remove(new Integer(board[i][k]));
					}
					if (workBoard[i][k].size() == 1 && currCell.contains(workBoard[i][k].get(0))&& j!=k){
						currCell.remove(workBoard[i][k].get(0));
					}
				}
			}
		}
	}

	public void fillGivenValues(){
		for (int i=0;i<9;i++){
			for (int j=0; j<9; j++){
				ArrayList currCell = workBoard[i][j];
				if (board[i][j] != 0){
					currCell.clear();
					currCell.add(new Integer(board[i][j]));
				}
			}
		}
	}

	public static void main(String args[]){
		Sudoku s = new Sudoku();
		s.initializeBoard();
		s.printBoard();
		
		s.initializeWorkBoard();
		
		for (int i=0; i<10; i++){
			System.out.println("Run "+(i+1));
			s.removeByColumn();
			s.removeByRow();
			s.fillGivenValues();
			s.printWorkBoard();
		}
	}
}
