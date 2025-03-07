alter table whishlist
drop foreign key fk_whishlist_on_product;

alter table whishlist
    add constraint fk_whishlist_on_product
        foreign key (product_id) references products (id)
            on delete cascade;
