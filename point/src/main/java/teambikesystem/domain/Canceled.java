package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long reserveNo;
    private Integer userId;
}


