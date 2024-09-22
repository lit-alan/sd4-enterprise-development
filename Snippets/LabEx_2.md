## Lab Exercise Two. Week Three. 🙂

### 1. Create a Spring Boot Project
- Use Spring Initializr to create a new Spring Boot project, adding the following dependencies:
   - Spring Boot Dev Tools (Developer Tools)
   - Lombok (Developer Tools)
   - Spring Web (Web)
   - Thymeleaf (Template Engines)
   - Spring Data JPA (SQL)
   - MySQL Driver (SQL)

_You can use the default versions for the JDK, Java, and Spring Boot._

### 2. Set Up the MySQL Database
- Execute the following MySQL script to create a database called _jpa_example_ which contains three tables: `customers`, `products`, and `reviews`.

```sql
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `jpa_example`
--

-- --------------------------------------------------------
create Database jpa_example;
use jpa_example;
--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `first_name`, `last_name`, `email`, `password`, `address`, `city`) VALUES
(1, 'Eoin', 'Murphy', 'eoin.murphy@hotmail.com', 'eoinpa$$', '13 Talbot Street', 'Dublin'),
(2, 'Barry', 'Smith', 'barry.s@hotmail.com', 'brpa$$', '13 Talbot Street', 'Dublin'),
(3, 'Cillian', 'O\'Sullivan', 'cillian.osullivan@gmail.com', 'Ua^qJ!&6e', '9 Abbey Street', 'Limerick'),
(4, 'Saoirse', 'Walsh', 'swalsh@microsoft.com', 'ehGC$dYJb7', '8 Thomas Street', 'Galway'),
(5, 'Darragh', 'Ryan', 'darraghryano@esb.ie', 'H0XfQ6cW', '77 Pearse Street', 'Belfast'),
(6, 'Fionnuala', 'Doherty', 'fiodoh@bt.com', 'y6(eNw3O', '14 Clanbrassil Street', 'Dublin'),
(7, 'Cormac', 'McCarthy', 'cormac@ireland.com', 'XRPaL0J%R', '87 Francis Street', 'Cork'),
(8, 'Aisling', 'Ní Chonaill', 'aislingn@gmail.com', '7PqY#hu3', '3 Teeling Street', 'Balina Mayo'),
(9, 'Tadhg', 'O\'Connor', 'tadhgoconnor@microsoft.com', 'mgrwp7cU%', '81 Kevin Street', 'Galway'),
(10, 'Róisín', 'Ó Sé', 'roisino@gmail.com', 'piv8QrZ', '45 Wine Street', 'Sligo'),
(11, 'Padraig', 'Fitzgerald', 'paddyfitz@gmail.com', 'NOcc52d', '117 Baggot Street', 'Dublin'),
(12, 'Mairead', 'Ó Murchú', 'mairead.omurchu@gmail.com', 'PtjpcSHI', '4 Grattan Street', 'Sligo'),
(13, 'Seán', 'O\'Neill', 'sean.oneill@microsoft.com', 'G^dQ^)I', '4 O\'Gorman Street', 'Kilrush, Co Clare'),
(14, 'Eilis', 'Ní Bhraonáin', 'eilis.nibhraonain@gmail.com', '@^-PCov5', '7 Thomas Street', 'Galway'),
(15, 'Pádraig', 'Mac Suibhne', 'padraig_macsuibhne@gmail.com', 'LWDWeJdLe', 'John 15 Broderick Street', 'Athlone'),
(16, 'Máire', 'Ní Ghríofa', 'maire.nighriofa@gmail.com', 'c2qvkqbq', '1212 Oak Avenue', 'Dublin'),
(17, 'Ciarán', 'Ó Conaire', 'ciaranDOR@hotmail.com', 'BM3Ya5#uUn', '45 Carmody Street', 'Ennis, Co Clare'),
(18, 'Siobhán', 'Mac an Bhaird', 'siobhan.macanbhaird@gmail.com', 'XRQec0f2M$', 'Sean Costello Street', 'Athlone'),
(19, 'Niall', 'Ó Ceallaigh', 'niall.oceallaigh@gmail.com', 'n)VjoZCn$', '34 Castletown Road', 'Galway'),
(20, 'Bríd', 'Ní Dhonnchadha', 'brid.nidhonnchad@gmail.com', '^1#OZJs', '1616 Cedar Avenue', 'Belfast'),
(21, 'Caoimhe', 'Ní Mhurchú', 'canimhurchu@yahoo.com', '&7Quo8l2', '1717 Birch Lane', 'Dublin'),
(22, 'Dónal', 'Ó Céilleachair', 'donal.oceilleacha@gmail.com', 'Qz8G#Qe6', '24 Long Walk', 'Cork'),
(23, 'Síle', 'Mac Aodha', 'silemac@gmail.com', 'NKMerz3N', '34 Barrett Street', 'Ballina, Mayo'),
(24, 'Mícheál', 'Ó Cearbhaill', 'micheal.ocearbhaill@gmail.com', 'Q%&(DSM7', '20 Oak Lane', 'Galway'),
(25, 'Ailbhe', 'Ní Dhálaigh', 'ailbhe.nidhalaigh@gmail.com', 'DhalaighPaSS', 'Jocelyn Street', 'Dundalk'),
(26, 'John', 'Murphy', 'jmrphy@gmail.com', 'Iu#k@9rle', '333 Main Street', 'Dublin'),
(27, 'Mary', 'Walsh', 'mwalsh@gmail.com', 'Mj^PPfl&j', '444 Elm Avenue', 'Cork'),
(28, 'Michael', 'O\'Connor', 'michael.oconnor@tus.ie', 'mikeyopassword', '555 Oak Road', 'Limerick'),
(29, 'Anne', 'Ryan', 'anne.ryan@ucg.ie', 'IJT*)Fdg)', '666 Pine Lane', 'Galway'),
(30, 'James', 'Smith', 'jimmys@gmail.com', '38!7kG@IT', '777 Birch Lane', 'Belfast'),
(31, 'Sarah', 'Johnson', 'sj91@gmail.com', 'bFR&BUV', '888 Cedar Avenue', 'Dublin'),
(32, 'Peter', 'Brown', 'peterbbb84@gmail.com', 'o$!rcMyq', '999 Elm Road', 'Cork'),
(33, 'Laura', 'Davis', 'laura.davis@gmail.com', 'eXY1vDUk', '1010 Oak Lane', 'Limerick'),
(34, 'Andrew', 'Wilson', 'andywil@gmail.com', 'L^K*Y8Jb', '1111 Pine Avenue', 'Galway'),
(35, 'Emma', 'Taylor', 'emtay97@gmail.com', 'OejOmDsk', '1212 Birch Road', 'Belfast'),
(36, 'Daniel', 'Roberts', 'daniel_roberts23@gmail.com', '0UScN2Qu0', '1313 Oak Road', 'Dublin'),
(37, 'Olivia', 'Wilson', 'olivia_wilson@gmail.com', '6i*Y7G&kF!', '1414 Cedar Lane', 'Cork'),
(38, 'Liam', 'Smith', 'smithlisa@gmail.com', '$X!YFbv0&j', '1515 Pine Avenue', 'Limerick'),
(39, 'Ava', 'Davis', 'ava_davis@gmail.com', 'YQG3ppK(t', '1616 Elm Road', 'Galway'),
(40, 'Noah', 'Miller', 'noaaahmiller@gmail.com', 'Mbc8-id', '1717 Birch Avenue', 'Belfast'),
(41, 'Mia', 'Brown', 'mia.brown@gmail.com', 'u#m&K!@f*', '1818 Oak Lane', 'Dublin'),
(42, 'Lucas', 'Jones', 'lucas.jones@gmail.com', 'be-znsgoM', '1919 Cedar Road', 'Cork'),
(43, 'Sophia', 'Anderson', 'sophia.anderson@gmail.com', '7spDiU^!o', '2020 Pine Avenue', 'Limerick'),
(44, 'Tommy', 'Jones', 'eoin.murphy@hotmail.com', 'bjpass', '13 Talbot Street', 'Dublin'),
(45, 'Isabella', 'White', 'isabella_white@trump.co.uk', 'g0TME3xY%', '2222 Cedar Avenue', 'Belfast'),
(46, 'Siobhán', 'O\'Connor', 'siobhanoc@gmail.com', 'lZQCli6', '2323 Oak Road', 'Dublin'),
(47, 'Ciarán', 'Murphy', 'ciarmurphy@gmail.com', 'XxiUBQG@3', '2424 Cedar Lane', 'Cork'),
(48, 'Aoife', 'Ní Mhurchú', 'aoife.nimhurchu@yahoo.com', 's18)gS#w', '2525 Pine Avenue', 'Limerick'),
(49, 'Pádraig', 'Ó Súilleabháin', 'paddysuilleabha@bt.com', 'cXfP1EF6F', '2626 Elm Road', 'Galway'),
(50, 'Róisín', 'Ní Bhraonáin', 'roisin.nibhraonain@gmail.com', 'q!lBllE!', '2727 Cedar Road', 'Belfast'),
(51, 'Elena', 'Ivanova', 'elena.ivanova@gmail.com', '^Dc6990*@w', '2828 Elm Lane', 'Dublin'),
(52, 'Mikhail', 'Kuznetsov', 'mikhail.kuze@gmail.com', 'M8u0yXl', '2929 Cedar Avenue', 'Cork'),
(53, 'Katarzyna', 'Nowak', 'katarzyna.nowak11@tcd.ie', 'dSEleoniG', '3030 Pine Avenue', 'Limerick'),
(54, 'Andrei', 'Popescu', 'andrei.popescu@gmail.com', 'rPV6Ni8og', '3131 Oak Road', 'Galway'),
(55, 'Anastasia', 'Zyablikova', 'anastasia.zyablikova@gmail.com', 'NOendg)Z', '3232 Cedar Road', 'Belfast'),
(56, 'Lukasz', 'Novak', 'lukasz.novak@hotmail.com', 'U8WCRJ!aF', '3333 Pine Lane', 'Dublin'),
(57, 'Caoimhe', 'Smith', 'caoimhe.smith@ireland.com', 'M$CgIR84S0', '3434 Oak Road', 'Cork'),
(58, 'Viktor', 'Ivanov', 'viktor.ivanov@ucd.ie', 'ar%7XL4%dR', '3535 Cedar Avenue', 'Limerick'),
(59, 'Aisling', 'Ní Mhurchú', 'aisling.nimhurchu@gmail.com', '#z%eZkj4', '3636 Elm Lane', 'Galway'),
(60, 'Pavel', 'Kuznetsov', 'pavel.kuznetsov@gmail.com', 'HJZc#SrafuZ', '3737 Pine Avenue', 'Belfast'),
(61, 'Síle', 'Walsh', 'sile.walsh@gmail.com', 'p7clZRI', '3838 Oak Road', 'Dublin'),
(62, 'Dominik', 'Nowak', 'do#nowak@gmail.com', 'hu7MchJ(Y', '3939 Cedar Lane', 'Cork'),
(63, 'Máire', 'Zyablikova', 'maire.zyablikova@gmail.com', 'g)q(GkRz', '4040 Pine Avenue', 'Limerick'),
(64, 'Nikolay', 'O\'Connor', 'nikolay.oconnor@hotmail.com', 'vVm0EJf', '4141 Elm Road', 'Galway'),
(65, 'Eva', 'Murphy', 'eva.murphy@gmail.com', '5rsTkzEcU', '4242 Cedar Road', 'Belfast'),
(66, 'Daria', 'Ivanova', 'daria.ivanova@tcd.ie', 'nX&5HLgb', '4343 Elm Lane', 'Dublin'),
(67, 'Dylan', 'Walsh', 'dylan.walsh@gmail.com', 's&#saA^s', '4444 Oak Road', 'Cork'),
(68, 'Kamila', 'Nowak', 'kamila.nowak@gmail.com', '7g1as)F!w(', '4545 Cedar Avenue', 'Limerick'),
(69, 'Fionn', 'Mac Suibhne', 'fionn.macsuibhne@gmail.com', 'x$gmW&5M-', '4646 Pine Avenue', 'Galway'),
(70, 'Elena', 'Kuznetsova', 'elena.kuznetsova@gmail.com', 'fXXvVkt(b', '4747 Birch Road', 'Belfast'),
(71, 'Cillian', 'Ó Murchú', 'cillian.omurchu@gmail.com', 'oJAuN-ff2', '4848 Oak Lane', 'Dublin'),
(72, 'Andrii', 'Kovalenko', 'andrii.kovalenko@gmail.com', 'Ku4(p#2Ft-', '4949 Cedar Lane', 'Cork'),
(73, 'Maeve', 'Ní Bhraonáin', 'maeve.nibhraonain@gmail.com', 'i$H4t2$jlWT', '5050 Pine Avenue', 'Limerick'),
(74, 'Piotr', 'Kowalski', 'piotr.kowalski@gmail.com', 'PTxsBPC7', '5151 Elm Road', 'Galway'),
(75, 'Clodagh', 'Kearney', 'clodagh.kearney@gmail.com', 'CCFR)OEq', '5252 Cedar Road', 'Belfast'),
(76, 'Anastasija', 'Petrova', 'anastasija.petrov@hotmail.com', 'iqjy-$nk', '5353 Birch Lane', 'Dublin'),
(77, 'Seán', 'Byrne', 'sean.byrne@gmail.com', 'OV7T9gyt!', '5454 Cedar Road', 'Cork'),
(78, 'Aleksandr', 'Smirnov', 'aleksandr.smirnov@rte.ie', 'i%ME7&RKg', '5555 Oak Avenue', 'Limerick'),
(79, 'Sorcha', 'Mac Conmara', 'sorcha.macconmara@gmail.com', 'h7zHZiWv', '5656 Elm Road', 'Galway'),
(80, 'Tomasz', 'Kowalczyk', 'tomasz.kowalczyk@eir.ie', 'K84duAHIQn', '5757 Pine Lane', 'Belfast'),
(81, 'Gráinne', 'O\'Leary', 'grainne.oleary@gmail.com', 'YHkQsaA', '5858 Cedar Avenue', 'Dublin'),
(82, 'Ivan', 'Dimitrov', 'ivan.dimitrov@microsoft.com', 'zFP7lIB', '5959 Oak Road', 'Cork'),
(83, 'Aoibheann', 'Ní Bhraonáin', 'aoibheann.nibhraonain@gmail.com', 'QZGczYoRL', '4 Evergreen Terrace', 'Limerick'),
(84, 'Marek', 'Novotný', 'marek.novotny@gmail.com', 'kCwROV8Amo', '21 Whispering Pines Drive', 'Galway'),
(85, 'Svetlana', 'Ivanova', 'svetlana.ivanova@yahoo.com', 'Znx33mbZw', '6262 Cedar Road', 'Belfast'),
(86, 'Mohammed', 'Abdullah', 'mohammed.abdullah@finite.com', 'L4e3pnA&', '6363 Cedar Lane', 'Dublin'),
(87, 'Niamh', 'Doherty', 'dohertyniamh@larksky.com', 'Ipk5kG$2Ya', '6464 Pine Avenue', 'Cork'),
(88, 'Aleksandra', 'Kowalczyk', 'aleksandra.kowalczyke@gmail.com', '0&o&Fmd9tR*', '6565 Oak Road', 'Limerick'),
(89, 'Conor', 'Ó Cionnaith', 'conor.ocionnaith@gmail.com', 'DDGXXuS*3', '6666 Elm Lane', 'Galway'),
(90, 'Dmitri', 'Volkov', 'dmitri.volkov@gmail.com', '6MchJS#', '6767 Cedar Avenue', 'Belfast'),
(91, 'Sinead', 'Ní Dhomhnaill', 'sinead.nidhomhnail@gmail.com', 'oaJpjx*d', '6868 Pine Lane', 'Dublin'),
(92, 'Józef', 'Kowalski', 'jozef.kowalski@gmail.com', 'WcDCCDJF2', '6969 Oak Road', 'Cork'),
(93, 'Aoibhinn', 'Mac Conmara', 'aoibhinn.macconmara@gmail.com', '$PZGd4u', '7070 Elm Avenue', 'Limerick'),
(94, 'Irina', 'Ivanova', 'irina.ivanova@gmail.com', '5S$3JXRS', '7171 Cedar Lane', 'Galway'),
(95, 'Szymon', 'Nowak', 'szymon.nowak@firstactive.ie', 'cMx$hpj1e', '7272 Pine Road', 'Belfast'),
(96, 'Karolina', 'Jankowska', 'karolina.jankowsk@aviva.ie', 'VuWq-SRu', '7373 Elm Lane', 'Dublin'),
(97, 'Colm', 'Ó Coileáin', 'colm.ocoileain@nolans.ie', '6VEc683QYZ', '7474 Cedar Avenue', 'Cork'),
(98, 'Vladimir', 'Sokolov', 'vladimir.sokolov@gmail.com', 'Y^vkj(cA', '7575 Oak Road', 'Limerick'),
(99, 'Maeve', 'Ní Ghallchóir', 'maeve.nighallchoi@gmail.com', 'lE3u%xsaK0', '7676 Pine Avenue', 'Galway'),
(100, 'Dmitry', 'Kovalenko', 'dmitry.kovalenko@fishamble.com', 'fs3)tL^D', '7777 Cedar Lane', 'Belfast'),
(101, 'Róisín', 'O\'Neill', 'reill@gmail.com', 'tgYZ2xN', '16 Swanston Street', 'Dublin'),
(102, 'Bartosz', 'Nowak', 'bartosz.nowak@gmail.com', '(CRFvFcvG', '12 Stephanie Drive', 'Cork'),
(103, 'Siobhán', 'Ní Chonaill', 'siobhan.nichonaill@microsoft.com', 'kJIQ1C$w', '10 Oakhaven Drive', 'Limerick'),
(104, 'Andrey', 'Petrov', 'andrey.petrov@gmail.com', '-*8U#rZ', '100 Spruce Drive', 'Galway'),
(105, 'Sofia', 'Ivanova', 'sofia_ivanova@forbes.co.uk', 'fS&(DWaq', '9 Birch Avenue', 'Belfast'),
(106, 'Ivan', 'Petrov', 'ivan.petrov@twitter.com', 'mz$fh)n5C', '53 Poplar Way', 'Dublin'),
(107, 'Eimear', 'O\'Sullivan', 'eimearosull88@gmail.com', '3MpV6JO', '8 Bourke Street', 'Cork'),
(108, 'Paweł', 'Kowalski', 'pawel.kowalski@tus.ie', 'SaCEN4YyuT', '8585 Oak Avenue', 'Limerick'),
(109, 'Síofra', 'Ní Dhonnabháin', 'siofra.nidhonnabha@gmail.com', 'Y#dbuGmM', '7 Flinders Lane', 'Galway'),
(110, 'Grzegorz', 'Nowak', 'grzegorz.nowak@examp@gmail.com', 'yFTI1ZmL', '34 Russell Street', 'Belfast'),
(111, 'Caitríona', 'Ní Ghallchóir', 'caitriona.nighallchoi@gmail.com', 'Qk90HXVlIl#', '18 Spencer Street', 'Dublin'),
(112, 'Andrzej', 'Kaczmarek', 'andrzej.kaczmarek@e@gmail.com', 'G*n9tqC8y', '9 Pitt Street', 'Cork'),
(113, 'Aoife', 'Ní Mhurchú', 'aoife.nimhurchu@e@gmail.com', ')c)24t6i', '9090 Pine Avenue', 'Limerick'),
(114, 'Pavel', 'Pavlov', 'pavel.pavlov@exam@gmail.com', '5jE696nt(', '17 Park Street', 'Galway'),
(115, 'Oksana', 'Semenova', 'oksana.semenova@ex@gmail.com', '-)&3A0rc', '9292 Elm Road', 'Belfast'),
(116, 'Kateryna', 'Ivanenko', 'kateryna.ivanenko@ex@gmail.com', 'o&BUY7G', '9393 Cedar Lane', 'Dublin'),
(117, 'Niall', 'Clarke', 'niall.clarke@exam@gmail.com', 'HhBwXrC1&', '9494 Elm Road', 'Cork'),
(118, 'Mateusz', 'Kowalski', 'mateusz.kowalski@ex@gmail.com', ')!XCLx(j', '9595 Oak Avenue', 'Limerick'),
(119, 'Róisín', 'Ní Dhonnabháin', 'roisin.nidhonnabha@gmail.com', 'BRH4rvhXl', '9696 Pine Lane', 'Galway'),
(120, 'Mariusz', 'Nowak', 'mariusz.nowak@examp@gmail.com', 'dKh@Ac^r5', '9797 Cedar Road', 'Belfast'),
(121, 'Eilis', 'Ní Mhurchú', 'eilis.nimhurchu@e@gmail.com', 'yYr-O)Y', '9898 Elm Lane', 'Dublin'),
(122, 'Michał', 'Kaczmarek', 'michal.kaczmarek@e@gmail.com', 'j)idt#oC', '9999 Oak Lane', 'Cork'),
(123, 'Sorcha', 'Ní Chonaill', 'sorcha.nichonaill@@gmail.com', 'HlT3C#XT', '0000 Pine Avenue', 'Limerick'),
(124, 'Sergei', 'Ivanov', 'sergei.ivanov@exam@gmail.com', 'n@5WN*Utl', '0101 Cedar Road', 'Galway'),
(125, 'Anastasiia', 'Semenova', 'anastasiia.semenova@ex@gmail.com', 'oPbTQW8z7', '0202 Elm Road', 'Belfast'),
(126, 'Hanna', 'Mazur', 'hanna.mazur@microsoft.com', 'g#J(if0o!', '0303 Cedar Lane', 'Dublin'),
(127, 'Trevor', 'Murphy', 'trevmurphy@yahoo.com', 'rAPEs%1E', '0404 Elm Road', 'Cork'),
(128, 'Iryna', 'Kovalenko', 'iryna.kovalenko@eir.ie', 'pfh*hex0lf', '0505 Oak Avenue', 'Limerick'),
(129, 'Caoimhe', 'Ní Mhurchú', 'caoimhe.nimhurchu@hotmail.com', 'hF)ynrZ', '0606 Pine Lane', 'Galway'),
(130, 'Dariusz', 'Nowak', 'dariusz_nowak@aol.com', '7v9U!guV7', '0707 Cedar Road', 'Belfast'),
(131, 'Ciara', 'Ní Chonaill', 'ciara.nichonaill@gmail.com', '^QV7PpRv@', '0808 Elm Road', 'Dublin'),
(132, 'Piotr', 'Kaczmarek', 'piotr.kaczmarek@microsoft.com', 'MCs-L2WaH', '0909 Oak Lane', 'Cork'),
(133, 'Méabh', 'Ní Dhonnabháin', 'meabhnidhonnabha@eir.ie', 'BKv@bTOV', '1010 Pine Avenue', 'Limerick'),
(134, 'Viktor', 'Ivanov', 'viktor.ivanov@gmit.ie', 's052cxSarp', '1111 Cedar Road', 'Galway'),
(135, 'Alina', 'Sokolova', 'alina.sokolova@gmail.com', 'ygIS#x4', '1212 Elm Lane', 'Belfast'),
(136, 'Anatoliy', 'Kovalev', 'anatoliy.kovalev@hotmail.com', 'FYhVHprn', '1313 Cedar Lane', 'Dublin'),
(137, 'Aoibheann', 'O\'Donnell', 'aoibheann.odonnell@aol.com', 'sJ2ap5Rv', '1414 Elm Road', 'Cork'),
(138, 'Ilya', 'Petrov', 'ilya.petrov@ul.ie', 'BO&J4mYUc8', '1515 Oak Avenue', 'Limerick'),
(139, 'Clíodhna', 'Ní Mhurchú', 'cliodhna.nimhurchu@hotmail.com', '8R0$X#l', '1616 Pine Lane', 'Galway'),
(140, 'Rafal', 'Kowalczyk', 'rafalyk@gmail.com', 'DQ(OF3r3', '1717 Cedar Road', 'Belfast'),
(141, 'Aisling', 'Creed', 'aisling.creed@turnpike.com', '80FP6evRx#', '1818 Elm Road', 'Dublin'),
(142, 'Arkadiy', 'Sokolov', 'arkadiy_sokolov@gmail.com', 'cMzB&yv7', '1919 Oak Lane', 'Cork'),
(143, 'Eilish', 'Ní Dhonnabháin', 'eilish.nidhonnabha@gmail.com', 'YfMlF8*p5', '2020 Pine Avenue', 'Limerick'),
(144, 'Pavel', 'Ivanov', 'pavel.ivanov@gmail.com', 'jLT!mCpTQt', '2121 Cedar Road', 'Galway'),
(145, 'Olga', 'Semenova', 'olgasem2023@gmail.com', '%2(uTcKz', '2222 Elm Lane', 'Belfast'),
(146, 'Katarzyna', 'Wójcik', 'katarzyna.wojcik@gmail.com', 'fSASRebO', '2323 Cedar Lane', 'Dublin'),
(147, 'Padraig', 'Ó Súilleabháin', 'padraig.osuilleabha@gmail.com', 'dr2A1yTb9', '2424 Elm Road', 'Cork'),
(148, 'Nina', 'Sokolova', 'nina.sokolova@tus.ie', '^I1ar#vhS', '2525 Oak Avenue', 'Limerick'),
(149, 'Séan', 'Ó Raghallaigh', 'sean.oraghallaig@gmit.ie', '0r5OpVz4', '2626 Pine Lane', 'Galway'),
(150, 'Natalia', 'Kowalczyk', 'natalia.kowalczyk@qub.co.uk', 'w&z0kV-dY', '2727 Cedar Road', 'Belfast'),
(151, 'Ciarán', 'Ó Néill', 'coneill88@gmail.com', 'c*rH0VU', '2828 Elm Road', 'Dublin'),
(152, 'Svitlana', 'Ivanenko', 'sviivan@gmail.com', 'fLh!$(J6', '2929 Oak Lane', 'Cork');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `colour` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `description`, `price`, `colour`) VALUES
(1, 'Organic Cotton Men\'s T-Shirt', 'A comfortable and sustainable organic cotton t-shirt for men.', '29.99', 'White'),
(2, 'Recycled Denim Jeans', 'Stylish jeans made from recycled denim material.', '79.99', 'Blue'),
(3, 'Women\'s Eco-Friendly Dress', 'A beautiful and eco-friendly dress for women made from sustainable materials.', '59.99', 'Green'),
(4, 'Organic Men\'s Jacket', 'A warm and sustainable jacket for men made from organic materials.', '99.99', 'Black'),
(5, 'Recycled Sneakers', 'Stylish sneakers made from recycled materials.', '49.99', 'Gray'),
(6, 'Sustainable Sun Hat', 'A sustainable sun hat made from eco-friendly materials.', '19.99', 'Beige'),
(7, 'Organic Cotton Women\'s T-Shirt', 'A comfortable and sustainable organic cotton t-shirt for women.', '27.99', 'Pink'),
(8, 'Recycled Men\'s Jeans', 'Eco-friendly jeans made from recycled denim material.', '69.99', 'Dark Blue'),
(9, 'Sustainable Women\'s Blouse', 'A stylish and sustainable blouse for women made from eco-friendly materials.', '49.99', 'White'),
(10, 'Recycled Men\'s Jacket', 'Warm and eco-friendly jacket made from recycled materials.', '89.99', 'Navy'),
(11, 'Bamboo Fiber Men\'s Polo Shirt', 'A comfortable and eco-friendly polo shirt for men made from bamboo fiber.', '39.99', 'Green'),
(12, 'Recycled Women\'s Skirt', 'Stylish skirt for women made from recycled materials.', '49.99', 'Purple'),
(13, 'Organic Hemp Shoes', 'Eco-conscious shoes made from organic hemp material.', '59.99', 'Natural'),
(14, 'Sustainable Men\'s Cardigan', 'A sustainable cardigan for men made from eco-friendly materials.', '69.99', 'Navy'),
(15, 'Recycled PET Backpack', 'Eco-conscious backpack made from recycled PET bottles.', '29.99', 'Gray'),
(16, 'Sustainable Linen Women\'s Pants', 'Comfortable and eco-friendly linen pants for women.', '44.99', 'Beige'),
(17, 'Recycled Men\'s Hoodie', 'Stylish hoodie for men made from recycled materials.', '59.99', 'Gray'),
(18, 'Organic Cotton Women\'s Sweater', 'A cozy and eco-friendly sweater for women made from organic cotton.', '54.99', 'Blue'),
(19, 'Bamboo Fiber Men\'s Shorts', 'Comfortable and eco-friendly shorts for men made from bamboo fiber.', '34.99', 'Black'),
(20, 'Recycled Women\'s Sweater', 'Stylish sweater for women made from recycled materials.', '54.99', 'Gray'),
(21, 'Recycled PET Women\'s Jacket', 'Stylish jacket for women made from recycled PET bottles.', '79.99', 'Black'),
(22, 'Organic Linen Men\'s Shirt', 'Comfortable and eco-friendly linen shirt for men.', '44.99', 'White'),
(23, 'Sustainable Women\'s Sandals', 'Eco-conscious sandals made from sustainable materials.', '39.99', 'Brown'),
(24, 'Recycled Men\'s Belt', 'Stylish belt for men made from recycled materials.', '19.99', 'Black'),
(25, 'Organic Cotton Women\'s Blouse', 'A sustainable blouse for women made from organic cotton.', '49.99', 'Red'),
(26, 'Recycled Denim Women\'s Jacket', 'Stylish jacket for women made from recycled denim material.', '69.99', 'Denim Blue'),
(27, 'Sustainable Men\'s Beanie', 'A cozy and eco-friendly beanie for men made from sustainable materials.', '24.99', 'Gray'),
(28, 'Organic Linen Women\'s Pants', 'Comfortable and eco-friendly linen pants for women.', '44.99', 'Beige'),
(29, 'Bamboo Fiber Women\'s T-Shirt', 'A comfortable and eco-friendly t-shirt for women made from bamboo fiber.', '29.99', 'Green'),
(30, 'Recycled PET Men\'s Backpack', 'Eco-conscious backpack made from recycled PET bottles.', '34.99', 'Gray'),
(31, 'Organic Hemp Women\'s Sandals', 'Eco-conscious sandals made from organic hemp material for women.', '39.99', 'Natural'),
(32, 'Sustainable Men\'s Swim Shorts', 'Comfortable and eco-friendly swim shorts for men.', '29.99', 'Blue'),
(33, 'Recycled PET Women\'s Bag', 'Stylish bag for women made from recycled PET bottles.', '49.99', 'Gray'),
(34, 'Organic Linen Men\'s Shorts', 'Comfortable and eco-friendly linen shorts for men.', '34.99', 'Khaki'),
(35, 'Sustainable Women\'s Scarf', 'A cozy and eco-friendly scarf for women made from sustainable materials.', '19.99', 'Green'),
(36, 'Recycled Men\'s Backpack', 'Eco-conscious backpack made from recycled materials for men.', '39.99', 'Black'),
(37, 'Bamboo Fiber Women\'s Leggings', 'Comfortable and eco-friendly leggings for women made from bamboo fiber.', '34.99', 'Gray'),
(38, 'Recycled PET Men\'s Hat', 'Eco-conscious hat made from recycled PET bottles for men.', '24.99', 'Navy'),
(39, 'Organic Hemp Women\'s T-Shirt', 'A comfortable and eco-friendly t-shirt for women made from organic hemp.', '29.99', 'Blue'),
(40, 'Sustainable Men\'s Sunglasses', 'Eco-conscious sunglasses made from sustainable materials for men.', '39.99', 'Brown'),
(41, 'Organic Cotton Men\'s Chinos', 'Stylish and eco-friendly chinos for men made from organic cotton.', '49.99', 'Olive'),
(42, 'Recycled PET Women\'s Backpack', 'Eco-conscious backpack made from recycled PET bottles for women.', '44.99', 'Teal'),
(43, 'Sustainable Men\'s Button-Up Shirt', 'A comfortable and eco-friendly button-up shirt for men made from sustainable materials.', '39.99', 'Navy'),
(44, 'Recycled Women\'s Backpack', 'Eco-conscious backpack made from recycled materials for women.', '44.99', 'Gray'),
(45, 'Organic Hemp Men\'s Shorts', 'Comfortable and eco-friendly shorts for men made from organic hemp.', '34.99', 'Navy'),
(46, 'Sustainable Women\'s Belt', 'Stylish and eco-friendly belt for women made from sustainable materials.', '24.99', 'Brown'),
(47, 'Recycled Men\'s Trousers', 'Eco-conscious trousers for men made from recycled materials.', '49.99', 'Black'),
(48, 'Bamboo Fiber Women\'s Tank Top', 'A comfortable and eco-friendly tank top for women made from bamboo fiber.', '29.99', 'Green'),
(49, 'Recycled PET Men\'s Sandals', 'Eco-conscious sandals made from recycled PET bottles for men.', '39.99', 'Black'),
(50, 'Organic Linen Women\'s Jumpsuit', 'Stylish and eco-friendly jumpsuit for women made from organic linen.', '59.99', 'Beige'),
(51, 'Recycled Men\'s Blazer', 'Eco-conscious blazer for men made from recycled materials.', '69.99', 'Charcoal'),
(52, 'Sustainable Women\'s Sunglasses', 'Eco-conscious sunglasses made from sustainable materials for women.', '34.99', 'Brown'),
(53, 'Organic Cotton Men\'s Polo Shirt', 'Stylish and eco-friendly polo shirt for men made from organic cotton.', '39.99', 'Navy'),
(54, 'Recycled PET Women\'s Hat', 'Eco-conscious hat made from recycled PET bottles for women.', '24.99', 'Pink'),
(55, 'Sustainable Men\'s Chinos', 'Comfortable and eco-friendly chinos for men made from sustainable materials.', '49.99', 'Olive'),
(56, 'Recycled Women\'s Jumpsuit', 'Eco-conscious jumpsuit for women made from recycled materials.', '59.99', 'Black'),
(57, 'Organic Cotton Women\'s Leggings', 'Eco-friendly leggings for women made from organic cotton.', '34.99', 'Black'),
(58, 'Sustainable Men\'s Sneakers', 'Comfortable and eco-friendly sneakers for men made from sustainable materials.', '59.99', 'Gray'),
(59, 'Plaid Shirt', 'For those who prefer life without sleeves', '135.99', 'Black and Red');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `review_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `review_text` text DEFAULT NULL,
  `review_date` date DEFAULT NULL,
  `flagged_as_spam` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`review_id`, `customer_id`, `product_id`, `rating`, `review_text`, `review_date`, `flagged_as_spam`) VALUES
(1, 1, 23, 5, 'Great product! Excellent quality and eco-friendly materials.', '2023-05-15', 0),
(2, 34, 2, 4, 'I love the sustainability of this clothing. Very comfortable.', '2023-05-16', 0),
(3, 16, 45, 4, 'Good product, but I expected more color choices.', '2023-05-17', 0),
(4, 78, 4, 5, 'Amazing sustainable fashion. I\'m impressed!', '2023-05-18', 0),
(5, 152, 5, 3, 'Decent product, but it could be more affordable.', '2023-05-19', 0),
(6, 152, 41, 5, 'Exceptional quality and eco-friendly. I highly recommend it!', '2023-05-20', 0),
(7, 152, 31, 4, 'Sustainable fashion is the future, and this product shows it.', '2023-05-21', 0),
(8, 2, 8, 4, 'I\'m pleased with my purchase. Great for the environment.', '2023-05-22', 0),
(9, 14, 9, 3, 'Nice product, but the fit is a bit off for me.', '2023-05-23', 0),
(10, 32, 12, 5, 'Top-notch sustainable clothing. Will buy more!', '2023-05-24', 0),
(11, 18, 18, 4, 'Quality materials and a positive eco-impact.', '2023-05-25', 0),
(12, 131, 15, 5, 'Impressive design and commitment to sustainability.', '2023-05-26', 0),
(13, 100, 13, 4, 'Sustainable fashion at its best! Truly comfortable.', '2023-05-27', 0),
(14, 133, 7, 3, 'Good product, but the color isn\'t what I expected.', '2023-05-28', 0),
(15, 12, 15, 5, 'Affordable and eco-friendly. Can\'t ask for more!', '2023-05-29', 0),
(16, 15, 32, 5, 'Sustainable fashion with a great style. Love it!', '2023-05-30', 0),
(17, 12, 17, 4, 'Pleasantly surprised by the quality and sustainability.', '2023-05-31', 0),
(18, 56, 2, 3, 'Good product overall, but sizing can be tricky.', '2023-06-01', 0),
(19, 86, 5, 5, 'Outstanding commitment to the environment. Impressed.', '2023-06-02', 0),
(20, 45, 20, 4, 'Nice product, but could offer more color options.', '2023-06-03', 0),
(21, 116, 45, 5, 'Eco-friendly fashion at its finest. Highly recommended!', '2023-06-04', 0),
(22, 98, 32, 4, 'I appreciate the sustainable choices made in this product.', '2023-06-05', 0),
(23, 1, 34, 5, 'Very comfortable and supports a great cause. Love it!', '2023-06-06', 0),
(24, 4, 34, 3, 'Good, but sizing could be more accurate.', '2023-06-07', 0),
(25, 12, 4, 5, 'Eco-conscious and budget-friendly. Can\'t go wrong!', '2023-06-08', 0),
(26, 26, 26, 4, 'Sustainable materials and a stylish look. Satisfied.', '2023-06-09', 0),
(27, 7, 27, 5, 'Impressive design and eco-friendly. Highly satisfied!', '2023-06-10', 0),
(28, 7, 28, 3, 'Decent product, but the fit isn\'t perfect for me.', '2023-06-11', 0),
(29, 15, 29, 4, 'Great quality and affordable for sustainable fashion.', '2023-06-12', 0),
(30, 19, 30, 5, 'Top-notch eco-conscious fashion. Will buy again!', '2023-06-13', 0),
(31, 1, 31, 5, 'Great product! Excellent quality and eco-friendly materials.', '2023-06-14', 0),
(32, 19, 32, 4, 'I love the sustainability of this clothing. Very comfortable.', '2023-06-15', 0),
(33, 77, 33, 4, 'Good product, but I expected more color choices.', '2023-06-16', 0),
(34, 89, 34, 5, 'Amazing sustainable fashion. I\'m impressed!, And it takes a lot to impress me', '2023-06-17', 0),
(35, 52, 35, 3, 'Decent product, but it could be more affordable. Think of us poor people!!', '2023-06-18', 1),
(36, 123, 36, 5, 'Exceptional quality and eco-friendly. I highly recommend it!', '2023-06-19', 0),
(37, 145, 37, 4, 'Sustainable fashion is the future, and this product shows it.', '2023-06-20', 0),
(38, 8, 38, 3, 'Nice product, but the fit is a bit off for me.', '2023-06-21', 0),
(39, 95, 39, 5, 'Top-notch sustainable clothing. Will buy more!', '2023-06-22', 0),
(40, 110, 40, 4, 'Quality materials and a positive eco-impact.', '2023-06-23', 0),
(41, 32, 41, 5, 'Outstanding commitment to the environment. Impressed.', '2023-06-24', 0),
(42, 125, 42, 4, 'Nice product, but could offer more colour options.', '2023-06-25', 0),
(43, 72, 43, 5, 'Eco-friendly fashion at its finest. Highly recommended!', '2023-06-26', 0),
(44, 15, 44, 4, 'I appreciate the sustainable choices made in this product.', '2023-06-27', 0),
(45, 103, 45, 5, 'Very comfortable and supports a great cause. Love it!', '2023-06-28', 0),
(46, 41, 46, 3, 'Good, but sizing could be more accurate.', '2023-06-29', 0),
(47, 67, 47, 5, 'Eco-conscious and budget-friendly. Can\'t go wrong!', '2023-06-30', 0),
(48, 137, 48, 4, 'Sustainable materials and a stylish look. Satisfied.', '2023-07-01', 0),
(49, 85, 49, 5, 'Impressive design and eco-friendly. Highly satisfied!', '2023-07-02', 0),
(50, 28, 50, 3, 'Decent product, but the fit isn\'t perfect for me.', '2023-07-03', 0),
(51, 47, 51, 5, 'Sustainable fashion with a great style. Love it!', '2023-07-04', 0),
(52, 121, 52, 4, 'Pleasantly surprised by the quality and sustainability and looked good against my pale Irish skin.', '2023-07-05', 0),
(53, 18, 53, 3, 'Good product overall, but sizing can be tricky.', '2023-07-06', 0),
(54, 75, 54, 5, 'Outstanding commitment to the environment.', '2023-07-07', 0),
(55, 82, 55, 4, 'Nice product.', '2023-07-08', 0),
(56, 33, 56, 5, 'Eco-friendly fashion at its finest. Highly recommended!', '2023-07-09', 0),
(57, 94, 57, 4, 'I appreciate the sustainable choices made in this product.', '2023-07-10', 0),
(58, 66, 58, 5, 'Very comfortable and supports a great cause. Love it!', '2023-07-11', 0),
(59, 12, 1, 3, 'Good, but sizing could be more accurate.', '2023-07-12', 0),
(60, 12, 6, 5, 'Eco-conscious and budget-friendly. Whats not to like?', '2023-07-13', 0),
(61, 48, 58, 2, 'Not satisfied with the quality. Expected better.', '2023-07-14', 0),
(62, 136, 12, 2, 'Disappointed with the product. Poor quality materials.', '2023-07-15', 0),
(63, 14, 1, 2, 'Product doesn\'t meet my expectations. Unsatisfactory.', '2023-07-16', 0),
(64, 95, 5, 1, 'Huge letdown. I expected better quality. About as useful as a pair of sunglasses to a man with one ear!', '2023-07-17', 1),
(65, 64, 6, 3, 'Average product. Nothing special.', '2023-07-18', 0),
(66, 87, 19, 2, 'Overpriced for the quality provided.', '2023-07-19', 0),
(67, 74, 36, 1, 'Joke shop of a place', '2023-07-20', 1),
(68, 57, 23, 1, 'Worst purchase ever. Avoid at all costs. Same old Zelora, always out to rip off their customers.', '2023-07-21', 1),
(69, 150, 16, 2, 'Subpar product. Not worth the money.', '2023-07-22', 0),
(70, 41, 22, 2, 'Extremely dissatisfied with the product.', '2023-07-23', 0),
(71, 108, 23, 1, 'Regret buying this. Poor quality and high price.', '2023-07-24', 1),
(72, 49, 45, 2, 'Not what I expected. Product falls short.', '2023-07-25', 0),
(73, 6, 3, 2, 'Highly disappointed. Don\'t recommend it.', '2023-07-26', 0),
(74, 144, 7, 1, 'I bought this for my mother. She hated it and now hates me. Thanks for nothing Zelora', '2023-07-27', 1),
(75, 70, 17, 2, 'Product quality is disappointing. Overpriced.', '2023-07-28', 0),
(76, 45, 6, 1, 'Wasted my money. Poor-quality product.', '2023-07-29', 0),
(77, 101, 19, 2, 'Not worth the price. Very dissatisfied.', '2023-07-30', 0),
(78, 88, 8, 2, 'Very disappointed. Quality is below par.', '2023-07-31', 0),
(79, 131, 39, 1, 'Awful product. Don\'t make the same mistake I did.', '2023-08-01', 0),
(80, 3, 1, 2, 'Extremely unsatisfied with the purchase.', '2023-08-02', 0),
(81, 12, 7, 4, 'I love the colour options for this product. Great!', '2023-08-03', 0),
(82, 35, 15, 2, 'Disappointed with the quality. Not worth it.', '2023-08-04', 0),
(83, 99, 23, 3, 'Average product. Decent quality for the price.', '2023-08-05', 0),
(84, 53, 31, 5, 'Exceptional quality and eco-friendly. Highly recommended!', '2023-08-06', 0),
(85, 41, 8, 1, 'Terrible product. Avoid it at all costs.', '2023-08-07', 0),
(86, 5, 16, 4, 'Sustainable fashion with a stylish look. Satisfied.', '2023-08-08', 0),
(87, 38, 3, 3, 'Product quality is okay, but could be better.', '2023-08-09', 0),
(88, 14, 50, 2, 'Not what I expected. A letdown in terms of quality.', '2023-08-10', 0),
(89, 8, 47, 4, 'Sustainable choices made in this product are appreciated.', '2023-08-11', 0),
(90, 1, 33, 5, 'Outstanding commitment to the environment. Impressed.', '2023-08-12', 0),
(91, 19, 55, 2, 'Product doesn\'t meet my expectations', '2023-08-12', 0),
(101, 17, 17, 4, 'Nice product, but could offer more color options.', '2023-08-23', 0),
(102, 36, 36, 3, 'Good, but sizing could be more accurate.', '2023-08-24', 0),
(103, 55, 55, 5, 'Eco-conscious and budget-friendly. Can\'t go wrong!', '2023-08-25', 0),
(104, 25, 25, 2, 'Subpar product. Not worth the money. Insert sad face emoji', '2023-08-26', 0),
(105, 42, 42, 2, 'Extremely dissatisfied with the product.', '2023-08-27', 0),
(106, 32, 32, 1, 'Regret buying this. Poor quality and high price.', '2023-08-28', 0),
(107, 10, 10, 2, 'Not what I expected. Product falls short.', '2023-08-29', 0),
(108, 46, 46, 1, 'Worst purchase ever. Avoid at all costs.', '2023-08-30', 0),
(109, 24, 24, 4, 'Decent product, but the fit isn\'t perfect for me.', '2023-08-31', 0),
(110, 52, 52, 2, 'Ah here, leave it out. Highly disappointed. Don\'t recommend it.', '2023-09-01', 1),
(111, 26, 22, 5, 'Impressive design and eco-friendly. Highly satisfied!', '2023-09-02', 0),
(112, 3, 19, 2, 'Not worth the price. Very dissatisfied.', '2023-09-03', 0),
(113, 50, 50, 4, 'Sustainable fashion with a great style. Love it!', '2023-09-04', 0),
(114, 52, 5, 2, 'Some shower of chancers. I hope ye all die', '2023-09-05', 1),
(115, 8, 16, 3, 'Product quality is okay, but could be better.', '2023-09-06', 0),
(116, 11, 11, 5, 'Great product! Excellent quality and eco-friendly materials.', '2023-09-07', 0),
(117, 29, 7, 1, 'Terrible product. Don\'t waste your money.', '2023-09-08', 0),
(118, 41, 38, 4, 'Sustainable fashion with a stylish look. Satisfied.', '2023-09-09', 0),
(119, 45, 52, 3, 'Product quality is okay, but could be better.', '2023-09-10', 0),
(120, 55, 11, 2, 'Overpriced for the quality provided.', '2023-09-11', 0),
(121, 16, 41, 5, 'Exceptional quality and eco-friendly. Highly recommended!', '2023-09-12', 0),
(122, 27, 6, 1, 'Wasted my money. Poor-quality product.', '2023-09-13', 0),
(123, 33, 29, 4, 'Impressive design and eco-friendly. Satisfied.', '2023-09-14', 0),
(124, 20, 18, 2, 'Huge letdown. I expected better quality.', '2023-09-15', 0),
(125, 47, 54, 5, 'Sustainable fashion is the future, and this product shows it.', '2023-09-16', 0),
(126, 18, 44, 2, 'Not as eco-friendly as claimed. Disappointed.', '2023-09-17', 0),
(127, 44, 56, 4, 'I appreciate the sustainable choices made in this product.', '2023-09-18', 0),
(128, 24, 49, 1, 'Awful awful product. Don\'t make the same mistake I did.', '2023-09-19', 0),
(129, 13, 21, 4, 'Nice product, but could offer more color options.', '2023-09-20', 0),
(130, 22, 30, 3, 'Good, but sizing could be more accurate.', '2023-09-21', 0),
(131, 152, 59, 3, 'Very nice and quality was good', '2024-05-30', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`),
  ADD KEY `idx_customer_id` (`customer_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `idx_customer_id_reviews` (`customer_id`),
  ADD KEY `idx_product_id_reviews` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=159;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `review_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```

### 3. Examine Table Relationships
- Observe the relationships between `customers`, `products`, and `reviews` based on the foreign keys.


### 4. Configure the Database
- Open the `application.properties` file in the newly created project and add the following configuration for connecting to the `jpa_example` database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jpa_example
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

_Ensure to use your correct MySQL username and password._

### 5. Create Entity Classes

- Add the following entity classes representing the `customers`, `products`, and `reviews` tables.

```java

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Review> reviewList;
}

```

```java

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "colour")
    private String colour;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Review> reviewList;

}


```
```java

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    @ToString.Exclude
    private Customer customer;

    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    @ToString.Exclude
    private Product product;

    @Column(name = "rating")
    private Integer rating;

    @Lob
    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "review_date")
    @Temporal(TemporalType.DATE)
    private Date reviewDate;

    @Column(name = "flagged_as_spam")
    private Boolean flaggedAsSpam;

}
```

### 6. Create a `CustomerRepository` class. 

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> findAll() {
        String query = "SELECT c FROM Customer c";
        return entityManager.createQuery(query, Customer.class).getResultList();
    }

    public void delete(Customer customer) {
        if (entityManager.contains(customer)) {
            entityManager.remove(customer);
        } else {
            entityManager.remove(entityManager.merge(customer));
        }
    }
}
```
_This class is a Spring Data repository that handles basic CRUD (Create, Read, Update, Delete) operations for `Customer` entities and uses an `EntityManager` to interact with the database. The class is marked as `@Repository`, meaning it's a data access component, and `@Transactional`, ensuring that database operations are handled within a transaction. Note the use of [JPQL](https://www.tutorialspoint.com/jpa/jpa_jpql.htm) (Java Persistence Query Language) in the `findAll()` method_

### 7. Create a `CustomerService` class
```java
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
```
_This class wraps the `CustomerRepository` in a Spring Boot application. This design follows the Service Layer pattern, where the service class provides business logic and acts as an intermediary between the controller (see the next step) and the repository (handling data access)._

### 8. Create a `CustomerController`.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //This method retrieves a list of all customers from the CustomerService.
    //This method is triggered when someone accesses the URL (customers/) and displays all customers in the view.
    @GetMapping("/")
     public ModelAndView getAllCustomers() {

         List<Customer> allCustomers = customerService.getAllCustomers();
         allCustomers.forEach(System.out::println);
         return new ModelAndView("/displayAllCustomers","customerList", allCustomers);
    }

    //This method retrieves a specific customer by their customerId.
    //This method is triggered when someone accesses a URL like customers/123, displaying a specific customer's details in the view.
    @GetMapping("/{customerId}")
    public ModelAndView getOneCustomer(@PathVariable Long customerId) {

        Customer aCustomer = customerService.getCustomerById(customerId);
        System.out.println(aCustomer);
        return new ModelAndView("/displayOneCustomer","aCustomer", aCustomer);
    }

}
```
_Note that this class is annotated with `@Controller` and has an autowired reference to the CustomerService. The controller will handle incoming requests (through the browser)._

### 9. Add view templates.
- Add two Thymeleaf templates: `displayAllCustomers.html` and `displayOneCustomer.html`.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Customers</title>
</head>
<body>
All Customers are to be displayed here! <br>
For the time being, check the console and observe the output
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>One Customer</title>
</head>
<body>
One Customer is to be displayed here! <br>
For the time being, check the console and observe the output
</body>
</html>
```

### 10. Observe Console Output
- Run and test the application. Both controller methods will currently display data in the console while also displaying the static HTML templates.


### 11. Extend `getOneCustomer()` method
- Modify this method in the controller to also display any associated customer reviews in the console output. (_For example: Customer 1 has written 4 reviews_).

### 12. Add Remaining CRUD Operations
- Delete a customer by ID (the ID can be passed through the URL).
- Add a customer (hard-code the data for this within the controller method itself).
- Update a customer (this will involve the retrival of a customer by ID, and then updating some or all of the data for this customer. Again, you can hard-code the data for the update with the customers ID being passed through the URL).

_(you will be required you to make calls to the appropriate methods in the service class for task 12)._

### 13. Enhance Thymeleaf Views
- Modify `displayAllCustomers.html` to show all customers in a HTML table. For example:
  
  ![image](https://github.com/user-attachments/assets/37a20826-cccd-4d3b-b634-1333a6a600e8)




- Modify `displayOneCustomer.html` to display a single customer’s details and any reviews they have written. For example:
  
  ![image](https://github.com/user-attachments/assets/462af341-9429-4aee-9441-c46da6852ae4)

  ![image](https://github.com/user-attachments/assets/c6400048-7a5d-4c17-9a18-146a6fce5497)



_(you will need to use Thymeleaf for task 13)._


**Note**: My project has the following structure. 

![image](https://github.com/user-attachments/assets/7c92c541-365e-446f-a2ed-dfb9b17ea47c)

_With the main class, `LabExe2Application.java` located in a package called `src.application`. All other packages and classes are stored within this package._






