package teambikesystem.domain;

import teambikesystem.domain.PointOrdered;
import teambikesystem.ApprovalApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Approval_table")
@Data

public class Approval  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long confirmId;
    
    
    
    
    
    private Integer userId;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private String approveDate;

    @PostPersist
    public void onPostPersist(){


        PointOrdered pointOrdered = new PointOrdered(this);
        pointOrdered.publishAfterCommit();

    }

    public static ApprovalRepository repository(){
        ApprovalRepository approvalRepository = ApprovalApplication.applicationContext.getBean(ApprovalRepository.class);
        return approvalRepository;
    }






}
