/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Birahim
 */

import java.util.List;
import dao.DaoFactory;
import dao.StagiaireDao;
import pojos.Stagiaire;
public class StagiaireService {
    
    private DaoFactory daoFactory;
    
    public StagiaireService(DaoFactory daoFactory)
    {
     this.daoFactory = daoFactory;
    }
    
    public Stagiaire createStagiaire(Stagiaire stagiaire)
    {
      StagiaireDao stagiaireDao = daoFactory.getStagiaireDao();
      return stagiaireDao.insert(stagiaire);
    }
    
    public Stagiaire getStagiaireById(long id)
    {
        StagiaireDao stagiaireDao = daoFactory.getStagiaireDao();
        return stagiaireDao.find(id);
    }
    public void deleteStagiaire(Stagiaire stagiaire) {
StagiaireDao stagiaireDao = daoFactory.getStagiaireDao();
stagiaireDao.delete(stagiaire);
}
public List<Stagiaire> getAll() {
StagiaireDao stagiaireDao = daoFactory.getStagiaireDao();
return stagiaireDao.list();
}
    
    
    
    
}
