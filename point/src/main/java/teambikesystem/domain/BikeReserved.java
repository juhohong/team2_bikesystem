package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class BikeReserved extends AbstractEvent {

    private Long reserveNo;
    private Integer userId;
    private Integer bikeId;
    private Date reserveDateTime;
    private Date returnDateTime;
    private String reserveStatus;
}


