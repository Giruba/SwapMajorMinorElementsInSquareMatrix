import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Swap major and minor diagonal elements in a square matrix");
		System.out.println("---------------------------------------------------------");
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the dimension of the matrix");
			int dimension = scanner.nextInt();
			int[][] matrix = new int[dimension][dimension];
			for(int index = 0; index < dimension; index++) {
				for(int colIndex = 0; colIndex < dimension; colIndex++) {
					System.out.println("Enter the element");
					matrix[index][colIndex] = scanner.nextInt();
				}
			}
			System.out.println("Printing the original matrix");
			PrintMatrix(matrix);
			System.out.println("Printing the matrix with swapped major and minor diagonal elements---");
			PrintMatrixWithSwappedDiagonals(matrix);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
	
	public static void PrintMatrixWithSwappedDiagonals(int[][] matrix) {
		
		int[] mainDiagonalElements = new int[matrix.length];
		int[] minorDiagonalElements = new int[matrix.length];
		
		int primaryDiagonalIndex = 0;
		for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for(int colIndex = 0; colIndex < matrix.length; colIndex++) {
				if(rowIndex == colIndex) {
					mainDiagonalElements[primaryDiagonalIndex++] = matrix[rowIndex][colIndex];
				}
			}
		}
		
		int secondaryDiagonalIndex = 0;
		for(int rowIndex = 0, colIndex = matrix.length-1; rowIndex < matrix.length && colIndex >=0; rowIndex++, colIndex--) {
			minorDiagonalElements[secondaryDiagonalIndex++] = matrix[rowIndex][colIndex]; 
		}
		
		matrix = GetReplacedMatrix(matrix, mainDiagonalElements, minorDiagonalElements);
		
		PrintMatrix(matrix);
	}
	
	public static void PrintMatrix(int[][] matrix) {
		for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for(int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
				System.out.print(matrix[rowIndex][colIndex]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static int[][] GetReplacedMatrix(int[][] matrix, int[] mainDiagonalElements, int[] minorDiagonalElements){
		
		int secondaryDiagonalIndex = 0;
		for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for(int colIndex = 0; colIndex < matrix.length; colIndex++) {
				if(rowIndex == colIndex) {
					matrix[rowIndex][colIndex] = minorDiagonalElements[secondaryDiagonalIndex++];
				}
			}
		}
		
		int primaryDiagonalIndex = 0;
		for(int rowIndex = 0, colIndex = matrix.length-1; rowIndex < matrix.length && colIndex >=0; rowIndex++, colIndex--) {
			matrix[rowIndex][colIndex] = mainDiagonalElements[primaryDiagonalIndex++]; 
		}
		
		return matrix;
	}
}
