-- Scenario 1

DECLARE
    CURSOR c_transactions IS
        SELECT accountId, transactionDate, transactionType, amount
        FROM Transactions
        WHERE TO_CHAR(transactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY');

    v_accountId Transactions.account_id%TYPE;
    v_transactionDate Transactions.transaction_date%TYPE;
    v_transactionType Transactions.transaction_type%TYPE;
    v_amount Transactions.amount%TYPE;
BEGIN
    OPEN c_transactions;

    LOOP
        FETCH c_transactions INTO v_accountId, v_transactionDate, v_transactionType, v_amount;
        EXIT WHEN c_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_accountId);
        DBMS_OUTPUT.PUT_LINE('Date: ' || v_transactionDate);
        DBMS_OUTPUT.PUT_LINE('Type: ' || v_transactionType);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('-----------------------------');
    END LOOP;

    CLOSE c_transactions;
END;


--Scenario 2

DECLARE
    CURSOR c_accounts IS
        SELECT accountId
        FROM Accounts;

    v_accountId Accounts.accountId%TYPE;
    v_fee NUMBER := 50; 
BEGIN
    OPEN c_accounts;

    LOOP
        FETCH c_accounts INTO v_accountId;
        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts
        SET balance = balance - v_fee
        WHERE account_id = v_accountId;

        DBMS_OUTPUT.PUT_LINE('Fee applied to Account ID: ' || v_accountId);
    END LOOP;

    CLOSE c_accounts;
END;

--Scenario 3

DECLARE
    CURSOR c_loans IS
        SELECT loanId
        FROM Loans;

    v_loanId Loans.loan_id%TYPE;
    v_newRate NUMBER := 5; 

BEGIN
    OPEN c_loans;

    LOOP
        FETCH c_loans INTO v_loanId;
        EXIT WHEN c_loans%NOTFOUND;

        UPDATE Loans
        SET interestRate = v_newRate
        WHERE loanId = v_loanId;

        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_loanId || ' to Interest Rate: ' || v_newRate);
    END LOOP;

    CLOSE c_loans;
END;
