package dao;

import exception.DBException;
import model.BankClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankClientDAO {

    private Connection connection;

    public BankClientDAO(Connection connection) {
        this.connection = connection;
    }

    public List<BankClient> getAllBankClient() throws SQLException {
        List<BankClient> lbc = new ArrayList<>();
        Statement st = connection.createStatement();
        st.execute("select * from bank_client");
        ResultSet result = st.getResultSet();

        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            String password = result.getString("password");
            Long money = result.getLong("money");
            lbc.add(new BankClient(id, name, password, money));
        }


        return lbc;
    }

    public boolean validateClient(String name, String password) {
        List<BankClient> lvc = null;
        try {
            lvc = getAllBankClient();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (BankClient var : lvc) {
            if (var.getName().equals(name) && var.getPassword().equals(password)) return true;
        }
        return false;
    }

    public void updateClientsMoney(String name, String password, Long transactValue) throws SQLException {

        PreparedStatement pstmt = null;
        if (transactValue < 0) {
            Long trans = -1 * transactValue;
            if (validateClient(name, password) && isClientHasSum(name, trans)) {
                long money_minus = getClientByName(name).getMoney() - trans;
                pstmt = connection.prepareStatement("UPDATE bank_client SET money = ? WHERE name LIKE ?");
                pstmt.setLong(1, money_minus);
                pstmt.setString(2, name);
                pstmt.executeUpdate();
            } else throw new SQLException();
        }


        if (transactValue >= 0) {

            long money0 = getClientByName(name).getMoney() + transactValue;
            pstmt = connection.prepareStatement("UPDATE bank_client SET money = ? WHERE name LIKE ?");
            pstmt.setLong(1, money0);
            pstmt.setString(2, name);
            pstmt.executeUpdate();

        }

    }


    public BankClient getClientById(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where id like '" + id + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        //Long id = result.getLong(1);
        String name = result.getString("name");
        String password = result.getString("password");
        Long money = result.getLong("money");
        result.close();
        stmt.close();
        return new BankClient(id, name, password, money);
    }

    public boolean isClientHasSum(String name, Long expectedSum) {

        try {
            Statement stmt = connection.createStatement();

            stmt.execute("SELECT * FROM bank_client WHERE name LIKE '" + name + "'");
            ResultSet result = stmt.getResultSet();
            result.next();
            long money = result.getLong("money");//////////////////////////////////////////
            result.close();
            stmt.close();
            if (money >= expectedSum) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public long getClientIdByName(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where name like '" + name + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        long id = result.getLong(1);
        result.close();
        stmt.close();
        return id;
    }

    public BankClient getClientByName(String name) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("SELECT * FROM bank_client WHERE name LIKE '" + name + "'");
            ResultSet result = stmt.getResultSet();
            result.next();
            long id = result.getLong("id");
            String password = result.getString("password");
            Long money = result.getLong("money");
            result.close();
            stmt.close();
            return new BankClient(id, name, password, money);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new BankClient();
    }

    public void addClient(BankClient client) throws DBException, SQLException { // вместо void boolean

        Statement stmt = connection.createStatement();
        String name = client.getName();
        String password = client.getPassword();
        long money = client.getMoney();
        stmt.execute("insert into bank_client (NAME, PASSWORD, MONEY) values ('" + name + "','" + password + "', '" + money + "')");


    }

    public void sendMoney(String name, long value) {
        try {
            Statement stmt = connection.createStatement();
            BankClient bcd = getClientByName(name);
            long money0 = bcd.getMoney() + value;
            stmt.executeUpdate("UPDATE bank_client SET money = '" + money0 + "' WHERE name LIKE '" + name + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteClient(String name) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM bank_client WHERE name LIKE '" + name + "'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists bank_client (id bigint auto_increment, name varchar(256), password varchar(256), money bigint, primary key (id))");
        stmt.close();
    }

    public void dropTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS bank_client");
        stmt.close();
    }
}
