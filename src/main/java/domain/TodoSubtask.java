package domain;

public class TodoSubtask {
//    -	Descriere
//     -	isActive
//   -	Bool should repeat
    private String description;
    boolean isActive;
    private boolean shouldRepeat;

    public TodoSubtask(String description, boolean isActive, boolean shouldRepeat) {
        this.description = description;
        this.isActive = isActive;
        this.shouldRepeat = shouldRepeat;
    }

    public TodoSubtask(){
        shouldRepeat = true;
        isActive = true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isShouldRepeat() {
        return shouldRepeat;
    }

    public void setShouldRepeat(boolean shouldRepeat) {
        this.shouldRepeat = shouldRepeat;
    }

    @Override
    public String toString() {
        return "TodoSubtask{" +
                "description='" + description + '\'' +
                '}';
    }
}
