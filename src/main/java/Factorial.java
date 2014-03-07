import java.io.IOException;

// Reads a single non-negative integer from stdin writes its factorial to stdout

public class Factorial {
    static int LOOP_START = 1;
    static int LOOP_EXIT = 2;
    static int INPUT_LOC = 100;
    static int OUTPUT_LOC = 101;
    public static void main(String[] args) throws IOException {
        WhiteSpaceCoder whiteSpaceCoder = new WhiteSpaceCoder();

        whiteSpaceCoder.push(INPUT_LOC);
        whiteSpaceCoder.readInt();

        whiteSpaceCoder.push(1);
        whiteSpaceCoder.addToHeap(OUTPUT_LOC);

        whiteSpaceCoder.addLabel(LOOP_START);
        whiteSpaceCoder.getFromHeap(INPUT_LOC);
        whiteSpaceCoder.if0goto(LOOP_EXIT);
        whiteSpaceCoder.getFromHeap(INPUT_LOC);
        whiteSpaceCoder.getFromHeap(OUTPUT_LOC);
        whiteSpaceCoder.multiply();
        whiteSpaceCoder.addToHeap(OUTPUT_LOC);
        whiteSpaceCoder.getFromHeap(INPUT_LOC);
        whiteSpaceCoder.push(1);
        whiteSpaceCoder.subtract();
        whiteSpaceCoder.addToHeap(INPUT_LOC);
        whiteSpaceCoder.GoTo(LOOP_START);

        whiteSpaceCoder.addLabel(LOOP_EXIT);

        whiteSpaceCoder.getFromHeap(OUTPUT_LOC);
        whiteSpaceCoder.printAsInt();

        whiteSpaceCoder.end();

        whiteSpaceCoder.writeToFile("factorial.ws");
    }
}
