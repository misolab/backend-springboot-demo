# backend-springboot-demo

### TODO
1. devTools 확인
    * `./gradlew bootRun` 으로 실행하고, 변경 후 `./gradlew build` 로 빌드&재실행
    * 툴의 기능을 사용하다보니, 빌드 후 재실행 시 변경 내용이 반영되지 않는 문제 발생

2. profile 확인
    * local, dev, prod 프로파일 설정 완료
    * 프로파일별 설정 파일 분리:
        - application.yml (기본 설정)
            - on-profile 에 분리 
    * 커스텀 설정 파일 분리 (/config 폴더):
        - custom.yml (기본 설정)
        - custom-local.yml
        - custom-dev.yml
        - custom-prod.yml
    * 실행 방법:
        - IDE: VM arguments에 `-Dspring.profiles.active=프로파일명` 추가
        - 커맨드라인: `./gradlew bootRun --args='--spring.profiles.active=프로파일명'`

3. swagger 확인
    * springdoc-openapi 추가
    * 접속 주소
        - Swagger UI: http://localhost:8080/swagger-ui.html
        - API Docs: http://localhost:8080/api-docs
    * 설정 항목
        - SwaggerConfig: API 문서 기본 정보 설정
        - @Tag: API 그룹 설정
        - @Operation: API 설명 설정
    * prod 프로파일
        - Swagger UI 비활성화
        - API Docs 비활성화

4. Validation 확인
    * spring-boot-starter-validation 추가
    * 검증 어노테이션
        - @NotBlank: 필수 입력값 검증
        - @Size: 문자열 길이 검증
        - @Email: 이메일 형식 검증
        - @Min, @Max: 숫자 범위 검증
    * Controller에서 검증 활성화
        - 클래스에 @Validated 추가
        - 메서드 파라미터에 @Valid 추가
    * 공통 예외 처리
        - GlobalExceptionHandler: 전역 예외 처리
        - ApiResponse: 공통 응답 형식
    * Swagger UI에서 검증 규칙 확인 가능

5. PostgreSQL, DB Client 설치
    * Docker Desktop 설치
    * Docker Compose 파일 생성, 실행
        * PostgreSQL 설정
    * DB Client 설치, 접속

6. JPA, H2, PostgreSQL 확인
    * 의존성 추가
        - spring-boot-starter-data-jpa
        - h2database
        - postgresql
    * 데이터베이스 설정
        - H2: local 프로파일
            - 메모리 DB 사용
            - H2 콘솔: http://localhost:8080/h2-console
        - PostgreSQL: dev, prod 프로파일
            - Docker Compose로 실행
            - 접속 정보:
                - Host: localhost
                - Port: 5432
                - Database: demo
                - Username: demo_user
                - Password: demo_pass
    * JPA 설정
        - ddl-auto:
            - local: create-drop (개발용)
            - dev, prod: validate (운영용)
        - show-sql: true (SQL 로그 출력)
        - format_sql: true (SQL 로그 포맷팅)

7. Flyway 확인
    * 의존성 추가
        - flyway-core
    * 설정
        - locations: classpath:db/migration
        - sql-migration-prefix: V
        - sql-migration-separator: __
        - sql-migration-suffixes: .sql
    * 마이그레이션 파일
        - V1__init.sql: 초기 테이블 생성
    * 프로파일별 설정
        - local: clean 허용 (개발용)
        - prod: clean 비활성화 (운영용)
    * 실행
        - 자동 실행: 애플리케이션 시작 시
        - 수동 실행: ./gradlew flywayMigrate

8. File Upload 확인

9. Auth 확인

10. ???







