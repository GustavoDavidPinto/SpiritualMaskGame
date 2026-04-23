package main.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

// Essa classe "escuta" eventos do teclado
// Ao implementar KeyListener, somos obrigados a usar 3 métodos:
// keyTyped, keyPressed e keyReleased
public class KeyboardInputs implements KeyListener {

    // Referência ao GamePanel para poder modificar o jogo
    private GamePanel gamePanel;

    // Recebe o GamePanel no construtor (injeção de dependência)
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    // Não usado aqui (mais comum para texto digitado)
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Não usado aqui (seria ideal para movimento contínuo)
    @Override
    public void keyPressed(KeyEvent e) {
    }

    // Aqui está a lógica principal do teclado
    @Override
    public void keyReleased(KeyEvent e) {

        // getKeyCode() identifica qual tecla foi usada
        switch (e.getKeyCode()) {

            // Tecla A → mover para esquerda (X negativo)
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-5);
                break;

            // Tecla S → mover para baixo (Y positivo)
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(5);
                break;

            // Tecla D → mover para direita (X positivo)
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(5);
                break;

            // Tecla W → mover para cima (Y negativo)
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(-5);
                break;
        }
    }
}