package src;
import java.util.Date;
import java.util.ArrayList;

/**
 * Created by Sabrina on 1/18/18.
 */


/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 *
 * @author Michael Kölling and David Barnes
 * @version 2011.07.31
 */
public class LabClass {
    private Instructor instructor;
    //the instructor is no longer just one string as we will have different instructors
    private Room room;
    // we also have several different rooms
    private Date startingTime;
    private ArrayList<Student> students;
    private int capacity;

    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values.
     */

    public LabClass(int maxNumberOfStudents) {
        //each instance of this lab class will have its own characteristics, hence the "this"s
        this.instructor = null;
        this.room = null;
        this.startingTime = null;
        this.students = new ArrayList<Student>();
        this.capacity = maxNumberOfStudents;
    }

    public void createClassDetails() {


    }

    /**
     * Add a student to this LabClass.
     */
    public void enrollStudent(Student newStudent) {
        if (students.size() == capacity) {
            System.out.println("The class is full, you cannot enroll.");
        } else {
            students.add(newStudent);
        }
    }

    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents() {
        return students.size();
    }

    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(Room room) {
        //labs are held in different rooms
        this.room = room;
    }

    /**
     * Set the starting time for this LabClass.
     */
    public void setTime(Date startingTime) {
        //diff times for diff classes
        this.startingTime = startingTime;
    }

    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(Instructor instructor) {
        //we assign a certain instructor to this instance of the lab class
        this.instructor = instructor;
    }

    public String getInstructorInfo() {
        return "Instructor: " + instructor.getDetails();
    }

    public String getRoomInfo() {
        return "Room: "+ room.getDetails();
    }

    /**
     * Print out a class list with other LabClass details to the standard
     * terminal.
     */
    public void printList() {
        System.out.println("Lab class " + startingTime);
        System.out.println(getInstructorInfo() +" " + getRoomInfo());
        System.out.println("Class list:");
        for (Student student : students) {
            System.out.println(student.getDetails());
        }
        System.out.println("Number of students: " + numberOfStudents());
    }
}