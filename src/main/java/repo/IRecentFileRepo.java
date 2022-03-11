package repo;

import domain.RecentFile;

import java.util.List;

public interface IRecentFileRepo extends IRepository<Integer, RecentFile>{
    /**
     * Searches a file by name and path
     * @param recentFile - the wanted file with path and name completed
     * @return the recentFile or null
     */
    RecentFile searchFile(RecentFile recentFile);

    List<RecentFile> getFilesOrderedByLastOpened();

    List<RecentFile> getFilteredFilesOrderedByLastOpened(String text);
}
