package gildedrose;

import org.approvaltests.reporters.GenericDiffReporter;

public class MeldReporter extends GenericDiffReporter {

    static final String DIFF_PROGRAM = "/usr/bin/meld";

    public MeldReporter() {
        super(DIFF_PROGRAM);
    }
}