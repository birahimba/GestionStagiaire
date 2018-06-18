/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;  
import java.sql.*;

public class Database {
private String url;
private String userName;
private String password;

/**
 *
 * @author Birahim
 */

   
public Database( String url, String userName, String password ) 
        
    {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
/* Ouverture de la connexion */

Connection getConnection() throws SQLException {
   
    return DriverManager.getConnection( url, userName, password );
    
}
/* Fermeture de la connexion */
public void closeConnection( Connection connexion ) {
      if ( connexion != null ) {
           try {
                connexion.close();
                } catch ( SQLException e ) {
                    System.out.println( "Échec de la fermeture de la connexion: " + e.getMessage() );
}
}
}

/*
* Initialise la requête préparée basée sur la connexion passée en
argument,
* avec la requête SQL et les objets donnés.
*/
public PreparedStatement initialisationRequetePreparee(Connection
connexion, String requete, boolean returnGeneratedKeys, Object... objets )
throws SQLException {
PreparedStatement preparedStatement = connexion.prepareStatement(
requete, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS :
Statement.NO_GENERATED_KEYS );
for ( int i = 0; i < objets.length; i++ ) {
preparedStatement.setObject( i + 1, objets[i] );
}
return preparedStatement;
}
/* Fermeture du statement */
public void closeStatement( Statement statement ) {
    if ( statement != null ) {
       try {

        statement.close();
            } 
       catch ( SQLException e ) {
System.out.println( "Échec de la fermeture du Statement : "+ e.getMessage() );
}
}
}
/* Fermeture du resultset */
public void closeResultSet( ResultSet resultSet ) {
if ( resultSet != null ) {
try {
resultSet.close();
} catch ( SQLException e ) {
System.out.println( "Échec de la fermeture du ResultSet : "+ e.getMessage() );
}
}
}
public void close(Statement statement, Connection connexion)
{
closeStatement(statement);
closeConnection(connexion);
}
public void close(ResultSet resultSet, Statement statement, Connection
connexion)
{
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connexion);
        
}
}



    

