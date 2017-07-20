package jdbc3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	
	void batch(Connection connection, String sql, Object [] ... args) throws SQLException;

	<E> E getForValue(Connection connection, String sql, Object ... args) throws SQLException;

	List<T> getForList(Connection connection, String sql, Object ... args) throws SQLException;

	T get(Connection connection, String sql, Object ... args) throws SQLException;

	void update(Connection connection, String sql, Object ... args) throws SQLException;
}