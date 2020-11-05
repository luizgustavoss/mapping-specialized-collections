INSERT INTO piloto (id, tipo_piloto, nome) VALUES
  (1, 'ciclista', 'Moisés'),
  (2, 'motociclista', 'José');

INSERT INTO veiculo (id, id_piloto, marca, modelo) VALUES
  (1, 1, 'Caloi', 'Caloi 10'),
  (2, 1, 'Caloi', 'Caloi 100'),
  (3, 2, 'Honda', 'CG'),
  (4, 2, 'Yamaha', 'YZX');

INSERT INTO bicicleta (id, marchas, aro) VALUES
  (1, 18, 20),
  (2, 24, 25);

INSERT INTO motocicleta (id, cilindradas, combustivel) VALUES
  (3, 125, 'GASOLINA'),
  (4, 125, 'GASOLINA');