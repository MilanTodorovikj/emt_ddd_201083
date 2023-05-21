package mk.ukim.finki.emt.productcatalog.domain.exceptions;

public class ProductSalesLessThanZeroException extends RuntimeException{
    public ProductSalesLessThanZeroException() {
        super("Product sales cannot be less than zero");
    }
}
