package com.trainingapp.service;

import java.util.List;

import com.trainingapp.exceptions.CourseNotFoundException;
import com.trainingapp.model.Training;

public interface ITrainingService {
	
	void addCourse(Training trainingIns);
	int updateCourse(int CourseId,String CourseName);
	Training getById(int CourseId);
	
	void deleteCourse(int CourseId );
	
	List<Training> getAllCourses();

	List<Training> getByBranch(String Branch) throws CourseNotFoundException;

	List<Training> getByCourseAndBranch(String CourseName, String Branch) throws CourseNotFoundException;

	List<Training> getByFees( double Fees) throws CourseNotFoundException;
	
	List<Training> getByCourseAndTrainer(String CourseName, String TrainerName) throws CourseNotFoundException;


}
