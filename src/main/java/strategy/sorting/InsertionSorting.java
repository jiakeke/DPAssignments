package strategy.sorting;

public class InsertionSorting implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i]; // 取出当前元素
            int j = i - 1;

            // 向前查找合适的位置插入 key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // 后移元素
                j--;
            }
            array[j + 1] = key; // 插入到正确位置
        }
    }
}

