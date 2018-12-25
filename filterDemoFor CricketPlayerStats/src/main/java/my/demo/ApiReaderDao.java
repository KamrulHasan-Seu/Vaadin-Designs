package my.demo;

import my.demo.Models.Model;

import java.util.List;

public interface ApiReaderDao {
    public List<Model> getPlayer(String name);

    public List<Model> getPlayerDetails(int id);
}
