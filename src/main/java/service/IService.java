package service;

import domain.RecentFile;

import java.io.File;
import java.util.List;

public interface IService {
    void addRecentFile(File file);
    List<RecentFile> getRecentFiles();
    void removeRecentFile(RecentFile file);
}
