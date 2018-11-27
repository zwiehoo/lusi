package lusi;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.SegmentInfos;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Lusi {
    private static final long MEG = 1024 * 1024;
    private static final String SEGMENT_INFO_FORMAT = "segment=%s\tsizeWithDocStores=%dM\tsizeWithoutDocStores=%dM\tdocCount=%d\tdelCount=%d";
    private final String indexPath;
    private SegmentInfos si;
    private FSDirectory directory;

    Lusi(final String indexPath) {
        this.indexPath = indexPath;
    }

    Lusi init() throws IOException {
        directory = FSDirectory.open(new File(indexPath));

        si = new SegmentInfos();
        si.read(directory);

        return this;
    }

    public void dumpTerms() throws IOException {
        final IndexReader reader = IndexReader.open(directory);
        final TermEnum terms = reader.terms();

        Map<String, Integer> fields = new HashMap<>();
        while (terms.next()) {
            final Term term = terms.term();
            fields.putIfAbsent(term.field(), 1);
            fields.computeIfPresent(term.field(), (key, value) -> value + 1);
        }

        System.out.println("Unique term count: " + fields.size());
        System.out.println("List of terms with number of unique values: \n");

        fields.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

    void printSegmentInfo() {
        System.out.println("\nSegment sizing:\n");
        si.iterator().forEachRemaining(segment -> {
            try {
                String info = String.format(
                        SEGMENT_INFO_FORMAT,
                        segment.name,
                        segment.sizeInBytes(true) / MEG,
                        segment.sizeInBytes(false) / MEG,
                        segment.docCount,
                        segment.getDelCount()
                );
                System.out.println(info);
            } catch (IOException ignored) {
            }
        });
    }

    void printDiagnostics() {
        System.out.println("\nDiagnostics:\n");
        si.iterator().forEachRemaining(segment -> System.out.println("segment=" + segment.name + "\t" + segment.getDiagnostics()));
    }

    void printFiles() {
        System.out.println("\nFiles:\n");
        si.iterator().forEachRemaining(segment -> {
            try {
                System.out.println("segment=" + segment.name + "\t" + segment.files());
            } catch (IOException e) {
            }
        });
    }
}
