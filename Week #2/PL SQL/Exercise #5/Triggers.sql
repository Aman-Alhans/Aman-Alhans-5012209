-- Scenario 1

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;

-- Scenario 2

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (transactionId, transactionDate, action)
    VALUES (:NEW.transactionId, SYSDATE, 'INSERT');
END;

-- Scenario 3

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.transactionType = 'WITHDRAWAL' THEN
        IF :NEW.amount > (SELECT balance FROM accounts WHERE accountId = :NEW.accountId) THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
        END IF;
    
    ELSIF :NEW.transactionType = 'DEPOSIT' THEN
        IF :NEW.amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;