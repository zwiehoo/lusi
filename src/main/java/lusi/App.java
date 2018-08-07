package lusi;

import java.io.IOException;
import java.time.Instant;

public class App {
    public static void main(String[] args) throws IOException {
        checkArgs(args);

        final Lusi lusi = new Lusi(args[0]).init();

        System.out.println(Instant.now().toString() + "\t" + args[0]);
        lusi.printSegmentInfo();
        lusi.printDiagnostics();
        lusi.printFiles();
    }

    private static void checkArgs(final String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\n$ sh lusi.sh <path to your index directory>");
            System.exit(1);
        }
    }
}
