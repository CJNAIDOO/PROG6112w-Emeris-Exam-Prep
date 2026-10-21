package com.mycompany.studentmarksapp;

public class StudentMarks implements IStudentMarks {

    // 2D array: rows = students, columns = tests
    private int[][] marks;

    // Constructor: receives the array from the GUI and stores it
    public StudentMarks(int[][] marks) {
        this.marks = marks;
    }

    // Task 3.1 requirement: return the marks array
    @Override
    public int[][] GetMarks() {
        return marks;
    }

    // Task 4.2: add up every mark using nested loops
    @Override
    public int GetTotalMarks() {
        int total = 0;                                   // running total

        for (int row = 0; row < marks.length; row++) {           // each student
            for (int col = 0; col < marks[row].length; col++) {  // each test
                total = total + marks[row][col];
            }
        }
        return total;
    }

    // Task 4.3: total divided by number of marks
    @Override
    public double GetAverageMarks() {
        int count = 0;                                   // how many marks there are

        for (int row = 0; row < marks.length; row++) {
            count = count + marks[row].length;
        }

        if (count == 0) {                                // empty array: avoid dividing by 0
            return 0.0;
        }

        // (double) forces decimal division, so 370 / 6 = 61.67 and not 61
        return (double) GetTotalMarks() / count;
    }

    // Task 4.4: count marks that are 50 or more
    @Override
    public int GetPassCount() {
        int passCount = 0;

        for (int row = 0; row < marks.length; row++) {
            for (int col = 0; col < marks[row].length; col++) {
                if (marks[row][col] >= 50) {             // 50 counts as a pass
                    passCount++;
                }
            }
        }
        return passCount;
    }

    // Task 4.5: same loops, opposite condition
    @Override
    public int GetFailCount() {
        int failCount = 0;

        for (int row = 0; row < marks.length; row++) {
            for (int col = 0; col < marks[row].length; col++) {
                if (marks[row][col] < 50) {
                    failCount++;
                }
            }
        }
        return failCount;
    }

    // Task 4.6: each row is one student, so the number of rows is the answer
    @Override
    public int GetStudentsProcessed() {
        return marks.length;
    }
}
