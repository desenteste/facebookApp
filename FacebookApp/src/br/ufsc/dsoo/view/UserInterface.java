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
		return JOptionPane.showInputDialog("Acesse o endere�o que est� na sua �rea de transfer�ncia e cole o c�digo informado:");
		
	}

	public void showApplicationOptions(Facebook facebook) {

		int option = 0;
		
		try{
			option = Integer.parseInt(JOptionPane.showInputDialog("Informe a op��o desejada:\n"
				+ "\n[1] Confirmar presen�a em eventos que contenham \"OPEN BAR\" e \"OPEN FOOD\" em seu t�tulo"
				+ "\n[2] Fazer uma postagem e marcar todos os seus amigos"
				+ "\n[3] Dividir os membros de um grupo em Listas de amigos conforme o sexo da pessoa"
				+ "\n[4] Ajuda"
				+ "\n[5] Sobre"
				+ "\n[0] Sair da aplica��o"));
		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "ERRO: Voc� precisa informar um valor inteiro!");
			this.showApplicationOptions(facebook);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERRO: Voc� precisa informar um valor inteiro!");
			this.showApplicationOptions(facebook);
		}
		validate.optionValidate(option, facebook);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void showHelp(Facebook facebook) {
		JOptionPane.showMessageDialog(null, "[Funcionalidade 1]"
				+ "\n(Usu�rio) Informa o valor correspondente a primeira funcionalidade no menu de op��es."
				+ "\n(Sistema) Efetua uma busca em todos os eventos que o usu�rio foi convidado."
				+ "\n(Sistema) Confirma automaticamente a presen�a em todos os eventos que constarem OPEN BAR e OPEN FOOD em seu t�tulo.\n"
				+ "\n[Funcionalidade 2] "
				+ "\n(Usu�rio) Informa o valor correspondente a segunda funcionalidade no menu de op��es."
				+ "\n(Sistema) Exibe uma tela com um campo para inser��o do conte�do a ser postado."
				+ "\n(Usu�rio) Informa a mensagem a ser postada."
				+ "\n(Sistema) Posta a mensagem informada no feed do usu�rio e efetua a marca��o de todos os amigos.\n"
				+ "\n[Funcionalidade 3] "
				+ "\n(Usu�rio) Informa o valor correspondente a segunda funcionalidade no menu de op��es."
				+ "\n(Sistema) Faz uma busca nos membros do grupo pr� definido e os separa em Lista de Amigos conforme seu g�nero.", "Manual das funcionalidades - TF1", 1);
		this.showApplicationOptions(facebook);
	}

	public void showAboutUs(Facebook facebook) {
		JOptionPane.showMessageDialog(null, "Aplica��o desenvolvida por:\n"
				+ "\nGuilherme Luiz Ventura - 13201001"
				+ "\nK�dio Francisco Miguel Colzani - 13201010"
				+ "\nM�rcio Pereira dos Santos - 13201017\n"
				+ "\nVers�o 1.0", "Sobre o Grupo", 1);
		this.showApplicationOptions(facebook);
	}
}
