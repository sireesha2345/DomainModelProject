package com.trainingapp.model;

public class Training {
	private String CourseName;
	private Integer CourseId;
	private String Branch ;
	private String TrainerName;
	private double Fees;
	private long Contact;
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training(String courseName, Integer courseId, String branch, String trainerName, double fees, long contact) {
		super();
		CourseName = courseName;
		CourseId = courseId;
		Branch = branch;
		TrainerName = trainerName;
		Fees = fees;
		Contact = contact;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Integer getCourseId() {
		return CourseId;
	}
	public void setCourseId(Integer courseId) {
		CourseId = courseId;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getTrainerName() {
		return TrainerName;
	}
	public void setTrainerName(String trainerName) {
		TrainerName = trainerName;
	}
	public double getFees() {
		return Fees;
	}
	public void setFees(double fees) {
		Fees = fees;
	}
	public long getContact() {
		return Contact;
	}
	public void setContact(long contact) {
		Contact = contact;
	}
	@Override
	public String toString() {
		return "Training [CourseName=" + CourseName + ", CourseId=" + CourseId + ", Branch=" + Branch + ", TrainerName="
				+ TrainerName + ", Fees=" + Fees + ", Contact=" + Contact + "]";
	}
	
	

}
