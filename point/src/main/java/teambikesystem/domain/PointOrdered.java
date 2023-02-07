package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PointOrdered extends AbstractEvent {

    private Long confirmId;
    private Integer userId;
    private Integer price;
}


