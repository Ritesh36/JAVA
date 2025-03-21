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
    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        
        spiralMatrix(matrix);
    }
}