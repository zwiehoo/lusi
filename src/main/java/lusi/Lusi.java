package lusi;

import org.apache.lucene.index.SegmentInfos;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

class Lusi {
    private static final long MEG = 1024 * 1024;
    private static final String SEGMENT_INFO_FORMAT = "name=%s\tsizeWithDocStores=%dM\tsizeWoDocStores=%dM\tdocCount=%d\tdelCount=%d";
    private final String indexPath;
    private SegmentInfos si;

    Lusi(final String indexPath) {
        this.indexPath = indexPath;
    }

    Lusi init() throws IOException {
        FSDirectory directory = FSDirectory.open(new File(indexPath));
        si = new SegmentInfos();
        si.read(directory);
        return this;
    }

    void printSegmentInfo() {
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
        si.iterator().forEachRemaining(segment -> {
            System.out.println(segment.name + "\t" + segment.getDiagnostics());
        });
    }
}
