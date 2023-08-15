package com.trainingapp.dao;

import java.util.List;

import com.trainingapp.exceptions.CourseNotFoundException;
import com.trainingapp.model.Training;

public interface ITrainingDao {
	void addCourse(Training trainingIns);
	int updateCourse(int CourseId,String CourseName);
	Training FindById(int CourseId);
	
	void deleteCourse(int CourseId );
	List<Training> FindAllCourses();

	List<Training> FindByBranch(String Branch) throws CourseNotFoundException;

	List<Training> FindByCourseAndBranch(String CourseName, String Branch) throws CourseNotFoundException;

	List<Training> FindByFees(double Fees) throws CourseNotFoundException;
	
	List<Training> FindByCourseAndTrainer(String CourseName, String TrainerName) throws CourseNotFoundException;


}
