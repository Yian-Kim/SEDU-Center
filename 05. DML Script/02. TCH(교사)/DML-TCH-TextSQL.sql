/*
문서명 : DML-TCH-TextSQL.sql (교사)
작성자 : 디비 2조
작성일자 : 2019.04.05.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL 폴더에 있는 문서들과 DML에 있는 더미데이터 문서들과 연관성이 높은 문서이다.
         추후 JDBC 작업 시 사용될 DML 쿼리문을 담았다.
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 교사 계정 -- line 23
02. 강의스케줄 조회 -- line 31
03. 성적 입력 및 조회 -- line 99
04. 출결관리 및 조회 -- line 206
05. 교사 평가 결과 조회 -- line 289
06. 상담일지 조회 -- line 397
*/

--------------------------------------------------------------------------------------------------------------------
-- 01. 교사계정
--------------------------------------------------------------------------------------------------------------------

--로그인시 id와 비밀번호 비교
select name, pw from tblTeacher;


--------------------------------------------------------------------------------------------------------------------
-- 02. 강의스케줄 조회
--------------------------------------------------------------------------------------------------------------------
-- ======= 메인 > 교사 > 교사 메뉴 > 강의스케줄
--------------------------------------------------------------------------------------------------------------------

-- 교사의 과정 (class CourseOfTeacher #1)

--create or replace view vwSchedule_course
--as
select oc.opencourse_seq, c.name, oc.startDate, oc.endDate, r.roomName from tblTeacher t --교사 계정 테이블
    inner join tblTeachercourse tc --담당과정 테이블
        on t.teacher_seq = tc.teachercourse_seq
            inner join tblOpenCourse oc --개설과정 테이블
               on oc.openCourse_seq = tc.openCourse_seq
                    inner join tblCourse c --과정 테이블
                        on oc.course_seq = c.course_seq
                            inner join tblRoom r --강의실 테이블
                                on oc.room_seq = r.room_seq;
                                    -- where t.teacher_seq = 현재 로그인 된 교사 번호 변수
 

--과정번호(자바 변수에 저장할) (class CourseOfTeacher #2)
select oc.opencourse_seq from tblTeacher t --교사 계정 테이블
    inner join tblTeachercourse tc --담당과정 테이블
        on t.teacher_seq = tc.teachercourse_seq
            inner join tblOpenCourse oc --개설과정 테이블
               on oc.openCourse_seq = tc.openCourse_seq
                    inner join tblCourse c --과정 테이블
                        on oc.course_seq = c.course_seq
                            inner join tblRoom r --강의실 테이블
                                on oc.room_seq = r.room_seq;
                        
--담당 과정의 과목 (class SubjectOfCourse)
--create or replace view vwSchedule_subject
--as
select s.name, osm.startDate, osm.endDate, s.period 
    from tblOpencourse oc -- 테이블 : 개설과정
        inner join tblOpenSubjectMgmt osm -- 테이블 : 개설 과목 관리
            on oc.openCourse_seq = osm.openCourse_seq
                inner join tblSubject s -- 테이블 : 과목
                    on s.subject_seq = osm.subject_seq
                        inner join tblteachercourse tc -- 테이블 : 담당과정
                            on oc.openCourse_seq = tc.openCourse_seq
                                inner join tblTeacher t -- 테이블 : 교사계정
                                    on t.teacher_seq = tc.teacher_seq;
                                         --where t.teacher_seq = 현재 로그인 된 교사 번호 변수
                                         --and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수

drop view vwSchedule_subject;

--------------------------------------------------------------------------------------------------------------------
-- ======= 메인 > 교사 > 교사 메뉴 > 강의스케줄 > 학생정보
--------------------------------------------------------------------------------------------------------------------
--(class StudentOfCourse #4)
--create or replace view vwSchedule_student
--as
select s.name, s.student_seq, s.tel, s.major, c.name from tblOpenCourse oc --개설과정 테이블
    inner join tblCourse c --과정 테이블
       on oc.course_seq = c.course_seq
        inner join tblRegiCourse rg --수강신청 테이블
            on rg.openCourse_seq = oc.openCourse_seq
                inner join tblStudent s --학생 테이블
                    on s.student_seq = rg.student_seq;
                        --where t.teacher_seq = 현재 로그인 된 교사 번호 변수
                        --and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수
            

--------------------------------------------------------------------------------------------------------------------
-- 03. 성적 입력 및 조회
--------------------------------------------------------------------------------------------------------------------
-- ======= 메인 > 교사 > 교사 메뉴 > 성적 입력 및 조회
--------------------------------------------------------------------------------------------------------------------

-- 성적 입출력
-- 과목명 출력  -> 해당 과목 학생 성적 출력

--과정명
-- 뷰테이블 스케쥴코스 따와서 출력

--#1 CourseOfTeacher 클래스 참조
-- 과목별 성적 출력
-- 과목명->과목명 선택->학생성적 출력
-- 과목명 : 과목번호 과목명 과목끝날짜 : 과목 선택 시 해당 과목 전체 학생 점수 출력
-- class SubjectforGrade #1
SELECT s.subject_seq, s.name, os.enddate
    FROM tblTeacherCourse tc --담당 과정 테이블
        INNER JOIN tblOpenCourse oc --개설 과정 테이블
            ON tc.openCourse_seq = oc.openCourse_seq
                INNER JOIN tblOpenSubjectMgmt os --개설과목관리 테이블
                    ON oc.openCourse_seq = os.openCourse_seq
                        INNER JOIN tblSubject s --과목 테이블
                            ON s.subject_seq = os.subject_seq;
                                -- where tc.teacher_seq = 현재 로그인 된 교사 번호 변수;
                                -- and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수

--과목 번호(자바에 저장할) : 과목명 선택할때
-- class SubjectforGrade #2
SELECT s.subject_seq
    FROM tblTeacherCourse tc --담당 과정 테이블
        INNER JOIN tblOpenCourse oc --개설 과정 테이블
            ON tc.openCourse_seq = oc.openCourse_seq
                INNER JOIN tblOpenSubjectMgmt os --개설과목관리 테이블
                    ON oc.openCourse_seq = os.openCourse_seq
                        INNER JOIN tblSubject s --과목 테이블
                            ON s.subject_seq = os.subject_seq;
                                -- where tc.teacher_seq = 현재 로그인 된 교사 번호 변수;
                                -- and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수


-- 과목 선택 후 과목당 전체 학생 성적 출력
-- 과목명 학생이름 학번 성적 
-- class GradeOutput
select st.student_seq, st.name, su.name, g.score from tblStudent st --학생 테이블
    inner join tblRegiCourse rg --수강 신청 테이블
        on st.student_seq = rg.student_seq
            inner join tblGrade g --성적정보 테이블
                on g.regiCourse_seq = rg.regiCourse_seq
                    inner join tblOpenSubjectMgmt osm --개설 과목 관리 테이블
                        on osm.openSubjectmgmt_seq = g.openSubjectmgmt_seq
                            inner join tblSubject su --과목 테이블
                                on su.subject_seq = osm.subject_seq
                                    inner join tblopencourse oc --개설과정 테이블
                                        on oc.opencourse_seq = rg.opencourse_seq
                                            inner join tblteachercourse tc --담당과정 테이블
                                                on tc.opencourse_seq = oc.opencourse_seq
                                                    inner join tblresult r --수료여부 테이블
                                                        on r.regicourse_seq = rg.regicourse_seq;
                                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수
                                                    --and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수
                                                    --and su.subject_seq = 현재 선택한 과목의 번호
                                                    --where r.state = '수료중';


-- 학생번호 입력후 성적입력 하기위한 수강신청번호(자바 변수에 저장)
-- class GradeInput
select rg.regicourse_seq from tblStudent st --학생 테이블
    inner join tblRegiCourse rg --수강 신청 테이블
        on st.student_seq = rg.student_seq
            inner join tblGrade g --성적정보 테이블
                on g.regiCourse_seq = rg.regiCourse_seq
                    inner join tblOpenSubjectMgmt osm --개설 과목 관리 테이블
                        on osm.openSubjectmgmt_seq = g.openSubjectmgmt_seq
                            inner join tblSubject su --과목 테이블
                                on su.subject_seq = osm.subject_seq
                                    inner join tblopencourse oc --개설과정 테이블
                                        on oc.opencourse_seq = rg.opencourse_seq
                                            inner join tblteachercourse tc --담당과정 테이블
                                                on tc.opencourse_seq = oc.opencourse_seq;
                                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수;
                                                    --and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수
                                                    --and su.subject_seq = 현재 선택한 과목의 번호;                        


-- 학생번호 입력후 성적입력 하기위한 개설과목관리번호(자바 변수에 저장)
-- class GradeInput
select osm.opensubjectmgmt_seq from tblStudent st --학생 테이블
    inner join tblRegiCourse rg --수강 신청 테이블
        on st.student_seq = rg.student_seq
            inner join tblGrade g --성적정보 테이블
                on g.regiCourse_seq = rg.regiCourse_seq
                    inner join tblOpenSubjectMgmt osm --개설 과목 관리 테이블
                        on osm.openSubjectmgmt_seq = g.openSubjectmgmt_seq
                            inner join tblSubject su --과목 테이블
                                on su.subject_seq = osm.subject_seq
                                    inner join tblopencourse oc --개설과정 테이블
                                        on oc.opencourse_seq = rg.opencourse_seq
                                            inner join tblteachercourse tc --담당과정 테이블
                                                on tc.opencourse_seq = oc.opencourse_seq;
                                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수;
                                                    --and oc.opencourse_seq = 현재 로그인 된 교사의 현재 과정 번호 변수
                                                    --and su.subject_seq = 현재 선택한 과목의 번호;

                                                    
--성적입력 (개설과목관리번호, 수강신청번호)                           
update tblGrade set score = 점수 
    where regiCourse_seq = 1 and openSubjectMgmt_seq = 2;



--------------------------------------------------------------------------------------------------------------------
-- 04. 출결관리 및 조회
--------------------------------------------------------------------------------------------------------------------

--class AttendanceMgmt
--기간 조회, 날짜 조회
--전체, 개인
--시작날 ~ 마지막날

--기간 조회
--전체 학생 기간 조회
select s.name, am.attendDate, am.state from tblStudent s --학생 테이블
    inner join tblRegiCourse rg --수강신청 테이블
        on s.student_seq = rg.student_seq
            inner join tblAttendanceMgmt am --근태관리 테이블
                on am.regiCourse_seq = rg.regiCourse_seq
                    inner join tblopencourse oc --개설과정 테이블
                        on oc.opencourse_seq = rg.opencourse_seq
                            inner join tblteachercourse tc --담당과정 테이블
                                on tc.opencourse_seq = oc.opencourse_seq;
                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수
                                    --and attendDate between '' and ''; 

--class AttendanceMgmt
--개인별 기간 조회를 위한 학생 이름(자바 변수에 저장)
select s.name from tblStudent s --학생 테이블
    inner join tblRegiCourse rg --수강신청 테이블
        on s.student_seq = rg.student_seq
            inner join tblAttendanceMgmt am --근태관리 테이블
                on am.regiCourse_seq = rg.regiCourse_seq
                    inner join tblopencourse oc --개설과정 테이블
                        on oc.opencourse_seq = rg.opencourse_seq
                            inner join tblteachercourse tc --담당과정 테이블
                                on tc.opencourse_seq = oc.opencourse_seq;
                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수
                                    --and attendDate between '' and ''; 

--class AttendanceMgmt
--개인별 기간 조회
select s.name, am.attendDate, am.state from tblStudent s --학생 테이블
    inner join tblRegiCourse rg --수강신청 테이블
        on s.student_seq = rg.student_seq
            inner join tblAttendanceMgmt am --근태관리 테이블
                on am.regiCourse_seq = rg.regiCourse_seq
                    inner join tblopencourse oc --개설과정 테이블
                        on oc.opencourse_seq = rg.opencourse_seq
                            inner join tblteachercourse tc --담당과정 테이블
                                on tc.opencourse_seq = oc.opencourse_seq;
                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수
                                    --and s.name = 선택하여 자바 변수에 저장한 학생 이름
                                    --and attendDate between '' and ''; 

                    
                  
--class AttendanceMgmt
--날짜 조회
-- 전체 학생 날짜 조회
select s.name from tblStudent s --학생 테이블
    inner join tblRegiCourse rg --수강신청 테이블
        on s.student_seq = rg.student_seq
            inner join tblAttendanceMgmt am --근태관리 테이블
                on am.regiCourse_seq = rg.regiCourse_seq
                    inner join tblopencourse oc --개설과정 테이블
                        on oc.opencourse_seq = rg.opencourse_seq
                            inner join tblteachercourse tc --담당과정 테이블
                                on tc.opencourse_seq = oc.opencourse_seq;
                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수
                                    --and attendDate = ''; 

--class AttendanceMgmt
--개인별 날짜 조회
select s.name, am.attendDate, am.state from tblStudent s --학생 테이블
    inner join tblRegiCourse rg --수강신청 테이블
        on s.student_seq = rg.student_seq
            inner join tblAttendanceMgmt am --근태관리 테이블
                on am.regiCourse_seq = rg.regiCourse_seq
                    inner join tblopencourse oc --개설과정 테이블
                        on oc.opencourse_seq = rg.opencourse_seq
                            inner join tblteachercourse tc --담당과정 테이블
                                on tc.opencourse_seq = oc.opencourse_seq;
                                    --where tc.teacher_seq = 현재 로그인 된 교사 번호 변수
                                    --and s.name = 선택하여 자바 변수에 저장한 학생 이름
                                    --and attendDate = ''; 



--------------------------------------------------------------------------------------------------------------------
-- 05. 교사 평가 결과 조회
--------------------------------------------------------------------------------------------------------------------

--class EvalSubjective
--주관식 좋았던 점
--create or replace view vwPros --좋았던 점 뷰
--as
select tea.subjective_A from tblTeacher t 
    inner join tblTeacherCourse tc
        on t.teacher_seq = tc.teacher_seq
            inner join tblOpenCourse oc
                on oc.openCourse_seq = tc.openCourse_seq
                    inner join tblCourse c
                        on c.course_seq = oc.course_seq
                            inner join tblRegiCourse rc
                                on rc.openCourse_seq = oc.openCourse_seq
                                    inner join tblTeacherEval_A tea
                                        on tea.regiCourse_seq = rc.regiCourse_seq
                                                    inner join tblTeacherEval_Q teq
                                                        on teq.evalQ_seq = tea.evalQ_seq
                                                                    where teq.evalQ_seq= 6
                                                                    --and t.teacher_seq = 현재 로그인 된 교사 번호 변수; 
                                                                        order by dbms_random.value;

--select rownum, p.* from vwPros p;


--class EvalSubjective
--주관식 아쉬운 점
--create or replace view vwCons --아쉬운 점 뷰
--as
select tea.subjective_A from tblTeacher t
    inner join tblTeacherCourse tc
        on t.teacher_seq = tc.teacher_seq
            inner join tblOpenCourse oc
                on oc.openCourse_seq = tc.openCourse_seq
                    inner join tblCourse c
                        on c.course_seq = oc.course_seq
                            inner join tblRegiCourse rc
                                on rc.openCourse_seq = oc.openCourse_seq
                                    inner join tblTeacherEval_A tea
                                        on tea.regiCourse_seq = rc.regiCourse_seq
                                                    inner join tblTeacherEval_Q teq
                                                        on teq.evalQ_seq = tea.evalQ_seq
                                                                    where teq.evalQ_seq= 7
                                                                    --and t.teacher_seq = 현재 로그인 된 교사 번호 변수;
                                                                        order by dbms_random.value;

--select rownum, c.* from vwCons c;



-- class DTO EvalObjective
--객관식
--create or replace view vwResult_Objective
--as
select t.teacher_seq, teq.question, tea.objective_A, tea.evalq_seq from tblTeacher t --교사계정 테이블
    inner join tblTeacherCourse tc --담당과정 테이블
        on t.teacher_seq = tc.teacher_seq
            inner join tblOpenCourse oc --개설과정 테이블
                on oc.openCourse_seq = tc.openCourse_seq
                    inner join tblCourse c --과정 테이블
                        on c.course_seq = oc.course_seq
                            inner join tblRegiCourse rc --수강신청 테이블
                                on rc.openCourse_seq = oc.openCourse_seq
                                    inner join tblTeacherEval_A tea --평가답변 테이블
                                        on tea.regiCourse_seq = rc.regiCourse_seq
                                            inner join tblExample e --보기 테이블
                                                on e.example_seq = tea.objective_A
                                                    inner join tblTeacherEval_Q teq --평가문제 테이블
                                                        on teq.evalQ_seq = tea.evalQ_seq;
                                                            --where t.teacher_seq = 현재 로그인 된 교사 번호 변수;
drop view vwResult_Objective;


--create or replace view vwPrint_Result_Objective
--as
select question,evalq_seq,
    count(case 
        when objective_A = 5 then 5
        else null
    end) / count(*) * 100 as VeryGood,
    
        count(case
        when objective_A = 4 then 4
        else null
    end) / count(*) * 100 as Good,
    
        count(case
        when objective_A = 3 then 3
        else null
    end) / count(*) * 100 as Normal,
    
        count(case
        when objective_A = 2 then 2
        else null
    end) / count(*) * 100 as Bad,
    
        count(case
        when objective_A = 1 then 1
        else null
    end) / count(*) * 100 as VeryBad
from vwResult_Objective vwro
    --where vwro.teacher_seq = 현재 로그인 된 교사 번호 변수
            group by question, evalq_seq
                order by evalq_seq asc;


--------------------------------------------------------------------------------------------------------------------
-- 06. 상담일지 조회
--------------------------------------------------------------------------------------------------------------------
-- class DTO_consult
--1. 상담 요청(조회)
select s.student_seq, s.name, s.tel, s.major, cr.requestDate, cr.requestContent from tblStudent s
    inner join tblRegiCourse rg
        on s.student_seq = rg.student_seq
            inner join tblconsultrequest cr
                on rg.regicourse_seq = cr.regicourse_seq
                    inner join tblOpenCourse oc
                        on rg.opencourse_seq = oc.opencourse_seq
                            inner join tblteachercourse tc
                                on tc.opencourse_seq = oc.opencourse_seq
                                    inner join tblTeacher t
                                        on t.teacher_seq = tc.teacher_seq;
                                            --where t.teacher_seq = 현재 로그인 된 교사 번호 변수;
                    
-- class DTO_consultFinish
--2. 상담 내역 확인(완료 목록 조회)
select s.student_seq, s.name, crecord.recorddate, crecord.recordcontent from tblStudent s
    inner join tblRegiCourse rg
        on s.student_seq = rg.student_seq
            inner join tblconsultrequest cr
                on rg.regicourse_seq = cr.regicourse_seq
                    inner join tblOpenCourse oc
                        on rg.opencourse_seq = oc.opencourse_seq
                            inner join tblteachercourse tc
                                on tc.opencourse_seq = oc.opencourse_seq
                                    inner join tblTeacher t
                                        on t.teacher_seq = tc.teacher_seq
                                            inner join tblConsultRecord crecord
                                                on crecord.consult_seq = cr.consult_seq;
                                                    --where t.teacher_seq = 현재 로그인 된 교사번호변수;
-- class DTO_consultFinish
--상담 요청 번호(변수에 저장할)                                                    
select cr.consult_seq from tblStudent s
    inner join tblRegiCourse rg
        on s.student_seq = rg.student_seq
            inner join tblconsultrequest cr
                on rg.regicourse_seq = cr.regicourse_seq
                    inner join tblOpenCourse oc
                        on rg.opencourse_seq = oc.opencourse_seq
                            inner join tblteachercourse tc
                                on tc.opencourse_seq = oc.opencourse_seq
                                    inner join tblTeacher t
                                        on t.teacher_seq = tc.teacher_seq
                                            inner join tblConsultRecord crecord
                                                on crecord.consult_seq = cr.consult_seq;
                                                    --where t.teacher_seq = 현재 로그인 된 교사번호변수;
-- class DTO_consultFinish
--상담 요청 내용(변수에 저장할)                                                    
select cr.requestcontent from tblStudent s
    inner join tblRegiCourse rg
        on s.student_seq = rg.student_seq
            inner join tblconsultrequest cr
                on rg.regicourse_seq = cr.regicourse_seq
                    inner join tblOpenCourse oc
                        on rg.opencourse_seq = oc.opencourse_seq
                            inner join tblteachercourse tc
                                on tc.opencourse_seq = oc.opencourse_seq
                                    inner join tblTeacher t
                                        on t.teacher_seq = tc.teacher_seq
                                            inner join tblConsultRecord crecord
                                                on crecord.consult_seq = cr.consult_seq; 
                                                    --where t.teacher_seq = 현재 로그인 된 교사번호변수;

                 
-- 상담 내역 입력
insert into tblconsultrecord (record_seq, recordDate, recordContent, consult_seq) 
    VALUES (ConsultRecord_seq.nextVal, to_date(sysdate,'yyyy-mm-dd'), '상담 내용 변수', '상담 요청 번호 변수');
--상담일지에 있는 상담 요청번호 = 상담 요청에 있는 번호와 같다면 요청 목록에서 사라짐.
                 
-- class DTO_consultFinish                 
--상담 내역에서 학생 검색해서 상담 내역 조회
--검색시 필요한 학생이름(자바에 저장할)
select s.name from tblStudent s
    inner join tblRegiCourse rg
        on s.student_seq = rg.student_seq
            inner join tblconsultrequest cr
                on rg.regicourse_seq = cr.regicourse_seq
                    inner join tblOpenCourse oc
                        on rg.opencourse_seq = oc.opencourse_seq
                            inner join tblteachercourse tc
                                on tc.opencourse_seq = oc.opencourse_seq
                                    inner join tblTeacher t
                                        on t.teacher_seq = tc.teacher_seq
                                            inner join tblConsultRecord crecord
                                                on crecord.consult_seq = cr.consult_seq;
                                                    --where t.teacher_seq = 현재 로그인 된 교사번호변수;
                 
                                                               
                                                                                                                  
select * from tblresult;                 
-- 성적 null인거 중도탈락으로 바꾸기                 
select st.student_seq, st.name, su.name, g.score,
    case
        when g.score is not null then g.score || '점'
        when g.score is null then '중도탈락'
    end as scoretext
from tblStudent st --학생 테이블
    inner join tblRegiCourse rg --수강 신청 테이블
        on st.student_seq = rg.student_seq
            inner join tblGrade g --성적정보 테이블
                on g.regiCourse_seq = rg.regiCourse_seq
                    inner join tblOpenSubjectMgmt osm --개설 과목 관리 테이블
                        on osm.openSubjectmgmt_seq = g.openSubjectmgmt_seq
                            inner join tblSubject su --과목 테이블
                                on su.subject_seq = osm.subject_seq
                                    inner join tblopencourse oc --개설과정 테이블
                                        on oc.opencourse_seq = rg.opencourse_seq
                                            inner join tblteachercourse tc --담당과정 테이블
                                                on tc.opencourse_seq = oc.opencourse_seq
                                                    inner join tblattendancemgmt admg
                                                        on admg.regicourse_seq = rg.regicourse_seq
                                                          -- where tc.teacher_seq = 1
                                                            -- and oc.opencourse_seq = 1
                                                               -- and su.subject_seq = 1
                                                                 --   and admg.state = '수료 중';

                 
                    