/*
문서명 : DML-DMD01-Account.sql (1/7)
작성자 : 디비 2조
작성일자 : 2019.04.03.
프로젝트명 : SFT_EDC_CNT
프로그램명 : 소프트웨어교육센터 (Software Education Center)
프로그램 설명 : 소프트웨어 교육센터 시스템을 구현하기 위한 프로그램이다.
문서설명 : 본 문서는 DDL-01-Account.sql의 더미데이터를 담은 문서이다.
         (문서위치 : 04. DDL Script\DDL-01-Account.sql)
URL Link : https://github.com/xxHANIxx/SFT_EDC_CNT
*/

/*
-- INDEX
01. 관리자 계정 더미데이터 -- line 20
02. 교사 계정 더미데이터 -- line 29
03. 학생 계정 더미데이터 -- line 45
*/

------------------------------------------------------------------------------------------------------------------------------------------------
-- 01. 관리자 계정 더미데이터
------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO tblAdmin(admin_seq, id, pw) VALUES (Admin_seq.nextVal, '배성엽' , '1804666');
INSERT INTO tblAdmin(admin_seq, id, pw) VALUES (Admin_seq.nextVal, '조다미' , '1726544');
INSERT INTO tblAdmin(admin_seq, id, pw) VALUES (Admin_seq.nextVal, '홍다빈' , '1213123');


------------------------------------------------------------------------------------------------------------------------------------------------
-- 02. 교사 계정 더미데이터
------------------------------------------------------------------------------------------------------------------------------------------------

insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '김성호', '1694355', '010-5738-0947'); -- 1
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '강상구', '1789456', '010-1634-5193');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '한범준', '1563287', '010-4397-8955');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '최세현', '1473879', '010-7820-4986');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '지영진', '1786325', '010-5644-2345');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '지민수', '1715342', '010-9127-3319');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '박주영', '1362489', '010-1654-8144');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '안정민', '1882145', '010-9671-3621');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '이창민', '1556473', '010-2658-3851');
insert into tblTeacher (teacher_seq, name, pw, tel) values (teacher_seq.nextval, '손흥민', '1722103', '010-5521-1021'); -- 10


------------------------------------------------------------------------------------------------------------------------------------------------
-- 03. 학생 계정 더미데이터
------------------------------------------------------------------------------------------------------------------------------------------------

-- 시퀀스 1번 과정을 수강하는 학생들(25명)
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '강민혁', '1025642', '010-6452-4852', to_date('2018-01-11','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '권민재', '1125645', '010-6895-4212', to_date('2018-01-11','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김기현', '1105645', '010-6095-4212', to_date('2018-01-11','yyyy-mm-dd'), '토목공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김다미', '2055645', '010-2195-3012', to_date('2018-01-11','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김동환', '1950645', '010-3190-0519', to_date('2018-01-12','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김나연', '2102647', '010-4720-0856', to_date('2018-01-12','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김효은', '2115641', '010-7196-1352', to_date('2018-01-12','yyyy-mm-dd'), '영어영문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '민경희', '2015642', '010-5125-0052', to_date('2018-01-12','yyyy-mm-dd'), '한국어학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '정민지', '2600640', '010-9125-0140', to_date('2018-01-12','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '주진희', '2315642', '010-2501-1052', to_date('2018-01-12','yyyy-mm-dd'), '중어중문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '신나영', '2014642', '010-9452-0051', to_date('2018-01-12','yyyy-mm-dd'), '전자공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '박수환', '1015642', '010-1125-0052', to_date('2018-01-12','yyyy-mm-dd'), '경영학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '박성민', '1156422', '010-5552-0059', to_date('2018-01-13','yyyy-mm-dd'), '전자공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '박윤지', '2015649', '010-2122-9052', to_date('2018-01-12','yyyy-mm-dd'), '언론정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '박창휘', '1009642', '010-7005-5200', to_date('2018-01-12','yyyy-mm-dd'), '교육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '서지연', '2015649', '010-1200-0052', to_date('2018-01-12','yyyy-mm-dd'), '의류학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '정성재', '1234567', '010-1234-1234', to_date('2018-01-12','yyyy-mm-dd'), '건축학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '성태경', '1234568', '010-1234-1235', to_date('2018-01-13','yyyy-mm-dd'), '경영학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '성재윤', '1234569', '010-1234-1236', to_date('2018-01-13','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '송재영', '1234560', '010-1234-1237', to_date('2018-01-13','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '신호현', '1234561', '010-1234-1238', to_date('2018-01-13','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '신민철', '1234562', '010-1234-1239', to_date('2018-01-13','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '안상현', '1234563', '010-1234-1230', to_date('2018-01-13','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '우다훈', '1234564', '010-1234-1231', to_date('2018-01-13','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '홍세준', '1234565', '010-1234-1232', to_date('2018-01-13','yyyy-mm-dd'), '기계공학과');

-- 시퀀스 2번 과정을 수강하는 학생들(25명)
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '홍정희', '2109876', '010-1234-1233', to_date('2018-02-15','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '홍성환', '1012345', '010-1234-1123', to_date('2018-02-15','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이혜연', '2109875', '010-1234-1124', to_date('2018-02-15','yyyy-mm-dd'), '토목공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '허시현', '2055646', '010-1234-1125', to_date('2018-02-15','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '한운옥', '2109877', '010-1234-1126', to_date('2018-02-15','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '한성민', '1012346', '010-1234-1127', to_date('2018-02-15','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '한보원', '2109878', '010-1234-1128', to_date('2018-02-15','yyyy-mm-dd'), '영어영문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '하재범', '1012347', '010-1234-1129', to_date('2018-02-15','yyyy-mm-dd'), '한국어학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최철',   '1012348', '010-1234-1230', to_date('2018-02-15','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최정환', '1012349', '010-1234-1231', to_date('2018-02-15','yyyy-mm-dd'), '중어중문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최정진', '1012350', '010-1234-1232', to_date('2018-02-15','yyyy-mm-dd'), '중어중문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최정훈', '1012351', '010-1234-1235', to_date('2018-02-15','yyyy-mm-dd'), '중어중문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최재명', '1012352', '010-1234-1236', to_date('2018-02-15','yyyy-mm-dd'), '전산학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최승주', '1012353', '010-1234-1237', to_date('2018-02-15','yyyy-mm-dd'), '전산학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최소영', '2012353', '010-1234-1238', to_date('2018-02-15','yyyy-mm-dd'), '전산학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '진혜명', '2012354', '010-1234-1239', to_date('2018-02-15','yyyy-mm-dd'), '회계학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '최지원', '2012355', '010-1234-1240', to_date('2018-02-15','yyyy-mm-dd'), '회계학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '조혁진', '1012355', '010-1234-1241', to_date('2018-02-15','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '조영주', '1012356', '010-1234-1242', to_date('2018-02-15','yyyy-mm-dd'), '일어일문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '조성빈', '1012357', '010-1234-1243', to_date('2018-02-15','yyyy-mm-dd'), '러시어학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '정혜진', '2012357', '010-1234-1244', to_date('2018-02-15','yyyy-mm-dd'), '건축학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '정지원', '1012357', '010-1234-1245', to_date('2018-02-15','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '정주영', '1012358', '010-1234-1246', to_date('2018-02-15','yyyy-mm-dd'), '광고홍보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '정대화', '1012359', '010-1234-1247', to_date('2018-02-15','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '전유선', '2012359', '010-1234-1248', to_date('2018-02-15','yyyy-mm-dd'), '외식조리학과');

-- 시퀀스 3번 과정을 수강하는 학생들(25명)
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '전영은', '2012360', '010-1234-1249', to_date('2018-03-15','yyyy-mm-dd'), '호텔경영학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '장아정', '2012361', '010-1234-1250', to_date('2018-03-15','yyyy-mm-dd'), '회계학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '전한별', '2012362', '010-1234-1251', to_date('2018-03-15','yyyy-mm-dd'), '포스트모던학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임채원', '2012363', '010-1234-1252', to_date('2018-03-15','yyyy-mm-dd'), '포스트모던학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임정희', '2012364', '010-1234-1253', to_date('2018-03-15','yyyy-mm-dd'), '심리학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임영혁', '1012364', '010-1234-1254', to_date('2018-03-15','yyyy-mm-dd'), '산업공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임수지', '2012365', '010-1234-1255', to_date('2018-03-15','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임소리', '2012366', '010-1234-1256', to_date('2018-03-15','yyyy-mm-dd'), '임상병리학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '황정덕', '1012366', '010-1234-1257', to_date('2018-03-15','yyyy-mm-dd'), '광고홍보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '박윤희', '2012367', '010-1234-1258', to_date('2018-03-17','yyyy-mm-dd'), '범죄심리학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이희찬', '1012367', '010-1234-1259', to_date('2018-03-17','yyyy-mm-dd'), '외식조리학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이홍식', '1012368', '010-1234-1260', to_date('2018-03-17','yyyy-mm-dd'), '이벤트학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이효연', '1012369', '010-1234-1261', to_date('2018-03-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이혜선', '2012369', '010-1234-1262', to_date('2018-03-17','yyyy-mm-dd'), '영어영문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이혜리', '2012370', '010-1234-1263', to_date('2018-03-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이한솔', '2012371', '010-1234-1264', to_date('2018-03-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이하림', '2012372', '010-1234-1265', to_date('2018-03-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이철진', '1012372', '010-1234-1266', to_date('2018-03-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이진수', '1012373', '010-1234-1267', to_date('2018-03-17','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이지원', '2012373', '010-1234-1268', to_date('2018-03-18','yyyy-mm-dd'), '불어불문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이지언', '2012374', '010-1234-1269', to_date('2018-03-18','yyyy-mm-dd'), '산업공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이지훈', '1012374', '010-1234-1270', to_date('2018-03-18','yyyy-mm-dd'), '산업공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이지운', '1012375', '010-1234-1271', to_date('2018-03-18','yyyy-mm-dd'), '산업공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이재은', '2012375', '010-1234-1272', to_date('2018-03-18','yyyy-mm-dd'), '경영학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이지훈', '1012376', '010-1234-1273', to_date('2018-03-18','yyyy-mm-dd'), '경영정보학과');

-- 시퀀스 4번 과정을 수강하는 학생들(25명)
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이지수', '2012376', '010-1234-1274', to_date('2018-04-18','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이종현', '1012377', '010-1234-1275', to_date('2018-04-18','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이정수', '2012377', '010-1234-1276', to_date('2018-04-18','yyyy-mm-dd'), '수학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이은성', '1012378', '010-1234-1277', to_date('2018-04-18','yyyy-mm-dd'), '수학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이예찬', '1012379', '010-1234-1278', to_date('2018-04-18','yyyy-mm-dd'), '법학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이애선', '2012379', '010-1234-1279', to_date('2018-04-16','yyyy-mm-dd'), '유아교육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이수민', '2012380', '010-1234-1280', to_date('2018-04-16','yyyy-mm-dd'), '유아교육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이세진', '2012381', '010-1234-1281', to_date('2018-04-16','yyyy-mm-dd'), '회계세무학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이세라', '2012382', '010-1234-1282', to_date('2018-04-16','yyyy-mm-dd'), '전자공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이선영', '2012383', '010-1234-1283', to_date('2018-04-16','yyyy-mm-dd'), '호텔경영학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이상윤', '1012383', '010-1234-1284', to_date('2018-04-16','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이다혜', '2012384', '010-1234-1285', to_date('2018-04-16','yyyy-mm-dd'), '경영정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이다빈', '2012385', '010-1234-1286', to_date('2018-04-16','yyyy-mm-dd'), '보육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이다겸', '2012386', '010-1234-1287', to_date('2018-04-17','yyyy-mm-dd'), '언론정보학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이나리', '2012387', '010-1234-1288', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이기쁨', '2012388', '010-1234-1289', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤강민', '1012387', '010-1234-1290', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤규만', '1012388', '010-1234-1291', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤은석', '1012389', '010-1234-1292', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤혜준', '1012390', '010-1234-1293', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤영준', '1012391', '010-1234-1294', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤영호', '1012392', '010-1234-1295', to_date('2018-04-17','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '유병현', '1012393', '010-1234-1296', to_date('2018-04-17','yyyy-mm-dd'), '글로벌어문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '우다애', '2012393', '010-1234-1297', to_date('2018-04-12','yyyy-mm-dd'), '체육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이길호', '1012394', '010-1234-1298', to_date('2018-04-12','yyyy-mm-dd'), '체육학과');

-- 시퀀스 5번 과정을 수강하는 학생들(25명)
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '한성은', '2012394', '010-1234-1299', to_date('2018-05-20','yyyy-mm-dd'), '수학교육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임선주', '2012395', '010-1234-1300', to_date('2018-05-20','yyyy-mm-dd'), '수학교육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '이원주', '2012396', '010-1234-1301', to_date('2018-05-20','yyyy-mm-dd'), '사회교육학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '송은이', '2012397', '010-1234-1302', to_date('2018-05-21','yyyy-mm-dd'), '불어불문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '손재만', '1012397', '010-1234-1302', to_date('2018-05-21','yyyy-mm-dd'), '호텔이벤트학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '서미희', '2012398', '010-1234-1303', to_date('2018-05-21','yyyy-mm-dd'), '중어중문학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김하나', '2012399', '010-1234-1304', to_date('2018-05-21','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김두리', '2012400', '010-1234-1305', to_date('2018-05-21','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김세리', '2012401', '010-1234-1306', to_date('2018-05-21','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김나리', '2012402', '010-1234-1307', to_date('2018-05-22','yyyy-mm-dd'), '컴퓨터공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김민주', '2012403', '010-1234-1308', to_date('2018-05-22','yyyy-mm-dd'), '전산학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '고민경', '2012404', '010-1234-1309', to_date('2018-05-22','yyyy-mm-dd'), '전산학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '임영희', '2012405', '010-1234-1310', to_date('2018-05-22','yyyy-mm-dd'), '전산학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '엄희진', '2012406', '010-1234-1311', to_date('2018-05-22','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '엄호진', '1012406', '010-1234-1312', to_date('2018-05-22','yyyy-mm-dd'), '기계공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '양주엽', '1012407', '010-1234-1313', to_date('2018-05-22','yyyy-mm-dd'), '연극영화과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '양예은', '2012407', '010-1234-1314', to_date('2018-05-22','yyyy-mm-dd'), '연극영화과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '안지연', '2012408', '010-1234-1315', to_date('2018-05-23','yyyy-mm-dd'), '산업공학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '안수진', '2012409', '010-1234-1316', to_date('2018-05-23','yyyy-mm-dd'), '포스트모던학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '안상현', '1012409', '010-1234-1317', to_date('2018-05-23','yyyy-mm-dd'), '심리학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '배세훈', '1012410', '010-1234-1318', to_date('2018-05-23','yyyy-mm-dd'), '간호학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김지영', '2012410', '010-1234-1319', to_date('2018-05-23','yyyy-mm-dd'), '한의예과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '윤지민', '1012411', '010-1234-1320', to_date('2018-05-23','yyyy-mm-dd'), '범죄심리학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '김주민', '1012412', '010-1234-1321', to_date('2018-05-23','yyyy-mm-dd'), '우주과학과');
INSERT INTO tblstudent VALUES ( student_seq.NEXTVAL, '간미연', '2012413', '010-1234-1322', to_date('2018-05-23','yyyy-mm-dd'), '생명공학과');
