package testproject.restApp.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testproject.restApp.model.Docs;

import java.util.List;

@Repository
public class DocsDAOImpl  implements DocsDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Docs> allDocs() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Docs").list();
    }

    @Override
    public void add(Docs docs) {
        Session session = sessionFactory.getCurrentSession();
        session.save(docs);
    }

    @Override
    public void delDoc(Docs docs) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(docs);
    }

    @Override
    public Docs getNumber(int number) {
        Session session = sessionFactory.getCurrentSession();
        return (Docs) session.get(Docs.class, number);
    }
}
