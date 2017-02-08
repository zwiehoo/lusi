package lusi;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        checkArgs(args);

        final Lusi lusi = new Lusi(args[0]).init();

        lusi.printSegmentInfo();

        if (args.length > 1 && args[1].equals("diag")) {
            lusi.printDiagnostics();
        }
    }

    private static void checkArgs(final String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\n$ java -jar build/libs/segmentinfo-all-1.0-SNAPSHOT.jar <path to your index directory>");
            System.exit(1);
        }
    }
}
