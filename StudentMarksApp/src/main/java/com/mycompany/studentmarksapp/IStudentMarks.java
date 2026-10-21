package com.mycompany.studentmarksapp;

public interface IStudentMarks {

    int[][] GetMarks();            // returns the marks array

    int GetTotalMarks();           // sum of all marks

    double GetAverageMarks();      // average of all marks

    int GetPassCount();            // number of marks >= 50

    int GetFailCount();            // number of marks < 50

    int GetStudentsProcessed();    // number of students (rows)
}
