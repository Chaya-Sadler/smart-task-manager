CREATE TABLE category (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    created_at  TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at  TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);