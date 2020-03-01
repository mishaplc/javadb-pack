package pl.sda.jdbc.starter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassicModelsManager {
    private ConnectionFactory connectionFactory;
    private static Logger logger = LoggerFactory.getLogger(ClassicModelsManager.class);

    public ClassicModelsManager(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void printAllOffices() {

        try (Statement statement = connectionFactory.getConnection().createStatement()) {
            String query = "Select * from Offices;";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                String city = result.getString("City");
                String phone = result.getString("phone");
                String address = result.getString("addressLine1");
                String address2 = result.getString("addressLine2");
                String state = result.getString("state");
                String country = result.getString("country");
                String postal = result.getString("postalCode");
                String terr = result.getString("territory");

                logger.info("Office in :" + city + " , " + address + " " + address2 + " , " + postal + " "
                        + city + " , " + state + " , " + "Phone" + " " + phone + " , " + country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateProductPrices() {

        try (Statement statement = connectionFactory.getConnection().createStatement()) {
            String queryUpdate = "update products set MSRP = MSRP * 1.1;";
            statement.executeUpdate(queryUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void printAllCustomersWithSalesRepName() throws SQLException {

        try (Statement statement = connectionFactory.getConnection().createStatement()) {
            String querySales = " select customerName, firstName, lastName from customers " +
                    "left join employees on salesRepEmployeeNumber = employeeNumber;";
            ResultSet result = statement.executeQuery(querySales);
            while (result.next()) {
                String customer = result.getString("customerName");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");

                System.out.println("Customer : " + customer +
                        " " + "-" + " " + "sales representative : " + " " + firstName + " " + lastName);

            }
        }
    }

    public List<Product> findProductByName(String nameMatcher) {
        String query = "Select * from products where productName LIKE ? ";
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement statement = connectionFactory.getConnection().prepareStatement(query)) {
            statement.setString(1, "%" + nameMatcher + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String productCode = result.getString("productCode");
                String productName = result.getString("productName");
                String productLine = result.getString("productLine");
                String productScale = result.getString("productScale");
                String productVendor = result.getString("productVendor");
                String productDescription = result.getString("productDescription");
                int quantityInStock = result.getInt("quantityInStock");
                BigDecimal buyPrice = result.getBigDecimal("buyPrice");
                BigDecimal mSRP = result.getBigDecimal("MSRP");

                Product p = new Product();
                p.setProductName(productName);
                productList.add(p);
// dokonczyc iterownie dla pozostalych pól


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        ClassicModelsManager classicModelsManager = new ClassicModelsManager(connectionFactory);

        System.out.println(classicModelsManager.findProductByName("harl"));


    }


}
