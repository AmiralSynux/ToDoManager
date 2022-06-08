package repository.database;

import domain.RecentFile;
import domain.validators.Validator;
import org.hibernate.SessionFactory;
import repository.IRecentFileRepo;

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
    public RecentFile searchFile(RecentFile recentFile) {
        List<RecentFile> files = filterMany((session)-> session.createQuery("FROM RecentFile as rf where rf.name= :name and rf.path = :path", getClassType())
                .setParameter("name",recentFile.getName())
                .setParameter("path",recentFile.getPath())
                .list());
        if(files.isEmpty())return null;
        if(files.size()>1)throw new RuntimeException("Too many files found!");
        return files.get(0);
    }

    @Override
    public List<RecentFile> getFilesOrderedByLastOpened() {
        return filterMany((session -> {
            return session.createQuery("from RecentFile as rf order by rf.lastOpened desc ", getClassType()).list();
        }));
    }

    @Override
    public List<RecentFile> getFilteredFilesOrderedByLastOpened(String text) {
        return filterMany((session -> {
            return session.createQuery("from RecentFile as rf where rf.name like :name  order by rf.lastOpened desc ", getClassType())
                    .setParameter("name","%"+text+"%")
                    .list();
        }));
    }
}
