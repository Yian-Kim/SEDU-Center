-- DML-ADM-TextSQL-03.sql

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








