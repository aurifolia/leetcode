import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No347_前K个高频元素 {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] ints = solution347.topKFrequent(new int[]{5,3,1,1,1,3,5,73,1}, 3);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution347 {
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Set<Integer>> frequencyMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            frequencyMap.computeIfAbsent(value, key -> new HashSet<>()).add(entry.getKey());
        }
        List<Integer> frequencyList = new ArrayList<>();
        Map<Integer, List<Integer>> frequencyMap1 = new HashMap<>();
        frequencyMap.forEach((key, value) -> {
            for (int i = value.size() - 1; i >= 0; i--) {
                frequencyList.add(key);
            }
            frequencyMap1.put(key, new ArrayList<>(value));
        });
        int[] frequencies = frequencyList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(frequencies);
        Map<Integer, Integer> locMap = new HashMap<>();
        int[] result = new int[k];
        for (int i = frequencies.length - 1; i >= frequencies.length - k; i--) {
            int frequency = frequencies[i];
            locMap.put(frequency, Math.min(locMap.getOrDefault(frequency, -1) + 1, frequencyMap.get(frequency).size() - 1));
            result[frequencies.length - i - 1] = frequencyMap1.get(frequency).get(locMap.get(frequency));
        }
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        map.forEach((key, value) -> {
            if (priorityQueue.size() >= k) {
                if (value > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(value);
                    frequencyMap.computeIfAbsent(value, key1 -> new ArrayList<>()).add(key);
                }
            }
            else {
                priorityQueue.add(value);
                frequencyMap.computeIfAbsent(value, key1 -> new ArrayList<>()).add(key);
            }
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            List<Integer> integers = null;
            do {
                integers = frequencyMap.remove(priorityQueue.poll());
            } while (integers == null);
            for (int j = integers.size() - 1; j >= 0; j--) {
                if (i >= k) {
                    break;
                }
                result[i] = integers.get(j);
                i++;
            }
            i--;
        }
        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        map.entrySet().forEach(entry -> {
            if (priorityQueue.size() >= k) {
                if (entry.getValue() > priorityQueue.peek().getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(entry);
                }
            }
            else {
                priorityQueue.add(entry);
            }
        });
        int[] result = new int[k];
        int loc = 0;
        for (Map.Entry<Integer, Integer> entry : priorityQueue) {
            result[loc++] = entry.getKey();
        }
        return result;
    }
}