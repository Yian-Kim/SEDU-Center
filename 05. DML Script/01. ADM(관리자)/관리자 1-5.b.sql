--관리자 1-5-b

--b눌렀을 때 출력화면
-- 과정번호 과정명 과정기간 교사명 강의실
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
--학생명 학번 출근시간 퇴근시간 근태상황
select s.name, s.student_seq, to_char(admg.workon, 'hh24:mm'), to_char(admg.workoff, 'hh24:mm'), admg.state from tblstudent s
    inner join tblregicourse rc
        on s.student_seq = rc.student_seq
            inner join tblopencourse oc
                on oc.opencourse_seq = rc.opencourse_seq
                    inner join tblattendancemgmt admg
                        on admg.regicourse_seq = rc.regicourse_seq;
                            --where oc.opencourse_seq = 자바에 저장된 개설과정번호
                            --and admg.attendDate = 입력받은 날짜
 

--입력받은 학생번호(자바 변수에 저장)

--입력받은 학생 번호의 수강신청 번호(자바 변수에 저장)
select rc.regicourse_seq from tblstudent s
    inner join tblregicourse rc
        on s.student_seq = rc.student_seq
            inner join tblopencourse oc
                on oc.opencourse_seq = rc.opencourse_seq
                    inner join tblattendancemgmt admg
                        on admg.regicourse_seq = rc.regicourse_seq;
                        --where s.student_seq = 입력받은 학생 번호(자바 변수);


--update tblattendancemgmt set state = '고칠 내용' where attenddate = 입력받은 날짜 and regicourse_seq = 수강 신청번호;












