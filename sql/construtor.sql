CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    price double,
    account_id INT,
    constraint fk_orders_account FOREIGN KEY (account_id)
    REFERENCES accounts(id)
)


CREATE TABLE product (
    code INT(11) PRIMARY KEY,
    name varchar(30),
    price double,
    constraint fk_orders_account FOREIGN KEY ()
    REFERENCES accounts(email)
)

create table order_product (
	order_id INT,
    code INT(11),
     constraint fk_product_order FOREIGN KEY (order_id)
    REFERENCES orders(order_id),
     constraint fk_product_code FOREIGN KEY (code)
    REFERENCES product(code)
)

CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(20),
    last_name varchar(20),
    email varhcar(30),
    balance double,
    password varchar(20),
    gender varchar (3)
    birhday date
)
