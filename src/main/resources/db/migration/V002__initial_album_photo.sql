create table album (
    
    id SERIAL PRIMARY KEY,
    user_id int not null,
    name varchar(80) not null
 
);

create table photo (
    
    id SERIAL PRIMARY KEY,
    album_id int not null,
    photo varchar(80) not null,
    user_id int not null,
    FOREIGN KEY (album_id) REFERENCES album(id)

);
