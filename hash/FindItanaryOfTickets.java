package hash;

import java.util.HashMap;

public class FindItanaryOfTickets {

    public static String getStarting(HashMap<String, String> tickts) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickts.keySet()) {
            revMap.put(tickts.get(key), key);
        }
        for (String key : tickts.keySet()) {
            if (!revMap.containsKey(key))
                return key;
        }
        return "null";
    }

    public static void main(String[] args) {
        HashMap<String, String> tickts = new HashMap<>();
        tickts.put("Chennai", "Benglaur");
        tickts.put("Mombai", "Delli");
        tickts.put("Goa", "Chennai");
        tickts.put("Delli", "Goa");

        String starting = getStarting(tickts);

        System.out.print(starting);
        for (@SuppressWarnings("unused") String key : tickts.keySet()) {
            System.out.print("->" + tickts.get(starting));
            starting = tickts.get(starting);
        }
        System.out.println();
    }
}
