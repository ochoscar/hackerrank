package com.ochoscar.prepare;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private static final int MODULO = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MODULO;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MODULO;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumEvenDepthNodes = 0;
    private int sumGreenLeaves = 0;

    public int getResult() {
        return Math.abs(sumEvenDepthNodes - sumGreenLeaves);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumEvenDepthNodes += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaves += leaf.getValue();
        }
    }
}

public class CG_JavaVisitorPattern {

    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] values = new int[n];
        Color[] colors = new Color[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;

            adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        scanner.close();

        return buildTree(0, -1, 0, values, colors, adjacencyList);
    }

    private static Tree buildTree(int node, int parent, int depth, int[] values, Color[] colors,    Map<Integer, List<Integer>> adjacencyList) {
        List<Integer> children = adjacencyList.getOrDefault(node, new ArrayList<>());

        if (children.size() == 1 && children.contains(parent) || children.isEmpty()) {
            return new TreeLeaf(values[node], colors[node], depth);
        }

        TreeNode treeNode = new TreeNode(values[node], colors[node], depth);
        for (int child : children) {
            if (child != parent) {
                treeNode.addChild(buildTree(child, node, depth + 1, values, colors, adjacencyList));
            }
        }
        return treeNode;
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

