package mk.ukim.finki.emt.productcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.CategoryId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class ProductForm {

    private String productName;
    private String productDescription;
    private String productMark;
    private Money price;
    private int sales;
    private CategoryId categoryId;
}
