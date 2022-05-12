package service;

import _parser.MyParser;
import domain.RecentFile;
import domain.TodoTask;
import repo.IRecentFileRepo;

import java.io.File;
import java.util.List;

public class Service implements IService{

    IRecentFileRepo fileRepo;
    public Service(IRecentFileRepo fileRepo){
        this.fileRepo = fileRepo;
    }

    @Override
    public RecentFile addRecentFile(File file) {
        RecentFile recentFile = new RecentFile(file);
        RecentFile searchFile = fileRepo.searchFile(recentFile);
        if(searchFile!=null)
            return searchFile;
        return fileRepo.save(recentFile);
    }

    @Override
    public void removeRecentFile(RecentFile file){
        fileRepo.delete(file.getId());
    }

    @Override
    public void updateFile(RecentFile file) {
        fileRepo.update(file);
    }

    @Override
    public List<RecentFile> getFilteredRecentFiles(String text) {
        return fileRepo.getFilteredFilesOrderedByLastOpened(text);
    }

    @Override
    public List<TodoTask> interpret(File file) {
        MyParser parser = new MyParser(file);
        try {
            parser.parse();
        }catch (Exception e){
            throw new RuntimeException("Unable to interpret file!\n" + e.getMessage());
        }
        return parser.getTasks();
    }

    @Override
    public List<RecentFile> getRecentFiles() {
        return fileRepo.getFilesOrderedByLastOpened();
    }


}
