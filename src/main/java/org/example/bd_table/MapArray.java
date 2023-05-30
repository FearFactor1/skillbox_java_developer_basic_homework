package org.example.bd_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapArray {

    HashMap<Integer, List> map = new HashMap<>();

    public HashMap<Integer, List> allCourseAndStudent(int id, int studentId, int courseId) {
        List<Integer>  allCourseAndStudent = new ArrayList<>();
        allCourseAndStudent.add(studentId);
        allCourseAndStudent.add(courseId);
        map.put(id, allCourseAndStudent);
        return map;
    }
}
