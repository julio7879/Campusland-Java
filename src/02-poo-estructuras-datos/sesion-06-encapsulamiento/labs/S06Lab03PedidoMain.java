public class S06Lab03PedidoMain {
    public static void main(String[] args) {
        // TO DO 6: Crear primerPedido y segundoPedido; mostrar el estado inicial de
        // ambos.
        S06Pedido primerPedido = new S06Pedido();
        S06Pedido segundoPedido = new S06Pedido();
        System.out.println("Pedido 1 inicial: " + primerPedido.getEstado());
        System.out.println("Pedido 2 inicial: " + segundoPedido.getEstado());

        // TO DO 7: Enviar primerPedido y luego intentar cancelarlo; consultar tras cada
        // accion.
        System.out.println("Enviar pedido 1: " + primerPedido.enviar());
        System.out.println("Pedido 1: " + primerPedido.getEstado());
        System.out.println("Cancelar pedido 1: " + primerPedido.cancelar());
        System.out.println("Pedido 1: " + primerPedido.getEstado());

        // TO DO 8: Cancelar segundoPedido y luego intentar enviarlo; consultar tras
        // cada accion.
        System.out.println("Cancelar pedido 2: " + segundoPedido.cancelar());
        System.out.println("Pedido 2: " + segundoPedido.getEstado());
        System.out.println("Enviar pedido 2: " + segundoPedido.enviar());
        System.out.println("Pedido 2: " + segundoPedido.getEstado());
    }
}
