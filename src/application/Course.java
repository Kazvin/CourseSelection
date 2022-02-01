package application;

import java.util.Calendar;

public class Course {

	private String name, description, courseCode;
	private int startTime, endTime;
	private String professor;
	private Calendar startDate, endDate;

	public Course(String code, String name, String desc, int start, int end, String prof, Calendar sDate,
			Calendar eDate) {
		this.courseCode = code;
		this.name = name;
		this.description = desc;
		this.professor = prof;
		this.startTime = start;
		this.endTime = end;
		this.startDate = sDate;
		this.endDate = eDate;
	}
	

	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", courseCode=" + courseCode + ", startTime="
				+ startTime + ", endTime=" + endTime + ", professor=" + professor + ", startDate=" + getStartDate()
				+ ", endDate= " + getEndDate() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getStartDate() {
		String date = (startDate.get(Calendar.MONTH) + "/" + startDate.get(Calendar.DAY_OF_MONTH) + "/"
				+ startDate.get(Calendar.YEAR));
		return date;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		String date = (endDate.get(Calendar.MONTH) + "/" + endDate.get(Calendar.DAY_OF_MONTH) + "/"
				+ endDate.get(Calendar.YEAR));
		return date;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
}
