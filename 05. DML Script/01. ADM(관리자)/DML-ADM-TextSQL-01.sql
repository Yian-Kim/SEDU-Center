-- 관리자 로그인
SELECT * FROM tblAdmin 
    WHERE id = '아이디변수명' and pw = '비밀번호변수명'; 
-- 1. 해당 맞으면 로그인




-- 관리자- 1. 기초 정보 관리

-- 과정 입력
INSERT INTO tblCourse (course_seq, name, period)
    VALUES (Course_seq.nextVal, '과정명', '과정기간');
    
-- 과목 입력
INSERT INTO tblSubject (subject_seq, name, period)
    VALUES (Subject_seq.nextVal, '과목명', '과목기간');
    
-- 강의실명 입력
INSERT INTO tblRoom (room_seq, roomName)
    VALUES (room_seq.nextVal, '강의실명');
    
-- 과정 출력
SELECT * FROM tblCourse;

-- 과목 출력
SELECT * FROM tblSubject;

-- 강의실명 출력
SELECT * FROM tblRoom;

-- 과정 수정
UPDATE tblCourse SET name = '입력할 값', pw = '입력할 값', tel = '입력할 값'
    WHERE course_seq = '해당시퀀스번호';
    
-- 과목 수정
UPDATE tblSubject SET name = '입력할 값', period = '입력할 값'
    WHERE subject_seq = '해당시퀀스번호';

-- 강의실명 수정
UPDATE tblRoom SET roomName = '입력할 값'
    WHERE subject_seq = '해당시퀀스번호';
    
-- 과정 삭제
DELETE FROM tblCourse WHERE course_seq = '조건번호';

-- 과목 삭제
DELETE FROM tblSubject WHERE subject_seq = '조건번호';

-- 강의실명 삭제
DELETE FROM tblRoom WHERE room_seq = '조건번호';

-- 관리자- 2. 교사 계정 관리

-- 교사 정보(for문 사용해서 출력)
-- a. 교사번호(출력할 떄는 앞에 구분자 넣을 예정)
SELECT teacher_seq,name, pw, tel,(SELECT LISTAGG(s.name, ',') WITHIN GROUP (ORDER BY s.name) as tAvlSubject
    FROM tblTeacher t
        INNER JOIN tblAvlSubject a
            ON t.teacher_seq = a.teacher_seq 
                    INNER JOIN tblSubject s
                        ON a.subject_seq = s.subject_seq
                            WHERE t.teacher_seq = '해당교사번호')
        FROM tblTeacher;


-- 1.관리자 - 1. 교사 계정 관리 - 1.(상세보기) 번호를 입력받아옴(시퀀스)
-- a. 홍길동 님의 정보입니다.
SELECT name FROM tblTeacher WEHRE teacher_seq = '입력받아온번호';

-- b. 과정명(받아온 시퀀스번호를 토대로..)
SELECT c.name as courseName
    FROM tblTeacher t
        INNER JOIN tblTeacherCourse tc
            ON t.teacher_seq = tc.teacher_seq
                INNER JOIN tblOpenCourse oc
                    ON tc.openCourse_seq = oc.openCourse_Seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                WHERE t.teacher_seq = '입력받아온 번호';

-- c. 과정기간(받아온 시퀀스번호를 토대로..)
SELECT oc.startDate || '~' || oc.endDate as courseDuration
    FROM tblTeacher t
        INNER JOIN tblTeacherCourse tc
            ON t.teacher_seq = tc.teacher_seq
                INNER JOIN tblOpenCourse oc
                    ON tc.openCourse_seq = oc.openCourse_seq
                        WHERE t.teacher_seq = '입력받아온 번호';
                        
-- d. 과목명 및 기간(각 과정마다 나누는기준이 있어야됨,받아온 시퀀스번호를 토대로..)
SELECT s.name as subjectNaem, s.period as subjectDuration
    FROM tblTeacher t
        INNER JOIN tblAvlSubject a
            ON t.teacher_seq = a.teacher_seq
                INNER JOIN tblSubject s
                    ON a.subject_seq = s.subject_seq
                        WHERE t.teacher_seq = '입력받아온번호';
        
-- e. 강의실명(받아온 시퀀스번호를 토대로..)
SELECT r.roomName as className
    FROM tblTeacher t
        INNER JOIN tblTeacherCourse tc
            ON t.teacher_seq = tc.teacher_seq
                INNER JOIN tblOpenCourse oc
                    ON tc.openCourse_seq = oc. course_seq
                        INNER JOIN tblRoom r
                            ON oc.room_seq = r.room_seq
                                WHERE t.teacher_seq = '입력받아온번호';

-- f. 강의진행여부(해당 쿼리문의 날짜와 현재날짜를 비교하여 강의예정/강의중/강의종료 출력,받아온 시퀀스번호를 토대로..)

SELECT 
    CASE
        WHEN sysdate between to_date(oc.startDate, 'yyyy-mm-dd') and to_date(oc.endDate) then '강의중'
        WHEN sysdate < to_date(oc.startDate, 'yyyy-mm-dd') then '강의예정'
        WHEN sysdate > to_date(oc.endDate, 'yyyy-mm-dd') then '강의종료'
    END as courseProgressStatus
        FROM tblTeacher t
            INNER JOIN tblTeacherCourse tc
                ON t.teacher_seq = tc.teacher_seq
                    INNER JOIN tblOpenCourse oc
                        ON tc.openCourse_seq = oc.openCourse_seq
                            WHERE t.teacher_seq = 1;

-- 과정명 과정기간 교사명 강의실
SELECT c.name as courseName, oc.startDate || '~' || oc.endDate as courseDuration, t.name as teacherNaem, r.roomName as className
    FROM tblCourse c
        INNER JOIN tblOpenCourse oc
            ON c.course_seq = oc.course_seq
                INNER JOIN tblTeacherCourse tc
                    ON oc.openCourse_seq = tc.openCourse_seq
                        INNER JOIN tblTeacher t
                            ON tc.teacher_seq = t.teacher_seq
                                INNER JOIN tblRoom r
                                    ON r.room_seq = oc.room_seq;
                                        WHERE t.;

-- 1.관리자 - 1. 교사 계정 관리 - a.교사 정보 등록
-- a. 과목번호 과목명
SELECT subject_seq, name FROM tblSubject;

-- b. 강의가능과목, 입력값 받는 부분(번호 다중 입력 ex)1,2,3...  ) -> , 구분자로 나눠서 다뤄야됨

-- c. 교사명과 주민번호 유효성검사(교사명과 주민번호 동시에 같은 데이터가 있을 경우에는 데이터가 들어가면 안됨!)
SELECT COUNT(*) FROM tblTeacher WHERE name = '입력받은교사명' and pw = '입력받은주민번호(뒷자리)';

-- d. 등록(연락처는 입력받을 때 - 포함)
INSERT tblTeacher (teacher_seq, name, pw, tel)
    VALUES (teacher_seq.nextval, '입력받은교사명', '입력받은주민번호(뒷자리)', '입력받은연락처');

INSERT MAX(teacher_seq) FROM tblTeacher; -- 강의가능과목에서 해당 방금 넣은 해당 교사의 PK를 뽑아오기 위함

INSERT tblAvlSubject (avlSubject_seq, teacher_seq, subject_seq)
    VALUES (avlSubject_seq.nextval, '위의 max쿼리문 변수명', '입력받은번호'); -- 단 입력받은 번호가 과목 pk범위 안이어야함


-- 1. 관리자 - 1. 교사 계정 관리 -b. 교사 정보 수정(넘어가는 값은 해당 교사번호)
-- a. 교사명
SELECT name, pw, tel, (SELECT LISTAGG(s.name, ',') WITHIN GROUP (ORDER BY s.name)
    FROM tblTeacher t
        INNER JOIN tblAvlSubject a
            ON t.teacher_seq = a.teacher_seq
                    INNER JOIN tblSubject s
                        ON a.subject_seq = s.subject_seq
                            WHERE t.teacher_seq = '받아온 번호') as tAvlSubject
                                FROM tblTeacher WHERE teacher_seq = '받아온 번호';

-- 교사명과 주민번호 유효성검사(교사명과 주민번호 동시에 같은 데이터가 있을 경우에는 데이터가 들어가면 안됨!)
SELECT COUNT(*) as numberTeachers FROM tblTeacher WHERE name = '입력받은교사명' and pw = '입력받은주민번호(뒷자리)'; -- 1이상이면 불가능하게

-- 교사명, 주민번호, 전화번호 입력 받고, 해당 교사가 강의가능한 과목 번호들을 선택함, 가능과목 수만큼 반복해야됨
UPDATE tblTeacher 
    SET name = '입력받은 교사명', pw = '입력받은 주민번호', tel = '입력받은 번호' 
        WHERE teacher_seq = '받아온 번호';

-- 과목번호, 과목명 출력
SELECT subject_seq, name
    FROM tblSubject;

-- 받아온 번호는 교사번호, 입력한 번호는 해당 과목번호, 해당 과목번호를 입력한만큼 반복해야됨
INSERT INTO tblAvlSubject VALUES(avlSubject_seq.nextval, '받아온번호', '입력한번호');

-- 1. 관리자 - 1. 교사 계정 관리 - c. 교사 정보 삭제
-- a. 교사명
SELECT name,pw, tel, (SELECT LISTAGG(s.name, ',') WITHIN GROUP (ORDER BY s.name)
    FROM tblTeacher t
        INNER JOIN tblAvlSubject a
            ON t.teacher_seq = a.teacher_seq
                    INNER JOIN tblSubject s
                        ON a.subject_seq = s.subject_seq
                            WHERE t.teacher_seq = 1) as tAvlSubject
                                FROM tblTeacher 
                                    WHERE teacher_seq = 1;

-- e. 삭제
DELETE FROM tblTeacher WHERE teacher_seq = '받아온번호';

    
  