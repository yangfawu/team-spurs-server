package cse416.teamspurs.server.Representatives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VirginaRepService {
    @Autowired
    private VirginaRepRepository virginaRepRepository;

    public List<VirginaReps> getAllVirginaReps()
    {
        System.out.println(virginaRepRepository.findAll().toString());
        return virginaRepRepository.findAll();
    }

}
