-- 고객 테이블
CREATE TABLE tbl_custom (
	custom_id varchar2(20) PRIMARY KEY ,  
	name varchar2(40) NOT NULL,		
	email varchar2(40),
	age number(3) DEFAULT 0,	
	reg_date date DEFAULT sysdate 
);

INSERT INTO 
	TBL_CUSTOM 
VALUES
	( 'mina012', '김미나', 'kimm@gmail.com', 20,  to_date('2022-03-10 14:23:25', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_custom 
VALUES ('hongGD', '홍길동', 'gil@korea.com', 32, to_date('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_custom 
VALUES ( 'twice', '박모모', 'momo@daum.net', 29, to_date('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO tbl_custom (custom_id,name,email)
VALUES ( 'wonder', '이나나', 'lee@naver.com');

-- 상품 테이블 :
CREATE TABLE tbl_product(
	pcode varchar2(20) PRIMARY KEY ,
	category char(2) NOT NULL,
	pname varchar2(40) NOT NULL,
	price number(9) NOT NULL 
);

INSERT INTO TBL_PRODUCT tp 
VALUES ('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO TBL_PRODUCT tp 
VALUES ('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO TBL_PRODUCT tp 
VALUES ('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO TBL_PRODUCT tp 
VALUES ('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO TBL_PRODUCT tp 
VALUES ('MANGOTK4r', 'A2', '애플망고 1kg', 32000);

--카테고리 저장 테이블
create table tbl_category(
	code char(2) primary key,
	name varchar2(20) not null);
	
insert into tbl_category values('A1','국내과일');
insert into tbl_category values('A2','수입과일');
insert into tbl_category values('B1','인스턴트');
insert into tbl_category values('B2','선물세트');
insert into tbl_category values('C1','과자류');
