package com.vladbel.usermanagment.db;

import java.sql.Connection;

public interface ConnectionFactory {
Connection createConnection() throws DatabaseException;
}
