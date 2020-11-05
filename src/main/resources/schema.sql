CREATE TABLE veiculo (
  id INT PRIMARY KEY,
  id_piloto INT NOT NULL,
  marca VARCHAR(250) NOT NULL,
  modelo VARCHAR(250) NOT NULL
);

CREATE TABLE bicicleta (
  id INT PRIMARY KEY,
  marchas INT NOT NULL,
  aro INT NOT NULL,
  FOREIGN KEY(id) REFERENCES veiculo(id)
);

CREATE TABLE motocicleta (
  id INT PRIMARY KEY,
  cilindradas INT NOT NULL,
  combustivel VARCHAR(10) NOT NULL,
  FOREIGN KEY(id) REFERENCES veiculo(id)
);

CREATE TABLE piloto (
  id INT PRIMARY KEY,
  tipo_piloto VARCHAR(12) NOT NULL,
  nome VARCHAR(250) NOT NULL
);