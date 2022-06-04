package repo.database;

import domain.Entity;
import domain.validators.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repo.IRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDbRepo<ID extends Serializable,E extends Entity> implements IRepository<ID,E> {
    protected static SessionFactory sessionFactory;
    protected final Validator<E> validator;
    protected static final Logger logger= LogManager.getLogger();
    public BaseDbRepo(SessionFactory sessionFactory, Validator<E> validator) {
        this.validator = validator;
        BaseDbRepo.sessionFactory = sessionFactory;
    }

    @Override
    public E save(E entity) {
        logger.traceEntry("{}",entity);
        validator.validate(entity);
        System.out.println("Entering session");
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                logger.trace("Before save");
                session.save(entity);
                logger.trace("After save");
                tx.commit();
                logger.traceExit();
                return entity;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
                ex.printStackTrace();
                logger.error(ex.getMessage());
            }
        }
        throw new RuntimeException("An error encountered!");
    }
    @Override
    public void delete(ID id) {
        logger.traceEntry();
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                E entity = get(id);
                session.delete(entity);
                tx.commit();
                logger.traceExit("Deleted successfully");
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
    }

    protected abstract Class<E> getClassType();

    @Override
    public E get(ID id) {
        logger.traceEntry();
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                E entity = session.get(getClassType(), id);
                tx.commit();
                logger.traceExit("Exiting with: " + entity);
                return entity;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        logger.traceExit("Nothing found");
        return null;
    }

    interface MyQuery<E>{
        List<E> execute(Session session);
    }

    protected List<E> filterMany(MyQuery<E> query){
        logger.traceEntry();
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                List<E> entities = query.execute(session);
                tx.commit();
                logger.traceExit("Exiting with " + entities.size());
                return entities;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        logger.traceExit("Nothing found");
        return new ArrayList<>();
    }

    @Override
    public List<E> getAll() {
        logger.traceEntry();
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                List<E> entities = (List<E>)session.createQuery("From " + getClassType().getSimpleName(), getClassType()).getResultList();
                tx.commit();
                logger.traceExit("Exiting with " + entities.size());
                return entities;
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        logger.traceExit("Nothing found");
        return new ArrayList<>();
    }

    @Override
    public void update(E entity) {
        logger.traceEntry("{}",entity);
        validator.validate(entity);
        try(Session session = sessionFactory.openSession()){
            Transaction tx=null;
            try{
                tx = session.beginTransaction();
                session.update(entity);
                tx.commit();
            } catch(RuntimeException ex){
                if (tx!=null)
                    tx.rollback();
            }
        }
        logger.traceExit();
    }
}
