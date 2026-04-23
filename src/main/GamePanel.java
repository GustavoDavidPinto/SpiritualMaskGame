package main;

import java.awt.Graphics;
import javax.swing.JPanel;

import main.inputs.KeyboardInputs;
import main.inputs.MouseInputs;

// JPanel é a "tela" onde desenhamos no Swing
public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;

    // Posição do retângulo na tela
    private int xDelta = 100, yDelta = 100;

    public GamePanel() {

        // Inicializa controle do mouse
        mouseInputs = new MouseInputs(this);

        // Registra o teclado no painel
        addKeyListener(new KeyboardInputs(this));

        // Registra eventos do mouse
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        // IMPORTANTE: permite que o painel receba eventos de teclado
        setFocusable(true);
        requestFocus();
    }

    // Move no eixo X (horizontal)
    public void changeXDelta(int value) {

        // Soma o valor (movimento incremental)
        this.xDelta += value;

        // Solicita redesenho da tela
        repaint();
    }

    // Move no eixo Y (vertical)
    public void changeYDelta(int value) {

        this.yDelta += value;

        repaint();
    }

    // Define posição diretamente (usado normalmente com mouse)
    public void setRecPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    // Método responsável por desenhar na tela
    @Override
    public void paintComponent(Graphics g) {

        // Limpa a tela antes de redesenhar (evita "rastros")
        super.paintComponent(g);

        // Desenha um retângulo sólido na posição atual
        g.fillRect(xDelta, yDelta, 200, 50);
    }
}