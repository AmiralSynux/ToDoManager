package service;

import domain.RecentFile;
import repo.IRecentFileRepo;
import repo.IRepository;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Service implements IService{

    IRecentFileRepo fileRepo;
    public Service(IRecentFileRepo fileRepo){
        this.fileRepo = fileRepo;
    }

    @Override
    public void addRecentFile(File file) {
        RecentFile recentFile = new RecentFile(file);
        if(fileRepo.fileExists(recentFile))
            return;
        fileRepo.save(recentFile);
    }

    public void removeRecentFile(RecentFile file){
        fileRepo.delete(file.getId());
    }

    @Override
    public List<RecentFile> getRecentFiles() {
        return fileRepo.getAll();
    }


}
