package br.com.fiap.soat7.grupo18.lanchonete.core.usecase;

import java.util.Optional;

import br.com.fiap.soat7.grupo18.lanchonete.adapter.gateway.ClienteGateway;
import br.com.fiap.soat7.grupo18.lanchonete.config.AmazonCognitoConfig;
import br.com.fiap.soat7.grupo18.lanchonete.core.entity.Cliente;
import br.com.fiap.soat7.grupo18.lanchonete.external.handler.dto.ClienteHandlerRequestDto;
import br.com.fiap.soat7.grupo18.lanchonete.external.infra.exception.DomainUseCaseException;

public class ClienteUseCase {

    private final ClienteGateway clienteGateway;

    private AmazonCognitoConfig cognitoConfig;

    public ClienteUseCase(ClienteGateway clienteGateway, AmazonCognitoConfig cognitoConfig) {
        this.clienteGateway = clienteGateway;
        this.cognitoConfig = cognitoConfig;
    }

    public Cliente findByCpfCliente(String cpf){
        return cpf == null || cpf.isBlank() ? null : clienteGateway.findByCpfCliente(cpf);
    }

    public Cliente save(ClienteHandlerRequestDto clienteDto){
        final String cpf = Optional.ofNullable(clienteDto).map(ClienteHandlerRequestDto::getCpf).orElse("");
        final String nome = Optional.ofNullable(clienteDto).map(ClienteHandlerRequestDto::getNome).orElse("");
        final String email = Optional.ofNullable(clienteDto).map(ClienteHandlerRequestDto::getEmail).orElse("");
        final String senha = Optional.ofNullable(clienteDto).map(ClienteHandlerRequestDto::getSenha).orElse("");
        Cliente cliente = new Cliente(cpf, nome, email, senha);
        if (findByCpfCliente(cpf) != null){
            throw new DomainUseCaseException("CPF já cadastrado");
        }
        var savedClient = clienteGateway.save(cliente);
        cognitoConfig.createUser(cliente);

        return savedClient;
    }

}
