-- Package Specification

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_accountId IN NUMBER, p_customerId IN NUMBER, p_initialBalance IN NUMBER);

    PROCEDURE CloseAccount(p_accountId IN NUMBER);

    FUNCTION GetTotalBalance(p_customerId IN NUMBER) RETURN NUMBER;
END AccountOperations;


-- Package Body

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_accountId IN NUMBER, p_customerId IN NUMBER, p_initialBalance IN NUMBER) IS
    BEGIN
        INSERT INTO Accounts (accountId, customerId, balance)
        VALUES (p_accountId, p_customerId, p_initialBalance);
    END OpenAccount;

    PROCEDURE CloseAccount(p_accountId IN NUMBER) IS
    BEGIN
        DELETE FROM Accounts
        WHERE accountId = p_accountId;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_customerId IN NUMBER) RETURN NUMBER IS
        v_totalBalance NUMBER;
    BEGIN
        SELECT NVL(SUM(balance), 0) INTO v_totalBalance
        FROM Accounts
        WHERE customerId = p_customerId;
        
        RETURN v_totalBalance;
    END GetTotalBalance;

END AccountOperations;


