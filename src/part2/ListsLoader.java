package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Static Factory to load elements lists from the specified data source.
 */
public class ListsLoader {

    public static List<String> loadListA() {
        List<String> list = loadListByPath("src/resources/listA.csv");
        return list;
    }

    public static List<String> loadListB() {
        List<String> list = loadListByPath("src/resources/listB.csv");
        return list;
    }

    private static List<String> loadListByPath(String path) {
        List<String> result = Collections.emptyList();
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.parallel().map(String::toLowerCase)
                    //.distinct()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            //handle your exception here!
            e.printStackTrace();
        }
        return result;
    }
}
