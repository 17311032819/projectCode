package com.cdvtc.ecommerce.dao;

import com.cdvtc.ecommerce.connection.DbCon;
import com.cdvtc.ecommerce.model.Category;
import com.cdvtc.ecommerce.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection con;


    public ProductDao() {
        this.con = DbCon.getConnection();
    }

    public List<Category> getAllCategories() {//获取分类
        List<Category> categories = new ArrayList<>();
        try {

            String query = "select * from category";
            PreparedStatement pst = this.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setC_no(rs.getString("c_no"));
                category.setC_name(rs.getString("c_name"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }


    public List<Product> gettodaycommend() {//获取今日推荐
        List<Product> products = new ArrayList<>();
        try {

            String query = "select *, category.c_name cname from goods left join category on category.c_no=goods.c_no ";
            PreparedStatement pst = this.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setG_name(rs.getString("g_name"));
                product.setG_no(rs.getString("g_no"));
                product.setMain_image(rs.getString("main_img"));
                product.setG_price(rs.getFloat("g_price"));

                Category category = new Category();
                category.setC_no(rs.getString("c_no"));
                category.setC_name(rs.getString("c_name"));
                product.setCategory(category);

                product.setTodaycommend(rs.getString("todaycommend"));
                product.setG_quantity(rs.getString("g_quantity"));
                product.setDetails01(rs.getString("details01"));
                product.setDetails02(rs.getString("details02"));
                product.setDetails03(rs.getString("details03"));
                product.setDetails04(rs.getString("details04"));
                product.setDetails05(rs.getString("details05"));
                product.setOrigin(rs.getString("origin"));
                product.setIndredient(rs.getString("indredient"));
                product.setShow01(rs.getString("show01"));
                product.setShow02(rs.getString("show02"));
                product.setShow03(rs.getString("show03"));
                products.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public Product getProductByGno( String g_no) {//获取今日推荐
        Product product = new Product();
        try {
            String query = "select *, category.c_name cname from goods left join category on category.c_no=goods.c_no where g_no="+g_no;
            PreparedStatement pst = this.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                product.setG_name(rs.getString("g_name"));
                product.setG_no(rs.getString("g_no"));
                product.setMain_image(rs.getString("main_img"));
                product.setG_price(rs.getFloat("g_price"));

                Category category = new Category();
                category.setC_no(rs.getString("c_no"));
                category.setC_name(rs.getString("c_name"));
                product.setCategory(category);

                product.setTodaycommend(rs.getString("todaycommend"));
                product.setG_quantity(rs.getString("g_quantity"));
                product.setDetails01(rs.getString("details01"));
                product.setDetails02(rs.getString("details02"));
                product.setDetails03(rs.getString("details03"));
                product.setDetails04(rs.getString("details04"));
                product.setDetails05(rs.getString("details05"));
                product.setOrigin(rs.getString("origin"));
                product.setIndredient(rs.getString("indredient"));
                product.setShow01(rs.getString("show01"));
                product.setShow02(rs.getString("show02"));
                product.setShow03(rs.getString("show03"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
//
//    public List<Product> getAllProducts() {
//        List<Product> products = new ArrayList<>();
//        try {
//            Map<Integer, Integer> salesMap = getProductSales(); // 获取产品销售量Map
//
//            String query = "select *, category.name cname from product left join category on category.id=product.category_id";
//            PreparedStatement pst = this.con.prepareStatement(query);
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt("id"));
//                product.setName(rs.getString("name"));
//                product.setMarketPrice(rs.getBigDecimal("market_price"));
//                product.setPrice(rs.getBigDecimal("price"));
//                product.setImage(rs.getString("image"));
//                product.setStock(rs.getInt("stock"));
//
//                Category category = new Category();
//                category.setId(rs.getInt("category_id"));
//                category.setName(rs.getString("cname"));
//                product.setCategory(category);
//
//                product.setSales(salesMap.get(product.getId()));
//
//                products.add(product);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
//
//    public List<Product> getProducts(String key) {
//        List<Product> products = new ArrayList<>();
//        try {
//            Map<Integer, Integer> salesMap = getProductSales(); // 获取产品销售量Map
//
//            String query = "select *, category.name cname from product left join category on category.id=product.category_id where product.name like ? or category.name like ?";
//            PreparedStatement pst = this.con.prepareStatement(query);
//            String str = "%"+key+"%";
//            pst.setString(1, str);
//            pst.setString(2, str);
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt("id"));
//                product.setName(rs.getString("name"));
//                product.setMarketPrice(rs.getBigDecimal("market_price"));
//                product.setPrice(rs.getBigDecimal("price"));
//                product.setImage(rs.getString("image"));
//                product.setStock(rs.getInt("stock"));
//
//                Category category = new Category();
//                category.setId(rs.getInt("category_id"));
//                category.setName(rs.getString("cname"));
//                product.setCategory(category);
//
//                product.setSales(salesMap.get(product.getId()));
//
//                products.add(product);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
//
//    public List<Product> getProducts(int categoryId) {
//        List<Product> products = new ArrayList<>();
//        try {
//            Map<Integer, Integer> salesMap = getProductSales(); // 获取产品销售量Map
//
//            String query = "select *, category.name cname from product left join category on category.id=product.category_id where category_id=?";
//            PreparedStatement pst = this.con.prepareStatement(query);
//            pst.setInt(1, categoryId);
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt("id"));
//                product.setName(rs.getString("name"));
//                product.setMarketPrice(rs.getBigDecimal("market_price"));
//                product.setPrice(rs.getBigDecimal("price"));
//                product.setImage(rs.getString("image"));
//                product.setStock(rs.getInt("stock"));
//
//                Category category = new Category();
//                category.setId(rs.getInt("category_id"));
//                category.setName(rs.getString("cname"));
//                product.setCategory(category);
//
//                product.setSales(salesMap.get(product.getId()));
//
//                products.add(product);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
//
//
//    public Product getProduct(int id) {
//        try {
//            String query = "select *, category.name cname from product left join category on category.id=product.category_id where product.id=? ";
//
//            PreparedStatement pst = this.con.prepareStatement(query);
//            pst.setInt(1, id);
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt("id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getBigDecimal("price"));
//                product.setImage(rs.getString("image"));
//                product.setStock(rs.getInt("stock"));
//
//                Category category = new Category();
//                category.setId(rs.getInt("category_id"));
//                category.setName(rs.getString("cname"));
//                product.setCategory(category);
//
//                return product;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    /**
//     * 根据订单明细获取商品销量Map
//     *
//     * @return key:产品编号， value:销量
//     */
//    private Map<Integer, Integer> getProductSales() throws SQLException {
//        Map<Integer, Integer> salesMap = new HashMap<>();
//
//        String query = "select id, ifnull(sales, 0) sales from (select product.id as id,  sum(quantity) as sales from product left join order_item on product.id=order_item.product_id group by product.id) as stats";
//
//        Statement st = this.con.createStatement();
//        ResultSet rs = st.executeQuery(query);
//
//        while (rs.next()) {
//            salesMap.put(rs.getInt("id"), rs.getInt("sales"));
//        }
//
//        return salesMap;
//    }
}
