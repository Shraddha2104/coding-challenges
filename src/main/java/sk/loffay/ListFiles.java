package sk.loffay;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class ListFiles {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }

        String pattern = args[0];
        String workingDirectory = pattern.startsWith("/") ? "/"  : Paths.get("").toAbsolutePath().toString();

        List<String> files = traversal(pattern, workingDirectory);

        System.out.println(files);
    }

    public static List<String> traversal(final String pattern, final String directory) {

        if (pattern == null) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        String currentChunk = firstChunk(pattern);
        String nextPattern = nextPattern(pattern);

        if (!currentChunk.equals("*") && (new File(directory + "/" + currentChunk)).exists()) {
            if (nextPattern == null) {
                nextPattern = "*";
            }
            List<String> traversal = traversal(nextPattern, directory + "/" + currentChunk);
            result.addAll(traversal);
            return result;
        }
        // chunk is *
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            result.add(folder.getName());
            return result;
        }

        for (File file: listOfFiles) {
            if (nextPattern == null) {
                result.add(file.getName());
            } else if (file.isDirectory() && (nextPattern.equals("*") || file.getName().equals(nextPattern))) {
                result.addAll(traversal(nextPattern, directory + "/" + file.getName()));
            }
        }

        return result;
    }

    public static String firstChunk(String pattern) {
        String nextChunk = pattern.indexOf("/") < 0 ? pattern : pattern.substring(0, pattern.indexOf("/"));
        nextChunk = nextChunk != null ? nextChunk : pattern;

        return nextChunk;
    }

    public static String nextPattern(String pattern) {
        if (pattern.indexOf("/") < 0) {
            return null;
        }
        return pattern.substring(pattern.indexOf("/") + 1, pattern.length());
    }
}
