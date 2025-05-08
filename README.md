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
