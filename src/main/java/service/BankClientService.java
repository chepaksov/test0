package service;

import dao.BankClientDAO;
import exception.DBException;
import model.BankClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankClientService {

    public BankClientService() {
    }

    public BankClient getClientById(long id) throws DBException {
        try {
            return getBankClientDAO().getClientById(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public BankClient getClientByName(String name) {

        return new BankClientDAO(getMysqlConnection()).getClientByName(name);
    }

    public List<BankClient> getAllClient() {
        List<BankClient> bc = new ArrayList<>();
        try {
            BankClientDAO bcd = new BankClientDAO(getMysqlConnection());
            bc = bcd.getAllBankClient();
            return bc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bc;
    }

    public boolean deleteClient(String name) {
        if (new BankClientDAO(getMysqlConnection()).deleteClient(name)) {
            return true;
        } else return false;


    }

    public boolean addClient(BankClient client) {
        try {
            BankClientDAO bcd = new BankClientDAO(getMysqlConnection());
            bcd.getAllBankClient();

            for (BankClient s : bcd.getAllBankClient()) {
                if (s.getName().equals(client.getName())) {
                    return false;
                }
            }
            bcd.addClient(client);
            return true;


        } catch (DBException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean sendMoneyToClient(BankClient sender, String name, Long value) {
        Connection connection = getMysqlConnection();
        try {

            connection.setAutoCommit(false);

            new BankClientDAO(connection).updateClientsMoney(sender.getName(), sender.getPassword(), -1 * value);
            new BankClientDAO(connection).updateClientsMoney(name, null, value);
            connection.commit();

            return true;


        } catch (SQLException e) {

            e.printStackTrace();
            try {
                connection.rollback();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void cleanUp() throws DBException {
        BankClientDAO dao = getBankClientDAO();
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void createTable() throws DBException {
        BankClientDAO dao = getBankClientDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=root").       //password
                    append("&serverTimezone=UTC");   //setup server time

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static BankClientDAO getBankClientDAO() {
        return new BankClientDAO(getMysqlConnection());
    }
}
