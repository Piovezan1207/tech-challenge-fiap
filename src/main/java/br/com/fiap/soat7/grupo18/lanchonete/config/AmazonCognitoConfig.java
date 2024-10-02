package br.com.fiap.soat7.grupo18.lanchonete.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AttributeType;
import com.amazonaws.services.cognitoidp.model.SignUpRequest;
import com.amazonaws.services.cognitoidp.model.SignUpResult;

import br.com.fiap.soat7.grupo18.lanchonete.core.entity.Cliente;

@Configuration
public class AmazonCognitoConfig {


    @Value("${COGNITO_USER_POOL_ID}")
    private String userPoolID;

    @Value("${COGNITO_CLIENT_ID}")
    private String clientID;

    
    public String getUserPoolID() {
        return userPoolID;
    }

    public String getClientID() {
        return clientID;
    }

    public String createUser(Cliente cliente) {
        AWSCognitoIdentityProvider cognitoClient = AWSCognitoIdentityProviderClientBuilder
                                                        .standard()
                                                        .withRegion(Regions.US_EAST_1)
                                                        .build();
        SignUpRequest signUpRequest = new SignUpRequest()
                .withClientId(clientID)
                .withUsername(cliente.getCpf())
                .withPassword(cliente.getSenha())
                .withUserAttributes(
                    List.of(new AttributeType().withName("custom:CPF").withValue(cliente.getCpf()),
                    new AttributeType().withName("email").withValue(cliente.getEmail()),
                    new AttributeType().withName("name").withValue(cliente.getNome())
                    )
                );

        SignUpResult signUpResult = cognitoClient.signUp(signUpRequest);
        return signUpResult.getUserSub();
    }

    
}
