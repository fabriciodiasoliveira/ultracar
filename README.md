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
<br>Todos os outros endpoints exigem o login. O token retornado precisa estar no cabeçalho Autorization indicados como Bearer.
Endpoint para a realização do login. É público.
### cadastro de ordem de serviço
POST
<br>http://localhost:8080/servicos
<br>{
		<br>&nbsp;"carro_id": "653147cd1240b67230276e4b",
		<br>&nbsp;"funcionario": "Nostradamus",
		<br>&nbsp;"servicos": "Aconteceu um problema",
		<br>&nbsp;"observacoes": "Voltou",
		<br>&nbsp;"valor": "0",
		<br>&nbsp;"data": "2023-10-18T15:10:24.603598227",
		<br>&nbsp;"ativo": true
<br>}
<br>
<br>
Endpoint para a realização do cadastro de Ordens de Serviço
<br><b>Validador:</b> É necessário que exista um cliente e um carro ativos

### cadastro de cliente
POST
<br>http://localhost:8080/clientes
<br>{
	<br>&nbsp;"nome": "Darwin Evoluilton",
	<br>&nbsp;"identidade":"589",
	<br>&nbsp;"email":"oi@oi.com",
	<br>&nbsp;"telefone":"12534",
	<br>&nbsp;"endereco":"Rua do gato persa"
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
<br>É obrigatório o id do cliente, mas os outros campos não.
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
### listar clientes
GET
<br>Endpoint para obter uma lista de clientes;
### alterar cliente
PUT
<br>http://localhost:8080/clientes
<br>{
	<br>&nbsp;"id": "65312cc9fbf5b1702cf3d1ad",
	<br>&nbsp;"nome": "Darwin Evoluilton",
	<br>&nbsp;"identidade":"677",
	<br>&nbsp;"email":"oi@oi.com",
	<br>&nbsp;"telefone":"4582",
	<br>&nbsp;"endereco":"Rua do sapato"
<br>}
<br>Endpoint para alterar um cliente. O id é obrigatório.
### deletar cliente
DELETE
<br>http://localhost:8080/clientes/{id}
<br>Endpoint para a deleção de um cliente.
### listar um cliente
GET
<br>http://localhost:8080/clientes/{id}
<br>Endpoint para exibir um cliente expecífico
### listar os carros de um cliente
GET
<br>http://localhost:8080/carros/cliente/{id}
<br>Endpoint para listar os carros de um cliente.
### alterar uma ordem de serviços
PUT
<br>http://localhost:8080/servicos
<br>{
	<br>&nbsp;"id": "65301f7b98fbde60817e8829",
	<br>&nbsp;"carro_id": "653014a5ed1e2e23e3795f7e",
	<br>&nbsp;"servicos": "chimarruts",
	<br>&nbsp;"observacoes": "Isto é incrível",
	<br>&nbsp;"valor": "10.000",
	<br>&nbsp;"data": "2023-10-18T15:10:03.003323521",
	<br>&nbsp;"funcionario": "Sô zé"
<br>}
<br>Endpoint para alterar uma ordem de serviço.
<br>O id é obrigatório, e os outros campos são opcionais.
### listar ordens de serviços
GET
<br>http://localhost:8080/servicos
<br>Endpoint para listar ordens de serviços - todas as do sistema.
### deletar uma ordem de serviço
DELETE
<br>http://localhost:8080/servicos/{id}
<br>Endpoint para deletar uma ordem de serviços.
### obter uma ordem de serviços
GET
<br>http://localhost:8080/servicos/
<br>Endpoint para mostrar uma ordem de serviços.
### listar ordens de serviço do carro
GET
<br>http://localhost:8080/servicos/carro/{id}
<br>Endpoint para obter as ordens de serviços associadas a um carro.