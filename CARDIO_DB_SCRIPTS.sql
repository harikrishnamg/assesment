insert into categery (cat_id,cat_title) values (1,'Beginner');
insert into categery (cat_id,cat_title) values (2,'Intermediate');
insert into categery (cat_id,cat_title) values (3,'Advanced');
commit;




INSERT INTO challange(ch_id,ch_title,cat_id) VALUES (101,'Jump Squat', 1);
INSERT INTO challange(ch_id,ch_title,cat_id) VALUES (102,'Sit Up', 1);
INSERT INTO challange(ch_id,ch_title,cat_id) VALUES (103,'Push Up', 2);
INSERT INTO challange(ch_id,ch_title,cat_id) VALUES (104,'500 Calories Run', 2);
INSERT INTO challange(ch_id,ch_title,cat_id) VALUES (105,'2.4 Km Run', 2);
INSERT INTO challange(ch_id,ch_title,cat_id) VALUES (106,'Mountain Climbers', 3);

commit;
insert into challange_results (calaries_burned,ch_id,day,rec_id,weight_loss)values('120',101,'day1',1,'50gm');
insert into challange_results (calaries_burned,ch_id,day,rec_id,weight_loss)values('150',101,'day1',2,'55gm');
commit;	

--------------------------------------------------------
--  DDL for Table CATEGERY
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CATEGERY" 
   (	"CAT_D" NUMBER, 
	"CAT_TITLE" VARCHAR2(20 BYTE)
   );

--------------------------------------------------------
--  DDL for Table CHALLANGE
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CHALLANGE" 
   (	"CH_ID" NUMBER, 
	"CH_TITLE" VARCHAR2(200 BYTE), 
	"CAT_ID" NUMBER
   ) ;

--------------------------------------------------------
--  DDL for Table CHALLANGE_RESULTS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CHALLANGE_RESULTS" 
   (	"REC_ID" NUMBER, 
	"CALARIES_BURNED" VARCHAR2(20 BYTE), 
	"CH_ID" NUMBER, 
	"WEIGHT_LOSS" VARCHAR2(20 BYTE), 
	"DAY" VARCHAR2(20 BYTE)
   )  ;
