#-- creating fields and rooms  to reserve them

INSERT INTO `room` VALUES
 ('1','Simple','1-bed','City',50,0,NULL,0),
 ('2','Simple','1-bed','Beach',50,0,NULL,0),
 ('3','Double','large-bed','Beach',90,0,NULL,0),
 ('5','Double','2-beds','Beach',90,0,NULL,0),
 ('6','Double','large-bed','City',90,0,NULL,0),
 ('7','family','2-rooms','Beach',190,0,NULL,0),
 ('8','family','3-rooms','city',220,0,NULL,0),
 ('9','Mini','Suit','Beach',300,0,NULL,0),
 ('10','Master','Suit','Beach',400,0,NULL,0);

 
 INSERT INTO `staff` VALUES
 ('1254','0000','emp1','zeazee',25,5689,235,'reception')
 ,('9876','22845','boss1','jjqljfq',48,659874,650,'reception');
 
 INSERT INTO `ordertype` VALUES 
 ('breakfast',10,'08:30:00'),
 ('dinner',20,'19:30:00'),
 ('lunch',10,'12:15:00');
 
 