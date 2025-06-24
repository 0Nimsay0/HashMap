package javahashseparatechaining;
import java.util.LinkedList;

public class CustomHashMap<T> {
    private LinkedList<Dado<T>>[] tabela;
    private int tamanho;
    private int numElementos;
    private int comparacoes; // Implementar para apresentar o número de comparações necessárias para inserir, buscar e remover elementos
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static class Dado<T> {
        long key;
        T value;

        Dado(long key, T value) {
            this.key = key;
            this.value = value;
        }
    }


    public CustomHashMap(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int funcaoHash(long chave) {
        return (int) (chave % tamanho);
    }

    public void put(long key, T value) {
        this.comparacoes = 0;
        if ((double) numElementos / tamanho >= DEFAULT_LOAD_FACTOR) {
            resize();
        }

        int indice = funcaoHash(key);
        LinkedList<Dado<T>> lista = tabela[indice];

        for (Dado<T> item : lista) {
            this.comparacoes++;
            if (item.key == key) {
                item.value = value;
                System.out.println("Comparações na inserção (chave atualizada): " + this.comparacoes);
                return;
            }
        }

        Dado<T> dado = new Dado<>(key, value);
        lista.add(dado);
        numElementos++;
        System.out.println("Comparações na inserção (nova chave): " + this.comparacoes);
    }

    public boolean containsKey(long key) {
        this.comparacoes = 0;
        int indice = funcaoHash(key);
        for (Dado<T> item : tabela[indice]) {
            this.comparacoes++;
            if (item.key == key) {
                System.out.println("Comparações na busca: " + this.comparacoes);
                return true;
            }
        }
        System.out.println("Comparações na busca: " + this.comparacoes);
        return false;
    }

    public boolean remove(long key) {
        this.comparacoes = 0;
        int indice = funcaoHash(key);
        for (Dado<T> item : tabela[indice]) {
            this.comparacoes++;
            if (item.key == key) {
                tabela[indice].remove(item);
                numElementos--;
                System.out.println("Comparações na remoção: " + this.comparacoes);
                return true;
            }
        }
        System.out.println("Comparações na remoção: " + this.comparacoes);
        return false;
    }

    public T get(long key) {
        this.comparacoes = 0;
        int indice = funcaoHash(key);
        for (Dado<T> item : tabela[indice]) {
            this.comparacoes++;
            if (item.key == key) {
                System.out.println("Comparações na busca (get): " + this.comparacoes);
                return item.value;
            }
        }
        System.out.println("Comparações na busca (get): " + this.comparacoes);
        return null;
    }

    public void replace(long key, T value) {
        this.comparacoes = 0;
        int indice = funcaoHash(key);
        for (Dado<T> item : tabela[indice]) {
            this.comparacoes++;
            if (item.key == key) {
                item.value = value;
                System.out.println("Comparações na alteração (replace): " + this.comparacoes);
                return;
            }
        }
        System.out.println("Comparações na alteração (replace): " + this.comparacoes);
    }


    private void resize() {
        int novoTamanho = tamanho * 2;
        LinkedList<Dado<T>>[] antigaTabela = this.tabela;

        this.tamanho = novoTamanho;
        this.tabela = new LinkedList[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            this.tabela[i] = new LinkedList<>();
        }
        
        this.numElementos = 0; 

        for (LinkedList<Dado<T>> lista : antigaTabela) {
            for (Dado<T> dado : lista) {
                put(dado.key, dado.value); // Usa o put para reinserir e manter a contagem de elementos correta
            }
        }
        System.out.println("Tabela redimensionada para " + novoTamanho + " elementos.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append("[").append(i).append("]");
            for (Dado<T> item : tabela[i]) {
                sb.append(" -> ").append(item.key).append(":").append(item.value);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
