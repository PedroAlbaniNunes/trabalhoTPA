# Trabalho de TPA – Implementação e Análise de Listas em Java

Este repositório contém a implementação prática e a análise de complexidade referentes ao **Trabalho 1 - Análise de Complexidade sobre Estruturas de Listas**, desenvolvido para a disciplina de **Técnicas de Programação Avançada (TPA)**.

## 🎯 Objetivos do Trabalho

O projeto teve como objetivos principais:

- **Implementação de uma biblioteca de listas genéricas** em Java utilizando **Generics** e **Comparator**.
- **Suporte a listas ordenadas e não ordenadas**, definido no momento da criação da lista.
- **Desenvolvimento de métodos essenciais** para manipulação de listas:
  - `adicionar(T novoValor)`
  - `contemElemento(T valor)`
  - `pesquisar(T valor)`
  - `remover(T valor)`
- **Análise de complexidade** dos métodos implementados, comparando listas ordenadas e não ordenadas.
- **Estudo das estruturas nativas do Java** (`ArrayList` e `LinkedList`), avaliando:
  - Funcionamento interno
  - Complexidade teórica das operações
  - Resultados empíricos com arquivos de teste de diferentes tamanhos

## 🧩 Estrutura do Repositório

A organização dos arquivos foi feita de forma a facilitar a navegação e a execução dos testes:

```text
trabalhoTPA/
├── src/
│   ├── lista/
│   │   ├── ListaEncadeada.java                     # Implementação da lista genérica
│   │   ├── No.java                                 # Classe nó da lista encadeada
│   │   └── ComparadorAlunoPorMatricula.java        # Comparators para listas ordenadas
│   │   └── Aluno.java                              # Classe modelo representando o aluno
│   │   └── Main.java                               # Programa de teste com inserção, busca e remoção
└── README.md                                       # Este arquivo
```

## 📚 Implementação

A lista encadeada foi projetada para ser **genérica** e **reutilizável**, aceitando qualquer tipo de objeto.  

A **ordenação** é mantida automaticamente quando a lista é criada como ordenada, utilizando um `Comparator<T>` informado no construtor. Caso seja não ordenada, os elementos são adicionados ao final da lista.  

## ⏳ Análise de Complexidade

Foram analisadas as operações principais da lista nos casos **ordenado** e **não ordenado**:

| Operação        | Lista Não Ordenada | Lista Ordenada |
|-----------------|------------------|----------------|
| **Adicionar**   | `O(1)` (inserção no fim) | `O(n)` (busca da posição correta) |
| **Pesquisar**   | `O(n)` | `O(n)` (interrompe cedo se passar da posição correta) |
| **Remover**     | `O(n)` | `O(n)` (interrompe cedo se passar da posição correta) |

Além disso, o trabalho inclui uma comparação entre `ArrayList` e `LinkedList`, abordando **busca por índice**, **busca por valor**, **inserções** e **remoções** em diferentes posições, explicando quando cada estrutura é mais eficiente.

## 🧪 Testes Empíricos

Para validar a análise teórica, foram feitos testes de desempenho com entradas de tamanhos variados (100k, 200k, 500k, 1m, 10m elementos), medindo:

- Inserções no **início**, **meio** e **fim** das listas.
- Buscas em posições específicas (primeiro, último, meio).
- Comparação dos tempos entre **ArrayList** e **LinkedList**.

Os resultados confirmaram o comportamento esperado pela análise de complexidade.

## 🏗️ Tecnologias Utilizadas

- **Java SE 17+**
- **Comparator** para ordenação
- **ArrayList** e **LinkedList** para testes comparativos

## 📌 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/saraivagustavo/trabalhoTPA.git
   cd trabalhoTPA
   ```
2. Compile os arquivos:
   ```bash
   javac -d bin src/**/*.java
   ```
3. Execute o programa principal:
   ```bash
   java -cp bin main.Principal
   ```

## **Integrantes do Projeto**
| Aluno | GitHub | LinkedIn |
|-------|--------|----------|
| Gustavo Saraiva Mariano | [![GitHub](https://img.shields.io/badge/github-black?style=for-the-badge&logo=github)](https://github.com/saraivagustavo) | [![LinkedIn](https://img.shields.io/badge/linkedin-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/gustavo-saraiva-mariano/) |
| Pedro Henrique Albani Nunes | [![GitHub](https://img.shields.io/badge/github-black?style=for-the-badge&logo=github)](https://github.com/PedroAlbaniNunes) | [![LinkedIn](https://img.shields.io/badge/linkedin-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/pedro-henrique-albani-nunes-33a729270/) |
| Vivian Moreira Gomes de Lacerda | [![GitHub](https://img.shields.io/badge/github-black?style=for-the-badge&logo=github)](https://github.com/vviivviaan) | [![LinkedIn](https://img.shields.io/badge/linkedin-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/vivian-lacerda-935a41239/) |
