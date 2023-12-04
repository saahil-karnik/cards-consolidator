CREATE TABLE USER (
UID INT(20),
Name VARCHAR(20),
Email VARCHAR(25),
Password VARCHAR(64),
DOB DATE
);

INSERT INTO USER (UID, Name, Email, Password, DOB) VALUES ('','','','','');
INSERT INTO USER (UID, Name, Email, Password, DOB) VALUES ('','','','','');
INSERT INTO USER (UID, Name, Email, Password, DOB) VALUES ('','','','','');

ALTER TABLE USER
ADD CONSTRAINT PK_user PRIMARY KEY (UID);

CREATE TABLE CARD (
CardNo VARCHAR(20), 
Type VARCHAR(25),
UID INT(20),
Points VARCHAR(25),
Expiry DATE
);

INSERT INTO CARD (CardNo, Type, UID, Points, Expiry) VALUES ('','','','','');
INSERT INTO CARD (CardNo, Type, UID, Points, Expiry) VALUES ('','','','','');
INSERT INTO CARD (CardNo, Type, UID, Points, Expiry) VALUES ('','','','','');

ALTER TABLE CARD 
ADD CONSTRAINT CK_card PRIMARY KEY (CardNo, Type);

CREATE TABLE PROMOTIONS(
PromotionID VARCHAR(20), 
Type VARCHAR(25),
EligiblePoints INT(25),
PromotionName VARCHAR(20)
);

INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('','','','','');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('','','','','');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('','','','','');

ALTER TABLE PROMOTIONS
ADD CONSTRAINT PK_promotions PRIMARY KEY (PromotionID);
