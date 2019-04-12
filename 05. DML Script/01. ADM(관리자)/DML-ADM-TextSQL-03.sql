-- 1. 관리자 - 3. 학생 관리 - a. 학생 정보 전체보기
-- a. 학생명, 주민번호, 전화번호, 등록일, 수강신청횟수, 학과
-- DTO_Student
SELECT name, pw, tel, regiDate,
    (SELECT COUNT(*) 
        FROM tblStudent s
            INNER JOIN tblRegiCourse rc
                ON s.student_seq = rc.student_seq
                    WHERE s.student_seq = '자바에서for문으로 변수돌림') as numberCourseRequests , major
                        FROM tblStudent;

-- 자바에서 for문 변수 범위
-- DTO_Student
SELECT COUNT(*) as numberStudent FROM tblStudent;

-- 1. 관리자 – 3. 학생 관리 - b. 학생 정보 등록 (학생명, 주민번호, 전화번호, 학과 입력)
-- DTO_Student
INSERT INTO tblStudent
    VALUES(student_seq.nextval, '입력한 학생명', '입력한 주민번호', '입력한 전화번호', null,'입력한 학과');

-- 학생명과 주민번호가 동시에 해당 학생 테이블에 만족하는게 있으면 등록안됨
-- DTO_Student
SELECT name, pw FROM tblStudent;


-- 1. 관리자 – 3. 학생 관리 - c. 학생 정보 검색 및 수정 (선택한 해당 학생 PK번호 저장해서 다음으로 넘겨줌)
-- a. 이름 검색
-- 수강신청
-- DTO_Student
SELECT student_seq FROM tblStudent WHERE name = '입력학생명'; -- 변수에 저장

-- DTO_Student
SELECT rownum, s.name as studentName, s.pw as studentPw, s.tel as studentTel, s.regidate as studentRegidate, 
    (SELECT COUNT(*) 
        FROM tblStudent s
            INNER JOIN tblRegiCourse rc
                ON s.student_seq = rc.student_seq
                    WHERE s.student_seq = '위에서 변수에 저장한것을 하나씩 대입') as numberCourseRequests, major
                        FROM tblStudent  s
                            WHERE name = '입력학생명';

-- b. 주민번호 검색
-- DTO_Student
SELECT student_seq FROM tblStudent WHERE name = '입력주민번호'; -- 변수에 저장

-- DTO_Student
SELECT student_seq, name, pw, tel, regidate,
    (SELECT COUNT(*) 
        FROM tblStudent s
            INNER JOIN tblRegiCourse rc
                ON s.student_seq = rc.student_seq
                    WHERE s.student_seq = '위에서 변수에 저장한것을 하나씩 대입') as numberCourseRequests, major
                        FROM tblStudent 
                            WHERE pw = '입력주민번호';

-- c. 전화번호 검색
-- 수강신청
-- DTO_Student
SELECT student_seq FROM tblStudent WHERE name = '입력전화번호'; -- 변수에 저장

-- DTO_Student
SELECT student_seq, name, pw, tel, regidate,
    (SELECT COUNT(*) 
        FROM tblStudent s
            INNER JOIN tblRegiCourse rc
                ON s.student_seq = rc.student_seq
                    WHERE s.student_seq = '위에서 변수에 저장한것을 하나씩 대입') as numberCourseRequests, major
                        FROM tblStudent 
                            WHERE tel = '입력전화번호';

-- d. 등록일 검색
-- 수강신청
-- DTO_Student
SELECT student_seq FROM tblStudent WHERE name = '입력등록일'; -- 변수에 저장

-- DTO_Student
SELECT student_seq, name, pw, tel, regidate,
    (SELECT COUNT(*) 
        FROM tblStudent s
            INNER JOIN tblRegiCourse rc
                ON s.student_seq = rc.student_seq
                    WHERE s.student_seq = '위에서 변수에 저장한것을 하나씩 대입') as numberCourseRequests
                        FROM tblStudent 
                        WHERE regidate = '입력등록일';



-- 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
---- e. 수강(신청) 횟수 검색(해시코드 이용?) -- 나중에 다시 볼것
--SELECT s.student_seq
--    FROM tblStudent s
--        INNER JOIN tblRegiCourse rc
--            ON s.student_seq = rc.student_seq; -- 해시코드 키값에 들어갈 것(50개)
--
--SELECT count(*)
--    FROM tblStudent s
--        INNER JOIN tblRegiCourse rc
--            ON s.student_seq = rc.student_seq
--                --where s.student_seq = 31;
--                group by s.student_seq; -- 해시코드 값에 들어갈 것(50개)
--
---- 해시코드 값이 입력한 수강(신청)횟수와 같을 때(검색조건)
--SELECT student_seq, name, pw, tel, regidate FROM tblStudent WHERE student_seq = '해시코드 키값';
---- 수강(신청)횟수는 해시코드 값 출력
--SELECT mojor FROM tblStudent WHERE student_seq = '해시코드 키값';
-- 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!




-- f. 학과 검색
-- 수강신청
-- DTO_Student
SELECT student_seq FROM tblStudent WHERE name = '입력학과'; -- 변수에 저장

-- DTO_Student
SELECT student_seq, name, pw, tel, regidate ,
    (SELECT COUNT(*)
        FROM tblStudent s
            INNER JOIN tblRegiCourse rc
                ON s.student_seq = rc.student_seq
                    WHERE s.student_seq = '위에서 변수에 저장한것을 하나씩 대입') as numberCourseRequests, major
                        FROM tblStudent 
                            WHERE major = '입력학과';


-- b. 수정하기(수정하기 위해 입력한 학생명과 주민번호 둘다 일치하는 사람이 있으면 수정불가)
-- DTO_Student
SELECT name, pw FROM tblStudent; -- 배열이나 리스트에 넣고 하나씩 비교

-- 조건에 만족하면
-- DTO_Student
UPDATE tblStudent 
    SET name = '입력한이름', pw = '입력한 주민번호', tel = '입력한전화번호', major = '입력한학과'
        WHERE student_seq = '받아온번호값';


--  1. 관리자 – 3. 학생 관리 - c. 학생 정보 검색 및 수정 – (검색후) – 삭제 선택시
-- b. 삭제하기
-- DTO_Student
DELETE FROM tblStudent WHERE student_seq = '받아온번호값';
