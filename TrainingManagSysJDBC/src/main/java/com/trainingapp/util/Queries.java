package com.trainingapp.util;

public class Queries {
	public static final String CREATEQUERY = "create table trainingIns (CourseName varchar(20),CourseId integer primary key , Branch varchar(30),TrainerName varchar(20), Fees float,Contact bigint)";
	public static final String INSERTQUERY = "insert into trainingIns(CourseName,CourseId,Branch, TrainerName,Fees,Contact) values(?,?,?,?,?,?)";
	public static final String UPDATEQUERY = "update trainingIns set CourseName=? where CourseId=?";
	public static final String DELETEQUERY = "delete from trainingIns where CourseId=?";
	public static final String QUERYBYID = "select * from trainingIns where CourseId=?";
	public static final String GETALLQUERY = "select * from trainingIns";
	public static final String QUERYBYBRANCH = "select * from trainingIns where Branch=?";
	public static final String QUERYBYCOURSE = "select * from trainingIns where CourseName=?";
	public static final String QUERYBYCOURSEANDBRANCH = "select * from trainingIns where CourseName=? and Branch=?";
	public static final String QUERYBYFEE = "select * from trainingIns where Fees>=?";
	public static final String QUERYBYCOURSEANDTRAINER = "select * from trainingIns where CourseName=? and TrainerName=?";


}
