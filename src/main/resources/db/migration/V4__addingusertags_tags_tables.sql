
-- Create the tags table
CREATE TABLE  tags (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
    );





CREATE TABLE  user_tags (
                                         user_id BIGINT NOT NULL,
                                         tag_id  BIGINT NOT NULL,

    -- Composite primary key ensures each (user, tag) pair is unique
                                         PRIMARY KEY (user_id, tag_id),

    -- Foreign key to users
    CONSTRAINT fk_user_tags_user
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    -- Foreign key to tags
    CONSTRAINT fk_user_tags_tag
    FOREIGN KEY (tag_id)
    REFERENCES tags (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );