package org.example.bd_table;

import javax.persistence.Column;
import java.io.Serializable;

public class PurchaseListKey implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;
}
