/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/08/2018 14:42:03                          */
/*==============================================================*/


drop table if exists ADMINST;

drop table if exists BEACON;

drop table if exists BEACONLOYALITETYPE;

drop table if exists CAMPAIGNCONTENT;

drop table if exists CAMPAIGNCONTENTTYPE;

drop table if exists COMPANY;

drop table if exists CRITERIA;

drop table if exists CUSTOMER;

drop table if exists EARNINGRULE;

drop table if exists EXCHANGEPOINT;

drop table if exists LEVELS;

drop table if exists LOYALITYPOINT;

drop table if exists LOYALTYTYPE;

drop table if exists MANAGER;

drop table if exists PLACE;

drop table if exists REWARD;

drop table if exists REWARDTYPE;

drop table if exists SUBSCRIPTION;

drop table if exists SUPERADMIN;

drop table if exists USERS;

drop table if exists VISIT;

/*==============================================================*/
/* Table: ADMINST                                               */
/*==============================================================*/
create table ADMINST
(
   ID                   varchar(8) not null,
   IDCOMPANY            varchar(8) not null,
   LASTNAME             varchar(30),
   FIRSTNAME            varchar(30),
   ADDRESS              varchar(50),
   EMAIL                varchar(30),
   PHONENUMBER          varchar(15),
   PASSWORD             varchar(100),
   CREATIONDATE         date,
   GENDER               int,
   PROFIL               varchar(50),
   STATUS               int,
   ACTIVE				int,
   IDPLACE              varchar(8),
   primary key (ID)
);

/*==============================================================*/
/* Table: BEACON                                                */
/*==============================================================*/
create table BEACON
(
   IDBEACON             varchar(8) not null,
   IDPLACE              varchar(8) not null,
   IDCAMPAIGNCONTENT    varchar(8),
   TAGNAME              varchar(15),
   ACTIVE               int,
   TITLENOTIFICATION    varchar(25),
   DESCRIPTION          varchar(300),
   TYPEBEACON           int,
   ICONNOTIF            varchar(50),
   primary key (IDBEACON)
);

/*==============================================================*/
/* Table: BEACONLOYALITETYPE                                    */
/*==============================================================*/
create table BEACONLOYALITETYPE
(
   IDBEACON             varchar(8) not null,
   IDEARNINGRULE varchar(8) not null,
   primary key (IDBEACON, IDEARNINGRULE)
);

/*==============================================================*/
/* Table: CAMPAIGNCONTENT                                       */
/*==============================================================*/
create table CAMPAIGNCONTENT
(
   IDCAMPAIGNCONTENT    varchar(8) not null,
   IDCAMPAIGNCONTENTTYPE varchar(8) not null,
   IDCOMPANY            varchar(8) not null,
   TITLE                varchar(30),
   BODIES               varchar(300),
   primary key (IDCAMPAIGNCONTENT)
);

/*==============================================================*/
/* Table: CAMPAIGNCONTENTTYPE                                   */
/*==============================================================*/
create table CAMPAIGNCONTENTTYPE
(
   IDCAMPAIGNCONTENTTYPE varchar(8) not null,
   NAMECONTENT          varchar(15),
   primary key (IDCAMPAIGNCONTENTTYPE)
);

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
create table COMPANY
(
   IDCOMPANY            varchar(8) not null,
   COMPANYNAME          varchar(20),
   DESCRIPTION          varchar(300),
   REGISTEREDADDRESS    varchar(50),
   primary key (IDCOMPANY)
);

/*==============================================================*/
/* Table: CRITERIA                                              */
/*==============================================================*/
create table CRITERIA
(
   IDSUBSCRIPTION       varchar(8) not null,
   IDLEVELS              varchar(8) not null,
   primary key (IDSUBSCRIPTION, IDLEVELS)
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER
(
   ID                   varchar(8) not null,
   LASTNAME             varchar(30),
   FIRSTNAME            varchar(30),
   ADDRESS              varchar(50),
   EMAIL                varchar(30),
   PHONENUMBER          varchar(15),
   PASSWORD             varchar(100),
   CREATIONDATE         date,
   GENDER               int,
   PROFIL               varchar(50),
   STATUS               int,
   BIRTHDATE            date,
   primary key (ID)
);

/*==============================================================*/
/* Table: EARNINGRULE                                           */
/*==============================================================*/
create table EARNINGRULE
(
   IDEARNINGRULE varchar(8) not null,
   IDLOYALTYTYPE        varchar(8) not null,
   STARTDATE            date,
   ENDDATE              date,
   EARNEDPOINT          int,
   CURRENTDATE          date,
   ACTIVE               int,
   TARGETCHAR           char(20),
   primary key (IDEARNINGRULE)
);

/*==============================================================*/
/* Table: EXCHANGEPOINT                                         */
/*==============================================================*/
create table EXCHANGEPOINT
(
   IDREWARD             varchar(8) not null,
   IDSUBSCRIPTION                   varchar(8) not null,
   POINTVALUE           bigint,
   EXCHANGEDATE         date,
   primary key (IDREWARD, ID)
);

/*==============================================================*/
/* Table: LEVELS                                                 */
/*==============================================================*/
create table LEVELS
(
   IDLEVELS              varchar(8) not null,
   DESCRIPTION          varchar(300),
   VALUEPERMISSION      int,
   IDCOMPANY 			 varchar(8),
   primary key (IDLEVELS)
);

/*==============================================================*/
/* Table: LOYALITYPOINT                                         */
/*==============================================================*/
create table LOYALITYPOINT
(
   IDLOYALITYPOINT      varchar(8) not null,
   IDCOMPANY			varchar(8) not null,
   IDEARNINGRULE varchar(8) not null,
   IDSUBSCRIPTION       varchar(8) not null,
   EARNEDPOINT          int,
   ACQUISITIONDATE      date,
   primary key (IDLOYALITYPOINT)
);

/*==============================================================*/
/* Table: LOYALTYTYPE                                           */
/*==============================================================*/
create table LOYALTYTYPE
(
   IDLOYALTYTYPE        varchar(8) not null,
   IDCOMPANY            varchar(8) not null,
   LOYALTYNAME          varchar(40),
   DESCRIPTION          varchar(300),
   STATUSTYPE			int,
   primary key (IDLOYALTYTYPE)
);

/*==============================================================*/
/* Table: MANAGER                                               */
/*==============================================================*/
create table MANAGER
(
   ID                   varchar(8) not null,
   IDPLACE              varchar(8),
   LASTNAME             varchar(30),
   FIRSTNAME            varchar(30),
   ADDRESS              varchar(50),
   EMAIL                varchar(30),
   PHONENUMBER          varchar(15),
   PASSWORD             varchar(100),
   CREATIONDATE         date,
   GENDER               int,
   PROFIL               varchar(50),
   STATUS               int,
   ACTIVE               int,
   primary key (ID)
);

/*==============================================================*/
/* Table: PLACE                                                 */
/*==============================================================*/
create table PLACE
(
   IDPLACE              varchar(8) not null,
   IDCOMPANY            varchar(8) not null,
   NAMEPLACE            varchar(15),
   ADDRESS              varchar(50),
   primary key (IDPLACE)
);

/*==============================================================*/
/* Table: REWARD                                                */
/*==============================================================*/
create table REWARD
(
   IDREWARD             varchar(8) not null,
   IDREWARDTYPE         varchar(8) not null,
   STARTREWARD          DATE,
   ENDREWARD            DATE,
   LEVELS               int,
   COSTINPOINT          int,
   REWARDVALUE          decimal,
   DESCRIPTION          varchar(300),
   REWARDNAME           varchar(30),
   ACTIVE               int,
   "LIMIT"              int,
   LIMITPERCUSTOMER     int,
   primary key (IDREWARD)
);

/*==============================================================*/
/* Table: REWARDTYPE                                            */
/*==============================================================*/
create table REWARDTYPE
(
   IDREWARDTYPE         varchar(8) not null,
   REWARDTYPE           varchar(20),
   DESCRIPTION          varchar(300),
   primary key (IDREWARDTYPE)
);

/*==============================================================*/
/* Table: SUBSCRIPTION                                          */
/*==============================================================*/
create table SUBSCRIPTION
(
   IDSUBSCRIPTION       varchar(8) not null,
   IDCOMPANY            varchar(8) not null,
   ID                   varchar(8) not null,
   CURRENTPOINTVALUE    int,
   STATUS				int,
   LEVELS				int,
   primary key (IDSUBSCRIPTION)
);

/*==============================================================*/
/* Table: SUPERADMIN                                            */
/*==============================================================*/
create table SUPERADMIN
(
   ID                   varchar(8) not null,
   LASTNAME             varchar(30),
   FIRSTNAME            varchar(30),
   ADDRESS              varchar(50),
   EMAIL                varchar(30),
   PHONENUMBER          varchar(15),
   PASSWORD             varchar(100),
   CREATIONDATE         date,
   GENDER               int,
   PROFIL               varchar(50),
   STATUS               int,
   primary key (ID)
);

/*==============================================================*/
/* Table: USERS                                                  */
/*==============================================================*/
create table USERS
(
   ID                   varchar(8) not null,
   LASTNAME             varchar(30),
   FIRSTNAME            varchar(30),
   ADDRESS              varchar(50),
   EMAIL                varchar(30),
   PHONENUMBER          varchar(15),
   PASSWORD             varchar(100),
   CREATIONDATE         date,
   GENDER               int,
   PROFIL               varchar(50),
   STATUS               int,
   primary key (ID)
);

/*==============================================================*/
/* Table: VISIT                                                 */
/*==============================================================*/
create table VISIT
(
   IDVISIT              varchar(8) not null,
   IDSUBSCRIPTION       varchar(8) not null,
   VISITDATE            date,
   VISITBEGIN           time,
   VISITEND             time,
   VISITNUMBER          int,
   primary key (IDVISIT)
);

/*alter table ADMINST add constraint FK_INHERITANCE_2 foreign key (ID)
      references USERS (ID) on delete restrict on update restrict;
*/
alter table ADMINST add constraint FK_MANAGE foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;

alter table BEACON add constraint FK_BROADCASTS foreign key (IDCAMPAIGNCONTENT)
      references CAMPAIGNCONTENT (IDCAMPAIGNCONTENT) on delete restrict on update restrict;

alter table BEACON add constraint FK_POSSESS foreign key (IDPLACE)
      references PLACE (IDPLACE) on delete restrict on update restrict;

alter table BEACONLOYALITETYPE add constraint FK_BEACONLOYALITETYPE foreign key (IDBEACON)
      references BEACON (IDBEACON) on delete restrict on update restrict;

alter table BEACONLOYALITETYPE add constraint FK_BEACONLOYALITETYPE2 foreign key (IDEARNINGRULE)
      references EARNINGRULE (IDEARNINGRULE) on delete restrict on update restrict;

alter table CAMPAIGNCONTENT add constraint FK_ASSOCIATION_11 foreign key (IDCAMPAIGNCONTENTTYPE)
      references CAMPAIGNCONTENTTYPE (IDCAMPAIGNCONTENTTYPE) on delete restrict on update restrict;

alter table CAMPAIGNCONTENT add constraint FK_CREATE foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;

alter table CRITERIA add constraint FK_CRITERIA foreign key (IDSUBSCRIPTION)
      references SUBSCRIPTION (IDSUBSCRIPTION) on delete restrict on update restrict;

alter table CRITERIA add constraint FK_CRITERIA2 foreign key (IDLEVELS)
      references LEVELS (IDLEVELS) on delete restrict on update restrict;
/*
alter table CUSTOMER add constraint FK_INHERITANCE_1 foreign key (ID)
      references USERS (ID) on delete restrict on update restrict;
*/
alter table EARNINGRULE add constraint FK_LOYALITE_EARNING foreign key (IDLOYALTYTYPE)
      references LOYALTYTYPE (IDLOYALTYTYPE) on delete restrict on update restrict;

alter table EARNINGRULE add constraint FK_DEFINE foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;

alter table EXCHANGEPOINT add constraint FK_EXCHANGEPOINT foreign key (IDREWARD)
      references REWARD (IDREWARD) on delete restrict on update restrict;

alter table EXCHANGEPOINT add constraint FK_EXCHANGEPOINT2 foreign key (IDSUBSCRIPTION)
      references SUBSCRIPTION (IDSUBSCRIPTION) on delete restrict on update restrict;

alter table LOYALITYPOINT add constraint FK_EARNEDPOINTSOURCE foreign key (IDEARNINGRULE)
      references EARNINGRULE (IDEARNINGRULE) on delete restrict on update restrict;

alter table LOYALITYPOINT add constraint FK_HAS foreign key (IDSUBSCRIPTION)
      references SUBSCRIPTION (IDSUBSCRIPTION) on delete restrict on update restrict;

alter table LOYALTYTYPE add constraint FK_PUT foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;

alter table MANAGER add constraint FK_ASSIGNED foreign key (IDPLACE)
      references PLACE (IDPLACE) on delete restrict on update restrict;

alter table MANAGER add constraint FK_INHERITANCE_4 foreign key (ID)
      references USERS (ID) on delete restrict on update restrict;

alter table PLACE add constraint FK_AT foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;

alter table REWARD add constraint FK_ASSOCIATION_7 foreign key (IDREWARDTYPE)
      references REWARDTYPE (IDREWARDTYPE) on delete restrict on update restrict;

alter table SUBSCRIPTION add constraint FK_IN foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;

alter table SUBSCRIPTION add constraint FK_SUBSCRIBE foreign key (ID)
      references CUSTOMER (ID) on delete restrict on update restrict;

alter table SUPERADMIN add constraint FK_INHERITANCE_3 foreign key (ID)
      references USERS (ID) on delete restrict on update restrict;

alter table VISIT add constraint FK_ATTENDANCE foreign key (IDSUBSCRIPTION)
      references SUBSCRIPTION (IDSUBSCRIPTION) on delete restrict on update restrict;

	  alter table LEVELS add constraint FK_CREATE foreign key (IDCOMPANY)
      references COMPANY (IDCOMPANY) on delete restrict on update restrict;
