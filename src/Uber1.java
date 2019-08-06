import java.util.*;

public class Uber1 {
    boolean sudoku2(char[][] grid) {
        //check all the rows and Arrays

        for(int i=0;i< grid.length;i++){
            char[] rowArray = grid[i];
            if(checkForDuplicates(new String(rowArray))){
                return false;
            }
            for(int j=0; j<grid[i].length; j++){
                char[] colArray = getColumn(grid,j);

                if(checkForDuplicates(new String(colArray))){
                    return false;
                }
            }
        }


        char[][] smallerGrid = initializeArray(grid,0,3,0,3);
        return sudokuHelper(grid,smallerGrid,0,3,0,3);

    }

    boolean sudokuHelper(char[][] masterGrid , char[][] smallerGrid,
                         int startRow, int endRow, int startCol, int endCol){


        if( startCol >9 || endCol>9 || startRow >9 || endRow >9){
            return true;
        }
        if(checkForDuplicates(flatten2DArray(smallerGrid))){
            return false;
        }

        boolean result = false;
        //jump col
        smallerGrid = initializeArray(masterGrid,startRow,endRow,startCol+1,endCol+1);
        result = sudokuHelper(masterGrid,smallerGrid,startRow,endRow,startCol+1,endCol+1);

        //jump row
        smallerGrid =initializeArray(masterGrid,startRow+1,endRow+1,startCol,endCol);
        result =sudokuHelper(masterGrid,smallerGrid,startRow+1,endRow+1,startCol,endCol);

        return result;
    }

    private char[][] initializeArray(char[][] grid, int startRow , int endRow,
                                     int startCol , int endCol ){

        int smallRow =0, smallCol =0;
        char[][] smallerGrid = new char[3][3];
        for(int i=startRow ; i<endRow ; i++){
            for(int j=startCol; j<endCol ;j++){
                smallerGrid[smallRow][smallCol] = grid[i][j];
                smallCol++;
            }
            smallRow++;
        }
        return smallerGrid;
    }

    String flatten2DArray(char[][] matrix){
        // Create an empty list to collect the stream
        List<Character> list = new ArrayList<>();

        // Using forEach loop
        // convert the array into stream
        // and add the stream into list
        String someText ="";

        StringBuilder builder = new StringBuilder();
        for (char[] array : matrix) {
         builder.append(array);

        }

        // Convert the list into Stream and return it
        return builder.toString();
    }

    private boolean checkForDuplicates(String mat){
        mat.replaceAll("\\.","");
        char[] tempArray = mat.toCharArray();
        Arrays.sort(tempArray);

        for(int i=0 ;i < tempArray.length-1;i++){
            if(tempArray[i] == tempArray[i+1]){
                return false;
            }
        }

        return true;
    }

    public  char[] getColumn(char[][] array, int index){
        char[] column = new char[array[0].length]; // Here I assume a rectangular 2D array!
        for(int i=0; i<column.length; i++){
            column[i] = array[i][index];
        }
        return column;
    }
}
