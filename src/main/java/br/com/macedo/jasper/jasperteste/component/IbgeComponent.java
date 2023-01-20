package br.com.macedo.jasper.jasperteste.component;

import br.com.macedo.jasper.jasperteste.dto.State;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class IbgeComponent {


    private RestTemplate restTemplate;


    public List<State> getIBGEStates() {

        try {

            var url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

            var request = new HttpEntity<>(httpHeaders);

            var response = restTemplate.exchange(url, HttpMethod.GET, request, State[].class).getBody();

            return Arrays.asList(response);

        } catch (RestClientException e) {
            throw new RuntimeException("Fail to consult IBGE");
        }

    }

}
