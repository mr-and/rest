package testproject.restApp.service;


import testproject.restApp.model.Docs;

import java.util.List;

public interface DocsService {
    List<Docs> allDocs();
    void add(Docs docs);
    void delDoc(Docs docs);
    Docs getNumber(int number);

}
