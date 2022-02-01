package application;

import java.util.HashSet;
import java.util.Set;

public class UserAccount {
	
	private static String name;
	private static HashSet<Course> userCourses = new HashSet<>();
	private UserAccount() {}
	
	public static String getName() { return name; }
	
	public static void setName(String name)
	{
		UserAccount.name = name;
	}
	
	public static HashSet<Course> getCourses() 
	{
		return userCourses;

	}
	
	public static void addCourse(Course c)
	{
		UserAccount.userCourses.add(c);
	}
	
	public static void clear() 
	{
		UserAccount.setName("");
		
		if(userCourses != null )
			userCourses.clear();
	}
	

}
