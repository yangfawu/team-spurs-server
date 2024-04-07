package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "district-demographic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDemographic {
    @Id
    private String id;

    private Map<Group, Integer> count;
    private Integer district;
    private State state;
}
