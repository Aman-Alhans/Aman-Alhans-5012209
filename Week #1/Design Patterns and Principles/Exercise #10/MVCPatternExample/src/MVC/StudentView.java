package MVC;

public class StudentView {
	public void displayStudentDetail(String studentName, String studentGrade, String studentId) {
		System.out.println("Student:");
		System.out.println("Name: " + studentName);
		System.out.println("Grade: " + studentGrade);
		System.out.println("Id: " + studentId);
	}
}
