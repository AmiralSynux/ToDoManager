package domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import java.io.File;
import java.time.LocalDateTime;

@javax.persistence.Entity
public class RecentFile extends Entity{
    File file;
    String name;
    String path;
    LocalDateTime lastOpened;

    public RecentFile(File file){
        this.file = file;
        name = file.getName();
        path = file.getAbsolutePath();
    }

    public RecentFile() {
    }

    public LocalDateTime getLastOpened() {
        return lastOpened;
    }

    public void setLastOpened(LocalDateTime lastOpened) {
        this.lastOpened = lastOpened;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
}
