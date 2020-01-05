package es.upm.pproject.prePaidCard.views;

import es.upm.pproject.prePaidCard.controllers.Controller;
import es.upm.pproject.prePaidCard.model.PrePaidCardInterface;
import es.upm.pproject.prePaidCard.model.PrePaidCardManager;

import java.awt.*;


import java.awt.EventQueue;

import javax.swing.JFrame;


public class PrePaidCard {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PrePaidCardInterface model = new PrePaidCardManager(true);
            Controller controller = new Controller(null,model);
            FrameManager view = new FrameManager(controller);
            controller.setView(view);
        });

    }

}
