/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    public static void main(String[] args) {
        // Initialize department and course catalog
        Department department = new Department("Information Systems");
        CourseCatalog courseCatalog = department.getCourseCatalog();

        // Create courses (1 core and 5 electives)
        Course coreCourse = courseCatalog.newCourse("Application Engineering", "INFO 5100", 4);
        Course elective1 = courseCatalog.newCourse("Database Systems", "INFO 5200", 3);
        Course elective2 = courseCatalog.newCourse("Web Development", "INFO 5300", 3);
        Course elective3 = courseCatalog.newCourse("Machine Learning", "INFO 5400", 3);
        Course elective4 = courseCatalog.newCourse("Network Security", "INFO 5500", 3);
        Course elective5 = courseCatalog.newCourse("Cloud Computing", "INFO 5600", 3);

        // Create course schedule for the semester
        CourseSchedule courseSchedule = department.newCourseSchedule("Fall 2024");
        
        // Create course offers for each course
        CourseOffer coreOffer = courseSchedule.newCourseOffer("INFO 5100");
        CourseOffer electiveOffer1 = courseSchedule.newCourseOffer("INFO 5200");
        CourseOffer electiveOffer2 = courseSchedule.newCourseOffer("INFO 5300");
        CourseOffer electiveOffer3 = courseSchedule.newCourseOffer("INFO 5400");
        CourseOffer electiveOffer4 = courseSchedule.newCourseOffer("INFO 5500");
        CourseOffer electiveOffer5 = courseSchedule.newCourseOffer("INFO 5600");

        // Generate seats for the course offers
        coreOffer.generatSeats(20);
        electiveOffer1.generatSeats(20);
        electiveOffer2.generatSeats(20);
        electiveOffer3.generatSeats(20);
        electiveOffer4.generatSeats(20);
        electiveOffer5.generatSeats(20);

        // Create student profiles
        StudentDirectory studentDirectory = department.getStudentDirectory();
        for (int i = 0; i < 10; i++) {
            Person person = new Person("S" + String.format("%03d", i + 1)); // Create student ID S001, S002, etc.
            StudentProfile studentProfile = studentDirectory.newStudentProfile(person);
            CourseLoad courseLoad = studentProfile.newCourseLoad("Fall 2024");
            
            // Register the student in some courses (randomly chosen)
            courseLoad.newSeatAssignment(coreOffer); // Register in the core course
            // Register in elective courses
            if (i % 2 == 0) courseLoad.newSeatAssignment(electiveOffer1); // Even IDs in elective 1
            if (i % 3 == 0) courseLoad.newSeatAssignment(electiveOffer2); // Multiple of 3 in elective 2
            if (i % 4 == 0) courseLoad.newSeatAssignment(electiveOffer3); // Multiple of 4 in elective 3
            if (i % 5 == 0) courseLoad.newSeatAssignment(electiveOffer4); // Multiple of 5 in elective 4
            if (i % 6 == 0) courseLoad.newSeatAssignment(electiveOffer5); // Multiple of 6 in elective 5
        }

        // Create faculty profiles and assign them to courses
        for (int i = 0; i < 5; i++) {
            Person facultyPerson = new Person("F" + String.format("%03d", i + 1)); // Create faculty ID F001, F002, etc.
            FacultyProfile facultyProfile = new FacultyProfile(facultyPerson);
            facultyProfile.AssignAsTeacher(coreOffer); // Assign to the core course
            facultyProfile.AssignAsTeacher(electiveOffer1); // Assign to elective 1
            // You can expand this as necessary
        }

        // Print total revenue for the semester
        int total = department.calculateRevenuesBySemester("Fall 2024");
        System.out.println("Total Revenue for Fall 2024: " + total);
        
        // Print the report for the semester
        printReport(department, "Fall 2024");
    }

    public static void printReport(Department department, String semester) {
        System.out.println("Semester Report: " + semester);
        System.out.println("------------------------------------------------");
        StudentDirectory studentDirectory = department.getStudentDirectory();
        
        for (StudentProfile student : studentDirectory.studentlist) {
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Courses Registered:");

            double totalTuition = 0;
            double totalGradePoints = 0;
            int totalCourses = 0;

            // Get the CourseLoad for the specified semester
            CourseLoad courseLoad = student.getCourseLoadBySemester(semester);
            if (courseLoad == null) {
                System.out.println("No courses registered for this semester.");
                continue;
             }

        // Iterate through each SeatAssignment in the course load
            for (SeatAssignment seatAssignment : courseLoad.getSeatAssignments()) {
                double grade = seatAssignment.grade; // Accessing grade directly
                CourseOffer courseOffer = seatAssignment.getCourseOffer();
                Course course = courseOffer.getSubjectCourse();
                double tuition = seatAssignment.GetCourseStudentScore(); // Assuming Course has a getTuition method

            totalTuition += tuition;
            totalGradePoints += grade;
            totalCourses++;

            System.out.printf("- %s (Grade: %.2f, Professor: %s)\n", 
                course.getCOurseNumber(), 
                grade, 
                courseOffer.getFacultyProfile().person.getPersonId());
        }


            double averageGPA = (totalCourses > 0) ? (totalGradePoints / totalCourses) : 0;

            System.out.printf("Total Tuition Paid: %.2f\n", totalTuition);
            System.out.printf("Average GPA: %.2f\n", averageGPA);
            System.out.println("------------------------------------------------");
        }
    }
}
