package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderItemQuantityLessOrEqualZeroException;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.ProductId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int itemQuantity;

    @AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
    private ProductId productId;

    public OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull ProductId productId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.productId = productId;
        this.itemPrice = itemPrice;
        if(qty<=0)
            throw new OrderItemQuantityLessOrEqualZeroException();
        this.itemQuantity = qty;
    }

    public Money subtotal() {
        return itemPrice.multiply(itemQuantity);
    }
}
