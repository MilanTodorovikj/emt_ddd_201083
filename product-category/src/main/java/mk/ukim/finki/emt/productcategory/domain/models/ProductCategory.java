package mk.ukim.finki.emt.productcategory.domain.models;


import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class ProductCategory extends AbstractEntity<CategoryId> {
    private String categoryName;
    private Integer numberOfProducts;
}
