package sk.loffay;

import org.junit.Test;

import junit.framework.TestCase;
import sk.loffay.other.ListFiles;

/**
 * @author Pavol Loffay
 */
public class ListFilesTest extends TestCase {

    @Test
    public void testFileList() {
        ListFiles.main(new String[]{""});
        ListFiles.main(new String[]{"."});
        ListFiles.main(new String[]{"pom.xml"});
        ListFiles.main(new String[]{"*/*"});
    }

    @Test
    public void testOne() {
        ListFiles.main(new String[]{"pom.xml"});
    }
}
