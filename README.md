## Mapeamento de Coleções Especializadas

Este pequeno exemplo mostra como mapear coleções de tipos especializados em relacionamentos de herança.

O modelo de exemplo é simples:

![image](https://user-images.githubusercontent.com/5515537/98199143-510e7200-1f09-11eb-9683-882f3cd58713.png)

O propósito é mostar como as classes especializadas Ciclista e Motociclista conseguem ter acesso à lista de veículos 
mapeados na classe Piloto de forma especializada, ou seja, embora Piloto tenha uma lista de Veiculo, 
a classe Ciclista acessa uma lista de Bicicleta enquanto que Motociclista acessa uma lista de Motocicleta.

O exemplo deixa claro que o Hibernate já faz o trabalho de carregar as classes especializadas em memória, de acordo com
o tipo correto. Ao listar ciclistas, por exemplo, nenhum mapeamento adicional é feito para retornar a entidade
através do controller, e os dados de biciletas são apresentados na listagem de veículo. No entanto, a listagem de
motocicletas mostra que podemos mapear de forma explícita  os dados para uma coleção especializada em um DTO.

```java 
@Getter
@Setter
@Builder
public class MotociclistaDTO {

    private Long id;
    private String nome;
    private List<MotocicletaDTO> motocicletas;
}
```

```java 
@Getter
@Setter
@Builder
public class MotocicletaDTO {

    private Long id;
    private Piloto piloto;
    private String marca;
    private String modelo;
    private int cilindradas;
    private Combustivel combustivel;
}
```

```java 
public class MotocicletaMapper extends AbstractMapper<MotocicletaDTO, Veiculo> {
    @Override
    public MotocicletaDTO map(Veiculo veiculo) {

        Motocicleta motocicleta = (Motocicleta) veiculo;

        return MotocicletaDTO.builder()
                .id(motocicleta.getId())
                .marca(motocicleta.getMarca())
                .modelo(motocicleta.getModelo())
                .cilindradas(motocicleta.getCilindradas())
                .combustivel(motocicleta.getCombustivel())
                .build();
    }
}
```

```java 
public class MotociclistaMapper extends AbstractMapper<MotociclistaDTO, Motociclista> {

    @Override
    public MotociclistaDTO map(Motociclista motociclista) {
        return MotociclistaDTO.builder()
                .id(motociclista.getId())
                .nome(motociclista.getNome())
                .motocicletas(new MotocicletaMapper().map(motociclista.getVeiculos()))
                .build();
    }
}
```



A aplicação conta com um banco de dados de exemplo, criado em memória durante a inicialziação, com dados de demonstração.

### Clonar e executar

Para clonar e executar o projeto, utilize estes comandos:

```
$ git clone git@github.com:luizgustavoss/mapping-specialized-collections.git && cd mapping-specialized-collections

$ mvn clean install spring-boot:run
```



### Acesso ao banco em memória

Depois de inicializado, acesse o banco de dados através do endereço:

``` 
http://localhost:8080/h2-console/
```

**jdbc url**: jdbc:h2:mem:testdb

**user**: sa

**password**: password


### Acesso aos endpoints

Para testar as consultas, você pode chamar os seguintes endpoints, com seus respectivos resultados:


http://localhost:8080/motociclistas
```json
[ {
  "id" : 2,
  "nome" : "José",
  "motocicletas" : [ {
    "id" : 3,
    "piloto" : null,
    "marca" : "Honda",
    "modelo" : "CG",
    "cilindradas" : 125,
    "combustivel" : "GASOLINA"
  }, {
    "id" : 4,
    "piloto" : null,
    "marca" : "Yamaha",
    "modelo" : "YZX",
    "cilindradas" : 125,
    "combustivel" : "GASOLINA"
  } ]
} ]
```
http://localhost:8080/ciclistas
```json
[ {
  "id" : 1,
  "nome" : "Moisés",
  "veiculos" : [ {
    "id" : 1,
    "marca" : "Caloi",
    "modelo" : "Caloi 10",
    "marchas" : 18,
    "aro" : 20
  }, {
    "id" : 2,
    "marca" : "Caloi",
    "modelo" : "Caloi 100",
    "marchas" : 24,
    "aro" : 25
  } ]
} ]
```
http://localhost:8080/pilotos
```json 
[ {
  "id" : 1,
  "nome" : "Moisés",
  "veiculos" : [ {
    "id" : 1,
    "marca" : "Caloi",
    "modelo" : "Caloi 10",
    "marchas" : 18,
    "aro" : 20
  }, {
    "id" : 2,
    "marca" : "Caloi",
    "modelo" : "Caloi 100",
    "marchas" : 24,
    "aro" : 25
  } ]
}, {
  "id" : 2,
  "nome" : "José",
  "veiculos" : [ {
    "id" : 3,
    "marca" : "Honda",
    "modelo" : "CG",
    "cilindradas" : 125,
    "combustivel" : "GASOLINA"
  }, {
    "id" : 4,
    "marca" : "Yamaha",
    "modelo" : "YZX",
    "cilindradas" : 125,
    "combustivel" : "GASOLINA"
  } ]
} ]
```