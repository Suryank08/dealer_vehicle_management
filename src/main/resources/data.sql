TRUNCATE TABLE dealer CASCADE;
INSERT INTO dealer (dealer_id, name, email, subscription_type) VALUES
('b301c238-d63c-4a12-8888-085e3d7402c5', 'Suryank''s Auto', 'suryank.auto@example.com', 'PREMIUM'),
('8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 'City Cars', 'city.cars@example.com', 'BASIC');


TRUNCATE TABLE vehicle CASCADE;
INSERT INTO vehicle (vehicle_id, dealer_id, model, price, status_type) VALUES
('30ed4a44-1fbc-47ca-ba5e-191b28082652', 'b301c238-d63c-4a12-8888-085e3d7402c5', 'Tesla Model 3', 45000, 'AVAILABLE'),
('dcff27ae-436d-4624-823a-3ec4fa174638', 'b301c238-d63c-4a12-8888-085e3d7402c5', 'Ford Mustang', 60000, 'SOLD'),
('e39b83ca-0b8b-48ea-ae42-10ddcfcad6fd', '8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 'Honda Civic', 25000, 'AVAILABLE'),
('d9748e50-edbe-44ca-ba84-818f2dddaf7e', 'b301c238-d63c-4a12-8888-085e3d7402c5', 'Chevy Corvette', 80000, 'AVAILABLE'),
('59effe51-0f16-415f-8729-26714b1c635e', '8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 'Nissan Titan', 40000, 'SOLD');

TRUNCATE TABLE payment_log CASCADE;
INSERT INTO payment_log (payment_id, dealer_id, amount, method, status) VALUES
('6201be38-51c6-4187-85e3-258574dcdbb7', 'b301c238-d63c-4a12-8888-085e3d7402c5', 1000, 'UPI', 'PENDING'),
('25b30e98-c620-4e0f-8158-bd0a3958b9ef', '8d506a59-a29d-4e2b-9c9c-074e64f9f4a2', 500, 'Card', 'SUCCESS');
