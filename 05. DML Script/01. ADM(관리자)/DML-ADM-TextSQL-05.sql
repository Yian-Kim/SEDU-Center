-- 1. 관리자 – 5. 출결 관리 및 출결조회 - a. 학생별 조회 및 수정
SELECT rownum as 번호, s.name as 학생명, s.pw as "주민번호(뒷자리)", c.name as 과정명, oc.startDate || '~' || oc.endDate as 과정기간, r.roomName as 강의실명 
    FROM tblStudent s
        INNER JOIN tblRegiCourse rc
            ON s.student_seq = rc.student_seq
                INNER JOIN tblOpenCourse oc
                    ON rc.openCourse_seq = oc.openCourse_seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                INNER JOIN tblRoom r
                                    ON oc.room_seq = r.room_seq
                                        WHERE s.name = '입력받은 학생명';

-- 학생번호 변수에 저장
SELECT s.student_seq
    FROM tblStudent s
        INNER JOIN tblRegiCourse rc
            ON s.student_seq = rc.student_seq
                INNER JOIN tblOpenCourse oc
                    ON rc.openCourse_seq = oc.openCourse_seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                INNER JOIN tblRoom r
                                    ON oc.room_seq = r.room_seq
                                        WHERE s.name = '입력받은 학생명';


-- 1. 관리자 – 5. 출결 관리 및 출결조회 - a. 학생별 조회 – 학생 선택시(앞에서 학생번호와 조회기간 시작일, 종료일을 받아옴)
-- 기간 : 입력받은 시작일 ~ 입력받은 종료일
-- 이름
SELECT name
    FROM tblStudent
        WHERE student_seq = '받아온 학생번호';

-- 날짜, 출근시간, 퇴근시간, 근태상황
SELECT am.attendDate as 날짜, to_char(am.workOn, 'hh24:mi') as 출근시간, to_char(am.workOff, 'hh24:mi') as 퇴근시간, am.state as 근태상황
    FROM tblAttendanceMgmt am
        INNER JOIN tblRegiCourse rc
            ON am.regiCourse_seq = rc.regiCourse_seq
                WHERE rc.student_seq = '받아온 학생번호' AND attendDate BETWEEN to_date('받아온 시작일','yyyy-mm-dd') AND to_date('받아온 종료일','yyyy-mm-dd');

--입력받은 학생 번호의 수강신청 번호(자바 변수에 저장)
SELECT rc.regiCourse_seq
    FROM tblStudent s
        INNER JOIN tblRegiCourse rc
            ON s.student_seq = rc.student_seq
                INNER JOIN tblOpenCourse oc
                    ON oc.openCourse_seq = rc.openCourse_seq
                        WHERE s.student_seq = '입력받은 학생 번호' 
                            AND oc.openCourse_seq = '입력받은 개설과정번호';

-- 수정하기
UPDATE tblattendancemgmt 
    SET state = '고칠내용'
        WHERE attenddate = to_date('입력받은 날짜','yyyy-mm-dd') and regicourse_seq = '수강 신청번호';





-- 1. 관리자 – 5. 출결 관리 및 출결조회 - b. 과정별 조회
-- a. 과정번호 과정명 과정기간 교사명 강의실(개설과정번호,조회기간 입력받아 넘겨줌)
select oc.course_seq, c.name, oc.startdate || ' ~ ' || oc.enddate as 과정기간, t.name, r.roomname 
    from tblopencourse oc
        inner join tblteachercourse tc
            on tc.opencourse_seq = oc.opencourse_seq
                inner join tblteacher t
                    on t.teacher_seq = tc.teacher_seq
                        inner join tblcourse c
                            on c.course_seq = oc.course_seq
                                inner join tblroom r
                                    on r.room_seq = oc.room_seq;


--과정번호 입력을 위해 저장할 개설과정번호(자바에 저장)
select oc.course_seq
    from tblopencourse oc
        inner join tblteachercourse tc
            on tc.opencourse_seq = oc.opencourse_seq
                inner join tblteacher t
                    on t.teacher_seq = tc.teacher_seq
                        inner join tblcourse c
                            on c.course_seq = oc.course_seq
                                inner join tblroom r
                                    on r.room_seq = oc.room_seq;

--입력받을 날짜(자바 변수에 저장해야함)


--입력받은 날짜에 대한 출결 정보
--학생명 학번 출근시간 퇴근시간 근태상황(수정에서 학생이름은 겹칠 수 있기때문에 학생번호로 바꿔야됨)
select s.name, s.student_seq, to_char(admg.workon, 'hh24:mm'), to_char(admg.workoff, 'hh24:mm'), admg.state, s.student_seq
    from tblstudent s
        inner join tblregicourse rc
            on s.student_seq = rc.student_seq
                inner join tblopencourse oc
                    on oc.opencourse_seq = rc.opencourse_seq
                        inner join tblattendancemgmt admg
                            on admg.regicourse_seq = rc.regicourse_seq
                                where oc.opencourse_seq = '입력받은 개설과정번호'
                                    and admg.attendDate = to_date('입력받은 조회날짜','yyyy-mm-dd');
 

--입력받은 학생번호(자바 변수에 저장)
select s.student_seq
    from tblstudent s
        inner join tblregicourse rc
            on s.student_seq = rc.student_seq
                inner join tblopencourse oc
                    on oc.opencourse_seq = rc.opencourse_seq
                        inner join tblattendancemgmt admg
                            on admg.regicourse_seq = rc.regicourse_seq
                                where oc.opencourse_seq = '입력받은 개설과정번호'
                                    and admg.attendDate = to_date('2019-04-17','입력받은 조회날짜');

--입력받은 학생 번호의 수강신청 번호(자바 변수에 저장)
SELECT rc.regiCourse_seq
    FROM tblStudent s
        INNER JOIN tblRegiCourse rc
            ON s.student_seq = rc.student_seq
                INNER JOIN tblOpenCourse oc
                    ON oc.openCourse_seq = rc.openCourse_seq
                        WHERE s.student_seq = '입력받은 학생 번호' 
                            AND oc.openCourse_seq = '입력받은 개설과정번호';


--update tblattendancemgmt set state = '고칠 내용' where attenddate = to_date('입력받은 날짜','yyyy-mm-dd') and regicourse_seq = 수강 신청번호;












