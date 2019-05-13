/*
문서명 : DML-DMD02-BasicInfo.sql (2/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-02-BasicInfo.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-02-BasicInfo.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 과목 더미데이터 -- line 20
02. 강의실 더미데이터 -- line 85
03. 과정 더미데이터 -- line 97
*/

------------------------------------------------------------------------------------------------------------------------------------------------
-- 01. 과목 더미데이터
------------------------------------------------------------------------------------------------------------------------------------------------

insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '객체지향 프로그래밍', '25'); --1
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '데이터 베이스 구현', '8'); --2
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'JAVA 애플리케이션 구현', '18'); --3
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'JAVA 애플리케이션 통합테스트', '12'); --4
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '애플리케이션 배포', '5'); --5
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Front-end 웹 애플리케이션 구현', '16'); --6
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Back-end 웹 애플리케이션 구현', '12'); --7
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Full-stack Framework 구현', '5'); --8
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '반응형 웹 개발기법', '15'); --9
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '융합기반 웹표준 프로젝트', '24'); --10
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'NCS 소양교과', '1'); --11
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '관계형 데이터베이스', '10'); --12
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '화면 설계', '9'); --13
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹 애플리케이션', '43'); --14
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹 퍼블리싱', '10'); --15
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '구현 애플리케이션 테스트', '8'); --16
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '자바 프레임워크', '8'); --17
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '인공지능', '24'); --18
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Oracle DBMS', '18'); --19
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Fundamental Java SE', '48'); --20
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Front-end 개발', '15'); --21
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Back-end 개발', '17'); --22
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Framework', '12'); --23
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Testing' || '&' || 'Development', '14'); --24

insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Python', '15'); --25
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'JAVA 프로그래밍', '15'); --26
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '데이터베이스', '10'); -- 27
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '애플리케이션 테스트 수행', '7'); --28
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹 프로그래밍', '16'); -- 29
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '요구사항확인', '7'); --30
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Spring 개발', '9'); --31
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Spring framework 통합구현', '7'); --32
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '제이쿼리모바일', '20'); --33
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '코틀린 프로그래밍', '5'); --33
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '코틀린 안드로이드 프로그램 구현', '2'); --34
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '코틀린 활용 안드로이드 모바일 프로젝트 제작', '6'); --35
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Spring 서버 기반의 지능형 웹과 앱 통합개발 및 구현', '9'); --36
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '개발환경 설정 및 JAVA 기초', '24'); --37
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'JAVA Testing', '49'); --38
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'UI 설계 및 구현', '6'); --39
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '빅데이터분석', '7'); --40
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'R Fundamentals Application', '12'); --41
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹개발 프로그래밍', '46'); --42
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Java응용프로젝트', '5'); --43
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹 클라이언트 프로그래밍', '15'); --44
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Full-stack 응용 프로젝트 제작', '12'); --45
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Database Programming', '10'); --46
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Web Programming', '64'); --47
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹 서버 구축 실무', '3'); --48
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '파이썬을 활용한 머신러닝 분석기술', '11'); --49
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Server/client side 프로젝트', '19'); --50
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Oracle DMBS', '10');--51
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, 'Java 응용프로젝트', '5');--52
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '응용SW기초 및 프로그래밍 제작', '24'); --53
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '빅데이터 애플리케이션 구현', '54'); --54
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '애플리케이션 테스트 및 배포', '21'); --55
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹클라이언트 프로그래밍', '11'); --56
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '웹서버 프로그래밍', '50'); --57
insert into tblSubject (subject_seq, name, period) values (Subject_seq.nextval, '실무프로젝트 통합구현', '27'); --58


------------------------------------------------------------------------------------------------------------------------------------------------
-- 02. 강의실 더미데이터
------------------------------------------------------------------------------------------------------------------------------------------------

insert into tblRoom (room_seq, roomName) values (room_seq.nextval, '1 강의실');
insert into tblRoom (room_seq, roomName) values (room_seq.nextval, '2 강의실');
insert into tblRoom (room_seq, roomName) values (room_seq.nextval, '3 강의실');
insert into tblRoom (room_seq, roomName) values (room_seq.nextval, '4 강의실');
insert into tblRoom (room_seq, roomName) values (room_seq.nextval, '5 강의실');
insert into tblRoom (room_seq, roomName) values (room_seq.nextval, '6 강의실');


------------------------------------------------------------------------------------------------------------------------------------------------
-- 03. 과정 더미데이터
------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblCourse (course_seq, name, period) VALUES (Course_seq.nextVal, '자바 기반 융합형 SW 개발자 양성과정', 140); -- 1
INSERT INTO tblCourse (course_seq, name, period) VALUES (Course_seq.nextVal, '웹개발'||'&'||'머신러닝을 통한 응용SW 엔지니어링', 138); -- 2
INSERT INTO tblCourse (course_seq, name, period) VALUES (Course_seq.nextVal, 'Python'||'&'||'Java 응용SW실무개발자 양성과정', 140); -- 3
INSERT INTO tblCourse (course_seq, name, period) VALUES (Course_seq.nextVal, 'JAVA기반의 스마트 웹 앱콘텐츠 양성과정', 119); -- 4
INSERT INTO tblCourse (course_seq, name, period) VALUES (Course_seq.nextVal, '웹기반 빅데이터 분석 응용SW개발자', 158); -- 5
INSERT INTO tblCourse (course_seq, name, period) VALUES (Course_seq.nextVal, 'Java를 활용한 웹 응용SW개발자 양성과정', 111); -- 6
