package repo.database;

import domain.RecentFile;
import domain.validators.Validator;
import org.hibernate.SessionFactory;
import repo.IRecentFileRepo;

import java.util.List;

public class RecentFileRepo extends BaseDbRepo<Integer, RecentFile> implements IRecentFileRepo{

    public RecentFileRepo(SessionFactory sessionFactory, Validator<RecentFile> validator) {
        super(sessionFactory, validator);
    }

    @Override
    protected Class<RecentFile> getClassType() {
        return RecentFile.class;
    }

    @Override
    public boolean fileExists(RecentFile recentFile) {
        List<RecentFile> files = filterMany((session)-> session.createQuery("FROM RecentFile as rf where rf.name= :name and rf.path = :path", getClassType())
                .setParameter("name",recentFile.getName())
                .setParameter("path",recentFile.getPath())
                .list());
        return !files.isEmpty();
    }
}
