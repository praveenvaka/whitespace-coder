import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 7/3/14
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    public static void main(String[] args) throws IOException {
        WhiteSpaceCoder whiteSpaceCoder = new WhiteSpaceCoder();
        String str = "Hello World!";
        for (int i = 0; i < str.length(); i++) {
            whiteSpaceCoder.pushAndPrint(str.charAt(i));
        }
        whiteSpaceCoder.writeToFile("hello.ws");
    }
}
