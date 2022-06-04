package domain;


import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@javax.persistence.Entity
public class TaskList extends Entity{
    @OneToOne
    private RecentFile file;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TodoTask> tasks;
    public TaskList(){}

    public TaskList(RecentFile file, List<TodoTask> tasks) {
        this.file = file;
        this.tasks = tasks;
    }

    public RecentFile getFile() {
        return file;
    }

    public void setFile(RecentFile file) {
        this.file = file;
    }

    public List<TodoTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<TodoTask> tasks) {
        this.tasks = tasks;
    }
}
