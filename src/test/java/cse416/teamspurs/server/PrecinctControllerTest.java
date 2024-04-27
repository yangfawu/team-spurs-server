package cse416.teamspurs.server;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.RegressionLine;
import cse416.teamspurs.server.repository.RegressionLineRespository;

@SpringBootTest
public class PrecinctControllerTest {
    @Autowired
    RegressionLineRespository repo;

    @Test
    void regressionLineNotNull() {
        RegressionLine line = repo.findByStateAndGroupAndParty(State.nj, Group.american_indian_alaska_native, Party.d);
        assertTrue(line != null);
    }

}
