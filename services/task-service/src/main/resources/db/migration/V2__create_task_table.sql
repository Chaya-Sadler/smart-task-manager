CREATE TABLE task (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title           VARCHAR(100) NOT NULL,
    description     TEXT,
    status          VARCHAR(50) NOT NULL DEFAULT 'NEW',
    priority        VARCHAR(20) NOT NULL DEFAULT 'MEDIUM',
    due_date        DATE,
    category_id     UUID REFERENCES category(id),
    created_at      TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at      TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);