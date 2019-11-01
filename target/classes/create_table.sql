CREATE TABLE book(
  id INT(11) NOT NULL  auto_increment,
  name VARCHAR(50) NOT NULL,
  author VARCHAR(100),
  summary text,
  author_summary text,
  catalog text,
  pages INT,
  year VARCHAR(15),
  publisher VARCHAR(50),
  score FLOAT,
  PRIMARY KEY(id)
)