package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import main.inputs.KeyboardInputs;
import main.inputs.MouseInputs;

// JPanel é a "tela" onde desenhamos no Swing
public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private long lastCheck = 0;
    private Color color = new Color(150, 20, 90);
    private Random random;

    // Posição do retângulo na tela
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;

    public GamePanel() {
        random = new Random();
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
    }

    // Move no eixo Y (vertical)
    public void changeYDelta(int value) {

        this.yDelta += value;

    }

    // Define posição diretamente (usado normalmente com mouse)
    public void setRecPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    // Método responsável por desenhar na tela
    @Override
    public void paintComponent(Graphics g) {

        // Limpa a tela antes de redesenhar (evita "rastros")
        super.paintComponent(g);
        
        g.setColor(color);
        updateRectanglee();
        // Desenha um retângulo sólido na posição atual
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

      
    }

    private void updateRectanglee() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();

        }

        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();

        }
    }

    private Color getRndColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }
}