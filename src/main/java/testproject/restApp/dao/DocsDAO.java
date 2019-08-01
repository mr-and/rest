package testproject.restApp.dao;


import testproject.restApp.model.Docs;

import java.util.List;

public interface DocsDAO {
    List<Docs> allDocs();
    void add(Docs docs);
    void delDoc(Docs docs);
    Docs getNumber(int number);
}
