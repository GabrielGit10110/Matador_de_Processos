package view;


import javax.swing.JOptionPane;

import controller.*;

public class Main {

	public static void main(String[] args) {
		KillController kc = new KillController();
		userOptions(kc);

	}
	
	private static void userOptions(KillController kc) {
		int options = 0;
		String cmnd = "";
		
		do {
			options = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1- Listar processos. \n"
				+	"2- Matar processo pelo PID. \n"
				+	"3- Matar processo pelo nome. \n"
				+	"9- Finalizar."));
			
			switch (options) {
			case 1:
				kc.listaProcessos();
				break;
			case 2:
				cmnd = userChoice("PID");
				kc.mataPid(cmnd);

				break;
			case 3:
				cmnd = userChoice("Nome");
				kc.mataNome(cmnd);

				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Finalizando...");

				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida. Digite novamente...");
			}
			
		} while (options != 9);

	}
				
	private static String userChoice(String pidOrName) {
		String cmnd = "";
		
		cmnd = JOptionPane.showInputDialog("Digite o " + pidOrName + " do processo");
		
		return cmnd;
	}
	
}