package org.example.bd_table;

import javax.persistence.Column;
import java.io.Serializable;

public class SubscriptionKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
}
