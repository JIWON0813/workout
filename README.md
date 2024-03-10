# 어플 운동햄
운동 기록 사이드 프로젝트

## 사용 기술 스택
- JAVA 17
- Spring Boot 3.2.3
- GraphQL
- MongoDB

## 인원
디자이너 2명  
프론트 1명  
백엔드 1명(나)

## DB (Mongo DB)


# 기능 정리
### 팀
- 소스
    - [controller](src/main/java/com/warmingup/mini/controller/TeamController.java)
    - [service](src/main/java/com/warmingup/mini/service/TeamService.java)
    - [domain](src/main/java/com/warmingup/mini/domain/Team.java)
- 기능
    - 저장  
      ![img_2.png](image/img_2.png)
    - 조회  
      ![img_7.png](image/img_7.png)
    - DB 데이터  
      ![img_6.png](image/img_6.png)

### 직원
- 소스
    - [controller](src/main/java/com/warmingup/mini/controller/WorkerController.java)
    - [service](src/main/java/com/warmingup/mini/service/WorkerService.java)
    - [domain](src/main/java/com/warmingup/mini/domain/Worker.java)
- 기능
    - 저장  
      ![img.png](image/img-t1.png)
    - 같은 팀의 MANAGER가 이미 존재할 때  
      ![img_3.png](image/img_3.png)  
      ![img_1.png](image/img_1t2.png)
    - 조회  
      ![img_4.png](image/img_4.png)
    - DB 데이터  
      ![img_5.png](image/img_5.png)

