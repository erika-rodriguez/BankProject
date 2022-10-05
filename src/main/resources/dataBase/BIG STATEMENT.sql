USE bank;

#big statement to join all tables
SELECT cus.full_name AS 'Client', 
acc.id_account AS 'Account number', 
accst.status AS 'Status',
br.city AS 'Branch',
acc.balance AS 'Balance', 
ln.amount AS 'Loan', 
tr.id_transaction AS 'Transaction number', 
trtype.transaction AS 'Transaction type'
FROM customer AS cus 

INNER JOIN account AS acc ON cus.id_customer = acc.customer_id
INNER JOIN account_status AS accst ON acc.account_status_id = accst.id_account_status
INNER JOIN branch AS br ON acc.branch_id = br.id_branch
INNER JOIN loan AS ln ON ln.customer_id = cus.id_customer
INNER JOIN transaction AS tr ON tr.account_id = acc.id_account
INNER JOIN transaction_type AS trtype ON trtype.id_transaction_type = tr.transaction_type_id
GROUP BY cus.id_customer;