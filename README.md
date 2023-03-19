# spring-data-redis

### Redis
- key-value 구조의 비정형 데이터를 저장하고 관리하기 위한 오픈 소스 기반의 비관계형 DBMS<br>
- Database, Cache, Message Broker 로 사용되며, 인메모리 데이터 구조를 가진 저장소다.<br>


### Database 가 있는데 Redis를 사용하는 이유가 뭘까?
데이터베이스는 데이터를 물리디스크에 직접 사용하기 때문에 서버에 장애가 발생해 다운되더라도 데이터가 손실되지 않지만, 매 번 디스크에 접근해야 해서, 사용자가 많아질수록 부하가 심해지고 느려진다.<br>
물론, 서비스 운영 초반이거나 규모가 작은 서비스의 경우 "Web Server-WAS-DB" 의 구조로도 데이터베이스에 무리가 가진 않는다.<br>
하지만 사용자가 늘어날수록 데이터베이스가 과부하가 될 수 있기 때문에, Cache Server를 도입하여 사용해야 한다. 이때 이 캐시서버로 이용 가능한 것이 Redis 다.<br>

### Redis 특징

- Key-Value 구조로 Query를 사용하지 않아도 된다.
- 데이터를 디스크에 쓰는 구조가 아닌, 메모리에서 데이터를 처리하기 때문에, 속도가 매우 빠르다.
- String, List, Set, Sorted Set, Hash 자료 구조를 지원한다.
- Single Threaded이다. 즉, 한 번에 하나의 명령만 처리할 수 있다. <br>
때문에, 중간에 처리 시간이 긴 명령어가 들어오면 그 뒤에 명령어들은 대기가 필요하다. (단, get, set 명령어의 경우 초당 10만개 이상 처리할 수 있을만큼 빠름.)<br>

### Redis 주의 사항
서버에 장애 발생 시 그에 대한 운영 계획이 필요하다.<br>
메모리 관리가 중요하다.<br>
싱글 스레드의 특성상, 처리하는데 오래 걸리는 요청, 명령은 피해야 한다.<br>

## Cache 전략

### 읽기 전략
- Look Aside Cache Pattern
- Write Back Pattern

### 쓰기 전략
- Write Back
- Write Through
- Write Around

### 캐시 읽기 + 쓰기 전략 조합
Look Aside + Write Around 조합
Read Through + Write Around 조합

### 참고
--- 
https://inpa.tistory.com/entry/REDIS-%F0%9F%93%9A-%EC%BA%90%EC%8B%9CCache-%EC%84%A4%EA%B3%84-%EC%A0%84%EB%9E%B5-%EC%A7%80%EC%B9%A8-%EC%B4%9D%EC%A0%95%EB%A6%AC#read_through_%ED%8C%A8%ED%84%B4
https://devlog-wjdrbs96.tistory.com/375
