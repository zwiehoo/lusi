package lusi;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws IOException {
        checkArgs(args);

        final Lusi lusi = new Lusi(args[0]).init();

        System.out.println(Instant.now().toString() + "\t" + args[0]);

        final HashSet<String> argsSet = new HashSet<>(Arrays.asList(args));

        if (argsSet.contains("--dumpTerms")) {
            lusi.dumpTerms();
        } else {
            lusi.printSegmentInfo();
            lusi.printDiagnostics();
            lusi.printFiles();
        }
    }

    private static void checkArgs(final String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\n$ sh lusi.sh <path to your index directory> --dumpTerms");
            System.exit(1);
        }
    }
}
