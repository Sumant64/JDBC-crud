package com.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("================welcome to Student Management App=================");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.println("Press 1 to ADD student");
				System.out.println("Press 2 to Delete student");
				System.out.println("Press 3 to Display student");
				System.out.println("Press 4 to Update student");
				System.out.println("Press 5 to Exit");
				
				int c = Integer.parseInt(br.readLine());
				
				if(c == 1) {
					// add student..
					System.out.println("Enter user name: ");
					String name = br.readLine();
					
					System.out.println("Enter user phone: ");
					String phone = br.readLine();
					
					System.out.println("Enter user city: ");
					String city = br.readLine();
					
					//create student object to store student
					Student st = new Student(name, phone, city);
					boolean answer = StudentDao.insertStudentToDB(st);
					if(answer) {
						System.out.println("Student is added successfully");
					}else {
						System.out.println("Something went wrong!");
					}
					
					System.out.println(st);
					
					
				} else if(c == 2) {
					// delete student
					
					System.out.println("Enter student id to delete");
					int userId = Integer.parseInt(br.readLine());
					boolean f = StudentDao.deleteStudent(userId);
					if(f) {
						System.out.println("Deleted....!");
					}else {
						System.out.println("Something went wrong!s");
					}
					
					
				} else if(c == 3) {
					//display
					StudentDao.showAllStudent();
					
					
				} else if(c == 4) {
					// update student
					System.out.println("Enter id of the student");
					int id = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name");
					String name = br.readLine();
					
					System.out.println("Enter phone");
					String phone = br.readLine();
					
					System.out.println("Enter city");
					String city = br.readLine();
					
					Student updSt = new Student(id, name, phone, city);
					
					boolean f = StudentDao.updateStudent(updSt);
					if(f) {
						System.out.println("Student updated successfully");
					}else {
						System.out.println("Something went wrong!!");
					}
					
				}else if(c == 5) {
					//exit
					break;
				} else {
					System.out.println("Invalid input!.. Please try again!");
				}
				
			}
			
			System.out.println("Thank you for using my application");
			System.out.println("See you soon..!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
			
			
			
		
	}

}
