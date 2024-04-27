package cse416.teamspurs.server;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;

import cse416.teamspurs.server.constant.State;
//import cse416.teamspurs.server.controller.PrecinctController;
import cse416.teamspurs.server.repository.RegressionLineRespository;
import cse416.teamspurs.server.model.RegressionLine;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class PrecinctControllerTest {
    @Autowired
    RegressionLineRespository repo;

    @Test
    void regressionLineNotNull()
    {
        RegressionLine line = repo.findByStateAndGroupAndParty(State.nj, Group.american_indian_alaska_native, Party.d);
        assertTrue(line != null);
    }

}
