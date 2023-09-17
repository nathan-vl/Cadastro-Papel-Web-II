package br.com.imd.arq;

public class EntidadeNaoEncontrada extends RuntimeException {
    public EntidadeNaoEncontrada() {
        super("Não foi possível obter a entidade.");
    }
}
