package part2;

import java.util.List;

/**
 * Testing the lists loading code;
 */
public class LoaderTester {

    public static void main(String... args) {
        List<String> listA = ListsLoader.loadListB();
        long count = listA.stream().count();
        System.out.println("count = " + count);
    }
}
