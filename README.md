# backend-springboot-demo

### TODO
1. devTools 확인
    * `./gradlew bootRun` 실행 하지말고, IDE에서 실행
    * Lombok 설정 추가
        - build.gradle: lombok 의존성 추가
        - VSCode: lombok 지원 설정 추가
``` json
{   // .vscode/settings.json
    "java.compile.nullAnalysis.mode": "automatic",
    "java.settings.gradle.autoDetect": "on",
    "editor.formatOnSave": true,
    "files.autoSave": "afterDelay",
    "files.autoSaveDelay": 1000,
    "java.configuration.updateBuildConfiguration": "automatic",
    "java.jdt.ls.lombokSupport.enabled": true
}
```
2. profile 확인
    * local, dev, prod 프로파일 설정 완료
    * 프로파일별 설정 파일 분리:
        - application.yml (기본 설정)
        - application-local.yml
        - application-dev.yml
        - application-prod.yml
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

5. JPA 확인

6. H2, PostgreSQL 확인

7. Flyway 확인

8. File Upload 확인

9. Auth 확인

10. ???







