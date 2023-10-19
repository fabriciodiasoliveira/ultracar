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
<br>Todos os outros endpoints exigem o login. O token retornado precisa estar no cabeçalho Bearer.
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
Endpoint para a realização do cadastro de Ordens de Serviço
<br><b>Validador:</b> É necessário que exista um cliente e um carro ativos

### cadastro de cliente
POST
<br>http://localhost:8080/clientes
<br>{
	<br>&nbsp;"nome":"Gratak Norville",
	<br>&nbsp;"identidade":"481",
	<br>&nbsp;"endereco":"Rua das lindezas"
<br>}
<br>Cadastro de um novo cliente.

### cadastro de carro

POST
<br>http://localhost:8080/carros
<br>{
	<br>&nbsp;"placa":"MUU-123BOI",
	<br>&nbsp;"cor":"Azul",
	<br>&nbsp;"modelo":"Caminhotete Amarok",
	<br>&nbsp;"idCliente":"652e90f2a35ec97081881ebc"
<br>}
<br>Cadastro de um novo carro.
<br><b>Validador:</b> É necessário existir um cliente ativo.
### alterar carro
PUT
<br>{
	<br>&nbsp;"id": "652ec6c8e2940113af32228f",
	<br>&nbsp;"modelo": "Caminhotete D20",
	<br>&nbsp;"cor": "Azul",
	<br>&nbsp;"placa": "MUU-123BOI"
<br>}
<br>Endpoint para alteração de um carro. Não é possível mudar o id do cliente.
<br>Obrigatório o id do carro
### listar carros
GET
<br>http://localhost:8080/carros
<br>Endpoint para listar os carros.
### listar um carro
GET
<br>http://localhost:8080/carros/652ec6c8e2940113af32228f
<br>Endpoint para obter um único carro.
### deletar um carro
DELETE
<br>http://localhost:8080/carros/652ec54de2940113af322289
<br>Endpoint para eliminar um carro. Realiza exclusão de um carro.
### listar clientes
GET
<br>http://localhost:8080/clientes
<br>Endpoint para obter os clientes da oficina.
### alterar cliente
PUT
<br>http://localhost:8080/clientes
<br>PUT
<br>{
	<br>&nbsp;"id": "652e90f2a35ec97081881ebc",
	<br>&nbsp;"nome": "Darwin Evoluilton",
	<br>&nbsp;"identidade": "98526325",
	<br>&nbsp;"endereco": "Rua das ervilhas"
<br>}
<br>Endpoint para alterar o cliente
<br>É obrigatório o id do cliente
### listar carros com paginação
GET
<br>http://localhost:8080/carros/paginacao
<br>Lista carros com paginação - útil para obter a lista completa de carros na oficina
### listar carros
GET
<br>http://localhost:8080/carros
<br>Útil para obter a lista completa de carros na oficina - sem paginação
### listar um carro
GET
<br>http://localhost:8080/carros/{id}
<br>Obtendo um único carro na oficina
### deletar um carro
DELETE
<br>http://localhost:8080/carros/{id}
<br>Endpoint para a deleção de um carro
