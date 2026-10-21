package com.mycompany.studentmarksapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentMarksTest {

    // Activity 1 sample data
    private int[][] sampleMarks = {
        {70, 60},
        {40, 80},
        {30, 90}
    };

    @Test
    public void GetPassCount_ReturnsNumberOfPasses() {
        StudentMarks sm = new StudentMarks(sampleMarks);
        int expected = 4;                      // 70, 60, 80, 90
        int actual = sm.GetPassCount();
        assertEquals(expected, actual);
    }

    @Test
    public void GetFailCount_ReturnsNumberOfFails() {
        StudentMarks sm = new StudentMarks(sampleMarks);
        int expected = 2;                      // 40, 30
        int actual = sm.GetFailCount();
        assertEquals(expected, actual);
    }

    // ---------- Additional challenge ----------

    @Test
    public void GetPassCount_MarkOfExactly50_CountsAsPass() {
        int[][] marks = { {50, 49} };          // one boundary pass, one fail
        StudentMarks sm = new StudentMarks(marks);
        assertEquals(1, sm.GetPassCount());
        assertEquals(1, sm.GetFailCount());
    }

    @Test
    public void GetAverageMarks_ReturnsCorrectAverage() {
        StudentMarks sm = new StudentMarks(sampleMarks);
        double expected = 370.0 / 6;           // 61.666...
        // third value = allowed difference, because decimals are never exactly equal
        assertEquals(expected, sm.GetAverageMarks(), 0.01);
    }
}
