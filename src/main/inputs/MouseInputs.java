package main.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.GamePanel;

// Essa classe escuta eventos do mouse:
// - MouseListener → cliques, pressionar, soltar, entrar/sair
// - MouseMotionListener → movimento e arrasto
public class MouseInputs implements MouseListener, MouseMotionListener {

    // Referência ao GamePanel para alterar o estado do jogo
    private GamePanel gamePanel;

    // Recebe o painel no construtor (mesma ideia do teclado)
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    // Dispara quando o mouse é arrastado (clicado + movendo)
    @Override
    public void mouseDragged(MouseEvent e) {
        // Não está sendo usado aqui
        System.out.println("");
    }

    // Dispara quando o mouse se move (sem clicar)
    @Override
    public void mouseMoved(MouseEvent e) {

        // getX() e getY() → posição atual do mouse dentro do painel

        // Atualiza a posição do retângulo para seguir o mouse
        gamePanel.setRecPos(e.getX(), e.getY());
    }

    // Dispara quando ocorre um clique completo (pressionar + soltar)
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
    }

    // Dispara quando o botão do mouse é pressionado
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("");
    }

    // Dispara quando o botão do mouse é solto
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("");
    }

    // Dispara quando o cursor entra na área do componente (GamePanel)
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");
    }

    // Dispara quando o cursor sai da área do componente
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");
    }
}