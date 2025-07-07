package Algorithm4.chapter1.fundamentals;

public class ResizableArray {
    private int[] arr;
    private int size;

    public ResizableArray() {
        arr = new int[1];
        size = 0;
    }

    public void add(int val) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size] = val;
        size++;
    }

    private void resize(int capacity) {
        int[] newArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        return arr[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }

        for (int i = index; i < size - 1; i++)  {
            arr[i] = arr[i + 1];
        }
        size--;
        if (size > 0 && size == arr.length / 4) {
            resize (arr.length / 2);
        }
    }

}
