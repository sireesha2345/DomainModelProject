package com.trainingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trainingapp.exceptions.CourseNotFoundException;
import com.trainingapp.model.Training;
import com.trainingapp.util.DbConnection;
import com.trainingapp.util.Queries;

public class TrainingDaoImpl implements ITrainingDao{

	@Override
	public void addCourse(Training trainingIns) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERTQUERY);) {
			preparedStatement.setString(1, trainingIns.getCourseName());
			preparedStatement.setInt(2, trainingIns.getCourseId());
			preparedStatement.setString(3, trainingIns.getBranch());
			preparedStatement.setString(4, trainingIns.getTrainerName());
			preparedStatement.setDouble(5, trainingIns.getFees());
			preparedStatement.setLong(6, trainingIns.getContact());
			preparedStatement.execute();
			System.out.println("----------Courses are added sucesfully-----------");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public int updateCourse(int CourseId, String CourseName) {
		

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			preparedStatement.setInt(2, CourseId);
			preparedStatement.setString(1, CourseName);
			preparedStatement.execute();
			System.out.println("----------Course is updated sucesfully-------");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseId;
	}
	

	@Override
	public Training FindById(int CourseId) {
		Training trainingIns = new Training();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYID);) {
			preparedStatement.setInt(1, CourseId);
			try (ResultSet rt = preparedStatement.executeQuery();) {
				while (rt.next()) {

					String cname = rt.getString("CourseName");
					Integer courseId=rt.getInt("CourseId");
					String branch = rt.getString("Branch");
					String tname = rt.getString("TrainerName");
					Double fees = rt.getDouble("Fees");
					Long contact=rt.getLong("Contact");
					trainingIns.setCourseName(cname);
					trainingIns.setCourseId(courseId);
					trainingIns.setBranch(branch);
					trainingIns.setTrainerName(tname);
					trainingIns.setFees(fees);
					trainingIns.setContact(contact);
					System.out.println("Course is found sucesfully");
					System.out.println(trainingIns.toString());
				}
				return trainingIns;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	

	@Override
	public void deleteCourse(int CourseId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETEQUERY);) {
			preparedStatement.setInt(1, CourseId);
			preparedStatement.execute();
			System.out.println("Course with id: " + CourseId + " is sucessfully deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Training> FindAllCourses() {
		List<Training> courseList = new ArrayList<Training>();

		// TODO Auto-generated method stub
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETALLQUERY);) {
			preparedStatement.execute();
			System.out.println("Fetching all courses...Be Patient");
			try (ResultSet rs = preparedStatement.executeQuery();) {
				while (rs.next()) {

					String cname = rs.getString("CourseName");
					Integer courseId=rs.getInt("CourseId");
					String branch = rs.getString("Branch");
					String tname = rs.getString("TrainerName");
				 	Double fees = rs.getDouble("Fees");
				    Long contact=rs.getLong("Contact");
					Training trainingIns = new Training(cname,courseId,branch,tname,fees,contact);

					courseList.add(trainingIns);
					System.out.println(trainingIns.toString());
				}
			}
			return courseList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Training> FindByBranch(String Branch) throws CourseNotFoundException {
		List<Training> courseList = new ArrayList<Training>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYBRANCH);) {

			preparedStatement.setString(1, Branch);
			preparedStatement.execute();
			System.out.println("Getting courses with branch: " + Branch);
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String cname = rs.getString("CourseName");
					Integer courseId=rs.getInt("CourseId");
					String branch = rs.getString("Branch");
					String tname = rs.getString("TrainerName");
				 	Double fees = rs.getDouble("Fees");
				    Long contact=rs.getLong("Contact");
					Training trainingIns = new Training(cname,courseId,branch,tname,fees,contact);

					courseList.add(trainingIns);
					System.out.println(trainingIns.toString());
				}
			}
			return courseList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Training> FindByCourseAndBranch(String CourseName, String Branch) throws CourseNotFoundException {
		List<Training> courseList = new ArrayList<>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYCOURSEANDBRANCH);) {

			preparedStatement.setString(1, CourseName);
			preparedStatement.setString(2, Branch);
			System.out.println("Getting Course with Branch: " + Branch );
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String cname1 = rs.getString("CourseName");
					Integer courseId=rs.getInt("CourseId");
					String branch1 = rs.getString("Branch");
					String tname = rs.getString("TrainerName");
				 	Double fees = rs.getDouble("Fees");
				    Long contact=rs.getLong("Contact");
					Training trainingIns = new Training(cname1,courseId,branch1,tname,fees,contact);
					
					courseList.add(trainingIns);
				}
				return courseList;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Training> FindByFees( double Fees) throws CourseNotFoundException {
		List<Training> courseList = new ArrayList<Training>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYFEE);) {

			
			preparedStatement.setDouble(1, Fees);
			System.out.println("Getting Course with Branch: "  + " and with fee of: " + Fees );
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String cname = rs.getString("CourseName");
					Integer courseId=rs.getInt("CourseId");
					String branch = rs.getString("Branch");
					String tname = rs.getString("TrainerName");
				 	Double fees = rs.getDouble("Fees");
				    Long contact=rs.getLong("Contact");
					Training trainingIns = new Training(cname,courseId,branch,tname,fees,contact);
					
					courseList.add(trainingIns);
					System.out.println(trainingIns.toString());
				}
			}
			return courseList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Training> FindByCourseAndTrainer(String CourseName, String TrainerName) throws CourseNotFoundException {
		List<Training> courseList = new ArrayList<>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYCOURSEANDTRAINER);) {
                
			preparedStatement.setString(1, CourseName);
			preparedStatement.setString(2, TrainerName);
			System.out.println("Getting Course with Branch: " + CourseName + " and with trainer of: " + TrainerName );
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					String cname1 = rs.getString("CourseName");
					Integer courseId=rs.getInt("CourseId");
					String branch = rs.getString("Branch");
					String tname1 = rs.getString("TrainerName");
				 	Double fees = rs.getDouble("Fees");
				    Long contact=rs.getLong("Contact");
					Training trainingIns = new Training(cname1,courseId,branch,tname1,fees,contact);
					
					courseList.add(trainingIns);
				}
				return courseList;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	
	

}
