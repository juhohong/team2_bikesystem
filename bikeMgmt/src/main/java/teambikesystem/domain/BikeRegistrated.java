package teambikesystem.domain;

import teambikesystem.domain.*;
import teambikesystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class BikeRegistrated extends AbstractEvent {

    private Integer bikeId;
    private String color;
    private String registeredDate;

    public BikeRegistrated(Management aggregate){
        super(aggregate);
    }
    public BikeRegistrated(){
        super();
    }
}
