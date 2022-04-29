package domain;

import java.time.LocalDateTime;
import java.util.List;

public class TodoTask {
//    -	Descriere (String)
//    -	Interval Repetare
//    -	Culoare
//    -	StartAt
//    -	Subtask
//    -	isActive
    private Integer id;
    private String description;
    private LocalDateTime interval;
    // color>?
    private LocalDateTime startAt;
    private List<TodoSubtask> subtasks;
    private boolean isActive;

    public TodoTask(Integer id, String description, LocalDateTime interval, LocalDateTime startAt, List<TodoSubtask> subtasks, boolean isActive) {
        this.id = id;
        this.description = description;
        this.interval = interval;
        this.startAt = startAt;
        this.subtasks = subtasks;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getInterval() {
        return interval;
    }

    public void setInterval(LocalDateTime interval) {
        this.interval = interval;
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
}
