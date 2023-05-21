package mk.ukim.finki.emt.productcatalog.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CategoryId extends DomainObjectId {
    public CategoryId() {
        super(CategoryId.randomId(CategoryId.class).getId());
    }

    public CategoryId(String uuid) {
        super(uuid);
    }
}
