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

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_pooped_idx, right_child_popped_idx;

        if (this.heapArray.size() <= 1)
            return null;

        returned_data = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);
        popped_idx = 1;

        while (this.move_down(popped_idx)) {
            left_child_pooped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            // CASE 2 : 오른쪽 자식 노드만 없을 때
            if (right_child_popped_idx >= this.heapArray.size()) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_pooped_idx)) {
                    Collections.swap(this.heapArray, popped_idx, left_child_pooped_idx);
                    popped_idx = left_child_pooped_idx;
                }
            } else { // CASE 3 : 왼쪽 / 오른쪽 자식 노드가 모두 없을 때,
                if (this.heapArray.get(left_child_pooped_idx) > this.heapArray.get(right_child_popped_idx)) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_pooped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_pooped_idx);
                        popped_idx = left_child_pooped_idx;
                    }
                } else {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                        popped_idx = right_child_popped_idx;
                    }
                }
            }
        }
        return returned_data;
    }

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;
        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE 1 : 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
        if (left_child_popped_idx >= this.heapArray.size())
            return false;
        else if (right_child_popped_idx >= this.heapArray.size()) {
            // CASE 2 : 오른쪽 자식 노드만 없을 때
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx))
                return true;
            else
                return false;
        } else {
            // CASE 3 : 왼쪽 / 오른쪽 자식 노드가 모두 있을 때
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx))
                    return true;
                else
                    return false;
            } else {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx))
                    return true;
                else
                    return false;
            }
        }
    }
}
