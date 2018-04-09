/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgreedy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Alhassan
 */
public class NewGreedy {

    void graphDesing() {

        ArrayList<Node> graph = new ArrayList<>();
        graph.add(new Node("A", "B", 4, false));
        graph.add(new Node("A", "C", 1, false));
//        graph.add(new Node("B", "A", 4, false));
        graph.add(new Node("B", "D", 3, false));
        graph.add(new Node("B", "E", 8, false));
        graph.add(new Node("C", "D", 2, false));
        graph.add(new Node("C", "F", 6, false));
//        graph.add(new Node("C", "A", 1, false));
//        graph.add(new Node("D", "B", 3, false));
//        graph.add(new Node("D", "C", 2, false));
        graph.add(new Node("D", "E", 4, false));
//        graph.add(new Node("E", "B", 8, false));
        graph.add(new Node("E", "G", 2, false));
        graph.add(new Node("F", "G", 8, false));
//        graph.add(new Node("E", "D", 4, false));
//        graph.add(new Node("G", "E", 2, false));
//        graph.add(new Node("G", "F", 8, false));

        HashMap<String, Integer> value = new HashMap<>();
        value.put("A", 8);
        value.put("B", 8);
        value.put("C", 6);
        value.put("D", 5);
        value.put("E", 1);
        value.put("F", 4);
        value.put("G", 0);

        ArrayList<Node> frontier = new ArrayList<>();
        ArrayList<Node> explored = new ArrayList<>();
        ArrayList<Node> temp = new ArrayList<>();
        ArrayList<Node> tempClear = new ArrayList<>();

        String start = "A";
        String end = "G";
        explored.add(new Node(start, "", 0, true));
        frontier.add(new Node(start, "", 0, true));
        boolean flag = true, finished = false;
        String newString = null;
        boolean wlag = true;
        boolean ifFlag = true;
        while (!graph.isEmpty() & flag == true) {
//            System.out.println("while loop");
            for (int i = 0; i < graph.size(); i++) {
//                System.out.println("for between while and if");
//                System.out.println("i: " + i);
                if (finished == false) {
                    if (ifFlag == true) {
                        if (start.equals(end)) {
//                            frontier.add(new Node(graph.get(i).startNode, graph.get(i).startNode, 0, true));
//                            explored.add(new Node(graph.get(i).startNode, graph.get(i).startNode, 0, true));
//                            System.out.println("done");
                            flag = false;
                            ifFlag = false;
                            finished = true;
                            break;

                        }
                    }
                    if (end.equals(graph.get(i).startNode)) {
//                        System.out.println("if last");
                        frontier.add(new Node(graph.get(i).startNode, "", 1, true));
                        explored.add(new Node(graph.get(i).startNode, "", 0, true));
                        flag = false;
                        end = start;
                        finished = true;
                        break;
                    }
//                    System.out.println("if herer new");
//                    System.out.println("start node: " + start
//                            + " graph.get(i).startNode: " + graph.get(i).startNode);
                    if (start.equals(graph.get(i).startNode)) {
//                        System.out.println("for after while loop i: " + i);
                        String startNode = graph.get(i).startNode;
//                        System.out.println("i: i: " + i);
//                        System.out.println("startNode: " + startNode);
                        temp.add(graph.get(i));
//                    frontier.add(new Node(graph.get(i).startNode,graph.get(i).endNode,graph.get(i).cost,true));
                        for (HashMap.Entry<String, Integer> loop : value.entrySet()) {
                            if (graph.get(i).endNode.equals(loop.getKey())) {
                                frontier.add(new Node(graph.get(i).startNode, graph.get(i).endNode, loop.getValue(), true));
                            }
                        }
//                        System.out.println("i: i: " + i);
//                        System.out.println("temp.add(___): " + graph.get(i).endNode);
                        for (int x = i + 1; x < graph.size(); x++) {
//                            System.out.println("for after for one :" + x);
                            if (startNode.equals(graph.get(x).startNode)) {
//                                System.out.println("if now ");
                                temp.add(graph.get(x));
                                for (HashMap.Entry<String, Integer> loop : value.entrySet()) {
                                    if (graph.get(x).endNode.equals(loop.getKey())) {
                                        frontier.add(new Node(graph.get(x).startNode, graph.get(x).endNode, loop.getValue(), true));
                                    }
                                }

                                wlag = false;
//                                System.out.println("temp in if now : " + graph.get(x).endNode);
                                newString = graph.get(x).startNode;
//                                System.out.println("newString: " + newString);
                            }
                        }
                    }
                    if (temp.size() > 0) {
                        for (int y = 0; y < temp.size(); y++) {
//                            System.out.println("for y: " + y);

                            for (HashMap.Entry<String, Integer> loop : value.entrySet()) {
//                                System.out.println("hashmap: " + loop);
//                                System.out.println("Temp: " + temp.get(y).startNode);
//                                System.out.println("loop.getKey(): " + loop.getKey());
                                if (temp.get(y).endNode.equals(loop.getKey())) {
//                                    System.out.println("if in hashmap: " + loop.getKey());
//                                    System.out.println("loop.getKey(): " + loop.getKey() + " " + newString + " : " + loop.getValue());
                                    frontier.add(new Node(loop.getKey(), newString, loop.getValue(), true));
                                    tempClear.add(new Node(temp.get(y).startNode, loop.getKey(), loop.getValue(), true));
                                }
                            }

                        }
                    }
                    if (temp.size() > 0) {
                        temp.clear();
                    }
                    if (tempClear.size() > 0) {
                        for (int o = 0; o < tempClear.size(); o++) {
                            for (int t = o + 1; t < tempClear.size(); t++) {
                                if (tempClear.get(o).cost > tempClear.get(t).cost) {
                                    int swapValue;
                                    String swapEndNode;
                                    swapEndNode = tempClear.get(t).endNode;
                                    swapValue = tempClear.get(t).cost;
                                    tempClear.get(t).endNode = tempClear.get(o).endNode;
                                    tempClear.get(t).cost = tempClear.get(o).cost;
                                    tempClear.get(o).endNode = swapEndNode;
                                    tempClear.get(o).cost = swapValue;
                                }

                            }
                        }
                    }
                    if (tempClear.size() > 0) {
                        explored.add(new Node(tempClear.get(0).startNode, tempClear.get(0).endNode, tempClear.get(0).cost, true));
                        start = tempClear.get(0).endNode;
                        tempClear.clear();
                    }
                }

            }

        }
        for (Node print : frontier) {
            System.out.println("frontier: " + print.startNode + " : " + print.endNode + " : " + print.cost);

        }
        System.out.println("--------------------------------");
//        for (Node print : explored) {
//            System.out.println("explored: " + print.startNode + " : " + print.endNode + " : " + print.cost);
//
//        }
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        if (explored.size() == 0) {
            System.out.println("0");
        } else {
            System.out.println("size " + explored.size());

        }
        for (Node print : explored) {
            System.out.println("explored: " + print.startNode + " : " + print.endNode + " : " + print.cost);

        }
        int newCost = 0;
        boolean out = true;
        for (int hh = 0; hh < explored.size(); hh++) {
            System.out.println("print.endNode: " + explored.get(hh).endNode);
            System.out.println("start: " + explored.get(hh).startNode);
            System.out.println("graph size: " + graph.size());
            System.out.println("explored size: " + explored.size());
            out = true;
            System.out.println("out: " + out);
            for (int h = 0; h < graph.size(); h++) {
                System.out.println("h: " + h);
                System.out.println("explored.get(hh).startNode: " + explored.get(hh).startNode);
                System.out.println("graph.get(h).startNode: " + graph.get(h).startNode);
                System.out.println("explored.get(hh).endNode " + explored.get(hh).endNode);
                System.out.println("graph.get(h).endNode " + graph.get(h).endNode);
                System.out.println("out: fout: " + out);
                if (out == true) {
                    if (explored.get(hh).startNode == graph.get(h).startNode && explored.get(hh).endNode == graph.get(h).endNode && out == true) {
                        System.out.println("if");
                        newCost += graph.get(h).cost;
                        System.out.println("cost: " + newCost);
                        out = false;
                    }
                    if (explored.get(hh).endNode == "")  {
                        System.out.println("else");
                        newCost += 0;
                        System.out.println("cost: " + newCost);
                        out = false;
                    }

                }
                System.out.println("for inner: h: " + h);

            }
        }
        System.out.println("cost: " + newCost);

    }

    public static void main(String[] args) {

        NewGreedy obj = new NewGreedy();
        Astar a = new Astar();
        
       // obj.graphDesing();
        a.ASTAR();
    }

}
