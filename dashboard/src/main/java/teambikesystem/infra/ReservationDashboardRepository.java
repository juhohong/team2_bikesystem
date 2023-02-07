package teambikesystem.infra;

import teambikesystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="reservationDashboards", path="reservationDashboards")
public interface ReservationDashboardRepository extends PagingAndSortingRepository<ReservationDashboard, Long> {

    

    
}
