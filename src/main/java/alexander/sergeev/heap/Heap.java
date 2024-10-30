package alexander.sergeev.heap;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {

    private Object[] array;
    private int size;
    private int maxSize;

    public Heap() {
        this.maxSize = 10;
        array = new Object[maxSize];
        size = 0;
    }

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        size = 0;
    }

    public boolean add(T value) {
        if (size == maxSize) increaseCapacity();
        array[size] = value;
        displaceUp(size++);
        return true;
    }

    public T pop() {
        return remove(0);
    }

    public T remove(int index) {
        if (index >= 0 && size > index) {
            T root = (T) array[index];
            array[index] = array[--size];
            array[size] = null;
            displaceDown(index);
            return root;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void displaceUp(int index) {
        int parentIndex = (index - 1) / 2;
        T bottom = (T) array[index];
        T parent = (T) array[parentIndex];
        while (index > 0 && parent.compareTo(bottom) < 0) {
            array[index] = array[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
            parent = (T) array[parentIndex];
        }
        array[index] = bottom;
    }

    private void displaceDown(int index) {
        int biggerChildIndex;
        T top = (T) array[index];
        while (index < size / 2) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            T leftChild = (T) array[leftChildIndex];
            T rightChild = (T) array[rightChildIndex];
            if (rightChildIndex < size && leftChild.compareTo(rightChild) < 0) {
                biggerChildIndex = rightChildIndex;
            } else {
                biggerChildIndex = leftChildIndex;
            }
            T biggerChild = (T) array[biggerChildIndex];
            if (top.compareTo(biggerChild) >= 0) {
                break;
            }
            array[index] = array[biggerChildIndex];
            index = biggerChildIndex;
        }
        array[index] = top;
    }

    private void increaseCapacity() {
        int newLength = array.length * 2;
        array = Arrays.copyOf(array, newLength);
        maxSize = newLength;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
