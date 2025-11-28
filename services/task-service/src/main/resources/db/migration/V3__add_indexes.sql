CREATE INDEX idx_task_status ON task(status);
CREATE INDEX idx_task_priority ON task(priority);
CREATE INDEX idx_task_category_id ON task(category_id);
CREATE INDEX idx_task_due_date ON task(due_date);