package teambikesystem.domain;

import teambikesystem.domain.BikeReserved;
import teambikesystem.domain.BikeReturned;
import teambikesystem.domain.Canceled;
import teambikesystem.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Reservation_table")
@Data

public class Reservation  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long reserveNo;
    
    
    
    
    
    private Integer userId;
    
    
    
    
    
    private Integer bikeId;
    
    
    
    
    
    private Date reserveDateTime;
    
    
    
    
    
    private Date returnDateTime;
    
    
    
    
    
    private String reserveStatus;

    @PostPersist
    public void onPostPersist(){


        BikeReserved bikeReserved = new BikeReserved(this);
        bikeReserved.publishAfterCommit();



        BikeReturned bikeReturned = new BikeReturned(this);
        bikeReturned.publishAfterCommit();



        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }






}
