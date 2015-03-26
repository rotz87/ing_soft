/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model.compitoInClasse;

import org.hibernate.usertype.UserType;
import org.hibernate.*;
import java.sql.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class CompitoInClasseStateUserType implements UserType {
private static final int[] SQL_TYPES = {Types.VARCHAR};
	
	public Class returnedClass() {
		return CompitoInClasseState.class;
	}
	
	public Object nullSafeGet(ResultSet aResultSet, String[] aStrings, org.hibernate.engine.spi.SessionImplementor aSessionImplementor, Object aObject) throws HibernateException, SQLException {
		String classSimpleName = aResultSet.getString(aStrings[0]);
		String packageName = CompitoInClasseState.class.getPackage().getName();
		Object ret;
		
		ret = null;
		if(!aResultSet.wasNull()){
			try {
				ret  = Class.forName(packageName+"."+classSimpleName).getDeclaredMethod("getInstance").invoke(null);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException | ClassNotFoundException e) {
				throw new HibernateException("Impossibile istanziare CompitoState");
			}
		}
		
        return ret;
	}
	
	public void nullSafeSet(PreparedStatement aPreparedStatement, Object aObject, int aint, org.hibernate.engine.spi.SessionImplementor aSessionImplementor) throws HibernateException, SQLException {
		if (aObject == null){
            aPreparedStatement.setNull(aint, Types.VARCHAR);
        }else{
            aPreparedStatement.setString(aint, aObject.getClass().getSimpleName());
        }
	}
	
	public boolean isMutable() {
		return false;
	}
	
	public Serializable disassemble(Object aObject) throws HibernateException {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Object assemble(Serializable aSerializable, Object aObject) throws HibernateException {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public int[] sqlTypes() {
		return CompitoInClasseStateUserType.SQL_TYPES;
	}
	
	public Object deepCopy(Object aObject) throws HibernateException {
		return aObject;
	}
	
	public boolean equals(Object aObject, Object aObject2) throws HibernateException {
		return aObject == aObject2;
	}
	
	public int hashCode(Object aObject) throws HibernateException {
		return aObject.hashCode();
	}
	
	public Object replace(Object aObject, Object aObject2, Object aObject3) throws HibernateException {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
}
//ORM Hash:647af8824dec89058ea44c98a942b458