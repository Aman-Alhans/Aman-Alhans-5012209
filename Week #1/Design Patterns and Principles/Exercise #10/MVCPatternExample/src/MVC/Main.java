package MVC;

public class Main {
	public static void main(String[] args) {
		Student model = new Student();
		model.setName("Amit");
		model.setId("111");
		model.setGrade("A");
		
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model,view);
		
		controller.View();
		
		controller.setStudentName("Rahul");
		controller.setStudentGrade("B");
		
		controller.View();
	}
}
