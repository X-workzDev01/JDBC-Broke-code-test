package com.xworkz.broke.dao;

import java.sql.ResultSet;
import java.time.LocalDate;

public interface EcommerceDao {

    Integer validateAndSave(String productName, String productBrand, String productModel, LocalDate mfgDate, Double price, String currency);

    ResultSet findById(int id);

    ResultSet findByIdModel(int id, String productModel);

    ResultSet countByCurrency(String currency);

    ResultSet productNameAndBrand(String productName, String productBrand);

    Integer updatePriceById(int id, double price);

    Integer updateBrandByid(int id, String brand);

    Integer deleteById(int id);


}
