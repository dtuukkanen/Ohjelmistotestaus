package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseStub {
    private HashMap<String, String> courseHashMap = new HashMap<String, String>();
    private HashMap<String, ArrayList<Integer>> gradeHashMap = new HashMap<String, ArrayList<Integer>>();

    public DatabaseStub() {
        ArrayList<Integer> grades = new ArrayList<Integer>();

        // testGetAverageGrade
        grades.add(3);
        grades.add(4);
        gradeHashMap.put("123", grades);
        grades = new ArrayList<Integer>();
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(2);
        grades.add(3);
        gradeHashMap.put("666", grades);

        // testGetCourseName
        courseHashMap.put("CT60A4160", "Ohjelmistotestauksen periaatteet");
        courseHashMap.put("CT60N00B", "Help 4 newbies");
    }

    public String getCourseName(String id) {
        String courseName = courseHashMap.get(id);

        if (id.length() > 9) {
            return "Invalid id";
        }

        if (courseName == null) {
            return "Not Found";
        }

        return courseName;
    }

    public ArrayList<Integer> getGrades(String id) {
        ArrayList<Integer> grades = gradeHashMap.get(id);

        if (grades == null) {
            ArrayList<Integer> zero = new ArrayList<Integer>();
            zero.add(0);
            return zero;
        }

        return gradeHashMap.get(id);
    }
}
