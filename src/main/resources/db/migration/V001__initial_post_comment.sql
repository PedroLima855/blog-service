
create table post (
    
    id SERIAL PRIMARY KEY,
    text varchar(80) not null,
    images varchar(80) not null,
    links varchar(80) not null,
    user_id int not null
    
);

create table comment (
    
    id SERIAL PRIMARY KEY,
    post_id int not null,
    comment varchar(80) not null,
    user_id int not null,
    FOREIGN KEY (post_id) REFERENCES post(id)

);
