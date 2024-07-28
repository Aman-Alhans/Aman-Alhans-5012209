package task;

public class Task {
	private String TaskId;
	private String TaskName;
	private String Status;
	
	public Task(String TaskId, String TaskName, String Status) {
		this.TaskId = TaskId;
		this.TaskName = TaskName;
		this.Status = Status;
	}
	
	public String getTaskId() {
		return TaskId;
	}
	
	public String getTaskName() {
		return TaskName;
	}
	
	public String getStatus() {
		return Status;
	}
	
	@Override
	public String toString() {
		return "Task Id = " + TaskId + " Task Name = " + TaskName + " Status + " + Status;
	}
}
