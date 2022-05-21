import java.util.Objects;

public class Matrix {
    private static int [][] buffer;
    private int [][] matrix;
    private int m, n;
    private static int actualRow;
    public static void setUpMatrix(int m, int n) {
        if(n <= 0 || m <= 0){
            System.out.println("Error: size of matrix ");
        }
        buffer = new int [m][n];
        for(int i = 0; i < m; i++){
            buffer[i] = new int [n];
        }
        actualRow = 0;
    }

    public static void insertRow(int [] arr) {
        if(actualRow == buffer.length){
            System.out.println("Error: We can't add more row");
            return;
        }
        if(buffer[0].length != arr.length){
            System.out.println("Error: Bad len of row");
            return;
        }
        buffer[actualRow] = arr;
        actualRow++;
    }


    // Constructor for Matrix object
    private Matrix(){
        this.matrix = Matrix.buffer;
        m = buffer.length;
        n = buffer[0].length;
    }


    // Create new obj from static buffer matrix
    public static Matrix create() {
        if(actualRow != buffer.length){
            System.out.print("Error: not enough row to create new matrix");
        }
        Matrix buffer = new Matrix();
        Matrix.buffer = null;
        return buffer;
    }

    ///Utils method

    // Swap matrix to new one
    private void swapMatrix(Matrix matrix){
        this.matrix = matrix.matrix;
        m = matrix.m;
        n = matrix.n;
    }

    // Will count the digit of the number
    private int digit(int a){
        int i = 0;
        while (a != 0){
            a /= 10;
            i++;
        }
        return i;
    }


    // Get max digit of number in array to justify printed array
    private int maxInArr(){
        int max = matrix[0][0], min = max;
        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < this.n; j++){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                }
            }
        }
        return digit(max) < digit(min) || (digit(max) == digit(min) && min < 0)  ? digit(min) + 1: digit(max);
    }

    // Print array
    public void print() {
        if (isNotMatrix()){
            System.out.println("Error: matrix missing");
            return;
        }
        int max = maxInArr();
        for(int i = 0; i < m; i++){
            System.out.print("\n| ");
            for(int j = 0; j < n; j++){
                System.out.printf("%-"+ max +"d ", matrix[i][j]);
            }
            System.out.print("| ");
        }
        System.out.print("\n\n");
    }

    ///Calculator method

    // Add array to each other and assigns result to (this)
    public Matrix add(Matrix A) {
        if (checkMatrix(this, A)) return null;
        Matrix buf = Matrix.add(this, A);
        swapMatrix(Objects.requireNonNull(buf));
        return this;
    }

    // Add array to each other and return result
    public static Matrix add(Matrix A, Matrix B) {
        if (checkMatrix(A, B)) return null;
        for(int i = 0; i < A.m; i++){
            int [] buf = new int[A.n];
            for(int j = 0; j < A.n; j++){
                buf[j] = A.matrix[i][j] + B.matrix[i][j];
            }
            Matrix.insertRow(buf);
        }
        return Matrix.create();
    }

    // Subtract array to each other and assigns result to (this)
    public Matrix subtract(Matrix A) {
        if (checkMatrix(this, A)) return null;
        Matrix buf = Matrix.subtract(this, A);
        swapMatrix(Objects.requireNonNull(buf));
        return this;
    }

    // Subtract array to each other and return result
    public static Matrix subtract(Matrix A, Matrix B) {
        if (checkMatrix(A, B)) return null;
        for(int i = 0; i < A.m; i++){
            int [] buf = new int[A.n];
            for(int j = 0; j < A.n; j++){
                buf[j] = A.matrix[i][j] - B.matrix[i][j];
            }
            Matrix.insertRow(buf);
        }
        return Matrix.create();
    }

    // Return value of multiple row from matrix A and col from matrix B
    public static int multipleRowAndCol(Matrix A, Matrix B, int row, int col){
        int sum = 0;
        for(int i = 0; i < A.m; i++){
            sum += A.matrix[row][i] * B.matrix[i][col];
        }
        return sum;
    }

    // Multiple array to each other and return result
    public static Matrix multiple(Matrix A, Matrix B){
        if (checkMatrix(A, B)) return null;
        if(A.m != B.n){
            System.out.println("Error: can't multiple this matrix");
            return null;
        }
        for(int i = 0; i < A.m; i++){
            int [] buf = new int[A.n];
            for(int j = 0; j < A.n; j++){
                buf[j] = Matrix.multipleRowAndCol(A, B, i, j);
            }
            Matrix.insertRow(buf);
        }
        return Matrix.create();
    }

    // Multiple array to each other and assigns result to (this)
    public Matrix multiple(Matrix A){
        if (checkMatrix(this, A)) return null;
        Matrix buf = Matrix.multiple(this, A);
        swapMatrix(Objects.requireNonNull(buf));
        return buf;

    }

    ///Valid matrix method


    // Check if matrix is valid
    private boolean isNotMatrix(){
        if(matrix == null) return true;
        return matrix.length == 0;
    }

    // Check if we can add or subtract matrix
    private static boolean sizeCheck(Matrix A, Matrix B){
        return A.m == B.m && A.n == B.n;
    }

    // Check if matrix is valid to add, multiple and subtract
    private static boolean checkMatrix(Matrix A, Matrix B) {
        if(A.isNotMatrix() || B.isNotMatrix()){
            System.out.println("Error data input");
            return true;
        }
        if(!Matrix.sizeCheck(A, B)){
            System.out.print("");
            return true;
        }
        Matrix.setUpMatrix(A.m, A.n);
        return false;
    }
}
