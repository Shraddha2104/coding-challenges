package sk.loffay.codeeval.easy;

import java.io.File;

/**
 * @author Pavol Loffay
 */
public class FileSize {

    public static void main(String[] args) {
        File file = new File(args[0]);
        System.out.println(file.length());
    }
}
