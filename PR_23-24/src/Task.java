public class Task {
    private int id;
    private String taskDescription;
    private String expression;

    public Task(int id, String taskDescription, String expression) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.expression = expression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
