CREATE TABLE whishlist
(
    product_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    CONSTRAINT pk_whishlist PRIMARY KEY (product_id, user_id)
);

ALTER TABLE whishlist
    ADD CONSTRAINT fk_whishlist_on_product FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE whishlist
    ADD CONSTRAINT fk_whishlist_on_user FOREIGN KEY (user_id) REFERENCES users (id);