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
03.14  
날짜 기록도 Embedding으로 결정 - 이유 ? 유저별로 샤딩할 생각  
샤딩은 해시 샤딩 생각중(만약 데이터가 많아진다면)  
유저 id를 기준으로 할 예정인데 범위 조회도 할 필요 없고 모든 데이터는 한 유저를 기반으로 가져올 생각이기 때문에  
근데 관리자 입장에서 이후 데이터 분석이 필요할 땐...?? ex) 어느 시간 대에 운동량이 제일 많은지... 조회 답이 없다 => 어차피 통계니 전체조회를 해야하는거 아닌가?  
03.15

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

