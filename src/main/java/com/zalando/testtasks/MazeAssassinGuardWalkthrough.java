package com.zalando.testtasks;

import java.util.LinkedList;
import java.util.Objects;

public class MazeAssassinGuardWalkthrough {

    public static boolean solution(String[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        final int N = A.length;

        if (A[0] == null || A[0].length() == 0) {
            return false;
        }
        final int M = A[0].length();

        char[][] maze = new char[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = A[i].toCharArray();
        }

        // 1. Maze preprocessing
        Point start = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char field = maze[i][j];
                if (field == 'A') {
                    start = new Point(i, j);
                }
                if (field == '>') {
                    upgradeMaze(maze, i, j, N, M, 0, 1);
                    continue;
                }
                if (field == '<') {
                    upgradeMaze(maze, i, j, N, M, 0, -1);
                    continue;
                }
                if (field == '^') {
                    upgradeMaze(maze, i, j, N, M, -1, 0);
                    continue;
                }
                if (field == 'v') {
                    upgradeMaze(maze, i, j, N, M, 1, 0);
                }
            }
        }

        if (start == null) {
            return false;
        }

        // 2. Maze walkthrough
        final LinkedList<Point> path = new LinkedList<>();
        int i = start.getX();
        int j = start.getY();
        path.push(start);
        Point finish = new Point(N - 1, M - 1);
        while (path.size() > 0 && (i > 0 || i < N - 1) && (j > 0 || j < M - 1)) {
            if (path.contains(finish)) {
                return true;
            }
            Point current = path.pop();
            i = current.getX();
            j = current.getY();
            if (maze[i][j] == 'A') {
                boolean canMove = false;
                if (j + 1 < M && maze[i][j + 1] == '.') {
                    j++;
                    canMove = true;
                } else if (i + 1 < N && maze[i + 1][j] == '.') {
                    i++;
                    canMove = true;
                } else if (j - 1 >= 0 && maze[i][j - 1] == '.') {
                    j--;
                    canMove = true;
                } else if (i - 1 >= 0 && maze[i - 1][j] == '.') {
                    i--;
                    canMove = true;
                }

                if (canMove) {
                    path.push(current);
                    path.push(new Point(i, j));
                    maze[i][j] = 'A';
                }
            }
        }
        return false;
    }

    private static void upgradeMaze(char[][] maze, int i, int j, int N, int M, int x, int y) {
        while (true) {
            i += x;
            j += y;

            if (i < 0 || j < 0 || i >= N || j >= M) {
                break;
            }

            if (maze[i][j] == '>' || maze[i][j] == '<' ||
                    maze[i][j] == '^' || maze[i][j] == 'v' || maze[i][j] == 'X') {
                return;
            }
            if (maze[i][j] == '.' || maze[i][j] == 'A') {
                maze[i][j] = 'x';
            }
        }
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
