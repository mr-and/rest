package testproject.restApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testproject.restApp.dao.DocsDAO;
import testproject.restApp.model.Docs;

import java.util.List;

@Service
public class DocsServiceImpl implements DocsService {

    private DocsDAO docsDAO;

    @Autowired
    public void setDocsDAO(DocsDAO docsDAO) {
        this.docsDAO = docsDAO;
    }

    @Transactional
    public List<Docs> allDocs() {
        return docsDAO.allDocs();
    }

    @Transactional
    @Override
    public void add(Docs docs) {
        docsDAO.add(docs);
    }

    @Transactional
    @Override
    public void delDoc(Docs docs) {
        docsDAO.delDoc(docs);
    }

    @Transactional
    @Override
    public Docs getNumber(int number) {
        return docsDAO.getNumber(number);
    }
}
