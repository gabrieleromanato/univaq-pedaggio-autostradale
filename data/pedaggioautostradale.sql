#
# SQL Export
# Created by Querious (201069)
# Created: 12 January 2020 at 10:02:39 CET
# Encoding: Unicode (UTF-8)
#


SET @PREVIOUS_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS = 0;


CREATE TABLE `autostrade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codice` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;


CREATE TABLE `caselli` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `autostrada` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `progressiva_km` decimal(10,2) DEFAULT '0.00',
  `nome` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=513 DEFAULT CHARSET=utf8;


CREATE TABLE `pagamenti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_veicolo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `importo` decimal(10,2) DEFAULT '0.00',
  `orario` datetime DEFAULT NULL,
  `tipologia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;




SET FOREIGN_KEY_CHECKS = @PREVIOUS_FOREIGN_KEY_CHECKS;


SET @PREVIOUS_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS = 0;


LOCK TABLES `autostrade` WRITE;
ALTER TABLE `autostrade` DISABLE KEYS;
INSERT INTO `autostrade` (`id`, `nome`, `codice`) VALUES 
	(1,'A1 Milano-Napoli','A01'),
	(2,'A3 Napoli-Salerno','A03'),
	(3,'A4 Torino-Trieste','A04'),
	(4,'A5 Torino-Aosta-Monte Bianco','A05'),
	(5,'A6 Torino-Savona','A06'),
	(6,'A7 Milano-Serravalle-Genova','A07'),
	(7,'A8 Milano-Varese','A08'),
	(8,'A9 Lainate-Como-Chiasso','A09'),
	(9,'A10 Genova-Savona-Ventimiglia','A10'),
	(10,'A11 Firenze-Pisa nord','A11'),
	(11,'A12 Genova-Rosignano Marittimo','A12'),
	(12,'A12 Roma-Civitavecchia-Tarquinia','A12'),
	(13,'A13 Bologna-Padova','A13'),
	(14,'A14 Bologna-Taranto','A14'),
	(15,'A15 Parma-La Spezia','A15'),
	(16,'A16 Napoli-Canosa','A16'),
	(17,'A18 Messina-Catania','A18'),
	(18,'A20 Messina-Palermo','A20'),
	(19,'A21 Torino-Piacenza-Brescia','A21'),
	(20,'A22 Brennero-Modena','A22'),
	(21,'A23 Palmanova-Udine-Tarvisio','A23'),
	(22,'A24 Roma-L\'Aquila-Teramo','A24'),
	(23,'A25 Torano-Pescara','A25'),
	(24,'A26 Ge.Voltri-SS 33 Semp.-Gravell.Toce','A26'),
	(25,'A27 Venezia-Belluno','A27'),
	(26,'A28 Portogruaro-Pordenone-Conegliano','A28'),
	(27,'A30 Caserta-Salerno','A30'),
	(28,'A31 Vicenza-Valdastico','A31'),
	(29,'A32 Torino-Bardonecchia','A32'),
	(30,'A33 Asti-Cuneo','A33'),
	(31,'A33 Asti - A6','A33'),
	(32,'Tangenziale Napoli','A56'),
	(33,'A57 Tangenziale di Mestre','A57'),
	(34,'TANG EST ESTERNA MILANO','A58');
ALTER TABLE `autostrade` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `caselli` WRITE;
ALTER TABLE `caselli` DISABLE KEYS;
INSERT INTO `caselli` (`id`, `autostrada`, `progressiva_km`, `nome`, `codice`) VALUES 
	(1,'A01',7.70,'Melegnano','37'),
	(2,'A01',8.90,'Milano Sud','1'),
	(3,'A01',22.30,'Lodi','2'),
	(4,'A01',37.80,'Casalpusterlengo','3'),
	(5,'A01',49.70,'Basso Lodigiano','4'),
	(6,'A01',74.00,'Fiorenzuola','6'),
	(7,'A01',90.40,'Fidenza','7'),
	(8,'A01',110.40,'Parma','8'),
	(9,'A01',124.40,'Terre di canossa - Campegine','91'),
	(10,'A01',137.10,'Reggio Emilia','9'),
	(11,'A01',157.60,'Modena Nord','10'),
	(12,'A01',170.80,'Modena Sud','11'),
	(13,'A01',184.79,'Valsamoggia','96'),
	(14,'A01',199.89,'Sasso Marconi Nord','70'),
	(15,'A01',209.80,'Sasso Marconi','14'),
	(16,'A01',222.70,'Rioveggio','15'),
	(17,'A01',237.20,'Pian del Voglio','16'),
	(18,'A01',242.30,'Roncobilaccio','17'),
	(19,'A01',261.50,'Barberino di Mugello','18'),
	(20,'A01',278.10,'Calenzano-Sesto Fiorentino','19'),
	(21,'A01',279.90,'Firenze Nord','20'),
	(22,'A01',286.90,'Firenze Scandicci','21'),
	(23,'A01',289.70,'Villa Costanza','97'),
	(24,'A01',295.50,'Firenze Impruneta','22'),
	(25,'A01',300.90,'Firenze Sud','23'),
	(26,'A01',319.90,'Incisa - Reggello','24'),
	(27,'A01',335.80,'Valdarno','25'),
	(28,'A01',358.50,'Arezzo','26'),
	(29,'A01',371.60,'Monte San Savino','27'),
	(30,'A01',385.40,'Valdichiana','28'),
	(31,'A01',409.90,'Chiusi-Chianciano Terme','29'),
	(32,'A01',427.80,'Fabro','30'),
	(33,'A01',451.40,'Orvieto','31'),
	(34,'A01',479.50,'Attigliano','32'),
	(35,'A01',491.30,'Orte','33'),
	(36,'A01',500.90,'Magliano Sabina','34'),
	(37,'A01',516.00,'Ponzano Romano-Soratte','90'),
	(38,'A01',555.47,'Guidonia Montecelio','93'),
	(39,'A01',586.90,'Valmontone','705'),
	(40,'A01',592.90,'Colleferro','706'),
	(41,'A01',603.90,'Anagni-Fiuggi','707'),
	(42,'A01',618.20,'Ferentino','786'),
	(43,'A01',624.20,'Frosinone','708'),
	(44,'A01',642.00,'Ceprano','709'),
	(45,'A01',658.30,'Pontecorvo','710'),
	(46,'A01',669.60,'Cassino','711'),
	(47,'A01',678.60,'San Vittore','712'),
	(48,'A01',700.80,'Caianello','713'),
	(49,'A01',719.80,'Capua','714'),
	(50,'A01',728.60,'Santa Maria Capua Vetere','776'),
	(51,'A01',733.70,'Caserta Nord','715'),
	(52,'A01',739.70,'Napoli Nord','779'),
	(53,'A01',740.60,'Caserta Sud','716'),
	(54,'A01',3.60,'Roma Nord','36'),
	(55,'A01',4.00,'Fiano Romano','35'),
	(56,'A01',9.50,'Castelnuovo di Porto','92'),
	(57,'A01',5.00,'San Cesareo','704'),
	(58,'A01',10.20,'Monteporzio','703'),
	(59,'A01',14.90,'Roma sud','702'),
	(60,'A01',739.70,'Caserta Centro','778'),
	(61,'A01',58.20,'Piacenza Sud','5'),
	(62,'A01',17.43,'Badia','94'),
	(63,'A01',28.09,'Firenzuola','95'),
	(64,'A01',261.50,'Barberino di Mugello','18'),
	(65,'A03',4.70,'Ponticelli','17'),
	(66,'A03',4.80,'Napoli Sud','1'),
	(67,'A03',8.10,'Portici','4'),
	(68,'A03',12.50,'Torre del Greco','5'),
	(69,'A03',17.50,'Torre Annunziata Nord','15'),
	(70,'A03',19.70,'Torre Annunziata Sud','6'),
	(71,'A03',21.90,'Pompei','7'),
	(72,'A03',22.60,'Castellammare di Stabia','8'),
	(73,'A03',25.00,'Scafati','9'),
	(74,'A03',29.80,'Angri','10'),
	(75,'A03',31.83,'Angri Sud','18'),
	(76,'A03',36.70,'Nocera Sud','16'),
	(77,'A03',36.80,'Nocera Nord','11'),
	(78,'A03',42.80,'Cava de\' Tirreni','12'),
	(79,'A04',24.30,'Torino Rondissone','420'),
	(80,'A04',36.80,'Borgo d\'Ale','426'),
	(81,'A04',45.20,'Santhia`','429'),
	(82,'A04',54.40,'Carisio','430'),
	(83,'A04',60.00,'Balocco','432'),
	(84,'A04',67.50,'Greggio','433'),
	(85,'A04',73.60,'Biandrate-Vicolungo','434'),
	(86,'A04',82.90,'Novara Ovest','436'),
	(87,'A04',90.50,'Novara Est','437'),
	(88,'A04',105.40,'Marcallo-Mesero','440'),
	(89,'A04',110.50,'Arluno','441'),
	(90,'A04',118.40,'Rho','442'),
	(91,'A04',120.90,'Milano Ghisolfa','443'),
	(92,'A04',138.20,'Milano Est','654'),
	(93,'A04',138.90,'Monza','656'),
	(94,'A04',143.90,'bivio Tangenziale Est','655'),
	(95,'A04',145.80,'Agrate','653'),
	(96,'A04',150.00,'Cavenago','652'),
	(97,'A04',157.10,'Trezzo','651'),
	(98,'A04',160.60,'Capriate','650'),
	(99,'A04',167.70,'Dalmine','649'),
	(100,'A04',172.40,'Bergamo','648'),
	(101,'A04',179.00,'Seriate','647'),
	(102,'A04',187.60,'Grumello','646'),
	(103,'A04',190.90,'Ponte Oglio','645'),
	(104,'A04',193.10,'Palazzolo','644'),
	(105,'A04',201.30,'Rovato','643'),
	(106,'A04',206.30,'Ospitaletto','642'),
	(107,'A04',210.83,'Castegnato','378'),
	(108,'A04',215.20,'Brescia Ovest','641'),
	(109,'A04',228.50,'Brescia Est','618'),
	(110,'A04',244.20,'Desenzano','617'),
	(111,'A04',251.60,'Sirmione','616'),
	(112,'A04',259.10,'Peschiera','615'),
	(113,'A04',270.70,'Sommacampagna','614'),
	(114,'A04',280.10,'Verona Sud','613'),
	(115,'A04',290.00,'Verona Est','612'),
	(116,'A04',302.70,'Soave','611'),
	(117,'A04',311.70,'Montebello','610'),
	(118,'A04',320.90,'Montecchio','609'),
	(119,'A04',326.90,'Vicenza Ovest','608'),
	(120,'A04',334.50,'Vicenza Est','607'),
	(121,'A04',343.60,'Grisignano','606'),
	(122,'A04',356.60,'Padova Ovest','605'),
	(123,'A04',363.60,'Padova Est','604'),
	(124,'A04',380.30,'Spinea','598'),
	(125,'A04',389.39,'Martellago-Scorze\'','597'),
	(126,'A04',400.10,'Preganziol','596'),
	(127,'A04',416.09,'Meolo - Roncade','513'),
	(128,'A04',424.60,'San Dona\' di Piave','511'),
	(129,'A04',432.20,'Cessalto','510'),
	(130,'A04',438.90,'San Stino di Livenza','509'),
	(131,'A04',467.70,'Latisana','507'),
	(132,'A04',482.70,'San Giorgio di Nogaro','506'),
	(133,'A04',491.30,'Palmanova','504'),
	(134,'A04',506.50,'Redipuglia','502'),
	(135,'A04',515.10,'Trieste Lisert','501'),
	(136,'A04',120.90,'Milano Tangenziale Nord Ovest','444'),
	(137,'A05',3.70,'Settimo Torinese','419'),
	(138,'A05',3.70,'Torino Nord','401'),
	(139,'A05',4.00,'Settimo Nord','400'),
	(140,'A05',10.80,'Volpiano','402'),
	(141,'A05',24.90,'San Giorgio','403'),
	(142,'A05',33.00,'Scarmagno','404'),
	(143,'A05',39.30,'Ivrea','407'),
	(144,'A05',53.40,'Quincinetto','408'),
	(145,'A05',57.60,'Pont Saint Martin','409'),
	(146,'A05',70.10,'Verres','410'),
	(147,'A05',81.30,'Chatillon-Saint Vincent','411'),
	(148,'A05',92.70,'Nus','412'),
	(149,'A05',100.20,'Aosta','414'),
	(150,'A05',101.10,'Aosta est','469'),
	(151,'A05',112.80,'Aosta Ovest','415'),
	(152,'A05',7.90,'Albiano','405'),
	(153,'A05',0.10,'Aosta-Gran San Bernardo','413'),
	(154,'A06',13.00,'Barriera di Torino','351'),
	(155,'A06',13.10,'Carmagnola','352'),
	(156,'A06',34.60,'Marene','353'),
	(157,'A06',49.30,'Fossano','354'),
	(158,'A06',57.80,'Carru`','355'),
	(159,'A06',62.70,'Mondovi`','356'),
	(160,'A06',70.60,'Niella Tanaro','358'),
	(161,'A06',81.00,'Ceva','359'),
	(162,'A06',97.10,'Millesimo','361'),
	(163,'A06',109.60,'Altare','362'),
	(164,'A07',4.10,'Milano Ovest','201'),
	(165,'A07',10.50,'Binasco','202'),
	(166,'A07',21.50,'Bereguardo','203'),
	(167,'A07',30.60,'Gropello Cairoli','204'),
	(168,'A07',50.00,'Casei Gerola','205'),
	(169,'A07',54.00,'Castelnuovo Scrivia','206'),
	(170,'A07',63.50,'Tortona','207'),
	(171,'A07',84.50,'Serravalle Scrivia','208'),
	(172,'A07',88.60,'Vignole Borbera','209'),
	(173,'A07',100.70,'Isola del Cantone','210'),
	(174,'A07',106.50,'Ronco Scrivia','211'),
	(175,'A07',111.50,'Busalla','212'),
	(176,'A07',125.80,'Genova Bolzaneto','213'),
	(177,'A07',132.80,'Genova Ovest','214'),
	(178,'A08',5.60,'MILANO NORD','1'),
	(179,'A08',8.10,'Lainate','2'),
	(180,'A08',29.90,'Gallarate','6'),
	(181,'A08',31.90,'Gallarate Nord','10'),
	(182,'A08',2.50,'Gallarate Ovest','246'),
	(183,'A08',4.00,'Besnate','245'),
	(184,'A08',11.90,'Sesto Calende-Vergiate','244'),
	(185,'A08',17.90,'Castelletto Ticino','243'),
	(186,'A09',29.80,'Fino Mornasco','4'),
	(187,'A09',33.00,'Como Grandate','3'),
	(188,'A10',2.30,'Genova Aeroporto','215'),
	(189,'A10',6.00,'Genova Pegli','216'),
	(190,'A10',10.70,'Genova Pra\'','217'),
	(191,'A10',20.20,'Arenzano','218'),
	(192,'A10',26.80,'Varazze','219'),
	(193,'A10',32.35,'Celle Ligure','220'),
	(194,'A10',36.40,'Albisola','221'),
	(195,'A10',52.70,'Spotorno','482'),
	(196,'A10',59.40,'Orco Feglino','483'),
	(197,'A10',63.00,'Finale Ligure','484'),
	(198,'A10',67.70,'Pietra Ligure','485'),
	(199,'A10',72.60,'Borghetto Santo Spirito','497'),
	(200,'A10',81.20,'Albenga','486'),
	(201,'A10',93.20,'Andora','487'),
	(202,'A10',100.00,'San Bartolomeo','488'),
	(203,'A10',106.30,'Imperia Est','489'),
	(204,'A10',112.20,'Imperia Ovest','490'),
	(205,'A10',128.40,'Arma di Taggia','491'),
	(206,'A10',139.40,'Sanremo Ovest','493'),
	(207,'A10',145.80,'Bordighera','494'),
	(208,'A10',151.80,'Ventimiglia','495'),
	(209,'A10',151.80,'Ventimiglia','496'),
	(210,'A10',44.80,'Savona-Vado','222'),
	(211,'A11',4.20,'Firenze Ovest','333'),
	(212,'A11',9.00,'Prato Est','334'),
	(213,'A11',16.80,'Prato Ovest','335'),
	(214,'A11',27.40,'Pistoia','336'),
	(215,'A11',39.00,'Montecatini Terme','337'),
	(216,'A11',46.40,'Chiesina Uzzanese','338'),
	(217,'A11',49.30,'Altopascio','339'),
	(218,'A11',57.20,'Capannori','340'),
	(219,'A11',66.00,'Lucca','344'),
	(220,'A11',81.00,'Pisa Nord','345'),
	(221,'A11',69.00,'Lucca ovest','348'),
	(222,'A11',81.70,'Massarosa','290'),
	(223,'A11',6.30,'Firenze Nord','20'),
	(224,'A12',4.20,'Genova Est','260'),
	(225,'A12',11.50,'Genova Nervi','261'),
	(226,'A12',22.80,'Recco','262'),
	(227,'A12',28.40,'Rapallo','263'),
	(228,'A12',38.30,'Chiavari','264'),
	(229,'A12',41.10,'Lavagna','265'),
	(230,'A12',48.70,'Sestri Levante','266'),
	(231,'A12',60.50,'Deiva Marina','273'),
	(232,'A12',70.10,'Carrodano','274'),
	(233,'A12',75.80,'Brugnato','275'),
	(234,'A12',101.60,'Sarzana','279'),
	(235,'A12',110.00,'Carrara','280'),
	(236,'A12',116.40,'Massa','281'),
	(237,'A12',127.90,'Versilia','282'),
	(238,'A12',161.60,'Pisa Centro','287'),
	(239,'A12',177.80,'Collesalvetti','300'),
	(240,'A12',205.90,'Rosignano Marittimo','301'),
	(241,'A12',206.90,'Rosignano Barriera','302'),
	(242,'A12',11.30,'Maccarese-Fregene','2'),
	(243,'A12',11.60,'Roma Ovest','1'),
	(244,'A12',14.90,'Torrimpietra','6'),
	(245,'A12',52.20,'Civitavecchia Sud','4'),
	(246,'A12',52.30,'Aurelia','3'),
	(247,'A12',77.80,'Tarquinia','308'),
	(248,'A12',170.70,'barriera di Livorno','286'),
	(249,'A12',78.90,'Pisa Centro','287'),
	(250,'A12',0.60,'Viareggio','283'),
	(251,'A12',2.50,'Rosignano','303'),
	(252,'A13',0.60,'Bologna Arcoveggio','101'),
	(253,'A13',7.90,'Bologna Interporto','100'),
	(254,'A13',20.50,'Altedo','102'),
	(255,'A13',33.70,'Ferrara Sud','103'),
	(256,'A13',41.90,'Ferrara Nord','104'),
	(257,'A13',49.10,'Occhiobello','105'),
	(258,'A13',63.00,'Rovigo Sud - Villamarzana','113'),
	(259,'A13',70.40,'Rovigo','106'),
	(260,'A13',74.80,'Boara','107'),
	(261,'A13',88.60,'Monselice','108'),
	(262,'A13',95.00,'Terme Euganee','109'),
	(263,'A13',112.40,'Padova industriale','112'),
	(264,'A13',0.70,'Padova Sud','110'),
	(265,'A13',0.60,'Bologna Arcoveggio','101'),
	(266,'A14',4.80,'Bologna Borgo Panigale','12'),
	(267,'A14',15.50,'Bologna Fiera','40'),
	(268,'A14',22.20,'Bologna San Lazzaro','41'),
	(269,'A14',38.20,'Castel San Pietro','38'),
	(270,'A14',50.10,'Imola','42'),
	(271,'A14',64.50,'Faenza','43'),
	(272,'A14',81.60,'Forli`','44'),
	(273,'A14',93.60,'Cesena Nord','39'),
	(274,'A14',99.70,'Cesena','45'),
	(275,'A14',110.07,'Valle Rubicone','69'),
	(276,'A14',117.30,'Rimini Nord','46'),
	(277,'A14',127.40,'Rimini Sud','47'),
	(278,'A14',135.40,'Riccione','48'),
	(279,'A14',143.90,'Cattolica','49'),
	(280,'A14',155.90,'Pesaro-Urbino','50'),
	(281,'A14',173.30,'Fano','51'),
	(282,'A14',185.30,'Marotta-Mondolfo','64'),
	(283,'A14',194.50,'Senigallia','52'),
	(284,'A14',207.90,'Montemarciano','68'),
	(285,'A14',213.50,'Ancona Nord','53'),
	(286,'A14',230.40,'Ancona Sud','54'),
	(287,'A14',245.50,'Loreto-Porto Recanati','55'),
	(288,'A14',262.60,'Civitanova Marche Macerata','56'),
	(289,'A14',270.82,'Porto S. Elpidio','67'),
	(290,'A14',279.50,'Fermo','57'),
	(291,'A14',287.90,'Pedaso','58'),
	(292,'A14',301.80,'Grottammare','66'),
	(293,'A14',311.70,'San Benedetto del Tronto','59'),
	(294,'A14',319.50,'Val Vibrata','65'),
	(295,'A14',334.40,'Teramo - Giulianova Mosciano S.Angelo','60'),
	(296,'A14',344.00,'Roseto degli Abruzzi','61'),
	(297,'A14',351.80,'Atri Pineto','62'),
	(298,'A14',364.20,'Pescara Nord-Citta` Sant\'Angelo','63'),
	(299,'A14',380.80,'Pescara Ovest-Chieti','772'),
	(300,'A14',392.60,'Pescara Sud-Francavilla','771'),
	(301,'A14',403.80,'Ortona','770'),
	(302,'A14',413.00,'Lanciano','769'),
	(303,'A14',421.10,'Val di Sangro','768'),
	(304,'A14',437.30,'Vasto Nord','767'),
	(305,'A14',453.80,'Vasto Sud','766'),
	(306,'A14',476.10,'Termoli Molise','765'),
	(307,'A14',507.00,'Poggio Imperiale','764'),
	(308,'A14',528.60,'San Severo','763'),
	(309,'A14',554.10,'Foggia','762'),
	(310,'A14',564.96,'Foggia Zona Industriale','760'),
	(311,'A14',589.20,'Cerignola Est','761'),
	(312,'A14',610.50,'Canosa','732'),
	(313,'A14',626.90,'Andria-Barletta','733'),
	(314,'A14',638.10,'Trani','734'),
	(315,'A14',652.40,'Molfetta','735'),
	(316,'A14',663.00,'Bitonto','736'),
	(317,'A14',672.20,'Bari Nord','737'),
	(318,'A14',677.80,'Bari Sud','738'),
	(319,'A14',697.60,'Acquaviva delle Fonti','739'),
	(320,'A14',709.60,'Gioia del Colle','740'),
	(321,'A14',723.90,'Mottola-Castellaneta','741'),
	(322,'A14',735.20,'Taranto Nord','742'),
	(323,'A14',8.50,'Ravenna','82'),
	(324,'A14',0.80,'Bologna Casalecchio','13'),
	(325,'A15',5.20,'Parma Ovest','151'),
	(326,'A15',22.70,'Fornovo','152'),
	(327,'A15',42.10,'Borgotaro','153'),
	(328,'A15',51.00,'Berceto','154'),
	(329,'A15',74.60,'Pontremoli','155'),
	(330,'A15',91.40,'Aulla','156'),
	(331,'A15',101.70,'La Spezia','278'),
	(332,'A16',7.30,'Pomigliano d\'Arco','718'),
	(333,'A16',13.20,'Napoli Est','780'),
	(334,'A16',23.53,'Tufino','729'),
	(335,'A16',26.60,'Baiano','720'),
	(336,'A16',41.10,'Avellino Ovest','721'),
	(337,'A16',49.70,'Avellino Est','722'),
	(338,'A16',68.70,'Benevento','723'),
	(339,'A16',81.70,'Grottaminarda','724'),
	(340,'A16',104.20,'Vallata','725'),
	(341,'A16',111.00,'Lacedonia','726'),
	(342,'A16',127.90,'Candela','727'),
	(343,'A16',159.90,'Cerignola','728'),
	(344,'A18',1.00,'Messina Sud','1'),
	(345,'A18',22.00,'Roccalumera','3'),
	(346,'A18',36.00,'Taormina','4'),
	(347,'A18',41.00,'Giardini Naxos','5'),
	(348,'A18',48.00,'Fiumefreddo','6'),
	(349,'A18',59.00,'Giarre','7'),
	(350,'A18',69.00,'Acireale','8'),
	(351,'A18',77.00,'Catania Nord','9'),
	(352,'A20',21.00,'barriera di Messina Nord','1'),
	(353,'A20',24.00,'Rometta','2'),
	(354,'A20',38.00,'Milazzo-Isole Eolie','3'),
	(355,'A20',47.00,'Barcellona','4'),
	(356,'A20',58.00,'Falcone','5'),
	(357,'A20',67.00,'Patti','6'),
	(358,'A20',84.00,'Brolo','7'),
	(359,'A20',97.00,'Rocca di Capri Leone','8'),
	(360,'A20',107.00,'San Agata di Militello','9'),
	(361,'A20',135.00,'S.Stefano di Camastra','12'),
	(362,'A20',144.00,'Tusa','13'),
	(363,'A20',155.00,'Castelbuono','14'),
	(364,'A20',163.00,'Cefalu\'','15'),
	(365,'A20',181.00,'Buonfornello','16'),
	(366,'A21',10.70,'Villanova','446'),
	(367,'A21',10.80,'Villanova','445'),
	(368,'A21',32.50,'Asti Ovest','447'),
	(369,'A21',38.70,'Asti Est','448'),
	(370,'A21',51.60,'Felizzano','449'),
	(371,'A21',66.00,'Alessandria Ovest','451'),
	(372,'A21',76.00,'Alessandria Est','452'),
	(373,'A21',101.30,'Voghera','455'),
	(374,'A21',114.90,'Casteggio','456'),
	(375,'A21',126.90,'Broni Stradella','457'),
	(376,'A21',140.90,'Castel San Giovanni','458'),
	(377,'A21',157.40,'Piacenza Ovest','459'),
	(378,'A21',176.30,'Caorso','637'),
	(379,'A21',186.00,'Castelvetro','635'),
	(380,'A21',194.80,'Cremona','634'),
	(381,'A21',210.00,'Pontevico','633'),
	(382,'A21',220.30,'Manerbio','632'),
	(383,'A21',233.20,'Brescia Sud','630'),
	(384,'A21',238.20,'Brescia Centro','631'),
	(385,'A22',15.80,'Brennero','681'),
	(386,'A22',15.80,'Vipiteno','680'),
	(387,'A22',38.00,'Bressanone','679'),
	(388,'A22',47.70,'Bressanone Zona Industriale','683'),
	(389,'A22',53.00,'Chiusa','678'),
	(390,'A22',77.40,'Bolzano Nord','677'),
	(391,'A22',85.30,'Bolzano Sud','676'),
	(392,'A22',102.00,'Egna Ora','675'),
	(393,'A22',121.50,'San Michele','674'),
	(394,'A22',131.70,'Trento Nord','682'),
	(395,'A22',136.50,'Trento Centro','673'),
	(396,'A22',142.00,'Trento Sud','684'),
	(397,'A22',158.40,'Rovereto Nord','672'),
	(398,'A22',167.00,'Rovereto Sud','671'),
	(399,'A22',179.40,'Ala Avio','670'),
	(400,'A22',207.00,'Affi','669'),
	(401,'A22',225.80,'Verona Nord','668'),
	(402,'A22',243.00,'Nogarole Rocca','667'),
	(403,'A22',256.70,'Mantova Nord','666'),
	(404,'A22',265.50,'Mantova Sud','665'),
	(405,'A22',277.20,'Pegognaga','664'),
	(406,'A22',286.00,'Reggiolo Rolo','663'),
	(407,'A22',302.60,'Carpi','662'),
	(408,'A22',310.90,'Campogalliano','661'),
	(409,'A23',13.70,'Udine Sud','505'),
	(410,'A23',26.00,'Udine Nord','541'),
	(411,'A23',44.90,'Gemona-Osoppo','542'),
	(412,'A23',59.60,'Carnia','543'),
	(413,'A23',92.40,'Pontebba','544'),
	(414,'A23',105.20,'Ugovizza Tarvisio','545'),
	(415,'A24',8.00,'Lunghezza','802'),
	(416,'A24',8.10,'Roma Est','801'),
	(417,'A24',12.60,'Tivoli','803'),
	(418,'A24',24.00,'Castel Madama','804'),
	(419,'A24',33.20,'Vicovaro-Mandela','805'),
	(420,'A24',50.50,'Carsoli Oricola','806'),
	(421,'A24',61.20,'Tagliacozzo','807'),
	(422,'A24',75.10,'Valle del Salto','808'),
	(423,'A24',84.90,'Tornimparte','809'),
	(424,'A24',101.00,'L\'Aquila Ovest','810'),
	(425,'A24',106.70,'L\'Aquila Est','811'),
	(426,'A24',116.80,'Assergi','812'),
	(427,'A24',136.60,'San Gabriele Colledara','813'),
	(428,'A24',146.10,'Teramo','814'),
	(429,'A24',2.50,'Settecamini','819'),
	(430,'A24',4.50,'Ponte di Nona','818'),
	(431,'A24',2.50,'Settecamini','819'),
	(432,'A24',4.50,'Ponte di Nona','818'),
	(433,'A25',83.10,'Magliano dei Marsi','830'),
	(434,'A25',87.90,'Avezzano','831'),
	(435,'A25',101.20,'Aielli Celano','832'),
	(436,'A25',110.30,'Pescina','833'),
	(437,'A25',121.60,'Cocullo','834'),
	(438,'A25',136.80,'Sulmona-Pratola Peligna','835'),
	(439,'A25',149.90,'Bussi Popoli','836'),
	(440,'A25',157.20,'Casauria Torre De\' Passeri','837'),
	(441,'A25',166.40,'Scafa-Alanno','838'),
	(442,'A25',170.89,'Manoppello','829'),
	(443,'A25',177.50,'Chieti','839'),
	(444,'A25',185.40,'Pescara-Villanova','840'),
	(445,'A25',0.20,'Avezzano','831'),
	(446,'A26',14.00,'Masone','230'),
	(447,'A26',29.90,'Ovada','231'),
	(448,'A26',59.50,'Alessandria Sud','233'),
	(449,'A26',89.60,'Casale Monferrato Sud','234'),
	(450,'A26',94.10,'Casale Monferrato Nord','235'),
	(451,'A26',116.80,'Vercelli Est','239'),
	(452,'A26',145.10,'Romagnano Sesia - Ghemme','240'),
	(453,'A26',153.40,'Borgomanero','241'),
	(454,'A26',165.50,'Arona','247'),
	(455,'A26',166.60,'Lago Maggiore','248'),
	(456,'A26',7.90,'Novi Ligure','232'),
	(457,'A26',8.00,'Vercelli Ovest','236'),
	(458,'A27',5.00,'Venezia','521'),
	(459,'A27',13.40,'Treviso Sud','522'),
	(460,'A27',22.60,'Treviso Nord','523'),
	(461,'A27',52.30,'Vittorio Veneto Sud','525'),
	(462,'A27',58.90,'Vittorio Veneto Nord','526'),
	(463,'A27',66.80,'Fadalto-Lago Santa Croce','527'),
	(464,'A27',75.20,'Belluno','528'),
	(465,'A27',0.10,'Conegliano Veneto','524'),
	(466,'A28',0.80,'Portogruaro','508'),
	(467,'A28',36.43,'Cordignano','537'),
	(468,'A28',43.79,'Godega','538'),
	(469,'A30',18.90,'Nola','719'),
	(470,'A30',30.40,'Palma Campania','785'),
	(471,'A30',36.20,'Sarno','781'),
	(472,'A30',40.00,'Nocera Pagani','784'),
	(473,'A30',44.40,'Castel San Giorgio','782'),
	(474,'A30',49.70,'Salerno','783'),
	(475,'A31',0.00,'Badia Polesine','626'),
	(476,'A31',7.64,'Piacenza d\'Adige','625'),
	(477,'A31',18.05,'Santa Margherita d\'Adige','624'),
	(478,'A31',24.97,'Noventa Vicentina','623'),
	(479,'A31',32.10,'Agugliaro','622'),
	(480,'A31',38.66,'Albettone-Barbarano','621'),
	(481,'A31',46.60,'Montegaldella','620'),
	(482,'A31',61.67,'Vicenza Nord','690'),
	(483,'A31',69.67,'Dueville','691'),
	(484,'A31',79.47,'Thiene','692'),
	(485,'A31',88.67,'Piovene-Rocchette','693'),
	(486,'A32',9.00,'Avigliana','191'),
	(487,'A32',57.60,'Salbertrand','192'),
	(488,'A33',4.17,'Castelletto Stura','181'),
	(489,'A33',12.60,'S. Albano','180'),
	(490,'A33',0.00,'Marene','353'),
	(491,'A33',7.50,'Cherasco','189'),
	(492,'A33',30.90,'barriera govone','188'),
	(493,'A56',5.40,'Astroni','1'),
	(494,'A56',7.20,'Agnano','2'),
	(495,'A56',10.10,'Fuorigrotta','3'),
	(496,'A56',12.50,'Vomero','4'),
	(497,'A56',13.80,'Camaldoli','5'),
	(498,'A56',15.10,'zona Ospedaliera Cardarelli','10'),
	(499,'A56',15.30,'Arenella','6'),
	(500,'A56',16.10,'Capodimonte','7'),
	(501,'A56',18.80,'Corso Malta','8'),
	(502,'A56',19.30,'Capodichino-Napoli Est','9'),
	(503,'A57',1.30,'Mirano Dolo','602'),
	(504,'A57',7.20,'Mira-Oriago','603'),
	(505,'A57',9.20,'Venezia Mestre','601'),
	(506,'A57',25.50,'Venezia Est','515'),
	(507,'A58',1.75,'Pessano con Bornago','380'),
	(508,'A58',4.14,'Gessate','381'),
	(509,'A58',8.20,'Pozzuolo Martesana','382'),
	(510,'A58',18.56,'Paullo','383'),
	(511,'A58',29.40,'Vizzolo Predabissi','384');
ALTER TABLE `caselli` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `pagamenti` WRITE;
ALTER TABLE `pagamenti` DISABLE KEYS;
ALTER TABLE `pagamenti` ENABLE KEYS;
UNLOCK TABLES;




SET FOREIGN_KEY_CHECKS = @PREVIOUS_FOREIGN_KEY_CHECKS;


