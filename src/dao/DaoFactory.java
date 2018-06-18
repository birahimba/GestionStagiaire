/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Birahim
 */
public class DaoFactory {
    
private Database db;
public DaoFactory(Database db)
    {
    this.db = db;
    }
public VilleDao getVilleDao() {
    return new VilleDao(db);
}
public StagiaireDao getStagiaireDao()
{
 return new StagiaireDao(db);
}
public GroupeDao getGroupeDao()
{
return new GroupeDao(db);
}

}
