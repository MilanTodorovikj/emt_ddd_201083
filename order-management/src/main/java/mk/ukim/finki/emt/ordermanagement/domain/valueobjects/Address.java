package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address implements ValueObject {
    private final String address;
    private final String city;
    private final String country;
    private final String postalCode;

    protected Address(){
        this.address=null;
        this.city=null;
        this.country=null;
        this.postalCode=null;
    }

    public Address(@NonNull String address, @NonNull String city, @NonNull String country, @NonNull String postalCode) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }
}
