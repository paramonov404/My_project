public class Report {
    final private int id = 0;
    private int taskId;
    final private String worker = "Paramonov";
    private double result;

    public Report(int taskId, double result) {
        this.taskId = taskId;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getWorker() {
        return worker;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", worker='" + worker + '\'' +
                ", result=" + result +
                '}';
    }
}

