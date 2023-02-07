package teambikesystem.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import teambikesystem.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import teambikesystem.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired PointRepository pointRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PointOrdered'")
    public void wheneverPointOrdered_PointTransfer(@Payload PointOrdered pointOrdered){

        PointOrdered event = pointOrdered;
        System.out.println("\n\n##### listener PointTransfer : " + pointOrdered + "\n\n");


        

        // Sample Logic //
        Point.pointTransfer(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Canceled'")
    public void wheneverCanceled_RequestReturn(@Payload Canceled canceled){

        Canceled event = canceled;
        System.out.println("\n\n##### listener RequestReturn : " + canceled + "\n\n");


        

        // Sample Logic //
        Point.requestReturn(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='BikeReserved'")
    public void wheneverBikeReserved_UsePoint(@Payload BikeReserved bikeReserved){

        BikeReserved event = bikeReserved;
        System.out.println("\n\n##### listener UsePoint : " + bikeReserved + "\n\n");


        

        // Sample Logic //
        Point.usePoint(event);
        

        

    }

}


