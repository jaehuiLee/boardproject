# Board Management System

## 🛠️ 프로젝트 개요

본 프로젝트는 간단한 게시판 관리 시스템으로, Java를 기반으로 구현되었습니다. 사용자는 글 작성, 목록 조회, 글 상세 조회 및 수정/삭제 기능을 이용할 수 있습니다. `FrontController` 패턴을 통해 메뉴 선택에 따라 각 기능이 실행됩니다.

---

## ⚙️ 기술 스택

- Java (JDK 8 이상)
- Oracle DB
- JDB
- Git
- Lombok

---
## 👥 팀원 구성 및 역할 분담

본 프로젝트는 **게시판 관리 시스템**을 개발하기 위해 아래와 같은 팀원으로 구성되었습니다.

| 이름 | GitHub 계정 | 담당 | 커밋(main) |
| --- | --- | --- | --- |
| 이재희(팀장) | [@jaehuiLee](https://github.com/jaehuiLee) | 💻 전체 프로젝트 관리 및 코드 리뷰 | 진행중 |
| 최은진 | [@PanicAthe](https://github.com/PanicAthe) | 📝 글 작성 기능, 컨벤션, SQL 작성 | 6 |
| 김세연 | [@Yee0nnN](https://github.com/Yee0nnN) | 📖 목록 조회 기능 (선택, 전체) | 7 |
| 강경민 | [@Gaegulin](https://github.com/Gaegulin) | 📌 상세 조회, 수정, 삭제 기능 | 진행중 |

---

### 💼 프로젝트 역할 및 담당 업무

###  이재희 (팀장) - [@jaehuiLee](https://github.com/jaehuiLee)

- **프로젝트 관리 및 코드 품질 향상**
    - 프로젝트 전반적인 코드 리뷰 및 통합 관리
    - 기능 개발 중 발생하는 충돌 해결 및 브랜치 관리
- **데이터베이스 관리**
    - **Oracle SQL Developer**를 사용하여 데이터베이스 생성 및 관리
- **주요 기능 구현**
    - `FrontController`: 각 기능의 컨트롤러를 선택 및 실행하는 중앙 제어 컨트롤러 개발
    - `Controller`: 공통 실행 메서드를 정의하는 인터페이스 개발
    - `DBUtil`: 데이터베이스 연결 및 해제를 효율적으로 관리

###  최은진 - [@PanicAthe](https://github.com/PanicAthe)

- **게시글 작성 기능 구현**
    - `WriteController`: 사용자 입력을 바탕으로 새로운 게시글을 작성하고 DB에 저장하는 기능 구현
- **비즈니스 로직 개발**
    - `BoardService`: 게시글 작성 로직(`createBoard`) 및 데이터 검증 로직 추가
- **문서화 및 프로젝트 관리**
    - 프로젝트 커밋 컨벤션 수립 및 README 작성
    - 프로젝트 구조, 설치 방법, 실행 방법 등을 포함한 README 문서화
- **데이터베이스 설계**
    - DB 스키마 설계 및 SQL 스크립트 작성
    - `board` 테이블과 시퀀스 생성, 더미 데이터 삽입

### 김세연 - [@Yee0nnN](https://github.com/Yee0nnN)

- **게시글 목록 조회 기능 구현**
    - `ListController`: 게시글 목록을 ID 오름차순으로 정렬하여 조회
    - 게시글 목록 형식: ID, 제목, 작성자, 작성일, 내용 순으로 출력
    - 긴 제목과 내용을 요약하여 표시하는 기능
        - `summarize()` : 긴 내용 요약
        - `truncate()` : 긴 제목 요약
- **비즈니스 로직 구현**
    - `BoardService`: 게시글 전체 조회 기능 (`selectAll()`)

###  강경민 - [@Gaegulin](https://github.com/Gaegulin)

- **게시글 상세 조회 및 관리**
    - `DetailController`: 특정 게시글 ID를 입력받아 상세 조회, 수정, 삭제 기능 구현
        - `f_selectOne`: ID를 통해 상세 조회하여 게시글의 전체 내용을 출력
        - `f_update`: 기존 제목과 내용을 출력하고 수정할 내용을 사용자에게 입력받음
        - `f_delete`: 게시글 삭제 기능 구현
- **비즈니스 로직 개발**
    - `BoardService`: 게시글 상세 조회(`selectOne`), 수정(`update`), 삭제(`delete`) 기능 구현

---

## 🧭 주요 기능

### 1. 게시글 관리

- 글 작성: 사용자가 새로운 게시글을 작성할 수 있습니다.
- 목록 조회: 작성된 모든 게시글을 조회할 수 있습니다.
- 상세 조회: 특정 게시글의 상세 내용을 조회할 수 있습니다.
- 수정/삭제: 게시글을 수정하거나 삭제할 수 있습니다.

### 2. FrontController

- `FrontController` 클래스에서 메뉴 선택을 통해 `Controller` 인터페이스를 구현한 각 기능 컨트롤러가 실행됩니다.

### 3. DAO

- `BoardDAO` 클래스는 DB와 상호작용하여 CRUD 기능을 제공합니다.

---

## 🗂️ 프로젝트 구조

---

```markdown
src/
├── common/
│   ├── Controller.java
│   └── FrontController.java
│
├── controller/
│   ├── DetailController.java
│   ├── ListController.java
│   └── WriteController.java
│
├── model/
│   ├── Board.java
│   └── BoardDAO.java
│
├── service/
│   └── BoardService.java
│
├── util/
│   └── DBUtil.java
│
└── db.properties

```

## ✅ 설치 및 실행 방법

### 1. 저장소 클론:

```
git clone https://github.com/username/boardproject.git
```

---

### 2. DB 설정 (`db.properties`):

```
# Oracle DB 연결 정보
db.url=jdbc:oracle:thin:@[YOUR_IP_ADDRESS]:1521:[YOUR_SID]
db.user=[YOUR_DB_USER]
db.password=[YOUR_DB_PASSWORD]

```

- `[YOUR_IP_ADDRESS]`: Oracle DB가 설치된 서버의 IP 주소 (예: `localhost` 또는 `192.168.0.100`)
- `[YOUR_SID]`: Oracle SID (기본값: `xe`)
- `[YOUR_DB_USER]`: DB 사용자 계정
- `[YOUR_DB_PASSWORD]`: 사용자 비밀번호

---

### 3. DB 설정 SQL문:

아래 SQL문을 **Oracle SQL Developer** 또는 **SQLPlus**에서 실행하여 DB 테이블 및 시퀀스를 생성하세요.

```sql
-- Board 테이블 생성
CREATE TABLE board (
    id NUMBER PRIMARY KEY,
    title VARCHAR2(255) NOT NULL,
    content CLOB NOT NULL,
    writer VARCHAR2(100) NOT NULL,
    created_date TIMESTAMP DEFAULT SYSTIMESTAMP
);

-- 시퀀스 생성 (id 자동 증가)
CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1;

-- 더미 데이터 삽입
INSERT INTO board (id, title, content, writer) VALUES (board_seq.NEXTVAL, '첫 번째 글', '이것은 첫 번째 글입니다.', 'admin');
INSERT INTO board (id, title, content, writer) VALUES (board_seq.NEXTVAL, '두 번째 글', '이것은 두 번째 글입니다.', 'user1');
INSERT INTO board (id, title, content, writer) VALUES (board_seq.NEXTVAL, '세 번째 글', '이것은 세 번째 글입니다.', 'user2');

COMMIT;

```

---

### 4. 빌드 및 실행:

```bash
javac -cp .;lib/ojdbc8.jar src/**/*.java
java -cp .;lib/ojdbc8.jar common.FrontController

```

---

## 🧪 테스트 시나리오

- `1. 글작성`: 새로운 글을 작성하고, 목록에서 글이 정상적으로 표시되는지 확인.
- `2. 목록조회`: 작성된 모든 글이 올바르게 출력되는지 확인.
- `3. 글상세조회`: 특정 글을 선택하여 상세 내용이 출력되는지 확인.
- `0. 종료`: 프로그램이 정상적으로 종료되는지 확인.

---

## 🐣 커밋 컨벤션

| Type | 이모지 | 설명 |
| --- | --- | --- |
| 기능 추가 | ✨ | 새로운 기능 추가 |
| 버그 수정 | 🔧 | 버그 수정 |
| 코드 스타일 | 💅 | 코드 스타일링 |
| 문서 작성 | 📝 | README 또는 문서 작성 |
| 테스트 코드 | ✅ | 테스트 코드 추가 |
| 패키지 추가 | 📦 | 패키지 파일 추가 |
| 배포 | 🚀 | 배포 스크립트 |
| 핫픽스 | 💥 | 긴급한 버그 수정 |
| 삭제 | 🗑️ | 불필요한 파일 삭제 |
| 리팩토링 | 🔍 | 코드 구조 개선 |
