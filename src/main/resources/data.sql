insert into products (id, product_name, number_of_persons_one, number_of_persons_two, number_of_persons_three, price_one, price_two, price_three) values (1001, 'IJstaart Rond', '4/6 personen', '8/10 personen', '14/16 personen', 20.00, 26.50, 39.00);
insert into products (id, product_name, number_of_persons_one, number_of_persons_two, price_one, price_two) values (1002, 'IJstaart Kerstster', '5/6 personen', '10/12 personen', 25.00, 35.00);
insert into products (id, product_name, number_of_persons_one, number_of_persons_two, price_one, price_two) values (1003, 'IJstaart Kerstklok', '5/6 personen', '14/16 personen', 25.00, 39.00);
insert into products (id, product_name, number_of_persons_one, price_one) values (1004, 'Cassata', '8/10 personen', 32.50);
insert into products (id, product_name, number_of_persons_one, price_one) values (1005, 'Tulband', '8/10 personen', 32.50);
insert into products (id, product_name, number_of_persons_one, price_one) values (1006, 'Kerstkathedraal', '8/10 personen', 35.00);
insert into products (id, product_name, number_of_persons_one, price_one) values (1007, 'Bombe', '3/4 personen', 19.50);
insert into products (id, product_name, number_of_persons_one, price_one) values (1008, 'Profiterolles', 'Vanaf 6 personen', 5.00);

insert into icecreamflavors values (1100, 'aarbeien');
insert into icecreamflavors values (1101, 'banaan');
insert into icecreamflavors values (1102, 'roomijs');
insert into icecreamflavors values (1103, 'amarena');
insert into icecreamflavors values (1104, 'lemon_cheesecake');
insert into icecreamflavors values (1105, 'bosbessenyoghurt');
insert into icecreamflavors values (1106, 'yoghurt');
insert into icecreamflavors values (1107, 'yoghurt_passievrucht');
insert into icecreamflavors values (1108, 'zuppa_inglese');
insert into icecreamflavors values (1109, 'chocolade');
insert into icecreamflavors values (1110, 'mokka');
insert into icecreamflavors values (1111, 'brownies');
insert into icecreamflavors values (1112, 'biscotti');
insert into icecreamflavors values (1113, 'stracciatella');
insert into icecreamflavors values (1114, 'soesocholato');
insert into icecreamflavors values (1115, 'tiramisu');
insert into icecreamflavors values (1116, 'black_cookies');
insert into icecreamflavors values (1117, 'bianco_doro');
insert into icecreamflavors values (1118, 'hazelnoot');
insert into icecreamflavors values (1119, 'pralinone');
insert into icecreamflavors values (1120, 'pistache');
insert into icecreamflavors values (1121, 'malaga');
insert into icecreamflavors values (1122, 'kaneel');
insert into icecreamflavors values (1123, 'butterschotch');
insert into icecreamflavors values (1124, 'stroopwafel');
insert into icecreamflavors values (1125, 'salted_caramel');

insert into sorbetflavors values (1150, 'meloen');
insert into sorbetflavors values (1151, 'citroen');
insert into sorbetflavors values (1152, 'sinaasappel');
insert into sorbetflavors values (1153, 'mango');
insert into sorbetflavors values (1154, 'cassis');
insert into sorbetflavors values (1155, 'rode guave');
insert into sorbetflavors values (1156, 'appel');
insert into sorbetflavors values (1157, 'framboos');

insert into users (username, password, email, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE);
insert into users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);

insert into authorities (username, authority) VALUES ('user', 'ROLE_USER');
insert into authorities (username, authority) VALUES ('admin', 'ROLE_USER');
insert into authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');


