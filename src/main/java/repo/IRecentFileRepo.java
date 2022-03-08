package repo;

import domain.RecentFile;

public interface IRecentFileRepo extends IRepository<Integer, RecentFile>{
    boolean fileExists(RecentFile recentFile);
}
