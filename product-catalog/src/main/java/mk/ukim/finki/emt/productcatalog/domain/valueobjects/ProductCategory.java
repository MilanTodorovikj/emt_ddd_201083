package mk.ukim.finki.emt.productcatalog.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class ProductCategory implements ValueObject {

    private final CategoryId id;
    private final String categoryName;
    private final Integer numberOfProducts;

    private ProductCategory() {
        this.id=CategoryId.randomId(CategoryId.class);
        this.categoryName = "";
        this.numberOfProducts = 0;
    }

    @JsonCreator
    public ProductCategory(@JsonProperty("id") CategoryId id,
                   @JsonProperty("categoryName") String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.numberOfProducts=0;
    }
}
