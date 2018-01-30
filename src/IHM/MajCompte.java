/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import DAO.CompteDAO;
import Extension.IconesPerso;
import Extension.LienHypertexte;
import Metier.Compte;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utilisateur
 */
public class MajCompte extends javax.swing.JFrame
{
	//------------------------- ATTRIBUTS -------------------------//
	private int idCompte;
	private int idPersonne;
	
	private final String iconeAdresseQuitter = "../icones/iconeQuitter.png";
	private final String iconeAdresseRetour = "../icones/iconeRetour.png";
	private final String iconeAdresseValider = "../icones/iconeValider.png";
	//------------------------- ATTRIBUTS -------------------------//
	public MajCompte()
	{
		initComponents();		
		
		//------------------------- POSITIONNEMENT FENETRE -------------------------//
			// GESTION AUTO DU POSITIONNEMENT EN CENTRE VERTICAL / HORIZONTAL
		this.setLocationRelativeTo(this);
		//------------------------- POSITIONNEMENT FENETRE -------------------------//
	}

	public MajCompte(int idCompte, int idPersonne)
	{
		initComponents();
		
		//------------------------- DEFINITION ICONE DE BOUTON -------------------------//
		IconesPerso boutonValider = new IconesPerso();
		boutonValider.iconeBouton(valider, iconeAdresseValider);
		IconesPerso boutonRetour = new IconesPerso();
		boutonRetour.iconeBouton(retour, iconeAdresseRetour);
		IconesPerso boutonQuitter = new IconesPerso();
		boutonQuitter.iconeBouton(quitter, iconeAdresseQuitter);
		//------------------------- DEFINITION ICONE DE BOUTON -------------------------//
		
		//------------------------- POSITIONNEMENT FENETRE -------------------------//
			// GESTION AUTO DU POSITIONNEMENT EN CENTRE VERTICAL / HORIZONTAL
		this.setLocationRelativeTo(this);
		//------------------------- POSITIONNEMENT FENETRE -------------------------//
		
		//------------------------- DEFINITION ICONE DE BOUTON -------------------------//
		this.idCompte = idCompte;
		this.idPersonne = idPersonne;
		//------------------------- DEFINITION ICONE DE BOUTON -------------------------//
		
		//------------------------- CHARGEMENT UTILISATEUR/ REMPLISSAGE DES LABELS -------------------------//
		CompteDAO compteDao = new CompteDAO();
		Compte compte;
		try
		{
			compte = compteDao.chargerCompte(this.idCompte);
			saisieNomSite.setText(compte.getNom());
			saisieLogin.setText(compte.getLogin());
			saisieMdp.setText(compte.getMdp());
			saisieAdresse.setText(compte.getAdresse());
		}
		catch (SQLException ex)
		{
			Logger.getLogger(MajCompte.class.getName()).log(Level.SEVERE, null, ex);
		}
		//------------------------- CHARGEMENT UTILISATEUR/ REMPLISSAGE DES LABELS -------------------------//
		//------------------------- CHARGEMENT UTILISATEUR/ REMPLISSAGE DES LABELS -------------------------//
		//------------------------- CHARGEMENT UTILISATEUR/ REMPLISSAGE DES LABELS -------------------------//
		//------------------------- CHARGEMENT UTILISATEUR/ REMPLISSAGE DES LABELS -------------------------//
	}
	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JLabel();
        labelNomSite = new javax.swing.JLabel();
        saisieNomSite = new javax.swing.JTextField();
        labelLogin = new javax.swing.JLabel();
        saisieLogin = new javax.swing.JTextField();
        labelMdp = new javax.swing.JLabel();
        saisieMdp = new javax.swing.JTextField();
        retour = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        lien = new javax.swing.JLabel();
        saisieAdresse = new javax.swing.JTextField();
        labelAdresse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyPass - Gestionnaire de mot de passe");
        setMinimumSize(new java.awt.Dimension(400, 500));

        titre.setFont(new java.awt.Font("Source Sans Pro", 1, 36)); // NOI18N
        titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre.setText("Modifier un compte");

        labelNomSite.setText("Nom du site :");

        labelLogin.setText("Login :");

        labelMdp.setText("Mdp :");

        retour.setText("Retour");
        retour.setMaximumSize(new java.awt.Dimension(150, 50));
        retour.setMinimumSize(new java.awt.Dimension(150, 50));
        retour.setPreferredSize(new java.awt.Dimension(150, 50));
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        valider.setText("Valider");
        valider.setMaximumSize(new java.awt.Dimension(150, 50));
        valider.setMinimumSize(new java.awt.Dimension(150, 50));
        valider.setPreferredSize(new java.awt.Dimension(150, 50));
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        quitter.setText("Quitter");
        quitter.setMaximumSize(new java.awt.Dimension(150, 50));
        quitter.setMinimumSize(new java.awt.Dimension(150, 50));
        quitter.setPreferredSize(new java.awt.Dimension(150, 50));
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        lien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lien.setText("Programmé par STRYJEWSKI NICOLAS");
        lien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lienMouseExited(evt);
            }
        });

        labelAdresse.setText("Adresse du site");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelMdp)
                                        .addComponent(labelNomSite)
                                        .addComponent(labelLogin)
                                        .addComponent(saisieLogin)
                                        .addComponent(saisieNomSite)
                                        .addComponent(saisieMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelAdresse)
                                    .addComponent(saisieAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(titre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titre)
                .addGap(18, 18, 18)
                .addComponent(labelNomSite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saisieNomSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saisieLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMdp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saisieMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelAdresse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saisieAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(lien))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	//------------------------- GESTION EVENEMENTS -------------------------//
    private void retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
        ListeCompte retour = new ListeCompte(idPersonne);
		retour.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_retourActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        CompteDAO compteDao = new CompteDAO();
		Compte compte = new Compte();
		
		try
		{
			compte = compteDao.chargerCompte(idCompte);
		}
		catch (SQLException ex)
		{
			Logger.getLogger(MajCompte.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			//------------------------- RECUPERATION / MAJ DONNEES SAISIES -------------------------//
			compte.setNom(saisieNomSite.getText());
			compte.setLogin(saisieLogin.getText());
			compte.setMdp(saisieMdp.getText());
			compte.setAdresse(saisieAdresse.getText());
			compteDao.majCompte(compte);
			//------------------------- RECUPERATION / MAJ DONNEES SAISIES -------------------------//
			
			//------------------------- RE-INITIALISATION LABELS -------------------------//
			saisieNomSite.setText("");
			saisieLogin.setText("");
			saisieMdp.setText("");
			saisieAdresse.setText("");
			//------------------------- RE-INITIALISATION LABELS -------------------------//
		}
		catch (SQLException ex)
		{
			Logger.getLogger(MajCompte.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_validerActionPerformed

    private void lienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienMouseClicked
        //Ouverture du navigateur par defaut du systeme + ouverture page definie
		String adresse = "https://www.linkedin.com/in/stryjewskinicolas/";
		LienHypertexte lienlabel = new LienHypertexte();
		lienlabel.ouvertureLien(adresse);
    }//GEN-LAST:event_lienMouseClicked

    private void lienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienMouseEntered
        //Fonction pour survol de souris
		LienHypertexte lienlabel = new LienHypertexte();
		lien.setEnabled(true);
		lienlabel.souligner(true, lien);
    }//GEN-LAST:event_lienMouseEntered

    private void lienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienMouseExited
        //Fonction lors de l'arret du survol
		LienHypertexte lienlabel = new LienHypertexte();
		lienlabel.souligner(false, lien);
    }//GEN-LAST:event_lienMouseExited
	//------------------------- GESTION EVENEMENTS -------------------------//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAdresse;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelMdp;
    private javax.swing.JLabel labelNomSite;
    private javax.swing.JLabel lien;
    private javax.swing.JButton quitter;
    private javax.swing.JButton retour;
    private javax.swing.JTextField saisieAdresse;
    private javax.swing.JTextField saisieLogin;
    private javax.swing.JTextField saisieMdp;
    private javax.swing.JTextField saisieNomSite;
    private javax.swing.JLabel titre;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}