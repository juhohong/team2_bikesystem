package teambikesystem.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="ReservationDashboard_table")
@Data
public class ReservationDashboard {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String reserveNo;
        private Integer userId;
        private Integer bikeId;
        private String reserveStatus;


}
