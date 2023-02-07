package teambikesystem.domain;

import teambikesystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class BikeReturned extends AbstractEvent {

    private Long reserveNo;
}
