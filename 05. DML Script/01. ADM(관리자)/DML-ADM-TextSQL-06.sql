-- 1. 관리자 - 6. 교사평가 관리 및 결과 조회
-- 유형 받는 칸을 주관식/객관식이 아닌 번호로 입력받는게 자바에서 짤 때 편함
-- ex) 1 주관식 / 2 객관식
-- 유형(번호로 입력) 으로 바꿀것

-- 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - a. 질문지 등록
INSERT INTO tblTeacherEval_Q VALUES (TeacherEval_Q.nextval, '입력받은 질문', '입력받은 유형번호');


-- 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정 및 삭제
SELECT teq.evalQ_seq, teq.question as 질문, t.type as 유형
    FROM tblTeacherEval_Q teq
        INNER JOIN tblType t
            ON teq.type_seq = t.type_seq
                ORDER BY teq.evalQ_seq;

-- 입력한 번호를 자바 변수에 저장


-- 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정(입력받은 번호가 넘어옴)
-- 질문, 유형 출력
SELECT teq.evalQ_seq, teq.question as 질문, t.type as 유형
    FROM tblTeacherEval_Q teq
        INNER JOIN tblType t
            ON teq.type_seq = t.type_seq
                WHERE evalQ_seq = '입력받은 번호';

-- 유형 입력란에 (1 주관식/ 2 객관식, 번호로 입력)으로 수정
-- 수정하기
UPDATE tblTeacherEval_Q SET question = '입력한 질문', type_seq = '입력받은 유형번호';




-- 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정 및 삭제 – 번호 선택 – 2. 삭제하기(입력받은 번호가 넘어옴)
-- 질문, 유형 출력
SELECT teq.evalQ_seq, teq.question as 질문, t.type as 유형
    FROM tblTeacherEval_Q teq
        INNER JOIN tblType t
            ON teq.type_seq = t.type_seq
                WHERE evalQ_seq = '입력받은 번호';

-- 삭제하기
DELETE FROM tblTeacher_Eval_Q
    WHERE evalQ_seq = '입력받은 번호';


-- 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제(개설과정번호 넘겨줌)
-- 평가답변을 위한 for문 범위
SELECT COUNT(*) FROM tblOpenCourse;

-- 번호, 담당교사, 진행과정명, 평가답변개수
select oc.openCourse_seq as 번호, c.name as 과정명, t.name as 교사명, 
    (SELECT COUNT(*)
        FROM tblTeacherEval_A tea
            INNER JOIN tblRegiCourse rc
                ON tea.regiCourse_seq = rc.regiCourse_seq
                    where rc.openCourse_seq = '해당개설과정 번호(for문으로 돌리기)') as 평가답변개수
                        from tblteacher t
                            inner join tblteachercourse tc
                                on t.teacher_seq = tc.teacher_seq
                                    inner join tblopencourse oc
                                        on oc.opencourse_seq = tc.opencourse_seq
                                            inner join tblcourse c
                                                on c.course_seq = oc.course_seq;

-- 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제 – 1.(상세보기), 개설과정번호 받음
-- a. 과정명
SELECT c.name
    FROM tblOpenCourse oc
        INNER JOIN tblCourse c
            ON oc.course_seq = c.course_seq
                WHERE oc.openCourse_seq = '받은 개설과정번호';

-- b. 교사명
SELECT t.name
    FROM tblOpenCourse oc
        INNER JOIN tblCourse c
            ON oc.course_seq = c.course_seq
                INNER JOIN tblTeacherCourse tc
                    ON oc.openCourse_seq = tc.openCourse_seq
                        INNER JOIN tblTeacher t
                            ON tc.teacher_seq = t.teacher_seq
                                WHERE oc.openCourse_seq = '받은 개설과정번호';

-- 매우 그렇다 그렇다 보통이다 아니다 매우아니다(한줄로 출력)
SELECT content FROM tblExample;

-- c. 평가질문 
SELECT teq.question
    FROM tblTeacherEval_Q teq
        WHERE teq.type_seq = 2;



-- 평가비율 for문 번호 범위(for문으로 1부터 순서대로 돌릴지 나중을 생각해서 각 번호를 배열에 값을 입력하여 빼내올지 선택해야됨)
SELECT COUNT(*) FROM tblExample;

-- 평가 비율
SELECT round((SELECT COUNT(*)
    FROM tblTeacherEval_A tea
        INNER JOIN tblTeacherEval_Q teq
            ON tea.evalQ_seq = teq.evalQ_seq
                INNER JOIN tblRegiCourse rc
                    ON tea.regiCourse_seq = rc.regiCourse_seq
                        WHERE tea.objective_A = 'for문으로 번호돌려야됨 1~5' and rc.openCourse_seq = '받은 개설과정번호') /(SELECT COUNT(*)
        FROM tblTeacherEval_A tea
            INNER JOIN tblRegiCourse rc
                ON tea.regiCourse_seq = rc.regiCourse_seq
                    where rc.openCourse_seq = '받은 개설과정번호'),3)*100 || '%' as 비율
    FROM dual;

-- 평가답변(개수), 혹시나 해서 남겨둠
SELECT COUNT(*)
    FROM tblTeacherEval_A tea
        INNER JOIN tblRegiCourse rc
            ON tea.regiCourse_seq = rc.regiCourse_seq
                where rc.openCourse_seq = 2;

-- 좋았던 점 아쉬운점,개선할점 출력
SELECT rownum as 번호, question as 주관식질문
    FROM tblTeacherEval_Q
        WHERE type_seq = 1;

-- 주관식 번호 저장(배열), 사용할 때 배열[입력한번호-1] 값을 넘겨줌
SELECT evalQ_seq
    FROM tblTeacherEval_Q
        WHERE type_seq = 1;

--주관식[좋았던 점], 문제번호(PK),개설과정번호(PK) 받아옴
-- 문제 출력
SELECT question
    FROM tblTeacherEval_Q
        WHERE evalQ_seq = '받아온 문제번호';

-- 번호, 내용 출력
SELECT rownum, tea.subjective_A
    FROM tblTeacherEval_A tea
        INNER JOIN tblTeacherEval_Q teq
            ON tea.evalQ_seq = teq.evalQ_seq
                WHERE teq.evalQ_seq = '받아온 문제번호';

