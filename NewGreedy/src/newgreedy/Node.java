/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgreedy;

/**
 *
 * @author Alhassan
 */
public class Node {
    String startNode;
    String endNode;
    int cost;
    boolean visited;

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node(String startNode, String endNode, int cost, boolean visited) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.cost = cost;
        this.visited = visited;
    }
    public Node() {
        this.startNode = "";
        this.endNode = "";
        this.cost = 0;
        this.visited = false;
    }
}
