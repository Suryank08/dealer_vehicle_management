
CREATE TABLE IF NOT EXISTS dealer (
    dealer_id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    subscription_type VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS vehicle (
    vehicle_id UUID PRIMARY KEY,
    dealer_id UUID NOT NULL,
    model VARCHAR(255) NOT NULL,
    price BIGINT NOT NULL,
    status_type VARCHAR(50) NOT NULL,
    CONSTRAINT fk_dealer_vehicle FOREIGN KEY (dealer_id) REFERENCES dealer(dealer_id)
);
CREATE TABLE IF NOT EXISTS payment_log (
    payment_id UUID PRIMARY KEY,
    dealer_id UUID NOT NULL,
    amount BIGINT,
    method VARCHAR(50),
    status VARCHAR(50),
    CONSTRAINT fk_dealer_payment FOREIGN KEY (dealer_id) REFERENCES dealer(dealer_id)
);
