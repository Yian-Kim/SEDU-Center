-- DML-STD-TextSQL.sql
-- 성적100% -> 80:20


--●1. 학생은 학생계정으로 로그인을 해야한다.
select student_seq 
    from tblStudent 
        where name = 'reader.readline() > 사용자이름' 
            and pw = 'reader.readline() > 비밀번호(주민번호 7자리)' ;




--●2. 시스템은 로그인에 성공한 학생에게 해당 학생에 대한 기본정보를 보여준다.
--  (출력될 기본정보: 학생번호(seq), 수강과정명, 과정 기간, 강의실, 담당 교사명)

--①
select 
    s.student_seq as 학번, s.name as 학생명, 
    c.name as 과정명, o.startdate as 시작일, o.enddate as 종료일, 
    r.roomname as 강의실명, t.name as 선생님  
from tblstudent s
    inner join tblRegiCourse regi 
        on s.student_seq = regi.student_seq
            inner join tblOpenCourse o
                on regi.opencourse_seq = o.opencourse_seq
                    inner join tblroom r
                        on r.room_seq = o.room_seq
                            inner join tblCourse c
                                on c.course_seq = o.course_seq
                                    inner join tblTeacherCourse tc
                                        on o.opencourse_seq=tc.opencourse_seq
                                            inner join tblTeacher t
                                                on t.teacher_seq = tc.teacher_seq;




--●3. 성적조회 > 과목별 성적을 조회한다 
--  - 로그인한 특정 학생 1명에 대한 정보만을 뽑아옴
--  - 출결(근태)이 부분에 있어 JAVA 구현 시, 집계함수이용할 것 > 서브쿼리 (조인X)
--  - 성적 100%
--  -★☆★☆ 수정사항[성적 80% + 출결 20%] ★☆★☆
-- 과목번호, 과목명, 과목시작일, 과목종료일, 교사명, 시험날짜, 시험, 출결, 총점 => 가상컬럼(SQL쿼리 추가필요)
select 
    sub.subject_seq, sub.name, os.startdate, os.enddate, t.name, g.score
from tblstudent s
    inner join tblRegiCourse regi --수강신청
        on s.student_seq = regi.student_seq
            inner join tblOpenCourse o --개설과정
                on regi.opencourse_seq = o.opencourse_seq
                    inner join tblCourse c --전체과정
                        on c.course_seq = o.course_seq
                              inner join tblTeacherCourse tc --담당과정
                                  on o.opencourse_seq=tc.opencourse_seq
                                       inner join tblTeacher t --선생님정보
                                           on t.teacher_seq = tc.teacher_seq
                                                inner join tblOpenSubjectMgmt os--개설과목관리
                                                    on o.opencourse_seq = os.opencourse_seq     
                                                        inner join tblsubject sub --과목
                                                            on sub.subject_seq = os.subject_seq
                                                                  inner join tblgrade g --성적
                                                                       on g.opensubjectmgmt_seq = os.opensubjectmgmt_seq
                                                                          --  inner join tblattendancemgmt att
                                                                            --   on att.regicourse_seq = regi.regicourse_seq
                                                                                    where s.name = '강민혁';




-- ●4. 한 학생(강민혁학생)의 전체출결을 조회한다. 
--  - 현재 3,4월달의 근태정보만 더미정보로 나타나있기 때문에 결과를 보여줄 때 전체인것처럼 잘 만들어서 보여줘야할듯 
select att.attenddate, att.workon, att.workoff, att.state  
from  tblstudent s
    inner join tblregicourse regi 
        on s.student_seq = regi.student_seq
            inner join tblopencourse o
                on o.opencourse_seq = regi.opencourse_seq
                    inner join tblattendancemgmt att
                        on att.regicourse_seq = regi.regicourse_seq
                            where s.name = '강민혁'
                                order by att.attenddate;
 
 
 
 
 
-- ●5. 한 학생의 월간출결을 조회한다.
--   - 현재 3,4월달의 근태정보만 더미정보에 존재
select att.attenddate, att.workon, att.workoff, att.state  
from  tblstudent s
    inner join tblregicourse regi 
        on s.student_seq = regi.student_seq
            inner join tblopencourse o
                on o.opencourse_seq = regi.opencourse_seq
                    inner join tblattendancemgmt att
                        on att.regicourse_seq = regi.regicourse_seq
                            where substr(att.attenddate,4,2)='입력한 숫자' ;
                            -- 숫자 입력 시, 1의 자리수 달은 03,04,...표기
                            -- 입력한 숫자의 경우 월을 의미함.




-- ●6. 한 학생의 일별출결을 조회한다.
select att.attenddate, att.workon, att.workoff, att.state  
from  tblstudent s
    inner join tblregicourse regi 
        on s.student_seq = regi.student_seq
            inner join tblopencourse o
                on o.opencourse_seq = regi.opencourse_seq
                    inner join tblattendancemgmt att
                        on att.regicourse_seq = regi.regicourse_seq;
                            where s.name = '강민혁'  and '날짜지정' 
                            --특정학생이름과 지정될 날짜
                            --강민혁, 날짜지정의 경우 임시로 넣어놓은 값이며 실제는 사용자를 통해 입력받을 값이다.
                                    order by att.attenddate;
--날짜지정쿼리
--19,03,03은 임시로 넣어 놓은 값이며 실제는 자바에서 사용자를 통해 입력받을 값이다 
select * from tblattendancemgmt 
    where substr(attenddate,1,2)=19 
        and substr(attenddate,4,2)=03 and substr(attenddate,7,2)=03 ;




--●7. 교사평가
--   1.조건검사: sysdate > o.enddate
--   조건에 맞는 학생에 한하여 교사평가를 진행할 수 있다.(수료생)
--   수료학생: 현재 DB상에 수료한 학생이 없음 => 따로 데이터 만들지 않고 컴퓨터 시간 조정으로 구현. ★★★
--   수료학생이 아닌 경우 조회
select s.name, c.name, o.enddate 
    from tblstudent s
        inner join tblregicourse regi
            on s.student_seq = regi.student_seq
                inner join tblresult r
                    on regi.regicourse_seq = r.regicourse_seq
                        inner join tblopencourse o
                            on o.opencourse_seq = regi.opencourse_seq
                                inner join tblcourse c
                                    on c.course_seq = o.course_seq
                                        where s.name = '강민혁'
                                            and sysdate < o.enddate ;
--  2-1. 수료중인 학생: 교사평가 불가
--  2-2. 수료한 학생: 교사평가 가능   
--"평가일시"의 경우 JAVA를 이용하여 입력한 날짜를 기록하도록 설정(응요프로그램에서 구현)
--"과정명", "교사명" 출력을 위한 테이블 셀렉 [평과결과상단에 선출력될 정보]
select s.name , c.name, t.name 
    from tblstudent s --학생
        inner join tblregicourse regi --수강신청
            on s.student_seq = regi.student_seq
                inner join tblresult r --결과(수료여부)
                    on regi.regicourse_seq = r.regicourse_seq
                        inner join tblopencourse o --개설과정
                            on o.opencourse_seq = regi.opencourse_seq
                                inner join tblcourse c --과정
                                    on c.course_seq = o.course_seq
                                    
                                        inner join tblteacherCourse tc
                                            on tc.opencourse_seq = o.opencourse_seq
                                                inner join tblTeacher t
                                                    on t.teacher_seq=tc.teacher_seq  
                                                        where s.name = '강민혁'
                                                           and sysdate < o.enddate ;
                                                           

-- ⓐ객관식
--   ⓐ-1 : 객관식 문제의 보기 출력
select * from tblExample;


--   ⓐ-2 : 객관식 문제 & 답변 결과 출력  
select teq.evalq_seq,teq.question, tea.objective_a, ex.content
    from tblstudent s --학생
        inner join tblregicourse regi --수강신청
            on s.student_seq = regi.student_seq
                inner join tblresult r  --수료여부
                    on regi.regicourse_seq = r.regicourse_seq
                        inner join tblopencourse o --개설과정
                            on o.opencourse_seq = regi.opencourse_seq
                                inner join tblcourse c      --과정
                                    on c.course_seq = o.course_seq 
                                        inner join tblteacherEval_A tea --평가답변
                                            on tea.regicourse_seq = regi.regicourse_seq
                                                inner join tblteachereval_q teq--평가문제
                                                    on teq.evalQ_seq = tea.evalQ_seq
                                                        inner join tblExample ex --보기
                                                            on ex.example_seq = tea.objective_a
                                                        where TEA.objective_A is not null
                                                        order by  tea.evalq_seq;
                                            
-- ⓑ주관식
select teq.evalq_seq, teq.question,tea.subjective_a
    from tblstudent s --학생
        inner join tblregicourse regi --수강신청
            on s.student_seq = regi.student_seq
                inner join tblresult r  --수료여부
                    on regi.regicourse_seq = r.regicourse_seq
                        inner join tblopencourse o --개설과정
                            on o.opencourse_seq = regi.opencourse_seq
                                inner join tblcourse c      --과정
                                    on c.course_seq = o.course_seq 
                                        inner join tblteacherEval_A tea --평가답변
                                            on tea.regicourse_seq = regi.regicourse_seq
                                                inner join tblteachereval_q teq--평가문제
                                                    on teq.evalQ_seq = tea.evalQ_seq    
                                                        where tea.subjective_a is not null
                                                            order by tea.evalq_seq;
    
-------------------------------------------------------------------        
--객관식 답변 입력시 사용될 insert문 예제
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 1); 

--주관식 답변 입력시 사용될 insert문 예제
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, '입력하고자하는 평가내용', null, 6, 1); --6: 좋았던점/7: 아쉬운점+개선할점
    
    
                                                       
                                                              
--●8. 상담신청
-- - 예) 이다현 학생의 담당교사는 박세인 교사로 결정되어 있으므로 상담 신청 시 자동적으로 박세인 교사로 신청접수된다.
select s.student_seq, s.name, cr.requestDate, cr.requestcontent 
from tblstudent s
    inner join tblregicourse regi
        on s.student_seq = regi.student_seq
            inner join tblConsultRequest cr
                on cr.regicourse_seq = regi.regicourse_seq
                    inner join tblOpenCourse o
                        on o.openCourse_seq = regi.openCourse_seq
                            inner join tblTeacherCourse tc
                                on tc.openCourse_seq = o.openCourse_seq
                                    inner join tblTeacher t
                                        on t.teacher_seq = tc.teacher_seq;




--●9. 상담일지조회
--  - 상담이 완료된 상담내역에 대해 학생이 조회할 수 있다.
--  ⓐ 상담을 시행한 교사 + 과정!
select regi.student_seq, s.name, c.name, t.name
from  tblRegiCourse regi
    inner join tblOpenCourse o
        on o.opencourse_seq = regi.openCourse_seq
            inner join  tblTeacherCourse tc
                 on tc.openCourse_seq = o.openCourse_seq
                     inner join tblTeacher t
                         on t.teacher_seq = tc.teacher_seq
                            inner join tblCourse c
                                on c.course_seq = o.course_seq
                                    inner join tblstudent s
                                        on s.student_seq = regi.student_seq;

--  ⓑ 상담요청에 따른 일지조회
select 
    s.student_seq, s.name, creq.requestdate, crd.recorddate,
    creq.requestcontent, crd.recordcontent   
from tblstudent s --학생
    inner join tblregicourse regi   --수강신청
        on s.student_seq = regi.student_seq
            inner join tblConsultRequest creq -- 상담요청
                on creq.regicourse_seq = regi.regicourse_seq
                    inner join tblConsultRecord crd --상담일지
                        on crd.consult_seq = creq.consult_seq;
                
 
 
 
 --●10. 과정 및 과목 조회
 --어떤학생이
 select * from tblstudent s
    inner join tblRegiCourse regi
        on regi.student_seq = s.student_seq;
        
 --수강중인 과정, 담당교사, 강의실정보
 select c.name, t.name, r.roomname
 from tblOpenCourse o
    inner join tblcourse c
        on c.course_seq= o.course_seq
            inner join tblroom r
                on r.room_seq = o.room_seq
                    inner join tblTeacherCourse tc
                        on o.opencourse_seq = tc.opencourse_seq
                            inner join tblteacher t
                                on t.teacher_seq = tc.teacher_seq;
 
 --과목정보 : 과목번호, 과목명, 과목시작 및 종료일
 select c.course_seq, c.name,  s.subject_seq,s.name, os.startdate, os.enddate 
 from tblcourse c
    inner join tblopencourse o
        on c.course_seq = o.course_seq
            inner join tblOpenSubjectMgmt os
                on  o.opencourse_seq = os.opencourse_seq
                    inner join tblSubject s
                        on s.subject_seq=os.subject_seq
                            order by c.course_seq,  s.subject_seq;
 
 
 
 
 
 
 
 
 
