import java.util.*;
import java.util.Arrays;
import java.util.Stack;

public class RoomPuzzle {
    /*
     * Given a sequence of rooms each with keys, check if all the rooms can be
     * traversed
     */
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(3));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(0));
        List<List<Integer>> l = new ArrayList<>(List.of(l1, l2, l3, l4));
        System.out.println(visitRoomsWithKeys(l));

    }

    public static boolean visitRoomsWithKeys(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        while (!s.isEmpty()) {
            int room = s.pop();
            List<Integer> neighbours = rooms.get(room);
            for (int nbr : neighbours) {
                if (!seen[nbr]) {
                    seen[nbr] = true;
                    s.push(nbr);
                }
            }
        }
        for (boolean v : seen) {
            if (!v)
                return false;
        }
        return true;
    }
}
