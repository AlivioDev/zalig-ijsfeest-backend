 insert into products (id, product_name, number_of_persons_one, number_of_persons_two, number_of_persons_three, price_one, price_two, price_three) values (1001, 'IJstaart Rond', '4/6 personen', '8/10 personen', '14/16 personen', 20.00, 26.50, 39.00);
 insert into products (id, product_name, number_of_persons_one, number_of_persons_two, price_one, price_two) values (1002, 'IJstaart Kerstster', '5/6 personen', '10/12 personen', 25.00, 35.00);
 insert into products (id, product_name, number_of_persons_one, number_of_persons_two, price_one, price_two) values (1003, 'IJstaart Kerstklok', '5/6 personen', '14/16 personen', 25.00, 39.00);
 insert into products (id, product_name, number_of_persons_one, price_one) values (1004, 'Cassata', '8/10 personen', 32.50);
 insert into products (id, product_name, number_of_persons_one, price_one) values (1005, 'Tulband', '8/10 personen', 32.50);
 insert into products (id, product_name, number_of_persons_one, price_one) values (1006, 'Kerstkathedraal', '8/10 personen', 35.00);
 insert into products (id, product_name, number_of_persons_one, price_one) values (1007, 'Bombe', '3/4 personen', 19.50);
 insert into products (id, product_name, price_one) values (1008, 'Profiteroles', 5.00);

 insert into icecreamflavors values ('aardbeien');
 insert into icecreamflavors values ('banaan');
 insert into icecreamflavors values ('roomijs');
 insert into icecreamflavors values ('amarena');
 insert into icecreamflavors values ('lemon cheesecake');
 insert into icecreamflavors values ('bosbessenyoghurt');
 insert into icecreamflavors values ('yoghurt');
 insert into icecreamflavors values ('yoghurt passievrucht');
 insert into icecreamflavors values ('zuppa inglese');
 insert into icecreamflavors values ('chocolade');
 insert into icecreamflavors values ('mokka');
 insert into icecreamflavors values ('brownies');
 insert into icecreamflavors values ('biscotti');
 insert into icecreamflavors values ('stracciatella');
 insert into icecreamflavors values ('soescholato');
 insert into icecreamflavors values ('tiramisu');
 insert into icecreamflavors values ('black cookies');
 insert into icecreamflavors values ('bianco doro');
 insert into icecreamflavors values ('hazelnoot');
 insert into icecreamflavors values ('pralinone');
 insert into icecreamflavors values ('pistache');
 insert into icecreamflavors values ('malaga');
 insert into icecreamflavors values ('kaneel');
 insert into icecreamflavors values ('butterscotch');
 insert into icecreamflavors values ('stroopwafel');
 insert into icecreamflavors values ('salted caramel');

 insert into sorbetflavors values ('meloen');
 insert into sorbetflavors values ('citroen');
 insert into sorbetflavors values ('sinaasappel');
 insert into sorbetflavors values ('mango');
 insert into sorbetflavors values ('cassis');
 insert into sorbetflavors values ('rode guave');
 insert into sorbetflavors values ('appel');
 insert into sorbetflavors values ('framboos');

 insert into users (username, email, first_name, last_name, password, phone_number) VALUES ('user01', 'user01@test.nl', 'test01', 'testuser01', '$2a$10$/bLChEVlakQB4chrCsFw6.gxDFz9qSwlR4.apaxdTKxd3/mQM/mZi', '012-3456789');
 insert into users (username, email, first_name, last_name, password, phone_number) VALUES ('user02', 'user02@test.nl', 'test02', 'testuser02', '$2a$10$/bLChEVlakQB4chrCsFw6.gxDFz9qSwlR4.apaxdTKxd3/mQM/mZi', '012-3456789');
 insert into users (username, email, password) VALUES ('admin01', 'admin01@test.nl', '$2a$10$n9WtjvLx7mhAHgERb7Px6.g7zCYnveEvCGwNCyqUNSrmguCj4y9KG');

 insert into authorities (username, authority) VALUES ('user01', 'USER');
 insert into authorities (username, authority) VALUES ('user02', 'USER');
 insert into authorities (username, authority) values ('admin01', 'ADMIN');

 insert into orders (id, order_amount, pickup_date, payment_status, username) VALUES (1012, 55.00, '24-12-2022 13:15', 'online', 'user01');
 insert into orders (id, order_amount, pickup_date, payment_status, username) VALUES (1013, 40.00, '24-12-2022 12:45', 'tijdens afhalen', 'user02');

 insert into orderlines (id, product_name, flavors, options, price, order_id) VALUES ('user011014', 'IJstaart Rond', 'banaan, banaan, banaan, banaan', '4/6 personen', 20.00, 1012);
 insert into orderlines (id, product_name, flavors, options, price, order_id) VALUES ('user011015', 'IJstaart Ster', 'banaan, banaan, banaan', '10/12 personen', 35.00, 1012);
 insert into orderlines (id, product_name, flavors, options, persons, price, order_id) VALUES ('user021016', 'Profiteroles', 'banaan, banaan', 'other', 8, 20.00, 1013);

