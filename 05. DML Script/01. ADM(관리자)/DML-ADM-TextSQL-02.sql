SELECT teacher_seq FROM tblTeacher;

-- b. 교사명
SELECT name
    FROM tblTeacher;

-- c. 주민번호 뒷자리
SELECT pw FROM tblteacher;

-- d. 전화번호
SELECT tel FROM tblteacher;

-- e. 강의 가능 과목( for문으로 돌려야됨 변수는 교사PK번호 값과 같아야하며 교사인원수만큼 돌려야됨)
select *from tblteacher;
select *from tblavlsubject;
select *from tblsubject;

SELECT s.name
    FROM tblTeacher t
        INNER JOIN tblAvlSubject a
            ON t.teacher_seq = a.teacher_seq 
                    INNER JOIN tblSubject s
                        ON a.subject_seq = s.subject_seq
                            WHERE t.teacher_seq = '해당교사번호입력값,for문 변수';


-- 1.관리자 - 1. 교사 계정 관리 - 1.(상세보기) 번호를 입력받아옴(시퀀스)
-- a. 홍길동 님의 정보입니다.
SELECT name FROM tblTeacher WEHRE teacher_seq = '입력받아온번호';

-- b. 과정명(받아온 시퀀스번호를 토대로..)
SELECT c.name
    FROM tblTeacher t
        INNER JOIN tblTeacherCourse tc
            ON t.teacher_seq = tc.teacher_seq
                INNER JOIN tblOpenCourse oc
                    ON tc.openCourse_seq = oc.openCourse_seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                WHERE t.teacher_seq = '입력받아온번호';

-- c. 과정기간(받아온 시퀀스번호를 토대로..)
SELECT oc.startDate, oc.endDate
    FROM tblTeacher t
        INNER JOIN tblTeacherCourse tc
            ON t.teacher_seq = tc.teacher_seq
                INNER JOIN tblOpenCourse oc
                    ON tc.openCourse_seq = oc.openCourse_seq
                        WHERE t.teacher_seq = '입력받아온번호'; 
    
    
    
    
    
    
    
-------------------------------------------------------------------------------------------------
select *from tblteachercourse; 
select *from tblopencourse;
select *from tblavlsubject;
select *from tblsubject;
select *from tblCourse;
select *from tblRoom;


-- a(☆). ■ 자바 기반 융합형 SW 개발자 양성과정
select name from tblcourse where course_seq=1;

-- b(☆). 2019.01.07 ~ 2019.06.07
--  : 과정번호가 1인 과정의 시작~종료일(join?) > select
select c.name,oc.startdate,oc.enddate 
    from tblopencourse oc
        inner join tblcourse c
            on oc.opencourse_seq = c.course_seq 
                where c.course_seq=1;


--■ 과목명 및 기간 
--JAVA 프로그래밍 15일
--Oracle DBMS 18일
--웹개발 프로그래밍 46일
--Java응용프로젝트 5일
--웹 클라이언트 프로그래밍 15일
--Full-stack 응용 프로젝트 제작 12일 
select * from tblOpenSubjectMgmt;
    
select s.name, s.period
    from tblSubject s
        inner join tblOpenSubjectMgmt osm
            on s.subject_seq =osm.subject_seq
                inner join tblOpenCourse oc
                    on osm.openCourse_seq = oc.openCourse_seq
                        inner join tblcourse c
                            on oc.course_seq= c.course_seq 
                            where c.course_seq =1;
            
-- d(☆). 강의실 – 6
--  : 과정번호 1에 속한 강의실 번호? > select
select r.room_seq as 강의실
    from tblRoom r
        inner join tblOpenCourse oc
            on r.room_seq = oc.room_seq
                inner join tblCourse c
                    on oc.course_seq = c.course_seq
                        where c.course_seq=1;
                        
-- : 과정번호 1에 속한 교사명? > select
select t.name
    from tblteacher t
        inner join tblTeacherCourse tc
            on t.teacher_seq = tc.teacher_seq
                inner join tblOpenCourse oc
                    on tc.openCourse_seq = oc.openCourse_seq
                        inner join tblCourse c
                            on oc.course_seq = c.course_seq
                                where c.course_seq =1;
                                
                                
-- f(★). ■ 학생 정보
-- : 과정번호 1에 속한 모든 학생 명단 > select
select s.name, s.pw, s.tel, s.regiDate, r.state
    from tblStudent s
        inner join tblRegiCourse rc
            on s.student_seq = rc.student_seq
                inner join tblOpenCourse oc
                    on rc.openCourse_seq = oc.openCourse_seq
                        inner join tblCourse c
                            on c.course_seq =oc.course_seq
                                inner join tblResult r
                                    on r.regiCourse_seq = rc.regiCourse_seq
                                where c.course_seq=1;
                                

--번호    과정명		과정기간	강의실명	개설과목등록여부  학생 등록 인원
select count(c.name) ,c.course_seq, c.name, c.period, r.roomname ,s.name
--select distinct  count(*)
    from tblCourse c
        inner join tblOpenCourse oc
            on c.course_seq = oc.course_seq
                inner join tblRoom r
                    on oc.room_seq = r.room_seq
                        inner join tblRegiCourse rc
                            on rc.openCourse_seq = oc.openCourse_seq
                                inner join tblStudent s
                                    on s.student_seq =rc.student_seq
                                        inner join tblOpenSubjectMgmt osm
                                            on osm.openCourse_seq = oc.openCourse_seq
                                                where c.course_seq = 1
                                                    order by c.course_seq
                                                        GROUP BY s.name;
                


--번호    과정명		과정기간	강의실명	개설과목등록개수  학생 등록 인원
--번호    과정명(*)		과정기간(*)
--번호    과정명		과정기간	강의실명(*)
select  
    c.course_seq as "번호",
    c.name as "과정명",
    c.period as "과정기간",
    r.roomname as "강의실명",
    (select count(*) from tblOpenSubjectMgmt where opencourse_seq = c.course_seq) as "개설과목등록개수"
    ,s.name
    --(select count(*) from tblStudent ) as "학생 등록 인원"
from tblCourse c
    inner join tblOpenCourse oc
        on c.course_seq = oc.course_seq 
            inner join tblRoom r
                    on oc.room_seq = r.room_seq
                         inner join tblRegiCourse rc --수강신청(실제 학생)
                            on rc.openCourse_seq = oc.openCourse_seq
                                inner join tblStudent s --학생정보
                                    on s.student_seq =rc.student_seq;
--                                        inner join tblOpenSubjectMgmt osm --과목
--                                            on osm.openCourse_seq = oc.openCourse_seq;



select c.course_seq, c.name, c.period, r.roomname , s.name
    from tblCourse c --과정 정보
        inner join tblOpenCourse oc --개설과정
            on c.course_seq = oc.course_seq
                inner join tblRoom r --강의실
                    on oc.room_seq = r.room_seq
                        inner join tblRegiCourse rc --수강신청(실제 학생)
                            on rc.openCourse_seq = oc.openCourse_seq
                                inner join tblStudent s --학생정보
                                    on s.student_seq =rc.student_seq
                                        inner join tblOpenSubjectMgmt osm --과목
                                            on osm.openCourse_seq = oc.openCourse_seq
                                                where c.course_seq = 1
                                                    order by c.course_seq;
                                                      --  GROUP BY s.name;




        
select * from tblOpenCourse; --1, 2
select count(*) from tblOpenSubjectMgmt where opencourse_seq = 1; --10과목
select count(*) from tblOpenSubjectMgmt where opencourse_seq = 2; --9과목
    
    
select count(*) from 
--1. 
--1번과정에 속해있는 tblRegiCourse의 레코드 개수 = 1번 과정을 등록한 학생 수 
--2번과정에 속해있는 tblRegiCourse의 레코드 개수 = 2번 과정을 등록한 학생 수




        
    
    
    
    
    
                        
                        
