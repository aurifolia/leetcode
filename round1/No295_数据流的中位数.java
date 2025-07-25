package round1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 round1.MedianFinder 类:
 *
 * round1.MedianFinder() 初始化 round1.MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No295_数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
    }
}

class MedianFinder1 {
    private List<Integer> list;

    public MedianFinder1() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        if ((list.size() & 0x1) == 1) {
            return findTopK(0, list.size() - 1, list.size() >> 1);
        }
        else {
            return (findTopK(0, list.size() - 1, list.size() >> 1) + findTopK(0, list.size() - 1, (list.size() >> 1) - 1)) / 2.0;
        }
    }

    private int findTopK(int left, int right, int k) {
        if (left == right) {
            return list.get(left);
        }
        int leftCopy = left;
        int rightCopy = right;
        int pivot = list.get(left);
        while (left < right) {
            while (left < right && list.get(right) >= pivot) {
                right--;
            }
            while (left < right && list.get(left) <= pivot) {
                left++;
            }
            swap(left, right);
        }
        swap(leftCopy, left);
        if (left == k) {
            return list.get(left);
        } else if (left < k) {
            return findTopK(left + 1, rightCopy, k);
        } else {
            return findTopK(leftCopy, left - 1, k);
        }
    }

    private void swap(int left, int right) {
        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}


class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num <= minHeap.peek()) {
            minHeap.offer(num);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
        else {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}