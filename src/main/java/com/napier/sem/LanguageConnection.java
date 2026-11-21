package com.napier.sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Represents db connection for language reports

public class LanguageConnection {
    private final Connection con;

    public LanguageConnection(Connection con){
        this.con = con;
    }

    public List<Language> runLanguageQuery(String sql, Object... params){

        // New list of languages
        List<Language> languages = new ArrayList<>();

        // Prepare SQL Statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // If the statement has params, add the params to SQL
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            // Execute SQL Statement
            try(ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    languages.add(new Language(
                            rset.getString("AreaName"),
                            rset.getLong("TotalSpeakers"),
                            rset.getDouble("WorldPercentage")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return languages;
    }
}
