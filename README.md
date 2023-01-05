# ThingsFlow

----

## Contributors
- **김동열**
- **조정빈**
- **황승수**
---
## Contents
- [Tech & Stack]()
- [Summary]()
- [Feature List]()
- [ERD]()
- [TEST-CODE]()
- [Issue]()
---

## Tech & Stack
### language
<img src="https://img.shields.io/badge/Java-17-007396?style=fflat&logo=java&logoColor=white"><Br>

### Framework & API
<img src="https://img.shields.io/badge/Spring Boot-2.7.7-6DB33F?style=flat&logo=Spring Boot&logoColor=white"/><br>
<img src="https://img.shields.io/badge/spring-6DB33F?style=flat&logo=spring&logoColor=white"><br>
<img src="https://img.shields.io/badge/gradle-02303A?style=flat&logo=gradle&logoColor=white"><Br>
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat&logo=Spring security&logoColor=white"><br>
<img src="https://img.shields.io/badge/Swagger-6DB33F?style=flat&logo=Swagger&logoColor=white">

### DB
<img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=flat&logo=PostgreSQL&logoColor=white"><br>

### ORM
<img src="https://img.shields.io/badge/JPA-6DB33F?style=flat&logo=&logoColor=white"/><br>

### Tools
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=flat&logo=IntelliJ IDEA&logoColor=white"><br>

### Communication
<img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=Slack&logoColor=white"><br>
<img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=Notion&logoColor=white"><br>
---
## Summary
- 내용

---
## Feature List
### Simple List
- 사용자는 게시글을 **등록**할 수 있음
    - 게시글은 **제목**과 **본문**으로 구성
    - 제목(최대 20자), 본문(최대 200자)로 서버에서 제한
    - 제목과 본문 모두 **이모지**가 포함 가능
- 사용자는 게시글을 올릴 때 **비밀번호**를 설정 가능. 추후, 본인이 작성한 게시물에 비밀번호 입력 후 **수정**, **삭제** 가능
    - 회원가입, 로그인 없이 **비밀번호만** 일치하면 수정, 삭제 가능
    - 비밀번호는 DB에 **암호화**된 형태로 저장
    - 비밀번호는 **6자 이상**이어야 하고, **숫자 1개**이상 **반드시** 포함
- 모든 사용자는 한 페이지 내에서 모든 게시글을 **최신 순**으로 확인
- (우선) 외부 API를 활용하여 사용자가 게시글을 업로드한 시점의 날씨(예: 맑음, 흐림, 소나기, 눈 등) 정보가 게시글에 포함
    - 외부 API는 자유, https://www.weatherapi.com 에 가입 후 Real-time Weather API 사용하시는 것을 추천
    - 발급 받으신 API Key 는 전달해주지 않아도 됨
    - 게시글 작성 시 자동으로 데이터베이스에 추가되고, 수정은 불가
- 게시글의 개수가 많을 때, 사용자가 앱이나 웹에서 스크롤을 내릴 때마다 오래된 글들이
  계속 로드 되는 형태로 API 를 수정 [무한 스크롤]
  - 게시글이 중복으로 나타나면 안됨
  - 추가 로드는 20 개 단위


### Condition
1. DBMS 는 PostgreSQL, MySQL, SQLite 중 하나를 사용
2. 프론트엔드는 직접 구현하지 않아도 됨
3. 함께 일할 프론트엔드 개발자가 API 스펙을 보고 문제 없이 개발할 수 있어야 함
4. ORM 을 사용

### API Specification




---
## ERD


---
## Test-Code


---
## Issue

