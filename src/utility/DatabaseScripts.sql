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

INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('TH1','Tim Hortons','5000','Get 5% off on your Latte now!!');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('TH2','Tim Hortons','8000','Get 8% off on your Latte now!!');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('SB1','Starbucks','500','25% off on Dark Roast');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('SB2','Starbucks','1000','50% off on Croissant');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('SB3','Starbucks','2000','Free Chai');
INSERT INTO PROMOTIONS (PromotionID, Type, EligiblePoints, PromotionName) VALUES ('PC1','PC Optimum','10000','Redeem 2000 points and get 1000 points back');

ALTER TABLE PROMOTIONS
ADD CONSTRAINT PK_promotions PRIMARY KEY (PromotionID);
