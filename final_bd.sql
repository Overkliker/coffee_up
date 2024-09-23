CREATE TABLE coffee_shops (

    shop_id SERIAL PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    location VARCHAR(255),

    phone VARCHAR(15),

    email VARCHAR(100)

);


-- Таблица сотрудников

CREATE TABLE employees (

    employee_id SERIAL PRIMARY KEY,

    shop_id INTEGER REFERENCES coffee_shops(shop_id),

    name VARCHAR(100) NOT NULL,

    position VARCHAR(50),

    hire_date DATE,

    salary DECIMAL(10, 2)

);


-- Таблица продуктов

CREATE TABLE products (

    product_id SERIAL PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    price DECIMAL(10, 2) NOT NULL,

    category VARCHAR(50)

);


-- Таблица продаж

CREATE TABLE sales (

    sale_id SERIAL PRIMARY KEY,

    shop_id INTEGER REFERENCES coffee_shops(shop_id),

    employee_id INTEGER REFERENCES employees(employee_id),

    sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    total_amount DECIMAL(10, 2) NOT NULL

);


-- Таблица товаров на продажах

CREATE TABLE sale_items (

    sale_item_id SERIAL PRIMARY KEY,

    sale_id INTEGER REFERENCES sales(sale_id),

    product_id INTEGER REFERENCES products(product_id),

    quantity INTEGER NOT NULL,

    subtotal DECIMAL(10, 2) NOT NULL

);


-- Таблица расходов

CREATE TABLE expenses (

    expense_id SERIAL PRIMARY KEY,

    shop_id INTEGER REFERENCES coffee_shops(shop_id),

    expense_date DATE,

    description VARCHAR(255),

    amount DECIMAL(10, 2) NOT NULL

);


-- Таблица запасов

CREATE TABLE inventory (

    inventory_id SERIAL PRIMARY KEY,

    product_id INTEGER REFERENCES products(product_id),

    quantity_in_stock INTEGER NOT NULL,

    reorder_level INTEGER

);


-- Таблица платежей

CREATE TABLE payments (

    payment_id SERIAL PRIMARY KEY,

    sale_id INTEGER REFERENCES sales(sale_id),

    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    payment_method VARCHAR(50),

    amount DECIMAL(10, 2) NOT NULL

);