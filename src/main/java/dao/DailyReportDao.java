package DAO;

import model.DailyReport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.CarService;

import java.util.ArrayList;
import java.util.List;

public class DailyReportDao {

    private Session session;

    public DailyReportDao(Session session) {
        this.session = session;
    }

    public List<DailyReport> getAllDailyReports() {
        Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
        transaction.commit();
        session.close();
        return dailyReports;
    }


    public void newDay(DailyReport dr) {
        Transaction transaction = session.beginTransaction();
        session.save(dr);
        transaction.commit();

    }

    public void delete() {
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM DailyReport").executeUpdate();
        transaction.commit();
        session.close();
    }


}
