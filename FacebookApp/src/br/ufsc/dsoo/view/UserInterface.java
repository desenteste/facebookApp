package br.ufsc.dsoo.view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import br.ufsc.dsoo.controller.Validate;
import facebook4j.Facebook;

public class UserInterface {

	Validate validate;
	
	public UserInterface() {
		validate = new Validate();
	}

	public String insertOAuthAcessToken(Facebook facebook) {
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String link = facebook.getOAuthAuthorizationURL("http://www.athom.com.br/");
		clipboard.setContents(new StringSelection(link), null);
		return JOptionPane.showInputDialog("Acesse o endereço que está na sua área de transferência e cole o código informado:");
		
	}

	public void showApplicationOptions(Facebook facebook) {

		int option = 0;
		
		try{
			option = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada:\n"
				+ "\n[1] Confirmar presença em eventos que contenham \"OPEN BAR\" e \"OPEN FOOD\" em seu título"
				+ "\n[2] Fazer uma postagem e marcar todos os seus amigos"
				+ "\n[3] Dividir os membros de um grupo em Listas de amigos conforme o sexo da pessoa"
				+ "\n[4] Ajuda"
				+ "\n[5] Sobre"
				+ "\n[0] Sair da aplicação"));
		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "ERRO: Você precisa informar um valor inteiro!");
			this.showApplicationOptions(facebook);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERRO: Você precisa informar um valor inteiro!");
			this.showApplicationOptions(facebook);
		}
		validate.optionValidate(option, facebook);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void showHelp(Facebook facebook) {
		JOptionPane.showMessageDialog(null, "[Funcionalidade 1]"
				+ "\n(Usuário) Informa o valor correspondente a primeira funcionalidade no menu de opções."
				+ "\n(Sistema) Efetua uma busca em todos os eventos que o usuário foi convidado."
				+ "\n(Sistema) Confirma automaticamente a presença em todos os eventos que constarem OPEN BAR e OPEN FOOD em seu título.\n"
				+ "\n[Funcionalidade 2] "
				+ "\n(Usuário) Informa o valor correspondente a segunda funcionalidade no menu de opções."
				+ "\n(Sistema) Exibe uma tela com um campo para inserção do conteúdo a ser postado."
				+ "\n(Usuário) Informa a mensagem a ser postada."
				+ "\n(Sistema) Posta a mensagem informada no feed do usuário e efetua a marcação de todos os amigos.\n"
				+ "\n[Funcionalidade 3] "
				+ "\n(Usuário) Informa o valor correspondente a segunda funcionalidade no menu de opções."
				+ "\n(Sistema) Faz uma busca nos membros do grupo pré definido e os separa em Lista de Amigos conforme seu gênero.", "Manual das funcionalidades - TF1", 1);
		this.showApplicationOptions(facebook);
	}

	public void showAboutUs(Facebook facebook) {
		JOptionPane.showMessageDialog(null, "Aplicação desenvolvida por:\n"
				+ "\nGuilherme Luiz Ventura - 13201001"
				+ "\nKádio Francisco Miguel Colzani - 13201010"
				+ "\nMárcio Pereira dos Santos - 13201017\n"
				+ "\nVersão 1.0", "Sobre o Grupo", 1);
		this.showApplicationOptions(facebook);
	}
}
