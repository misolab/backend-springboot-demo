CREATE TABLE sample (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    age INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 초기 데이터 삽입
INSERT INTO sample (name, email, age) VALUES
    ('홍길동', 'hong@example.com', 20),
    ('김철수', 'kim@example.com', 25); 