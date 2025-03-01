// Importaciones de bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// se importarón las librerias de java
public class Main extends JFrame {
    private JTextField Numero1, Numero2, Resultado;
    private JComboBox<String> comboOperaciones;
    private JButton botonCalcular;

    public  Main() {
        setTitle("Calculadora Básica 🖩");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 3, 10, 10));
        setLocationRelativeTo(null);
        JLabel etiquetaNumero1 = new JLabel("Número 1:");
        Numero1 = new JTextField();

        JLabel etiquetaNumero2 = new JLabel("Número 2:");
        Numero2 = new JTextField();

        JLabel etiquetaOperacion = new JLabel("Operación:");
        String[] operaciones = {
                "Suma", "Resta", "Multiplicación", "División", "Potenciación",
                "Raíz Cuadrada", "Módulo", "Celsius a Fahrenheit"
        };
        comboOperaciones = new JComboBox<>(operaciones);

        botonCalcular = new JButton("Calcular");
        JLabel etiquetaResultado = new JLabel("Resultado:");
        Resultado = new JTextField();
        Resultado.setEditable(false);

        add(etiquetaNumero1);
        add(Numero1);
        add(etiquetaNumero2);
        add(Numero2);
        add(etiquetaOperacion);
        add(comboOperaciones);
        add(new JLabel());
        add(botonCalcular);
        add(etiquetaResultado);
        add(Resultado);

    botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

        setVisible(true);
    }

    private void calcularResultado() {
        try {
            double num1 = 0, num2 = 0;
            String operacion = (String) comboOperaciones.getSelectedItem();
            double resultado = 0;

            // Verificar qué tipo de operación se realiza
            if (!operacion.equals("Raíz Cuadrada") && !operacion.equals("Celsius a Fahrenheit")) {
                num1 = Double.parseDouble(Numero1.getText());
                num2 = Double.parseDouble(Numero2.getText());
            } else {
                num1 = Double.parseDouble(Numero1.getText());
            }

            // Calcular según la operación elegida
            switch (operacion) {
                case "Suma":
                    resultado = num1 + num2;
                    break;
                case "Resta":
                    resultado = num1 - num2;
                    break;
                case "Multiplicación":
                    resultado = num1 * num2;
                    break;
                case "División":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "⚠️ No se puede dividir por cero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                case "Potenciación":
                    resultado = Math.pow(num1, num2);
                    break;
                case "Raíz Cuadrada":
                    if (num1 >= 0) {
                        resultado = Math.sqrt(num1);
                    } else {
                        JOptionPane.showMessageDialog(this, "⚠️ No se puede calcular la raíz cuadrada de un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                case "Módulo":
                    resultado = num1 % num2;
                    break;
                case "Celsius a Fahrenheit":
                    resultado = (num1 * 9 / 5) + 32;
                    break;
            }

            Resultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
