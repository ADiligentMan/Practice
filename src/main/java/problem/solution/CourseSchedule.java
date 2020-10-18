package problem.solution;

import java.util.*;

/**
 * LeetCode 207
 *
 * @author wangpeng
 * @since 2020-09-10
 */
public class CourseSchedule {

    private List<Integer> topologicalOrderList = new LinkedList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] adjacentArr = getAdjacentArray(numCourses, prerequisites);
        // [num][0] = 1 means have been visited. [num][1] means have been visited in a recursive call.
        int [][] nodeMarkArr = new int[numCourses][2];

        try {
            for (int i = 0; i < nodeMarkArr.length; i++) {
                if (nodeMarkArr[i][0] == 0) {
                    visit(adjacentArr[i], adjacentArr, nodeMarkArr);
                }
            }
        } catch (NotDAGException e) {
            return false;
        }
        System.out.println(topologicalOrderList.toString());
        return true;
    }

    //  Graph depth-first search
    private void visit(Node node, Node[] adjacentArr, int[][] nodeMarkArr) throws NotDAGException {
        // A cycle was detected.
        if (nodeMarkArr[node.node][1] == 1) {
            throw new NotDAGException();
        }
        // No need to visit because It have been visited.
        if (nodeMarkArr[node.node][0] == 1) {
            return;
        }
        nodeMarkArr[node.node][1] = 1;

        Node adjacentNode = adjacentArr[node.node].next;
        while (adjacentNode != null) {
            visit(adjacentNode, adjacentArr, nodeMarkArr);
            adjacentNode = adjacentNode.next;
        }

        nodeMarkArr[node.node][0] = 1;
        nodeMarkArr[node.node][1] = 0;
        topologicalOrderList.add(0, node.node);
    }

    // Convert to graph adjacent list presentation, time complexity : O(E);
    private Node[] getAdjacentArray(int numCourses, int[][] prerequisites) {
        Node[] adjacentArray = new Node[numCourses];

        int length = prerequisites.length;
        for (int i = 0; i < length; i++) {
            int fromNode = prerequisites[i][1];
            int toNode = prerequisites[i][0];
            Node node = new Node();
            node.node = toNode;
            node.next = adjacentArray[fromNode];
            adjacentArray[fromNode] = node;
        }
        // init adjacentArray
        for (int i = 0; i < numCourses; i++) {
            Node node = new Node();
            node.node = i;
            node.next = adjacentArray[i];
            adjacentArray[i] = node;
        }
        return adjacentArray;
    }

    private class Node {
        int node;
        Node next;
    }

    // Not a directed acyclic graph exception.
    private class NotDAGException extends IllegalArgumentException {
    }

}