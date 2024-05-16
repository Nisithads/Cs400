

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HAshTableTester  {

    public static boolean getTester() {

        HashtableMap map = new HashtableMap<>(6);
        map.put("Nisitha", 3);

        Object val = map.get("Nisitha");

        if ( (int)val != 3) {
            return false;
        }

        try {
            map.get(null);

            return false;
        } catch (Exception ex) {

        }
        return true;
    }

    public static boolean putTester() {

        HashtableMap map = new HashtableMap<>(8);

        map.put("kevin", 5);

        if (map.size() == 0) {
            return false;
        }
        if (map.size() != 1) {
            return false;
        }
        map.put("devin", 4);

        if (map.size() != 2) {
            return false;
        }
        map.put(null, 3);
        if (map.size() != 2) {
            return false;
        }

        map.put("devin", 3);
        if (map.size() != 2) {
            return false;
        }
        return true;
    }


    public static boolean containsTester() {
        HashtableMap map = new HashtableMap<>(8);
        map.put("nisi", 2);

        if (!map.containsKey("nisi")) {


            return false;
        }

        if (map.size() == 0) {
            return false;
        }

        return true;
    }


    public static boolean removeTester() {
        HashtableMap map = new HashtableMap<>(8);
        map.put("nisi", 2);

        Object remove = map.remove("nisi");

        if (!remove.equals(2)) {
            return false;
        }

        return true;
    }


    public static boolean clearTester() {
        HashtableMap map = new HashtableMap<>(8);
        map.put("nisi", 2);
        map.put("adam", 5);
        map.put("kevin", 7);
        map.clear();

        if (map.size() != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(containsTester());
        System.out.println(putTester());
        System.out.println(getTester());
        System.out.println(clearTester());
        System.out.println(removeTester());


    }
}
