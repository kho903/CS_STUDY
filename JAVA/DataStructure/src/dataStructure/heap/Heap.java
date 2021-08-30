package dataStructure.heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }
    public boolean move_up(Integer insertedIdx) {
        if (insertedIdx <= 1)
            return false;
        Integer parentIdx = insertedIdx / 2;
        if (this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx))
            return true;
        else
            return false;
    }

    public boolean insert(Integer data) {
        Integer insertedIdx, parentIdx;
        if (heapArray == null) {
            heapArray = new ArrayList<Integer>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        this.heapArray.add(data);
        insertedIdx = this.heapArray.size() - 1;

        while (this.move_up(insertedIdx)) {
            parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }
}
