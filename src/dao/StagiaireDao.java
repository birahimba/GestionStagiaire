/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pojos.Stagiaire;
import pojos.Ville;



/**
 *
 * @author Birahim
 */
public class StagiaireDao extends Dao<Stagiaire>{

    public static final String TABLE_NAME = "stagiaire";
    
    StagiaireDao(Database db) {
        super(db, TABLE_NAME);
    }

    @Override
    public Stagiaire find(long id) {
        String requete = String.format("SELECT * FROM %s WHERE idGroupe = ? ", TABLE_NAME); //To change body of generated methods, choose Tools | Templates.
        return getItemOnQuery(requete, id);
    }

    @Override
    public List<Stagiaire> list() {
        String requete  = String.format("SELECT * FROM %s",TABLE_NAME);
        return getListOnQuery(requete);
    }

    @Override
    public Stagiaire insert(Stagiaire obj) {
      String requete = String.format("INSERT INTO %s (nom, prenom , idVille, idGroupe)" + "VALUES(?,?,?,?)", TABLE_NAME); //To change body of generated methods, choose Tools | Templates.
   obj.setIdStagiaire(insert(requete,obj.getNom(),obj.getPrenom(),obj.getIdVille(),obj.getIdGroupe()));
   return obj;
    }

    @Override
    public void update(Stagiaire obj) {
       
        String requete  = String.format("Update %s SET"+"nom = ?, prenom=?, idVille=?, idGroupe=?"+"WHERE idStagiaire = ?", TABLE_NAME);
      update(requete,obj.getNom(),obj.getPrenom(),obj.getIdVille(),obj.getIdGroupe(), obj.getIdStagiaire());
    }

    @Override
    public void delete(Stagiaire obj) {
      String requete = String.format("DELETE from %s WHERE idStagiaire= ? ", TABLE_NAME);
      delete(requete, obj.getIdStagiaire());
      
    }

    @Override
    public Stagiaire load(ResultSet resultSet) throws SQLException {
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setIdStagiaire(resultSet.getInt("idStagiaire"));
        stagiaire.setNom(resultSet.getString("nom"));
        stagiaire.setPrenom(resultSet.getString("prenom"));
        stagiaire.setIdVille(resultSet.getInt("idVille"));
        stagiaire.setIdGroupe(resultSet.getInt("idGroupe"));
        
        
        
       return stagiaire; 
    }
    
}
