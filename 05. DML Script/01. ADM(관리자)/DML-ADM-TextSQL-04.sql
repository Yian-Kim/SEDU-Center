-- 1. 관리자 – 4. 성적 조회

-- 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회
-- a. 개설과정 보여줌(개설과정 PK를 넘김)
SELECT c.name, oc.startDate || '~' || oc.endDate, t.name, r.roomName
    FROM tblCourse c
        INNER JOIN tblOpenCourse oc
            ON c.course_seq = oc.course_seq
                INNER JOIN tblRoom r
                    ON oc.room_seq = r.room_seq
                        INNER JOIN tblTeacherCourse tc
                            ON tc.openCourse_seq = oc.openCourse_seq
                                INNER JOIN tblTeacher t
                                    ON tc.teacher_seq = t.teacher_seq;

-- b. 개설과정 안의 개설과목을 보여줌,개설과목번호(PK)를 넘겨줌 , 성적등록여부를 어떻게 할지?(grade가 들어가는 순간 250개로 나옴)
SELECT osm.openSubjectMgmt_seq as 개설과목번호, s.name as 과목명, osm.startDate || '~' || osm.endDate as 과목기간
--    CASE
--            WHEN g.score is not null then 'O'
--            WHEN g.score is null then 'X'
--    END
        FROM tblOpenCourse oc
            INNER JOIN tblOpenSubjectMgmt osm
                ON oc.openCourse_seq = osm.openCourse_seq
                    INNER JOIN tblSubject s
                        ON osm.subject_seq = s.subject_seq
--                            INNER JOIN tblGrade g
--                                ON g.openSubjectMgmt_seq = osm.openSubjectMgmt_seq
                                    WHERE oc.openCourse_seq = '받아온개설과정번호';

-- c. 과목에 해당하는 학생들의 성적보여주기
SELECT stu.name, g.score
    FROM tblOpenCourse oc
            INNER JOIN tblOpenSubjectMgmt osm
                ON oc.openCourse_seq = osm.openCourse_seq
                    INNER JOIN tblSubject s
                        ON osm.subject_seq = s.subject_seq
                            INNER JOIN tblGrade g
                                ON g.openSubjectMgmt_seq = osm.openSubjectMgmt_seq
                                    INNER JOIN tblRegiCourse rc
                                        ON g.regiCourse_seq = rc.regiCourse_seq
                                            INNER JOIN tblStudent stu
                                                ON rc.student_seq = stu.student_seq
                                                    WHERE oc.openCourse_seq = '받아온개설과정번호' and osm.openSubjectMgmt_seq = '받아온개설과목번호';


-- 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회(해당 번호 찝찝, 학생명으로 하자니 수강을2개이상하면 번호가 겹치고, 수강번호로 하자니 건너뛰는 번호가 나옴, 자바에서 번호 보여주고 해당 학생번호를 배열에 넣어서 보여줘도됨)
SELECT s.student_seq, s.name, s.pw, c.name, oc.startDate || '~' || oc.endDate as 과정기간, r.roomName 
    FROM tblStudent s
        INNER JOIN tblRegiCourse rc
            ON s.student_seq = rc.student_seq
                INNER JOIN tblOpenCourse oc
                    ON rc.openCourse_seq = oc.openCourse_seq
                        INNER JOIN tblCourse c
                            ON oc.course_seq = c.course_seq
                                INNER JOIN tblRoom r
                                    ON oc.room_seq = r.room_seq
                                        WHERE s.name = '입력한학생명';

-- 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생
-- a. ■ 학생이름
SELECT name
    FROM tblStudent
        WHERE student_seq = '받아온 학생번호';

-- b. 과목명 과목기간 점수 출력
SELECT s.name as 과목명, osm.startDate || '~' || osm.endDate as 과목기간, g.score as 점수
    FROM tblStudent stu
        INNER JOIN tblRegiCourse rc
            ON stu.student_seq = rc.student_seq
                INNER JOIN tblGrade g
                    ON rc.regiCourse_seq = g.regiCourse_seq
                        INNER JOIN tblOpenSubjectMgmt osm
                            ON g.openSubjectMgmt_seq = osm.openSubjectMgmt_seq
                                INNER JOIN tblSubject s
                                    ON osm.subject_seq = s.subject_seq
                                        WHERE stu.student_seq = '받아온학생번호';


select * from tblGrade;
delete from tblGrade;




