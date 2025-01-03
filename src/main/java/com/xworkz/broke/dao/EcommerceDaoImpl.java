package com.xworkz.broke.dao;

import java.sql.*;
import java.time.LocalDate;

public class EcommerceDaoImpl implements EcommerceDao {
    private Connection connection;
    private final String URL = "";
    private final String USER = "";
    private final String PASS = "";




    @Override
    public Integer validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency) {

        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement prepareStatement = connection.prepareStatement("insert into ecommerce values (?  ? ? ?)");
            prepareStatement.setInt(1, 0);
            prepareStatement.setString(2, productName);
            prepareStatement.setString(3, productBrand);
            prepareStatement.setString(4, productModel);
            prepareStatement.setDate(5, Date.valueOf(mfgDate));
            prepareStatement.setString(7, currency);
            connection.commit();
            return prepareStatement.executeUpdate();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());

            }
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public ResultSet findById(int id) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet findByIdModel(int id, String productModel) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            statement.setInt(1, id);
            statement.setString(2, productModel);
            return null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ResultSet countByCurrency(String currency) {

        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            statement.setString(1, currency);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ResultSet productNameAndBrand(String productName, String productBrand) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            statement.setString(1, productBrand);
            statement.setString(2, productName);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    @Override
    public Integer updatePriceById(int id, double price) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            statement.setInt(1, id);
            statement.setString(2, Double.valueOf(price).toString());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Integer updateBrandByid(int id, String brand) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            statement.setString(1, brand);
            statement.setInt(2, id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Integer deleteById(int id) {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("");
            statement.setString(1, Integer.valueOf(id).toString());
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


}
