-- Scenario 1

BEGIN
    UPDATE customers
    SET LoanInterestRate = LoanInterestRate * 0.99
    WHERE age>60

    COMMIT;
END;


-- Scenario 2

BEGIN 
    UPDATE customers    
    SET IsVip = "True"
    WHERE balance > 10000

    COMMIT;
END;


-- Scenario 3

BEGIN 
    FOR record IN(
        SELECT c.CustomerId, c.CustomerName, l.LoanId, l.DueDate
        FROM customers c JOIN loans l on c.CustomerId = l.LoanId
        where l.DueDate BETWEEN SYSDate and SYSDATE + 30
    ) LOOP

        DBMS_OUTPUT.PUT_LIN('Reminder: Customer ' || record.CustomerName || 'ID: ' || record.CustomerId || 
                            'has a loan Id:' || record.LoanId || 'Due on: ' || TO_CHAR(record.DueDate,'DD-MM-YYYY'));
    END LOOP;
END;