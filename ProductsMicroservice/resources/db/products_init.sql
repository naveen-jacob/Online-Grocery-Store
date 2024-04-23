DROP TABLE IF EXISTS products;

CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          name TEXT NOT NULL,
                          description TEXT,
                          price BIGINT NOT NULL,
                          image_url TEXT
);

INSERT INTO products (name, description, price, image_url)
VALUES ('Apples (1kg)', 'Fresh, crisp red apples', 129, 'https://images.unsplash.com/photo-1613061527119-56ad37b8a581?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Milk (1L)', 'Pasteurized whole milk', 40, 'https://images.unsplash.com/photo-1576186726115-4d51596775d1?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Eggs (Dozen)', 'Grade A brown eggs', 89, 'https://images.unsplash.com/photo-1518569656558-1f25e69d93d7?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Bread (450g)', 'Soft and fluffy bread', 50, 'https://images.unsplash.com/photo-1598373182133-52452f7691ef?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Chicken Breasts (1kg)', 'Fresh, boneless, skinless chicken breasts', 182, 'https://images.unsplash.com/photo-1604503468506-a8da13d82791?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Lettuce (1kg)', 'Crisp and refreshing romaine lettuce', 30, 'https://images.unsplash.com/photo-1622205313162-be1d5712a43f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Tomatoes (1kg)', 'Sweet and flavorful Roma tomatoes', 40, 'https://images.unsplash.com/photo-1558818498-28c1e002b655?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Bananas (1kg)', 'Sweet and creamy ripe bananas', 88, 'https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Greek Yogurt (250g)', 'Plain greek yogurt', 119, 'https://images.unsplash.com/photo-1604095853918-1a1823a63dd5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');

INSERT INTO products (name, description, price, image_url)
VALUES ('Cheese Slices (10pc)', 'Sharp cheddar cheese', 115, 'https://images.unsplash.com/photo-1618164435777-ebf94ffa77af?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80');
