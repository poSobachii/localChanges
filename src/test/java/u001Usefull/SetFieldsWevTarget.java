package u001Usefull;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.util.ReflectionTestUtils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SetFieldsWevTarget {

//    @BeforeEach
//    void setup() {
//        initMocks(this);
//        ReflectionTestUtils.setField(mockObject, "field", "new value");
//        ReflectionTestUtils.setField(mockObject, "tokenExchangeEndpoint", tokenExchangeEndpoint);
//        when(asyncClient.getTarget(authorizationUrl)).thenReturn(webTarget);
//        when(webTarget.path(tokenExchangeEndpoint)).thenReturn(webTarget);
//        when(webTarget.request(MediaType.APPLICATION_FORM_URLENCODED)).thenReturn(invocationBuilder);
//        when(invocationBuilder.accept(MediaType.APPLICATION_JSON)).thenReturn(invocationBuilder);
//        when(invocationBuilder.post(any(Entity.class))).thenReturn(response);
//        when(response.getStatus()).thenReturn(HttpStatus.SC_OK);
//        when(response.readEntity(NordeaIDTokenResolver.class)).thenReturn(tokenResolver);
//        when(tokenResolver.getIdToken()).thenReturn("imaginaryToken");
//
//    }
}
