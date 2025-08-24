package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	private static String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	private final String currentOs = os();

	public void listaProcessos() {

		try {
			if (currentOs.contains("Linux") || currentOs.contains("Mac")) {
				StringBuffer strBuffer = new StringBuffer();
				strBuffer.append("ps").append(" ").append("-ef");
				executaProcesso(strBuffer.toString());
				
			} else {
				StringBuffer strBuffer = new StringBuffer();
				strBuffer.append("TASKLIST").append(" ").append("/FO").append(" ").append("TABLE");
				executaProcesso(strBuffer.toString());
			
			}
			
		} catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
			
		}
		
	}
	
	public void mataPid(String pid) {
		
		try {
			if (currentOs.contains("Linux")) {
				StringBuffer strBuffer = new StringBuffer();
				strBuffer.append("kill").append(" ").append("-9");
				strBuffer.append(" ").append(pid);
				executaProcesso(strBuffer.toString());
				
			} else {
				StringBuffer strBuffer = new StringBuffer();
				strBuffer.append("TASKKILL").append(" ").append("/PID");
				strBuffer.append(" ").append(pid);
				executaProcesso(strBuffer.toString());
			
			}
			
		} catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
			
		}
		
	}
	
	public void mataNome(String nomeProcesso) {
		try {
			if (currentOs.contains("Linux")) {
				StringBuffer strBuffer = new StringBuffer();
				strBuffer.append("pkill").append(" ").append("-f");
				strBuffer.append(" ").append(nomeProcesso);
				executaProcesso(strBuffer.toString());
				
			} else {
				StringBuffer strBuffer = new StringBuffer();
				strBuffer.append("TASKKILL").append(" ").append("/IM");
				strBuffer.append(" ").append(nomeProcesso);
				executaProcesso(strBuffer.toString());
			
			}
			
		} catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
			
		}
	
	}
	
	private void executaProcesso(String process) {

		try {
			Process p = Runtime.getRuntime().exec(process);
			readAllLines(p);

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
			
		}
		
	}
	
	private void readAllLines(Process p) {
		InputStream inStream = p.getInputStream();
		InputStreamReader reader = new InputStreamReader(inStream);
		BufferedReader rdrBuffer = new BufferedReader(reader);
		
		try {
			String linha = rdrBuffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = rdrBuffer.readLine();
			}
			
			rdrBuffer.close();
			inStream.close();
			reader.close();

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
			
		}
		
	}

}
