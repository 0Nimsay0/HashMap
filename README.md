# 💖 Mapa Hash Encantado com Encadeamento Separado 💖

**Bem-vinda ao nosso cantinho de Estrutura de Dados! ✨**  
Este projeto foi feito para demonstrar de forma prática e intuitiva como funciona uma **tabela Hash** com **Encadeamento Separado**.🌸

---

## ✨ O que ele faz?

🔹 **Tabela Hash Personalizada**  
Implementa uma **tabela hash do zero**, onde cada posição pode armazenar uma lista de elementos (através de `LinkedList`).  
Nada de bibliotecas prontas — aqui a mágica acontece linha por linha!  

🔹 **Operações Essenciais**  
Você pode:
- Inserir 🔧  
- Remover 🗑️  
- Buscar 🔍  
- Alterar dados 📝  
Tudo isso através de um menu **super amigável no console**!

🔹 **Redimensionamento Dinâmico**  
A tabela se adapta! Quando chega a 75% da capacidade (o famoso **load factor**), ela **dobra de tamanho automaticamente**, mantendo a performance nas alturas. ⚡

🔹 **Análise de Comparações**  
O código mostra quantas comparações foram feitas em cada operação.  
Isso te ajuda a **visualizar na prática** a eficiência dos algoritmos! 📊

---

## 🧠 Um Pouquinho da Teoria

### 📌 Função Hash
Usamos uma função simples e eficiente:
```java
indice = chave % tamanho;
````

Ou seja, usamos o resto da divisão da chave pelo tamanho da tabela para determinar onde armazenar o valor.

### 🪄 Lidando com Colisões

E se duas chaves caírem na mesma posição?
Sem drama! Utilizamos o **Encadeamento Separado (Separate Chaining)**:
Cada posição da tabela contém uma `LinkedList` que guarda todos os itens com o mesmo índice.

### 🌱 Fator de Carga

Quando a ocupação da tabela atinge **75%**, a estrutura é **automaticamente redimensionada**:

* O tamanho dobra
* Todos os elementos são **re-hashados** para as novas posições

---

## 📂 Conheça nossos Arquivos

| Arquivo              | Descrição                                                                               |
| -------------------- | --------------------------------------------------------------------------------------- |
| `CustomHashMap.java` | 🌟 Contém toda a lógica da estrutura hash com encadeamento separado. |
| `JavaHashMain.java`  | 🎀 Um menu interativo para testar tudo.            |


## ❤️ Feito com muitos `System.out.println()`

