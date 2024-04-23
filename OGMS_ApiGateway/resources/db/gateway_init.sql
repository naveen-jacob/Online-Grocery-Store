DROP TABLE IF EXISTS USER_PASS;

CREATE TABLE USER_PASS
(
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

INSERT INTO USER_PASS (username, password) VALUES
                                               ('john.doe', 'john'),
                                               ('jane.doe', 'jane'),
                                               ('michael.smith', 'michael'),
                                               ('alice.johnson', 'alice'),
                                               ('david.williams', 'david'),
                                               ('sarah.brown', 'sarah'),
                                               ('richard.miller', 'richard'),
                                               ('jennifer.davis', 'jennifer'),
                                               ('william.jones', 'william'),
                                               ('elizabeth.Garcia', 'elizabeth');
