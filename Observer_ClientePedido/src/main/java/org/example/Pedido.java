package org.example;

import java.util.Observable;

public class Pedido extends Observable{
    private String descricao;
    private String numeroPedido;

    public Pedido(String numeroPedido, String descricao) {
        this.numeroPedido = numeroPedido;
        this.descricao = descricao;
    }

    public void pedidoPronto() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "número='" + numeroPedido + '\'' +
                ", descrição='" + descricao + '\'' +
                '}';
    }
}
