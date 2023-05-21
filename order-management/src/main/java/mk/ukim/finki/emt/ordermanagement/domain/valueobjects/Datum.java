package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.Period;

@Embeddable
@Getter
public class Datum implements ValueObject {
    private final LocalDate date;

    protected Datum(){
        this.date=LocalDate.now();
    }

    public Datum(@NonNull LocalDate date){
        this.date=date;
    }

    public Period getTimePassed(){
        return Period.between(this.date, LocalDate.now());
    }
}
