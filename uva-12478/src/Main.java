
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Arrays.sort;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static {
        logger.setLevel(Level.OFF);
    }
    private static String[] names = {
            "RAKIBUL",
            "ANINDYA",
            "MOSHIUR",
            "SHIPLU",
            "KABIR",
            "SUNNY",
            "OBAIDA",
            "WASI"
    };
    private static String[] grid = {
            "OBIDAIBKR",
            "RKAULHISP",
            "SADIYANNO",
            "HEISAWHIA",
            "IRAKIBULS",
            "MFBINTRNO",
            "UTOYZIFAH",
            "LEBSYNUNE",
            "EMOTIONAL"
    };
    private static List<String> gridList = new ArrayList<>();
    private static Map<String, Integer> namesMap;

    public static void main(String[] args) {
        initNamesMap();
        initGridList();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String sortedName = sortString(names[i]);
            logger.log(Level.INFO, "name = " + name);
            for (String line : gridList) {
                List<String> slices = getSlices(line, name.length());
                for (String slice : slices) {
                    if (sortString(name).equals(sortString(slice))) {
                        namesMap.put(name, namesMap.get(name) + 1);
                        logger.log(Level.INFO, "line = " + line);
                    }
                }
                if (namesMap.get(name) >= 2) {
                    System.out.println(name);
                    return;
                }

            }
        }
    }

    private static List<String> getSlices(String line, int sliceSize) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i <= line.length() - sliceSize; i++) {
            results.add(line.substring(i, i + sliceSize));
        }
        return results;
    }

    private static String sortString(String name) {
        char[] chars = name.toCharArray();
        sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    private static void initGridList() {
        for (int row = 0; row < grid.length; row++) {
            gridList.add(grid[row]);
        }
        for (int col = 0; col < grid[0].length(); col++) {
            String colString = getGridColumn(grid, col);
            gridList.add(colString);

        }
    }

    private static String getGridColumn(String[] grid, int col) {
        String result = "";
        for (int row = 0; row < grid.length; row++) {
            String letter = grid[row].substring(col, col+1);
            result += letter;
        }
        return result;
    }

    private static void initNamesMap() {
        namesMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String key = names[i];
            namesMap.put(key, 0);
        }
    }

}
