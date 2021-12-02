import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Merge N input list to single output list.
// Note: where all the input list are in increasing order and output should be in increasing order.

// Input:
// List-1: [1, 4, 5, ....]
// List-2: [2, 6, ....]
// List-3: [2, 3, 15, ....]

// Output: [1,2,2,3,4,5,6,15, ...]

class Item {
    int position;
    int listNumber;
}

class JLLTest {
    public static void main(String[] args) {
        List[][] myList = new List[][] { { 1, 4, 5 }, { 2, 6 }, { 2, 3, 15 } };
        List<Integer> finalList = new ArrayList<>();
        PriorityQueue<Item> queue = new PriorityQueue<>((i, j) -> {
            myList[i.listNumber][i.position].compareTo(myList[j.listNumber][j.position]);
        });
        List<Integer> pointersList = new ArrayList<>();
        for (int i = 0; i < myList.length; i++) {
            List[] innerList = myList[i];
            queue.add(innerList[0]);
        }

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            finalList.add(myList[item.listNumber][position]);
            // check if position exists
            int position = item.position + 1;
            if (position < myList[item.listNumber].length) {
                Item item1 = new Item();
                item1.position = position;
                item1.listNumber = item.listNumber;
                queue.add(item1);
            }
        }

    }
}
