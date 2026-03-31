package main.java.app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculadoraV1 {
	
	//Atributo da calculadora
	private JFrame frame;
	private JTextField campo;
	private double num1, num2;
	private String operacao;
	
	public CalculadoraV1() {
		frame = new JFrame("Calculadora");
		frame.setSize(300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		campo = new JTextField();
		campo.setBounds(30, 20, 220, 30);
		frame.add(campo);
		
		criarBotao("1", 30, 70);
		criarBotao("2", 90, 70);
		criarBotao("3", 150, 70);
		
		criarBotao("4", 30, 120);
		criarBotao("5", 90, 120);
		criarBotao("6", 150, 120);
		
		criarBotao("7", 30, 170);
		criarBotao("8", 90, 170);
		criarBotao("9", 150, 170);
		
		criarBotao("0", 90, 220);
		
		criarOperacao("+", 210, 70);
		criarOperacao("-", 210, 120);
		criarOperacao("*", 210, 170);
		criarOperacao("/", 210, 220);
		
		JButton igual = new JButton("=");
		igual.setBounds(30, 220, 50, 30);
		frame.add(igual);
		
		igual.addActionListener(e -> calcular());
		
		JButton limpar = new JButton("L");
		limpar.setBounds(150, 220, 50, 30);
		frame.add(limpar);
		limpar.addActionListener(e -> campo.setText(""));
		
		frame.setVisible(true);
		
	}
		
		private void criarBotao(String texto, int x, int y) {
			JButton botao = new JButton(texto);
			botao.setBounds(x, y, 50, 30);
			frame.add(botao);
			
			botao.addActionListener(e -> campo.setText(campo.getText() + texto));
				
	}
		
		private void criarOperacao(String op, int x, int y) {
			JButton botao = new JButton(op);
			botao.setBounds(x, y, 50, 30);
			frame.add(botao);
			
			botao.addActionListener(e -> {
				num1 = Double.parseDouble(campo.getText());
				operacao = op;
				campo.setText("");
			});
	}
		
		private void calcular() {
			num2 = Double.parseDouble(campo.getText());
			double resultado = 0;
			
			switch (operacao) {
			case "+":
				resultado = num1 + num2;
				break;
			case "-":
				resultado = num1 - num2;
				break;
			case "*":
				resultado = num1 * num2;
				break;
			case "/":
				if (num2 != 0) {
					resultado = num1 / num2;
				} 
				else {
					campo.setText("ERRO");
					return;
				}
				break;
			}
			
			campo.setText(String.valueOf(resultado));
		}
		
		public static void main(String[] args) {
			new CalculadoraV1();
		}		
}
