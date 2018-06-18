/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojos.Groupe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Birahim
 */
public class GroupeDao extends Dao<Groupe> {

    public static final String TABLE_NAME = "groupe";
      GroupeDao(Database db) {
        super(db, TABLE_NAME);
    }

  

    @Override
    public Groupe find(long id) {
      
        String requete = String.format("select * from %s where idGroupe = ? ", TABLE_NAME);
        return getItemOnQuery(requete, id);
        
    }

    @Override
    public List<Groupe> list() {
         String requete  = String.format("select * from %s", TABLE_NAME);
         return getListOnQuery(requete);
    }

    @Override
    public Groupe insert(Groupe obj) {
      
        String requete  = String.format("insert into %s (nom, dateDebut, dateDebutStage,dateFin )"+"values(?,?,?,?)", TABLE_NAME);
        obj.setIdGroupe(insert(requete,obj.getNom(),obj.getDateDebut(),obj.getDateDebutStage(),obj.getDateFin()));
        return obj;
    }

    @Override
    public void update(Groupe obj) {
       String requete  = String.format("update %s set"+"nom=?, dateDebut=?, dateDebutStage=?, dateFin=?"+"where idGroupe=?", TABLE_NAME);
       update(requete, obj.getDateDebut(),obj.getDateDebutStage(),obj.getDateFin());
       
    }

    @Override
    public void delete(Groupe obj) {
       String requete = String.format("delete from %s where idGroupe = ?", TABLE_NAME);
       delete(requete,obj.getIdGroupe());
    }

    @Override
    public Groupe load(ResultSet resultSet) throws SQLException {
       Groupe groupe = new Groupe();
       groupe.setIdGroupe(resultSet.getInt("idGroupe"));
      groupe.setNom(resultSet.getString("nom"));
       groupe.setDateDebut(resultSet.getDate("dateDebut"));
       groupe.setDateDebutStage(resultSet.getDate("dateDebutStage"));
       groupe.setDateFin(resultSet.getDate("dateFin") );
       return groupe;
       
    }
    
}
