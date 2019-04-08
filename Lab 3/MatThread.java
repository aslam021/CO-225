public class MatThread extends Thread {
    private int[][] a;
    private int[][] b;
    private int threadID, begin, end, i;

    public static int[][] c;
    private static int noOfThread;

    // this method will allocate the array size for the static variable c and
    // allocate the value for number of threads since they common for all threads
    public static void result(int rawSize, int colSize, int t) {
        c = new int[rawSize][colSize];
        noOfThread = t;
    }

    // cunstructor
    public MatThread(int[][] a, int[][] b, int m, int t) {
        this.a = a;
        this.b = b;
        this.threadID = m;
    }

    // multiply method from the skeleton code is implemented inside the run method
    public void run() {

        // start and end raws of current thread
        begin = (int) Math.floor((this.threadID) * ((double) this.a.length / noOfThread));
        end = (int) Math.floor((this.threadID + 1) * ((double) this.a.length / noOfThread));

        int s;

        try {
            for (i = begin; i < end; i++)
                for (int j = 0; j < b[threadID].length; j++) {
                    s = 0;
                    for (int k = 0; k < a[0].length; k++) {
                        s += a[i][k] * b[k][j];
                    }
                    c[i][j] = s;
                }
        } catch (NullPointerException e) {
            System.out.println("Null pointer Error, check the matrix size");
            System.exit(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bound Error, check the matrix size");
            System.exit(-1);
        }

    }
}