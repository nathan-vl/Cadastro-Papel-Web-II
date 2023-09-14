package br.com.imd.arq;

public class EntidadeNaoEncontrada extends RuntimeException {
    public EntidadeNaoEncontrada(String nome, int id) {
        super("Não foi possível obter " + nome.toLowerCase() + " com id " + id + ".");
    }
}
