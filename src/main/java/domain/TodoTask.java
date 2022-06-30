package domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@javax.persistence.Entity
public class TodoTask extends Entity{
//    -	Descriere (String)
//    -	Interval Repetare
//    -	Culoare
//    -	StartAt
//    -	Subtask
//    -	isActive
    private String description;
    private Duration _interval;
    // color>?
    private LocalDateTime startAt;
    private LocalDateTime completedOn;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<TodoSubtask> subtasks;
    private boolean isActive;

    public TodoTask(Integer id, String description, Duration interval, LocalDateTime startAt, List<TodoSubtask> subtasks, boolean isActive) {
        this.id = id;
        this.description = description;
        this._interval = interval;
        this.startAt = startAt;
        this.subtasks = subtasks;
        this.isActive = isActive;
    }

    public TodoTask(){
        isActive = true;
        _interval = null;
    }

    public void complete(){
        completedOn = LocalDateTime.now();
        isActive = false;
    }

    public boolean shouldRefresh(){
        if(completedOn == null) return false;
        if(_interval == null) return false;
        return !completedOn.plus(_interval).isAfter(LocalDateTime.now());
    }

    public void refresh(){
        completedOn = null;
        isActive = true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration get_interval() {
        return _interval;
    }

    public void set_interval(Duration _interval) {
        this._interval = _interval;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public List<TodoSubtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<TodoSubtask> subtasks) {
        this.subtasks = subtasks;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        String subst = "";
        for(TodoSubtask subtask : subtasks)
            subst += "- " + subtask + "\n";
        return "TodoTask{" +
                "description='" + description + '\'' +
                ", interval=" + _interval +
                ", startAt=" + startAt +
                ", isActive=" + isActive +
                ", subtasks:\n" + subst +
                '}';
    }
}
