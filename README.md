## 따릉이 예약/사용 시스템

수정해봄//홍주호

## 서비스 시나리오

...

1. 관리자는 구매한 따릉이를 시스템에 입력한다.
2. 사용자는 따릉이 예약시스템을 사용하기 위해 구매시스템에서 포인트를 구매한다
3. 사용자는 따릉이 예약시스템에서 포인트를 이용해 예약을 한다
4. 사용자는 따릉이 예약시스템에서 취소를 할 수 있다

...


## Event Storming 결과
 . MSAEz 로 모델링한 이벤트스토밍 결과:
  https://labs.msaez.io/#/storming/70d9e09c3c0a88189e6c4b72c6e2f61f

 
 . Event 도출
 
![image](https://user-images.githubusercontent.com/2344829/217235648-3a1157ed-2092-47e4-9f6a-9b391d7e2743.png)

  따릉이의 구매
  포인트의 구매
  예약 - 포인트 사용
  취소 - 포인트 복귀
  반납
  의 이벤트 


 . 완성된 모델
 
 ![image](https://user-images.githubusercontent.com/2344829/217236216-a38c0155-8026-4a97-80a3-d5ea708bb64e.png)



 . 완성된 모델에서 기능 검증
 
  1) 따릉이의 등록
  2) 포인트 결재 후 따릉이 예약

![image](https://user-images.githubusercontent.com/2344829/217236947-a2da20c1-0906-42d0-b874-e100ac646940.png)

  
## 구현

  . pub/sub를 통해 전달되는 내용을 policy에서 구현
  
  
  . 적용 후 테스트 (gitpod 환경)
  
    각 마이크로 서비스의 기능에 대한 검증 및
    pub/sub 를 통한 서비스 확인
    gateway를 통한 서비스 확인
    CQRS 확인 을 수행 
  
    각 서비스의 포트는 다음과 같음
  
     gateway 8088
     point결재시스템 8081
     예약시스템 8082
     point관리시스템 8083
     따릉이관리시스템 8084
     예약DashBoard 8085
  
  ...
  
   1) 따릉이관리시스템에서 따릉이의 등록 
   
      등록 : http localhost:8084/managements color="red" registeredDate="20230207"  
      
      등록 후 확인 : http localhost:8084/managements 
      
   2) point결재시스템에서 point 구매
      
      결재 (userId 10번으로 Point 3000 결재)
      
           http localhost:8081/approvals userId="10" price="3000" approveDate="20230207" 
      
      결재 후 확인
      
            http localhost:8081/approvals
      
      [pub/sub] point 시스템에 userId 10에 대한 Point 등록 확인
      
            http localhost:8083/points/10
            
   3) 예약시스템에서 따릉이 예약

      예약 (userId 10번으로 bikeID 1번 예약)

            http POST localhost:8082/reservations userId="10" bikeId="1" 

      예약 확인
           
            http localhost:8082/reservations
      
      [pub/sub] point 시스템에 userId 10의 Point 차감 확인     
           
            http localhost:8083/points/10
      
      [CQRS] 예약DashBoard 에서 예약 현황 확인
      
           http localhost:8085/reservationDashboards
           
           * 예약시스템 마이크로서비스 종료 후 재확인
           
           http localhost:8085/reservationDashboards
   
   4) gateway를 통한 시나리오 확인
   
           http localhost:8088/managements → http localhost:8084/managements
          
  ...
  
## 
  
  

# 

## Model
www.msaez.io/#/storming/70d9e09c3c0a88189e6c4b72c6e2f61f

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- approval
- reservation
- point
- bikeMgmt
- dashboard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- approval
```
 http :8088/approvals confirmId="confirmId" userId="userId" price="price" approveDate="approveDate" 
```
- reservation
```
 http :8088/reservations reserveNo="reserveNo" userId="userId" bikeId="bikeId" reserveDateTime="reserveDateTime" returnDateTime="returnDateTime" reserveStatus="reserveStatus" 
```
- point
```
 http :8088/points userId="userId" totalPoint="totalPoint" 
```
- bikeMgmt
```
 http :8088/managements bikeId="bikeId" color="color" registeredDate="registeredDate" 
```
- dashboard
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

