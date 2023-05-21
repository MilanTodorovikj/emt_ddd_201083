package mk.ukim.finki.emt.ordermanagement.domain.exceptions;

public class OrderItemQuantityLessOrEqualZeroException extends RuntimeException{
    public OrderItemQuantityLessOrEqualZeroException() {
        super("Item in order cannot have quantity that is less or equal to zero");
    }
}
