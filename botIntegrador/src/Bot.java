import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bot {
    private String nome = "Chiquinho";
    private String senha = "gabilinda";
    private String descricao = "Um bot criado para te ajudar com duvidas sobre os produtos do nosso site";

    private String enderecoExcel = "H://FPOO/ProjetoIntegradorGabriela.xls";

    LerEscreverExcel teste = new LerEscreverExcel(enderecoExcel);

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void botOpcoes() {
        System.out.println("Oi, eu sou o "+this.nome);
        System.out.println("Eu sou o "+this.descricao);
        System.out.println("Como posso te ajudar?: ");
        System.out.println("1 - Ver todos os produtos do site");
        System.out.println("2 - Ver todos os preços dos produtos");
        System.out.println("3 - Ver a descrição dos produtos");
        System.out.println("4 - Ver a quantidade em estoque");
        System.out.println("5 - Ver todos os dados de um usuario cadastrado");
        System.out.println("6 - Mostar senha");
        System.out.println("Digite a opcao desejada:");
    }

    public void executarBot(int opcao) throws BiffException, IOException {

        Scanner sc = new Scanner(System.in);

        teste.lerExcel();

        switch (opcao) {
            case 1:
                System.out.println("Todos os produtos do site");
                for (int x = 1; x <= teste.getAs2().length - 1; x++) {
                    System.out.println(teste.getAs2()[x]);
                }
                break;
            case 2:
                System.out.println("Todos os preços dos produtos");
                for (int x = 1; x <= teste.getAs3().length - 1; x++) {
                    System.out.println(teste.getAs3()[x]);
                }
                break;
            case 3:
                System.out.println("Todas as descrições dos produtos");
                for (int x = 1; x <= teste.getAs4().length - 1; x++) {
                    System.out.println(teste.getAs4()[x]);
                }
                break;
            case 4:
                System.out.println("Todas os produtos em estoque");
                for (int x = 1; x <= teste.getAs5().length - 1; x++) {
                    System.out.println(teste.getAs5()[x]);
                }
                break;
            case 5:
                boolean flag = false;
                System.out.println("Digite o código do usuario:");
                String codigo = sc.next();
                String[] codigos = teste.getAs1();
                String[] nomes = teste.getAs2();
                String[] telefones = teste.getAs3();
                String[] emails = teste.getAs4();
                String[] datas = teste.getAs5();
                for (int x = 0; x <= Arrays.asList(codigo).size(); x++) {
                    if(Arrays.asList(codigos).get(x).equals(codigo)){
                        System.out.println("Todos os dados de um usuario cadastrado");
                        System.out.println("Produtos: "+ Arrays.asList(codigos).get(x));
                        System.out.println("Preços: "+Arrays.asList(nomes).get(x));
                        System.out.println("Descriçao: "+Arrays.asList(telefones).get(x));
                        System.out.println("Quantidade em estoque: "+Arrays.asList(emails).get(x));
                        System.out.println("Data de Cadastro: "+Arrays.asList(datas).get(x));
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("Usuario não encontrado!");
                }
                break;
            case 6:
                System.out.println("A senha é "+this.senha);
            default:
                System.out.println("Opcao invalida!");
                break;
        }

        System.out.println("Desejar escolher outra opcao?S ou N");

    }
}