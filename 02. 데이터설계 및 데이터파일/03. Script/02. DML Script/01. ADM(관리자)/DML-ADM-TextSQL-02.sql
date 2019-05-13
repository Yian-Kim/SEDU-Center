-- 2번, 3번 통합해야됨

-- 1. 관리자 – 2. 개설 과정 및 과목 관리(개설과정PK 번호 받아옴)

SELECT rownum, c.name as courseName, oc.startDate || '~' || oc.endDate as courseduration, r.roomName as className
    ,(SELECT count(*)
        FROM tblOpenCourse oc
            INNER JOIN tblOpenSubjectMgmt osm
                ON oc.openCourse_seq = osm.openCourse_seq
                    WHERE osm.openCourse_seq = 'for문으로 개설과정만큼 돌려야됨') as subjectRegistration,
                        (SELECT count(*)
                            FROM tblOpenCourse oc
                                INNER JOIN tblRegiCourse rc
                                    ON oc.openCourse_seq = rc.openCourse_seq
                                        INNER JOIN tblStudent s
                                            ON s.student_seq = rc.student_seq
                                                WHERE oc.openCourse_seq = 'for문으로 개설과정만큼 돌려야됨') as studentNum
                                                    FROM tblOpenCourse oc
                                                        INNER JOIN tblCourse c
                                                            ON oc.course_seq = c.course_seq
                                                                INNER JOIN tblRoom r
                                                                    ON oc.room_seq = r.room_seq;     

-- for문 범위
SELECT COUNT(*) FROM tblOpenCourse;

-- 배열에 개설과정 번호 넣기
SELECT openCourse_seq FROM tblOpenCourse;

-- 1. 관리자 – 2. 개설 과정 및 과목 관리– 1. (상세보기)
-- a. 과정명
SELECT c.name as courseName
    FROM tblOpenCourse oc
        INNER JOIN tblCourse c
            ON oc.course_seq = c.course_seq
                WHERE oc.openCourse_seq = '배열[받아온번호-1]';

-- b. 교사명
SELECT t.name as teacherName
    FROM tblOpenCourse oc
        INNER JOIN tblTeacherCourse tc
            ON oc.openCourse_seq = tc.openCourse_seq
                INNER JOIN tblTeacher t
                    ON tc.teacher_seq = t.teacher_seq
                        WHERE oc.openCourse_seq = '배열[받아온번호-1]';

-- c. 강의실
SELECT r.roomName as className
    FROM tblOpenCourse oc
        INNER JOIN tblRoom r
            ON oc.room_seq = r.room_seq
                WHERE oc.openCourse_seq = '배열[받아온번호-1]';

-- d. 과정기간
SELECT startDate || '~' || endDate as courseDuration
    FROM tblOpenCourse
        WHERE openCourse_seq = '배열[받아온번호-1]';

-- e. 과목명 및 기간
SELECT s.name as subjectName, s.period || '일' as subjectDuration
    FROM tblOpenCourse oc
        INNER JOIN tblOpenSubjectMgmt osm
            ON oc.openCourse_seq = osm.openCourse_seq
                INNER JOIN tblSubject s
                    ON osm.subject_seq = s.subject_seq
                        WHERE oc.openCourse_seq = '배열[받아온번호-1]';


-- f. 학생 정보
SELECT s.name as studentName, s.pw as studentPw, s.tel as studentTel, s.regiDate as studentRegidate, r.state as completion
                        FROM tblOpenCourse oc
                            INNER JOIN tblRegiCourse rc
                                ON oc.openCourse_seq = rc.openCourse_seq
                                    INNER JOIN tblStudent s
                                        ON rc.student_seq = s.student_seq
                                            INNER JOIN tblResult r
                                                ON rc.regiCourse_seq = r.regiCourse_seq
                                                    where oc.openCourse_seq = '배열[받아온번호-1]';


-- 1. 관리자 – 2. 개설 과정 및 과목 관리– 1. (상세보기) - a. 개설과목 정보 등록(개설과정번호 받아옴, 배열[입력번호-1])
SELECT rownum, s.name as subjectName, s.period as subjectDuration-- 과목번호는 삭제가 없기 때문에 그대로 가도됨!
    FROM tblSubject s
        INNER JOIN tblOpenSubjectMgmt osm
            ON s.subject_seq = osm.subject_seq
                WHERE osm.openCourse_seq = '배열[받아온번호-1]';

-- 등록하기(강의 예정인것에 한함)
-- 조건(시간)
SELECT startDate FROM tblOpenCourse; -- 과정 시작일
SELECT sysdate FROM dual; -- 현재시간

-- 조건(같은 과목 x), 배열에 저장
SELECT subject_seq
    FROM tblOpenSubjectMgmt 
        WHERE openCourse_seq = '배열[받아온번호-1]';
        
-- 위의 배열과 입력한 과목번호를 비교해서 있는 경우에는 등록 불가

-- 등록
INSERT INTO tblOpenSubjectMgmt 
    VALUES(OpenSubjectMgmt_seq.nextval, 
        to_date((SELECT endDate
            FROM tblOpenCourse WHERE openCourse_seq = '배열[받아온번호 -1]'), 'yyyy-mm-dd')
                , to_date('입력한 종료일', 'yyyy-mm-dd'), '입력한번호(과목번호)', '배열[받아온번호-1]');


-- 1. 관리자 – 2. 개설 과정 및 과목 관리– a. 개설과정 정보 등록,  //강의실명을 입력받는게 아니라 강의실 번호를 입력받아야함
-- 번호, 과정명, 과정기간 출력 -- 과정을 추가하는 항목이 없으므로 해당 PK 그대로 사용가능
SELECT course_seq, name, period
    FROM tblCourse;

-- 등록할 수 있는 강의실 보여주기
-- 조건 : 입력한 강의실명이 현재 사용중이거나 사용 예정이면 불가능
SELECT rownum, roomName
    FROM tblRoom
        WHERE not room_seq in (SELECT r.room_seq
    FROM tblOpenCourse oc
        INNER JOIN tblRoom r
            ON oc.room_seq = r.room_seq
                WHERE to_date('2018-10-21', 'yyyy-mm-dd') between oc.startDate and oc.endDate 
                    or to_date('2019-03-03', 'yyyy-mm-dd') between oc.startDate and oc.endDate);

-- 강의실번호(PK) 배열에 저장
SELECT room_seq
    FROM tblRoom
        WHERE not room_seq in (SELECT r.room_seq
    FROM tblOpenCourse oc
        INNER JOIN tblRoom r
            ON oc.room_seq = r.room_seq
                WHERE to_date('2018-10-21', 'yyyy-mm-dd') between oc.startDate and oc.endDate 
                    or to_date('2019-03-03', 'yyyy-mm-dd') between oc.startDate and oc.endDate)
                        ORDER BY room_seq;

-- 등록하기
-- 조건 : 입력한 시작일이 현재시간보다 과거면 불가능, 자바에서 비교
SELECT sysdate FROM dual;

-- 등록
INSERT INTO tblOpenCourse
    VALUES(OpenCourse_seq.nextval, to_date('입력한 시작일','yyyy-mm-dd'), to_date('입력한 종료일','yyyy-mm-dd'), '입력한 과정번호', '강의실번호배열[입력한 강의실번호-1]');







-- a. 개설과정 출력
SELECT oc.openCourse_seq as , c.name, oc.startDate || '~' || oc.endDate, r.roomName, 
    (SELECT COUNT(*)
        FROM tblOpenCourse oc
            INNER JOIN tblOpenSubjectMgmt osm
                ON oc.openCourse_seq = osm.openCourse_seq
                    WHERE oc.openCourse_seq = '자바에서 for문으로 변수지정'),
                        (SELECT COUNT(*)
                            FROM tblOpenCourse oc
                                INNER JOIN tblRegiCourse rc
                                    ON oc.openCourse_seq = rc.openCourse_seq
                                        WHERE oc.openCourse_seq = '자바에서 for문으로 변수지정')
                                            FROM tblOpenCourse oc
                                                INNER JOIN tblCourse c
                                                    ON oc.course_seq = c.course_seq
                                                        INNER JOIN tblRoom r
                                                            ON oc.room_seq = r.room_seq;

-- for문 변수 지정 범위
SELECT COUNT(*) FROM tblOpenCourse;

SELECT COUNT(*)
    FROM tblOpenCourse oc
        INNER JOIN tblOpenSubjectMgmt osm
            ON oc.openCourse_seq = osm.openCourse_seq
                WHERE oc.openCourse_seq = 1;
                group by oc.openCourse_seq;

SELECT COUNT(*)
    FROM tblOpenCourse oc
        INNER JOIN tblRegiCourse rc
            ON oc.openCourse_seq = rc.openCourse_seq
                WHERE oc.openCourse_seq = 1;

-- 수정을 선택할시, 개설과정의 시작일이 현재 시간과 비교해서 이후일 경우에만 가능하게 해야됨
SELECT startDate
    FROM tblOpenCourse
        WHERE openCourse_seq = '선택한번호';

-- 삭제를 선택할시, 개설과정이 종료일이 현재 시간과 비교해서 이전일 경우에만 가능하게 해야됨
SELECT endDate
    FROM tblOpenCourse
        WHERE openCourse_Seq = '선택한번호';


-- 1. 관리자 – 2. 개설 과정 관리 – a. 개설과정 정보 등록
-- a. 과정번호, 과정명, 과정기간 출력
SELECT course_seq, name, period FROM tblCourse;

-- b. 개설과정 등록(과정PK를 입력받음)
INSERT INTO tblOpenCourse VALUES( OpenCourse_seq.nextval, '시작일입력값', '종료일입력값', '입력한과정PK', '입력한강의실PK');

-- 강의실 선택시 강의실 목록 보여줘야됨, 강의실명 입력으로는 할수가 없음
/*
강의실번호   강의실명
   1        1강의실    -> 이런형식으로 출력해서 보여주고
강의실선택(번호) : 입력 -> 으로 바꿔야됨
*/
SELECT room_seq, roomName FROM tblRoom;


-- 1. 관리자 – 2. 개설 과정 관리 - b. 개설과정 정보 수정(개설과정 PK를 받아옴)
-- a. 과정명, 과정기간, 강의실명, 개설과목등록여부, 학생 등록인원 출력
-- 개설과정 정보 수정을 보여주기 위해서는 개설과정 테이블에 강의예정인 정보를 추가해줘야함
SELECT c.name, oc.startDate || '~' || oc.endDate, r.roomName,
    (SELECT COUNT(*)
        FROM tblOpenCourse oc
            INNER JOIN tblOpenSubjectMgmt osm
                ON oc.openCourse_seq = osm.openCourse_seq
                    WHERE oc.openCourse_seq = '받아온 개설과정 pk 번호'),
                        (SELECT COUNT(*)
                            FROM tblOpenCourse oc
                                INNER JOIN tblRegiCourse rc
                                    ON oc.openCourse_seq = rc.openCourse_seq
                                        WHERE oc.openCourse_seq = '받아온 개설과정 pk 번호')
                                            FROM tblOpenCourse oc
                                                INNER JOIN tblRoom r
                                                    ON oc.room_seq = r.room_seq
                                                        INNER JOIN tblCourse c
                                                            ON oc.course_seq = c.course_seq
                                                                WHERE oc.openCourse_seq = '받아온 개설과정 pk 번호';

-- b. 번호, 과정명, 과정기간 출력
SELECT course_seq, name, period
    FROM tblCourse;

-- 강의실 선택시 강의실 목록 보여줘야됨, 강의실명 입력으로는 할수가 없음
/*
강의실번호   강의실명
   1        1강의실    -> 이런형식으로 출력해서 보여주고
강의실선택(번호) : 입력 -> 으로 바꿔야됨
*/

-- c. 개설과정수정
UPDATE tblOpenCourse SET startDate = '받아온시작일', endDate = '받아온종료일', course_seq = '받아온과정PK', room_seq = '받아온 강의실PK'
    WHERE openCourse_seq = '받아온번호';

-- 1. 관리자 – 2. 개설 과정 관리 - c. 개설과정 정보 삭제
-- a. 과정명, 과정기간, 강의실명, 개설과목등록여부, 학생 등록인원 출력
SELECT c.name, oc.startDate || '~' || oc.endDate, r.roomName,
    (SELECT COUNT(*)
        FROM tblOpenCourse oc
            INNER JOIN tblOpenSubjectMgmt osm
                ON oc.openCourse_seq = osm.openCourse_seq
                    WHERE oc.openCourse_seq = '받아온 개설과정 pk 번호'),
                        (SELECT COUNT(*)
                            FROM tblOpenCourse oc
                                INNER JOIN tblRegiCourse rc
                                    ON oc.openCourse_seq = rc.openCourse_seq
                                        WHERE oc.openCourse_seq = '받아온 개설과정 pk 번호')
                                            FROM tblOpenCourse oc
                                                INNER JOIN tblRoom r
                                                    ON oc.room_seq = r.room_seq
                                                        INNER JOIN tblCourse c
                                                            ON oc.course_seq = c.course_seq
                                                                WHERE oc.openCourse_seq = '받아온 개설과정 pk 번호';

-- b. 삭제
DELETE FROM tblOpenCourse
    WHERE openCourse_seq = '받아온번호';








------------------------------------------------------------------------------------------
-- 합쳐야될것
-- 1. 관리자 - 3. 개설 과목 관리 -- 개설과정 번호(PK) 넘겨줌
-- a. 번호
SELECT openSubjectMgmt_seq FROM tblOpenSubjectMgmt;

-- b. 개설과정명
SELECT c.name
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblOpenCourse oc
            ON os.openCourse_seq = oc.openCourse_seq
                INNER JOIN tblCourse c
                    ON oc.course_seq = c.course_seq
                        WHERE os.openSubjectMgmt_seq = '번호'; -- 번호는 for문으로 개설관리과목 테이블 갯수를 카운트 하여 범위지정

-- c. 과정명 범위지정
SELECT COUNT(*) FROM tblOpenSubjectMgmt;

-- d. 강의실
SELECT r.roomName
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblOpenCourse oc
            ON os.openCourse_seq = oc.openCourse_seq
                INNER JOIN tblRoom r
                    ON oc.room_seq = r.room_seq
                        WHERE os.openSubjectMgmt_seq = '번호';-- 번호는 for문으로 개설관리과목 테이블 갯수를 카운트 하여 범위지정

-- e. 개설과목명
SELECT s.name
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblSubject s
            ON os.subject_seq = s.subject_seq
                WHERE os.openSubjectMgmt_seq = '번호';-- 번호는 for문으로 개설관리과목 테이블 갯수를 카운트 하여 범위지정
                
-- f. 과목기간
SELECT s.period
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblSubject s
            ON os.subject_seq = s.subject_seq
                WHERE openSubjectMgmt_seq = '번호';-- 번호는 for문으로 개설관리과목 테이블 갯수를 카운트 하여 범위지정

-- g. 교사명
SELECT t.name
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblOpenCourse oc
            ON os.openCourse_seq = oc.openCourse_seq
                INNER JOIN tblTeacherCourse tc
                    ON oc.openCourse_seq = tc.openCourse_seq
                        INNER JOIN tblTeacher t
                            ON tc.teacher_seq = t.teacher_seq
                                WHERE openSubjectMgmt_seq = 1;


-- 1. 관리자 - 3. 개설 과목 관리 - a. 개설과목 정보 등록 -- 개설과정 번호(PK) 받아옴
-- a. 과목명번호
SELECT s.subject_seq
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblSubject s
            ON os.subject_seq = s.subject_seq
                WHERE os.openSubjectMgmt_seq = '번호';

-- b. 과목명
SELECT s.name
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblSubject s
            ON os.subject_seq = s.subject_seq
                WHERE os.openSubjectMgmt_seq = '번호';

-- c. 과목기간
SELECT s.period
    FROM tblOpenSubjectMgmt os
        INNER JOIN tblSubject s
            ON os.subject_seq = s.subject_seq
                WHERE os.openSubjectMgmt_seq = '번호';

-- d. 개설과목관리 추가(과목PK 입력, 종료일 입력), 받아온 개설과정번호에 추가하려는 개설과목이 있을 경우는 제외, 시작일은 해당 개설과정의 종료일+1일이 시작지점
INSERT INTO tblOpenSubjectMgmt VALUES(OpenSubjectMgmt_seq.nextval, '시작일', '종료일', '입력한과목pk', '받아온 개설과정번호');

-- 추가 후 해당 개설과정 종료일을 추가한 개설과목관리 종료일로 수정해야됨













