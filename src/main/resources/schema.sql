CREATE TABLE AUTHOR (
  author_id DOUBLE PRIMARY KEY,  
  name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL
);

CREATE TABLE POST (
  post_id DOUBLE PRIMARY KEY,  
  tittle VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  author_ref_id DOUBLE NOT NULL,
  FOREIGN KEY(author_ref_id) REFERENCES AUTHOR(author_id)
);