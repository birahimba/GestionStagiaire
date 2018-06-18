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
import dao.GroupeDao;
import pojos.Groupe;

public class GroupeService {
    
    private DaoFactory daoFactory;
    
public GroupeService(DaoFactory daoFactory) {
this.daoFactory = daoFactory;
}
public Groupe createGroupe(Groupe groupe) {
GroupeDao groupeDao = daoFactory.getGroupeDao();
return groupeDao.insert(groupe);
}
public Groupe getGroupeById(int id) {
GroupeDao groupeDao = daoFactory.getGroupeDao();
return groupeDao.find(id);
}
public void updateGroupe(Groupe groupe) {
GroupeDao groupeDao = daoFactory.getGroupeDao();
groupeDao.update(groupe);
}
public void deleteVille(Groupe groupe) {
GroupeDao groupeDao = daoFactory.getGroupeDao();
groupeDao.delete(groupe);
}
public List<Groupe> getAll() {
GroupeDao groupeDao = daoFactory.getGroupeDao();
return groupeDao.list();
}
    
}
