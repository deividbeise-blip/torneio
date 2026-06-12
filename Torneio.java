import java.util.Scanner;
import java.util.Arrays;

public class Torneio {
    public static void main(String[] args) {
        // Classes de combate disponiveis
        Scanner scanner = new Scanner(System.in);
            // Classes de combate disponiveis
            String classeCaca       = "Caca";
            String classeGuerra     = "Guerra";
            String classeEstrategia = "Estrategia";
            String classeMagia      = "Magia";

            // Vetores para armazenar os dados dos 8 lutadores
            int MAX = 8;
            String[] nomes      = new String[MAX];
            String[] classes    = new String[MAX];
            int[]    ataques    = new int[MAX];
            int[]    defesas    = new int[MAX];
            int[]    agilidades = new int[MAX];
            int[]    danos      = new int[MAX];

            int totalCadastrados = 0;
            int opcao;

                // Matriz de combate (12x2) - cada linha indica um confronto entre índices
                int[][] matriz = {
                    {3, 4},
                    {3, 5},
                    {1, 7},
                    {4, 5},
                    {6, 3},
                    {7, 0},
                    {7, 5},
                    {1, 0},
                    {6, 4},
                    {2, 6},
                    {1, 2},
                    {0, 2}
                };

                // Matriz de pontuações (8 lutadores x 3 combates)
                int[][] pontuacoes = new int[8][3];
                boolean lutasExecutadas = false;

                System.out.println("   Liga de Lutadores(as) de Alegrete       ");


            // Loop principal do menu
            do {

                System.out.println("              MENU PRINCIPAL               ");

                System.out.println("1 - Registrar lutadores(as)");
                System.out.println("2 - Mostrar lutadores(as)");
                System.out.println("3 - Buscar por nome");
                System.out.println("4 - Listar por classe");
                System.out.println("5 - Mostrar combates");
                System.out.println("6 - Executar Lutas");
                System.out.println("7 - Mostrar lutas");
                System.out.println("8 - Mostrar ranking");
                System.out.println("9 - Encerrar");
                System.out.print("Escolha uma opcao: ");

                while (!scanner.hasNextInt()) {
                    System.out.print("[AVISO] Digite um numero valido: ");
                    scanner.next();
                }
                opcao = scanner.nextInt();
                scanner.nextLine();

                // -------------------------------------------------------
                // OPCAO 1 — Registrar lutadores
                // -------------------------------------------------------
                switch (opcao) {
                    case 1: {
                        if (totalCadastrados == MAX) {
                            System.out.println("\n[AVISO] Todos os 8 lutadores(as) ja foram registrados.\n");
                        } else {
                            System.out.println("\n--- Registro de Lutadores(as) ---");
                            System.out.println("Cadastrados: " + totalCadastrados + "/" + MAX);

                            int vagas = MAX - totalCadastrados;
                            System.out.print("Quantos deseja registrar agora? (max " + vagas + "): ");

                            while (!scanner.hasNextInt()) {
                                System.out.print("[AVISO] Digite um numero valido: ");
                                scanner.next();
                            }
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            if (quantidade <= 0 || quantidade > vagas) {
                                System.out.println("[AVISO] Valor invalido. Registrando o maximo disponivel (" + vagas + ").");
                                quantidade = vagas;
                            }

                            // Loop para cadastrar cada lutador
                            for (int i = 0; i < quantidade; i++) {
                                int idx = totalCadastrados;
                                System.out.println("\n-- Lutador(a) " + (idx + 1) + " --");

                                // Nome — nao pode ser vazio
                                System.out.print("Nome: ");
                                nomes[idx] = scanner.nextLine().trim();
                                while (nomes[idx].isEmpty()) {
                                    System.out.print("[AVISO] Nome nao pode ser vazio. Nome: ");
                                    nomes[idx] = scanner.nextLine().trim();
                                }

                                // Classe — normaliza removendo acento e convertendo pra minusculo
                                // assim "Caça", "CACA", "caça", "Caca" etc. sao todos aceitos
                                System.out.print("Classe (" + classeCaca + " / " + classeGuerra + " / " + classeEstrategia + " / " + classeMagia + "): ");
                                String classeDigitada = scanner.nextLine().trim().toLowerCase()
                                        .replace("ç", "c").replace("é", "e").replace("á", "a")
                                        .replace("ê", "e").replace("ã", "a").replace("ó", "o");

                                while (!classeDigitada.equals("caca")
                                        && !classeDigitada.equals("guerra")
                                        && !classeDigitada.equals("estrategia")
                                        && !classeDigitada.equals("magia")) {
                                    System.out.print("[AVISO] Classe invalida. Digite " + classeCaca + ", " + classeGuerra + ", " + classeEstrategia + " ou " + classeMagia + ": ");
                                    classeDigitada = scanner.nextLine().trim().toLowerCase()
                                            .replace("ç", "c").replace("é", "e").replace("á", "a")
                                            .replace("ê", "e").replace("ã", "a").replace("ó", "o");
                                }

                                // Salva o nome padrao da classe (com acento e maiuscula correta)
                                switch (classeDigitada) {
                                    case "caca":
                                        classes[idx] = classeCaca;
                                        break;
                                    case "guerra":
                                        classes[idx] = classeGuerra;
                                        break;
                                    case "estrategia":
                                        classes[idx] = classeEstrategia;
                                        break;
                                    default:
                                        classes[idx] = classeMagia;
                                        break;
                                }

                                // Ataque — de 0 a 100
                                System.out.print("Ataque (0-100): ");
                                while (!scanner.hasNextInt()) {
                                    System.out.print("[AVISO] Digite um numero inteiro: ");
                                    scanner.next();
                                }
                                ataques[idx] = scanner.nextInt();
                                scanner.nextLine();
                                while (ataques[idx] < 0 || ataques[idx] > 100) {
                                    System.out.print("[AVISO] Valor deve ser entre 0 e 100. Ataque: ");
                                    while (!scanner.hasNextInt()) {
                                        System.out.print("[AVISO] Digite um numero inteiro: ");
                                        scanner.next();
                                    }
                                    ataques[idx] = scanner.nextInt();
                                    scanner.nextLine();
                                }

                                // Defesa — de 0 a 100
                                System.out.print("Defesa (0-100): ");
                                while (!scanner.hasNextInt()) {
                                    System.out.print("[AVISO] Digite um numero inteiro: ");
                                    scanner.next();
                                }
                                defesas[idx] = scanner.nextInt();
                                scanner.nextLine();
                                while (defesas[idx] < 0 || defesas[idx] > 100) {
                                    System.out.print("[AVISO] Valor deve ser entre 0 e 100. Defesa: ");
                                    while (!scanner.hasNextInt()) {
                                        System.out.print("[AVISO] Digite um numero inteiro: ");
                                        scanner.next();
                                    }
                                    defesas[idx] = scanner.nextInt();
                                    scanner.nextLine();
                                }

                                // Agilidade — de 0 a 100
                                System.out.print("Agilidade (0-100): ");
                                while (!scanner.hasNextInt()) {
                                    System.out.print("[AVISO] Digite um numero inteiro: ");
                                    scanner.next();
                                }
                                agilidades[idx] = scanner.nextInt();
                                scanner.nextLine();
                                while (agilidades[idx] < 0 || agilidades[idx] > 100) {
                                    System.out.print("[AVISO] Valor deve ser entre 0 e 100. Agilidade: ");
                                    while (!scanner.hasNextInt()) {
                                        System.out.print("[AVISO] Digite um numero inteiro: ");
                                        scanner.next();
                                    }
                                    agilidades[idx] = scanner.nextInt();
                                    scanner.nextLine();
                                }

                                // Dano calculado automaticamente
                                danos[idx] = ataques[idx] + defesas[idx] + agilidades[idx];
                                System.out.println("Dano calculado: " + danos[idx]);
                                System.out.println("Lutador(a) registrado(a) com sucesso!");

                                totalCadastrados++;
                            }

                            System.out.println("\nTotal registrados: " + totalCadastrados + "/" + MAX + "\n");
                        }
                        System.out.println("Pressione Enter para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }
                    
                    // -------------------------------------------------------
                    // OPCAO 2 — Mostrar todos os lutadores
                    // -------------------------------------------------------
                    case 2: {
                        System.out.println("\n--- Lista de Lutadores(as) ---");
                        if (totalCadastrados == 0) {
                            System.out.println("[AVISO] Nenhum(a) lutador(a) registrado(a) ainda.\n");
                        } else {
                            for (int i = 0; i < totalCadastrados; i++) {
                                System.out.println("---------------------------");
                                System.out.println("Nome      : " + nomes[i]);
                                System.out.println("Classe    : " + classes[i]);
                                System.out.println("Ataque    : " + ataques[i]);
                                System.out.println("Defesa    : " + defesas[i]);
                                System.out.println("Agilidade : " + agilidades[i]);
                                System.out.println("Dano      : " + danos[i]);
                            }
                            System.out.println("---------------------------\n");
                        }
                        System.out.println("Pressione Enter para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }

                    // -------------------------------------------------------
                    // OPCAO 3 — Buscar por nome
                    // -------------------------------------------------------
                    case 3: {
                        System.out.println("\n--- Buscar por Nome ---");
                        if (totalCadastrados == 0) {
                            System.out.println("[AVISO] Nenhum(a) lutador(a) registrado(a) ainda.\n");
                        } else {
                            System.out.print("Digite o nome: ");
                            String busca = scanner.nextLine().trim();
                            
                            boolean encontrado = false;
                            
                            for (int i = 0; i < totalCadastrados; i++) {
                                if (nomes[i].equalsIgnoreCase(busca)) {
                                    System.out.println("\nLutador(a) encontrado(a):");
                                    System.out.println("---------------------------");
                                    System.out.println("Nome      : " + nomes[i]);
                                    System.out.println("Classe    : " + classes[i]);
                                    System.out.println("Ataque    : " + ataques[i]);
                                    System.out.println("Defesa    : " + defesas[i]);
                                    System.out.println("Agilidade : " + agilidades[i]);
                                    System.out.println("Dano      : " + danos[i]);
                                    System.out.println("---------------------------\n");
                                    encontrado = true;
                                    break;
                                }
                            }
                            
                            if (!encontrado) {
                                System.out.println("[AVISO] Lutador(a) \"" + busca + "\" nao encontrado(a).\n");
                            }
                        }
                        System.out.println("Pressione Enter para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }

                    // -------------------------------------------------------
                    // OPCAO 4 — Listar por classe
                    // -------------------------------------------------------
                    case 4: {
                        System.out.println("\n--- Listar por Classe ---");
                        if (totalCadastrados == 0) {
                            System.out.println("[AVISO] Nenhum(a) lutador(a) registrado(a) ainda.\n");
                        } else {
                            System.out.print("Classe (" + classeCaca + " / " + classeGuerra + " / " + classeEstrategia + " / " + classeMagia + "): ");
                            
                            // Mesma normalizacao: remove acento e converte pra minusculo
                            String classeBusca = scanner.nextLine().trim().toLowerCase()
                                    .replace("ç", "c").replace("é", "e").replace("á", "a")
                                    .replace("ê", "e").replace("ã", "a").replace("ó", "o");
                            
                            if (!classeBusca.equals("caca")
                                    && !classeBusca.equals("guerra")
                                    && !classeBusca.equals("estrategia")
                                    && !classeBusca.equals("magia")) {
                                System.out.println("[AVISO] Classe invalida. Use: " + classeCaca + ", " + classeGuerra + ", " + classeEstrategia + " ou " + classeMagia + ".\n");
                            } else {
                                // Converte para o nome padrao para exibir certinho
                                String classeNomePadrao;
                                switch (classeBusca) {
                                    case "caca":
                                        classeNomePadrao = classeCaca;
                                        break;
                                    case "guerra":
                                        classeNomePadrao = classeGuerra;
                                        break;
                                    case "estrategia":
                                        classeNomePadrao = classeEstrategia;
                                        break;
                                    default:
                                        classeNomePadrao = classeMagia;
                                        break;
                                }
                                
                                boolean achouAlgum = false;
                                System.out.println("\nLutadores(as) da classe " + classeNomePadrao + ":");
                                
                                for (int i = 0; i < totalCadastrados; i++) {
                                    if (classes[i].equals(classeNomePadrao)) {
                                        System.out.println("---------------------------");
                                        System.out.println("Nome      : " + nomes[i]);
                                        System.out.println("Classe    : " + classes[i]);
                                        System.out.println("Ataque    : " + ataques[i]);
                                        System.out.println("Defesa    : " + defesas[i]);
                                        System.out.println("Agilidade : " + agilidades[i]);
                                        System.out.println("Dano      : " + danos[i]);
                                        System.out.println("---------------------------");
                                        achouAlgum = true;
                                    }
                                }
                                
                                if (!achouAlgum) {
                                    System.out.println("[AVISO] Nenhum(a) lutador(a) da classe " + classeNomePadrao + " foi registrado(a).\n");
                                } else {
                                    System.out.println();
                                }
                            }
                        }
                        System.out.println("Pressione Enter para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }

                    // -------------------------------------------------------
                    // OPCAO 5 — Mostrar combates
                    // -------------------------------------------------------
                    case 5: {
                        System.out.println("\n--- Combates ---");
                        for (int i = 0; i < matriz.length; i++) {
                            int a = matriz[i][0];
                            int b = matriz[i][1];
                            String nomeA = (a < totalCadastrados && nomes[a] != null) ? nomes[a] : "(vazio)";
                            String nomeB = (b < totalCadastrados && nomes[b] != null) ? nomes[b] : "(vazio)";
                            System.out.printf("%2d) %s (indice %d)  x  %s (indice %d)\n", i + 1, nomeA, a, nomeB, b);
                        }
                        System.out.println("\nPressione Enter para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }

                    // -------------------------------------------------------
                    // OPCAO 6 — Executar lutas
                    // -------------------------------------------------------
                    case 6: {
                        if (totalCadastrados < MAX) {
                            System.out.println("\n[AVISO] Cadastre os 8 lutadores antes de executar as lutas.\n");
                            System.out.println("Pressione Enter para voltar ao menu...");
                            scanner.nextLine();
                            break;
                        }

                        // reseta pontuacoes
                        for (int i = 0; i < pontuacoes.length; i++) Arrays.fill(pontuacoes[i], 0);
                        int[] contagemLutas = new int[8];

                        for (int i = 0; i < matriz.length; i++) {
                            int a = matriz[i][0];
                            int b = matriz[i][1];
                            int danoA = danos[a];
                            int danoB = danos[b];

                            int scoreA = danoA - danoB;
                            int scoreB = danoB - danoA;

                            if (contagemLutas[a] < 3) pontuacoes[a][contagemLutas[a]++] = scoreA;
                            if (contagemLutas[b] < 3) pontuacoes[b][contagemLutas[b]++] = scoreB;
                        }

                        lutasExecutadas = true;
                        System.out.println("\nLutas executadas e pontuações calculadas.\n");
                        System.out.println("Pressione Enter para voltar ao menu...");
                        scanner.nextLine();
                        break;
                    }







                    case 9:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("\n[AVISO] Opcao invalida. Escolha entre 1 e 9.\n");
                        break;
                }
            } while (opcao != 9);

            scanner.close();
    }
}
