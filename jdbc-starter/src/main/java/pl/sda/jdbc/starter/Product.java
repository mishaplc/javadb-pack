package pl.sda.jdbc.starter;

import java.math.BigDecimal;

public class Product {

    String productCode;
    String productName;
    String productLine;
    String productScale;
    String productVendor;
    String productDescriptor;
    int quantityInStock;
    BigDecimal buyPrice;
    BigDecimal mSRP;

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescriptor='" + productDescriptor + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", mSRP=" + mSRP +
                '}';
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescriptor() {
        return productDescriptor;
    }

    public void setProductDescriptor(String productDescriptor) {
        this.productDescriptor = productDescriptor;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getmSRP() {
        return mSRP;
    }

    public void setmSRP(BigDecimal mSRP) {
        this.mSRP = mSRP;
    }
}
