package teambikesystem.domain;

import teambikesystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Canceled extends AbstractEvent {

    private Long reserveNo;
    private Integer userId;
}
