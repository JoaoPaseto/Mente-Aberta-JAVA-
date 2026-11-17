package br.com.fiap.utils;

import javax.swing.*;

public class EntradaDados {

    // Recebe informações em formato de texto
    public static String texto(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    // Recebe números inteiros e impede entradas inválidas
    public static int inteiro(String mensagem) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensagem);

            // Identifica quando o usuário clica em Cancelar
            if (entrada == null) {
                return 0;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                mensagem("Digite um número inteiro válido!");
            }
        }
    }

    // Recebe números decimais
    public static double real(String mensagem) {

        while (true) {
            String entrada = JOptionPane.showInputDialog(mensagem);
            if (entrada == null) {
                return 0;
            }
            try {
                // Aceita tanto vírgula quanto ponto decimal
                entrada = entrada.trim().replace(",", ".");
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                mensagem("Digite um número decimal válido!");
            }
        }
    }


    public static void mensagem(String mensagem) {

        // MENSAGENS PEQUENAS
        if (mensagem.length() <= 300) {JOptionPane.showMessageDialog(null, mensagem);}
        else {
            // MENSAGENS GRANDES
            JTextArea texto = new JTextArea(mensagem, 15, 40);

            texto.setEditable(false);
            texto.setLineWrap(true);
            texto.setWrapStyleWord(true);

            JScrollPane rolagem = new JScrollPane(texto);

            JOptionPane.showMessageDialog(null, rolagem);
        }
    }

}

