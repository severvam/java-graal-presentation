package com.fourfinanceit.db.migration;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;

public class MigrationApp {

	public static void main(String[] args) {
		new MigrationApp().updateDb();
	}

	public void updateDb() {
		final var quarkusDatabase = new DatabaseConfig("127.0.0.1", "3306", "quarkus", "quarkus", "secret");
		final var connection = quarkusDatabase.db().getConnection();
		final var dataGenerator = new DataGenerator();
		try {
			final var database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
			final var liquibase = new liquibase.Liquibase("migration/main.yaml", new ClassLoaderResourceAccessor(), database);
			liquibase.update(new Contexts("dev"), new LabelExpression());
			dataGenerator.generate().forEach(row -> quarkusDatabase.db().insert(row));
		} catch (LiquibaseException e) {
			e.printStackTrace();
		}
	}
}
