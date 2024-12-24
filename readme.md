# 🚀 Paralelismo Java - Projeto Educacional

Este repositório foi criado com o objetivo de **demonstrar os conceitos de paralelismo e processamento sequencial utilizando Java** de forma didática. O conteúdo é ideal para **entusiastas e estudantes que queiram explorar práticas de programação paralela**, além de entender os benefícios de desempenho que podem ser alcançados com essas abordagens.

---

## ❓ **O que é paralelismo no processamento?**

O paralelismo é a capacidade de **dividir tarefas complexas em partes menores que podem ser executadas simultaneamente** em diferentes núcleos de CPU. Ele é amplamente utilizado para melhorar a performance de aplicações, permitindo que grandes volumes de dados ou cálculos sejam processados de forma mais eficiente.

### Benefícios do processamento paralelo:

- **Velocidade**: O paralelismo explora múltiplos núcleos da CPU, reduzindo significativamente o tempo de execução das tarefas.
- **Escalabilidade**: Permite o processamento eficiente de grandes volumes de dados, essencial em aplicações críticas como análise de dados e cálculos matemáticos complexos.
- **Aproveitamento de hardware moderno**: Hoje, a maioria dos computadores e servidores possui processadores com múltiplos núcleos, otimizando o uso dos recursos disponíveis.

---

## 🛠️ **Como este projeto funciona?**

O projeto contém um menu interativo no console onde o usuário pode escolher entre dois tipos de processamento:

1. **Processamento Sequencial**: Tarefas são executadas de forma linear, um passo após o outro.
2. **Processamento Paralelo**: Divide as tarefas, executando simultaneamente em diferentes núcleos.

Ambos os métodos buscam **encontrar números primos em grandes intervalos**, mostrando o impacto de cada abordagem no tempo total de processamento.

---

### ✨ **Exemplo das Operações Integradas**

#### **1. Processamento Sequencial**

Executa a tarefa de forma linear, avaliando os números de um intervalo (`2` a `LIMITE_SUPERIOR`). Ideal para sistemas com apenas um núcleo de processamento ou tarefas simples.

```java
List<Integer> numerosPrimos = IntStream.rangeClosed(2, LIMITE_SUPERIOR)
    .filter(this::isPrimo)
    .boxed()
    .toList();
```

- 📘 Resultado: Processamento mais lento, mas sem overhead ou custo adicional de gerenciamento de threads.

---

#### **2. Processamento Paralelo**

Executa a mesma tarefa, mas utilizando múltiplos núcleos do processador, através do método `.parallel()` no Stream API.

```java
List<Integer> numerosPrimos = IntStream.rangeClosed(2, LIMITE_SUPERIOR)
    .parallel()
    .filter(this::isPrimo)
    .boxed()
    .toList();
```

- 📘 Resultado: **Desempenho superior** em máquinas com múltiplos núcleos, especialmente quando o intervalo de processamento é muito grande.

---

### 🎮 **Exemplo Interativo**

Durante a execução, o programa apresenta um menu para que o usuário escolha o tipo de processamento desejado:

```plaintext
=== Escolha uma forma de processamento ===

1 - Processamento Sequencial
2 - Processamento Paralelo
0 - Sair

Digite sua opção:
```

Ao escolher uma das opções, o programa executa o cálculo de números primos e exibe informações como o **tempo total de processamento** e a **quantidade de resultados encontrados**.

---

### 🚀 **Como executar este projeto**

1. Clone o repositório:

   ```bash
   git clone https://github.com/seunome/paralelismo-java
   ```

2. Compile o projeto:

   ```bash
   javac -d bin src/**/*.java
   ```

3. Execute o programa:

   ```bash
   java -cp bin br.com.stream.parallel.Main
   ```

---

### 🏆 **Objetivos Educacionais**

- 🌟 Demonstrar como **paralelismo** pode melhorar o desempenho em execução de algoritmos intensivos.
- 📚 Explicar a diferença entre **processamento sequencial** e **paralelo** de forma prática.
- 🛠️ Ensinar conceitos como manipulação de Streams, uso de `IntStream.parallel()` e otimizações do Java para tarefas computacionais.

Se você deseja contribuir ou tem dúvidas sobre o projeto, sinta-se à vontade para criar uma issue ou enviar um pull request! Este repositório foi feito para aprender e colaborar. 😊

---

> ✍️ **Nota**: Este conteúdo foi desenvolvido com fins educacionais, para ajudar a entender os conceitos de paralelismo e processamento sequencial no Java. Explore o código e veja na prática como o paralelismo pode fazer a diferença!