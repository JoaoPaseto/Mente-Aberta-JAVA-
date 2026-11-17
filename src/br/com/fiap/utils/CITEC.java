package br.com.fiap.utils;

import br.com.fiap.entities.Oportunidade;
import java.util.ArrayList;

    public class CITEC {

        // MÉTODO DE CONSULTA OFFLINE
        public static void consultarOffline(
                ArrayList<Oportunidade> oportunidades) {

            if (oportunidades.isEmpty()) {EntradaDados.mensagem("C.I-TEC: Nenhuma oportunidade cadastrada.");}
            else {String resultado = "===== C.I-TEC =====\n\n";

                // LISTAR OPORTUNIDADES
                for (Oportunidade o : oportunidades) {
                    resultado += "Título: " + o.getTitulo() + "\n";
                    resultado += "Área: " + o.getArea() + "\n";
                    resultado += "Descrição: " + o.getDescricao() + "\n";
                    resultado += "--------------------\n";
                }
                EntradaDados.mensagem(resultado);
            }
        }
    }

