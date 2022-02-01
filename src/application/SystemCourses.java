package application;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class SystemCourses {

	private static Set<Course> systemCoursesSet;
	
	private SystemCourses() {}
	
	public static void setSystemCourses() 
	{
		SystemCourses.systemCoursesSet = new HashSet<>();
		SystemCourses.systemCoursesSet.add(new Course("CS101", "Introduction to Programming", "Fundamental Principles of Programming across all languages", 1830, 2130, "Barack Obama", new GregorianCalendar(2050, 5, 21), new GregorianCalendar(2050, 8, 15)));
		SystemCourses.systemCoursesSet.add(new Course("ALG145", "Algorithms and DataStructures", "Introduces the concepts of algorithms", 1830, 2130, "Donald Trump", new GregorianCalendar(2050, 5, 22), new GregorianCalendar(2050, 8, 16)));
		SystemCourses.systemCoursesSet.add(new Course("CRT101", "Critial Thinking 1", "Rational and Logical thinking Strategies and Concepts", 1830, 2130, "Boris Johnson", new GregorianCalendar(2050, 5, 23), new GregorianCalendar(2050, 8, 17)));
		
		SystemCourses.systemCoursesSet.add(new Course("OOP214", "Object Oriented Programming", "OOP introduction", 1330, 1630, "Bill Gates", new GregorianCalendar(2050, 5, 21), new GregorianCalendar(2050, 8, 15)));
		SystemCourses.systemCoursesSet.add(new Course("JAV133", "Java Programming", "Introduction to Java Programming", 800, 1200, "Jeff Bezos", new GregorianCalendar(2050, 5, 22), new GregorianCalendar(2050, 8, 16)));
		SystemCourses.systemCoursesSet.add(new Course("WEB113", "Web Development", "HTML, CSS", 1100, 1315, "Justin Trudeau", new GregorianCalendar(2050, 5, 23), new GregorianCalendar(2050, 8, 17)));
		
		SystemCourses.systemCoursesSet.add(new Course("COM101", "Workplace Communication", "Core Concepts of Communication. Developing reading and writing skills", 800, 1200, "Jeff Bezos", new GregorianCalendar(2050, 5, 21), new GregorianCalendar(2050, 8, 15)));
		SystemCourses.systemCoursesSet.add(new Course("WEB213", "Web Development II", "Web Development Frameworks", 1135, 1345, "Justin Trudeau", new GregorianCalendar(2050, 5, 22), new GregorianCalendar(2050, 8, 16)));
		SystemCourses.systemCoursesSet.add(new Course("DBS101", "Database Design and Management", "Database SQL ", 1200, 1500, "Elon Musk", new GregorianCalendar(2050, 5, 23), new GregorianCalendar(2050, 8, 17)));
		
		SystemCourses.systemCoursesSet.add(new Course("CPP265", "Programming with C++", "Using C++ to do Advanced Programming", 1830, 2130, "Barack Obama", new GregorianCalendar(2050, 5, 21), new GregorianCalendar(2050, 8, 15)));
		SystemCourses.systemCoursesSet.add(new Course("PSY101", "Introduction to Psycology ", "The study of Psyclogy", 1830, 2130, "Donald Trump", new GregorianCalendar(2050, 5, 22), new GregorianCalendar(2050, 8, 16)));
		SystemCourses.systemCoursesSet.add(new Course("DBS202", "Database Design II", "Advanced Database Concepts", 1830, 2130, "Steve Jobs", new GregorianCalendar(2050, 5, 23), new GregorianCalendar(2050, 8, 17)));
		
		SystemCourses.systemCoursesSet.add(new Course("AAD225", "Andriod App Development", "App Development on Android using Java", 1330, 1630, "Bill Gates", new GregorianCalendar(2050, 5, 21), new GregorianCalendar(2050, 8, 15)));
		SystemCourses.systemCoursesSet.add(new Course("IOS255", "IOS App Development", "App Development on IOS", 800, 1200, "Jeff Bezos", new GregorianCalendar(2050, 5, 22), new GregorianCalendar(2050, 8, 16)));
		SystemCourses.systemCoursesSet.add(new Course("ALG245", "Algorithms and DataStructures II", "Part two of the Algorithms and Datastructures courses", 1100, 1315, "Boris Johnson", new GregorianCalendar(2050, 5, 23), new GregorianCalendar(2050, 8, 17)));
		
		SystemCourses.systemCoursesSet.add(new Course("ECO111", "Economics", "Intro to Economics", 800, 1200, "Jeff Bezos", new GregorianCalendar(2050, 5, 21), new GregorianCalendar(2050, 8, 15)));
		SystemCourses.systemCoursesSet.add(new Course("MGT312", "Management", "Managing a Workplace", 1135, 1345, "Mark Zuckerberg", new GregorianCalendar(2050, 5, 22), new GregorianCalendar(2050, 8, 16)));
		SystemCourses.systemCoursesSet.add(new Course("GEO515", "Geography", "The World ", 1200, 1500, "Elon Musk", new GregorianCalendar(2050, 5, 23), new GregorianCalendar(2050, 8, 17)));
		
		
	}
	
	
	
	public static Set<Course> getSystemCourses() { return SystemCourses.systemCoursesSet; }
	
	public static void addCourse(Course c)
	{
		SystemCourses.systemCoursesSet.add(c);
		
		
	}


	
	
}
