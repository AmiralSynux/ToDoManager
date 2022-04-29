package service;

import domain.RecentFile;

import java.io.File;
import java.util.List;

public interface IService {
    RecentFile addRecentFile(File file);
    List<RecentFile> getRecentFiles();
    void removeRecentFile(RecentFile file);
    void updateFile(RecentFile file);
    List<RecentFile> getFilteredRecentFiles(String text);

    void parse(String recentText);
}
