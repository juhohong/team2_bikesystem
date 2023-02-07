package teambikesystem.infra;

import teambikesystem.domain.*;
import teambikesystem.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationDashboardViewHandler {

    @Autowired
    private ReservationDashboardRepository reservationDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeReserved_then_CREATE_1 (@Payload BikeReserved bikeReserved) {
        try {

            if (!bikeReserved.validate()) return;

            // view 객체 생성
            ReservationDashboard reservationDashboard = new ReservationDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            reservationDashboard.setReserveNo(String.valueOf(bikeReserved.getReserveNo()));
            reservationDashboard.setUserId(bikeReserved.getUserId());
            reservationDashboard.setBikeId(bikeReserved.getBikeId());
            reservationDashboard.setReserveStatus(bikeReserved.getReserveStatus());
            // view 레파지 토리에 save
            reservationDashboardRepository.save(reservationDashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_1(@Payload Canceled canceled) {
        try {
            if (!canceled.validate()) return;
                // view 객체 조회
            Optional<ReservationDashboard> reservationDashboardOptional = reservationDashboardRepository.findById(String.valueOf(canceled.getReserveNo()));

            if( reservationDashboardOptional.isPresent()) {
                 ReservationDashboard reservationDashboard = reservationDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                reservationDashboard.setReserveStatus("예약취소");    
                // view 레파지 토리에 save
                 reservationDashboardRepository.save(reservationDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeReturned_then_UPDATE_2(@Payload BikeReturned bikeReturned) {
        try {
            if (!bikeReturned.validate()) return;
                // view 객체 조회
            Optional<ReservationDashboard> reservationDashboardOptional = reservationDashboardRepository.findById(String.valueOf(bikeReturned.getReserveNo()));

            if( reservationDashboardOptional.isPresent()) {
                 ReservationDashboard reservationDashboard = reservationDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                reservationDashboard.setReserveStatus("사용완료");    
                // view 레파지 토리에 save
                 reservationDashboardRepository.save(reservationDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

