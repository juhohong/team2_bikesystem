package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class BikeReserved extends AbstractEvent {

    private Long reserveNo;
    private Integer userId;
    private Integer bikeId;
    private Date reserveDateTime;
    private Date returnDateTime;
    private String reserveStatus;

    public BikeReserved(Reservation aggregate){
        super(aggregate);
    }
    public BikeReserved(){
        super();
    }
}
