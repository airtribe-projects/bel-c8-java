package com.airtribe;

import com.airtribe.cohort.Cohort;
import com.airtribe.course.Course;
import com.airtribe.course.CourseType;
import com.airtribe.course.OnlineCourse;
import com.airtribe.instructor.Instructor;
import com.airtribe.learner.JavaLearner;
import com.airtribe.learner.Learner;
import com.airtribe.learner.NodeJsLearner;
import java.util.List;


public class Main {
  public static void main(String[] args) {

    Instructor instructor = new Instructor("John Doe", "1234",
        "test@gmail.com", "1234567890", 10);

    Learner nodeLearner1 = new NodeJsLearner("1234", "Jane Doe", 5, 3, 2);
    Learner nodeLearner2 = new NodeJsLearner("1235", "John Doe", 6, 4, 3);
    Learner javaLearner = new JavaLearner("1236", "Jack Doe", 7, 5, 4);

    nodeLearner1.displayLearnerDetails();
    nodeLearner2.displayLearnerDetails();
    javaLearner.displayLearnerDetails();

    Cohort nodeCohort1 = new Cohort("1234", "01/01/2020", "01/01/2021",
        List.of(nodeLearner1, nodeLearner2), List.of(instructor));

    Cohort javaCohort = new Cohort("1235", "01/01/2020", "01/01/2021",
        List.of(javaLearner), List.of(instructor));

    javaCohort.displayCohortDetails();
    nodeCohort1.displayCohortDetails();

    Course nodeJsCourse = new OnlineCourse("1234", "NodeJs",
        "NodeJs Course", CourseType.NODE);

    nodeJsCourse.addCohort(nodeCohort1);

    nodeJsCourse.displayCourseDetails();

  }
}