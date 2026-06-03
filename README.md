# Sistema de Torneio de Lutadores(as)
 
Trabalho prático da disciplina **Algoritmos e Programação** — Engenharia de Software  
Universidade Federal do Pampa (UNIPAMPA) — Alegrete/RS
 
---
 
## Sobre o projeto
 
Sistema desenvolvido em Java que simula o gerenciamento de um torneio de lutadores(as).  
O programa roda no terminal e permite cadastrar lutadores, consultar informações e filtrar por classe de combate.
 
---
 
## Funcionalidades
 
- **Registrar lutadores(as)** — cadastra até 8 lutadores com nome, classe, ataque, defesa e agilidade. O dano é calculado automaticamente.
- **Mostrar lutadores(as)** — exibe todos os lutadores cadastrados.
- **Buscar por nome** — localiza um lutador pelo nome.
- **Listar por classe** — filtra e exibe todos os lutadores de uma classe específica.
- **Encerrar** — finaliza o programa.
---
 
## Regras do torneio
 
- O torneio suporta **8 lutadores(as)**.
- Cada lutador(a) possui os seguintes atributos:
  - **Nome**
  - **Classe de combate:** Caca, Guerra, Estrategia ou Magia
  - **Ataque:** valor de 0 a 100
  - **Defesa:** valor de 0 a 100
  - **Agilidade:** valor de 0 a 100
  - **Dano:** calculado como `ataque + defesa + agilidade` (valor de 0 a 300)
---
 
## Como executar
 
**Pré-requisito:** ter o Java instalado na máquina.
 
1. Compile o arquivo:
```
javac Torneio.java
```
 
2. Execute o programa:
```
java Torneio
```
 
---
 
## Validações
 
- Nome não pode ser vazio.
- Classe deve ser uma das quatro opções válidas. O sistema aceita qualquer forma de escrita — `CAÇA`, `caça`, `Caca`, `caca` são todos reconhecidos.
- Ataque, defesa e agilidade devem ser valores entre 0 e 100.
- Entradas que não são números inteiros são rejeitadas com aviso.
- Busca por nome inexistente e listagem por classe sem lutadores cadastrados exibem mensagens de aviso.
---
 
## Estrutura do código
 
O programa utiliza apenas um `main`, sem métodos auxiliares, com:
 
- **Vetores paralelos** para armazenar os dados dos lutadores
- **do/while** para o loop principal do menu
- **for** e **while** para cadastro, busca e validações
- **switch** para controle das opções do menu
---
 
## Autores
 
Trabalho desenvolvido em trio para a disciplina de Algoritmos e Programação.  
Professoras: Aline Vieira de Mello e Raquel Pillat
