package com.example.enrollment.models;

import com.example.enrollment.dto.ClassDTO;
import com.example.enrollment.enums.ClasszzType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
@Builder
@NamedNativeQuery(
        name = "Classzz.findAllClassesWithEnrollmentCount",
        query = "SELECT c.class_id, c.course_id, c.semester, c.max_students, c.instructor, c.status, c.room_id, c.schedule_id, COUNT(e.enrollment_id) AS enrollment_count " +
                "FROM classes c LEFT JOIN enrollment e ON c.class_id = e.class_id GROUP BY c.class_id",
        resultSetMapping = "ClassDTO"
)
@SqlResultSetMapping(
        name = "ClassDTO",
        classes = @ConstructorResult(
                targetClass = ClassDTO.class,
                columns = {
                        @ColumnResult(name = "class_id", type = Long.class),
                        @ColumnResult(name = "course_id", type = Long.class),
                        @ColumnResult(name = "semester", type = String.class),
                        @ColumnResult(name = "max_students", type = Integer.class),
                        @ColumnResult(name = "instructor", type = String.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "room_id", type = Long.class),
                        @ColumnResult(name = "schedule_id", type = Long.class),
                        @ColumnResult(name = "enrollment_count", type = Integer.class)
                }
        )
)
public class Classzz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private long classId;
    @Column(name = "course_id",nullable = false)
    private long courseId;
    @Column(name = "semester",nullable = false)
    private String semester;
    @Column(name = "max_students",nullable = false)
    private int maxStudents;
    @Column(name = "instructor",nullable = false)
    private String instructor;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClasszzType status;
    @Column(name = "room_id",nullable = false)
    private long roomId;
    @Column(name = "schedule_id",nullable = false)
    private long scheduleId;
}
