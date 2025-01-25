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

4. Validation 확인

5. JPA 확인

6. H2, PostgreSQL 확인

7. Flyway 확인

8. File Upload 확인

9. Auth 확인

10. ???







