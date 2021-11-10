package com.pks.learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandLocatorTest {
    private static final IslandLocator geoLocator = new IslandLocator();

    @Test
    public void testIsland1() {
        /**
         * 0 1 1 0 0
         * 0 0 1 1 0
         * 0 0 0 0 0
         * 0 1 0 0 0
         * 0 0 0 0 0
         */
        int[][] arr = new int[5][5];
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[3][1] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(2, count);
    }

    @Test
    public void testIsland2() {
        /**
         * 0 1 1 0 0
         * 0 1 1 1 0
         * 0 0 0 0 0
         * 0 1 0 0 0
         * 0 0 0 0 0
         */
        int[][] arr = new int[5][5];
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[3][1] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(2, count);
    }

    @Test
    public void testBackwaters() {
        /**
         * 1 1 1 0 1
         * 1 0 0 0 1
         * 1 0 0 0 1
         * 1 0 0 0 1
         * 1 1 1 1 1
         */
        int[][] arr = new int[5][5];
        arr[0][0] = 1; arr[0][1] = 1; arr[0][2] = 1; arr[0][4] = 1;
        arr[1][0] = 1; arr[1][4] = 1;
        arr[2][0] = 1; arr[2][4] = 1;
        arr[3][0] = 1; arr[3][4] = 1;
        arr[4][0] = 1; arr[4][1] = 1; arr[4][2] = 1; arr[4][3] = 1; arr[4][4] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(1, count);
    }

    @Test
    public void testBackwaters2() {
        /**
         * 1 1 1 1 1
         * 1 0 0 0 1
         * 1 0 0 0 1
         * 1 0 0 0 0
         * 1 1 1 1 1
         */
        int[][] arr = new int[5][5];
        arr[0][0] = 1; arr[0][1] = 1; arr[0][2] = 1; arr[0][3] = 1; arr[0][4] = 1;
        arr[1][0] = 1; arr[1][4] = 1;
        arr[2][0] = 1; arr[2][4] = 1;
        arr[3][0] = 1;
        arr[4][0] = 1; arr[4][1] = 1; arr[4][2] = 1; arr[4][3] = 1; arr[4][4] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(1, count);
    }

    @Test
    public void testPond() {
        /**
         * 1 1 1 1 1
         * 1 0 0 0 1
         * 1 0 0 0 1
         * 1 0 0 0 1
         * 1 1 1 1 1
         */
        int[][] arr = new int[5][5];
        arr[0][0] = 1; arr[0][1] = 1; arr[0][2] = 1; arr[0][3] = 1; arr[0][4] = 1;
        arr[1][0] = 1; arr[1][4] = 1;
        arr[2][0] = 1; arr[2][4] = 1;
        arr[3][0] = 1; arr[3][4] = 1;
        arr[4][0] = 1; arr[4][1] = 1; arr[4][2] = 1; arr[4][3] = 1; arr[4][4] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(1, count);
    }

    @Test
    public void testIslandInLake() {
        /**
         * 1 1 1 1 1
         * 1 0 0 0 1
         * 1 0 1 0 1
         * 1 0 0 0 1
         * 1 1 1 1 1
         */
        int[][] arr = new int[5][5];
        arr[0][0] = 1; arr[0][1] = 1; arr[0][2] = 1; arr[0][3] = 1; arr[0][4] = 1;
        arr[1][0] = 1; arr[1][4] = 1;
        arr[2][0] = 1; arr[2][2] = 1; arr[2][4] = 1;
        arr[3][0] = 1; arr[3][4] = 1;
        arr[4][0] = 1; arr[4][1] = 1; arr[4][2] = 1; arr[4][3] = 1; arr[4][4] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(2, count);
    }

    @Test
    public void test2() {
        /**
         * 0 1 0 0 0
         * 0 0 1 1 0
         * 0 0 1 0 0
         * 0 1 0 0 0
         * 0 0 0 0 0
         */
        int[][] arr = new int[5][5];
        arr[0][1] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(1, count);
    }

    @Test
    public void test3() {
        /**
         * 1 1 1 1 0
         * 0 0 0 0 0
         * 1 0 1 0 1
         */
        int[][] arr = new int[3][5];
        arr[0][0] = 1; arr[0][1] = 1; arr[0][2] = 1; arr[0][3] = 1; arr[0][4] = 1;
        arr[2][0] = 1; arr[2][2] = 1; arr[2][4] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(4, count);
    }

    @Test
    public void test4() {
        /**
         * 1 1 1 1 0
         * 0 0 0 0 0
         */
        int[][] arr = new int[2][5];
        arr[0][0] = 1; arr[0][1] = 1; arr[0][2] = 1; arr[0][3] = 1; arr[0][4] = 1;
        int count = geoLocator.countIsland(arr);
        assertEquals(1, count);
    }

    @Test
    public void test5() {
        /**
         * 0 0 0 0 0
         * 0 0 0 0 0
         */
        int[][] arr = new int[2][5];
        int count = geoLocator.countIsland(arr);
        assertEquals(0, count);
    }

    @Test
    public void testEmpty() {
        int[][] arr = new int[0][0];
        int count = geoLocator.countIsland(arr);
        assertEquals(0, count);
    }

    @Test
    public void testEmptyRow() {
        int[][] arr = new int[0][5];
        int count = geoLocator.countIsland(arr);
        assertEquals(0, count);
    }

    @Test
    public void testEmptyCol() {
        int[][] arr = new int[5][0];
        int count = geoLocator.countIsland(arr);
        assertEquals(0, count);
    }

    @Test
    public void testNull() {
        int[][] arr = null;
        int count = geoLocator.countIsland(arr);
        assertEquals(0, count);
    }

}