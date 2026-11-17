
package br.com.fiap.main;

import br.com.fiap.entities.*;
import br.com.fiap.utils.EntradaDados;
import java.util.ArrayList;
import br.com.fiap.utils.CITEC;
import br.com.fiap.entities.Conteudo;

public class TesteSistema {

    public static void main(String[] args) {

        // Solicita o nome do usuário e apresenta a mensagem inicial
        String nome = EntradaDados.texto("Digite seu nome:");
        EntradaDados.mensagem("Bem-vindo ao Mente Aberta, " + nome + "!");

        // Registra o início da execução no console do IntelliJ
        System.out.println("===== MENTE ABERTA =====");
        System.out.println("Usuário: " + nome);
        System.out.println("Sistema iniciado!");

        // Lista principal que armazena cursos, vagas,
        // serviços públicos e benefícios sociais
        ArrayList<Oportunidade> oportunidades = new ArrayList<>();

        // LISTA DE CONTEÚDOS C.I-TEC
        ArrayList<Conteudo> conteudos = new ArrayList<>();

        int opcao;

        // Mantém o menu funcionando até o usuário escolher sair
        do {
            opcao = EntradaDados.inteiro(
                    "===== Mente Aberta =====\n" +
                            "1 - Cadastrar oportunidade\n" +
                            "2 - Consultar oportunidades\n" +
                            "3 - Filtrar por área\n" +
                            "4 - Consultar benefícios\n" +
                            "5 - C.I-TEC - Consulta Offline\n" +
                            "0 - Sair"
            );
            // Direciona o usuário para a funcionalidade escolhida
            switch (opcao) {

                // CASE 1 - CADASTRAR OPORTUNIDADE
                case 1: {
                    int tipo;
                    // Submenu para selecionar o tipo de oportunidade
                    do {
                        tipo = EntradaDados.inteiro(
                                "===== CADASTRAR OPORTUNIDADE =====\n\n" +
                                        "1 - Curso\n" +
                                        "2 - Vaga de emprego\n" +
                                        "3 - Serviço público\n" +
                                        "4 - Benefício social\n" +
                                        "0 - Voltar ao menu principal"
                        );

                        // Retorna ao menu principal
                        if (tipo == 0) {
                            break;
                        }

                        // Impede a seleção de um tipo inexistente
                        if (tipo < 1 || tipo > 4) { EntradaDados.mensagem("Tipo inválido!");
                            continue;
                        }

                        // Atributos herdados da classe oportunidade
                        int id = EntradaDados.inteiro("Digite o ID:");
                        String titulo = EntradaDados.texto("Digite o título:");
                        String descricao = EntradaDados.texto("Digite a descrição:");
                        String area = EntradaDados.texto("Digite a área:");
                        String perfilAlvo = EntradaDados.texto("Digite o público-alvo:");
                        String dataLimite = EntradaDados.texto("Digite a data limite:");

                        // Solicita os atributos específicos de cada classe
                        switch (tipo) {
                            // CADASTRO DE CURSO
                            case 1: {
                                int cargaHoraria = EntradaDados.inteiro("Digite a carga horária:");
                                String modalidade = EntradaDados.texto("Digite a modalidade:");
                                int resposta = EntradaDados.inteiro("O curso é gratuito?\n1 - Sim\n2 - Não");

                                // Converte a resposta numérica em boolean
                                boolean gratuito = (resposta == 1);

                                // Cria o objeto utilizando o construtor
                                Curso novoCurso = new Curso(
                                        id, titulo, descricao, area,
                                        perfilAlvo, dataLimite,
                                        cargaHoraria, modalidade, gratuito
                                );

                                // Armazena o curso na lista principal
                                oportunidades.add(novoCurso);

                                EntradaDados.mensagem("Curso cadastrado!");

                                // Registra o cadastro no console
                                System.out.println(nome + " cadastrou o curso: " + titulo);
                                // Executa o método de negócio da classe curso
                                System.out.println(novoCurso.verificarGratuidade());
                                break;
                            }

                            // CADASTRO DE VAGA DE EMPREGO
                            case 2: {
                                String empresa = EntradaDados.texto("Digite o nome da empresa:");
                                String tipoContrato = EntradaDados.texto("Digite o tipo de contrato:");
                                double salario = EntradaDados.real("Digite o salário:");

                                // Cria o objeto da classe vaga
                                Vaga novaVaga = new Vaga(
                                        id, titulo, descricao, area,
                                        perfilAlvo, dataLimite,
                                        empresa, tipoContrato, salario
                                );

                                // Adiciona a vaga à lista de oportunidades
                                oportunidades.add(novaVaga);

                                EntradaDados.mensagem("Vaga cadastrada!");
                                System.out.println(nome + " cadastrou a vaga: " + titulo);
                                break;
                            }

                            // CADASTRO DE SERVIÇO PÚBLICO
                            case 3: {
                                String instituicao = EntradaDados.texto("Digite a instituição responsável:");

                                // Coleta os atributos do endereço
                                String rua = EntradaDados.texto( "Cadastro do endereço\nRua:");
                                String numero = EntradaDados.texto("Número:");
                                String bairro = EntradaDados.texto("Bairro:");
                                String cidade = EntradaDados.texto("Cidade:");
                                String estado = EntradaDados.texto("Estado:");
                                String cep = EntradaDados.texto("CEP:");
                                String complemento = EntradaDados.texto("Complemento:");

                                // Cria um objeto Endereco
                                Endereco endereco = new Endereco(
                                        rua, numero, bairro, cidade,
                                        estado, cep, complemento
                                );

                                String horarioAtendimento = EntradaDados.texto("Digite o horário de atendimento:");

                                // Associa o endereço ao serviço público
                                Servico novoServico = new Servico(
                                        id, titulo, descricao, area,
                                        perfilAlvo, dataLimite,
                                        instituicao, endereco, horarioAtendimento
                                );

                                // Adiciona o serviço à lista principal
                                oportunidades.add(novoServico);

                                EntradaDados.mensagem("Serviço cadastrado!");
                                System.out.println(nome + " cadastrou o serviço: " + titulo);
                                break;
                            }

                            // CADASTRO DE BENEFÍCIO SOCIAL
                            case 4: {
                                String orgaoResponsavel = EntradaDados.texto("Digite o órgão responsável:");
                                String requisitos = EntradaDados.texto("Digite os requisitos:");
                                String documentosNecessarios = EntradaDados.texto("Digite os documentos necessários:");

                                // Cria o objeto da classe beneficio
                                Beneficio novoBeneficio = new Beneficio(
                                        id, titulo, descricao, area,
                                        perfilAlvo, dataLimite,
                                        orgaoResponsavel, requisitos,
                                        documentosNecessarios
                                );

                                oportunidades.add(novoBeneficio);
                                EntradaDados.mensagem("Benefício cadastrado!");
                                System.out.println(nome + " cadastrou o benefício: " + titulo);

                                // Executa o método de negócio da classe beneficio
                                System.out.println(novoBeneficio.listarDocumentos());
                                break;
                            }
                        }
                    } while (tipo != 0);
                    break;
                }
                // CASE 2 - CONSULTAR OPORTUNIDADES
                case 2: {
                    // Verifica se existem oportunidades cadastradas
                    if (oportunidades.isEmpty()) {
                        EntradaDados.mensagem("Nenhuma oportunidade cadastrada!");

                    } else {
                        String resultado = "===== OPORTUNIDADES DISPONÍVEIS =====\n\n";

                        // Percorre todos os objetos da lista
                        for (Oportunidade o : oportunidades) {

                            resultado += "ID: " + o.getId() + "\n";
                            resultado += "Título: " + o.getTitulo() + "\n";
                            resultado += "Descrição: " + o.getDescricao() + "\n";
                            resultado += "Área: " + o.getArea() + "\n";
                            resultado += "Público-alvo: " + o.getPerfilAlvo() + "\n";
                            resultado += "Data limite: " + o.getDataLimite() + "\n";

                            // Identifica a classe real do objeto
                            resultado += "Tipo: " + o.getClass().getSimpleName() + "\n";
                            resultado += "-------------------------\n\n";
                        }

                        // Exibe todas as oportunidades cadastradas
                        EntradaDados.mensagem(resultado);

                        // Registra a consulta e a quantidade no Run
                        System.out.println( nome + " consultou todas as oportunidades.");
                        System.out.println( "Total de oportunidades: " + oportunidades.size());
                    }
                    break;
                }

                // CASE 3 - FILTRAR OPORTUNIDADES POR ÁREA
                case 3: {

                    // Solicita a área que o usuário deseja pesquisar
                    String areaDesejada = EntradaDados.texto("Digite a área que deseja pesquisar:");

                    // Impede pesquisas nulas ou vazias
                    if (areaDesejada == null || areaDesejada.isBlank()) {
                        EntradaDados.mensagem("Digite uma área válida!");
                        break;
                    }

                    String resultado =
                            "===== OPORTUNIDADES ENCONTRADAS =====\n\n";

                    boolean encontrou = false;
                    int quantidade = 0;

                    // Pesquisa em todos os tipos de oportunidades
                    for (Oportunidade o : oportunidades) {

                        // Método herdado que verifica a área pesquisada
                        if (o.filtrarPorArea(areaDesejada)) {

                            quantidade++;
                            resultado += "ID: " + o.getId() + "\n";
                            resultado += "Título: " + o.getTitulo() + "\n";
                            resultado += "Tipo: " + o.getClass().getSimpleName() + "\n";
                            resultado += "Área: " + o.getArea() + "\n";
                            resultado += "Descrição: " + o.getDescricao() + "\n";
                            resultado += "-------------------------\n\n";

                            encontrou = true;
                        }
                    }

                    // Exibe as oportunidades que correspondem à pesquisa
                    if (encontrou) {
                        EntradaDados.mensagem(resultado);
                        System.out.println(nome + " pesquisou pela área: " + areaDesejada);
                        System.out.println("Oportunidades encontradas: " + quantidade);

                    } else {

                        EntradaDados.mensagem("Nenhuma oportunidade encontrada para: " + areaDesejada);
                        System.out.println(nome + " pesquisou por: " + areaDesejada);
                        System.out.println("Nenhuma oportunidade encontrada.");
                    }
                    break;
                }

                // CASE 4 - CONSULTAR BENEFÍCIOS SOCIAIS
                case 4: {
                    String resultado = "===== BENEFÍCIOS SOCIAIS =====\n\n";

                    int quantidade = 0;

                    // Percorre todas as oportunidades cadastradas
                    for (Oportunidade o : oportunidades) {
                        // Verifica se o objeto é da classe beneficio
                        if (o instanceof Beneficio) {

                            // Converte oportunidade para beneficio para acessar seus métodos específicos
                            Beneficio b = (Beneficio) o;
                            resultado += "ID: " + b.getId() + "\n";
                            resultado += "Benefício: " + b.getTitulo() + "\n";
                            resultado += "Descrição: " + b.getDescricao() + "\n";
                            resultado += "Área: " + b.getArea() + "\n";
                            resultado += "Órgão responsável: " + b.getOrgaoResponsavel() + "\n";
                            resultado += "Requisitos: " + b.getRequisitos() + "\n";

                            //Método que retorna os documentos necessários
                            resultado += b.listarDocumentos() + "\n";
                            resultado += "-------------------------\n\n";
                            quantidade++;
                        }
                    }
                    // Mostra os benefícios ou informa que não existem
                    if (quantidade > 0) {EntradaDados.mensagem(resultado);}
                    else {EntradaDados.mensagem("Nenhum benefício cadastrado!");}

                    // Registra a consulta no console
                    System.out.println( nome + " consultou os benefícios sociais.");
                    System.out.println("Benefícios encontrados: " + quantidade);
                    break;
                }



                case 5: {
                    // MENU C.I-TEC
                    int opcaoCitec;
                    do {
                        opcaoCitec = EntradaDados.inteiro(
                                "===== C.I-TEC =====\n"
                                        + "1 - Adicionar conteúdo educativo\n"
                                        + "2 - Consultar conteúdos\n"
                                        + "3 - Pesquisar conteúdo por tema\n"
                                        + "4 - Consultar cursos gratuitos\n"
                                        + "0 - Voltar ao Mente Aberta"
                        );
                        switch (opcaoCitec) {
                            case 1: {

                                // CADASTRAR CONTEÚDO EDUCATIVO
                                String titulo = EntradaDados.texto("Título:");
                                String tema = EntradaDados.texto("Tema:");
                                String descricao = EntradaDados.texto("Conteúdo educativo:");

                                if (titulo == null || titulo.isBlank()
                                        || tema == null || tema.isBlank()
                                        || descricao == null || descricao.isBlank()) {
                                    EntradaDados.mensagem("Preencha todos os campos!");
                                    break;
                                }
                                Conteudo novoConteudo = new Conteudo(titulo, tema, descricao);
                                conteudos.add(novoConteudo);
                                EntradaDados.mensagem("Conteúdo cadastrado com sucesso!");
                                break;
                            }

                            case 2: {
                                // CONSULTAR CONTEÚDOS EDUCATIVOS
                                if (conteudos.isEmpty()) {
                                    EntradaDados.mensagem("Nenhum conteúdo cadastrado.");
                                    break;
                                }
                                String resultado = "===== CONTEÚDOS EDUCATIVOS =====\n\n";
                                for (Conteudo c : conteudos) {
                                    resultado += "Título: " + c.getTitulo() + "\n";
                                    resultado += "Tema: " + c.getTema() + "\n";
                                    resultado += "Conteúdo: " + c.getDescricao() + "\n";
                                    resultado += "--------------------------\n";
                                }
                                EntradaDados.mensagem(resultado);
                                break;
                            }
                            case 3: {
                                // PESQUISAR CONTEÚDO POR TEMA
                                String pesquisa = EntradaDados.texto("Digite o tema:");

                                if (pesquisa == null || pesquisa.isBlank()) {
                                    EntradaDados.mensagem("Informe um tema válido.");
                                    break;
                                }
                                String resultado = "";
                                int encontrados = 0;

                                for (Conteudo c : conteudos) {

                                    if (c.getTema().toLowerCase().contains(pesquisa.trim().toLowerCase())) {
                                        resultado += "Título: " + c.getTitulo() + "\n";
                                        resultado += "Tema: " + c.getTema() + "\n";
                                        resultado += "Conteúdo: " + c.getDescricao() + "\n\n";
                                        encontrados++;}
                                }
                                if (encontrados == 0) {EntradaDados.mensagem("Nenhum conteúdo encontrado.");}
                                else {EntradaDados.mensagem(resultado);}
                                break;
                            }
                            case 4: {
                                // CONSULTAR CURSOS GRATUITOS DO MENTE ABERTA
                                String resultado = "===== CURSOS GRATUITOS =====\n\n";
                                int encontrados = 0;
                                for (Oportunidade o : oportunidades) {
                                    if (o instanceof Curso) {
                                        Curso c = (Curso) o;
                                        if (c.isGratuito()) {
                                            resultado += "Curso: " + c.getTitulo() + "\n";
                                            resultado += "Área: " + c.getArea() + "\n";
                                            resultado += "Descrição: " + c.getDescricao() + "\n";
                                            resultado += "Modalidade: " + c.getModalidade() + "\n";
                                            resultado += "Carga horária: " + c.getCargaHoraria() + " horas\n";
                                            resultado += "--------------------------\n";
                                            encontrados++;
                                        }
                                    }
                                }
                                if (encontrados == 0) {EntradaDados.mensagem("Nenhum curso gratuito disponível.");}
                                else {EntradaDados.mensagem(resultado);}
                                break;
                            }
                            case 0:
                                break;
                            default:
                                EntradaDados.mensagem("Opção inválida!");
                        }
                    } while (opcaoCitec != 0);
                    break;
                }

                // CASE 0 - ENCERRAR SISTEMA
                case 0: {
                    EntradaDados.mensagem("Até logo!");
                    System.out.println(nome + " encerrou o sistema.");
                    break;
                }

                // Trata opções que não existem no menu
                default: {
                    EntradaDados.mensagem("Opção inválida!");
                    System.out.println(nome + " digitou uma opção inválida: " + opcao);
                    break;
                }
            }
        } while (opcao != 0);
    }
}
