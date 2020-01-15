import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class to demonstrate Coin change DP algorithm
 */
public class EditDistance {
    // read 2 strings from standard input.
    // compute and print the edit distance between them and output an optimal
    // alignment and associated penalties.
    public static void main(String[] args) throws FileNotFoundException {
	File inf = new File(args[0]);
        Scanner in = new Scanner(inf);
        String a = in.next();
        String b = in.next();
        Match m = new Match();
        Path p = m.match(a, b);
        p.print(a, b);
    }
    
}
