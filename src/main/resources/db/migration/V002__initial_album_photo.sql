create table album (
    
    id SERIAL PRIMARY KEY,
    name varchar(80) not null
 
);

create table photo (
    
    id SERIAL PRIMARY KEY,
    album_id int not null,
    photo varchar(80) not null,
    FOREIGN KEY (album_id) REFERENCES album(id)

);
