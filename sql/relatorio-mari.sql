select a.data_mes, b.total primeiro_login, a.total acesso  from 
(select count(1) total, date(data_atualizacao) data_mes from acesso_cliente where DATE_FORMAT(data_atualizacao, '%Y-%m-%d') = current_date() group by date(data_atualizacao)) a inner join
(select count(1) total, date(data_primeiro_login) data_mes from acesso_cliente where DATE_FORMAT(data_primeiro_login, '%Y-%m-%d') = current_date() group by date(data_primeiro_login)) b 
on a.data_mes = b.data_mes;