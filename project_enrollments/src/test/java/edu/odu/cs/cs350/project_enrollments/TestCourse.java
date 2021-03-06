package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestCourse {

	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@Test
	void testDefaultConstructor() {
		Course c1 = new Course();
		
		assertEquals(c1.getCourseTitle(), "");
		assertEquals(c1.getActualEnrolled(), 0);
		assertEquals(c1.getEnrollmentCap(), 0);
		assertEquals(c1.getProjectedEnrollment(), 0);
		assertEquals(c1.getOfferingListSize(), 0);
		//TODO Need test for display functions
		
	}
	
	@Test
	void testSingleParamConstructor() {
		Course c2 = new Course("CourseTitle");
		
		assertEquals(c2.getCourseTitle(), "CourseTitle");
		assertEquals(c2.getActualEnrolled(), 0);
		assertEquals(c2.getEnrollmentCap(), 0);
		assertEquals(c2.getProjectedEnrollment(), 0);
		assertEquals(c2.getOfferingListSize(), 0);
		//TODO Need test for display functions
	}

	@Test	
	void testSetCourseTitle() {
		Course c2 = new Course("CourseTitle");
		Course c1 = new Course();
		
		c2.setCourseTitle("NewTitle");
		
		assertEquals(c2.getCourseTitle(), "NewTitle");
		assertTrue(c2.getCourseTitle()!=c1.getCourseTitle());
		
		assertEquals(c2.getActualEnrolled(), 0);
		assertEquals(c2.getEnrollmentCap(), 0);
		assertEquals(c2.getProjectedEnrollment(), 0);
		assertEquals(c2.getOfferingListSize(), 0);
		//TODO Need to test display
	}
	
	@Test
	void testSetActualEnrolled() {
		Course c2 = new Course("CourseTitle");
		Course c1 = new Course();
		
		c2.setActualEnrolled(8);
		c1.setActualEnrolled(2);
		
		assertEquals(c2.getCourseTitle(), "CourseTitle");
		assertEquals(c2.getActualEnrolled(), 8);
		assertFalse(c2.getActualEnrolled()==c1.getActualEnrolled());
		
		assertEquals(c2.getEnrollmentCap(), 0);
		assertEquals(c2.getProjectedEnrollment(), 0);
		assertEquals(c2.getOfferingListSize(), 0);
	}
	
	@Test
	void testSsetEnrollmentCap() {
		Course c2 = new Course("CourseTitle");
		Course c1 = new Course();
		
		c2.setEnrollmentCap(9);
		c1.setEnrollmentCap(2);
		
		assertEquals(c2.getCourseTitle(), "CourseTitle");
		assertEquals(c2.getActualEnrolled(), 0);
		assertEquals(c2.getEnrollmentCap(), 9);
		assertTrue(c2.getEnrollmentCap()!=c1.getEnrollmentCap());
		
		assertEquals(c2.getProjectedEnrollment(), 0);
		assertEquals(c2.getOfferingListSize(), 0);
	}
	
	@Test
	void testSetProjectedEnrollment() {
		Course c2 = new Course("CourseTitle");
		Course c1 = new Course();
		
		c2.setProjectedEnrollment(2);
		c1.setProjectedEnrollment(7);
		
		assertEquals(c2.getCourseTitle(), "CourseTitle");
		assertEquals(c2.getActualEnrolled(), 0);
		assertEquals(c2.getEnrollmentCap(), 0);
		assertEquals(c2.getProjectedEnrollment(), 2);
		assertFalse(c2.getProjectedEnrollment()==c1.getProjectedEnrollment());
		
		assertEquals(c2.getOfferingListSize(), 0);
	}
	
	@Test
	void testAddOffering() {
		Course c2 = new Course("CourseTitle");
		Offering o1 = new Offering();
		
		c2.addOffering(o1);
		
		assertEquals(c2.getCourseTitle(), "CourseTitle");
		assertEquals(c2.getActualEnrolled(), 0);
		assertEquals(c2.getEnrollmentCap(), 0);
		assertEquals(c2.getProjectedEnrollment(), 0);
		
		assertTrue(c2.getOfferingListSize()>0);
		assertFalse(c2.getOfferingListSize()>1);
	}
	
	
	@Test
	void testDisplayCLI() {
		//final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		//System.setOut(new PrintStream(outContent));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream pri = new PrintStream(out);
		
		PrintStream ori = System.out;
		
		System.setOut(pri);
		
		Course c2 = new Course("CourseTitle");
		Offering o1 = new Offering();
		
		c2.addOffering(o1);
		c2.setActualEnrolled(255);
		
		c2.displayCLI();
		System.out.flush();
		System.setOut(ori);
		String expected = String.format("%-14s%-14s%-14s%-14s", "*"+c2.getCourseTitle(), c2.getActualEnrolled(), c2.getProjectedEnrollment(), c2.getEnrollmentCap());
		//System.out.println(expected);
		
		assertThat(out.toString(), containsString(expected));
		assertEquals(c2.getCourseTitle(), "CourseTitle");
		assertEquals(c2.getActualEnrolled(), 255);
		assertEquals(c2.getEnrollmentCap(), 0);
		assertEquals(c2.getProjectedEnrollment(), 0);	
		assertEquals(c2.getOfferingListSize(), 1);
		

	}
}
