TRUNCATE TABLE dealer CASCADE;
INSERT INTO dealer (dealer_id, name, email, subscription_type) VALUES
('b301c238-d63c-4a12-8888-085e3d7402c5', 'Suryank''s Auto', 'suryank.auto@example.com', 'PREMIUM'),
('8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 'City Cars', 'city.cars@example.com', 'BASIC');


TRUNCATE TABLE vehicle CASCADE;
INSERT INTO vehicle (vehicle_id, dealer_id, model, price, status_type) VALUES
(gen_random_uuid(), 'b301c238-d63c-4a12-8888-085e3d7402c5', 'Tesla Model 3', 45000, 'AVAILABLE'),
(gen_random_uuid(), 'b301c238-d63c-4a12-8888-085e3d7402c5', 'Ford Mustang', 60000, 'SOLD'),
(gen_random_uuid(), '8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 'Honda Civic', 25000, 'AVAILABLE'),
(gen_random_uuid(), 'b301c238-d63c-4a12-8888-085e3d7402c5', 'Chevy Corvette', 80000, 'AVAILABLE'),
(gen_random_uuid(), '8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 'Nissan Titan', 40000, 'SOLD');

TRUNCATE TABLE payment_log CASCADE;
INSERT INTO payment_log (payment_id, dealer_id, amount, method, status) VALUES
(gen_random_uuid(), 'b301c238-d63c-4a12-8888-085e3d7402c5', 1000, 'UPI', 'PENDING'),
(gen_random_uuid(), '8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 500, 'Card', 'SUCCESS');
