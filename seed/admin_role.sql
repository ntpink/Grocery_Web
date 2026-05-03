-- Add role column with default USER (run once)
ALTER TABLE `user` ADD COLUMN role VARCHAR(255) NOT NULL DEFAULT 'USER';

-- Promote a specific account to ADMIN (adjust username/email as needed)
UPDATE `user`
SET role = 'ADMIN'
WHERE username = 'admin' OR email = 'admin@example.com';
