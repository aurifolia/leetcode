import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No207_课程表 {
    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        boolean b = solution207.canFinish(2, new int[][]{{1, 0}});
        System.out.println(b);
    }
}

class Solution207 {
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[][] rela = new int[numCourses][numCourses];
        int[] rowOnes = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            for (int i = 1, length = prerequisite.length; i < length; i++) {
                rela[prerequisite[0]][prerequisite[i]] = 1;
                rowOnes[prerequisite[0]]++;
            }
        }
        Set<Integer> finished = new HashSet<>();
        canFinishCore(rela, finished, rowOnes);
        return finished.size() == numCourses;
    }

    private void canFinishCore(int[][] rela, Set<Integer> finished, int[] rowOnes) {
        int m = rela.length;
        for (int i = 0; i < m; i++) {
            if (finished.contains(i)) {
                continue;
            }
            if (rowOnes[i] == 0) {
                finished.add(i);
                for (int j = 0; j < m; j++) {
                    if (rela[j][i] == 1) {
                        rela[j][i] = 0;
                        rowOnes[j]--;
                        if (rowOnes[j] == 0) {
                            canFinishCore(rela, finished, rowOnes);
                        }
                    }
                }
            }
        }
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> mapIn = new HashMap<>(numCourses);
        Map<Integer, Set<Integer>> mapOut = new HashMap<>(numCourses);
        for (int[] pre : prerequisites) {
            for (int i = 1, length = pre.length; i < length; i++) {
                mapIn.computeIfAbsent(pre[0], key -> new HashSet<>()).add(pre[i]);
                mapOut.computeIfAbsent(pre[i], key -> new HashSet<>()).add(pre[0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!mapIn.containsKey(i) || mapIn.get(i).isEmpty()) {
                queue.offer(i);
            }
        }
        int finished = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                finished++;
                Integer poll = queue.poll();
                Optional.ofNullable(mapOut.remove(poll)).ifPresent(set -> {
                    set.forEach(item -> {
                        mapIn.get(item).remove(poll);
                        if (mapIn.get(item).isEmpty()) {
                            queue.offer(item);
                        }
                    });
                });
            }
        }
        return finished == numCourses;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        List<Set<Integer>> mapIn = new ArrayList<>(numCourses);
        List<Set<Integer>> mapOut = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            mapIn.add(new HashSet<>());
            mapOut.add(new HashSet<>());
        }
        for (int[] pre : prerequisites) {
            for (int i = 1, length = pre.length; i < length; i++) {
                mapIn.get(pre[0]).add(pre[i]);
                mapOut.get(pre[i]).add(pre[0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (mapIn.get(i).isEmpty()) {
                queue.offer(i);
            }
        }
        int finished = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                finished++;
                Integer poll = queue.poll();
                Set<Integer> set = mapOut.get(poll);
                set.forEach(item -> {
                    mapIn.get(item).remove(poll);
                    if (mapIn.get(item).isEmpty()) {
                        queue.offer(item);
                    }
                });
            }
        }
        return finished == numCourses;
    }
}
