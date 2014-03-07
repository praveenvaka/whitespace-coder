import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class WhiteSpaceCoder {
    private StringBuilder wsCode;
    private static char space = 32;
    private static char tab = 9;
    private static char lf = 10;

    public WhiteSpaceCoder() {
        wsCode = new StringBuilder();
    }

    public void clear() {
        wsCode = new StringBuilder();
    }

    /***********************Stack Manipulation********************************/
    public void push(int x) {
        wsCode.append(space).append(space).append(getBinaryWS(x));
    }

    public void push(char c) {
        wsCode.append(space).append(space).append(getBinaryWS(c));
    }

    public void pop() {
        wsCode.append(space).append(lf).append(lf);
    }

    public void duplicate() {
        wsCode.append(space).append(lf).append(space);
    }

    public void swap() {
        wsCode.append(space).append(lf).append(tab);
    }
    /*************************************************************************/

    /*******************************Arithmetic********************************/
    public void add() {
        wsCode.append(tab).append(space).append(space).append(space);
    }

    public void subtract() {
        wsCode.append(tab).append(space).append(space).append(tab);
    }

    public void multiply() {
        wsCode.append(tab).append(space).append(space).append(lf);
    }

    public void modulo() {
        wsCode.append(tab).append(space).append(tab).append(tab);
    }

    public void divide() {
        wsCode.append(tab).append(space).append(tab).append(space);
    }
    /*************************************************************************/

    /*******************************Heap Access*******************************/
    public void addToHeap() {
        wsCode.append(tab).append(tab).append(space);
    }

    public void getFromHeap() {
        wsCode.append(tab).append(tab).append(tab);
    }

    public void addToHeap(int loc) {
        this.push(loc);
        this.swap();
        this.addToHeap();
    }

    public void getFromHeap(int loc) {
        this.push(loc);
        this.getFromHeap();
    }

    public void addToHeap(int loc, int n) {
        this.push(loc);
        this.push(n);
        this.addToHeap();
    }

    public void incrementHeapLoc(int loc) {
        this.getFromHeap(loc);
        this.push(1);
        this.add();
        this.addToHeap(loc);
    }
    /*************************************************************************/

    /*******************************Flow Control******************************/
    public void addLabel(int n) {
        wsCode.append(lf).append(space).append(space).append(getBinaryWS(n));
    }

    public void callSubRoutine(int n) {
        wsCode.append(lf).append(space).append(tab).append(getBinaryWS(n));
    }

    public void if0goto(int n) {
        wsCode.append(lf).append(tab).append(space).append(getBinaryWS(n));
    }

    public void ifIsNegativeGoTo(int n) {
        wsCode.append(lf).append(tab).append(tab).append(getBinaryWS(n));
    }

    public void GoTo(int n) {
        wsCode.append(lf).append(space).append(lf).append(getBinaryWS(n));
    }

    public void endSubRoutine() {
        wsCode.append(lf).append(tab).append(lf);
    }

    public void end() {
        wsCode.append(lf).append(lf).append(lf);
    }
    /*************************************************************************/

    /************************************I/0**********************************/
    public void printAsInt() {
        wsCode.append(tab).append(lf).append(space).append(tab);
    }

    public void printAsChar() {
        wsCode.append(tab).append(lf).append(space).append(space);
    }

    public void readChar() {
        wsCode.append(tab).append(lf).append(tab).append(space);
    }

    public void readInt() {
        wsCode.append(tab).append(lf).append(tab).append(tab);
    }
    /*************************************************************************/

    public void pushAndPrint(int n) {
        this.push(n);
        this.printAsInt();
    }

    public void pushAndPrint(char c) {
        this.push(c);
        this.printAsChar();
    }

    public void duplicateAndPrintAsInt() {
        this.duplicate();
        this.printAsInt();
    }

    public void duplicateAndPrintAsChar() {
        this.duplicate();
        this.printAsChar();
    }

    public static String getBinaryWS(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n >= 0) {
            stringBuilder.append(space);
        } else if(n < 0) {
            stringBuilder.append(tab);
            n = n * -1;
        }

        Stack<Integer> binaryRep = new Stack<Integer>();
        while(n != 0) {
            binaryRep.push(n%2);
            n /= 2;
        }

        while(!binaryRep.empty()) {
            stringBuilder.append(binaryRep.pop() == 1?tab:space);
        }

        stringBuilder.append(lf);
        return stringBuilder.toString();
    }

    public void writeToFile(String file) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
        out.write(wsCode.toString());
        out.close();
    }

    @Override
    public String toString() {
        return wsCode.toString();
    }
}