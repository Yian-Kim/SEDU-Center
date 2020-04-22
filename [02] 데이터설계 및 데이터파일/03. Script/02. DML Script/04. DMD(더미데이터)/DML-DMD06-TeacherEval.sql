/*
문서명 : DML-DMD06-TeacherEval.sql (6/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-06-TeacherEval.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-06-TeacherEval.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 유형 더미데이터 -- line 21
02. 보기 더미데이터 -- line 29
03. 교사평가문제 더미데이터 -- line 40
04. 교사평가답변 더미데이터 -- line 53
*/

------------------------------------------------------------------------------------------------------------------------------
-- 01. 유형 더미데이터
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblType VALUES (Type_seq.nextVal, '주관식');
INSERT INTO tblType VALUES (Type_seq.nextVal, '객관식');


------------------------------------------------------------------------------------------------------------------------------
-- 02. 보기 더미데이터
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblExample (example_seq, content) VALUES (example_seq.nextval, '매우 아니다');
INSERT INTO tblExample (example_seq, content) VALUES (example_seq.nextval, '아니다');
INSERT INTO tblExample (example_seq, content) VALUES (example_seq.nextval, '보통이다');
INSERT INTO tblExample (example_seq, content) VALUES (example_seq.nextval, '그렇다');
INSERT INTO tblExample (example_seq, content) VALUES (example_seq.nextval, '매우 그렇다');


------------------------------------------------------------------------------------------------------------------------------
-- 03. 교사평가문제 더미데이터
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'본 강의에 대해 전체적으로 만족한다.' , 2);
INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'본 강의가 나의 진로 설정에 유익하다.' , 2);
INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'본 강의의 교육내용은 적절하다.' , 2);
INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'교사는 충분한 학문적 이해와 열의를 가지고 강의하였다.' , 2);
INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'본 강좌를 다른사람에게 추천할 의향이 있다.' , 2);
INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'좋았던 점' , 1);
INSERT INTO tblTeacherEval_Q (evalQ_seq, question, type_seq) VALUES (TeacherEval_Q.nextVal,'아쉬운 점'|| '&' || '개선할 점' , 1);


------------------------------------------------------------------------------------------------------------------------------
-- 04. 교사평가답변 더미데이터
------------------------------------------------------------------------------------------------------------------------------

-- 시퀀스 1번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 1);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 1);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 1);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 1);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 1);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, '강사님이 수업할 때 모르는거 있으면 하나씩 알려주시고 반분위기도 좋았습니다, 매니저님도 상담잘해주시고 이력서 선삭도 잘해주셔서 정말 감사했습니다.', null, 6, 1);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, '배우는 종류에 비해 시간이 조금 부족하다 느껴졌습니다. 교과목의 종류를 줄이던가 기간을 늘리던가 하는 방안이 필요할거 같습니다', null, 7, 1);

-- 시퀀스 2번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 2);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 2);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 2);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 2);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 2);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '원하는 만큼을 넘어서 도움이 되었습니다.', null, 6, 2);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '자리 개선이 필요함. 뒤로 갈 수록 앞 스크린이 안보임', null, 7, 2);

-- 시퀀스 3번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 3);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 3);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 1, 3, 3);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 4, 3);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 3);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님께서 정말 잘 가르쳐 주셨는데, 덕분에 7개월 간 학원에 다니면서 많은 것을 배울 수 있어서 좋았고 감사하단 말씀 드리고 싶어요. 좋은 사람들과 만나게 되고 수업을 듣고 프로젝트를 진행하고, 매일매일이 즐겁고 행복했어요.', null, 6, 3);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '개인물품 보관함이 넉넉했으면 정말 좋을 것 같아요!!', null, 7, 3);

-- 시퀀스 4번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 4, 1, 4);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 2, 2, 4);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 4);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 4);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 4);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '좋은 선생님을 만나서 좋았습니다. 저의 실력이 향상된 것 같습니다.', null, 6, 4);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  'NCS시험이 배운수업과 너무 연관성 없이 나온 문제들밖에 없다고 생각이 들었습니다. 수업내용과 상이하거나 비슷하더라도 난이도가 천차만별이라 차라리 선생님들에게 직접 문제를 맡기시는 것도 괜찮을거라 생각합니다.', null, 7, 4);

-- 시퀀스 5번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 5);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 5);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 5);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 4, 4, 5);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 1, 5, 5);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '6개월 동안 정말 많은것을 배우고 갑니다. 학생이 궁금한점을 그냥지나치지않으시고 하나하나 이해하실때까지 설명해주시며 항상 노력하여 학생을 가르치는 강사님을 만나 너무좋았습니다. 고생하셨습니다. ', null, 6, 5);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '교육자료가 아쉬웠습니다.', null, 7, 5);

-- 시퀀스62번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 6);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 6);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 6);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 6);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 6);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님의 친절한 강의 덕분에 수업분위기가 항상 좋았고 동기들도 수업과 프로젝트를 잘 도와주어서 프로그래밍에 전혀 문외한인 비전공자들도 수업에 따라갈 수 있었습니다.', null, 6, 6);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '개인적으로 만족스러운 수업이였으나 평가 시험 과목이나 문제는 좀더 다양하게 내주셨으면 합니다.', null, 7, 6);

-- 시퀀스 7번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 7);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 2, 7);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 7);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 4, 4, 7);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 7);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '프로그래밍을 처음 배우는데 개념과 이해에 큰 도움이 됐습니다.', null, 6, 7);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '자리 개선이 필요함. 뒤로 갈 수록 앞 스크린이 안보임', null, 7, 7);

-- 시퀀스 8번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 8);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 2, 8);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 8);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 4, 8);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 8);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '7개월동안 많은 것을 배웠고 특히 선생님 감사합니다~', null, 6, 8);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '단점은 느린 인터넷, 그리고 어느정도의 공부를 하고 가야 잘 따라갈수 있다고 생각함', null, 7, 8);

-- 시퀀스 9번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 9);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 1, 2, 9);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 9);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 2, 4, 9);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 9);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '프로젝트가 진짜 많이 도움이 되었고 열심히 한다면 비전공자도 좋은 결과를 얻을수 있은 과정인 것 같습니다.', null, 6, 9);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '맨뒤에 앉을때 앞에 빔 프로젝트 하나만으론 수업을 들을수 없는거 같습니다.', null, 7, 9);

-- 시퀀스 10번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 10);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 10);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 10);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 10);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 10);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님께서 책임감이 투철하셔서 무사히 교육을 마칠 수 있었습니다.', null, 6, 10);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '자습시간이 없어서 많이 아쉬웠습니다.', null, 7, 10);

-- 시퀀스 11번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 11);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 11);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 11);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 11);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 11);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님께서 수업에 이해가 안 가는 내용이 있어 질문을 하면 꼼꼼하게 설명해주셨고, 언제나 학생들을 먼저 생각해주신다는 것을 느꼈습니다.', null, 6, 11);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '키보드가 많이 불편해요.', null, 7, 11);

-- 시퀀스 12번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 12);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 12);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 12);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 12);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 12);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '항상 열정을 가지고 강의에 임하시는 선생님께 그동안 감사했다는 말씀 드리고 싶습니다.', null, 6, 12);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '수강 과목이 너무 한정되어있습니다. 대부분 과정이 자바, 웹, 빅데이터 과정뿐이어서 어플리케이션과 파일처리 등의 추가적인 과목 개설이 필요합니다.', null, 7, 12);

-- 시퀀스 13번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 13);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 13);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 13);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 13);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 13);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '수강하기 전과 수료 후를 비교해보면 제 실력이 월등히 향상되었다는 것을 느낍니다.', null, 6, 13);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '학원 시설이 전반적으로 좋았지만 컴퓨터가 자주 멈춰서 수업 진행에 어려움이 있었습니다..', null, 7, 13);

-- 시퀀스 14번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 14);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 14);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 14);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 14);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 14);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '수료 후 좋은 친구들도 많이 알게되고 연락하며 지낼 수 있는 기회를 만들어 줘서 감사한 마음으로 수료했습니다.', null, 6, 14);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '프로젝트 위주로 커리큘럼을 분배하는 것도 좋을 것 같습니다.', null, 7, 14);

-- 시퀀스 15번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 15);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 15);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 15);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 15);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 15);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '전공자 임에도 불구하고 아무것도 할 줄 몰라 대학 4년 내내 제 자신에게 답답함을 느낄때가 많았는데 이제는 무엇이든 할 수 있다는 자신감을 얻었습니다.', null, 6, 15);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '수업에 대한 진도를 조금 더 빨리 나가고 프로젝트 수행 기간을 더 주었다면 좋을 것 같습니다.', null, 7, 15);

-- 시퀀스 16번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 16);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 16);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 3, 16);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 4, 4, 16);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 16);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '전반적으로 만족 하였습니다.', null, 6, 16);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '배우는 종류에 비해 시간이 조금 부족하다 느껴졌습니다. 교과목의 종류를 줄이던가 기간을 늘리던가 하는 방안이 필요할거 같습니다.', null, 7, 16);

-- 시퀀스 17번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 17);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 17);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 17);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 17);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 17);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님과 매니저님께서 열정적으로 도와주셔서 감사했습니다. ', null, 6, 17);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '실질적으로 배우는 내용이나, 실습과정의 내용들이 정기적으로 보는 시험과 간혹 거리가 있는 것 같습니다.', null, 7, 17);

-- 시퀀스 18번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 18);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 18);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 18);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 18);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 18);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님께서 진도와 상관없이 모든 수강생들이 다 이해 할 수 있도록 천천히 알려주셔서 너무 감사했습니다.', null, 6, 18);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '저의 조원 중 한명이 중간에 이탈하여 팀프로젝트에 지장을 초래하는 일이 있었습니다. 앞으로는 이런일을 줄일 수 있게 대책이 마련되었으면 좋겠습니다.', null, 7, 18);

-- 시퀀스 19번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 19);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 19);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 2, 3, 19);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 19);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 19);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님의 지도실력이며 보유하고 계신 실력 또한 기대했던것보다 높았습니다. 학교에서 배울수 없던 실무기술을 습득하여 좋았고 어떤 시간보다 값지고 뿌듯했습니다. ', null, 6, 19);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '짧은 시간안에 많을걸 배우다보니 1달전에 배운걸 기억하기가 힘듬', null, 7, 19);

-- 시퀀스 20번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 20);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 20);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 20);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 20);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 20);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '너무 유익한 수업이었고 실무에서 사용하는 기술들을 선생님께서 친절히 알려주셔서 너무 감사했습니다. ', null, 6, 20);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '가르쳐 주는 것엔 부족함이 없지만 받아들이는 정도는 개인차가 있었습니다.', null, 7, 20);

-- 시퀀스 21번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 21);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 21);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 21);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 21);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 21);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '수업을 듣는데 어떤 문제가 생겨서 건의를 하면 바로 조치를 취해주신 매니저님, 팀장님 감사드립니다. 너무 잘 가르쳐주셔서 감사하고 취업 성공으로 보답하겠습니다.', null, 6, 21);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '개인적으로 열심히 하려는 사람과 그렇지 않은 사람이 있었는데, 그렇지 않은 사람들이 열심히 하려는 사람을 방해하는 듯한 모습이 나와 그점이 아쉬웠습니다. ', null, 7, 21);

-- 시퀀스 22번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 22);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 22);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 22);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 22);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 22);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님이 열의를 갖고 정말 잘 가르쳐주셔서 감사했습니다. 학원 시설도 전반적으로 좋았어요.', null, 6, 22);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '시험제도는 불필요한 것 같아요.', null, 7, 22);

-- 시퀀스 23번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 23);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 2, 23);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 23);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 4, 4, 23);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 23);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님의 세심한 배려와 꼼꼼한 수업이 큰 도움이 되었습니다.', null, 6, 23);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '다른 과목들도 배우고 싶었지만, 더 배우지 못한 점이 너무나 아쉬웠습니다.', null, 7, 23);

-- 시퀀스 24번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 1, 24);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 2, 24);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 3, 24);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 4, 24);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 24);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '선생님의 자세한 설명으로 이해도 쏙쏙되고 컴퓨터에 대한 흥미를 더욱 더 가질 있게 되었습니다. 프로젝트를 하면서 실력도 많이 쌓을 수 있게 되어서 알찬 수업이었습니다!^^', null, 6, 24);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '훈련과정에 비해 학습할 수 있는 시간 및 프로젝트로 주어진 시간의 배율이 부족했던 것 같습니다.', null, 7, 24);

-- 시퀀스 25번 학생 데이터
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 2, 1, 25);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 1, 2, 25);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 3, 3, 25);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 4, 4, 25);
    
INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal, null, 5, 5, 25);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '단언컨대 정말 멋진 선생님이셨습니다.', null, 6, 25);

INSERT INTO tblTeacherEval_A (evalA_seq, subjective_A,objective_A, evalQ_seq, regiCourse_seq)
    VALUES (TeacherEval_A_seq.nextVal,  '진도가 너무 빨랐습니다.', null, 7, 25);
