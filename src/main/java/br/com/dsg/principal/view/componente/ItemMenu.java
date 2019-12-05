package br.com.dsg.principal.view.componente;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.ImageIcon;

import br.com.dsg.swing.controller.action.AbstractAction;
import br.com.dsg.swing.util.Constantes;

public class ItemMenu extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1923843665779481525L;
	javax.swing.GroupLayout layoutItem = new javax.swing.GroupLayout(this);
	private javax.swing.JPanel ind = new javax.swing.JPanel();
	private javax.swing.JLabel jLabel = new javax.swing.JLabel();
	private javax.swing.JLabel imagem = new javax.swing.JLabel();
	
	private int ordem = 0;
	private int posicao = 0;
	
	private AbstractAction action;
	
	public ItemMenu(String nome, String imagepath, AbstractAction action) {
		
		setName(nome);
		
		this.action = action;
		
		setBackground(Constantes.COR_FUNDO_ITEM_MENU);
		setLayout(layoutItem);
		
		ind.setOpaque(false);
        ind.setPreferredSize(new java.awt.Dimension(3, 43));
        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind);
        ind.setLayout(ind_1Layout);

        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel.setForeground(Constantes.COR_FUNDO_LABEL_ITEM_MENU);
        jLabel.setText(nome);
		
        Box box = Box.createHorizontalBox();
        
        if(imagepath==null) {
        	imagepath = "/imagens/icons8-cardapio-16.png";
        }
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource(imagepath));
		imagem.setIcon(icon);
		box.add(ind);
        box.add(imagem);
        box.add(jLabel);
		
        layoutItem.setHorizontalGroup(
            layoutItem.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutItem.createSequentialGroup()
                .addComponent(ind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        layoutItem.setVerticalGroup(
            layoutItem.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutItem.createSequentialGroup()
                .addComponent(ind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layoutItem.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
		
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	ItemMenu.this.action.executar();
            }
        });
	}
	
	

	public AbstractAction getAction() {
		return action;
	}

	public void seleciona() {
		setBackground(Constantes.COR_FUNDO_ITEM_MENU_SELECIONADO);
		ind.setOpaque(true);
	}
	
	public void rest() {
		setBackground(Constantes.COR_FUNDO_ITEM_MENU);
		ind.setOpaque(false);
	}

	public int getPosicao() {
		return posicao;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
		this.posicao = Constantes.ALTURA_ITEM_MENU * this.ordem;
	}
	
	
	
}