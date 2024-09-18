package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ClienteView {
    public static void main(String[] args) {
        do{
            int id;
            String placa, nome;
            int opcao;
            String[] escolha = {"Inserir","Alterar", "Excluir", "Listar"};
            ClienteController clienteController = new ClienteController();
            try{
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um cliente " +
                                "huahuahua",
                        "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

                switch (opcao){
                    case 0:
                        nome = JOptionPane.showInputDialog("Qual o nome do cliente?");
                        placa = JOptionPane.showInputDialog("Insira a placa do carro!");
                        JOptionPane.showMessageDialog(null, clienteController.inserirCliente(nome, placa));
                        break;
                    case 1:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do cliente!"));
                        nome = JOptionPane.showInputDialog("Nome do cliente novo: ");
                        placa = JOptionPane.showInputDialog("Nova placa do cliente: ");
                        JOptionPane.showMessageDialog(null, clienteController.alterarCliente(id, nome, placa));
                        break;
                    case 2:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do cliente!"));
                        JOptionPane.showMessageDialog(null, clienteController.excluirCliente(id));
                        break;
                    case 3:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do cliente!"));
                        JOptionPane.showMessageDialog(null, clienteController.listarUm(id));
                        break;
                }
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }

        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar? ", "Atenção", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0);
    }
}
