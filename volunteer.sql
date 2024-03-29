create table volunteer(
    v_no number(3) primary key,
    v_title varchar2(300 char),
    v_img varchar2(300char), 
    v_txt varchar2(5000char),
    v_created To_char (sysdate, "YYYY-MM-DD") ,
    v_status varchar2(30char),
    a_no number(3) not null
);

create sequence volunteer_seq;

select * from volunteer;


ALTER TABLE volunteer
ADD CONSTRAINT fk_a_no foreign KEY(a_no) references opdogaccount (a_no);


insert into volunteer values(volunteer_seq.nextval, ?,?,?,sysdate,sysdate,?,?);

drop table volunteer;

