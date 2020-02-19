package service;

import DAO.DailyReportDao;
import model.DailyReport;
import org.hibernate.SessionFactory;
import util.DBHelper;


import java.util.List;

public class DailyReportService {

    private static DailyReportService dailyReportService;

    private SessionFactory sessionFactory;

    private DailyReportService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static DailyReportService getInstance() {
        if (dailyReportService == null) {
            dailyReportService = new DailyReportService(DBHelper.getSessionFactory());
        }
        return dailyReportService;
    }

    public List<DailyReport> getAllDailyReports() {
        return new DailyReportDao(sessionFactory.openSession()).getAllDailyReports();
    }


    public DailyReport getLastReport() {
        List<DailyReport> ldr = getAllDailyReports();
        return ldr.get(ldr.size() - 1);

    }

    public void newDay() {
        long sum = 0;
        List<Long> list = CarService.getInstance().oo;
        for (Long s : list) {
            sum = sum + s;
        }
        DailyReport dr = new DailyReport();
        dr.setEarnings(sum);
        dr.setSoldCars((long) list.size());
        new DailyReportDao(sessionFactory.openSession()).newDay(dr);
        CarService.getInstance().oo.clear();

    }

    public void delete() {
        new DailyReportDao(sessionFactory.openSession()).delete();
    }


}
