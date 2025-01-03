package com.xworkz.broke.service;

import com.xworkz.broke.dao.EcommerceDao;
import com.xworkz.broke.dao.EcommerceDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EcommerceServiceImpl implements EcommerceService {
    private EcommerceDao ecommerceDao = new EcommerceDaoImpl();

    @Override
    public boolean validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency) {
        boolean isProductName = true;
        boolean isProductBrand = true;
        boolean isProducrModel = true;
        boolean isMfgDate = true;
        boolean isPrice = true;
        boolean isCurrency = true;
        if (!isProductName && !isProductBrand && !isProducrModel && !isMfgDate && !isPrice && !isCurrency) {
            Integer integer = ecommerceDao.validateAndSave(productName, productBrand, productModel, mfgDate, price, currency);
            if (integer > 0) {
                System.out.println("Valid all fields data to be saved");
                return true;
            } else {
                System.out.println("in Valid  fields data ");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void findById(int id) {
        ResultSet resultSet = ecommerceDao.findById(id);
        try {
            resultSet.next();
            while (resultSet.next()) {
                System.out.println("Print all data");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void findByIdModel(int id, String productModel) {
        ResultSet resultSet = ecommerceDao.findByIdModel(id, productModel);
        try {
            while (resultSet.next()) {
                System.out.println("Print all data");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void countByCurrency(String currency) {
        ResultSet resultSet = ecommerceDao.countByCurrency(currency);
        try {
            while (resultSet.next()) {
                System.out.println("Print count");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void productNameAndBrand(String productName, String productBrand) {
        ResultSet resultSet = ecommerceDao.productNameAndBrand(productName, productBrand);
        try {
            while (resultSet.next()) {
                System.out.println("Print all data");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean updatePriceById(int id, double price) {
        Integer integer = ecommerceDao.updatePriceById(id, price);
        System.out.println("validate response and return true or false");
        return false;
    }

    @Override
    public boolean updateBrandByid(int id, String brand) {
        Integer integer = ecommerceDao.updateBrandByid(id, brand);
        System.out.println("validate response and return true or false");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Integer integer = ecommerceDao.deleteById(id);
        System.out.println("validate response and return true or false");
        return false;
    }
}
