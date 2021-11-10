package com.pks.learn;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IslandLocator {

    public static String indexToString(int row, int col) {
        return String.format("%d,%d", row, col);
    }

    public static Collection<Node> createIslandNodes(int[][] geo) {
        Map<String, Node> nodeMap = new LinkedHashMap<>();

        if (Objects.nonNull(geo) && geo.length > 0) {
            int row = geo.length;
            int col = geo[0].length;
            if (col > 0) {
                for (int i = 0; i < row; i++)
                    for (int j = 0; j < col; j++) {
                        Node node = new Node(geo[i][j], i, j, row, col);
                        nodeMap.put(node.toString(), node);
                        // Left
                        Optional.ofNullable(nodeMap.get(indexToString(i, j - 1)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // TopLeft
                        Optional.ofNullable(nodeMap.get(indexToString(i - 1, j - 1)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // Top
                        Optional.ofNullable(nodeMap.get(indexToString(i - 1, j)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // TopRight
                        Optional.ofNullable(nodeMap.get(indexToString(i - 1, j + 1)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // Right
                        Optional.ofNullable(nodeMap.get(indexToString(i, j + 1)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // BottomRight
                        Optional.ofNullable(nodeMap.get(indexToString(i + 1, j + 1)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // Bottom
                        Optional.ofNullable(nodeMap.get(indexToString(i + 1, j)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });
                        // BottomRight
                        Optional.ofNullable(nodeMap.get(indexToString(i + 1, j - 1)))
                                .ifPresent(n -> {
                                    n.getNeighbours().add(node);
                                    node.getNeighbours().add(n);
                                });

                    }
            }
        }

        return nodeMap.values();
    }

    public int countIsland(int[][] geo) {
        AtomicInteger island = new AtomicInteger(0);
        Set<Node> visitedNodes = new HashSet<>();

        createIslandNodes(geo)
                .stream()
                .filter(n -> n.getVal() == 1 && !visitedNodes.contains(n))
                .forEach(n -> {
                    island.incrementAndGet();
                    traverseNode(n, visitedNodes);
                });

        return island.get();
    }

    private void traverseNode(Node node, Set<Node> visitedNode) {
        if (!visitedNode.contains(node) && node.getVal() == 1) {
            visitedNode.add(node);
            node.getNeighbours().stream().forEach(n -> traverseNode(n, visitedNode));
        }
    }

    private static class Node {
        private final int row;
        private final int col;
        private final int height;
        private final int width;
        private final int val;

        private final Set<Node> neighbours = new HashSet<>();

        public Node(int val, int row, int col, int height, int width) {
            this.val = val;
            this.row = row;
            this.col = col;
            this.height = height;
            this.width = width;
        }

        public boolean hasTop() {
            return this.row > 0;
        }

        public boolean hasTopRight() {
            return this.row > 0 && this.col < (this.width - 1);
        }

        public boolean hasRight() {
            return this.col < (this.width - 1);
        }

        public boolean hasBottomRight() {
            return this.row < (this.height - 1) && this.col < (this.width - 1);
        }

        public boolean hasBottom() {
            return this.row < (this.height - 1);
        }

        public boolean hasBottomLeft() {
            return this.row < (this.height - 1) && this.col > 0;
        }

        public boolean hasLeft() {
            return this.col > 0;
        }

        public boolean hasTopLeft() {
            return this.col > 0 && this.row > 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row &&
                    col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return indexToString(row, col);
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getVal() {
            return val;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public Set<Node> getNeighbours() {
            return neighbours;
        }
    }
}
