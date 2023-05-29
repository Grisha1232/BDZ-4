CREATE TABLE IF NOT EXISTS user_table (
                      id INT PRIMARY KEY,
                      username VARCHAR(50) UNIQUE NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      password_hash VARCHAR(255) NOT NULL,
                      role VARCHAR(10) NOT NULL CHECK (role IN ('customer', 'chef', 'manager')),
                      created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS session (
                         id INT PRIMARY KEY,
                         user_id INT NOT NULL,
                         session_token VARCHAR(255) NOT NULL,
                         expires_at TIMESTAMP NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES user_table(id)
);

CREATE TABLE IF NOT EXISTS dish (
                      id INT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      description TEXT,
                      price DECIMAL(10, 2) NOT NULL,
                      quantity INT NOT NULL,
                      is_available BOOLEAN NOT NULL,
                      created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "order" (
                       id INT PRIMARY KEY,
                       user_id INT NOT NULL,
                       status VARCHAR(50) NOT NULL,
                       special_requests TEXT,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES user_table(id)
);

CREATE TABLE IF NOT EXISTS order_dish (
                            id INT PRIMARY KEY,
                            order_id INT NOT NULL,
                            dish_id INT NOT NULL,
                            quantity INT NOT NULL,
                            price DECIMAL(10, 2) NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES "order"(id),
                            FOREIGN KEY (dish_id) REFERENCES dish(id)
);



