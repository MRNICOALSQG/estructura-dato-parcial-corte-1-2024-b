import javax.swing.*;

public class Calculacion_compra {
    public static void main(String[] args) {

        String nombreCliente;
        String nombreProducto;
        double valorUnitario;
        int cantidad;
        double valorBruto;
        double descuento;
        double valorDescuento;
        double valorNeto;
        String mensajeError = "Error el valor debe ser un numero y mayor a 0";
        nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        try {
            valorUnitario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor unitario (mayor a 0):"));
            if (valorUnitario <= 0) {
                System.out.println(mensajeError);
                return;
            }
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad (mayor a 0):"));
            if (cantidad <= 0) {
                System.out.println(mensajeError);
                return;
            }
            valorBruto = valorUnitario * cantidad;
            if (cantidad < 10) {
                descuento = 0;
            } else if (cantidad < 20) {
                descuento = 0.05;
            } else {
                descuento = 0.07;
            }
            valorDescuento = valorBruto * descuento;
            valorNeto = valorBruto - valorDescuento;
            String resultado = String.format(
                    "Resumen de la Compra\n" +
                            "Nombre del Cliente: %s\n" +
                            "Nombre del Producto: %s\n" +
                            "Valor Unitario: %.2f\n" +
                            "Cantidad: %d\n" +
                            "Valor Bruto: %.2f\n" +
                            "Valor Descuento: %.2f\n" +
                            "Valor Neto: %.2f",
                    nombreCliente, nombreProducto, valorUnitario, cantidad, valorBruto, valorDescuento, valorNeto
            );
            System.out.println(resultado);
        } catch (NumberFormatException e) {
            System.out.println(mensajeError);
        }
    }
}

