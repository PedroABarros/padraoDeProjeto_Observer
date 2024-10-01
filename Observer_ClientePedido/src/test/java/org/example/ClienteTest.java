package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ClienteTest {


    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido("123", "Pizza de Calabresa");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.seguirPedido(pedido);
        pedido.pedidoPronto();
        assertEquals("Cliente 1, seu pedido está pronto! Pedido: Pedido{número='123', descrição='Pizza de Calabresa'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido pedido = new Pedido("123", "Pizza de Calabresa");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.seguirPedido(pedido);
        cliente2.seguirPedido(pedido);
        pedido.pedidoPronto();
        assertEquals("Cliente 1, seu pedido está pronto! Pedido: Pedido{número='123', descrição='Pizza de Calabresa'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, seu pedido está pronto! Pedido: Pedido{número='123', descrição='Pizza de Calabresa'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Pedido pedido = new Pedido("123", "Pizza de Calabresa");
        Cliente cliente = new Cliente("Cliente 1");
        // Cliente não segue o pedido, portanto, não deve receber notificação
        pedido.pedidoPronto();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasClienteQueSeguiuPedido() {
        Pedido pedido1 = new Pedido("123", "Pizza de Calabresa");
        Pedido pedido2 = new Pedido("456", "Hambúrguer");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.seguirPedido(pedido1);
        cliente2.seguirPedido(pedido2);
        pedido1.pedidoPronto();
        assertEquals("Cliente 1, seu pedido está pronto! Pedido: Pedido{número='123', descrição='Pizza de Calabresa'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}