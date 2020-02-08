
# --- !Ups
create table book(
    id serial not null,
    book_name text,
    price integer,
    created_at timestamp not null,
    updated_at timestamp not null
);

insert into book values (default, 'book1', 999, current_timestamp, current_timestamp);