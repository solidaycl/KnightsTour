/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package knightsTour;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static knightsTour.App.*;
import static org.junit.Assert.*;

public class AppTest {

    static int[][] startMatrix = new int[][]{
            { 2,3,4,4,4,4,3,2 },
            { 3,4,6,6,6,6,4,3 },
            { 4,6,8,8,8,8,6,4 },
            { 4,6,8,8,8,8,6,4 },
            { 4,6,8,8,8,8,6,4 },
            { 4,6,8,8,8,8,6,4 },
            { 3,4,6,6,6,6,4,3 },
            { 2,3,4,4,4,4,3,2 }
    };

    // test the getMoves method
    @Test public void testGetMoves0_0() {
        assertEquals(2, App.getMoves(new Point(0,0)).size());
    }
    @Test public void testGetMoves7_0() {
        assertEquals(2, App.getMoves(new Point(7,0)).size());
    }
    @Test public void testGetMoves0_7() {
        assertEquals(2, App.getMoves(new Point(0,7)).size());
    }
    @Test public void testGetMoves7_7() {
        assertEquals(2, App.getMoves(new Point(7,7)).size());
    }


    @Test public void testGetMoves0_4() {
        assertEquals(4, App.getMoves(new Point(0,4)).size());
    }
    @Test public void testGetMoves4_4() {
        assertEquals(8, App.getMoves(new Point(4,4)).size());
    }
    @Test public void testGetMoves1_0() {
        assertEquals(3, App.getMoves(new Point(1,0)).size());
    }
    @Test public void testGetMoves6_5() {
        assertEquals(6, App.getMoves(new Point(6,5)).size());
    }

    @Test public void testGetMoves6_5ElementsEqual() {
        ArrayList<Point> expected = new ArrayList<>();
        Point p = new Point(6, 5);

        // add all moves including invalid
        expected.add(new Point(p.x-2, p.y+1));
        expected.add(new Point(p.x-2, p.y-1));
        expected.add(new Point(p.x-1, p.y+2));
        expected.add(new Point(p.x-1, p.y-2));
        expected.add(new Point(p.x+1, p.y+2));
        expected.add(new Point(p.x+1, p.y-2));

        assertEquals(expected, App.getMoves(new Point(6,5)));
    }



    // test init board
    @Test public void testInitBoard() {
        assertArrayEquals(startMatrix, initBoard());
    }



    // test sort
    @Test public void testSortPointsInMatrix() {
        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(1,0));
        points.add(new Point(4,5));
        points.add(new Point(3,0));
        points.add(new Point(7,6));
        points.add(new Point(0,0));
        points.add(new Point(3,0));

        ArrayList<Point> expected = new ArrayList<>();
        expected.add(new Point(0,0));
        expected.add(new Point(1,0));
        expected.add(new Point(7,6));
        expected.add(new Point(3,0));
        expected.add(new Point(3,0));
        expected.add(new Point(4,5));

        assertEquals(expected, sort(false,new Point(0,0), startMatrix, points));

    }


    // test search
    @Test public void testSolutionsForAllStarts() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                assertEquals(64, search(new Point(i,j)).size());
            }
        }
    }

    @Test public void testSolutionFor4_2() {
        assertEquals(64, search(new Point(4,2)).size());
    }
    @Test public void testSolutionFor3_2() {
        assertEquals(64, search(new Point(3,2)).size());
    }

}