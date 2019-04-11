-- 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - a. 일괄 조회 및 수정
-- 번호 학생명 교사명 과정명 연락처 학과 출석률 상담요청일시 상담요청 내용(출석률이면 정상만 취급하는지? 조퇴나 이런건 빼고? 아직 안정함, 출석률 빼는걸 권장)
SELECT rownum, stu.name, t.name, c.name, stu.tel, stu.major, cr.requestDate, cr.requestContent
    FROM tblConsultRequest cr
        INNER JOIN tblRegiCourse rc
            ON cr.regiCourse_seq = rc.regiCourse_seq
                INNER JOIN tblOpenCourse oc
                    ON rc.openCourse_seq = oc.openCourse_seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                INNER JOIN tblTeacherCourse tc
                                    ON oc.openCourse_seq = tc.openCourse_seq
                                        INNER JOIN tblTeacher t
                                            ON tc.teacher_seq = t.teacher_seq
                                                INNER JOIN tblStudent stu
                                                    ON rc.student_seq = stu.student_seq;

-- 상담요청 번호 저장(배열)
SELECT consult_seq FROM tblConsultRequest;

-- 수정하기와 삭제하기는 해당 요청날짜가 현재시간 이전은 불가능
SELECT requestDate FROM tblConsultRequest WHERE consult_seq = '배열[입력한번호 -1]; -- 요청날짜
SELECT sysdate FROM dual; -- 현재 날짜

-- 수정하기
UPDATE tblConsultRequest SET requestDate = '입력한 요청날짜', requestContent = '입력한 요청내용'
    WHERE consult_seq = '배열[입력한번호-1]';

-- 삭제하기
DELETE FROM tblConsultRequest WHERE consult_seq = '배열[입력한번호-1];



-- 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 교사별 조회 및 수정 (53번)
-- a. 개설과정기간번호(PK) 배열에 저장
SELECT openCourse_seq FROM tblOpenCourse;

-- b. 출력구문
SELECT rownum, c.name, oc.startDate || '~' || oc.endDate as 과정기간, t.name, r.roomName
    FROM tblCourse c
        INNER JOIN tblOpenCourse oc
            ON c.course_seq = oc.openCourse_seq
                INNER JOIN tblRoom r
                    ON oc.room_seq = r.room_seq
                        INNER JOIN tblTeacherCourse tc
                            ON oc.openCourse_seq = tc.openCourse_seq
                                INNER JOIN tblTeacher t
                                    ON tc.teacher_seq = t.teacher_seq;

-- 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 교사별 조회 및 수정 – 1.선택(개설과정번호PK가 넘어옴)
-- 교사이름
SELECT t.name
    FROM tblTeacher t
        INNER JOIN tblTeacherCourse tc
            ON t.teacher_seq = tc.teacher_seq
                INNER JOIN tblOpenCourse oc
                    ON tc.openCourse_seq = oc.openCourse_seq
                        WHERE oc.openCourse_seq = '개설과정번호PK가 저장된 배열[입력한번호-1]';

-- 과정명
SELECT c.name
    FROM tblCourse c
        INNER JOIN tblOpenCourse oc
            ON c.course_seq = oc.course_seq
                WHERE oc.openCourse_seq = '개설과정번호PK가 저장된 배열[입력한번호-1]';

-- 번호, 학생명, 연락처, 학과, 상담요청일, 상담요청내용
SELECT rownum, stu.name, stu.tel, stu.major, cr.requestDate, cr.requestContent
    FROM tblStudent stu
        INNER JOIN tblRegiCourse rc
            ON stu.student_seq = rc.student_seq
                INNER JOIN tblConsultRequest cr
                    ON rc.regiCourse_seq = cr.regiCourse_seq
                        INNER JOIN tblOpenCourse oc
                            ON oc.openCourse_seq = rc.openCourse_seq
                                WHERE oc.openCourse_seq = '개설과정번호PK가 저장된 배열[입력한번호-1]';

-- 상담요청번호(PK) 배열에 저장
SELECT cr.consult_seq
    FROM tblStudent stu
        INNER JOIN tblRegiCourse rc
            ON stu.student_seq = rc.student_seq
                INNER JOIN tblConsultRequest cr
                    ON rc.regiCourse_seq = cr.regiCourse_seq
                        INNER JOIN tblOpenCourse oc
                            ON oc.openCourse_seq = rc.openCourse_seq
                                WHERE oc.openCourse_seq = '개설과정번호PK가 저장된 배열[입력한번호-1]';

-- 수정하기
UPDATE tblConsultRequest SET requestDate = '입력한 요청날짜', requestContent = '입력한 요청내용'
    WHERE consult_seq = '상담요청번호(PK) 배열[선택한번호-1]';

-- 삭제하기
DELETE FROM tblConsultRequest
    WHERE consult_seq = '상담요청번호(PK) 배열[선택한번호-1]';


-- 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 - 검색
-- 학생명 입력받음
-- 학생명 주민번호뒷자리 전화번호 등록일 상담(요청)횟수 학과, 상담요청횟수랑 학생번호 빼기
SELECT rownum, stu.name, stu.pw, stu.tel, cr.requestDate, stu.major
    FROM tblStudent stu
        INNER JOIN tblRegiCourse rc
            ON stu.student_seq = rc.student_seq
                INNER JOIN tblConsultRequest cr
                    ON rc.regiCourse_seq = cr.regiCourse_seq
                        WHERE stu.name = '입력한 이름명';

-- 상담요청번호(PK) 배열에 저장하기
SELECT cr.consult_seq
    FROM tblStudent stu
        INNER JOIN tblRegiCourse rc
            ON stu.student_seq = rc.student_seq
                INNER JOIN tblConsultRequest cr
                    ON rc.regiCourse_seq = cr.regiCourse_seq
                        WHERE stu.name = '입력한 이름명';


-- 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정
-- 입력한 학생명 출력
-- 과정명
SELECT c.name
    FROM tblCourse c
        INNER JOIN tblOpenCourse oc
            ON c.course_seq = oc.course_seq
                INNER JOIN tblRegiCourse rc
                    ON oc.openCourse_seq = rc.openCourse_seq
                        INNER JOIN tblConsultRequest cr
                            ON rc.regiCourse_seq = cr.regiCourse_seq
                                WHERE cr.consult_seq = '배열[입력받은번호-1]';

-- 내용 출력, 출석률이랑 학번 빼기
SELECT rownum, stu.name, stu.tel, stu.major, cr.requestDate, cr.requestContent
    FROM tblConsultRequest cr
        INNER JOIN tblRegiCourse rc
            ON cr.regiCourse_seq = rc.regiCourse_seq
                INNER JOIN tblOpenCourse oc
                    ON rc.openCourse_seq = oc.openCourse_seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                INNER JOIN tblStudent stu
                                    ON stu.student_seq = rc.student_seq
                                        WHERE cr.consult_seq = '배열[입력받은번호-1]';

-- 수정하기(요청번호는 삭제하기, 이미 앞에서 받아왔음)
UPDATE tblConsultRequest SET requestDate = '입력받은 요청날짜', requestContent = '입력받은 요청내용'
    WHERE consult_seq = '배열[입력받은번호-1]';

-- 삭제하기(요청번호는 삭제하기, 이미 앞에서 받아옴
DELETE FROM tblConsultRequest
    WHERE consult_seq = '배열[입력받은번호-1]';


-- 1. 관리자 – 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - a. 일괄 조회 및 수정
-- 내용 출력
SELECT rownum, record.recordDate, t.name, stu.name, request.requestContent, record.recordContent
    FROM tblConsultRecord record
        INNER JOIN tblConsultRequest request
            ON record.consult_seq = request.consult_seq
                INNER JOIN tblRegiCourse rc
                    ON request.regiCourse_seq = rc.regiCourse_seq
                        INNER JOIN tblStudent stu
                            ON rc.student_seq = stu.student_seq
                                INNER JOIN tblOpenCourse oc
                                    ON rc.openCourse_seq = oc.openCourse_seq
                                        INNER JOIN tblTeacherCourse tc
                                            ON oc.openCourse_seq = tc.openCourse_seq
                                                INNER JOIN tblTeacher t
                                                    ON tc.teacher_seq = t.teacher_seq;

-- 배열에 상담일시번호(PK) 저장하기
SELECT record_seq FROM tblConsultRecord;

-- 수정하기
UPDATE tblConsultRecord SET recordDate = '입력한 상담일시', recordContent = '입력한 상담내용'
    WHERE record_seq = '배열[입력한번호-1]';

-- 삭제하기
DELETE FROM tblConsultRecord
    WHERE record_seq = '배열[입력한번호-1]';


-- 1. 관리자 – 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 교사별 조회 및 수정(60 page)
-- 화면설계는 교사별 조회 및 수정이 아닌 개설과정별 조회 및 수정임
-- 교사명 입력받음
-- 내용 출력(번호, 교사명, 과정명, 과정기간, 강의실)
SELECT rownum, 
    FROM ;



-- 1. 관리자 – 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정
-- a. 학생명 입력받음, 이후 조건들은 입력받은 학생명 대신에 해당 조건을 달면됨
-- 번호, 학생명, 주민번호뒷자리, 전화번호, 등록일, 학과
SELECT rownum, name, pw, tel, regiDate, major
    FROM tblStudent
        WHERE name = '입력받은 학생명';

-- 배열에 학생PK 저장
SELECT student_seq 
    FROM tblStudent
        WHERE name = '입력받은 학생명';

-- 수정하기 전 해당 학생의 상담일지 내용 출력
SELECT rownum, record.recordDate, t.name, stu.name, request.requestContent, record.recordcontent
    FROM tblConsultRecord record
        INNER JOIN tblConsultRequest request
            ON record.consult_seq = request.consult_seq
                INNER JOIN tblRegiCourse rc
                    ON request.regiCourse_seq = rc.regiCourse_seq
                        INNER JOIN tblStudent stu
                            ON rc.student_seq = stu.student_seq
                                INNER JOIN tblOpenCourse oc
                                    ON oc.openCourse_seq = rc.openCourse_seq
                                        INNER JOIN tblTeacherCourse tc
                                            ON oc.openCourse_seq = tc.openCourse_seq
                                                INNER JOIN tblTeacher t
                                                    ON tc.teacher_seq = t.teacher_seq
                                                        WHERE stu.name = '강민혁';

-- 배열에 해당 상담일지번호(PK) 저장하기
SELECT record.record_seq
    FROM tblConsultRecord record
        INNER JOIN tblConsultRequest request
            ON record.consult_seq = request.consult_seq
                INNER JOIN tblRegiCourse rc
                    ON request.regiCourse_seq = rc.regiCourse_seq
                        INNER JOIN tblStudent stu
                            ON rc.student_seq = stu.student_seq
                                WHERE stu.name = '강민혁'
                                    ORDER BY record.record_seq;

-- 수정하기(상담일시는 현재날짜와 같거나 이전꺼만 수정가능, 귀찮으면 빼기 시현에는 큰 상관 없음)
UPDATE tblConsultRecord SET recordDate = '입력한 상담일시', recordContent = '입력한 상담내용'
    WHERE record_seq = '배열[입력한번호-1]';







