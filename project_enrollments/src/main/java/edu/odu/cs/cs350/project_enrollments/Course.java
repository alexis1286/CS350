/**
 * 
 */
package edu.odu.cs.cs350.project_enrollments;

import java.util.Vector;

/**
 * holds a list of Offerings with the same course title (e.g. CS350)
 */
public class Course {

	/*
	 * Title of the course (e.g. CS350)
	 */
	private String courseTitle;
	
	/*
	 * The # of currently enrolled students
	 */
	private int actualEnrollment;
	
	/*
	 * The number of students that are projected to take the class
	 */
	private int projectedEnrollment;
	
	/*
	 * The max amount of students that can take this class.
	 */
	private int enrollmentCap;
	
	
	
	/*
	 * A vector that contains ever Offering that is a part of this course
	 *
	 *	- Holds the actual object 'Offering'
	 */
	private Vector<Offering> offeringList = new Vector<Offering>();
	
	
	
	
	/*
	 * 
	 *  DEFAULT CONSTRUCTOR
	 *  ** NEED TO FINISH
	 */
	public Course()
	{
		this.courseTitle 	= "";
	}
	
	/*
	 * Constructor - create a Course object with the course title as parameter
	 * 	
	 * 	- Only need to set the courseTitle. The rest will be calculated later
	 */
	public Course(String in)
	{
		
		this.courseTitle = in;
			
	}
	
	
	


	/*
	 * GETTERS
	 */
	public String getCourseTitle() { return this.courseTitle; }
	public int getActualEnrolled() { return this.actualEnrollment; }
	public int getEnrollmentCap() { return this.enrollmentCap; }
	public int getProjectedEnrollment() { return this.projectedEnrollment; }
	
	/*
	 * SETTERS
	 */
	public void setCourseTitle(String in) { this.courseTitle = in; }
	public void setActualEnrolled(int in) { this.actualEnrollment = in; }
	public void setEnrollmentCap(int in) { this.enrollmentCap = in; }
	public void setProjectedEnrollment(int in) { this.projectedEnrollment = in; }
	
	
	/*
	 * Add to sectionList
	 * 
	 * Param: Section to add
	 */
	public void addOffering(Offering in)
	{
		this.offeringList.addElement(in);
	}
	
	/*
	 * Print every section listed under this offering
	 */
	public void display()
	{
		
		System.out.println("[Course]   " + this.courseTitle + "\t|\t" +  this.actualEnrollment + "\t|\t" +  this.enrollmentCap + "\t|\t" + this.projectedEnrollment + "\n");
		
		for( Offering offering : this.offeringList )
		{
			offering.display();
			System.out.println("\n");
		}
		System.out.println("\n");
	}
	
}