package org.example.bd_table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", insertable = true, updatable = false)
    private Long studentId;

    @Column(name = "course_id", insertable = true, updatable = false)
    private Long courseId;
}
