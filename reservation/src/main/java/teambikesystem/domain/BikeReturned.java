package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class BikeReturned extends AbstractEvent {

    private Long reserveNo;

    public BikeReturned(Reservation aggregate){
        super(aggregate);
    }
    public BikeReturned(){
        super();
    }
}
