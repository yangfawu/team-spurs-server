package cse416.teamspurs.server.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "district-demographic")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class District extends BaseDistrict {
    @Id
    private ObjectId Id;

    @Field("district")
    private Integer districtId;

    @Field("total_population")
    private Integer total;

    @Field("hispanic_latino")
    private Integer hl;

    private Integer white;

    private Integer black;

    @Field("american_indian_alaska_native")
    private Integer aian;

    private Integer asian;

    @Field("hawaiian_pacific_islander")
    private Integer hpi;

    private Integer other;

    private Integer mixed;

    private String state;

}
