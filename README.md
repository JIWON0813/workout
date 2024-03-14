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
백엔드 1명

## DB (Mongo DB)
네이밍  
https://typeof-undefined.tistory.com/11  
  
Embedding? vs Referencing?  
  
현재 상황은 Embedding이 맞는데 document 사이즈는 16MB.  
연도는 계속해서 붙을텐데 먼 미래이지만 사이즈는 무조건 한계치에 달할 수 있음.  
그렇다고 연도별로 컬렉션을 나눈다면? - 유저가 많아질경우 역시 사이즈가 16MB에 달할 수 있음  
아직 고민중  

# 기능 정리
### 팀
- 소스
    - [controller](src/main/java/com/warmingup/mini/controller/TeamController.java)
    - [service](src/main/java/com/warmingup/mini/service/TeamService.java)
    - [domain](src/main/java/com/warmingup/mini/domain/Team.java)

### 직원
- 소스
    - [controller](src/main/java/com/warmingup/mini/controller/WorkerController.java)
    - [service](src/main/java/com/warmingup/mini/service/WorkerService.java)
    - [domain](src/main/java/com/warmingup/mini/domain/Worker.java)

