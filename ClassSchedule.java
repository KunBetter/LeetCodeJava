import java.util.*;

/**
 * 【课程表】
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class ClassSchedule {

    // 深度优先搜索
    // 广度优先搜索
    // 图
    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 统计每个顶点的入度数
        // 将所有入度为0的顶点入队列
        // 将与"node"关联的节点的入度减1；
        // 若减1之后，该节点的入度为0；则将该节点添加到队列中。

        // 计算课程的入度
        int[] inDegree = new int[numCourses];
        // 构建邻接表
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            inDegree[prerequisites[i][0]]++;
            if (!adj.containsKey(prerequisites[i][1])) {
                adj.put(prerequisites[i][1], new ArrayList<>());
            }
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 将入度为0的节点放入队列
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.addLast(i);
            }
        }

        while (!q.isEmpty()) {
            int first = q.pollFirst();
            if (adj.containsKey(first)) {
                List<Integer> l = adj.get(first);
                for (int node : l) {
                    inDegree[node]--;
                    if (inDegree[node] == 0) {
                        q.addLast(node);
                    }
                }
            }
        }

        // bfs过后，若存在节点的入度不为零，说明存在环
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ClassSchedule cs = new ClassSchedule();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        boolean flag = cs.canFinish(numCourses, prerequisites);
        System.out.println(flag);
    }
}
