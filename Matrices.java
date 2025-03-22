public class Matrices {

    public static void spiralMatrix(int matrix[][]){
        int startRow = 0;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            //start
            for(int j=0; j<=endCol; j++){
                System.out.print(matrix[startRow][j]+ " ");
            }

            //right
            for(int i=startRow+1; i<=endRow; i++){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][endCol]+ " ");
            }

            //bottom
            for(int j=endRow-1; j>=startCol; j--){
                System.out.print(matrix[endRow][j]+ " ");
            }

            //left
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+ " ");
            }

            startRow++;
            endRow --;
            startCol++;
            endRow--;
        }
        System.out.println();
    }

    public static int digonalSum(int matrix[][]){
        int sum = 0;  //O(n^2)

        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix.length; j++){
        //         if(i == j){
        //             sum += matrix[i][j];
        //         } else if(i + j == matrix.length - 1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        // return sum;

        for(int i=0; i<matrix.length; i++){  //O(n)

            sum += matrix[i][i];

            if(i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - 1 - i];
        }

        return sum;
        
    }

    public static boolean staircaseSearchMatrix(int matrix[][], int key){
        int row = 0, col = matrix.length-1;

        while(row <= matrix.length && col >= 0){
            if(matrix[row][col] == key){
                System.out.println("Key found at (" + row + "," + col + ")");
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else {
                row ++;
            }
        }

        System.out.println("Key not found");
        return false;
    }
    public static void main(String args[]){
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        int key = 33;
        
        // spiralMatrix(matrix);
        // System.out.println(digonalSum(matrix));
        staircaseSearchMatrix(matrix, key);
    }
}