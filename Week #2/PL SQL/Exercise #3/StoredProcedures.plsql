-- Scenario 1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE savingsAccounts
    SET balance = balance * 1.01;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;

-- Scenario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_departmentId IN NUMBER,
    p_bonusPercentage IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary * (10 + p_bonusPercentage / 100)
    WHERE departmentId = p_departmentId;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to employees in department ID: ' || p_departmentId);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateEmployeeBonus;

-- Scenario 3

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_fromAccountId IN NUMBER,
    p_toAccountId IN NUMBER,
    p_amount IN NUMBER
) AS
    v_fromBalance NUMBER;
BEGIN
    SELECT balance INTO v_fromBalance
    FROM accounts
    WHERE accountId = p_fromAccountId;

    IF v_fromBalance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    UPDATE accounts
    SET balance = CASE
        WHEN accountId = p_fromAccountId THEN balance - p_amount
        WHEN accountId = p_toAccountId THEN balance + p_amount
    END
    WHERE accountId IN (p_fromAccountId, p_toAccountId);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from account ' || p_fromAccountId || ' to account ' || p_toAccountId);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
