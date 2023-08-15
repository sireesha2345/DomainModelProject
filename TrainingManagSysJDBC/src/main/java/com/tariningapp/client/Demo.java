package com.tariningapp.client;

import com.trainingapp.exceptions.CourseNotFoundException;
import com.trainingapp.model.Training;
import com.trainingapp.service.*;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ITrainingService courseService = new TrainingServiceImpl();
		System.out.println("Welcome to SIRI's Training Institute! Please choose the below courses to enroll  ");
		System.out.println("Learn More & Gain More");
		System.out.println(
				"1. Add Course\n 2. Update Course \n  3. Get Courses By ID's \n  4. Get All Courses \n 5. Delete  Courses  \n 6. Get Training By Branch\n 7. Get Training By Course And By Branch\n 8. Get Training By Course And By Fees\n 9.Get Training By Course And By Trainer");
		int choice = scanner.nextInt();
		if (choice == 1) {
			scanner.nextLine();
			System.out.println("Enter CourseName: ");
			String cname = scanner.nextLine();
			System.out.println("Enter CourseID: ");
			Integer courseId = scanner.nextInt();
			System.out.println("Enter Branch: ");
			scanner.nextLine();
			String branch = scanner.nextLine();
			System.out.println("Enter TrainerName: ");
			String tname = scanner.nextLine();
			System.out.println("Enter fees: ");
			Double fees = scanner.nextDouble();
			System.out.println("Enter Contact: ");
			Long contact = scanner.nextLong();
			Training trainingIns = new Training(cname,courseId,branch,tname,fees,contact);
			courseService.addCourse(trainingIns);
		} else if (choice == 2) {
			System.out.println("Enter course Id to update courseName");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter CourseName: ");
			String cname = scanner.nextLine();
			courseService.updateCourse(id,cname);	
		} else if (choice==3) {
			System.out.println("Enter course Id ");
			int id = scanner.nextInt();
			courseService.getById(id);
		} else if (choice==4) {
			courseService.getAllCourses();	
		} else if (choice==5) {
			System.out.println("Enter course Id to delete courseName");
			int id = scanner.nextInt();
			courseService.deleteCourse(id);	
			
		}else if(choice==6) {	
			scanner.nextLine();
			System.out.println("Enter Branch: ");
			String branch = scanner.nextLine();
			try {
				courseService.getByBranch(branch);
			} catch (CourseNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		} else if (choice==7) {
			System.out.println("Enter CourseName: ");
			scanner.nextLine();
			String cname = scanner.nextLine();
			
			System.out.println("Enter Branch: ");
			String branch = scanner.nextLine();
			try {
				System.out.println(courseService.getByCourseAndBranch(cname,branch));
			} catch (CourseNotFoundException e) {
				System.out.println(e.getMessage());
			}
		
		} else if (choice==8) {
			
			
			System.out.println("Enter fees: ");
			Double fees = scanner.nextDouble();
			try {
	                  courseService.getByFees(fees);
			} catch (CourseNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		} else {
			System.out.println("Enter courseName and fees to fetch course");
			System.out.println("Enter CourseName: ");
			scanner.nextLine();
			String cname = scanner.nextLine();
			
			System.out.println("Enter TrainerName: ");
			String tname = scanner.nextLine();
			
			try {
				System.out.println(courseService.getByCourseAndTrainer(cname, tname));
			} catch (CourseNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		}


	}

}
