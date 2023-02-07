package teambikesystem.domain;

import teambikesystem.domain.PointUsed;
import teambikesystem.domain.PointReturned;
import teambikesystem.domain.PointIncreased;
import teambikesystem.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Point_table")
@Data

public class Point  {


    
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    
    
    
    
    
    private Integer totalPoint;

    @PostPersist
    public void onPostPersist(){


        PointUsed pointUsed = new PointUsed(this);
        pointUsed.publishAfterCommit();



        PointReturned pointReturned = new PointReturned(this);
        pointReturned.publishAfterCommit();



        PointIncreased pointIncreased = new PointIncreased(this);
        pointIncreased.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }


    public static void pointTransfer(PointOrdered pointOrdered){

        System.out.println("Pub/Sub Price ["+pointOrdered.getPrice()+"] ");
        System.out.println("Pub/Sub UserId ["+pointOrdered.getUserId()+"]");
        System.out.println("Insert");

            repository().findById(Long.valueOf(pointOrdered.getUserId())).ifPresentOrElse(point->{
            
                point.setTotalPoint(point.getTotalPoint() + pointOrdered.getPrice()); 
                repository().save(point);
    
                PointIncreased pointIncreased = new PointIncreased(point);
                pointIncreased.publishAfterCommit();
    
            }            
            ,()->{

                Point point = new Point();
                point.setUserId(Long.valueOf(pointOrdered.getUserId()));
                point.setTotalPoint(pointOrdered.getPrice());
                repository().save(point);
            }
            );
       }  
       

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointIncreased pointIncreased = new PointIncreased(point);
        pointIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(pointOrdered.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointIncreased pointIncreased = new PointIncreased(point);
            pointIncreased.publishAfterCommit();

         });
        */       
    

    public static void requestReturn(Canceled canceled){


        // userId - point 1000 increase

        
        repository().findById(Long.valueOf(canceled.getUserId())).ifPresent(point->{

            point.setTotalPoint(point.getTotalPoint() + 1000); 
            repository().save(point);
    
            PointIncreased pointIncreased = new PointIncreased(point);
            pointIncreased.publishAfterCommit();
         });







        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointReturned pointReturned = new PointReturned(point);
        pointReturned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointReturned pointReturned = new PointReturned(point);
            pointReturned.publishAfterCommit();

         });
        */
        
    }

    public static void usePoint(BikeReserved bikeReserved){

        repository().findById(Long.valueOf(bikeReserved.getUserId())).ifPresent(point->{
            
            point.setTotalPoint(point.getTotalPoint() - 1000); 
            repository().save(point);

            PointUsed pointUsed = new PointUsed(point);
            pointUsed.publishAfterCommit();

         });





        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointUsed pointUsed = new PointUsed(point);
        pointUsed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(bikeReserved.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointUsed pointUsed = new PointUsed(point);
            pointUsed.publishAfterCommit();

         });
        */

        
    }

}
