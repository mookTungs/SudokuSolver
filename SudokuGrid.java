import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory; 
import javax.swing.JOptionPane;
import java.awt.Color;

public class SudokuGrid extends JFrame implements ActionListener{
	/*--------------------------------------*
		| a1 a2 a3 | b1 b2 b3 | c1 c2 c3 |
		| a4 a5 a6 | b4 b5 b6 | c4 c5 c6 |
		| a7 a8 a9 | b7 b8 b9 | c7 c8 c9 |
		----------------------------------
		| d1 d2 d3 | e1 e2 e3 | f1 f2 f3 | 
		| d4 d5 d6 | e4 e5 e6 | f4 f5 f6 |
		| d7 d8 d9 | e7 e8 e9 | f7 f8 f9 |
		----------------------------------
		| g1 g2 g3 | h1 h2 h3 | i1 i2 i3 |
		| g4 g5 g6 | h4 h5 h6 | i4 i5 i6 |
		| g7 g8 g9 | h7 h8 h9 | i7 i8 i9 |
	----------------------------------------*/
	int[][] sudoku;
	
	JPanel panel = (JPanel) getContentPane();
	JButton solveButton = new JButton("Solve");
	JButton clearButton = new JButton("Clear");
	JTextField[] a = new JTextField[9];
	JTextField[] b = new JTextField[9];
	JTextField[] c = new JTextField[9];
	JTextField[] d = new JTextField[9];
	JTextField[] e = new JTextField[9];
	JTextField[] f = new JTextField[9];
	JTextField[] g = new JTextField[9];
	JTextField[] h = new JTextField[9];
	JTextField[] i = new JTextField[9];
		
	public SudokuGrid(){
		initGrid();
	}
	
	private void initGrid(){
		createGrid();
		setTitle("Sudoku Solver");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void createGrid(){
		Font font = new Font("SansSerif", Font.BOLD, 20); 
		
		JPanel window = new JPanel();
		window.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();

		JPanel grid = new JPanel();
		grid.setBorder(BorderFactory.createLineBorder(Color.black,3));
		grid.setLayout(new GridLayout(3,3));
		
		JPanel boxA = new JPanel();
		JPanel boxB = new JPanel();
		JPanel boxC = new JPanel();
		JPanel boxD = new JPanel();
		JPanel boxE = new JPanel();
		JPanel boxF = new JPanel();
		JPanel boxG = new JPanel();
		JPanel boxH = new JPanel();
		JPanel boxI = new JPanel();
		
		boxA.setLayout(new GridLayout(3,3));
		boxB.setLayout(new GridLayout(3,3));
		boxC.setLayout(new GridLayout(3,3));
		boxD.setLayout(new GridLayout(3,3));
		boxE.setLayout(new GridLayout(3,3));
		boxF.setLayout(new GridLayout(3,3));
		boxG.setLayout(new GridLayout(3,3));
		boxH.setLayout(new GridLayout(3,3));
		boxI.setLayout(new GridLayout(3,3));
		
		boxA.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxB.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxC.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxD.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxE.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxF.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxG.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxH.setBorder(BorderFactory.createLineBorder(Color.black,3));
		boxI.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		for(int j = 0; j < 9 ; j++){
			a[j] = new JTextField();
			b[j] = new JTextField();
			c[j] = new JTextField();
			d[j] = new JTextField();
			e[j] = new JTextField();
			f[j] = new JTextField();
			g[j] = new JTextField();
			h[j] = new JTextField();
			i[j] = new JTextField();
			
			a[j].setHorizontalAlignment(JTextField.CENTER);		
			b[j].setHorizontalAlignment(JTextField.CENTER);
			c[j].setHorizontalAlignment(JTextField.CENTER);
			d[j].setHorizontalAlignment(JTextField.CENTER);
			e[j].setHorizontalAlignment(JTextField.CENTER);
			f[j].setHorizontalAlignment(JTextField.CENTER);
			g[j].setHorizontalAlignment(JTextField.CENTER);
			h[j].setHorizontalAlignment(JTextField.CENTER);
			i[j].setHorizontalAlignment(JTextField.CENTER);
			
			a[j].setFont(font);
			b[j].setFont(font);
			c[j].setFont(font);
			d[j].setFont(font);
			e[j].setFont(font);
			f[j].setFont(font);
			g[j].setFont(font);
			h[j].setFont(font);
			i[j].setFont(font);
			
			boxA.add(a[j]);
			boxB.add(b[j]);
			boxC.add(c[j]);
			boxD.add(d[j]);
			boxE.add(e[j]);
			boxF.add(f[j]);
			boxG.add(g[j]);
			boxH.add(h[j]);
			boxI.add(i[j]);
		}
		
		solveButton.addActionListener(this);
		clearButton.addActionListener(this);
		buttonPanel.add(solveButton);
		buttonPanel.add(clearButton);
		
		grid.add(boxA);
		grid.add(boxB);
		grid.add(boxC);
		grid.add(boxD);
		grid.add(boxE);
		grid.add(boxF);
		grid.add(boxG);
		grid.add(boxH);
		grid.add(boxI);
		
		window.add(grid, BorderLayout.CENTER);
		window.add(buttonPanel, BorderLayout.SOUTH);
		panel.add(window);
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
	}
	
	public void clearGrid(){
		for(int j = 0; j < 9; j++){
			a[j].setText("");
			b[j].setText("");
			c[j].setText("");
			d[j].setText("");
			e[j].setText("");
			f[j].setText("");
			g[j].setText("");
			h[j].setText("");
			i[j].setText("");
		}
	}
	
	public void setSudoku(){
		sudoku = new int[9][9];
		int index = 0;
		//box a
		for(int j = 0; j < 3; j++){
			for(int k = 0; k < 3; k++){
				String s = a[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box b
		index = 0;
		for(int j = 0; j < 3; j++){
			for(int k = 3; k < 6; k++){
				String s = b[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box c
		index = 0;
		for(int j = 0; j < 3; j++){
			for(int k = 6; k < 9; k++){
				String s = c[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box d
		index = 0;
		for(int j = 3; j < 6; j++){
			for(int k = 0; k < 3; k++){
				String s = d[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box e
		index = 0;
		for(int j = 3; j < 6; j++){
			for(int k = 3; k < 6; k++){
				String s = e[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box f
		index = 0;
		for(int j = 3; j < 6; j++){
			for(int k = 6; k < 9; k++){
				String s = f[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box g
		index = 0;
		for(int j = 6; j < 9; j++){
			for(int k = 0; k < 3; k++){
				String s = g[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box h
		index = 0;
		for(int j = 6; j < 9; j++){
			for(int k = 3; k < 6; k++){
				String s = h[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
		//box i
		index = 0;
		for(int j = 6; j < 9; j++){
			for(int k = 6; k < 9; k++){
				String s = i[index].getText();
				if(s.equals("")){
					s = "0";
				}
				sudoku[j][k] = Integer.parseInt(s);
				index++;
			}
		}
	}
	
	public void printResult(){
		int index = 0;
		for(int j = 0; j < 3; j++){
			for(int k = 0; k < 3; k++){
				a[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 0; j < 3; j++){
			for(int k = 3; k < 6; k++){
				b[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 0; j < 3; j++){
			for(int k = 6; k < 9; k++){
				c[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 3; j < 6; j++){
			for(int k = 0; k < 3; k++){
				d[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 3; j < 6; j++){
			for(int k = 3; k < 6; k++){
				e[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 3; j < 6; j++){
			for(int k = 6; k < 9; k++){
				f[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 6; j < 9; j++){
			for(int k = 0; k < 3; k++){
				g[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 6; j < 9; j++){
			for(int k = 3; k < 6; k++){
				h[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
		index = 0;
		for(int j = 6; j < 9; j++){
			for(int k = 6; k < 9; k++){
				i[index].setText(Integer.toString(sudoku[j][k]));
				index++;
			}
		}
	}
	
	public void actionPerformed(ActionEvent evt){
		Object obj = evt.getSource();
		if(obj == clearButton){
			clearGrid();
		}
		if(obj == solveButton){
			try{
				setSudoku();
				SudokuSolver s = new SudokuSolver(sudoku);
				if(!s.isNumberValid(s.sudoku)){
					JOptionPane.showMessageDialog(null, "Please enter a number bewteen 1 to 9");
				}else if(!s.isSudokuValid(s.sudoku)){
					JOptionPane.showMessageDialog(null, "Invalid sudoku!");
				}else{
					if(!s.solveSudoku(s.sudoku)){
						JOptionPane.showMessageDialog(null,"No solution");	
					}else{
						sudoku = s.sudoku;
						printResult();
					}
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Please enter a number bewteen 1 to 9");
			}
		}
	}
	
	public static void main(String[] args){
		SudokuGrid g = new SudokuGrid();
	}
	
}