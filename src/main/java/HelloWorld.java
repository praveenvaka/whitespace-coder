import java.io.IOException;

// A Simple hello world program

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        WhiteSpaceCoder whiteSpaceCoder = new WhiteSpaceCoder();
        String str = "Hello World!";
        for (int i = 0; i < str.length(); i++) {
            whiteSpaceCoder.pushAndPrint(str.charAt(i));
        }
        whiteSpaceCoder.writeToFile("hello.ws");
        whiteSpaceCoder.end();
    }
}
