package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PointOrdered extends AbstractEvent {

    private Long confirmId;
    private Integer userId;
    private Integer price;

    public PointOrdered(Approval aggregate){
        super(aggregate);
    }
    public PointOrdered(){
        super();
    }
}
