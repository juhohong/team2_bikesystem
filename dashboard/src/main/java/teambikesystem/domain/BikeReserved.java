package teambikesystem.domain;

import teambikesystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class BikeReserved extends AbstractEvent {

    private Long reserveNo;
    private Integer userId;
    private Integer bikeId;
    private Date reserveDateTime;
    private Date returnDateTime;
    private String reserveStatus;
}
