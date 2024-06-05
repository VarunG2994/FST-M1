package pactproject;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class PactTest {


    @BeforeEach
    public void setUp(PactVerificationContext context) {
        // Set target for provider to send request to
        context.setTarget(new HttpTestTarget("localhost", 8585));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void provderTest(PactVerificationContext context) {
           context.verifyInteraction();
    }


    // State to send the call to consumer
    @State("Post Request")
    public void state1() {

    }





}
