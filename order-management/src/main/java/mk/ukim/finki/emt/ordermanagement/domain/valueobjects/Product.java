package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Product implements ValueObject {

    private final ProductId id;
    private final String productName;
    private final String productDescription;
    private final String productMark;
    private final Money productPrice;
    private final int sales;

    private Product() {
        this.id=ProductId.randomId(ProductId.class);
        this.productName = "";
        this.productDescription = "";
        this.productMark = "";
        this.productPrice = Money.valueOf(Currency.MKD,0);
        this.sales = 0;
    }

    @JsonCreator
    public Product(@JsonProperty("id") ProductId id,
                   @JsonProperty("productName") String productName,
                   @JsonProperty("productDescription") String productDescription,
                   @JsonProperty("productMark") String productMark,
                   @JsonProperty("productPrice") Money price,
                   @JsonProperty("sales") int sales) {
        this.id = id;
        this.productName = productName;
        this.productDescription=productDescription;
        this.productMark=productMark;
        this.productPrice = price;
        this.sales = sales;
    }
}
