package teambikesystem.domain;

import teambikesystem.domain.BikeRegistrated;
import teambikesystem.BikeMgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Management_table")
@Data

public class Management  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bikeId;
    
    
    
    
    
    private String color;
    
    
    
    
    
    private String registeredDate;

    @PostPersist
    public void onPostPersist(){


        BikeRegistrated bikeRegistrated = new BikeRegistrated(this);
        bikeRegistrated.publishAfterCommit();

    }

    public static ManagementRepository repository(){
        ManagementRepository managementRepository = BikeMgmtApplication.applicationContext.getBean(ManagementRepository.class);
        return managementRepository;
    }






}
