drop table board;

create table board(
	board_no int primary key, --글번호
	subject varchar2(30) not null, --제목
	writer varchar2(20) not null,--작성자
	content varchar2(50) not null,--내용
	board_date date not null--등록일
); 


--시퀀스 만들기
create sequence board_seq nocache; 

drop sequence board_seq


select * from board where upper(subject) like upper(?);

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db수업', '장희정', '잼난다', sysdate)




--댓글
create table reply(
  reply_no number primary key, --댓글번호
  reply_content varchar2(100), --댓글내용
  board_no number references board(board_no), --댓글을 달 부모글번호
  reply_regdate date --등록일
);

--댓글에서 사용할 시퀀스생성
create sequence reply_no_seq nocache;

--샘플 테스트(부모의 1번 글에 댓글은 3개 달아본다)
select * from board;
select * from reply;

insert into reply values(reply_no_seq.nextval , '1번의 댓글 1', 1 , sysdate);
insert into reply values(reply_no_seq.nextval , '1번의 댓글 2', 1 , sysdate);
insert into reply values(reply_no_seq.nextval , '1번의 댓글 3', 1 , sysdate);

commit







































