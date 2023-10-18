# Ultracar
Processo seletivo API REST
## Endpoints
### Login
GET
<br>http://localhost:8080/login
<br>{
<br>&nbsp;    "login":"ultracar@ultracar.com",
<br>&nbsp;    "senha":"ultracar"
<br>}
<br>
<br>
Endpoint para a realização do login. É público.
### cadastro de ordem de serviço
POST
<br>http://localhost:8080/servicos
<br>{
<br>&nbsp;	"carro_id":40,
<br>&nbsp;	"cliente_id":"60",
<br>&nbsp;	"servicos":"Pobrema",
<br>&nbsp;	"observacoes":"Resolvido"
<br>}
<br>
<br>
Endpoint para a realização do cadastro de Ordens de Serviço: requer autenticação JWT
<br><b>É necessário que exista um cliente e um carro</b>
###cadastro de cliente
POST
<br>http://localhost:8080/clientes
<br>{
	<br>&nbsp;"nome":"Gratak Norville",
	<br>&nbsp;"identidade":"481",
	<br>&nbsp;"endereco":"Rua das lindezas"
<br>}

###cadastro de carro

POST
<br>http://localhost:8080/carros
