package com.trainingapp.service;

import java.util.List;

import java.util.stream.Collectors;

import com.trainingapp.dao.*;
import com.trainingapp.exceptions.CourseNotFoundException;
import com.trainingapp.model.Training;

public class TrainingServiceImpl implements ITrainingService{
	
	ITrainingDao trainingService = new TrainingDaoImpl();

	@Override
	public void addCourse(Training trainingIns) {
		trainingService.addCourse(trainingIns);
		
	}

	@Override
	public int updateCourse(int CourseId, String CourseName) {
		return trainingService.updateCourse(CourseId, CourseName);
		
	}

	@Override
	public Training getById(int CourseId) {
		
		return trainingService.FindById(CourseId);
		
	}

	@Override
	public void deleteCourse(int CourseId) {
		
		trainingService.deleteCourse(CourseId);
		
	
	}

	@Override
	public List<Training> getAllCourses() {
		
		return trainingService.FindAllCourses();
		
	}

	@Override
	public List<Training> getByBranch(String Branch) throws CourseNotFoundException {
		
		List<Training> training = trainingService.FindByBranch( Branch);
		if(training.isEmpty())
			throw new CourseNotFoundException("No such Branch is found.");
		
		return training.stream()
		.sorted((d1,d2)->d1.getBranch().compareTo(d2.getBranch()))
		.collect(Collectors.toList());
	}

	@Override
	public List<Training> getByCourseAndBranch(String CourseName, String Branch) throws CourseNotFoundException {
		
		List<Training> training = trainingService.FindByCourseAndBranch( CourseName,Branch);
		if(training.isEmpty())
			throw new CourseNotFoundException("No such course with branch is found.");
		
		return training.stream()
		.sorted((d1,d2)->d1.getCourseName().compareTo(d2.getBranch()))
		.collect(Collectors.toList());
	}

	@Override
	public List<Training> getByFees( double Fees) throws CourseNotFoundException {
		
		List<Training> training = trainingService.FindByFees(Fees);
		if(training.isEmpty())
			throw new CourseNotFoundException("No such course with this much fees is found.");
		
		return training.stream()
		.sorted((d1,d2)->d1.getCourseName().compareTo(d2.getCourseName()))
		.collect(Collectors.toList());
	}

	@Override
	public List<Training> getByCourseAndTrainer(String CourseName, String TrainerName) throws CourseNotFoundException {
		
		List<Training> training = trainingService.FindByCourseAndTrainer(CourseName,TrainerName);
		if(training.isEmpty())
			throw new CourseNotFoundException("No such course with Trainer is found .");
		
		return training.stream()
		.sorted((d1,d2)->d1.getCourseName().compareTo(d2.getTrainerName()))
		.collect(Collectors.toList());
	}
	}


	