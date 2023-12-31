  CREATE TABLE "ADMIN"."VOLUNTEER" 
   (	"V_TITLE" VARCHAR2(30 CHAR) COLLATE "USING_NLS_COMP" NOT NULL ENABLE, 
	"V_IMG" VARCHAR2(300 CHAR) COLLATE "USING_NLS_COMP" NOT NULL ENABLE, 
	"V_TXT" VARCHAR2(5000 CHAR) COLLATE "USING_NLS_COMP" NOT NULL ENABLE, 
	"V_CREATED" DATE DEFAULT TRUNC(SYSDATE) NOT NULL ENABLE, 
	"V_UPDATED" DATE DEFAULT TRUNC(SYSDATE) NOT NULL ENABLE, 
	"A_NO" NUMBER(3,0) NOT NULL ENABLE
   )  DEFAULT COLLATION "USING_NLS_COMP" SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 10 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "DATA" ;


ALTER TABLE volunteer
ADD CONSTRAINT fk_opdogaccount foreign KEY(a_no) references opdogaccount (a_no);
