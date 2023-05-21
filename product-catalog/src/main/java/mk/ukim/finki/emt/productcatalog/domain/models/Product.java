package mk.ukim.finki.emt.productcatalog.domain.models;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.productcatalog.domain.exceptions.ProductSalesLessThanZeroException;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.CategoryId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name="product")
@Getter
public class Product extends AbstractEntity<ProductId> {

    private String productName;
    private String productDescription;
    private String productMark;

    private int sales = 0;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money productPrice;
    @AttributeOverride(name="id", column = @Column(name="categoryId"))
    private CategoryId categoryId;

    public Product() {
        super(ProductId.randomId(ProductId.class));
    }

    public static Product build(@NonNull String productName, @NonNull String productDescription, String productMark, @NonNull Money price,@NonNull int sales, @NonNull CategoryId categoryId) {
        Product p = new Product();
        p.productPrice = price;
        p.productName = productName;
        p.productDescription = productDescription;
        if(productMark==null || productMark.equals(""))
            p.productMark="Unknown";
        else
            p.productMark = productMark;
        if(sales<0){
            throw new ProductSalesLessThanZeroException();
        }
        p.sales = sales;
        p.categoryId=categoryId;
        return p;
    }

    public void addSales(int qty) {
        this.sales += qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }
}
