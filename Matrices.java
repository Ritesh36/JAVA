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

    public static int no_OF_Seven(int matrix[][]){

        int count = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] == 7){
                    count++;
                }
            }
        }
        return count;
    }

    public static int sum_Of_secondRow(int matrix[][]){

        int sum = 0;

        for(int i=0; i<matrix[0].length; i++){
            sum += matrix[1][i];
        }

        return sum;
    }

    public static void transpose(int matrix[][]){
        for( int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for( int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
               System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int matrix[][] = {{4, 7, 8},
                          {8, 8, 7},
                          };
        // int key = 33;
        
        // spiralMatrix(matrix);
        // System.out.println(digonalSum(matrix));
        // staircaseSearchMatrix(matrix, key);
        // System.out.println(no_OF_Seven(matrix));
        // System.out.println(sum_Of_secondRow(matrix));
        transpose(matrix);
    }
}