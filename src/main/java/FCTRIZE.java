import java.io.IOException;

// Solves the problem http://www.codechef.com/CDGF2013/problems/FCTRIZE/.

public class FCTRIZE {
    static int GCD_ROUTINE_LABEL = 0;
    static int GCD_ROUTINE_EXIT_LABEL = 1;
    static int GCD_ROUTINE_START_LABEL = 2;
    static int EXIT_LABEL = 3;
    static int SOLVE_ROUTINE_LABEL = 4;
    static int SOLVE_EXIT_LABEL = 5;
    static int SOLVE_LOOP_LABEL = 6;
    static int DIVIDES_LABEL = 7;
    static int LOOP_INCR_LABEL = 8;
    static int GCD_ISZERO_LABEL = 9;
    static int PRINT_LOOP_LABEL = 10;
    static int INIT_LOOP_LABEL = 11;

    static int GCD_INPUT1_HEAP_LOC = 0;
    static int GCD_INPUT2_HEAP_LOC = 1;
    static int SOLVE_INPUT_HEAP_LOC = 2;
    static int SOLVE_OUTPUT_HEAP_LOC = 3;


    public static void main(String[] args) throws IOException {
        WhiteSpaceCoder whiteSpaceCoder = new WhiteSpaceCoder();

        whiteSpaceCoder.push(2);
        whiteSpaceCoder.GoTo(INIT_LOOP_LABEL);
        whiteSpaceCoder.addLabel(PRINT_LOOP_LABEL);
        whiteSpaceCoder.pushAndPrint(',');
        whiteSpaceCoder.addLabel(INIT_LOOP_LABEL);
        whiteSpaceCoder.duplicateAndPrintAsInt();
        whiteSpaceCoder.pushAndPrint(':');
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.addToHeap(SOLVE_INPUT_HEAP_LOC);
        whiteSpaceCoder.callSubRoutine(SOLVE_ROUTINE_LABEL);
        whiteSpaceCoder.getFromHeap(SOLVE_OUTPUT_HEAP_LOC);
        whiteSpaceCoder.push(2);
        whiteSpaceCoder.divide();
        whiteSpaceCoder.printAsInt();
        whiteSpaceCoder.push(1);
        whiteSpaceCoder.add();
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.push(1001);
        whiteSpaceCoder.subtract();

        whiteSpaceCoder.if0goto(EXIT_LABEL);
        whiteSpaceCoder.GoTo(PRINT_LOOP_LABEL);

        whiteSpaceCoder.addLabel(SOLVE_ROUTINE_LABEL);
        whiteSpaceCoder.addToHeap(SOLVE_OUTPUT_HEAP_LOC, 0);
        whiteSpaceCoder.push(1);
        whiteSpaceCoder.addLabel(SOLVE_LOOP_LABEL);
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.getFromHeap(SOLVE_INPUT_HEAP_LOC);
        whiteSpaceCoder.swap();
        whiteSpaceCoder.modulo();
        whiteSpaceCoder.if0goto(DIVIDES_LABEL);
        whiteSpaceCoder.GoTo(LOOP_INCR_LABEL);

        whiteSpaceCoder.addLabel(DIVIDES_LABEL);
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.addToHeap(GCD_INPUT1_HEAP_LOC);
        whiteSpaceCoder.getFromHeap(SOLVE_INPUT_HEAP_LOC);
        whiteSpaceCoder.swap();
        whiteSpaceCoder.divide();
        whiteSpaceCoder.addToHeap(GCD_INPUT2_HEAP_LOC);
        whiteSpaceCoder.callSubRoutine(GCD_ROUTINE_LABEL);
        whiteSpaceCoder.if0goto(GCD_ISZERO_LABEL);
        whiteSpaceCoder.GoTo(LOOP_INCR_LABEL);

        whiteSpaceCoder.addLabel(GCD_ISZERO_LABEL);
        whiteSpaceCoder.incrementHeapLoc(SOLVE_OUTPUT_HEAP_LOC);

        whiteSpaceCoder.addLabel(LOOP_INCR_LABEL);
        whiteSpaceCoder.push(1);
        whiteSpaceCoder.add();
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.getFromHeap(SOLVE_INPUT_HEAP_LOC);
        whiteSpaceCoder.swap();
        whiteSpaceCoder.subtract();
        whiteSpaceCoder.ifIsNegativeGoTo(SOLVE_EXIT_LABEL);
        whiteSpaceCoder.GoTo(SOLVE_LOOP_LABEL);
        whiteSpaceCoder.addLabel(SOLVE_EXIT_LABEL);
        whiteSpaceCoder.pop();
        whiteSpaceCoder.endSubRoutine();

        whiteSpaceCoder.addLabel(GCD_ROUTINE_LABEL);
        //If the gcd of the two input numbers is 1 writes 0 on top of stack
        whiteSpaceCoder.addLabel(GCD_ROUTINE_START_LABEL);
        whiteSpaceCoder.getFromHeap(GCD_INPUT1_HEAP_LOC);
        whiteSpaceCoder.getFromHeap(GCD_INPUT2_HEAP_LOC);
        whiteSpaceCoder.duplicate();
        whiteSpaceCoder.if0goto(GCD_ROUTINE_EXIT_LABEL);
        whiteSpaceCoder.modulo();
        whiteSpaceCoder.getFromHeap(GCD_INPUT2_HEAP_LOC);
        whiteSpaceCoder.addToHeap(GCD_INPUT1_HEAP_LOC);
        whiteSpaceCoder.addToHeap(GCD_INPUT2_HEAP_LOC);
        whiteSpaceCoder.GoTo(GCD_ROUTINE_START_LABEL);

        whiteSpaceCoder.addLabel(GCD_ROUTINE_EXIT_LABEL);
        whiteSpaceCoder.pop();
        whiteSpaceCoder.push(1);
        whiteSpaceCoder.subtract();
        whiteSpaceCoder.endSubRoutine();

        whiteSpaceCoder.addLabel(EXIT_LABEL);
        whiteSpaceCoder.end();

        whiteSpaceCoder.writeToFile("factorize.ws");
    }
}
